package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ServModeType;
import hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class ServiceModeTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param servModeType
     *            entity
     * @return ServiceModeTypeDTO
     */
    public static ServiceModeTypeDTO toDto(ServModeType servModeType) {
        ServiceModeTypeDTO dto = new ServiceModeTypeDTO();
        if (servModeType != null && servModeType.getServModeTypeId() != null
                && servModeType.getServModeTypeId() != 0) {
            dto.setServiceModeTypeId(servModeType.getServModeTypeId());
            dto.setServiceModeTypeCode(DbCommonUtil.getDbValueOrEmpty(servModeType.getServModeTypeCd()));
            dto.setServiceModeTypeName(DbCommonUtil.getDbValueOrEmpty(servModeType.getServModeTypeDesc()));
            dto.setVersionAndNanos(servModeType.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param servModeTypes
     *            List of Entity
     * @return list of ServiceModeTypeDTO
     */
    public static List<ServiceModeTypeDTO> toDtoList(List<ServModeType> servModeTypes) {
        List<ServiceModeTypeDTO> dtos = new ArrayList<ServiceModeTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(servModeTypes)) {
            for (ServModeType servModeType : servModeTypes) {
                dtos.add(toDto(servModeType));
            }
        }
        return dtos;
    }
}
