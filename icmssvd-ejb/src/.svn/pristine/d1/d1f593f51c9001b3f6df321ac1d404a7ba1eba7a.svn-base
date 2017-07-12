package hk.judiciary.icmssvd.model.exeReq.biz.assembler;

import hk.judiciary.icms.model.dao.entity.ExecReqs;
import hk.judiciary.icmssvd.model.common.biz.assembler.DocumentTypeDTOAssembler;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDTO;

/**
 * 
 * @version $Revision: 3291 $ $Date: 2017-01-13 16:51:17 +0800 (Fri, 13 Jan 2017) $
 * @author $Author: vicki.huang $
 */
public class ExecutionRequestDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param ExecReqs
     *            entity
     * @return ExecutionRequestDTO
     */
    public static ExecutionRequestDTO toDto(ExecReqs execReqs) {
        ExecutionRequestDTO dto = new ExecutionRequestDTO();
        if (execReqs != null && execReqs.getExecReqsId() != null
                && execReqs.getExecReqsId().intValue() > 0) {
            dto.setExecutionRequestId(execReqs.getExecReqsId());
            if (execReqs.getReqs() != null) {
                dto.setRequestId(execReqs.getReqs().getReqsId());
            }
            dto.setDocumentType(DocumentTypeDTOAssembler.toDto(execReqs.getDocType()));
            dto.setVersionAndNanos(execReqs.getVersion());
        }
        return dto;
    }
}
