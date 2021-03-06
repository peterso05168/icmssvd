package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Addr;
import hk.judiciary.icmssvd.model.common.biz.assembler.HkDistrictDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.HkRegionDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.AddressDTO;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class AddressDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param Addr
     *            entity
     * @return AddressDTO
     */
    public static AddressDTO toDto(Addr addr) {
        AddressDTO dto = new AddressDTO();
        if (addr != null && addr.getAddrId() != null && addr.getAddrId() != 0) {
            dto.setAddressId(addr.getAddrId());
            dto.setEnglishAddress1(DbCommonUtil.getDbValueOrEmpty(addr.getAddrLine1()));
            dto.setEnglishAddress2(DbCommonUtil.getDbValueOrEmpty(addr.getAddrLine2()));
            dto.setEnglishAddress3(DbCommonUtil.getDbValueOrEmpty(addr.getAddrLine3()));
            dto.setChineseAddress1(DbCommonUtil.getDbValueOrEmpty(addr.getAddrLine1Chin()));
            dto.setChineseAddress2(DbCommonUtil.getDbValueOrEmpty(addr.getAddrLine2Chin()));
            dto.setChineseAddress3(DbCommonUtil.getDbValueOrEmpty(addr.getAddrLine3Chin()));
            dto.setHkDistrict(HkDistrictDTOAssembler.toDto(addr.getHkDist()));
            dto.setHkRegion(HkRegionDTOAssembler.toDto(addr.getRgn()));
            dto.setForeignAddressInd(CommonUtil.toBoolean(addr.getFgnAddrFlag()));
            dto.setVersionAndNanos(addr.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param Addrs
     *            List of Entity
     * @return list of AddressDTO
     */
    public static List<AddressDTO> toDtoList(List<Addr> addrs) {
        List<AddressDTO> dtos = new ArrayList<AddressDTO>();
        if (!CommonUtil.isNullOrEmpty(addrs)) {
            for (Addr addr : addrs) {
                dtos.add(toDto(addr));
            }
        }
        return dtos;
    }
}
