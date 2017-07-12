package hk.judiciary.icmssvd.model.report.biz.dto;

public class RptSvdCertOfSerDTO {
	private String caseNo;
	private String regNo;
	private String hearingDate;
	private String prosecutionDept;
	private String defendantName;
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getHearingDate() {
		return hearingDate;
	}
	public void setHearingDate(String hearingDate) {
		this.hearingDate = hearingDate;
	}
	public String getProsecutionDept() {
		return prosecutionDept;
	}
	public void setProsecutionDept(String prosecutionDept) {
		this.prosecutionDept = prosecutionDept;
	}
	public String getDefendantName() {
		return defendantName;
	}
	public void setDefendantName(String defendantName) {
		this.defendantName = defendantName;
	}

	
	
}
