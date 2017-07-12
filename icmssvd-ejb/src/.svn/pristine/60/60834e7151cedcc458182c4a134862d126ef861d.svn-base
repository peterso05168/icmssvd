package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.CompsCourt;
import hk.judiciary.icms.model.dao.entity.CourtRmChmbr;
import hk.judiciary.icms.model.dao.entity.CourtVenue;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtRoomChambersDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtVenueDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 90 $ $Date: 2016-11-11 11:34:12 +0800 (Fri, 11 Nov 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class CourtRoomChambersDTOAssembler {
    /**
     * Copy properties from courtRmChmbr to CourtRoomChambersDTO
     * 
     * @param courtRmChmbr
     *            The entity of the courtRmChmbr.
     * 
     * @return CourtRoomChambersDTO
     */
    public static CourtRoomChambersDTO toDto(CourtRmChmbr courtRmChmbr) {
        CourtRoomChambersDTO dto = new CourtRoomChambersDTO();
        if (courtRmChmbr != null && DbCommonUtil.isValidDbId(courtRmChmbr.getCourtRmChmbrId())) {
            dto.setCourtRoomChambersId(courtRmChmbr.getCourtRmChmbrId());
            dto.setCourtRoomChambersName(DbCommonUtil.getDbValueOrEmpty(courtRmChmbr.getName()));
            dto.setFloor(DbCommonUtil.getDbValueOrEmpty(courtRmChmbr.getFl()));

            CourtVenue courtVenue = courtRmChmbr.getCourtVenue();
            if (courtVenue != null) {
                if (CommonConstant.COMMON_FLAG_TRUE.equals(courtVenue.getActiveFlag())) {
                    dto.setCourtVenue(CourtVenueDTOAssembler.toDto(courtVenue));
                }
                List<CompsCourt> compsCourts = courtVenue.getCompsCourt();
                for (CompsCourt compsCourt : compsCourts) {
                    if (CommonConstant.COMMON_FLAG_TRUE.equals(compsCourt.getActiveFlag())) {
                        CourtVenueDTO courtVenueDTO = CourtVenueDTOAssembler.toDtos(compsCourt);
                        dto.setCourtVenue(courtVenueDTO);
                        break;
                    }
                }
            }
            dto.setVersionAndNanos(courtRmChmbr.getVersion());
        }
        return dto;
    }

    /**
     * Copy properties from courtRmChmbr to CourtRoomChambersDTO
     * 
     * @param CourtRmChmbr
     *            List of CourtRmChmbr.
     * 
     * @return The list of CourtRoomChambersDTO
     */
    public static List<CourtRoomChambersDTO> toDtoList(List<CourtRmChmbr> courtRmChmbrs) {
        List<CourtRoomChambersDTO> CourtRoomChambersDTOList = new ArrayList<CourtRoomChambersDTO>();
        if (!CommonUtil.isNullOrEmpty(courtRmChmbrs)) {
            for (CourtRmChmbr courtRmChmbr : courtRmChmbrs) {
                CourtRoomChambersDTOList.add(toDto(courtRmChmbr));
            }
        }
        return CourtRoomChambersDTOList;
    }

}
