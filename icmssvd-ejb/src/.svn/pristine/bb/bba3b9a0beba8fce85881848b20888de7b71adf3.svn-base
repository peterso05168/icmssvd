package hk.judiciary.icmssvd.model.courtCase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.SummonNoti;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.SummonNotiRetrieveCriteriaDTO;

public class SummonNotiDAO extends CommonDAO<SummonNoti> {

	protected SummonNotiDAO() {
		super(SummonNotiDAO.class);
		// TODO Auto-generated constructor stub
	}

	public static final String SUMMON_NOTI_DAO = "summonNotiDAO";
	
	public List<SummonNoti> retrieve(SummonNotiRetrieveCriteriaDTO retrieveCriteriaDTO) {
		String caseEntityName = "vcase";
		String caseIdName = "caseId";
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<SummonNoti> criteriaQuery = criteriaBuilder.createQuery(SummonNoti.class);
		Root<SummonNoti> entityRoot = criteriaQuery.from(SummonNoti.class);
		criteriaQuery.select(entityRoot);
		
		List<Predicate> criterias = new ArrayList<Predicate>();
		Predicate criteria = null;
		
		if (retrieveCriteriaDTO.getCaseId() != null) {
			Join<SummonNoti, Case> summonNotiCaseJoin = entityRoot.join(caseEntityName);
			criteria = criteriaBuilder.equal(summonNotiCaseJoin.get(caseIdName), retrieveCriteriaDTO.getCaseId());
			criterias.add(criteria);
		}
		
		if (criterias.size() > 0) {
			criteria = criteriaBuilder.and((Predicate[])criterias.toArray(new Predicate[0]));
			criteriaQuery.where(criteria);
		}
		
		TypedQuery<SummonNoti> query = getEntityManager().createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
