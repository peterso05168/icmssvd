package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icms.model.dao.entity.Doc;
import hk.judiciary.icms.model.dao.entity.PartcpRole;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PartyDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestAddressDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDetailDTO;

/**
 * 
 * @version $Revision: 7060 $ $Date: 2017-05-20 12:12:34 +0800 (週六, 20 五月 2017) $
 * @author $Author: vicki.huang $
 */
public class ServiceRequestDetailDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param servReqs
     *            entity
     * @return ServiceRequestDTO
     */
    public static ServiceRequestDetailDTO toDto(Reqs reqs, List<Doc> docs) {
        ServiceRequestDetailDTO dto = new ServiceRequestDetailDTO();
        if (reqs != null && reqs.getReqsId() != null && reqs.getReqsId() != 0) {
            dto.setRequest(RequestDTOAssembler.toDto(reqs));
            dto.setServiceRequest(ServiceRequestDTOAssembler.toDto(reqs.getServReqs()));
            dto.setRequestAddress(RequestAddressDTOAssembler.toDto(reqs.getReqsAddr()));
            List<ReqsPartcpRole> reqsPartcpRoles = reqs.getReqsPartcpRole();
            if (!CommonUtil.isNullOrEmpty(reqsPartcpRoles)) {
                for (ReqsPartcpRole reqsPartcpRole : reqsPartcpRoles) {
                    if (RequestConstant.REQUEST_REQUESTER
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        dto.setRequesterRequestParticipantRole(RequestParticipantRoleDTOAssembler
                                .toDto(reqsPartcpRole));
                        dto.setRequester(PartyDTOAssembler.toDto(reqsPartcpRole));
                    }
                    if (RequestConstant.REQUEST_RECIPIENT
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        dto.setRecipientRequestParticipantRole(RequestParticipantRoleDTOAssembler
                                .toDto(reqsPartcpRole));
                        dto.setRecipient(PartyDTOAssembler.toDto(reqsPartcpRole));
                    }
                }
            }
            dto.setSpecialRequest(SpecialRequestDTOAssembler.toDto(reqs.getSpecialReqs()));
            if (dto.getSpecialRequest() == null) {
                dto.setUrgentRequireInd(false);
            } else {
                dto.setUrgentRequireInd(true);
            }
            dto.setDocumentRecords(DocumentRecordDTOAssembler.toDtoList(reqs.getReqsDoc(), docs));
            dto.setDocumentDrafts(DocumentDraftDTOAssembler.toDtoList(reqs.getReqsDoc()));
            dto.setRequestResult(RequestResultDTOAssembler.toDto(reqs.getReqsRslt()));
            dto.setNewReturnDocuments(new ArrayList<DocumentDTO>());
            if (reqs.getVcase() != null) {
                CourtLvlType courtLvlType = reqs.getVcase().getCourtLvlType();
                List<PartcpRole> partcpRoles = reqs.getVcase().getPartcpRole();
                String lvlCode = courtLvlType.getCourtLvlTypeCd();
                if (RequestConstant.COURT_LEVEL_TYPE_MAGISTRATES.equals(lvlCode)) {
                    dto.setRequesters(PartyDTOAssembler.toDtoList(partcpRoles,
                            RequestConstant.PARTICIPANT_ROLE_TYPE_PROSECUTION));
                    dto.setRecipients(PartyDTOAssembler.toDtoList(partcpRoles,
                            RequestConstant.PARTICIPANT_ROLE_TYPE_DEFENDANT));
                } else if (RequestConstant.COURT_LEVEL_TYPE_DISTRICT.equals(lvlCode)) {
                    List<PartyDTO> dtoList = PartyDTOAssembler.toDtoList(partcpRoles);
                    dto.setRequesters(dtoList);
                    dto.setRecipients(dtoList);
                }
            }
            dto.setVersionAndNanos(reqs.getVersion());
        }
        return dto;
    }

    public static ServiceRequestDetailDTO toDto(Case vcase, List<Doc> docs) {
        ServiceRequestDetailDTO dto = new ServiceRequestDetailDTO();
        if (vcase != null && vcase.getCaseId() != null && vcase.getCaseId() != 0) {
            RequestDTO requestDTO = new RequestDTO();
            requestDTO.setCaseId(vcase.getCaseId());
            if (vcase.getCompsCourt() != null) {
                requestDTO.setCaseCourtSystem(DbCommonUtil.getDbValueOrEmpty(vcase.getCompsCourt()
                        .getCompsCourtCd()));
            }
            if (vcase.getCaseType() != null) {
                requestDTO.setCaseType(DbCommonUtil.getDbValueOrEmpty(vcase.getCaseType()
                        .getCaseTypeCd()));
            }

            requestDTO.setCaseSerialNo(vcase.getCaseSerNo());
            requestDTO.setCaseYear(vcase.getCaseYr());
            requestDTO.setCaseNo(SvdCommonUtil.getCaseNo(vcase));
            requestDTO.setRequestStatusType(new RequestStatusTypeDTO());
            dto.setRequest(requestDTO);
            dto.setServiceRequest(new ServiceRequestDTO());
            dto.setRequestAddress(new RequestAddressDTO());
            dto.setUrgentRequireInd(false);
            dto.setDocumentRecords(DocumentRecordDTOAssembler.toDtoList(null, docs));
            CourtLvlType courtLvlType = vcase.getCourtLvlType();
            List<PartcpRole> partcpRoles = vcase.getPartcpRole();
            String lvlCode = courtLvlType.getCourtLvlTypeCd();
            if (RequestConstant.COURT_LEVEL_TYPE_MAGISTRATES.equals(lvlCode)) {
                dto.setRequesters(PartyDTOAssembler.toDtoList(partcpRoles,
                        RequestConstant.PARTICIPANT_ROLE_TYPE_PROSECUTION));
                dto.setRecipients(PartyDTOAssembler.toDtoList(partcpRoles,
                        RequestConstant.PARTICIPANT_ROLE_TYPE_DEFENDANT));
            } else if (RequestConstant.COURT_LEVEL_TYPE_DISTRICT.equals(lvlCode)) {
                List<PartyDTO> dtoList = PartyDTOAssembler.toDtoList(partcpRoles);
                dto.setRequesters(dtoList);
                dto.setRecipients(dtoList);
            }
            dto.setVersionAndNanos(vcase.getVersion());
        }
        return dto;
    }

}
