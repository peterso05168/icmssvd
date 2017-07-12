package hk.judiciary.icmssvd.model.common.dao;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.BlfTaskStatusType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 7630 $ $Date: 2017-06-20 17:53:40 +0800 (週二, 20 六月 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffTaskStatusTypeDAO extends BaseDAO<BlfTaskStatusType> {
    public static final String BLF_TASK_STATUS_TYPE_DAO = "bailiffTaskStatusTypeDAO";

    private static final String QUERY_SEQ_BYCD = "BlfTaskStatusType.findByBailiffTaskStatusTypeCode";

    private static final String PARAM_BLFTASK_STATUS_CD = "blfTaskStatusTypeCd";

    public BlfTaskStatusType findByBailiffTaskStatusTypeCode(String typeCd) {
        info("findByBailiffTaskStatusTypeCode() start ");
        TypedQuery<BlfTaskStatusType> query = getEntityManager().createNamedQuery(QUERY_SEQ_BYCD,
                BlfTaskStatusType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        query.setParameter(PARAM_BLFTASK_STATUS_CD, typeCd);
        query.setMaxResults(1);
        return getSingleResult(query);
    }
}
