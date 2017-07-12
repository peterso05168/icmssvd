package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class DocumentRecordDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private RequestDocumentDTO requestDocument;
    private DocumentDTO document;
    private boolean returnedDocumentInd;
    private boolean selectedDocumentInd;

    public RequestDocumentDTO getRequestDocument() {
        return requestDocument;
    }

    public void setRequestDocument(RequestDocumentDTO requestDocument) {
        this.requestDocument = requestDocument;
    }

    public DocumentDTO getDocument() {
        return document;
    }

    public void setDocument(DocumentDTO document) {
        this.document = document;
    }

    public boolean isReturnedDocumentInd() {
        return returnedDocumentInd;
    }

    public void setReturnedDocumentInd(boolean returnedDocumentInd) {
        this.returnedDocumentInd = returnedDocumentInd;
    }

    public boolean isSelectedDocumentInd() {
        return selectedDocumentInd;
    }

    public void setSelectedDocumentInd(boolean selectedDocumentInd) {
        this.selectedDocumentInd = selectedDocumentInd;
    }

    @Override
    public String toString() {
        return "DocumentRecordDTO [requestDocument=" + requestDocument + ", document=" + document
                + ", returnedDocumentInd=" + returnedDocumentInd + ", selectedDocumentInd="
                + selectedDocumentInd + "]";
    }

}
