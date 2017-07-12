package hk.judiciary.icmssvd.model.common.dao;

import javax.persistence.TypedQuery;

import hk.judiciary.fmk.common.security.user.InternalUserPropertiesConstant;
import hk.judiciary.icms.model.dao.entity.IntlUserAc;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class IntlUserAcDAO extends BaseDAO<IntlUserAc> {
    public static final String INTL_USERAC_DAO = "intlUserAcDAO";

    private static final String QUERY_BY_LOGINNAME = "IntlUserAc.findInternalLoginUser";

    private static final String PARAM_LOGIN_NAME = "loginName";

    public IntlUserAc findInternalLoginUser() {
        info("findInternalLoginUser() start ");
        TypedQuery<IntlUserAc> query = getEntityManager().createNamedQuery(QUERY_BY_LOGINNAME,
                IntlUserAc.class);
//        query.setParameter(PARAM_LOGIN_NAME, this.getJudiciaryUser().getLoginName());
        query.setParameter(
                PARAM_LOGIN_NAME,
                this.getJudiciaryUser().getInternalUserProperty(
                        InternalUserPropertiesConstant.LOGIN_NAME));
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        return getSingleResult(query);
    }
}
