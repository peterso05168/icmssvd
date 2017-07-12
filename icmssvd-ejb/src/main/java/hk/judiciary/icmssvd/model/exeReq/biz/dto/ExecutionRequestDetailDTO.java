package hk.judiciary.icmssvd.model.exeReq.biz.dto;

import java.util.List;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentRecordDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PartyDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestAddressDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestParticipantRoleDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestResultDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class ExecutionRequestDetailDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private RequestDTO request;
    private ExecutionRequestDTO executionRequest;
    private RequestAddressDTO requestAddress;
    private RequestParticipantRoleDTO requestParticipantRole;
    private PartyDTO applicant;
    private List<DocumentRecordDTO> documentRecords;
    private RequestResultDTO requestResult;
    private String executionRequestPanelMode;
    private String documentListPanelMode;
    private String executionResultPanelMode;
    private Boolean submittedModeInd;
    private Boolean allowSaveDraftInd;
    private Boolean allowSubmitInd;
    private Boolean allowWithdrawInd;
    private FunctionDTO func;
    private List<PartyDTO> applicants;

    public RequestDTO getRequest() {
        return request;
    }

    public void setRequest(RequestDTO request) {
        this.request = request;
    }

    public ExecutionRequestDTO getExecutionRequest() {
        return executionRequest;
    }

    public void setExecutionRequest(ExecutionRequestDTO executionRequest) {
        this.executionRequest = executionRequest;
    }

    public RequestAddressDTO getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(RequestAddressDTO requestAddress) {
        this.requestAddress = requestAddress;
    }

    public RequestParticipantRoleDTO getRequestParticipantRole() {
        return requestParticipantRole;
    }

    public void setRequestParticipantRole(RequestParticipantRoleDTO requestParticipantRole) {
        this.requestParticipantRole = requestParticipantRole;
    }

    public PartyDTO getApplicant() {
        return applicant;
    }

    public void setApplicant(PartyDTO applicant) {
        this.applicant = applicant;
    }

    public List<DocumentRecordDTO> getDocumentRecords() {
        return documentRecords;
    }

    public void setDocumentRecords(List<DocumentRecordDTO> documentRecords) {
        this.documentRecords = documentRecords;
    }

    public RequestResultDTO getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(RequestResultDTO requestResult) {
        this.requestResult = requestResult;
    }

    public String getExecutionRequestPanelMode() {
        return executionRequestPanelMode;
    }

    public void setExecutionRequestPanelMode(String executionRequestPanelMode) {
        this.executionRequestPanelMode = executionRequestPanelMode;
    }

    public String getDocumentListPanelMode() {
        return documentListPanelMode;
    }

    public void setDocumentListPanelMode(String documentListPanelMode) {
        this.documentListPanelMode = documentListPanelMode;
    }

    public String getExecutionResultPanelMode() {
        return executionResultPanelMode;
    }

    public void setExecutionResultPanelMode(String executionResultPanelMode) {
        this.executionResultPanelMode = executionResultPanelMode;
    }

    public Boolean getSubmittedModeInd() {
        return submittedModeInd;
    }

    public void setSubmittedModeInd(Boolean submittedModeInd) {
        this.submittedModeInd = submittedModeInd;
    }

    public Boolean getAllowSaveDraftInd() {
        return allowSaveDraftInd;
    }

    public void setAllowSaveDraftInd(Boolean allowSaveDraftInd) {
        this.allowSaveDraftInd = allowSaveDraftInd;
    }

    public Boolean getAllowSubmitInd() {
        return allowSubmitInd;
    }

    public void setAllowSubmitInd(Boolean allowSubmitInd) {
        this.allowSubmitInd = allowSubmitInd;
    }

    public Boolean getAllowWithdrawInd() {
        return allowWithdrawInd;
    }

    public void setAllowWithdrawInd(Boolean allowWithdrawInd) {
        this.allowWithdrawInd = allowWithdrawInd;
    }

    public FunctionDTO getFunc() {
        return func;
    }

    public void setFunc(FunctionDTO func) {
        this.func = func;
    }

    public List<PartyDTO> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<PartyDTO> applicants) {
        this.applicants = applicants;
    }

    @Override
    public String toString() {
        return "ExecutionRequestDetailDTO [request=" + request + ", executionRequest="
                + executionRequest + ", requestAddress=" + requestAddress
                + ", requestParticipantRole=" + requestParticipantRole + ", applicant=" + applicant
                + ", documentRecords=" + documentRecords + ", requestResult=" + requestResult
                + ", executionRequestPanelMode=" + executionRequestPanelMode
                + ", documentListPanelMode=" + documentListPanelMode
                + ", executionResultPanelMode=" + executionResultPanelMode + ", submittedModeInd="
                + submittedModeInd + ", allowSaveDraftInd=" + allowSaveDraftInd
                + ", allowSubmitInd=" + allowSubmitInd + ", allowWithdrawInd=" + allowWithdrawInd
                + ", func=" + func + ", applicants=" + applicants + "]";
    }

}
