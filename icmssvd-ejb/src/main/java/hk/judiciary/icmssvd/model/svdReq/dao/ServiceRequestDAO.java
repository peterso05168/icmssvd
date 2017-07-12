package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.ServReqs;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 7630 $ $Date: 2017-06-20 17:53:40 +0800 (週二, 20 六月 2017) $
 * @author $Author: vicki.huang $
 */
public class ServiceRequestDAO extends BaseDAO<ServReqs> {
    public static final String SERVICE_REQUEST_DAO = "serviceRequestDAO";

    private static final String QUERY_BY_REQS_ID = "ServReqs.findServiceRequestByRequestId";
    private static final String QUERY_BY_CASE_ID = "ServReqs.findLatestServiceRequestByCaseId";

    private static final String PARAM_REQUEST_ID = "reqsId";
    private static final String PARAM_CASE_ID = "caseId";

    public ServReqs findServiceRequestByRequestId(Integer reqsId) {
        info("findServiceRequestByRequestId() start " + reqsId);
        TypedQuery<ServReqs> query = getEntityManager().createNamedQuery(QUERY_BY_REQS_ID,
                ServReqs.class);
        query.setParameter(PARAM_REQUEST_ID, reqsId);
        query.setMaxResults(1);
        return getSingleResult(query);
    }

    public List<ServReqs> findLatestServiceRequestByCaseId(Integer caseId) {
        info("findServiceRequestByRequestId() start " + caseId);
        TypedQuery<ServReqs> query = getEntityManager().createNamedQuery(QUERY_BY_CASE_ID,
                ServReqs.class);
        query.setParameter(PARAM_CASE_ID, caseId);
        query.setMaxResults(1);
        return getResultList(query);
    }
}
