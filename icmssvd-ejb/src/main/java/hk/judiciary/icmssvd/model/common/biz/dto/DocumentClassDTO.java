package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class DocumentClassDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer documentClassId;
    private String documentClassCode;
    private String documentClassName;

    public Integer getDocumentClassId() {
        return documentClassId;
    }

    public void setDocumentClassId(Integer documentClassId) {
        this.documentClassId = documentClassId;
    }

    public String getDocumentClassCode() {
        return documentClassCode;
    }

    public void setDocumentClassCode(String documentClassCode) {
        this.documentClassCode = documentClassCode;
    }

    public String getDocumentClassName() {
        return documentClassName;
    }

    public void setDocumentClassName(String documentClassName) {
        this.documentClassName = documentClassName;
    }

    @Override
    public String toString() {
        return "DocumentClassDTO [documentClassId=" + documentClassId + ", documentClassCode="
                + documentClassCode + ", documentClassName=" + documentClassName + "]";
    }

}
