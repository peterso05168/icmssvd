package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.CaseClass;
import hk.judiciary.icms.model.dao.entity.CaseType;
import hk.judiciary.icms.model.dao.entity.CompsCourt;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icms.model.dao.entity.CourtRmChmbr;
import hk.judiciary.icms.model.dao.entity.FpAppNatType;
import hk.judiciary.icms.model.dao.entity.HrnDtl;
import hk.judiciary.icms.model.dao.entity.HrnRsltCd;
import hk.judiciary.icms.model.dao.entity.Pd;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtRoomChambersDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.CaseConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.BatchSearchDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class HearingDetailDAO extends BaseDAO<HrnDtl> {
    public static final String HEARING_DETAIL_DAO = "hearingDetailDAO";

    private static final String PARAM_HRNDT_LDATE = "hrnDtlDate";
    private static final String PARAM_COMPSCOURT_ID = "compsCourtId";
    private static final String PARAM_CASETYPE_ID = "caseTypeId";
    private static final String PARAM_CASETYPE_CD = "caseTypeCd";
    private static final String PARAM_CASECLASS_CD = "caseClassCd";
    private static final String PARAM_COURTLVL_TYPE_CD = "courtLvlTypeCd";
    private static final String PARAM_FP_APPNAT_TYPE_ID = "fpAppNatTypeId";
    private static final String PARAM_PD_ID = "pdId";
    private static final String PARAM_COURTRM_CHMBR_ID = "courtRmChmbrId";

    private static final String PARAM_COURTRM_CHMBR = "courtRmChmbr";
    private static final String PARAM_STNCE_ORDR = "stnceOrdr";
    private static final String PARAM_HRNRSLT_CD = "hrnRsltCd";
    private static final String PARAM_VCASE = "vcase";
    private static final String PARAM_COMPS_COURT = "compsCourt";
    private static final String PARAM_CASE_TYPE = "caseType";
    private static final String PARAM_CASE_CLASS = "caseClass";
    private static final String PARAM_COURT_LVL_TYPE = "courtLvlType";
    private static final String PARAM_SUMMON_NOTI = "summonNoti";
    private static final String PARAM_FP_APPNAT_TYPE = "fpAppNatType";
    private static final String PARAM_CHRG_NAT = "chrgNat";
    private static final String PARAM_PD = "pd";

    public List<HrnDtl> findHearingDetailListByBatchSearch(
            BatchSearchDTO searchDTO, String hearingResultCode) {
        info("findHearingDetailListByReserviceBatchSearch() start " + searchDTO);
        CriteriaBuilder builder = getEntityManager().getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<HrnDtl> criteria = builder.createQuery(HrnDtl.class);
        Root<HrnDtl> hrnDtlRoot = criteria.from(HrnDtl.class);
        criteria = criteria.select(hrnDtlRoot);
        List<Predicate> andPredicates = new ArrayList<Predicate>();

        Join<HrnDtl, Case> caseJoin = hrnDtlRoot.join(PARAM_VCASE, JoinType.LEFT);

        Join<HrnDtl, HrnRsltCd> hrnRsltCdJoin = hrnDtlRoot.join(PARAM_STNCE_ORDR, JoinType.LEFT)
                .join(PARAM_HRNRSLT_CD, JoinType.LEFT);
        andPredicates.add(builder.equal(hrnRsltCdJoin.get(PARAM_HRNRSLT_CD), hearingResultCode));

        Join<HrnDtl, CompsCourt> compsCourtJoin = caseJoin.join(PARAM_COMPS_COURT, JoinType.LEFT);
        andPredicates.add(builder.equal(compsCourtJoin.get(PARAM_COMPSCOURT_ID), searchDTO
                .getComprisingCourt().getComprisingCourtId()));

        CourtRoomChambersDTO courtRoomChambers = searchDTO.getCourtRoomChambers();
        if (courtRoomChambers != null
                && DbCommonUtil.isValidDbId(courtRoomChambers.getCourtRoomChambersId())) {
            Join<HrnDtl, CourtRmChmbr> courtRmJoin = hrnDtlRoot.join(PARAM_COURTRM_CHMBR,
                    JoinType.LEFT);
            andPredicates.add(builder.equal(courtRmJoin.get(PARAM_COURTRM_CHMBR_ID), searchDTO
                    .getCourtRoomChambers().getCourtRoomChambersId()));
        }

        Expression<Date> hrnDtlDate = hrnDtlRoot.get(PARAM_HRNDT_LDATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(searchDTO.getHearingStartTime());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        if (searchDTO.getHearingStartTime() == null || (hour == 0 && min == 0)) {
            andPredicates.add(builder.greaterThanOrEqualTo(hrnDtlDate,
                    DbCommonUtil.getStartDateTime(searchDTO.getHearingScheduleDate())));
            andPredicates.add(builder.lessThanOrEqualTo(hrnDtlDate,
                    DbCommonUtil.getEndDateTime(searchDTO.getHearingScheduleDate())));
        } else {
            calendar.setTime(searchDTO.getHearingScheduleDate());
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, min);
            andPredicates.add(builder.equal(hrnDtlDate, calendar.getTime()));
        }

        if (searchDTO.getCaseType() != null
                && DbCommonUtil.isValidDbId(searchDTO.getCaseType().getCaseTypeId())) {
            Join<Case, CaseType> caseTypeJoin = caseJoin.join(PARAM_CASE_TYPE);
            andPredicates.add(builder.equal(caseTypeJoin.get(PARAM_CASETYPE_ID), searchDTO
                    .getCaseType().getCaseTypeId()));
        } else {
            Join<Case, CaseType> caseTypeJoin = caseJoin.join(PARAM_CASE_TYPE);
            Expression<String> caseTypeCd = caseTypeJoin.get(PARAM_CASETYPE_CD);
            String[] caseTypes = { CaseConstant.CASE_TYPE_DOP_SUMMONS,
                    CaseConstant.CASE_TYPE_DEPT_SUMMONS, CaseConstant.CASE_TYPE_FP_SUMMONS_FS,
                    CaseConstant.CASE_TYPE_FP_SUMMONS_V, CaseConstant.CASE_TYPE_FP_SUMMONS_K,
                    CaseConstant.CASE_TYPE_FP_SUMMONS_R };
            andPredicates.add(caseTypeCd.in(Arrays.asList(caseTypes)));

            Join<CaseType, CaseClass> caseClassJoin = caseTypeJoin.join(PARAM_CASE_CLASS);
            andPredicates.add(builder.notEqual(caseClassJoin.get(PARAM_CASECLASS_CD),
                    CaseConstant.CASE_CLASS_WARRANT));

            Join<CaseType, CourtLvlType> courtLvlJoin = caseTypeJoin.join(PARAM_COURT_LVL_TYPE);
            andPredicates.add(builder.equal(courtLvlJoin.get(PARAM_COURTLVL_TYPE_CD), searchDTO
                    .getFunc().getCourtLevelTypeCode()));
        }

        if (searchDTO.getFpApplicationNatureType() != null
                && DbCommonUtil.isValidDbId(searchDTO.getFpApplicationNatureType()
                        .getFpApplicationNatureTypeId())) {
            Join<Case, FpAppNatType> fpAppNatTypeJoin = caseJoin.join(PARAM_SUMMON_NOTI).join(
                    PARAM_FP_APPNAT_TYPE);
            andPredicates.add(builder.equal(fpAppNatTypeJoin.get(PARAM_FP_APPNAT_TYPE_ID),
                    searchDTO.getFpApplicationNatureType().getFpApplicationNatureTypeId()));
        }

        if (searchDTO.getProsecutionDepartment() != null
                && DbCommonUtil.isValidDbId(searchDTO.getProsecutionDepartment()
                        .getProsecutionDepartmentCodeId())) {
            Join<Case, Pd> pdJoin = caseJoin.join(PARAM_CHRG_NAT).join(PARAM_PD);
            andPredicates.add(builder.equal(pdJoin.get(PARAM_PD_ID), searchDTO
                    .getProsecutionDepartment().getProsecutionDepartmentCodeId()));
        }

        if (!CommonUtil.isNullOrEmpty(andPredicates)) {
            criteria.where(andPredicates.toArray(new Predicate[0]));
        }
        List<Order> orderBies = new ArrayList<Order>();
        orderBies.add(builder.asc(hrnDtlRoot.get(PARAM_HRNDT_LDATE)));
        criteria.orderBy(orderBies);
        TypedQuery<HrnDtl> query = getEntityManager().createQuery(criteria);
        List<HrnDtl> returnVal = getResultList(query);
        return returnVal;
    }
}
