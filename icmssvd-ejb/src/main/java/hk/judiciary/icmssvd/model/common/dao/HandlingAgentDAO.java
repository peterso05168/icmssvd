package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.HandlingAgt;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 6116 $ $Date: 2017-04-05 17:01:18 +0800 (週三, 05 四月 2017) $
 * @author $Author: vicki.huang $
 */
public class HandlingAgentDAO extends BaseDAO<HandlingAgt> {
    public static final String HANDLING_AGT_DAO = "handlingAgentDAO";

    private static final String QUERY_LIST = "HandlingAgt.findHandlingAgentList";
    private static final String QUERY_HANDLINGAGT = "HandlingAgt.findHandlingAgent";
    private static final String QUERY_HANDLINGAGT_BY_CODE = "HandlingAgt.findHandlingAgentByCode";

    private static final String PARAM_HANDLINGAGT_ID = "handlingAgtId";
    private static final String PARAM_HANDLINGAGT_CODE = "handlingAgtCd";

    public List<HandlingAgt> findHandlingAgentList() {
        info("findHandlingAgentList() start ");
        TypedQuery<HandlingAgt> query = getEntityManager().createNamedQuery(QUERY_LIST,
                HandlingAgt.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<HandlingAgt> list = getResultList(query);
        return list;
    }

    public HandlingAgt findHandlingAgent(Integer handlingAgentId) {
        info("findHandlingAgent() start ");
        TypedQuery<HandlingAgt> query = getEntityManager().createNamedQuery(QUERY_HANDLINGAGT,
                HandlingAgt.class);
        query.setParameter(PARAM_HANDLINGAGT_ID, handlingAgentId);
        return getSingleResult(query);
    }

    public HandlingAgt findByHandlingAgentCode(String handlingAgentCode) {
        info("findHandlingAgent() start ");
        TypedQuery<HandlingAgt> query = getEntityManager().createNamedQuery(
                QUERY_HANDLINGAGT_BY_CODE, HandlingAgt.class);
        query.setParameter(PARAM_HANDLINGAGT_CODE, handlingAgentCode);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        return getSingleResult(query);
    }
}
