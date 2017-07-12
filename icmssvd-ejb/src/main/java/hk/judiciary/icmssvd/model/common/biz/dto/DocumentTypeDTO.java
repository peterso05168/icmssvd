package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 6002 $ $Date: 2017-03-30 18:32:23 +0800 (週四, 30 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class DocumentTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer documentTypeId;
    private String documentTypeCode;
    private String documentTypeName;

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    @Override
    public String toString() {
        return "DocumentTypeDTO [documentTypeId=" + documentTypeId + ", documentTypeCode="
                + documentTypeCode + ", documentTypeName=" + documentTypeName + "]";
    }

}
