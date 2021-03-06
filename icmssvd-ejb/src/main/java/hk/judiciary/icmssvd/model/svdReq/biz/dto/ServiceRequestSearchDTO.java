package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.Date;
import java.util.List;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ComprisingCourtDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HandlingAgentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class ServiceRequestSearchDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Date submitStartDate;
    private Date submitEndDate;
    private String caseNo;
    private ComprisingCourtDTO comprisingCourt;
    private CaseTypeDTO caseType;
    private ServiceModeTypeDTO serviceModeType;
    private HandlingAgentDTO handlingAgent;
    private List<RequestStatusTypeDTO> requestStatusType;
    private RequestServiceTypeDTO requestServiceType;
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

    public ServiceModeTypeDTO getServiceModeType() {
        return serviceModeType;
    }

    public void setServiceModeType(ServiceModeTypeDTO serviceModeType) {
        this.serviceModeType = serviceModeType;
    }

    public HandlingAgentDTO getHandlingAgent() {
        return handlingAgent;
    }

    public void setHandlingAgent(HandlingAgentDTO handlingAgent) {
        this.handlingAgent = handlingAgent;
    }

    public List<RequestStatusTypeDTO> getRequestStatusType() {
        return requestStatusType;
    }

    public void setRequestStatusType(List<RequestStatusTypeDTO> requestStatusType) {
        this.requestStatusType = requestStatusType;
    }

    public RequestServiceTypeDTO getRequestServiceType() {
        return requestServiceType;
    }

    public void setRequestServiceType(RequestServiceTypeDTO requestServiceType) {
        this.requestServiceType = requestServiceType;
    }

    public FunctionDTO getFunc() {
        return func;
    }

    public void setFunc(FunctionDTO func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return "ServiceRequestSearchDTO [submitStartDate=" + submitStartDate + ", submitEndDate="
                + submitEndDate + ", caseNo=" + caseNo + ", comprisingCourt=" + comprisingCourt
                + ", caseType=" + caseType + ", serviceModeType=" + serviceModeType
                + ", handlingAgent=" + handlingAgent + ", requestStatusType=" + requestStatusType
                + ", requestServiceType=" + requestServiceType + ", func=" + func + "]";
    }

}
