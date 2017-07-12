package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import hk.judiciary.icms.model.dao.entity.BlfAssign;
import hk.judiciary.icms.model.dao.entity.IntlUserAc;
import hk.judiciary.icmssvd.model.common.biz.assembler.BailiffOfficeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.BailiffStaffPostDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.BailiffAssignedDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.IntlUserAcDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class BailiffAssignedDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param BlfAssign
     *            entity
     * @return BailiffAssignedDTO
     */
    public static BailiffAssignedDTO toDto(BlfAssign blfAssign) {
        BailiffAssignedDTO dto = new BailiffAssignedDTO();
        if (blfAssign != null && blfAssign.getBlfAssignId() != null
                && blfAssign.getBlfAssignId() != 0) {
            dto.setBailiffAssignedId(blfAssign.getBlfAssignId());
            IntlUserAcDTO intlUserAcDTO = new IntlUserAcDTO();
            IntlUserAc intlUserAc = blfAssign.getIntlUserAc();
            if (intlUserAc != null) {
                intlUserAcDTO.setIntlUserAcId(intlUserAc.getIntlUserAcId());
                intlUserAcDTO.setLoginName(DbCommonUtil.getDbValueOrEmpty(intlUserAc.getLoginName()));
                intlUserAcDTO.setEnglishSurname(DbCommonUtil.getDbValueOrEmpty(intlUserAc.getSurname()));
                intlUserAcDTO.setEnglishGivenName(DbCommonUtil.getDbValueOrEmpty(intlUserAc
                        .getGivenName()));
                intlUserAcDTO.setChineseSurname(DbCommonUtil.getDbValueOrEmpty(intlUserAc
                        .getSurnameChin()));
                intlUserAcDTO.setChineseGivenName(DbCommonUtil.getDbValueOrEmpty(intlUserAc
                        .getGivenNameChin()));
                intlUserAcDTO.setVersionAndNanos(intlUserAc.getVersion());
            }
            dto.setIntlUserAc(intlUserAcDTO);
            dto.setBailiffStaffPost(BailiffStaffPostDTOAssembler.toDto(blfAssign
                    .getBlfStaffPostType()));
            dto.setBailiffOffice(BailiffOfficeDTOAssembler.toDto(blfAssign.getBlfOffice()));
            dto.setVersionAndNanos(blfAssign.getVersion());
        }
        return dto;
    }
}
