package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.CompsCourt;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class ComprisingCourtDAO extends BaseDAO<CompsCourt> {
    public static final String COMPS_COURT_DAO = "comprisingCourtDAO";

    private static final String QUERY_LIST = "CompsCourt.findComprisingCourtList";

    public List<CompsCourt> findComprisingCourtList() {
        info("findComprisingCourtList() start ");
        TypedQuery<CompsCourt> query = getEntityManager().createNamedQuery(QUERY_LIST,
                CompsCourt.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<CompsCourt> list = getResultList(query);
        return list;
    }
}
