package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.Date;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentClassDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentStatusDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentTypeDTO;

/**
 * 
 * @version $Revision: 7821 $ $Date: 2017-07-04 12:09:56 +0800 (週二, 04 七月 2017) $
 * @author $Author: vicki.huang $
 */
public class DocumentDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer documentId;
    private DocumentClassDTO documentClass;
    private DocumentStatusDTO documentStatus;
    private DocumentTypeDTO documentType;
    private String documentReferenceNo;
    private PartyDTO documentFileBy;
    private Date documentFileDate;
    private String cfsFileId;

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public DocumentClassDTO getDocumentClass() {
        return documentClass;
    }

    public void setDocumentClass(DocumentClassDTO documentClass) {
        this.documentClass = documentClass;
    }

    public DocumentStatusDTO getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(DocumentStatusDTO documentStatus) {
        this.documentStatus = documentStatus;
    }

    public DocumentTypeDTO getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeDTO documentType) {
        this.documentType = documentType;
    }

    public String getDocumentReferenceNo() {
        return documentReferenceNo;
    }

    public void setDocumentReferenceNo(String documentReferenceNo) {
        this.documentReferenceNo = documentReferenceNo;
    }

    public PartyDTO getDocumentFileBy() {
        return documentFileBy;
    }

    public void setDocumentFileBy(PartyDTO documentFileBy) {
        this.documentFileBy = documentFileBy;
    }

    public Date getDocumentFileDate() {
        return documentFileDate;
    }

    public void setDocumentFileDate(Date documentFileDate) {
        this.documentFileDate = documentFileDate;
    }

    public String getCfsFileId() {
        return cfsFileId;
    }

    public void setCfsFileId(String cfsFileId) {
        this.cfsFileId = cfsFileId;
    }

    @Override
    public String toString() {
        return "DocumentDTO [documentId=" + documentId + ", documentClass=" + documentClass
                + ", documentStatus=" + documentStatus + ", documentType=" + documentType
                + ", documentReferenceNo=" + documentReferenceNo + ", documentFileBy="
                + documentFileBy + ", documentFileDate=" + documentFileDate + ", cfsFileId="
                + cfsFileId + "]";
    }

}
