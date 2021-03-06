package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.HkRgn;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class HkRegionDAO extends BaseDAO<HkRgn> {
    public static final String HK_RGN_DAO = "hkRegionDAO";

    private static final String QUERY_LIST = "HkRgn.findHkRegionList";

    public List<HkRgn> findHkRegionList() {
        info("findHkRegionList() start ");
        TypedQuery<HkRgn> query = getEntityManager().createNamedQuery(QUERY_LIST, HkRgn.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<HkRgn> list = getResultList(query);
        return list;
    }
}
