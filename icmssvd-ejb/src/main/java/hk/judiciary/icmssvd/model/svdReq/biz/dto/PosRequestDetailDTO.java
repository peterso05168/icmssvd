package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.List;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class PosRequestDetailDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private PosRequestDTO posRequest;
    private RequestDTO request;
    private PartyDTO requester;
    private PartyDTO recipient;
    private String processedBy;
    private List<DocumentDTO> documents;
    private String posPanelMode;
    private FunctionDTO func;

    public PosRequestDTO getPosRequest() {
        return posRequest;
    }

    public void setPosRequest(PosRequestDTO posRequest) {
        this.posRequest = posRequest;
    }

    public RequestDTO getRequest() {
        return request;
    }

    public void setRequest(RequestDTO request) {
        this.request = request;
    }

    public PartyDTO getRequester() {
        return requester;
    }

    public void setRequester(PartyDTO requester) {
        this.requester = requester;
    }

    public PartyDTO getRecipient() {
        return recipient;
    }

    public void setRecipient(PartyDTO recipient) {
        this.recipient = recipient;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }

    public String getPosPanelMode() {
        return posPanelMode;
    }

    public void setPosPanelMode(String posPanelMode) {
        this.posPanelMode = posPanelMode;
    }

    public FunctionDTO getFunc() {
        return func;
    }

    public void setFunc(FunctionDTO func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return "PosRequestDetailDTO [posRequest=" + posRequest + ", request=" + request
                + ", requester=" + requester + ", recipient=" + recipient + ", processedBy="
                + processedBy + ", documents=" + documents + ", posPanelMode=" + posPanelMode
                + ", func=" + func + "]";
    }

}
