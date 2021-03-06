package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.HandlingAgt;
import hk.judiciary.icmssvd.model.common.biz.dto.HandlingAgentDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;

/**
 * 
 * @version $Revision: 6473 $ $Date: 2017-04-24 18:09:35 +0800 (週一, 24 四月 2017) $
 * @author $Author: vicki.huang $
 */
public class HandlingAgentDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param handlingAgt
     *            entity
     * @return HandlingAgentDTO
     */
    public static HandlingAgentDTO toDto(HandlingAgt handlingAgt) {
        HandlingAgentDTO dto = new HandlingAgentDTO();
        if (handlingAgt != null && handlingAgt.getHandlingAgtId() != null
                && handlingAgt.getHandlingAgtId() != 0) {
            dto.setHandlingAgentId(handlingAgt.getHandlingAgtId());
            dto.setHandlingAgentCode(DbCommonUtil.getDbValueOrEmpty(handlingAgt.getHandlingAgtCd()));
            dto.setHandlingAgentName(DbCommonUtil.getDbValueOrEmpty(handlingAgt.getHandlingAgtDesc()));
            dto.setVersionAndNanos(handlingAgt.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param handlingAgts
     *            List of Entity
     * @return list of HandlingAgentDTO
     */
    public static List<HandlingAgentDTO> toDtoList(List<HandlingAgt> handlingAgts,
            FunctionDTO function) {
        List<HandlingAgentDTO> dtos = new ArrayList<HandlingAgentDTO>();
        if (!CommonUtil.isNullOrEmpty(handlingAgts)) {
            for (HandlingAgt handlingAgt : handlingAgts) {
                if (RequestConstant.COURT_LEVEL_TYPE_MAGISTRATES.equals(function
                        .getCourtLevelTypeCode())
                        || RequestConstant.HANDLING_AGENT_BAILIFF.equals(handlingAgt
                                .getHandlingAgtCd())) {
                    dtos.add(toDto(handlingAgt));
                }
            }
        }
        return dtos;
    }
}
