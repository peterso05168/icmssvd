package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ReqsAddr;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.biz.assembler.BailiffOfficeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.HkDistrictDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.HkRegionDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestAddressDTO;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestAddressDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqsAddr
     *            entity
     * @return RequestAddressDTO
     */
    public static RequestAddressDTO toDto(ReqsAddr reqsAddr) {
        RequestAddressDTO dto = new RequestAddressDTO();
        if (reqsAddr != null && reqsAddr.getReqsAddrId() != null && reqsAddr.getReqsAddrId() != 0) {
            dto.setRequestAddressId(reqsAddr.getReqsAddrId());
            if (reqsAddr.getReqs() != null) {
                dto.setRequestId(reqsAddr.getReqs().getReqsId());
            }
            dto.setEnglishAddress1(DbCommonUtil.getDbValueOrEmpty(reqsAddr.getAddrLine1()));
            dto.setEnglishAddress2(DbCommonUtil.getDbValueOrEmpty(reqsAddr.getAddrLine2()));
            dto.setEnglishAddress3(DbCommonUtil.getDbValueOrEmpty(reqsAddr.getAddrLine3()));
            dto.setChineseAddress1(DbCommonUtil.getDbValueOrEmpty(reqsAddr.getAddrLine1Chin()));
            dto.setChineseAddress2(DbCommonUtil.getDbValueOrEmpty(reqsAddr.getAddrLine2Chin()));
            dto.setChineseAddress3(DbCommonUtil.getDbValueOrEmpty(reqsAddr.getAddrLine3Chin()));
            if (CommonConstant.COMMON_FLAG_TRUE.equals(reqsAddr.getPriAddrFlag())) {
                dto.setPrimaryAddressInd(true);
            } else {
                dto.setPrimaryAddressInd(false);
            }
            if (CommonConstant.COMMON_FLAG_TRUE.equals(reqsAddr.getActAddrFlag())) {
                dto.setActionAddressInd(true);
            } else {
                dto.setActionAddressInd(false);
            }
            if (CommonConstant.COMMON_FLAG_TRUE.equals(reqsAddr.getFgnAddrFlag())) {
                dto.setForeignAddressInd(true);
            } else {
                dto.setForeignAddressInd(false);
            }
            dto.setBailiffOffice(BailiffOfficeDTOAssembler.toDto(reqsAddr.getBlfOffice()));
            dto.setHkDistrict(HkDistrictDTOAssembler.toDto(reqsAddr.getHkDist()));
            dto.setHkRegion(HkRegionDTOAssembler.toDto(reqsAddr.getHkRgn()));
            dto.setVersionAndNanos(reqsAddr.getVersion());
        }
        return dto;
    }

    public static RequestAddressDTO toDto(List<ReqsAddr> reqsAddrs) {
        RequestAddressDTO dto = new RequestAddressDTO();
        if (!CommonUtil.isNullOrEmpty(reqsAddrs)) {
            ReqsAddr priReqsAddr = null;
            for (ReqsAddr reqsAddr : reqsAddrs) {
                if (CommonConstant.COMMON_FLAG_TRUE.equals(reqsAddr.getPriAddrFlag())) {
                    priReqsAddr = reqsAddr;
                    break;
                }
            }
            if (priReqsAddr != null && priReqsAddr.getReqsAddrId() != null
                    && priReqsAddr.getReqsAddrId() != 0) {
                dto = toDto(priReqsAddr);
            }
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param reqsAddrs
     *            List of Entity
     * @return list of RequestAddressDTO
     */
    public static List<RequestAddressDTO> toDtoList(List<ReqsAddr> reqsAddres) {
        List<RequestAddressDTO> dtos = new ArrayList<RequestAddressDTO>();
        if (!CommonUtil.isNullOrEmpty(reqsAddres)) {
            for (ReqsAddr reqsAddr : reqsAddres) {
                dtos.add(toDto(reqsAddr));
            }
        }
        return dtos;
    }
}
