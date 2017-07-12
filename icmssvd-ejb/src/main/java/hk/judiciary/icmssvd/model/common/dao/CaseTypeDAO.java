package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.CaseType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.CaseConstant;

/**
 * 
 * @version $Revision: 6473 $ $Date: 2017-04-24 18:09:35 +0800 (週一, 24 四月 2017) $
 * @author $Author: vicki.huang $
 */
public class CaseTypeDAO extends BaseDAO<CaseType> {
    public static final String CASE_TYPE_DAO = "caseTypeDAO";

    private static final String QUERY_LIST = "CaseType.findCaseTypeList";

    private static final String PARAM_CASE_CLASS_CD = "caseClassCd";

    public List<CaseType> findCaseTypeList() {
        info("findCaseTypeList() start ");
        TypedQuery<CaseType> query = getEntityManager()
                .createNamedQuery(QUERY_LIST, CaseType.class);
        query.setParameter(PARAM_CASE_CLASS_CD, CaseConstant.CASE_CLASS_WARRANT);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<CaseType> list = getResultList(query);
        return list;
    }
}
