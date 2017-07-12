package hk.judiciary.icmssvd.model.svdReq.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.StnceOrdrToDoc;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class SentenceOrderToDocumentDAO extends BaseDAO<StnceOrdrToDoc> {
    public static final String SENTENCE_ORDERTODOCUMENT_DAO = "sentenceOrderToDocumentDAO";

    private static final String QUERY_BY_REQS_ID = "StnceOrdrToDoc.findSentenceOrderToDocumentBySentenceOrderId";

    private static final String PARAM_STNCE_ORDR_TODOC_ID = "stnceOrdrToDocId";

    public StnceOrdrToDoc findSentenceOrderToDocumentBySentenceOrderId(Integer ordrId) {
        info("findSentenceOrderToDocumentBySentenceOrderId() start " + ordrId);
        StnceOrdrToDoc stnceOrdrToDoc = null;
        TypedQuery<StnceOrdrToDoc> query = getEntityManager().createNamedQuery(QUERY_BY_REQS_ID,
                StnceOrdrToDoc.class);
        query.setParameter(PARAM_STNCE_ORDR_TODOC_ID, ordrId);
        List<StnceOrdrToDoc> resultList = getResultList(query);
        if (!CommonUtil.isNullOrEmpty(resultList)) {
            stnceOrdrToDoc = resultList.get(0);
        }
        return stnceOrdrToDoc;
    }
}
