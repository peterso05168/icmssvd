package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.CaseType;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;

/**
 * 
 * @version $Revision: 5748 $ $Date: 2017-03-24 17:54:18 +0800 (週五, 24 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class CaseTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param CaseType
     *            entity
     * @return CaseTypeDTO
     */
    public static CaseTypeDTO toDto(CaseType caseType) {
        CaseTypeDTO dto = new CaseTypeDTO();
        if (caseType != null && caseType.getCaseTypeId() != null && caseType.getCaseTypeId() != 0) {
            dto.setCaseTypeId(caseType.getCaseTypeId());
            dto.setCaseTypeCode(DbCommonUtil.getDbValueOrEmpty(caseType.getCaseTypeCd()));
            dto.setCaseTypeName(DbCommonUtil.getDbValueOrEmpty(caseType.getCaseTypeDesc()));
            dto.setCourtLevelType(CourtLevelTypeDTOAssembler.toDto(caseType.getCourtLvlType()));
            dto.setVersionAndNanos(caseType.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param CaseTypes
     *            List of Entity
     * @return list of CaseTypeDTO
     */
    public static List<CaseTypeDTO> toDtoList(List<CaseType> caseTypes, FunctionDTO function) {
        List<CaseTypeDTO> dtos = new ArrayList<CaseTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(caseTypes)) {
            for (CaseType caseType : caseTypes) {
                CourtLvlType courtLvlType = caseType.getCourtLvlType();
                if (courtLvlType != null
                        && courtLvlType.getCourtLvlTypeCd()
                                .equals(function.getCourtLevelTypeCode())) {
                    dtos.add(toDto(caseType));
                }
            }
        }
        return dtos;
    }
}
