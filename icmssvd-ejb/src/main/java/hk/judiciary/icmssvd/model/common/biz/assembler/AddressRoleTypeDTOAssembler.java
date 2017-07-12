package hk.judiciary.icmssvd.model.common.biz.assembler;

import hk.judiciary.icms.model.dao.entity.AddrRoleType;
import hk.judiciary.icmssvd.model.common.biz.dto.AddressRoleTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (Wed, 15 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class AddressRoleTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param AddrRoleType
     *            entity
     * @return AddressRoleTypeDTO
     */
    public static AddressRoleTypeDTO toDto(AddrRoleType addrRoleType) {
        AddressRoleTypeDTO dto = new AddressRoleTypeDTO();
        if (addrRoleType != null && DbCommonUtil.isValidDbId(addrRoleType.getAddrRoleTypeId())) {
            dto.setAddressRoleTypeId(addrRoleType.getAddrRoleTypeId());
            dto.setAddressRoleTypeCode(DbCommonUtil.getDbValueOrEmpty(addrRoleType
                    .getAddrRoleTypeCd()));
            dto.setAddressRoleTypeName(DbCommonUtil.getDbValueOrEmpty(addrRoleType
                    .getAddrRoleTypeDesc()));
            dto.setVersionAndNanos(addrRoleType.getVersion());
        }
        return dto;
    }
}
