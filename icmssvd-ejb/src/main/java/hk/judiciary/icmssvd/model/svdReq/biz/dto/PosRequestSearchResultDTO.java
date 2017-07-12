package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.Date;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HandlingAgentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class PosRequestSearchResultDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private IdDTO requestId;
    private Date submitDate;
    private String caseNo;
    private PartyDTO requester;
    private PartyDTO recipient;
    private HandlingAgentDTO handlingAgent;
    private String posOrAcip;
    private Date dueOrHearingDate;

    public IdDTO getRequestId() {
        return requestId;
    }

    public void setRequestId(IdDTO requestId) {
        this.requestId = requestId;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
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

    public HandlingAgentDTO getHandlingAgent() {
        return handlingAgent;
    }

    public void setHandlingAgent(HandlingAgentDTO handlingAgent) {
        this.handlingAgent = handlingAgent;
    }

    public String getPosOrAcip() {
        return posOrAcip;
    }

    public void setPosOrAcip(String posOrAcip) {
        this.posOrAcip = posOrAcip;
    }

    public Date getDueOrHearingDate() {
        return dueOrHearingDate;
    }

    public void setDueOrHearingDate(Date dueOrHearingDate) {
        this.dueOrHearingDate = dueOrHearingDate;
    }

    @Override
    public String toString() {
        return "PosRequestDTO [requestId=" + requestId + ", submitDate=" + submitDate + ", caseNo="
                + caseNo + ", requester=" + requester + ", recipient=" + recipient
                + ", handlingAgent=" + handlingAgent + ", posOrAcip=" + posOrAcip
                + ", dueOrHearingDate=" + dueOrHearingDate + "]";
    }
}
