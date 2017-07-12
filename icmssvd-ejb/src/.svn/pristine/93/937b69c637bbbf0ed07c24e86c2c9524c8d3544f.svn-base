package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.CompsCourt;
import hk.judiciary.icms.model.dao.entity.CourtVenue;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtVenueDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 98 $ $Date: 2016-12-02 11:24:15 +0800 (Fri, 02 Dec 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class CourtVenueDTOAssembler {
    /**
     * Copy properties from CourtVenue to CourtVenueDTO
     * 
     * @param CourtVenue
     *            The entity of the CourtVenue.
     * 
     * @return CourtVenueDTO
     */
    public static CourtVenueDTO toDto(CourtVenue courtVenue) {
        CourtVenueDTO dto = new CourtVenueDTO();
        if (courtVenue != null && DbCommonUtil.isValidDbId(courtVenue.getCourtVenueId())) {
            dto.setCourtVenueId(courtVenue.getCourtVenueId());
            dto.setCourtVenueCode(DbCommonUtil.getDbValueOrEmpty(courtVenue.getCourtVenueCd()));
            dto.setCourtVenueName(DbCommonUtil.getDbValueOrEmpty(courtVenue.getCourtVenueName()));
            dto.setCourtVenueChineseName(DbCommonUtil.getDbValueOrEmpty(courtVenue
                    .getCourtVenueNameInChinSimpl()));
            dto.setCourtVenueDescription(DbCommonUtil.getDbValueOrEmpty(courtVenue
                    .getCourtVenueDesc()));
            dto.setCourtVenueChineseDescription(DbCommonUtil.getDbValueOrEmpty(courtVenue
                    .getCourtVenueDescInChinSimpl()));
            dto.setVersionAndNanos(courtVenue.getVersion());
        }
        return dto;
    }

    /**
     * Copy properties from CourtVenue to CourtVenueDTO
     * 
     * @param CourtVenue
     *            List of CourtVenue.
     * 
     * @return The list of CourtVenueDTO
     */
    public static List<CourtVenueDTO> toDtoList(List<CourtVenue> courtVenues) {
        List<CourtVenueDTO> CourtVenueDTOList = new ArrayList<CourtVenueDTO>();
        if (!CommonUtil.isNullOrEmpty(courtVenues)) {
            for (CourtVenue courtVenue : courtVenues) {
                CourtVenueDTOList.add(toDto(courtVenue));
            }
        }
        return CourtVenueDTOList;
    }

    /**
     * Copy properties from CompsCourt to CourtVenueDetailDTO
     * 
     * @param CompsCourt
     *            The entity of the CompsCourt.
     * 
     * @return CourtVenueDetailDTO
     */
    public static CourtVenueDTO toDtos(CompsCourt compsCourt) {
        CourtVenueDTO dto = new CourtVenueDTO();
        CourtVenue courtVenue = compsCourt.getCourtVenue();
        if (!CommonUtil.isNull(courtVenue)
                && CommonConstant.COMMON_FLAG_TRUE.equals(courtVenue.getActiveFlag())) {
            dto = toDto(courtVenue);
        }
        return dto;
    }

    /**
     * Copy properties from CompsCourt to CourtVenueDetailDTO
     * 
     * @param CompsCourt
     *            List of CompsCourt.
     * 
     * @return The list of CourtVenueDetailDTO
     */
    public static List<CourtVenueDTO> toDtoLists(List<CompsCourt> compsCourts) {
        List<CourtVenueDTO> CourtVenueDetailDTOList = new ArrayList<CourtVenueDTO>();
        if (!CommonUtil.isNullOrEmpty(compsCourts)) {
            for (CompsCourt compsCourt : compsCourts) {
                if (CommonConstant.COMMON_FLAG_TRUE.equals(compsCourt.getActiveFlag())) {
                    CourtVenueDetailDTOList.add(toDtos(compsCourt));
                }
            }
        }
        return CourtVenueDetailDTOList;
    }
}
