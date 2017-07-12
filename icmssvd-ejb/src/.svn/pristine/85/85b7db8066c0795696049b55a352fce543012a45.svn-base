package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.CourtRmChmbr;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 56 $ $Date: 2016-10-14 11:01:00 +0800 (Fri, 14 Oct 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class CourtRmChmbrDAO extends BaseDAO<CourtRmChmbr> {
    public static final String COURTRMCHMBR_DAO = "courtRmChmbrDAO";

    private static final String QUERY_GET_COURT_ROOM_CHAMBERS = "CourtRmChmbr.getCourtRoomChambers";

    private static final String PARAM_ACTIVE_FLAG = "activeFlag";
    private static final String PARAM_CURRENTDATE = "currentDate";

    /**
     * Get full list of CourtRoomChamber
     * 
     * @return CourtRoomChambersDetail
     */
    public List<CourtRmChmbr> getCourtRoomChambers() {
        info("executing getCourtRoomChambers()");
        TypedQuery<CourtRmChmbr> query = getEntityManager().createNamedQuery(
                QUERY_GET_COURT_ROOM_CHAMBERS, CourtRmChmbr.class);
        query.setParameter(PARAM_CURRENTDATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        return this.getResultList(query);
    }
}
