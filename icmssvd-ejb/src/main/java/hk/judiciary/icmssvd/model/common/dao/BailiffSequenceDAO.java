package hk.judiciary.icmssvd.model.common.dao;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.BlfSeq;
import hk.judiciary.icmssvd.model.BaseDAO;

/**
 * 
 * @version $Revision: 7630 $ $Date: 2017-06-20 17:53:40 +0800 (週二, 20 六月 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffSequenceDAO extends BaseDAO<BlfSeq> {
    public static final String BLF_SEQ_DAO = "bailiffSequenceDAO";

    private static final String QUERY_SEQ_BYKEY = "BlfSeq.findBailiffSequenceBySequenceKey";

    private static final String PARAM_BLFSEQ_KEY = "blfSeqKey";

    public BlfSeq findBailiffSequenceBySequenceKey(String seqKey) {
        info("findBailiffSequenceBySequenceKey() start ");
        TypedQuery<BlfSeq> query = getEntityManager().createNamedQuery(QUERY_SEQ_BYKEY,
                BlfSeq.class);
        query.setParameter(PARAM_BLFSEQ_KEY, seqKey);
        query.setMaxResults(1);
        return getSingleResult(query);
    }
}
