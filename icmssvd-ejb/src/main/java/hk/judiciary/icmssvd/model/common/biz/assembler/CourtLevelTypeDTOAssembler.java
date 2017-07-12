package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtLevelTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class CourtLevelTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param courtLvlType
     *            entity
     * @return CourtLevelTypeDTO
     */
    public static CourtLevelTypeDTO toDto(CourtLvlType courtLvlType) {
        CourtLevelTypeDTO dto = new CourtLevelTypeDTO();
        if (courtLvlType != null && courtLvlType.getCourtLvlTypeId() != null
                && courtLvlType.getCourtLvlTypeId() != 0) {
            dto.setCourtLevelTypeId(courtLvlType.getCourtLvlTypeId());
            dto.setCourtLevelTypeCode(DbCommonUtil.getDbValueOrEmpty(courtLvlType.getCourtLvlTypeCd()));
            dto.setCourtLevelTypeName(DbCommonUtil.getDbValueOrEmpty(courtLvlType.getCourtLvlTypeDesc()));
            dto.setVersionAndNanos(courtLvlType.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param courtLvlTypes
     *            List of Entity
     * @return list of CourtLevelTypeDTO
     */
    public static List<CourtLevelTypeDTO> toDtoList(List<CourtLvlType> courtLvlTypes) {
        List<CourtLevelTypeDTO> dtos = new ArrayList<CourtLevelTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(courtLvlTypes)) {
            for (CourtLvlType courtLvlType : courtLvlTypes) {
                dtos.add(toDto(courtLvlType));
            }
        }
        return dtos;
    }
}
