package hk.judiciary.icmssvd.model.report.biz.dto;

public class RptSvdCertPosDsDTO {
	private String summonsNo;
	private String hearingDate;
	private String prosecutionDept;
	private String defendantName;
	private String defendantAddress1;
	private String defendantAddress2;
	private String defendantAddress3;
	private String caseNo;
	private String drnNo;
	private String registeredPostDate;
	private String postOffice;
	private String dateOfCertificate;
	private String nameOfPersonnel;
	private String courtName;
	
	
	
	public String getDrnNo() {
		return drnNo;
	}

	public void setDrnNo(String drnNo) {
		this.drnNo = drnNo;
	}

	public String getRegisteredPostDate() {
		return registeredPostDate;
	}

	public void setRegisteredPostDate(String registeredPostDate) {
		this.registeredPostDate = registeredPostDate;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String getNameOfPersonnel() {
		return nameOfPersonnel;
	}

	public void setNameOfPersonnel(String nameOfPersonnel) {
		this.nameOfPersonnel = nameOfPersonnel;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getSummonsNo() {
		return summonsNo;
	}

	public void setSummonsNo(String summonsNo) {
		this.summonsNo = summonsNo;
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

	public String getNameOfDefendant() {
		return defendantName;
	}

	public void setNameOfDefendant(String nameOfDefendant) {
		this.defendantName = nameOfDefendant;
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

	public String getDateOfCertificate() {
		return dateOfCertificate;
	}

	public void setDateOfCertificate(String dateOfCertificate) {
		this.dateOfCertificate = dateOfCertificate;
	}
}
