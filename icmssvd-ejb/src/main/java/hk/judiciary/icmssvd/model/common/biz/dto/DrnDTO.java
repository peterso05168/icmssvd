package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (Wed, 30 Nov 2016) $
 * @author $Author: vicki.huang $
 */
public class DrnDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private String documentReferenceNo;

    public String getDocumentReferenceNo() {
        return documentReferenceNo;
    }

    public void setDocumentReferenceNo(String documentReferenceNo) {
        this.documentReferenceNo = documentReferenceNo;
    }

    @Override
    public String toString() {
        return "DrnDTO [documentReferenceNo=" + documentReferenceNo + "]";
    }

}
