package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.BlfDocStatusType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (Wed, 15 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffDocumentStatusTypeDAO extends BaseDAO<BlfDocStatusType> {
    public static final String BAILIFF_DOCUMENT_STATUSTYPE_DAO = "bailiffDocumentStatusTypeDAO";

    private static final String QUERY_BY_CODE = "BlfDocStatusType.findByBailiffDocumentStatusTypeCode";

    private static final String PARAM_STATUS_TYPE_CODE = "blfDocStatusTypeCd";

    public BlfDocStatusType findByBailiffDocumentStatusTypeCode(String code) {
        info("findByBailiffDocumentStatusTypeCode() start ");
        BlfDocStatusType blfDocStatusType = null;
        TypedQuery<BlfDocStatusType> query = getEntityManager().createNamedQuery(QUERY_BY_CODE,
                BlfDocStatusType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        query.setParameter(PARAM_STATUS_TYPE_CODE, code);
        List<BlfDocStatusType> list = getResultList(query);
        if (!CommonUtil.isNullOrEmpty(list)) {
            blfDocStatusType = list.get(0);
        }
        return blfDocStatusType;
    }
}
