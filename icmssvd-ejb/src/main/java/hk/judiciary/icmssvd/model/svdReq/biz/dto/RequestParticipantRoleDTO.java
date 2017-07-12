package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class RequestParticipantRoleDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer requestParticipantRoleId;
    private Integer requestId;
    private Integer participantId;
    private Integer originalParticipantRoleId;
    private Integer partyCategoryId;
    private Integer participantRoleTypeId;
    private Integer respondentSeqNo;
    private Integer respondentSubSeqNo;
    private Integer recipientRequesterIndicator;

    public Integer getRequestParticipantRoleId() {
        return requestParticipantRoleId;
    }

    public void setRequestParticipantRoleId(Integer requestParticipantRoleId) {
        this.requestParticipantRoleId = requestParticipantRoleId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getOriginalParticipantRoleId() {
        return originalParticipantRoleId;
    }

    public void setOriginalParticipantRoleId(Integer originalParticipantRoleId) {
        this.originalParticipantRoleId = originalParticipantRoleId;
    }

    public Integer getPartyCategoryId() {
        return partyCategoryId;
    }

    public void setPartyCategoryId(Integer partyCategoryId) {
        this.partyCategoryId = partyCategoryId;
    }

    public Integer getParticipantRoleTypeId() {
        return participantRoleTypeId;
    }

    public void setParticipantRoleTypeId(Integer participantRoleTypeId) {
        this.participantRoleTypeId = participantRoleTypeId;
    }

    public Integer getRespondentSeqNo() {
        return respondentSeqNo;
    }

    public void setRespondentSeqNo(Integer respondentSeqNo) {
        this.respondentSeqNo = respondentSeqNo;
    }

    public Integer getRespondentSubSeqNo() {
        return respondentSubSeqNo;
    }

    public void setRespondentSubSeqNo(Integer respondentSubSeqNo) {
        this.respondentSubSeqNo = respondentSubSeqNo;
    }

    public Integer getRecipientRequesterIndicator() {
        return recipientRequesterIndicator;
    }

    public void setRecipientRequesterIndicator(Integer recipientRequesterIndicator) {
        this.recipientRequesterIndicator = recipientRequesterIndicator;
    }

    @Override
    public String toString() {
        return "RequestParticipantRoleDTO [requestParticipantRoleId=" + requestParticipantRoleId
                + ", requestId=" + requestId + ", participantId=" + participantId
                + ", originalParticipantRoleId=" + originalParticipantRoleId + ", partyCategoryId="
                + partyCategoryId + ", participantRoleTypeId=" + participantRoleTypeId
                + ", respondentSeqNo=" + respondentSeqNo + ", respondentSubSeqNo="
                + respondentSubSeqNo + ", recipientRequesterIndicator="
                + recipientRequesterIndicator + "]";
    }

}
