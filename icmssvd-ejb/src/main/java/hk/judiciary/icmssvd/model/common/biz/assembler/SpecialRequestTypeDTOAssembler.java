package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.SpecialReqsType;
import hk.judiciary.icmssvd.model.common.biz.dto.SpecialRequestTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class SpecialRequestTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param specialReqsType
     *            entity
     * @return SpecialRequestTypeDTO
     */
    public static SpecialRequestTypeDTO toDto(SpecialReqsType specialReqsType) {
        SpecialRequestTypeDTO dto = new SpecialRequestTypeDTO();
        if (specialReqsType != null && specialReqsType.getSpecialReqsTypeId() != null
                && specialReqsType.getSpecialReqsTypeId() != 0) {
            dto.setSpecialRequestTypeId(specialReqsType.getSpecialReqsTypeId());
            dto.setSpecialRequestTypeName(DbCommonUtil.getDbValueOrEmpty(specialReqsType
                    .getSpecialReqsTypeDesc()));
            dto.setVersionAndNanos(specialReqsType.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param specialReqsTypes
     *            List of Entity
     * @return list of SpecialRequestTypeDTO
     */
    public static List<SpecialRequestTypeDTO> toDtoList(List<SpecialReqsType> specialReqsTypes) {
        List<SpecialRequestTypeDTO> dtos = new ArrayList<SpecialRequestTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(specialReqsTypes)) {
            for (SpecialReqsType specialReqsType : specialReqsTypes) {
                dtos.add(toDto(specialReqsType));
            }
        }
        return dtos;
    }
}
