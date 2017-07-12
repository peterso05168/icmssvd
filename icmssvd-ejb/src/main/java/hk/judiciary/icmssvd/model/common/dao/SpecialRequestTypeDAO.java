package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.SpecialReqsType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class SpecialRequestTypeDAO extends BaseDAO<SpecialReqsType> {
    public static final String SPECIAL_REQS_TYPE_DAO = "specialRequestTypeDAO";

    private static final String QUERY_LIST = "SpecialReqsType.findSpecialRequestTypeList";
    private static final String QUERY_BY_CODE = "SpecialReqsType.findBySpecialRequestTypeCode";

    private static final String PARAM_SPECIAL_REQSTYPE_CD = "specialReqsTypeCd";

    public SpecialReqsType findBySpecialRequestTypeCode(String code) {
        info("findBySpecialRequestTypeCode() start " + code);
        TypedQuery<SpecialReqsType> query = getEntityManager().createNamedQuery(QUERY_BY_CODE,
                SpecialReqsType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        query.setParameter(PARAM_SPECIAL_REQSTYPE_CD, code);
        return getSingleResult(query);
    }

    public List<SpecialReqsType> findSpecialRequestTypeList() {
        info("findSpecialRequestTypeList() start ");
        TypedQuery<SpecialReqsType> query = getEntityManager().createNamedQuery(QUERY_LIST,
                SpecialReqsType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<SpecialReqsType> list = getResultList(query);
        return list;
    }
}
