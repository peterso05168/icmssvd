package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class DocumentStatusDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer documentStatusId;
    private String documentStatusCode;
    private String documentStatusName;

    public Integer getDocumentStatusId() {
        return documentStatusId;
    }

    public void setDocumentStatusId(Integer documentStatusId) {
        this.documentStatusId = documentStatusId;
    }

    public String getDocumentStatusCode() {
        return documentStatusCode;
    }

    public void setDocumentStatusCode(String documentStatusCode) {
        this.documentStatusCode = documentStatusCode;
    }

    public String getDocumentStatusName() {
        return documentStatusName;
    }

    public void setDocumentStatusName(String documentStatusName) {
        this.documentStatusName = documentStatusName;
    }

    @Override
    public String toString() {
        return "DocumentStatusDTO [documentStatusId=" + documentStatusId + ", documentStatusCode="
                + documentStatusCode + ", documentStatusName=" + documentStatusName + "]";
    }

}
