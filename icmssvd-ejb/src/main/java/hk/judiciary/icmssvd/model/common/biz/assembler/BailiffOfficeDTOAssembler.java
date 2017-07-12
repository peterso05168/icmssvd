package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.BlfOffice;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffOfficeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffOfficeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param BlfOffice
     *            entity
     * @return BailiffOfficeDTO
     */
    public static BailiffOfficeDTO toDto(BlfOffice blfOffice) {
        BailiffOfficeDTO dto = new BailiffOfficeDTO();
        if (blfOffice != null && blfOffice.getBlfOfficeId() != null
                && blfOffice.getBlfOfficeId() != 0) {
            dto.setBailiffOfficeId(blfOffice.getBlfOfficeId());
            dto.setBailiffOfficeName(DbCommonUtil.getDbValueOrEmpty(blfOffice.getBlfOfficeName()));
            dto.setBailiffOfficeCode(DbCommonUtil.getDbValueOrEmpty(blfOffice.getBlfOfficeCd()));
            dto.setBailiffOfficeGroup(DbCommonUtil.getDbValueOrEmpty(blfOffice.getBlfOfficeGrp()));
            dto.setVersionAndNanos(blfOffice.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param blfOffices
     *            List of Entity
     * @return list of BailiffOfficeDTO
     */
    public static List<BailiffOfficeDTO> toDtoList(List<BlfOffice> blfOffices) {
        List<BailiffOfficeDTO> dtos = new ArrayList<BailiffOfficeDTO>();
        if (!CommonUtil.isNullOrEmpty(blfOffices)) {
            for (BlfOffice blfOffice : blfOffices) {
                dtos.add(toDto(blfOffice));
            }
        }
        return dtos;
    }
}
