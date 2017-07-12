package hk.judiciary.icmssvd.model.exeReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentTypeDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class ExecutionRequestDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer executionRequestId;
    private Integer requestId;
    private DocumentTypeDTO documentType;

    public Integer getExecutionRequestId() {
        return executionRequestId;
    }

    public void setExecutionRequestId(Integer executionRequestId) {
        this.executionRequestId = executionRequestId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public DocumentTypeDTO getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeDTO documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "ExecutionRequestDTO [executionRequestId=" + executionRequestId + ", requestId="
                + requestId + ", documentType=" + documentType + "]";
    }

}
