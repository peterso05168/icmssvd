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
import hk.judiciary.icms.model.dao.entity.PartcpRole;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.PartcpRoleRetrieveCriteriaDTO;

public class PartcpRoleDAO extends CommonDAO<PartcpRole>{

	protected PartcpRoleDAO() {
		super(PartcpRoleDAO.class);
		// TODO Auto-generated constructor stub
	}
	
	public static final String PARTCP_ROLE_DAO = "partcpRoleDAO";
	
	public List<PartcpRole> retrieve(PartcpRoleRetrieveCriteriaDTO retrieveCriteriaDTO) {
		String caseEntityName = "vcase";
		String caseIdName = "caseId";
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<PartcpRole> criteriaQuery = criteriaBuilder.createQuery(PartcpRole.class);
		Root<PartcpRole> entityRoot = criteriaQuery.from(PartcpRole.class);
		criteriaQuery.select(entityRoot);
		
		List<Predicate> criterias = new ArrayList<Predicate>();
		Predicate criteria = null;
		
		if (retrieveCriteriaDTO.getCaseId() != null) {
			Join<PartcpRole, Case> partcpRoleCaseJoin = entityRoot.join(caseEntityName);
			criteria = criteriaBuilder.equal(partcpRoleCaseJoin.get(caseIdName), retrieveCriteriaDTO.getCaseId());
			criterias.add(criteria);
		}
		
		if (criterias.size() > 0) {
			criteria = criteriaBuilder.and((Predicate[])criterias.toArray(new Predicate[0]));
			criteriaQuery.where(criteria);	
		}
		
		TypedQuery<PartcpRole> query = getEntityManager().createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
