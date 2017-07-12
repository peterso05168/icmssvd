package hk.judiciary.icmssvd.model.exeReq.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ExecReqs;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class ExecutionRequestDAO extends BaseDAO<ExecReqs> {
    public static final String EXECUTION_REQUEST_DAO = "executionRequestDAO";

    private static final String QUERY_EXECREQS = "ExecReqs.findExecutionRequest";

    private static final String PARAM_REQS_ID = "reqsId";

    public ExecReqs findExecutionRequest(Integer reqsId) {
        info("findExecutionRequest() start ");
        ExecReqs execReqs = null;
        TypedQuery<ExecReqs> query = getEntityManager().createNamedQuery(QUERY_EXECREQS,
                ExecReqs.class);
        query.setParameter(PARAM_REQS_ID, reqsId);
        List<ExecReqs> list = getResultList(query);
        if (!CommonUtil.isNullOrEmpty(list)) {
            execReqs = list.get(0);
        }
        return execReqs;
    }
}
