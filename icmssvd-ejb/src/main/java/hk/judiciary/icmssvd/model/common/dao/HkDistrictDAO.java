package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.HkDist;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class HkDistrictDAO extends BaseDAO<HkDist> {
    public static final String HK_DISTRICT_DAO = "hkDistrictDAO";

    private static final String QUERY_LIST = "HkDist.findHkDistrictList";

    public List<HkDist> findHkDistrictList() {
        info("findHkDistrictList() start ");
        TypedQuery<HkDist> query = getEntityManager().createNamedQuery(QUERY_LIST, HkDist.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<HkDist> list = getResultList(query);
        return list;
    }
}
