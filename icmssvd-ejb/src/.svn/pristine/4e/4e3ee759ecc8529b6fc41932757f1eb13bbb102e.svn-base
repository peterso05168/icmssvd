package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.BlfAssign;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.StaffConstant;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (Wed, 15 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffAssignedDAO extends BaseDAO<BlfAssign> {
    public static final String BAILIFF_ASSIGNED_DAO = "bailiffAssignedDAO";

    private static final String QUERY_BY_CODE = "BlfAssign.findSeniorBailiffAssignedByBailiffOfficeId";

    private static final String PARAM_BLFOFFICE_ID = "blfOfficeId";
    private static final String PARAM_BLFSTAFF_POSTTYPE_CD = "blfStaffPostTypeCd";

    public List<BlfAssign> findSeniorBailiffAssignedByBailiffOfficeId(Integer baiOffId) {
        info("findSeniorBailiffAssignedByBailiffOfficeId() start ");
        TypedQuery<BlfAssign> query = getEntityManager().createNamedQuery(QUERY_BY_CODE,
                BlfAssign.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_BLFOFFICE_ID, baiOffId);
        query.setParameter(PARAM_BLFSTAFF_POSTTYPE_CD, StaffConstant.STAFF_POST_TYPE_SB);
        List<BlfAssign> list = getResultList(query);
        return list;
    }
}
