package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.model.application.dao.entity.AuditEntity;
import hk.judiciary.icms.model.dao.entity.BlfTaskRsltStatus;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.CaseClass;
import hk.judiciary.icms.model.dao.entity.CaseType;
import hk.judiciary.icms.model.dao.entity.CompsCourt;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icms.model.dao.entity.HandlingAgt;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsRslt;
import hk.judiciary.icms.model.dao.entity.ReqsStatusType;
import hk.judiciary.icms.model.dao.entity.ReqsType;
import hk.judiciary.icms.model.dao.entity.ServSubModeType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ComprisingCourtDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HandlingAgentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.CaseConstant;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.MaintainRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestServiceTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchDTO;

/**
 * 
 * @version $Revision: 7826 $ $Date: 2017-07-04 16:06:07 +0800 (週二, 04 七月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestDAO extends BaseDAO<Reqs> {
    public static final String REQUEST_DAO = "requestDAO";

    private static final String QUERY_BY_ID = "Reqs.findRequest";
    private static final String QUERY_RESERVICE_REQUEST_BY_ID = "Reqs.findReserviceRequest";

    private static final String PARAM_REQUEST_TYPE = "reqsType";
    private static final String PARAM_HANDLING_AGT = "handlingAgt";
    private static final String PARAM_REQS_STATUS = "reqsStatus";
    private static final String PARAM_SERV_REQS = "servReqs";
    private static final String PARAM_SERV_MODE = "servMode";
    private static final String PARAM_CASE = "vcase";
    private static final String PARAM_COMPS_COURT = "compsCourt";
    private static final String PARAM_COURTLVL_TYPE = "courtLvlType";
    private static final String PARAM_CASE_TYPE = "caseType";
    private static final String PARAM_CASE_CLASS = "caseClass";
    private static final String PARAM_REQS_RSLT = "reqsRslt";
    private static final String PARAM_RSLT_STATUS = "rsltStatus";
    private static final String PARAM_AUDITENTITY = "auditEntity";

    private static final String PARAM_REQUEST_ID = "reqsId";
    private static final String PARAM_REQUEST_TYPE_ID = "reqsTypeId";
    private static final String PARAM_SUBMIT_DATE = "submitDt";
    private static final String PARAM_HANDLINGAGT_ID = "handlingAgtId";
    private static final String PARAM_REQ_STATUS_ID = "reqsStatusTypeId";
    private static final String PARAM_SEQNO_FOR_CASE = "seqNoForCase";
    private static final String PARAM_SERV_MODE_TYPE_ID = "servModeTypeId";
    private static final String PARAM_COURTLVL_TYPE_CD = "courtLvlTypeCd";
    private static final String PARAM_COMPS_COURT_ID = "compsCourtId";
    private static final String PARAM_COMPS_COURT_CD = "compsCourtCd";
    private static final String PARAM_CASE_TYPE_ID = "caseTypeId";
    private static final String PARAM_CASE_TYPE_CD = "caseTypeCd";
    private static final String PARAM_CASE_SERNO = "caseSerNo";
    private static final String PARAM_SEQNO_FORCASE = "seqNoForCase";
    private static final String PARAM_CASE_YR = "caseYr";
    private static final String PARAM_CASE_CLASS_CD = "caseClassCd";
    private static final String PARAM_BLFTASKRSLT_STATUS = "blfTaskRsltStatusId";
    private static final String PARAM_LAST_UPDATEDT = "lastUpdateDt";
    private static final String PARAM_HANDLINGAGT_CD = "handlingAgtCd";
    private static final String PARAM_CASE_ID = "caseId";

    public Reqs findRequest(Integer reqsId) {
        info("findRequest() start ");
        TypedQuery<Reqs> query = getEntityManager().createNamedQuery(QUERY_BY_ID, Reqs.class);
        query.setParameter(PARAM_REQUEST_ID, reqsId);
        return getSingleResult(query);
    }

    public List<Reqs> findRequestListByServiceRequestSearch(ServiceRequestSearchDTO searchDTO) {
        info("findRequestListByServiceRequestSearch() start - and ServiceRequestSearchDTO:"
                + searchDTO);
        CriteriaBuilder builder = getEntityManager().getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Reqs> criteria = builder.createQuery(Reqs.class);
        Root<Reqs> reqsRoot = criteria.from(Reqs.class);
        criteria = criteria.select(reqsRoot);
        reqsRoot.fetch(PARAM_REQUEST_TYPE, JoinType.LEFT);
        reqsRoot.fetch(PARAM_SERV_REQS, JoinType.LEFT);
        reqsRoot.fetch(PARAM_REQS_STATUS, JoinType.LEFT);
        List<Predicate> andPredicates = new ArrayList<Predicate>();

        addRequestTypeCriteria(builder, reqsRoot, andPredicates,
                RequestConstant.REQUEST_TYPE_ID_SER);

        addSubmitCriteria(builder, reqsRoot, andPredicates, searchDTO.getSubmitStartDate(),
                searchDTO.getSubmitEndDate());

        addCaseNoCriteria(builder, reqsRoot, andPredicates, searchDTO.getCaseNo());

        addHandlingAgentCriteria(builder, reqsRoot, andPredicates, searchDTO.getHandlingAgent());

        addRequestStatusCriteria(builder, reqsRoot, andPredicates, searchDTO.getRequestStatusType());

        RequestServiceTypeDTO requestServiceType = searchDTO.getRequestServiceType();
        if (requestServiceType != null && requestServiceType.getRequestServiceType() != null
                && requestServiceType.getRequestServiceType() != 0) {

            Expression<Integer> seqNo = reqsRoot.get(PARAM_SEQNO_FOR_CASE);
            if (RequestConstant.REQUEST_SERVICE_TYPE_FRIST.equals(requestServiceType
                    .getRequestServiceType())) {
                andPredicates.add(builder.equal(seqNo, 1));
            } else if (RequestConstant.REQUEST_SERVICE_TYPE_RESERVICE.equals(requestServiceType
                    .getRequestServiceType())) {
                andPredicates.add(builder.greaterThan(seqNo, 1));
            }
        }

        ServiceModeTypeDTO serviceMode = searchDTO.getServiceModeType();
        if (serviceMode != null && serviceMode.getServiceModeTypeId() != null
                && serviceMode.getServiceModeTypeId() != 0) {
            Join<Reqs, ServSubModeType> modeJoin = reqsRoot.join(PARAM_SERV_REQS).join(
                    PARAM_SERV_MODE);
            andPredicates.add(builder.equal(modeJoin.get(PARAM_SERV_MODE_TYPE_ID),
                    serviceMode.getServiceModeTypeId()));
        }

        FunctionDTO function = searchDTO.getFunc();
        addComprisingCourtCriteria(builder, reqsRoot, andPredicates,
                searchDTO.getComprisingCourt(), function);

        addCaseTypeCriteria(builder, reqsRoot, andPredicates, searchDTO.getCaseType(), function);

        addCourtLevelCriteria(builder, reqsRoot, andPredicates, function);

        if (!CommonUtil.isNullOrEmpty(andPredicates)) {
            criteria.where(andPredicates.toArray(new Predicate[0]));
        }
        List<Order> orderBies = new ArrayList<Order>();
        orderBies.add(builder.asc(reqsRoot.get(PARAM_SUBMIT_DATE)));
        orderBies.add(builder.asc(reqsRoot.get(PARAM_REQUEST_ID)));
        criteria.orderBy(orderBies);
        criteria.distinct(true);
        TypedQuery<Reqs> query = getEntityManager().createQuery(criteria);
        List<Reqs> returnVal = getResultList(query);
        return returnVal;
    }

    public List<Reqs> findRequestListByPosRequestSearch(PosRequestSearchDTO searchDTO) {
        info("findRequestListByPosRequestSearch() start - and ServiceRequestSearchDTO:" + searchDTO);
        CriteriaBuilder builder = getEntityManager().getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Reqs> criteria = builder.createQuery(Reqs.class);
        Root<Reqs> reqsRoot = criteria.from(Reqs.class);
        criteria = criteria.select(reqsRoot);
        reqsRoot.fetch(PARAM_REQUEST_TYPE, JoinType.LEFT);
        reqsRoot.fetch(PARAM_SERV_REQS, JoinType.LEFT);
        reqsRoot.fetch(PARAM_REQS_STATUS, JoinType.LEFT);
        List<Predicate> andPredicates = new ArrayList<Predicate>();

        addRequestTypeCriteria(builder, reqsRoot, andPredicates,
                RequestConstant.REQUEST_TYPE_ID_POS);

        addSubmitCriteria(builder, reqsRoot, andPredicates, searchDTO.getSubmitStartDate(),
                searchDTO.getSubmitEndDate());

        addCaseNoCriteria(builder, reqsRoot, andPredicates, searchDTO.getCaseNo());

        addHandlingAgentCriteria(builder, reqsRoot, andPredicates, searchDTO.getHandlingAgent());

        FunctionDTO function = searchDTO.getFunc();
        addComprisingCourtCriteria(builder, reqsRoot, andPredicates,
                searchDTO.getComprisingCourt(), function);

        addCaseTypeCriteria(builder, reqsRoot, andPredicates, searchDTO.getCaseType(), function);

        addCourtLevelCriteria(builder, reqsRoot, andPredicates, function);

        if (!CommonUtil.isNullOrEmpty(andPredicates)) {
            criteria.where(andPredicates.toArray(new Predicate[0]));
        }
        List<Order> orderBies = new ArrayList<Order>();
        orderBies.add(builder.asc(reqsRoot.get(PARAM_SUBMIT_DATE)));
        orderBies.add(builder.asc(reqsRoot.get(PARAM_REQUEST_ID)));
        criteria.orderBy(orderBies);
        criteria.distinct(true);
        TypedQuery<Reqs> query = getEntityManager().createQuery(criteria);
        List<Reqs> returnVal = getResultList(query);
        return returnVal;
    }

    public Reqs findReserviceRequest(Integer caseId) {
        info("findReserviceRequest() start ");
        Reqs reqs = null;
        TypedQuery<Reqs> query = getEntityManager().createNamedQuery(QUERY_RESERVICE_REQUEST_BY_ID,
                Reqs.class);
        query.setParameter(PARAM_REQUEST_TYPE_ID, RequestConstant.REQUEST_TYPE_ID_SER);
        query.setParameter(PARAM_CASE_ID, caseId);
        query.setParameter(PARAM_SEQNO_FORCASE, 1);
        query.setMaxResults(1);
        List<Reqs> resultList = getResultList(query);
        if (!CommonUtil.isNullOrEmpty(resultList)) {
            reqs = resultList.get(0);
        }
        return reqs;
    }

    private void addRequestTypeCriteria(CriteriaBuilder builder, Root<Reqs> reqsRoot,
            List<Predicate> andPredicates, Integer requestType) {
        Join<Reqs, ReqsType> reqsTypeJoin = reqsRoot.join(PARAM_REQUEST_TYPE);
        andPredicates.add(builder.equal(reqsTypeJoin.get(PARAM_REQUEST_TYPE_ID), requestType));
    }

    private void addSubmitCriteria(CriteriaBuilder builder, Root<Reqs> reqsRoot,
            List<Predicate> andPredicates, Date startDate, Date endDate) {
        Expression<Date> submitDt = reqsRoot.get(PARAM_SUBMIT_DATE);
        if (startDate != null) {
            andPredicates.add(builder.greaterThanOrEqualTo(submitDt, startDate));
        }

        if (endDate != null) {
            andPredicates.add(builder.lessThanOrEqualTo(submitDt, endDate));
        }
    }

    private void addCaseNoCriteria(CriteriaBuilder builder, Root<Reqs> reqsRoot,
            List<Predicate> andPredicates, String caseNo) {
        Join<Reqs, Case> caseJoin = reqsRoot.join(PARAM_CASE);
        Join<Case, CaseType> caseTypeJoin = caseJoin.join(PARAM_CASE_TYPE);
        if (caseNo != null && !"".equals(caseNo)) {
            int codeCaseNumSeperator = caseNo.indexOf(" ");
            int caseNumYearSeperator = caseNo.indexOf("/");
            if (codeCaseNumSeperator != -1 && caseNumYearSeperator != -1) {
                String caseTypeStr = caseNo.substring(0, codeCaseNumSeperator);
                if (caseTypeStr.length() == 3 || caseTypeStr.length() == 4) {
                    // case comps court
                    String compsCourtCd = caseTypeStr.substring(0, 2);
                    // case type
                    String caseTypeCd = caseTypeStr.substring(2, caseTypeStr.length()).trim();
                    // case serial no
                    String caseSerNo = caseNo.substring(codeCaseNumSeperator + 1,
                            caseNumYearSeperator);
                    // case year
                    String caseYr = caseNo.substring(caseNumYearSeperator + 1, caseNo.length());

                    Join<Case, CompsCourt> compsCourtJoin = caseJoin.join(PARAM_COMPS_COURT);
                    andPredicates.add(builder.equal(compsCourtJoin.get(PARAM_COMPS_COURT_CD),
                            compsCourtCd));

                    andPredicates.add(builder.equal(caseTypeJoin.get(PARAM_CASE_TYPE_CD),
                            caseTypeCd));

                    andPredicates.add(builder.equal(caseJoin.get(PARAM_CASE_SERNO), caseSerNo));

                    andPredicates.add(builder.equal(caseJoin.get(PARAM_CASE_YR), caseYr));
                }
            }
        }
    }

    private void addHandlingAgentCriteria(CriteriaBuilder builder, Root<Reqs> reqsRoot,
            List<Predicate> andPredicates, HandlingAgentDTO handlingAgent) {
        if (handlingAgent != null && handlingAgent.getHandlingAgentId() != null
                && handlingAgent.getHandlingAgentId() != 0) {
            Join<Reqs, HandlingAgt> handlingAgtJoin = reqsRoot.join(PARAM_HANDLING_AGT);
            andPredicates.add(builder.equal(handlingAgtJoin.get(PARAM_HANDLINGAGT_ID),
                    handlingAgent.getHandlingAgentId()));
        }
    }

    private void addRequestStatusCriteria(CriteriaBuilder builder, Root<Reqs> reqsRoot,
            List<Predicate> andPredicates, List<RequestStatusTypeDTO> requestStatus) {
        Join<Reqs, ReqsStatusType> statusJoin = reqsRoot.join(PARAM_REQS_STATUS);
        Expression<Integer> statusId = statusJoin.get(PARAM_REQ_STATUS_ID);
        if (!CommonUtil.isNullOrEmpty(requestStatus)) {
            List<Integer> statusIds = new ArrayList<Integer>();
            for (RequestStatusTypeDTO status : requestStatus) {
                if (status.getRequestStatusTypeId() != null && status.getRequestStatusTypeId() != 0) {
                    statusIds.add(status.getRequestStatusTypeId());
                }
            }
            if (!CommonUtil.isNullOrEmpty(statusIds)) {
                andPredicates.add(statusId.in(statusIds));
            }
        } else {
            andPredicates.add(builder.equal(statusId, -1));
        }
    }

    private void addComprisingCourtCriteria(CriteriaBuilder builder, Root<Reqs> reqsRoot,
            List<Predicate> andPredicates, ComprisingCourtDTO comprisingCourt, FunctionDTO func) {
        Join<Reqs, Case> caseJoin = reqsRoot.join(PARAM_CASE);
        if (comprisingCourt != null && comprisingCourt.getComprisingCourtId() != null
                && comprisingCourt.getComprisingCourtId() != 0) {
            Join<Case, CompsCourt> compsCourtJoin = caseJoin.join(PARAM_COMPS_COURT);
            andPredicates.add(builder.equal(compsCourtJoin.get(PARAM_COMPS_COURT_ID),
                    comprisingCourt.getComprisingCourtId()));
        } else {
            caseJoin = reqsRoot.join(PARAM_CASE);
            Join<Case, CompsCourt> compsCourtJoin = caseJoin.join(PARAM_COMPS_COURT);
            Join<CompsCourt, CourtLvlType> courtLvlJoin = compsCourtJoin.join(PARAM_COURTLVL_TYPE);
            andPredicates.add(builder.equal(courtLvlJoin.get(PARAM_COURTLVL_TYPE_CD),
                    func.getCourtLevelTypeCode()));
        }
    }

    private void addCaseTypeCriteria(CriteriaBuilder builder, Root<Reqs> reqsRoot,
            List<Predicate> andPredicates, CaseTypeDTO caseType, FunctionDTO func) {
        Join<Reqs, Case> caseJoin = reqsRoot.join(PARAM_CASE);
        Join<Case, CaseType> caseTypeJoin = caseJoin.join(PARAM_CASE_TYPE);
        if (caseType != null && caseType.getCaseTypeId() != null && caseType.getCaseTypeId() != 0) {
            andPredicates.add(builder.equal(caseTypeJoin.get(PARAM_CASE_TYPE_ID),
                    caseType.getCaseTypeId()));
        } else {
            Join<CaseType, CaseClass> caseClassJoin = caseTypeJoin.join(PARAM_CASE_CLASS);
            andPredicates.add(builder.notEqual(caseClassJoin.get(PARAM_CASE_CLASS_CD),
                    CaseConstant.CASE_CLASS_WARRANT));
            Join<CompsCourt, CourtLvlType> courtLvlJoin = caseTypeJoin.join(PARAM_COURTLVL_TYPE);
            andPredicates.add(builder.equal(courtLvlJoin.get(PARAM_COURTLVL_TYPE_CD),
                    func.getCourtLevelTypeCode()));
        }
    }

    private void addCourtLevelCriteria(CriteriaBuilder builder, Root<Reqs> reqsRoot,
            List<Predicate> andPredicates, FunctionDTO func) {
        Join<Reqs, Case> caseJoin = reqsRoot.join(PARAM_CASE);
        if (func != null && func.getCourtLevelTypeCode() != null
                && !"".equals(func.getCourtLevelTypeCode())) {
            Join<Case, CourtLvlType> courtLvlJoin = caseJoin.join(PARAM_COURTLVL_TYPE);
            andPredicates.add(builder.equal(courtLvlJoin.get(PARAM_COURTLVL_TYPE_CD),
                    func.getCourtLevelTypeCode()));
        }
    }

    public Reqs findLastSuccessServiceRequestByCaseNo(MaintainRequestDTO maintainRequest) {
        Reqs reqs = null;
        CriteriaBuilder builder = getEntityManager().getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Reqs> criteria = builder.createQuery(Reqs.class);
        Root<Reqs> reqsRoot = criteria.from(Reqs.class);
        criteria = criteria.select(reqsRoot);
        reqsRoot.fetch(PARAM_REQUEST_TYPE, JoinType.LEFT);
        reqsRoot.fetch(PARAM_SERV_REQS, JoinType.LEFT);
        reqsRoot.fetch(PARAM_REQS_STATUS, JoinType.LEFT);
        List<Predicate> andPredicates = new ArrayList<Predicate>();

        addRequestTypeCriteria(builder, reqsRoot, andPredicates,
                RequestConstant.REQUEST_TYPE_ID_SER);

        addCaseNoCriteria(builder, reqsRoot, andPredicates, maintainRequest.getCaseNo());

        addCourtLevelCriteria(builder, reqsRoot, andPredicates, maintainRequest.getFunc());

        Join<Reqs, ReqsRslt> reqsRsltJoin = reqsRoot.join(PARAM_REQS_RSLT);

        Join<Reqs, BlfTaskRsltStatus> reqsRsltStatusJoin = reqsRsltJoin.join(PARAM_RSLT_STATUS);

        Join<ReqsRslt, AuditEntity> auditEntityJoin = reqsRsltJoin.join(PARAM_AUDITENTITY);

        andPredicates.add(builder.equal(reqsRsltStatusJoin.get(PARAM_BLFTASKRSLT_STATUS),
                RequestConstant.BAILIFF_TASK_RESULT_STATUS_ID_SUCCESS));

        if (!CommonUtil.isNullOrEmpty(andPredicates)) {
            criteria.where(andPredicates.toArray(new Predicate[0]));
        }

        criteria.orderBy(builder.desc(auditEntityJoin.get(PARAM_LAST_UPDATEDT)));

        TypedQuery<Reqs> query = getEntityManager().createQuery(criteria);
        List<Reqs> list = getResultList(query);
        if (!CommonUtil.isNullOrEmpty(list)) {
            reqs = list.get(0);
        }
        return reqs;
    }

    public Reqs findSuccessServiceRequestByRequestId(MaintainRequestDTO maintainRequest) {
        CriteriaBuilder builder = getEntityManager().getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Reqs> criteria = builder.createQuery(Reqs.class);
        Root<Reqs> reqsRoot = criteria.from(Reqs.class);
        criteria = criteria.select(reqsRoot);
        reqsRoot.fetch(PARAM_REQUEST_TYPE, JoinType.LEFT);
        reqsRoot.fetch(PARAM_SERV_REQS, JoinType.LEFT);
        reqsRoot.fetch(PARAM_REQS_STATUS, JoinType.LEFT);
        List<Predicate> andPredicates = new ArrayList<Predicate>();

        addRequestTypeCriteria(builder, reqsRoot, andPredicates,
                RequestConstant.REQUEST_TYPE_ID_SER);

        andPredicates.add(builder.equal(reqsRoot.get(PARAM_REQUEST_ID),
                maintainRequest.getRequestId()));

        addCourtLevelCriteria(builder, reqsRoot, andPredicates, maintainRequest.getFunc());

        Join<Reqs, ReqsRslt> reqsRsltJoin = reqsRoot.join(PARAM_REQS_RSLT);

        Join<Reqs, BlfTaskRsltStatus> reqsRsltStatusJoin = reqsRsltJoin.join(PARAM_RSLT_STATUS);

        andPredicates.add(builder.equal(reqsRsltStatusJoin.get(PARAM_BLFTASKRSLT_STATUS),
                RequestConstant.BAILIFF_TASK_RESULT_STATUS_ID_SUCCESS));

        if (!CommonUtil.isNullOrEmpty(andPredicates)) {
            criteria.where(andPredicates.toArray(new Predicate[0]));
        }

        TypedQuery<Reqs> query = getEntityManager().createQuery(criteria);
        query.setMaxResults(1);

        return getSingleResult(query);
    }

    public List<Reqs> findRequestListByExecutionRequestSearch(ExecutionRequestSearchDTO searchDTO) {
        info("findRequestListByExecutionRequestSearch() start - and ExecutionRequestSearchDTO:"
                + searchDTO);
        CriteriaBuilder builder = getEntityManager().getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Reqs> criteria = builder.createQuery(Reqs.class);
        Root<Reqs> reqsRoot = criteria.from(Reqs.class);
        criteria = criteria.select(reqsRoot);
        reqsRoot.fetch(PARAM_REQUEST_TYPE, JoinType.LEFT);
        reqsRoot.fetch(PARAM_SERV_REQS, JoinType.LEFT);
        reqsRoot.fetch(PARAM_REQS_STATUS, JoinType.LEFT);
        List<Predicate> andPredicates = new ArrayList<Predicate>();

        addRequestTypeCriteria(builder, reqsRoot, andPredicates,
                RequestConstant.REQUEST_TYPE_ID_EXE);

        addSubmitCriteria(builder, reqsRoot, andPredicates, searchDTO.getSubmitStartDate(),
                searchDTO.getSubmitEndDate());

        addCaseNoCriteria(builder, reqsRoot, andPredicates, searchDTO.getCaseNo());

        Join<Reqs, HandlingAgt> handlingAgtJoin = reqsRoot.join(PARAM_HANDLING_AGT);
        andPredicates.add(builder.equal(handlingAgtJoin.get(PARAM_HANDLINGAGT_CD),
                RequestConstant.HANDLING_AGENT_BAILIFF));

        addRequestStatusCriteria(builder, reqsRoot, andPredicates,
                searchDTO.getRequestStatusTypes());

        FunctionDTO function = searchDTO.getFunc();
        addComprisingCourtCriteria(builder, reqsRoot, andPredicates,
                searchDTO.getComprisingCourt(), function);

        addCaseTypeCriteria(builder, reqsRoot, andPredicates, searchDTO.getCaseType(), function);

        addCourtLevelCriteria(builder, reqsRoot, andPredicates, function);

        if (!CommonUtil.isNullOrEmpty(andPredicates)) {
            criteria.where(andPredicates.toArray(new Predicate[0]));
        }
        List<Order> orderBies = new ArrayList<Order>();
        orderBies.add(builder.asc(reqsRoot.get(PARAM_SUBMIT_DATE)));
        orderBies.add(builder.asc(reqsRoot.get(PARAM_REQUEST_ID)));
        criteria.orderBy(orderBies);
        criteria.distinct(true);
        TypedQuery<Reqs> query = getEntityManager().createQuery(criteria);
        List<Reqs> returnVal = getResultList(query);
        return returnVal;
    }
}
