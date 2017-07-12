package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.SpecialReqs;
import hk.judiciary.icmssvd.model.common.biz.assembler.SpecialRequestTypeDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.SpecialRequestDTO;

/**
 * 
 * @version $Revision: 6473 $ $Date: 2017-04-24 18:09:35 +0800 (週一, 24 四月 2017) $
 * @author $Author: vicki.huang $
 */
public class SpecialRequestDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param specialReqs
     *            entity
     * @return SpecialRequestDTO
     */
    public static SpecialRequestDTO toDto(SpecialReqs specialReqs) {
        SpecialRequestDTO dto = new SpecialRequestDTO();
        if (specialReqs != null && specialReqs.getSpecialReqsId() != null
                && specialReqs.getSpecialReqsId() != 0) {
            dto.setSpecialRequestId(specialReqs.getSpecialReqsId());
            if (specialReqs.getReqs() != null) {
                dto.setRequestId(specialReqs.getReqs().getReqsId());
            }
            if (specialReqs.getSpecialReqsType() != null
                    && specialReqs.getSpecialReqsType().getSpecialReqsTypeId() != null
                    && specialReqs.getSpecialReqsType().getSpecialReqsTypeId() != 0) {
                dto.setSpecialRequestType(SpecialRequestTypeDTOAssembler.toDto(specialReqs
                        .getSpecialReqsType()));
            }
            dto.setVersionAndNanos(specialReqs.getVersion());
        }
        return dto;
    }

    public static SpecialRequestDTO toDto(List<SpecialReqs> specialReqses) {
        SpecialRequestDTO dto = null;
        if (!CommonUtil.isNullOrEmpty(specialReqses)) {
            for (SpecialReqs specialReqs : specialReqses) {
                if (specialReqs.getSpecialReqsType() != null
                        && RequestConstant.SPECIAL_REQUEST_TYPE_URGENT.equals(specialReqs
                                .getSpecialReqsType().getSpecialReqsTypeCd())) {
                    dto = toDto(specialReqs);
                }
            }
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param specialReqss
     *            List of Entity
     * @return list of SpecialRequestDTO
     */
    public static List<SpecialRequestDTO> toDtoList(List<SpecialReqs> specialReqses) {
        List<SpecialRequestDTO> dtos = new ArrayList<SpecialRequestDTO>();
        if (!CommonUtil.isNullOrEmpty(specialReqses)) {
            for (SpecialReqs specialReqs : specialReqses) {
                dtos.add(toDto(specialReqs));
            }
        }
        return dtos;
    }
}
