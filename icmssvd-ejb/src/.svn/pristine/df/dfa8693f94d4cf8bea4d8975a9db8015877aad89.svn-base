package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ListSchd;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class ListScheduleDAO extends BaseDAO<ListSchd> {
    public static final String LIST_SCHEDULE_DAO = "listScheduleDAO";

    private static final String QUERY_LATEST_LIST_SCHD = "ListSchd.findLatestListSchedule";

    private static final String PARAM_LIST_DATE = "listSchdDate";
    private static final String PARAM_STATUS = "status";

    public ListSchd findLatestListSchedule(Date date) {
        info("findLatestListSchedule() start " + date);
        ListSchd listSchd = null;
        TypedQuery<ListSchd> query = getEntityManager().createNamedQuery(QUERY_LATEST_LIST_SCHD,
                ListSchd.class);
        query.setParameter(PARAM_LIST_DATE, date);
        query.setParameter(PARAM_STATUS, CommonConstant.COMMON_STATUS_A);
        query.setMaxResults(1);
        List<ListSchd> list = getResultList(query);
        if (!CommonUtil.isNullOrEmpty(list)) {
            listSchd = list.get(0);
        }
        return listSchd;
    }
}
