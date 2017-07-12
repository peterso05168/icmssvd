package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icmssvd.model.common.biz.assembler.BailiffOfficeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.HandlingAgentDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestStatusTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqs
     *            entity
     * @return RequestDTO
     */
    public static RequestDTO toDto(Reqs reqs) {
        RequestDTO dto = new RequestDTO();
        if (reqs != null && reqs.getReqsId() != null && reqs.getReqsId() != 0) {
            dto.setRequestId(reqs.getReqsId());
            dto.setRegistrationNo(reqs.getRegNo());
            if (reqs.getVcase() != null) {
                Case vCase = reqs.getVcase();
                dto.setCaseId(vCase.getCaseId());
                if (vCase.getCompsCourt() != null) {
                    dto.setCaseCourtSystem(DbCommonUtil.getDbValueOrEmpty(vCase.getCompsCourt()
                            .getCompsCourtCd()));
                }
                if (vCase.getCaseType() != null) {
                    dto.setCaseType(DbCommonUtil.getDbValueOrEmpty(vCase.getCaseType().getCaseTypeCd()));
                }

                dto.setCaseSerialNo(vCase.getCaseSerNo());
                dto.setCaseYear(vCase.getCaseYr());
                dto.setCaseNo(SvdCommonUtil.getCaseNo(vCase));
            }
            dto.setRequestType(RequestTypeDTOAssembler.toDto(reqs.getReqsType()));
            dto.setRegistrationYear(reqs.getRegYr());
            dto.setRegistrationSerialNo(DbCommonUtil.getDbValueOrEmpty(reqs.getRegSerNo()));
            dto.setSubmissionDatetime(reqs.getSubmitDt());
            dto.setSequenceNoForCase(reqs.getSeqNoForCase());
            dto.setHandlingAgent(HandlingAgentDTOAssembler.toDto(reqs.getHandlingAgt()));
            dto.setRequestStatusType(RequestStatusTypeDTOAssembler.toDto(reqs.getReqsStatus()));
            dto.setBailiffOffice(BailiffOfficeDTOAssembler.toDto(reqs.getBlfOffice()));
            dto.setVersionAndNanos(reqs.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param reqss
     *            List of Entity
     * @return list of RequestDTO
     */
    public static List<RequestDTO> toDtoList(List<Reqs> reqses) {
        List<RequestDTO> dtos = new ArrayList<RequestDTO>();
        if (!CommonUtil.isNullOrEmpty(reqses)) {
            for (Reqs reqs : reqses) {
                dtos.add(toDto(reqs));
            }
        }
        return dtos;
    }
}
