package hk.judiciary.icmssvd.model.exeReq.biz.dto;

import java.util.Date;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PartyDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class ExecutionRequestSearchResultDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private IdDTO requestId;
    private Date submitDate;
    private String caseNo;
    private PartyDTO applicant;
    private BailiffOfficeDTO bailiffOffice;
    private RequestStatusTypeDTO requestStatusType;

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

    public PartyDTO getApplicant() {
        return applicant;
    }

    public void setApplicant(PartyDTO applicant) {
        this.applicant = applicant;
    }

    public BailiffOfficeDTO getBailiffOffice() {
        return bailiffOffice;
    }

    public void setBailiffOffice(BailiffOfficeDTO bailiffOffice) {
        this.bailiffOffice = bailiffOffice;
    }

    public RequestStatusTypeDTO getRequestStatusType() {
        return requestStatusType;
    }

    public void setRequestStatusType(RequestStatusTypeDTO requestStatusType) {
        this.requestStatusType = requestStatusType;
    }

    @Override
    public String toString() {
        return "ExecutionRequestSearchResultDTO [requestId=" + requestId + ", submitDate="
                + submitDate + ", caseNo=" + caseNo + ", applicant=" + applicant
                + ", bailiffOffice=" + bailiffOffice + ", requestStatusType=" + requestStatusType
                + "]";
    }

}
