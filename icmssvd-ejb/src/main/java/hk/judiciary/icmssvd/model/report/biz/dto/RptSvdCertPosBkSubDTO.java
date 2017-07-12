package hk.judiciary.icmssvd.model.report.biz.dto;

import hk.judiciary.fmk.model.report.biz.dto.ReportRequestData;

public class RptSvdCertPosBkSubDTO implements ReportRequestData {
	private String defendantName;
	private String defendantAddress1;
	private String defendantAddress2;
	private String defendantAddress3;
	private String caseNo;
	private String drnNo;
	private String totalPostage;
	private String arService;

	public String getDefendantName() {
		return defendantName;
	}

	public void setDefendantName(String defendantName) {
		this.defendantName = defendantName;
	}

	public String getDefendantAddress1() {
		return defendantAddress1;
	}

	public void setDefendantAddress1(String defendantAddress1) {
		this.defendantAddress1 = defendantAddress1;
	}

	public String getDefendantAddress2() {
		return defendantAddress2;
	}

	public void setDefendantAddress2(String defendantAddress2) {
		this.defendantAddress2 = defendantAddress2;
	}

	public String getDefendantAddress3() {
		return defendantAddress3;
	}

	public void setDefendantAddress3(String defendantAddress3) {
		this.defendantAddress3 = defendantAddress3;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getDrnNo() {
		return drnNo;
	}

	public void setDrnNo(String drnNo) {
		this.drnNo = drnNo;
	}

	public String getTotalPostage() {
		return totalPostage;
	}

	public void setTotalPostage(String totalPostage) {
		this.totalPostage = totalPostage;
	}

	public String getArService() {
		return arService;
	}

	public void setArService(String arService) {
		this.arService = arService;
	}

}
