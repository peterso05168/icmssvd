package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.BlfTaskRsltRsn;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffTaskResultReasonDAO extends BaseDAO<BlfTaskRsltRsn> {
    public static final String BAILIFFTASK_RESULT_REASON_DAO = "bailiffTaskResultReasonDAO";

    private static final String QUERY_LIST = "BlfTaskRsltRsn.findBailiffTaskResultReasonList";

    public List<BlfTaskRsltRsn> findBailiffTaskResultReasonList() {
        info("findBailiffTaskResultReasonList() start ");
        TypedQuery<BlfTaskRsltRsn> query = getEntityManager().createNamedQuery(QUERY_LIST,
                BlfTaskRsltRsn.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<BlfTaskRsltRsn> list = getResultList(query);
        return list;
    }
}
