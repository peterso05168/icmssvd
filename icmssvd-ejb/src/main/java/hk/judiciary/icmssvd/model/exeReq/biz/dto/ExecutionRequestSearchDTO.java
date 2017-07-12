package hk.judiciary.icmssvd.model.exeReq.biz.dto;

import java.util.Date;
import java.util.List;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ComprisingCourtDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class ExecutionRequestSearchDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Date submitStartDate;
    private Date submitEndDate;
    private String caseNo;
    private ComprisingCourtDTO comprisingCourt;
    private CaseTypeDTO caseType;
    private List<RequestStatusTypeDTO> requestStatusTypes;
    private FunctionDTO func;

    public Date getSubmitStartDate() {
        return submitStartDate;
    }

    public void setSubmitStartDate(Date submitStartDate) {
        this.submitStartDate = submitStartDate;
    }

    public Date getSubmitEndDate() {
        return submitEndDate;
    }

    public void setSubmitEndDate(Date submitEndDate) {
        this.submitEndDate = submitEndDate;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public ComprisingCourtDTO getComprisingCourt() {
        return comprisingCourt;
    }

    public void setComprisingCourt(ComprisingCourtDTO comprisingCourt) {
        this.comprisingCourt = comprisingCourt;
    }

    public CaseTypeDTO getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseTypeDTO caseType) {
        this.caseType = caseType;
    }

    public List<RequestStatusTypeDTO> getRequestStatusTypes() {
        return requestStatusTypes;
    }

    public void setRequestStatusTypes(List<RequestStatusTypeDTO> requestStatusTypes) {
        this.requestStatusTypes = requestStatusTypes;
    }

    public FunctionDTO getFunc() {
        return func;
    }

    public void setFunc(FunctionDTO func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return "ExecutionRequestSearchDTO [submitStartDate=" + submitStartDate + ", submitEndDate="
                + submitEndDate + ", caseNo=" + caseNo + ", comprisingCourt=" + comprisingCourt
                + ", caseType=" + caseType + ", requestStatusTypes=" + requestStatusTypes
                + ", func=" + func + "]";
    }

}
