package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ProofOfServReqs;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsDoc;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icms.model.dao.entity.ServReqs;
import hk.judiciary.icmssvd.model.common.biz.assembler.BailiffOfficeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.HandlingAgentDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestStatusTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class PosRequestDetailDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param ProofOfServReqs
     *            ,BlfTaskRslt entity
     * @return PosRequestDetailDTO
     */
    public static PosRequestDetailDTO toDto(ProofOfServReqs proofOfServReqs) {
        PosRequestDetailDTO dto = new PosRequestDetailDTO();
        if (proofOfServReqs != null && proofOfServReqs.getProofOfServReqsId() != null
                && proofOfServReqs.getProofOfServReqsId() != 0) {
            dto.setRequest(RequestDTOAssembler.toDto(proofOfServReqs.getReqs()));
            dto.setPosRequest(PosRequestDTOAssembler.toDto(proofOfServReqs));

            ServReqs servReqs = proofOfServReqs.getServReqs();
            if (servReqs != null) {
                Reqs reqs = servReqs.getReqs();

                if (reqs != null) {
                    List<ReqsPartcpRole> reqsPartcpRoles = reqs.getReqsPartcpRole();
                    if (!CommonUtil.isNullOrEmpty(reqsPartcpRoles)) {
                        for (ReqsPartcpRole reqsPartcpRole : reqsPartcpRoles) {
                            if (RequestConstant.REQUEST_RECIPIENT.equals(reqsPartcpRole
                                    .getRecipReqserInd())) {
                                dto.setRecipient(PartyDTOAssembler.toDto(reqsPartcpRole));
                            }
                            if (RequestConstant.REQUEST_REQUESTER.equals(reqsPartcpRole
                                    .getRecipReqserInd())) {
                                dto.setRequester(PartyDTOAssembler.toDto(reqsPartcpRole));
                            }
                        }
                    }

                    if (dto.getRecipient() == null) {
                        dto.setRecipient(PartyDTOAssembler.toDto(servReqs));
                    }

                    List<ReqsDoc> reqsDocs = reqs.getReqsDoc();
                    if (!CommonUtil.isNullOrEmpty(reqsDocs)) {
                        List<DocumentDTO> documents = new ArrayList<DocumentDTO>();
                        for (ReqsDoc reqsDoc : reqsDocs) {
                            documents.add(DocumentDTOAssembler.toDto(reqsDoc.getDoc()));
                        }
                        dto.setDocuments(documents);
                    }
                    if (reqs.getReqsRslt() != null) {
                        dto.setProcessedBy(reqs.getReqsRslt().getProcBy());
                    }
                }
            }

            dto.setVersionAndNanos(proofOfServReqs.getVersion());
        }
        return dto;
    }

    /**
     * parse entity to dto
     * 
     * @param Reqs
     *            ,BlfTaskRslt entity
     * @return PosRequestDetailDTO
     */
    public static PosRequestDetailDTO toDto(Reqs reqs) {
        PosRequestDetailDTO dto = new PosRequestDetailDTO();
        if (reqs != null && reqs.getReqsId() != null && reqs.getReqsId() != 0) {
            RequestDTO request = new RequestDTO();
            if (reqs.getVcase() != null) {
                request.setCaseId(reqs.getVcase().getCaseId());
                request.setCaseNo(SvdCommonUtil.getCaseNo(reqs.getVcase()));
            }
            request.setCaseCourtSystem(DbCommonUtil.getDbValueOrEmpty(reqs.getCourtSys()));
            request.setCaseType(DbCommonUtil.getDbValueOrEmpty(reqs.getCaseType()));
            request.setCaseSerialNo(reqs.getCaseSerNo());
            request.setCaseYear(reqs.getCaseYr());
            request.setSequenceNoForCase(reqs.getSeqNoForCase());
            request.setRequestStatusType(RequestStatusTypeDTOAssembler.toDto(reqs.getReqsStatus()));
            request.setHandlingAgent(HandlingAgentDTOAssembler.toDto(reqs.getHandlingAgt()));
            request.setBailiffOffice(BailiffOfficeDTOAssembler.toDto(reqs.getBlfOffice()));
            dto.setRequest(request);

            PosRequestDTO posRequestDTO = new PosRequestDTO();
            posRequestDTO.setRequestId(reqs.getReqsId());
            if (reqs.getServReqs() != null) {
                posRequestDTO.setServiceRequestId(reqs.getServReqs().getServReqsId());
            }
            dto.setPosRequest(posRequestDTO);

            if (reqs.getReqsRslt() != null) {
                dto.setProcessedBy(reqs.getReqsRslt().getProcBy());
            }

            List<ReqsPartcpRole> reqsPartcpRoles = reqs.getReqsPartcpRole();
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
                dto.setRecipient(PartyDTOAssembler.toDto(reqs.getServReqs()));
            }

            List<ReqsDoc> reqsDocs = reqs.getReqsDoc();
            if (!CommonUtil.isNullOrEmpty(reqsDocs)) {
                List<DocumentDTO> documents = new ArrayList<DocumentDTO>();
                for (ReqsDoc reqsDoc : reqsDocs) {
                    documents.add(DocumentDTOAssembler.toDto(reqsDoc.getDoc()));
                }
                dto.setDocuments(documents);
            }

            dto.setVersionAndNanos(reqs.getVersion());
        }
        return dto;
    }
}
