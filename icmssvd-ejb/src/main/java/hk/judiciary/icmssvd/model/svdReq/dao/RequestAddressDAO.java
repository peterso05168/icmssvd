package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.ReqsAddr;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class RequestAddressDAO extends BaseDAO<ReqsAddr> {
    public static final String REQUEST_ADDRESS_DAO = "requestAddressDAO";

    private static final String QUERY_PRIMARY_BY_ID = "ReqsAddr.findPrimaryRequestAddressByRequestId";
    private static final String QUERY_BY_REQS_ID = "ReqsAddr.findRequestAddressListByRequestId";

    private static final String PARAM_REQUEST_ID = "reqsId";

    public List<ReqsAddr> findPrimaryRequestAddressByRequestId(Integer reqsId) {
        info("findPrimaryRequestAddressByRequestId() start " + reqsId);
        TypedQuery<ReqsAddr> query = getEntityManager().createNamedQuery(QUERY_PRIMARY_BY_ID,
                ReqsAddr.class);
        query.setParameter(PARAM_REQUEST_ID, reqsId);
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        return getResultList(query);
    }

    public List<ReqsAddr> findRequestAddressListByRequestId(Integer reqsId) {
        info("findRequestAddressListByRequestId() start " + reqsId);
        TypedQuery<ReqsAddr> query = getEntityManager().createNamedQuery(QUERY_BY_REQS_ID,
                ReqsAddr.class);
        query.setParameter(PARAM_REQUEST_ID, reqsId);
        return getResultList(query);
    }
}
