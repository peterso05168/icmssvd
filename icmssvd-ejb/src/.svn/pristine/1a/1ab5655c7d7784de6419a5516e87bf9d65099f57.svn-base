package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.SummonNoti;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class SummonsNoticeDAO extends BaseDAO<SummonNoti> {
    public static final String SUMMONS_NOTICE_DAO = "summonsNoticeDAO";

    private static final String QUERY_BY_CASE_ID = "SummonNoti.findSummonsNoticeByCaseId";

    private static final String PARAM_CASE_ID = "caseId";

    public SummonNoti findSummonsNoticeByCaseId(Integer caseId) {
        info("findSummonsNoticeByCaseId() start " + caseId);
        SummonNoti returnVal = null;
        TypedQuery<SummonNoti> query = getEntityManager().createNamedQuery(QUERY_BY_CASE_ID,
                SummonNoti.class);
        query.setParameter(PARAM_CASE_ID, caseId);
        List<SummonNoti> list = getResultList(query);
        if (!CommonUtil.isNullOrEmpty(list)) {
            returnVal = list.get(0);
        }
        return returnVal;
    }
}
