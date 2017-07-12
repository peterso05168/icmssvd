package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ReqsType;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqsType
     *            entity
     * @return RequestTypeDTO
     */
    public static RequestTypeDTO toDto(ReqsType reqsType) {
        RequestTypeDTO dto = new RequestTypeDTO();
        if (reqsType != null && reqsType.getReqsTypeId() != null && reqsType.getReqsTypeId() != 0) {

            dto.setRequestTypeId(reqsType.getReqsTypeId());
            dto.setRequestTypeName(DbCommonUtil.getDbValueOrEmpty(reqsType.getReqsTypeDesc()));
            dto.setVersionAndNanos(reqsType.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param reqsTypes
     *            List of Entity
     * @return list of RequestTypeDTO
     */
    public static List<RequestTypeDTO> toDtoList(List<ReqsType> reqsTypes) {
        List<RequestTypeDTO> dtos = new ArrayList<RequestTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(reqsTypes)) {
            for (ReqsType reqsType : reqsTypes) {
                dtos.add(toDto(reqsType));
            }
        }
        return dtos;
    }
}
