package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ProofOfServReqs;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.biz.assembler.HandlingAgentDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.IdDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.PosRequestConstant;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchResultDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class PosRequestSearchResultDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param Reqs
     *            entity
     * @return PosRequestSearchResultDTO
     */
    public static PosRequestSearchResultDTO toDto(Reqs reqs) {
        PosRequestSearchResultDTO dto = new PosRequestSearchResultDTO();
        ProofOfServReqs proofOfServReqs = reqs.getProofOfServReqs();
        if (proofOfServReqs != null && proofOfServReqs.getProofOfServReqsId() != null && proofOfServReqs.getProofOfServReqsId().intValue() > 0) {
            dto.setRequestId(IdDTOAssembler.toDto(reqs.getReqsId()));
            dto.setSubmitDate(reqs.getSubmitDt());
            dto.setCaseNo(SvdCommonUtil.getCaseNo(reqs.getVcase()));
            dto.setHandlingAgent(HandlingAgentDTOAssembler.toDto(reqs.getHandlingAgt()));

            List<ReqsPartcpRole> reqsPartcpRoles = proofOfServReqs.getServReqs()
                    .getReqs().getReqsPartcpRole();
            if (!CommonUtil.isNullOrEmpty(reqsPartcpRoles)) {
                for (ReqsPartcpRole reqsPartcpRole : reqsPartcpRoles) {
                    if (RequestConstant.REQUEST_RECIPIENT
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        dto.setRecipient(PartyDTOAssembler.toDto(reqsPartcpRole));
                    }
                    if (RequestConstant.REQUEST_REQUESTER
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        dto.setRequester(PartyDTOAssembler.toDto(reqsPartcpRole));
                    }
                }
            }

            if (dto.getRecipient() == null) {
                dto.setRecipient(PartyDTOAssembler.toDto(reqs.getProofOfServReqs().getServReqs()));
            }

            if (proofOfServReqs != null) {
                if (CommonConstant.COMMON_FLAG_TRUE.equals(proofOfServReqs.getProofOfDocFlag())) {
                    dto.setPosOrAcip(PosRequestConstant.TYPE_POS);
                    dto.setDueOrHearingDate(proofOfServReqs.getProofByDocDueDate());
                } else if (CommonConstant.COMMON_FLAG_TRUE.equals(proofOfServReqs
                        .getAttdCourtInPersonFlag())) {
                    dto.setPosOrAcip(PosRequestConstant.TYPE_ACIP);
                    dto.setDueOrHearingDate(proofOfServReqs.getProofOfServHrnDt());
                }
            }
            dto.setVersionAndNanos(reqs.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param Reqss
     *            List of Entity
     * @return list of PosRequestSearchResultDTO
     */
    public static List<PosRequestSearchResultDTO> toDtoList(List<Reqs> reqss) {
        List<PosRequestSearchResultDTO> dtos = new ArrayList<PosRequestSearchResultDTO>();
        if (!CommonUtil.isNullOrEmpty(reqss)) {
            for (Reqs reqs : reqss) {
                dtos.add(toDto(reqs));
            }
        }
        return dtos;
    }
}
