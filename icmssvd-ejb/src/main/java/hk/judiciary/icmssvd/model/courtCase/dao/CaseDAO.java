package hk.judiciary.icmssvd.model.courtCase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseNoDTO;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;

public class CaseDAO extends CommonDAO<Case> {
    protected CaseDAO() {
        super(CaseDAO.class);
    }

    public static final String CASE_DAO = "caseDAO";

    private static final String PARAM_CASETYPE = "caseType";
    private static final String PARAM_COMPSCOURT = "compsCourt";
    private static final String PARAM_COURTLVLTYPE = "courtLvlType";

    private static final String PARAM_CASEID = "caseId";
    private static final String PARAM_CASESERNO = "caseSerNo";
    private static final String PARAM_CASEYR = "caseYr";
    private static final String PARAM_CASETYPE_CD = "caseTypeCd";
    private static final String PARAM_COMPSCOURT_CD = "compsCourtCd";
    private static final String PARAM_COURTLVLTYPE_CD = "courtLvlTypeCd";

    public List<Case> retrieve(CaseRetrieveCriteriaDTO retrieveCriteriaDTO) {

        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Case> criteriaQuery = criteriaBuilder.createQuery(Case.class);
        Root<Case> caseRoot = criteriaQuery.from(Case.class);
        criteriaQuery.select(caseRoot);

        List<Predicate> criterias = new ArrayList<Predicate>();

        if (retrieveCriteriaDTO.getCaseId() != null) {
            criterias.add(criteriaBuilder.equal(caseRoot.get(PARAM_CASEID),
                    retrieveCriteriaDTO.getCaseId()));
        }
        if (retrieveCriteriaDTO.getCaseIds() != null) {
            criterias.add(caseRoot.get(PARAM_CASEID).in(retrieveCriteriaDTO.getCaseIds()));
        }
        if (retrieveCriteriaDTO.getCaseNo() != null) {
            CaseNoDTO caseNoDTO = SvdCommonUtil.splitCaseNoToDTO(retrieveCriteriaDTO.getCaseNo());
            if (!CommonUtil.isNullOrEmpty(caseNoDTO)) {
                criterias.add(criteriaBuilder.equal(
                        caseRoot.join(PARAM_COMPSCOURT).get(PARAM_COMPSCOURT_CD),
                        caseNoDTO.getComprisingCourt()));
                criterias.add(criteriaBuilder.equal(
                        caseRoot.join(PARAM_CASETYPE).get(PARAM_CASETYPE_CD),
                        caseNoDTO.getCaseType()));
                criterias.add(criteriaBuilder.equal(caseRoot.get(PARAM_CASESERNO),
                        caseNoDTO.getCaseSerialNo()));
                criterias.add(criteriaBuilder.equal(caseRoot.get(PARAM_CASEYR),
                        caseNoDTO.getCaseYear()));
            }
        }
        if (retrieveCriteriaDTO.getFunc() != null
                && !"".equals(retrieveCriteriaDTO.getFunc().getCourtLevelTypeCode())) {
            Join<Case, CourtLvlType> courtLvlTypeJoin = caseRoot.join(PARAM_COURTLVLTYPE);
            criterias.add(criteriaBuilder.equal(courtLvlTypeJoin.get(PARAM_COURTLVLTYPE_CD),
                    retrieveCriteriaDTO.getFunc().getCourtLevelTypeCode()));
        }

        if (criterias.size() > 0) {
            criteriaQuery.where(criteriaBuilder.and((Predicate[]) criterias
                    .toArray(new Predicate[0])));
        }

        TypedQuery<Case> query = getEntityManager().createQuery(criteriaQuery);

        return query.getResultList();
    }

}
