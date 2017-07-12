package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (Wed, 30 Nov 2016) $
 * @author $Author: vicki.huang $
 */
public class DocumentFileDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer documentId;
    private String sourceFileId;

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getSourceFileId() {
        return sourceFileId;
    }

    public void setSourceFileId(String sourceFileId) {
        this.sourceFileId = sourceFileId;
    }

    @Override
    public String toString() {
        return "DocumentFileDTO [documentId=" + documentId + ", sourceFileId=" + sourceFileId + "]";
    }

}
