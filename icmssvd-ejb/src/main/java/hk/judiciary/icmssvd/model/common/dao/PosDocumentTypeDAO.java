package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.ProofOfServDocType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class PosDocumentTypeDAO extends BaseDAO<ProofOfServDocType> {
    public static final String POS_DOCUMENT_TYPE_DAO = "posDocumentTypeDAO";

    private static final String QUERY_LIST = "ProofOfServDocType.findPosDocumentTypeList";

    public List<ProofOfServDocType> findPosDocumentTypeList() {
        info("findBailiffOfficeList() start ");
        TypedQuery<ProofOfServDocType> query = getEntityManager().createNamedQuery(QUERY_LIST,
                ProofOfServDocType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<ProofOfServDocType> list = getResultList(query);
        return list;
    }
}
