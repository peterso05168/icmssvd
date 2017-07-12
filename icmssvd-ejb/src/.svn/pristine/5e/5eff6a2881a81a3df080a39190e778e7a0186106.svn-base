package hk.judiciary.icmssvd.model.courtCase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icms.model.dao.entity.IntmCase;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.HrnSchdRetrieveCriteriaDTO;

public class HrnSchdDAO extends CommonDAO<HrnSchd> {

	protected HrnSchdDAO() {
		super(HrnSchdDAO.class);
		// TODO Auto-generated constructor stub
	}

	public static final String HRN_SCHD_DAO = "hrnSchdDAO";
	
	public List<HrnSchd> retrieve(HrnSchdRetrieveCriteriaDTO retrieveCriteriaDTO) {
		String caseEntityName = "vcase";
		String caseIdName = "caseId";
		String statusName = "status";
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<HrnSchd> criteriaQuery = criteriaBuilder.createQuery(HrnSchd.class);
		Root<HrnSchd> entityRoot = criteriaQuery.from(HrnSchd.class);
		criteriaQuery.select(entityRoot);
		
		List<Predicate> criterias = new ArrayList<Predicate>();
		Predicate criteria = null;
		
		if (retrieveCriteriaDTO.getCaseId() != null) {
			Join<HrnSchd, IntmCase> hrnSchdCaseJoin = entityRoot.join(caseEntityName);
			criteria = criteriaBuilder.equal(hrnSchdCaseJoin.get(caseIdName), retrieveCriteriaDTO.getCaseId());
			criterias.add(criteria);
		}
		if (retrieveCriteriaDTO.getStatus() != null) {
			criteria = criteriaBuilder.equal(entityRoot.get(statusName), retrieveCriteriaDTO.getStatus());
			criterias.add(criteria);
		}
		
		if (criterias.size() > 0) {
			criteria = criteriaBuilder.and((Predicate[])criterias.toArray(new Predicate[0]));
			criteriaQuery.where(criteria);
		}
		
		TypedQuery<HrnSchd> query = getEntityManager().createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
