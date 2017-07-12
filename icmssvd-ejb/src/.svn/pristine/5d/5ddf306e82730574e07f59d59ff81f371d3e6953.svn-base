package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.CourtRmToList;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class CourtRoomToListDAO extends BaseDAO<CourtRmToList> {
    public static final String COURTROOM_TOLIST_DAO = "courtRoomToListDAO";

    private static final String QUERY_BY_REQS_ID = "CourtRmToList.findByListSchedule";

    private static final String PARAM_LIST_ID = "listId";
    private static final String PARAM_STATUS = "status";

    public CourtRmToList findByListSchedule(Integer listId, Date hrnDate) {
        info("findByListSchedule() start " + listId + "," + hrnDate);
        CourtRmToList courtRmToList = null;
        TypedQuery<CourtRmToList> query = getEntityManager().createNamedQuery(QUERY_BY_REQS_ID,
                CourtRmToList.class);
        query.setParameter(PARAM_LIST_ID, listId);
        query.setParameter(PARAM_EFFV_START_DATE, hrnDate);
        query.setParameter(PARAM_EFFV_END_DATE, hrnDate);
        query.setParameter(PARAM_STATUS, CommonConstant.COMMON_STATUS_A);
        query.setMaxResults(1);
        List<CourtRmToList> list = getResultList(query);
        if (!CommonUtil.isNullOrEmpty(list)) {
            courtRmToList = list.get(0);
        }
        return courtRmToList;
    }
}
