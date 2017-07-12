package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.HkDist;
import hk.judiciary.icms.model.dao.entity.HkRgn;
import hk.judiciary.icmssvd.model.common.biz.dto.HkDistrictDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class HkDistrictDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param hkDist
     *            entity
     * @return HkDistrictDTO
     */
    public static HkDistrictDTO toDto(HkDist hkDist) {
        HkDistrictDTO dto = new HkDistrictDTO();
        if (hkDist != null && hkDist.getHkDistId() != null && hkDist.getHkDistId() != 0) {
            dto.setHkDistrictId(hkDist.getHkDistId());
            dto.setHkDistrictName(DbCommonUtil.getDbValueOrEmpty(hkDist.getHkDistName()));
            dto.setHkDistrictChineseName(DbCommonUtil.getDbValueOrEmpty(hkDist.getHkDistNameChin()));
            dto.setHkDistrictCode(DbCommonUtil.getDbValueOrEmpty(hkDist.getHkDistCd()));
            HkRgn rgn = hkDist.getRgn();
            if (rgn != null && rgn.getHkRgnId() != null && rgn.getHkRgnId() != 0) {
                dto.setHkRegion(HkRegionDTOAssembler.toDto(rgn));
            }
            dto.setVersionAndNanos(hkDist.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param hkDists
     *            List of Entity
     * @return list of HkDistrictDTO
     */
    public static List<HkDistrictDTO> toDtoList(List<HkDist> hkDists) {
        List<HkDistrictDTO> dtos = new ArrayList<HkDistrictDTO>();
        if (!CommonUtil.isNullOrEmpty(hkDists)) {
            for (HkDist hkDist : hkDists) {
                dtos.add(toDto(hkDist));
            }
        }
        return dtos;
    }
}
