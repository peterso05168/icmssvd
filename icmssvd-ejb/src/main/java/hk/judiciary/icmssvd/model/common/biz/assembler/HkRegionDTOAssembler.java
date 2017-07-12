package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.HkRgn;
import hk.judiciary.icmssvd.model.common.biz.dto.HkRegionDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class HkRegionDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param hkRgn
     *            entity
     * @return HkRegionDTO
     */
    public static HkRegionDTO toDto(HkRgn hkRgn) {
        HkRegionDTO dto = new HkRegionDTO();
        if (hkRgn != null && hkRgn.getHkRgnId() != null && hkRgn.getHkRgnId() != 0) {
            dto.setHkRegionId(hkRgn.getHkRgnId());
            dto.setHkRegionName(DbCommonUtil.getDbValueOrEmpty(hkRgn.getHkRgnName()));
            dto.setHkRegionChineseName(DbCommonUtil.getDbValueOrEmpty(hkRgn.getHkRgnNameChin()));
            dto.setHkRegionCode(DbCommonUtil.getDbValueOrEmpty(hkRgn.getHkRgnCd()));
            dto.setVersionAndNanos(hkRgn.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param hkRgns
     *            List of Entity
     * @return list of HkRegionDTO
     */
    public static List<HkRegionDTO> toDtoList(List<HkRgn> hkRgns) {
        List<HkRegionDTO> dtos = new ArrayList<HkRegionDTO>();
        if (!CommonUtil.isNullOrEmpty(hkRgns)) {
            for (HkRgn hkRgn : hkRgns) {
                dtos.add(toDto(hkRgn));
            }
        }
        return dtos;
    }
}
