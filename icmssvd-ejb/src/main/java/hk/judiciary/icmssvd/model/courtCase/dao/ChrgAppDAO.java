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
import hk.judiciary.icms.model.dao.entity.ChrgApp;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgAppRetrieveCriteriaDTO;

public class ChrgAppDAO extends CommonDAO<ChrgApp> {

	protected ChrgAppDAO() {
		super(ChrgAppDAO.class);
		// TODO Auto-generated constructor stub
	}

	public static final String CHRG_APP_DAO = "chrgAppDAO";
	
	public List<ChrgApp> retrieve(ChrgAppRetrieveCriteriaDTO retrieveCriteriaDTO) {
		String caseEntityName = "vcase";
		String caseIdName = "caseId";
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ChrgApp> criteriaQuery = criteriaBuilder.createQuery(ChrgApp.class);
		Root<ChrgApp> entityRoot = criteriaQuery.from(ChrgApp.class);
		criteriaQuery.select(entityRoot);
		
		List<Predicate> criterias = new ArrayList<Predicate>();
		Predicate criteria = null;
		
		if (retrieveCriteriaDTO.getCaseId() != null) {
			Join<ChrgApp, Case> chrgAppCaseJoin = entityRoot.join(caseEntityName);
			criteria = criteriaBuilder.equal(chrgAppCaseJoin.get(caseIdName), retrieveCriteriaDTO.getCaseId());
			criterias.add(criteria);
		}
		
		if (criterias.size() > 0) {
			criteria = criteriaBuilder.and((Predicate[])criterias.toArray(new Predicate[0]));
			criteriaQuery.where(criteria);
		}
		
		TypedQuery<ChrgApp> query = getEntityManager().createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
