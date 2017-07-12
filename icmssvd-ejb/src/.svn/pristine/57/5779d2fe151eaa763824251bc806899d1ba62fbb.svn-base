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
import hk.judiciary.icms.model.dao.entity.ChrgNat;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgNatRetrieveCriteriaDTO;

public class ChrgNatDAO extends CommonDAO<ChrgNat>{

	protected ChrgNatDAO() {
		super(ChrgNatDAO.class);
		// TODO Auto-generated constructor stub
	}

	public static final String CHRG_NAT_DAO = "chrgNatDAO";
	
	public List<ChrgNat> retrieve(ChrgNatRetrieveCriteriaDTO retrieveCriteriaDTO) {
		String caseEntityName = "vcase";
		String caseIdName = "caseId";
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ChrgNat> criteriaQuery = criteriaBuilder.createQuery(ChrgNat.class);
		Root<ChrgNat> entityRoot = criteriaQuery.from(ChrgNat.class);
		criteriaQuery.select(entityRoot);
		
		List<Predicate> criterias = new ArrayList<Predicate>();
		Predicate criteria = null;
		
		if (retrieveCriteriaDTO.getCaseId() != null) {
			Join<ChrgNat, Case> chrgNatCaseJoin = entityRoot.join(caseEntityName);
			criteria = criteriaBuilder.equal(chrgNatCaseJoin.get(caseIdName), retrieveCriteriaDTO.getCaseId());
			criterias.add(criteria);
		}
		
		if (criterias.size() > 0) {
			criteria = criteriaBuilder.and((Predicate[])criterias.toArray(new Predicate[0]));
			criteriaQuery.where(criteria);
			
		}
		
		TypedQuery<ChrgNat> query = getEntityManager().createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
