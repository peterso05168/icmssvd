package hk.judiciary.icmssvd.model.svdReq.dao;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.ProofOfServReqs;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class PosRequestDAO extends BaseDAO<ProofOfServReqs> {
    public static final String POS_REQUEST_DAO = "posRequestDAO";

    private static final String QUERY_BY_REQS_ID = "ProofOfServReqs.findPosRequest";
    private static final String QUERY_BY_SEV_REQS_ID = "ProofOfServReqs.findPosRequestByServiceRequestId";

    private static final String PARAM_REQUEST_ID = "reqsId";
    private static final String PARAM_SERVICE_REQUEST_ID = "servReqsId";

    public ProofOfServReqs findPosRequest(Integer reqsId) {
        info("findPosRequest() start " + reqsId);
        TypedQuery<ProofOfServReqs> query = getEntityManager().createNamedQuery(QUERY_BY_REQS_ID,
                ProofOfServReqs.class);
        query.setParameter(PARAM_REQUEST_ID, reqsId);
        query.setMaxResults(1);
        return getSingleResult(query);
    }

    public ProofOfServReqs findPosRequestByServiceRequestId(Integer servReqsId) {
        info("findPosRequestByServiceRequestId() start " + servReqsId);
        TypedQuery<ProofOfServReqs> query = getEntityManager().createNamedQuery(
                QUERY_BY_SEV_REQS_ID, ProofOfServReqs.class);
        query.setParameter(PARAM_SERVICE_REQUEST_ID, servReqsId);
        query.setMaxResults(1);
        return getSingleResult(query);
    }
}
