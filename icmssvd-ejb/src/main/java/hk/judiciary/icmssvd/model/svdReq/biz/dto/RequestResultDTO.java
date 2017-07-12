package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.Date;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultReasonDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultStatusDTO;

/**
 * 
 * @version $Revision: 7060 $ $Date: 2017-05-20 12:12:34 +0800 (週六, 20 五月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestResultDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer requestResultId;
    private Integer requestId;
    private BailiffTaskResultStatusDTO bailiffTaskResultStatus;
    private Date endorsementDate;
    private BailiffTaskResultReasonDTO bailiffTaskResultReason;
    private Date serviceDate;
    private Date serviceReturnDate;
    private String requestResultNotes;
    private String processedBy;
    private Integer attemptNo;

    public Integer getRequestResultId() {
        return requestResultId;
    }

    public void setRequestResultId(Integer requestResultId) {
        this.requestResultId = requestResultId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public BailiffTaskResultStatusDTO getBailiffTaskResultStatus() {
        return bailiffTaskResultStatus;
    }

    public void setBailiffTaskResultStatus(BailiffTaskResultStatusDTO bailiffTaskResultStatus) {
        this.bailiffTaskResultStatus = bailiffTaskResultStatus;
    }

    public Date getEndorsementDate() {
        return endorsementDate;
    }

    public void setEndorsementDate(Date endorsementDate) {
        this.endorsementDate = endorsementDate;
    }

    public BailiffTaskResultReasonDTO getBailiffTaskResultReason() {
        return bailiffTaskResultReason;
    }

    public void setBailiffTaskResultReason(BailiffTaskResultReasonDTO bailiffTaskResultReason) {
        this.bailiffTaskResultReason = bailiffTaskResultReason;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getServiceReturnDate() {
        return serviceReturnDate;
    }

    public void setServiceReturnDate(Date serviceReturnDate) {
        this.serviceReturnDate = serviceReturnDate;
    }

    public String getRequestResultNotes() {
        return requestResultNotes;
    }

    public void setRequestResultNotes(String requestResultNotes) {
        this.requestResultNotes = requestResultNotes;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public Integer getAttemptNo() {
        return attemptNo;
    }

    public void setAttemptNo(Integer attemptNo) {
        this.attemptNo = attemptNo;
    }

    @Override
    public String toString() {
        return "RequestResultDTO [requestResultId=" + requestResultId + ", requestId=" + requestId
                + ", bailiffTaskResultStatus=" + bailiffTaskResultStatus + ", endorsementDate="
                + endorsementDate + ", bailiffTaskResultReason=" + bailiffTaskResultReason
                + ", serviceDate=" + serviceDate + ", serviceReturnDate=" + serviceReturnDate
                + ", requestResultNotes=" + requestResultNotes + ", processedBy=" + processedBy
                + ", attemptNo=" + attemptNo + "]";
    }

}
