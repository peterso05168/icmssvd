package hk.judiciary.icmssvd.model.exeReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icmssvd.model.common.biz.assembler.BailiffOfficeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestStatusTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.PartyDTOAssembler;

/**
 * 
 * @version $Revision: 3291 $ $Date: 2017-01-13 16:51:17 +0800 (Fri, 13 Jan 2017) $
 * @author $Author: vicki.huang $
 */
public class ExecutionRequestSearchResultDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param Reqs
     *            entity
     * @return ExecutionRequestSearchResultDTO
     */
    public static ExecutionRequestSearchResultDTO toDto(Reqs reqs) {
        ExecutionRequestSearchResultDTO dto = new ExecutionRequestSearchResultDTO();
        if (reqs != null && reqs.getReqsId() != null && reqs.getReqsId().intValue() > 0) {
            IdDTO requestId = new IdDTO();
            requestId.setId(reqs.getReqsId());
            dto.setRequestId(requestId);
            dto.setSubmitDate(reqs.getSubmitDt());
            String caseNo = String.format(RequestConstant.CASE_NO_PATTERN, reqs.getCourtSys(),
                    reqs.getCaseType(), reqs.getCaseSerNo(), reqs.getCaseYr());
            dto.setCaseNo(caseNo);
            List<ReqsPartcpRole> reqsPartcpRoles = reqs.getReqsPartcpRole();
            if (!CommonUtil.isNullOrEmpty(reqsPartcpRoles)) {
                for (ReqsPartcpRole reqsPartcpRole : reqsPartcpRoles) {
                    if (RequestConstant.REQUEST_REQUESTER
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        dto.setApplicant(PartyDTOAssembler.toDto(reqsPartcpRole));
                    }
                }
            }
            dto.setBailiffOffice(BailiffOfficeDTOAssembler.toDto(reqs.getBlfOffice()));
            dto.setRequestStatusType(RequestStatusTypeDTOAssembler.toDto(reqs.getReqsStatus()));
            dto.setVersionAndNanos(reqs.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param Reqs
     *            List of Entity
     * @return list of ExecutionRequestSearchResultDTO
     */
    public static List<ExecutionRequestSearchResultDTO> toDtoList(List<Reqs> reqs) {
        List<ExecutionRequestSearchResultDTO> dtos = new ArrayList<ExecutionRequestSearchResultDTO>();
        if (!CommonUtil.isNullOrEmpty(reqs)) {
            for (Reqs req : reqs) {
                dtos.add(toDto(req));
            }
        }
        return dtos;
    }
}
