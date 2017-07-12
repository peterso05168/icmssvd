package hk.judiciary.icmssvd.model.report.biz.dto;

import hk.judiciary.fmk.model.report.biz.dto.ReportRequestData;

public class RptSvdDSub2DTO implements ReportRequestData {
	private String transportDeptRefNo;
	private String caseNo;
	private String disqualificationOrderDate;
	private String disqualificationPeriod;

	public String getTransportDeptRefNo() {
		return transportDeptRefNo;
	}

	public void setTransportDeptRefNo(String transportDeptRefNo) {
		this.transportDeptRefNo = transportDeptRefNo;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getDisqualificationOrderDate() {
		return disqualificationOrderDate;
	}

	public void setDisqualificationOrderDate(String disqualificationOrderDate) {
		this.disqualificationOrderDate = disqualificationOrderDate;
	}

	public String getDisqualificationPeriod() {
		return disqualificationPeriod;
	}

	public void setDisqualificationPeriod(String disqualificationPeriod) {
		this.disqualificationPeriod = disqualificationPeriod;
	}
}