package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icms.model.dao.entity.ServReqs;
import hk.judiciary.icmssvd.model.common.biz.assembler.HandlingAgentDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.IdDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestStatusTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.ServiceModeTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.dto.HkRegionDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PartyDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.SpecialRequestDTO;

/**
 * 
 * @version $Revision: 6473 $ $Date: 2017-04-24 18:09:35 +0800 (週一, 24 四月 2017) $
 * @author $Author: vicki.huang $
 */
public class ServiceRequestSearchResultDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqs
     *            entity
     * @return ServiceRequestSearchResultDTO
     */
    public static ServiceRequestSearchResultDTO toDto(Reqs reqs) {
        ServiceRequestSearchResultDTO dto = new ServiceRequestSearchResultDTO();
        if (reqs != null && reqs.getReqsId() != null && reqs.getReqsId() != 0) {
            dto.setRequestId(IdDTOAssembler.toDto(reqs.getReqsId()));
            dto.setSubmitDate(reqs.getSubmitDt());
            if (reqs.getVcase() != null) {
                Case vCase = reqs.getVcase();
                dto.setCaseNo(SvdCommonUtil.getCaseNo(vCase));
            }
            dto.setHandlingAgent(HandlingAgentDTOAssembler.toDto(reqs.getHandlingAgt()));
            dto.setRequestStatusType(RequestStatusTypeDTOAssembler.toDto(reqs.getReqsStatus()));
            dto.setRequestServiceType(RequestServiceTypeDTOAssembler.toDto(reqs.getSeqNoForCase()));
            List<ReqsPartcpRole> reqsPartcpRoles = reqs.getReqsPartcpRole();
            PartyDTO requester = new PartyDTO();
            PartyDTO recipient = null;
            if (!CommonUtil.isNullOrEmpty(reqsPartcpRoles)) {
                for (ReqsPartcpRole reqsPartcpRole : reqsPartcpRoles) {
                    if (RequestConstant.REQUEST_REQUESTER
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        requester = PartyDTOAssembler.toDto(reqsPartcpRole);
                    }
                    if (RequestConstant.REQUEST_RECIPIENT
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        recipient = PartyDTOAssembler.toDto(reqsPartcpRole);
                    }
                }
            }
            dto.setRequester(requester);
            if (recipient == null
                    || (recipient != null && (recipient.getParticipantId() == null || recipient
                            .getParticipantId() <= 0))) {
                recipient = PartyDTOAssembler.toDto(reqs.getServReqs());
            }
            dto.setRecipient(recipient);

            HkRegionDTO hkRegion = RequestAddressDTOAssembler.toDto(reqs.getReqsAddr())
                    .getHkRegion();
            if (hkRegion == null) {
                hkRegion = new HkRegionDTO();
            }
            dto.setHkRegion(hkRegion);

            ServReqs servReqs = reqs.getServReqs();
            ServiceModeTypeDTO serviceModeType = new ServiceModeTypeDTO();
            if (servReqs != null && servReqs.getServReqsId() != null
                    && servReqs.getServReqsId() != 0) {
                serviceModeType = ServiceModeTypeDTOAssembler.toDto(servReqs.getServMode());
            }
            dto.setServiceModeType(serviceModeType);

            SpecialRequestDTO specialRequest = SpecialRequestDTOAssembler.toDto(reqs
                    .getSpecialReqs());
            if (specialRequest != null) {
                dto.setUrgentServiceInd(true);
            } else {
                dto.setUrgentServiceInd(false);
            }
            dto.setVersionAndNanos(reqs.getVersion());
        }
        return dto;
    }
}
