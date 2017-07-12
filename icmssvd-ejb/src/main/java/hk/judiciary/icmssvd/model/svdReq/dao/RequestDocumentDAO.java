package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.ReqsDoc;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class RequestDocumentDAO extends BaseDAO<ReqsDoc> {
    public static final String REQUEST_DOCUMENT_DAO = "requestDocumentDAO";

    private static final String QUERY_BY_REQS_ID = "ReqsDoc.findRequestDocumentListByRequestId";

    private static final String PARAM_REQUEST_ID = "reqsId";

    public List<ReqsDoc> findRequestDocumentListByRequestId(Integer reqsId) {
        info("findRequestDocumentListByRequestId() start " + reqsId);
        TypedQuery<ReqsDoc> query = getEntityManager().createNamedQuery(QUERY_BY_REQS_ID,
                ReqsDoc.class);
        query.setParameter(PARAM_REQUEST_ID, reqsId);
        return getResultList(query);
    }
}
