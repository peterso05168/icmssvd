package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.CompsCourt;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icmssvd.model.common.biz.dto.ComprisingCourtDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;

/**
 * 
 * @version $Revision: 5748 $ $Date: 2017-03-24 17:54:18 +0800 (週五, 24 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class ComprisingCourtDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param compsCourt
     *            entity
     * @return ComprisingCourtDTO
     */
    public static ComprisingCourtDTO toDto(CompsCourt compsCourt) {
        ComprisingCourtDTO dto = new ComprisingCourtDTO();
        if (compsCourt != null && DbCommonUtil.isValidDbId(compsCourt.getCompsCourtId())) {
            dto.setComprisingCourtId(compsCourt.getCompsCourtId());
            dto.setComprisingCourtCode(DbCommonUtil.getDbValueOrEmpty(compsCourt.getCompsCourtCd()));
            dto.setComprisingCourtName(DbCommonUtil.getDbValueOrEmpty(compsCourt
                    .getCompsCourtDesc()));
            dto.setComprisingCourtPrefix(DbCommonUtil.getDbValueOrEmpty(compsCourt
                    .getCompsCourtPrfx()));
            dto.setCourtLevelType(CourtLevelTypeDTOAssembler.toDto(compsCourt.getCourtLvlType()));
            dto.setCourtVenue(CourtVenueDTOAssembler.toDto(compsCourt.getCourtVenue()));
            dto.setVersionAndNanos(compsCourt.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param compsCourts
     *            List of Entity
     * @return list of ComprisingCourtDTO
     */
    public static List<ComprisingCourtDTO> toDtoList(List<CompsCourt> compsCourts,
            FunctionDTO function) {
        List<ComprisingCourtDTO> dtos = new ArrayList<ComprisingCourtDTO>();
        if (!CommonUtil.isNullOrEmpty(compsCourts)) {
            for (CompsCourt compsCourt : compsCourts) {
                CourtLvlType courtLvlType = compsCourt.getCourtLvlType();
                if (courtLvlType != null
                        && courtLvlType.getCourtLvlTypeCd()
                                .equals(function.getCourtLevelTypeCode())) {
                    dtos.add(toDto(compsCourt));
                }
            }
        }
        return dtos;
    }
}
