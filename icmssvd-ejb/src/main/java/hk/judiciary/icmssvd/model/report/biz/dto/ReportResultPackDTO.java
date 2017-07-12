package hk.judiciary.icmssvd.model.report.biz.dto;

import hk.judiciary.fmk.model.report.biz.dto.ReportRequestRequestParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icmssvd.model.BaseDTO;

public class ReportResultPackDTO extends BaseDTO {
	
    private static final long serialVersionUID = 1L;

	private ReportRequestRequestParameterDTO requestParameter;
	private ReportResultDTO reportResult;
	private String reportTypeCode;
	
	public ReportResultPackDTO(ReportRequestRequestParameterDTO requestParameter, ReportResultDTO reportResult, String reportTypeCode) {
		this.requestParameter = requestParameter;
		this.reportResult = reportResult;
		this.reportTypeCode = reportTypeCode;
	}
	
	public ReportRequestRequestParameterDTO getRequestParameter() {
		return requestParameter;
	}
	public void setRequestParameter(ReportRequestRequestParameterDTO requestParameter) {
		this.requestParameter = requestParameter;
	}
	
	public ReportResultDTO getReportResult() {
		return reportResult;
	}
	public void setReportResult(ReportResultDTO reportResult) {
		this.reportResult = reportResult;
	}
		
	public String getReportTypeCode() {
		return reportTypeCode;
	}
	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}
	
}