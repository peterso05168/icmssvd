package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.FpAppNatType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 56 $ $Date: 2016-10-14 11:01:00 +0800 (Fri, 14 Oct 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class FpApplicationNatureTypeDAO extends BaseDAO<FpAppNatType> {
    public static final String FP_APPLICATION_NATURE_TYPE_DAO = "fpApplicationNatureTypeDAO";

    private static final String QUERY_GET_FPAPP_NATTYPE = "FpAppNatType.getFpAppNatTypes";

    private static final String PARAM_ACTIVE_FLAG = "activeFlag";
    private static final String PARAM_CURRENTDATE = "currentDate";

    /**
     * Get full list of FpAppNatType
     * 
     * @return FpAppNatType
     */
    public List<FpAppNatType> getFpAppNatTypes() {
        info("executing getCourtRoomChambers()");
        TypedQuery<FpAppNatType> query = getEntityManager().createNamedQuery(
                QUERY_GET_FPAPP_NATTYPE, FpAppNatType.class);
        query.setParameter(PARAM_CURRENTDATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        return this.getResultList(query);
    }
}
