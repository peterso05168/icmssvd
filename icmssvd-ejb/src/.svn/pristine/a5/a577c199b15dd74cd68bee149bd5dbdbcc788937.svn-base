package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.Date;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class HearingScheduleDAO extends BaseDAO<HrnSchd> {
    public static final String HEARING_SCHEDULE_DAO = "hearingScheduleDAO";

    private static final String QUERY_LATEST_HRN_SCHD = "HrnSchd.findLatestHearingSchedule";

    private static final String PARAM_CASE_ID = "caseId";
    private static final String PARAM_HRN_DATE = "hrnSchdDate";
    private static final String PARAM_STATUS = "status";

    public HrnSchd findLatestHearingSchedule(Integer caseId, Date date) {
        info("findLatestHearingSchedule() start " + caseId + "," + date);
        TypedQuery<HrnSchd> query = getEntityManager().createNamedQuery(QUERY_LATEST_HRN_SCHD,
                HrnSchd.class);
        query.setParameter(PARAM_CASE_ID, caseId);
        query.setParameter(PARAM_HRN_DATE, date);
        query.setParameter(PARAM_STATUS, CommonConstant.COMMON_STATUS_I);
        query.setMaxResults(1);
        return getSingleResult(query);
    }
}
