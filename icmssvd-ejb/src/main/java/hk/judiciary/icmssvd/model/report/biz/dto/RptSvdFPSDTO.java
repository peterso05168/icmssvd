package hk.judiciary.icmssvd.model.report.biz.dto;

import java.util.List;

import hk.judiciary.fmk.model.report.biz.dto.ReportRequestData;

public class RptSvdFPSDTO implements ReportRequestData {

	private String langType;
	private String copyType; // partly used
	private String caseNo;
	private String regNo;
	private String drnNo;
	private String courtName;
	private String courtAddress;
	private String defendantName;
	private String defendantAddress1;
	private String defendantAddress2;
	private String defendantAddress3;
	private String defendantIdNo; // partly used
	private String defendantDrivingLicenseNo; // partly used
	private String defendantGender;
	private String defendantAge;
	private String pdRefNo;
	private String chargeParticular;
	private String contraryToLaw;
	private String informant;
	private String caseInitiateDate;
	private String dateOfHearing;
	private String timeOfHearing;
	private String courtRoomOfHearing;
	private String courtOfHearing;
	private String issueDate;
	private String fixedPenaltyAmt;
	private String additionalPenaltyAmt;
	private String costs;
	private String paymentAmt;

	private List<OffenceDTO> offences;

	public String getLangType() {
		return langType;
	}

	public void setLangType(String langType) {
		this.langType = langType;
	}

	public String getCopyType() {
		return copyType;
	}

	public void setCopyType(String copyType) {
		this.copyType = copyType;
	}

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

	public String getDrnNo() {
		return drnNo;
	}

	public void setDrnNo(String drnNo) {
		this.drnNo = drnNo;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getCourtAddress() {
		return courtAddress;
	}

	public void setCourtAddress(String courtAddress) {
		this.courtAddress = courtAddress;
	}

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

	public String getDefendantDrivingLicenseNo() {
		return defendantDrivingLicenseNo;
	}

	public void setDefendantDrivingLicenseNo(String defendantDrivingLicenseNo) {
		this.defendantDrivingLicenseNo = defendantDrivingLicenseNo;
	}

	public String getDefendantIdNo() {
		return defendantIdNo;
	}

	public void setDefendantIdNo(String defendantIdNo) {
		this.defendantIdNo = defendantIdNo;
	}

	public String getDefendantGender() {
		return defendantGender;
	}

	public void setDefendantGender(String defendantGender) {
		this.defendantGender = defendantGender;
	}

	public String getDefendantAge() {
		return defendantAge;
	}

	public void setDefendantAge(String defendantAge) {
		this.defendantAge = defendantAge;
	}

	public String getPdRefNo() {
		return pdRefNo;
	}

	public void setPdRefNo(String pdRefNo) {
		this.pdRefNo = pdRefNo;
	}

	public String getChargeParticular() {
		return chargeParticular;
	}

	public void setChargeParticular(String chargeParticular) {
		this.chargeParticular = chargeParticular;
	}

	public String getContraryToLaw() {
		return contraryToLaw;
	}

	public void setContraryToLaw(String contraryToLaw) {
		this.contraryToLaw = contraryToLaw;
	}

	public String getInformant() {
		return informant;
	}

	public void setInformant(String informant) {
		this.informant = informant;
	}

	public String getCaseInitiateDate() {
		return caseInitiateDate;
	}

	public void setCaseInitiateDate(String caseInitiateDate) {
		this.caseInitiateDate = caseInitiateDate;
	}

	public String getDateOfHearing() {
		return dateOfHearing;
	}

	public void setDateOfHearing(String dateOfHearing) {
		this.dateOfHearing = dateOfHearing;
	}

	public String getTimeOfHearing() {
		return timeOfHearing;
	}

	public void setTimeOfHearing(String timeOfHearing) {
		this.timeOfHearing = timeOfHearing;
	}

	public String getCourtRoomOfHearing() {
		return courtRoomOfHearing;
	}

	public void setCourtRoomOfHearing(String courtRoomOfHearing) {
		this.courtRoomOfHearing = courtRoomOfHearing;
	}

	public String getCourtOfHearing() {
		return courtOfHearing;
	}

	public void setCourtOfHearing(String courtOfHearing) {
		this.courtOfHearing = courtOfHearing;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getFixedPenaltyAmt() {
		return fixedPenaltyAmt;
	}

	public void setFixedPenaltyAmt(String fixedPenaltyAmt) {
		this.fixedPenaltyAmt = fixedPenaltyAmt;
	}

	public String getAdditionalPenaltyAmt() {
		return additionalPenaltyAmt;
	}

	public void setAdditionalPenaltyAmt(String additionalPenaltyAmt) {
		this.additionalPenaltyAmt = additionalPenaltyAmt;
	}

	public String getCosts() {
		return costs;
	}

	public void setCosts(String costs) {
		this.costs = costs;
	}

	public String getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(String paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public List<OffenceDTO> getOffences() {
		return offences;
	}

	public void setOffences(List<OffenceDTO> offences) {
		this.offences = offences;
	}

}
