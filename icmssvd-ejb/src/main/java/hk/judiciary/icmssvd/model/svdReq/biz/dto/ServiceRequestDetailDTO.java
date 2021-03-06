package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.List;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 7060 $ $Date: 2017-05-20 12:12:34 +0800 (週六, 20 五月 2017) $
 * @author $Author: vicki.huang $
 */
public class ServiceRequestDetailDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private RequestDTO request;
    private ServiceRequestDTO serviceRequest;
    private RequestAddressDTO requestAddress;
    private RequestParticipantRoleDTO requesterRequestParticipantRole;
    private RequestParticipantRoleDTO recipientRequestParticipantRole;
    private PartyDTO requester;
    private PartyDTO recipient;
    private RequestServiceTypeDTO requestServiceType;
    private SpecialRequestDTO specialRequest;
    private List<DocumentRecordDTO> documentRecords;
    private List<DocumentDraftDTO> documentDrafts;
    private RequestResultDTO requestResult;
    private List<DocumentDTO> newReturnDocuments;
    private String serviceOfDocumentPanelMode;
    private String documentListPanelMode;
    private String serviceResultPanelMode;
    private boolean submittedModeInd;
    private boolean allowSaveDraftInd;
    private boolean allowSubmitInd;
    private boolean allowWithdrawInd;
    private boolean allowCompleteInd;
    private boolean allowUpdateServiceTypeInd;
    private boolean allowProofOfServiceInd;
    private boolean urgentRequireInd;
    private FunctionDTO func;
    private List<PartyDTO> requesters;
    private List<PartyDTO> recipients;

    public RequestDTO getRequest() {
        return request;
    }

    public void setRequest(RequestDTO request) {
        this.request = request;
    }

    public ServiceRequestDTO getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequestDTO serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public RequestAddressDTO getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(RequestAddressDTO requestAddress) {
        this.requestAddress = requestAddress;
    }

    public RequestParticipantRoleDTO getRequesterRequestParticipantRole() {
        return requesterRequestParticipantRole;
    }

    public void setRequesterRequestParticipantRole(
            RequestParticipantRoleDTO requesterRequestParticipantRole) {
        this.requesterRequestParticipantRole = requesterRequestParticipantRole;
    }

    public RequestParticipantRoleDTO getRecipientRequestParticipantRole() {
        return recipientRequestParticipantRole;
    }

    public void setRecipientRequestParticipantRole(
            RequestParticipantRoleDTO recipientRequestParticipantRole) {
        this.recipientRequestParticipantRole = recipientRequestParticipantRole;
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

    public RequestServiceTypeDTO getRequestServiceType() {
        return requestServiceType;
    }

    public void setRequestServiceType(RequestServiceTypeDTO requestServiceType) {
        this.requestServiceType = requestServiceType;
    }

    public SpecialRequestDTO getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(SpecialRequestDTO specialRequest) {
        this.specialRequest = specialRequest;
    }

    public List<DocumentRecordDTO> getDocumentRecords() {
        return documentRecords;
    }

    public void setDocumentRecords(List<DocumentRecordDTO> documentRecords) {
        this.documentRecords = documentRecords;
    }

    public List<DocumentDraftDTO> getDocumentDrafts() {
        return documentDrafts;
    }

    public void setDocumentDrafts(List<DocumentDraftDTO> documentDrafts) {
        this.documentDrafts = documentDrafts;
    }

    public RequestResultDTO getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(RequestResultDTO requestResult) {
        this.requestResult = requestResult;
    }

    public List<DocumentDTO> getNewReturnDocuments() {
        return newReturnDocuments;
    }

    public void setNewReturnDocuments(List<DocumentDTO> newReturnDocuments) {
        this.newReturnDocuments = newReturnDocuments;
    }

    public String getServiceOfDocumentPanelMode() {
        return serviceOfDocumentPanelMode;
    }

    public void setServiceOfDocumentPanelMode(String serviceOfDocumentPanelMode) {
        this.serviceOfDocumentPanelMode = serviceOfDocumentPanelMode;
    }

    public String getDocumentListPanelMode() {
        return documentListPanelMode;
    }

    public void setDocumentListPanelMode(String documentListPanelMode) {
        this.documentListPanelMode = documentListPanelMode;
    }

    public String getServiceResultPanelMode() {
        return serviceResultPanelMode;
    }

    public void setServiceResultPanelMode(String serviceResultPanelMode) {
        this.serviceResultPanelMode = serviceResultPanelMode;
    }

    public boolean isSubmittedModeInd() {
        return submittedModeInd;
    }

    public void setSubmittedModeInd(boolean submittedModeInd) {
        this.submittedModeInd = submittedModeInd;
    }

    public boolean isAllowSaveDraftInd() {
        return allowSaveDraftInd;
    }

    public void setAllowSaveDraftInd(boolean allowSaveDraftInd) {
        this.allowSaveDraftInd = allowSaveDraftInd;
    }

    public boolean isAllowSubmitInd() {
        return allowSubmitInd;
    }

    public void setAllowSubmitInd(boolean allowSubmitInd) {
        this.allowSubmitInd = allowSubmitInd;
    }

    public boolean isAllowWithdrawInd() {
        return allowWithdrawInd;
    }

    public void setAllowWithdrawInd(boolean allowWithdrawInd) {
        this.allowWithdrawInd = allowWithdrawInd;
    }

    public boolean isAllowCompleteInd() {
        return allowCompleteInd;
    }

    public void setAllowCompleteInd(boolean allowCompleteInd) {
        this.allowCompleteInd = allowCompleteInd;
    }

    public boolean isAllowUpdateServiceTypeInd() {
        return allowUpdateServiceTypeInd;
    }

    public void setAllowUpdateServiceTypeInd(boolean allowUpdateServiceTypeInd) {
        this.allowUpdateServiceTypeInd = allowUpdateServiceTypeInd;
    }

    public boolean isAllowProofOfServiceInd() {
        return allowProofOfServiceInd;
    }

    public void setAllowProofOfServiceInd(boolean allowProofOfServiceInd) {
        this.allowProofOfServiceInd = allowProofOfServiceInd;
    }

    public boolean isUrgentRequireInd() {
        return urgentRequireInd;
    }

    public void setUrgentRequireInd(boolean urgentRequireInd) {
        this.urgentRequireInd = urgentRequireInd;
    }

    public FunctionDTO getFunc() {
        return func;
    }

    public void setFunc(FunctionDTO func) {
        this.func = func;
    }

    public List<PartyDTO> getRequesters() {
        return requesters;
    }

    public void setRequesters(List<PartyDTO> requesters) {
        this.requesters = requesters;
    }

    public List<PartyDTO> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<PartyDTO> recipients) {
        this.recipients = recipients;
    }

    @Override
    public String toString() {
        return "ServiceRequestDetailDTO [request=" + request + ", serviceRequest=" + serviceRequest
                + ", requestAddress=" + requestAddress + ", requesterRequestParticipantRole="
                + requesterRequestParticipantRole + ", recipientRequestParticipantRole="
                + recipientRequestParticipantRole + ", requester=" + requester + ", recipient="
                + recipient + ", requestServiceType=" + requestServiceType + ", specialRequest="
                + specialRequest + ", documentRecords=" + documentRecords + ", documentDrafts="
                + documentDrafts + ", requestResult=" + requestResult + ", newReturnDocuments="
                + newReturnDocuments + ", serviceOfDocumentPanelMode=" + serviceOfDocumentPanelMode
                + ", documentListPanelMode=" + documentListPanelMode + ", serviceResultPanelMode="
                + serviceResultPanelMode + ", submittedModeInd=" + submittedModeInd
                + ", allowSaveDraftInd=" + allowSaveDraftInd + ", allowSubmitInd=" + allowSubmitInd
                + ", allowWithdrawInd=" + allowWithdrawInd + ", allowCompleteInd="
                + allowCompleteInd + ", allowUpdateServiceTypeInd=" + allowUpdateServiceTypeInd
                + ", allowProofOfServiceInd=" + allowProofOfServiceInd + ", urgentRequireInd="
                + urgentRequireInd + ", func=" + func + ", requesters=" + requesters
                + ", recipients=" + recipients + "]";
    }

}
