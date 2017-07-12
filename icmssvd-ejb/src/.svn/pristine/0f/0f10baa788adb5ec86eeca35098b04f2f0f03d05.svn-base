package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.Pd;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 56 $ $Date: 2016-10-14 11:01:00 +0800 (Fri, 14 Oct 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class ProsecutionDepartmentDAO extends BaseDAO<Pd> {
    public static final String PROSECUTION_DEPARTMENT_DAO = "prosecutionDepartmentDAO";

    private static final String QUERY_GET_PROSECUTION_DEPARTMENT = "Pd.findProsecutionDepartmentList";

    private static final String PARAM_ACTIVE_FLAG = "activeFlag";
    private static final String PARAM_CURRENTDATE = "currentDate";

    /**
     * Get full list of Pd
     * 
     * @return Pd
     */
    public List<Pd> findProsecutionDepartmentList() {
        info("executing findProsecutionDepartmentList()");
        TypedQuery<Pd> query = getEntityManager().createNamedQuery(
                QUERY_GET_PROSECUTION_DEPARTMENT, Pd.class);
        query.setParameter(PARAM_CURRENTDATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        return this.getResultList(query);
    }
}
