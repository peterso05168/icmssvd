package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.Date;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 7569 $ $Date: 2017-06-15 18:07:40 +0800 (週四, 15 六月 2017) $
 * @author $Author: mtse $
 */
public class RequestDocumentDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer requestDocumentId;
    private Integer requestId;
    private Integer documentSeqNo;
    private Integer documentId;
    private Integer bailiffDocumentStatusId;
    private Integer adminSupportFileId;
    private String documentReferenceNo;
    private boolean actionRequestInd;
    private boolean printedInd;
    private boolean returnedDocumentInd;
    private boolean hardcopyInd;
    private Date receiveDate;
    private Date issueDate;    

    public Integer getRequestDocumentId() {
        return requestDocumentId;
    }

    public void setRequestDocumentId(Integer requestDocumentId) {
        this.requestDocumentId = requestDocumentId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getDocumentSeqNo() {
        return documentSeqNo;
    }

    public void setDocumentSeqNo(Integer documentSeqNo) {
        this.documentSeqNo = documentSeqNo;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getBailiffDocumentStatusId() {
        return bailiffDocumentStatusId;
    }

    public void setBailiffDocumentStatusId(Integer bailiffDocumentStatusId) {
        this.bailiffDocumentStatusId = bailiffDocumentStatusId;
    }

    public boolean isActionRequestInd() {
        return actionRequestInd;
    }

    public void setActionRequestInd(boolean actionRequestInd) {
        this.actionRequestInd = actionRequestInd;
    }

    public Integer getAdminSupportFileId() {
        return adminSupportFileId;
    }

    public void setAdminSupportFileId(Integer adminSupportFileId) {
        this.adminSupportFileId = adminSupportFileId;
    }    

    public String getDocumentReferenceNo() {
        return documentReferenceNo;
    }

    public void setDocumentReferenceNo(String documentReferenceNo) {
        this.documentReferenceNo = documentReferenceNo;
    }
    
    public boolean isPrintedInd() {
        return printedInd;
    }

    public void setPrintedInd(boolean printedInd) {
        this.printedInd = printedInd;
    }

    public boolean isReturnedDocumentInd() {
        return returnedDocumentInd;
    }

    public void setReturnedDocumentInd(boolean returnedDocumentInd) {
        this.returnedDocumentInd = returnedDocumentInd;
    }
    
    public boolean isHardcopyInd() {
        return hardcopyInd;
    }

    public void setHardcopyInd(boolean hardcopyInd) {
        this.hardcopyInd = hardcopyInd;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    
    @Override
    public String toString() {
        return "RequestDocumentDTO [requestDocumentId=" + requestDocumentId + ", requestId="
                + requestId + ", documentSeqNo=" + documentSeqNo + ", documentId=" + documentId
                + ", bailiffDocumentStatusId=" + bailiffDocumentStatusId + ", adminSupportFileId=" 
                + adminSupportFileId + ", documentReferenceNo=" + documentReferenceNo 
                + ", actionRequestInd=" + actionRequestInd + ", printedInd=" + printedInd 
                + ", returnedDocumentInd=" + returnedDocumentInd 
                + ", hardcopyInd=" + hardcopyInd
                + ", receiveDate=" + receiveDate
                + ", issueDate=" + issueDate + "]";
    }

}
