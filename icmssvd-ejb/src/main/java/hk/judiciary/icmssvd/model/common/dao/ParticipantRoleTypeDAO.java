package hk.judiciary.icmssvd.model.common.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hk.judiciary.icms.model.dao.entity.PartcpRoleType;
import hk.judiciary.icmssvd.model.BaseDAO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class ParticipantRoleTypeDAO extends BaseDAO<PartcpRoleType> {
    public static final String PARTICIPANT_ROLE_TYPE_DAO = "participantRoleTypeDAO";

    private static final String QUERY_LIST = "PartcpRoleType.findParticipantRoleTypeList";

    public List<PartcpRoleType> findParticipantRoleTypeList() {
        info("findParticipantRoleTypeList() start ");
        TypedQuery<PartcpRoleType> query = getEntityManager().createNamedQuery(QUERY_LIST,
                PartcpRoleType.class);
        query.setParameter(PARAM_EFFV_START_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_EFFV_END_DATE, DbCommonUtil.getCurrentSystemDateTime());
        query.setParameter(PARAM_ACTIVE_FLAG, CommonConstant.COMMON_FLAG_TRUE);
        List<PartcpRoleType> list = getResultList(query);
        return list;
    }
}
