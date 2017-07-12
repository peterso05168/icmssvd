package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.Doc;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class DocDAO extends BaseDAO<Doc> {
    public static final String DOC_DAO = "docDAO";

    private static final String QUERY_BY_CASE_ID = "Doc.findDocByCaseId";

    private static final String PARAM_CASE_ID = "caseId";

    public List<Doc> findDocByCaseId(Integer caseId) {
        info("findDocByCaseId() start ");
        TypedQuery<Doc> query = getEntityManager().createNamedQuery(QUERY_BY_CASE_ID, Doc.class);
        query.setParameter(PARAM_CASE_ID, caseId);
        return getResultList(query);
    }
}
