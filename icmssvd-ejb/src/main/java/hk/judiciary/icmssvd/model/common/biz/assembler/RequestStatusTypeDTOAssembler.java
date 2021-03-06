package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ReqsStatusType;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestStatusTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqsStatusType
     *            entity
     * @return RequestStatusDTO
     */
    public static RequestStatusTypeDTO toDto(ReqsStatusType reqsStatusType) {
        RequestStatusTypeDTO dto = new RequestStatusTypeDTO();
        if (reqsStatusType != null && reqsStatusType.getReqsStatusTypeId() != null
                && reqsStatusType.getReqsStatusTypeId() != 0) {
            dto.setRequestStatusTypeId(reqsStatusType.getReqsStatusTypeId());
            dto.setRequestStatusTypeName(DbCommonUtil.getDbValueOrEmpty(reqsStatusType
                    .getReqsStatusTypeDesc()));
            dto.setRequestStatusTypeCode(DbCommonUtil.getDbValueOrEmpty(reqsStatusType
                    .getReqsStatusTypeCd()));
            dto.setVersionAndNanos(reqsStatusType.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param reqsStatusTypes
     *            List of Entity
     * @return list of RequestStatusDTO
     */
    public static List<RequestStatusTypeDTO> toDtoList(List<ReqsStatusType> reqsStatusTypes) {
        List<RequestStatusTypeDTO> dtos = new ArrayList<RequestStatusTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(reqsStatusTypes)) {
            for (ReqsStatusType reqsStatusType : reqsStatusTypes) {
                dtos.add(toDto(reqsStatusType));
            }
        }
        return dtos;
    }
}
