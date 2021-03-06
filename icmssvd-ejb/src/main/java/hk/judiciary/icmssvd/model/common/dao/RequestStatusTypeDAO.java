package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.ReqsStatusType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestStatusTypeDAO extends BaseDAO<ReqsStatusType> {
    public static final String REQS_STATUS_TYPE_DAO = "requestStatusTypeDAO";

    private static final String QUERY_LIST = "ReqsStatusType.findRequestStatusList";

    private static final String QUERY_TYPE_BY_CD = "ReqsStatusType.findByRequestStatusTypeCode";

    private static final String PARAM_STATUS_TYPECD = "reqsStatusTypeCd";

    public List<ReqsStatusType> findRequestStatusList() {
        info("findRequestStatusList() start ");
        TypedQuery<ReqsStatusType> query = getEntityManager().createNamedQuery(QUERY_LIST,
                ReqsStatusType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<ReqsStatusType> list = getResultList(query);
        return list;
    }

    public ReqsStatusType findByRequestStatusTypeCode(String statusTypeCd) {
        info("findByRequestStatusTypeCode() start ");
        TypedQuery<ReqsStatusType> query = getEntityManager().createNamedQuery(QUERY_TYPE_BY_CD,
                ReqsStatusType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        query.setParameter(PARAM_STATUS_TYPECD, statusTypeCd);
        return getSingleResult(query);
    }
}
