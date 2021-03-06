package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icms.model.dao.entity.PartcpRoleType;
import hk.judiciary.icmssvd.model.common.biz.dto.ParticipantRoleTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class ParticipantRoleTypeDTOAssembler {
    public static ParticipantRoleTypeDTO toDto(PartcpRoleType partcpRoleType) {
        ParticipantRoleTypeDTO dto = new ParticipantRoleTypeDTO();
        if (partcpRoleType != null && partcpRoleType.getPartcpRoleTypeId() != null
                && partcpRoleType.getPartcpRoleTypeId() != 0) {
            dto.setParticipantRoleTypeId(partcpRoleType.getPartcpRoleTypeId());
            dto.setParticipantRoleTypeName(partcpRoleType.getPartcpRoleTypeDesc());
            dto.setParticipantRoleTypeCode(partcpRoleType.getPartcpRoleTypeCd());
            dto.setApplicantIndicator(partcpRoleType.getApplInd());
            dto.setParticipantRoleCategory(ParticipantRoleCategoryDTOAssembler.toDto(partcpRoleType
                    .getPartcpRoleCat()));
            dto.setCourtLevelType(CourtLevelTypeDTOAssembler.toDto(partcpRoleType.getCourtLvlType()));
            dto.setCaseType(CaseTypeDTOAssembler.toDto(partcpRoleType.getCaseType()));
            dto.setVersionAndNanos(partcpRoleType.getVersion());
        }
        return dto;
    }

    public static List<ParticipantRoleTypeDTO> toDtoList(List<PartcpRoleType> partcpRoleTypes,
            FunctionDTO function) {
        List<ParticipantRoleTypeDTO> list = new ArrayList<ParticipantRoleTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(partcpRoleTypes)) {
            for (PartcpRoleType partcpRoleType : partcpRoleTypes) {
                CourtLvlType courtLvlType = partcpRoleType.getCourtLvlType();
                if (courtLvlType != null) {
                    if (courtLvlType.getCourtLvlTypeCd().equals(function.getCourtLevelTypeCode())) {
                        list.add(toDto(partcpRoleType));
                    }
                }
            }
        }
        return list;
    }
}
