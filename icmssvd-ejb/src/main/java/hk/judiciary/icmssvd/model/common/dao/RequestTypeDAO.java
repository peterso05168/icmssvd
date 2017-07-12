package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.ReqsType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestTypeDAO extends BaseDAO<ReqsType> {
    public static final String REQS_TYPE_DAO = "requestTypeDAO";

    private static final String QUERY_LIST = "ReqsType.findRequestTypeList";

    public List<ReqsType> findRequestTypeList() {
        info("findRequestTypeList() start ");
        TypedQuery<ReqsType> query = getEntityManager()
                .createNamedQuery(QUERY_LIST, ReqsType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<ReqsType> list = getResultList(query);
        return list;
    }

    public ReqsType findRequestType(Integer requesteTypeId) {
        info("findRequestType() start ");
        return find(ReqsType.class, requesteTypeId);
    }
}
