package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.SpecialReqs;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class SpecialRequestDAO extends BaseDAO<SpecialReqs> {
    public static final String SPECIAL_REQUEST_DAO = "specialRequestDAO";

    private static final String QUERY_BY_REQS_ID = "SpecialReqs.findSpecialRequestListByRequestId";

    private static final String PARAM_REQUEST_ID = "reqsId";

    public List<SpecialReqs> findSpecialRequestListByRequestId(Integer reqsId) {
        info("findSpecialRequestListByRequestId() start " + reqsId);
        TypedQuery<SpecialReqs> query = getEntityManager().createNamedQuery(QUERY_BY_REQS_ID,
                SpecialReqs.class);
        query.setParameter(PARAM_REQUEST_ID, reqsId);
        return getResultList(query);
    }
}
