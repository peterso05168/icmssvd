package hk.judiciary.icmssvd.model.report.biz.dto;

import java.util.List;

import hk.judiciary.fmk.model.report.biz.dto.ReportRequestData;

public class RptSvdDDTO implements ReportRequestData {
	private String caseNo;
	private String regNo;
	private String drnNo;
	private String courtName;
	private String courtAddress;
	private String defendantName;
	private String defendantAddress1;
	private String defendantAddress2;
	private String defendantAddress3;
	private String defendantDocNo;
	private String defendantDrivingLicenseNo;
	private String defendantGender;
	private String defendantAge;
	private String pdRefNo;
	private String chargeParticular;
	private String contraryToLaw;
	private String caseInitiateDate;
	private String informant;
	private String dateOfHearing;
	private String timeOfHearing;
	private String courtOfHearing;
	private String courtRoomOfHearing;
	private String issueDate;
	private String defendantNameChi;
	private String defendantNameEng;
	private String DrivingLicenseNo;
	private String adviceServedDate;
	private String disqualificationRecordDate;
	private String templateNo;

	private List<RptSvdDSub1DTO> drivingOffence1;
	private List<RptSvdDSub2DTO> drivingOffence2;

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

	public String getDefendantDocNo() {
		return defendantDocNo;
	}

	public void setDefendantDocNo(String defendantDocNo) {
		this.defendantDocNo = defendantDocNo;
	}

	public String getDefendantDrivingLicenseNo() {
		return defendantDrivingLicenseNo;
	}

	public void setDefendantDrivingLicenseNo(String defendantDrivingLicenseNo) {
		this.defendantDrivingLicenseNo = defendantDrivingLicenseNo;
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

	public String getCaseInitiateDate() {
		return caseInitiateDate;
	}

	public void setCaseInitiateDate(String caseInitiateDate) {
		this.caseInitiateDate = caseInitiateDate;
	}

	public String getInformant() {
		return informant;
	}

	public void setInformant(String informant) {
		this.informant = informant;
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

	public String getCourtOfHearing() {
		return courtOfHearing;
	}

	public void setCourtOfHearing(String courtOfHearing) {
		this.courtOfHearing = courtOfHearing;
	}

	public String getCourtRoomOfHearing() {
		return courtRoomOfHearing;
	}

	public void setCourtRoomOfHearing(String courtRoomOfHearing) {
		this.courtRoomOfHearing = courtRoomOfHearing;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getDefendantNameChi() {
		return defendantNameChi;
	}

	public void setDefendantNameChi(String defendantNameChi) {
		this.defendantNameChi = defendantNameChi;
	}

	public String getDefendantNameEng() {
		return defendantNameEng;
	}

	public void setDefendantNameEng(String defendantNameEng) {
		this.defendantNameEng = defendantNameEng;
	}

	public String getDrivingLicenseNo() {
		return DrivingLicenseNo;
	}

	public void setDrivingLicenseNo(String drivingLicenseNo) {
		DrivingLicenseNo = drivingLicenseNo;
	}

	public String getAdviceServedDate() {
		return adviceServedDate;
	}

	public void setAdviceServedDate(String adviceServedDate) {
		this.adviceServedDate = adviceServedDate;
	}

	public String getDisqualificationRecordDate() {
		return disqualificationRecordDate;
	}

	public void setDisqualificationRecordDate(String disqualificationRecordDate) {
		this.disqualificationRecordDate = disqualificationRecordDate;
	}

	public String getTemplateNo() {
		return templateNo;
	}

	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}

	public List<RptSvdDSub1DTO> getDrivingOffence1() {
		return drivingOffence1;
	}

	public void setDrivingOffence1(List<RptSvdDSub1DTO> drivingOffence1) {
		this.drivingOffence1 = drivingOffence1;
	}

	public List<RptSvdDSub2DTO> getDrivingOffence2() {
		return drivingOffence2;
	}

	public void setDrivingOffence2(List<RptSvdDSub2DTO> drivingOffence2) {
		this.drivingOffence2 = drivingOffence2;
	}
}


