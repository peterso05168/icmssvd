package hk.judiciary.icmssvd.model.common.biz.assembler;

import hk.judiciary.icms.model.dao.entity.BlfStaffPostType;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffStaffPostDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 3291 $ $Date: 2017-01-13 16:51:17 +0800 (Fri, 13 Jan 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffStaffPostDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param BlfStaffPostType
     *            entity
     * @return BailiffStaffPostDTO
     */
    public static BailiffStaffPostDTO toDto(BlfStaffPostType blfStaffPostType) {
        BailiffStaffPostDTO dto = new BailiffStaffPostDTO();
        if (blfStaffPostType != null && blfStaffPostType.getBlfStaffPostTypeId() != null
                && blfStaffPostType.getBlfStaffPostTypeId() != 0) {
            dto.setBailiffStaffPostId(blfStaffPostType.getBlfStaffPostTypeId());
            dto.setBailiffStaffPostName(DbCommonUtil.getDbValueOrEmpty(blfStaffPostType
                    .getBlfStaffPostTypeDesc()));
            dto.setBailiffStaffPostCode(DbCommonUtil.getDbValueOrEmpty(blfStaffPostType
                    .getBlfStaffPostTypeCd()));
            dto.setVersionAndNanos(blfStaffPostType.getVersion());
        }
        return dto;
    }
}
