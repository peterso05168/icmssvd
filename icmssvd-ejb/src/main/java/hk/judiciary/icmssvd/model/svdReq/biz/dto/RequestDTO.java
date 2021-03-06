package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.sql.Timestamp;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HandlingAgentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestTypeDTO;

/**
 * 
 * @version $Revision: 4744 $ $Date: 2017-02-28 20:05:55 +0800 (週二, 28 二月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer requestId;
    private String registrationNo;
    private String caseNo;
    private Integer caseId;
    private String caseCourtSystem;
    private String caseType;
    private Integer caseSerialNo;
    private Integer caseYear;
    private RequestTypeDTO requestType;
    private Integer registrationYear;
    private String registrationSerialNo;
    private Timestamp submissionDatetime;
    private Timestamp acceptanceDatetime;
    private Integer sequenceNoForCase;
    private HandlingAgentDTO handlingAgent;
    private RequestStatusTypeDTO requestStatusType;
    private BailiffOfficeDTO bailiffOffice;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getCaseCourtSystem() {
        return caseCourtSystem;
    }

    public void setCaseCourtSystem(String caseCourtSystem) {
        this.caseCourtSystem = caseCourtSystem;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Integer getCaseSerialNo() {
        return caseSerialNo;
    }

    public void setCaseSerialNo(Integer caseSerialNo) {
        this.caseSerialNo = caseSerialNo;
    }

    public Integer getCaseYear() {
        return caseYear;
    }

    public void setCaseYear(Integer caseYear) {
        this.caseYear = caseYear;
    }

    public RequestTypeDTO getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestTypeDTO requestType) {
        this.requestType = requestType;
    }

    public Integer getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(Integer registrationYear) {
        this.registrationYear = registrationYear;
    }

    public String getRegistrationSerialNo() {
        return registrationSerialNo;
    }

    public void setRegistrationSerialNo(String registrationSerialNo) {
        this.registrationSerialNo = registrationSerialNo;
    }

    public Timestamp getSubmissionDatetime() {
        return submissionDatetime;
    }

    public void setSubmissionDatetime(Timestamp submissionDatetime) {
        this.submissionDatetime = submissionDatetime;
    }

    public Timestamp getAcceptanceDatetime() {
        return acceptanceDatetime;
    }

    public void setAcceptanceDatetime(Timestamp acceptanceDatetime) {
        this.acceptanceDatetime = acceptanceDatetime;
    }

    public Integer getSequenceNoForCase() {
        return sequenceNoForCase;
    }

    public void setSequenceNoForCase(Integer sequenceNoForCase) {
        this.sequenceNoForCase = sequenceNoForCase;
    }

    public HandlingAgentDTO getHandlingAgent() {
        return handlingAgent;
    }

    public void setHandlingAgent(HandlingAgentDTO handlingAgent) {
        this.handlingAgent = handlingAgent;
    }

    public RequestStatusTypeDTO getRequestStatusType() {
        return requestStatusType;
    }

    public void setRequestStatusType(RequestStatusTypeDTO requestStatusType) {
        this.requestStatusType = requestStatusType;
    }

    public BailiffOfficeDTO getBailiffOffice() {
        return bailiffOffice;
    }

    public void setBailiffOffice(BailiffOfficeDTO bailiffOffice) {
        this.bailiffOffice = bailiffOffice;
    }

    @Override
    public String toString() {
        return "RequestDTO [requestId=" + requestId + ", registrationNo=" + registrationNo
                + ", caseNo=" + caseNo + ", caseId=" + caseId + ", caseCourtSystem="
                + caseCourtSystem + ", caseType=" + caseType + ", caseSerialNo=" + caseSerialNo
                + ", caseYear=" + caseYear + ", requestType=" + requestType + ", registrationYear="
                + registrationYear + ", registrationSerialNo=" + registrationSerialNo
                + ", submissionDatetime=" + submissionDatetime + ", acceptanceDatetime="
                + acceptanceDatetime + ", sequenceNoForCase=" + sequenceNoForCase
                + ", handlingAgent=" + handlingAgent + ", requestStatusType=" + requestStatusType
                + ", bailiffOffice=" + bailiffOffice + "]";
    }

}
