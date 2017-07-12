package hk.judiciary.icmssvd.model.exeReq.biz.assembler;

import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.Doc;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.DocumentRecordDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.PartyDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.RequestAddressDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.RequestDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.RequestParticipantRoleDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.RequestResultDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestAddressDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;

/**
 * 
 * @version $Revision: 3291 $ $Date: 2017-01-13 16:51:17 +0800 (Fri, 13 Jan 2017) $
 * @author $Author: vicki.huang $
 */
public class ExecutionRequestDetailDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @return ExecutionRequestDetailDTO
     */
    public static ExecutionRequestDetailDTO toDto(Reqs reqs, List<Doc> docs) {
        ExecutionRequestDetailDTO dto = new ExecutionRequestDetailDTO();
        if (reqs != null && reqs.getReqsId() != null && reqs.getReqsId().intValue() > 0) {
            dto.setRequest(RequestDTOAssembler.toDto(reqs));
            dto.setExecutionRequest(ExecutionRequestDTOAssembler.toDto(reqs.getExecReqs()));
            dto.setRequestAddress(RequestAddressDTOAssembler.toDto(reqs.getReqsAddr()));
            List<ReqsPartcpRole> reqsPartcpRoles = reqs.getReqsPartcpRole();
            if (!CommonUtil.isNullOrEmpty(reqsPartcpRoles)) {
                for (ReqsPartcpRole reqsPartcpRole : reqsPartcpRoles) {
                    if (RequestConstant.REQUEST_REQUESTER
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        dto.setRequestParticipantRole(RequestParticipantRoleDTOAssembler
                                .toDto(reqsPartcpRole));
                        dto.setApplicant(PartyDTOAssembler.toDto(reqsPartcpRole));
                    }
                }
            }
            dto.setDocumentRecords(DocumentRecordDTOAssembler.toDtoList(reqs.getReqsDoc(), docs));
            dto.setRequestResult(RequestResultDTOAssembler.toDto(reqs.getReqsRslt()));
            if (reqs.getVcase() != null) {
                dto.setApplicants(PartyDTOAssembler.toDtoList(reqs.getVcase().getPartcpRole()));
            }
            dto.setVersionAndNanos(reqs.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @return list of ExecutionRequestDetailDTO
     */
    public static ExecutionRequestDetailDTO toDto(Case vCase, List<Doc> docs) {
        ExecutionRequestDetailDTO dto = new ExecutionRequestDetailDTO();
        if (vCase != null && vCase.getCaseId() != null && vCase.getCaseId().intValue() > 0) {
            RequestDTO request = new RequestDTO();
            request.setCaseId(vCase.getCaseId());
            if (vCase.getCompsCourt() != null) {
                request.setCaseCourtSystem(DbCommonUtil.getDbValueOrEmpty(vCase.getCompsCourt()
                        .getCompsCourtCd()));
            }
            if (vCase.getCaseType() != null) {
                request.setCaseType(DbCommonUtil.getDbValueOrEmpty(vCase.getCaseType()
                        .getCaseTypeCd()));
            }

            request.setCaseSerialNo(vCase.getCaseSerNo());
            request.setCaseYear(vCase.getCaseYr());
            request.setCaseNo(String.format(RequestConstant.CASE_NO_PATTERN,
                    request.getCaseCourtSystem(), request.getCaseType(), request.getCaseSerialNo(),
                    request.getCaseYear()));
            request.setRequestStatusType(new RequestStatusTypeDTO());
            dto.setRequest(request);

            dto.setExecutionRequest(new ExecutionRequestDTO());
            dto.setRequestAddress(new RequestAddressDTO());
            dto.setDocumentRecords(DocumentRecordDTOAssembler.toDtoList(null, docs));
            dto.setApplicants(PartyDTOAssembler.toDtoList(vCase.getPartcpRole()));
            dto.setVersionAndNanos(vCase.getVersion());
        }
        return dto;
    }
}
