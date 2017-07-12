package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.AddrRole;
import hk.judiciary.icmssvd.model.common.biz.assembler.AddressRoleTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.AddressRoleDTO;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (Wed, 15 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class AddressRoleDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param AddrRole
     *            entity
     * @return AddressRoleDTO
     */
    public static AddressRoleDTO toDto(AddrRole addrRole) {
        AddressRoleDTO dto = new AddressRoleDTO();
        if (addrRole != null && DbCommonUtil.isValidDbId(addrRole.getAddrRoleId())) {
            dto.setAddressRoleId(addrRole.getAddrRoleId());
            dto.setAddress(AddressDTOAssembler.toDto(addrRole.getAddr()));
            dto.setAddressRoleType(AddressRoleTypeDTOAssembler.toDto(addrRole.getAddrRoleType()));
            dto.setAddressSequenceNo(addrRole.getAddrSeqNo());
            // Confirmed with JUD. If the flag is null or empty, set the value is TRUE
            if (CommonUtil.isNullOrEmpty(addrRole.getPostalServFlag())) {
            	dto.setPostalServiceInd(true);
            } else {
            	dto.setPostalServiceInd(CommonUtil.toBoolean(addrRole.getPostalServFlag()));
            }
            if (CommonUtil.isNullOrEmpty(addrRole.getPersonServFlag())) {
            	dto.setPersonalServiceInd(true);
            } else {
            	dto.setPersonalServiceInd(CommonUtil.toBoolean(addrRole.getPersonServFlag()));
            }
            if (CommonUtil.isNullOrEmpty(addrRole.getExecServFlag())) {
            	dto.setExecutionServiceInd(true);
            } else {
            	dto.setExecutionServiceInd(CommonUtil.toBoolean(addrRole.getExecServFlag()));
            }
            dto.setVersionAndNanos(addrRole.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param AddrRoles
     *            List of Entity
     * @return list of AddressRoleDTO
     */
    public static List<AddressRoleDTO> toDtoList(List<AddrRole> addrRoles) {
        List<AddressRoleDTO> dtos = new ArrayList<AddressRoleDTO>();
        if (!CommonUtil.isNullOrEmpty(addrRoles)) {
            for (AddrRole addrRole : addrRoles) {
                dtos.add(toDto(addrRole));
            }
        }
        return dtos;
    }
}
