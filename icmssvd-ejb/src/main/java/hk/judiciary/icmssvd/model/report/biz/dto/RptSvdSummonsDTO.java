package hk.judiciary.icmssvd.model.report.biz.dto;

import java.util.List;

import hk.judiciary.fmk.model.report.biz.dto.ReportRequestData;

public class RptSvdSummonsDTO implements ReportRequestData {
	
	private String copyType;
	private String langType;
	private String omrData;
	private String jobCnt;
	private String pageCnt;
	private String caseCnt;
	private String miscCnt;    
	
	private String formName1;
	private String formName2;
	private String caseNo;
	private String regNo;
	private String drnNo;
	private String courtName;
	private String courtAddress;
	private String defendantName;
	private String defendantNameImage;
	private String defendantAddress1;
	private String defendantAddress2;
	private String defendantAddress3;
	private String defendantDocType;
	private String defendantDocNo;
	private String defendantGender;
	private String defendantAge;
	private String pdRefNo;
	private String chargeParticular;
	private String chargeParticularFontSize;
	private String contraryToLaw;
	private String informant;
	private String caseInitiateDate;
	private String dateOfHearing;
	private String timeOfHearing;
	private String courtRoomOfHearing;
	private String courtOfHearing;	
	private String venueOfHearing;
	private String addressOfHearing;
	private String remarks;
	private String issueDate;
	private String templateNo;
	private String additionalPage;
    
	// For Fixed Penalty
	private String fixedPenaltyAmt;
	private String additionalPenaltyAmt;
	private String costs;
	private String paymentAmt;

	// For Driving Offence Points
	private List<OffenceDTO> offences;
	private String defendantNameChi;
	private String defendantNameEng;
	private String defendantDrivingLicenseNo;
	private String adviceServedDate;
	private String disqualificationRecordDate;
	private List<DisqualificationDTO> disqualifications;
    
	public String getCopyType() {
		return copyType;
	}
	public void setCopyType(String copyType) {
		this.copyType = copyType;
	}
	public String getLangType() {
		return langType;
	}
	public void setLangType(String langType) {
		this.langType = langType;
	}
	public String getOmrData() {
		return omrData;
	}
	public void setOmrData(String omrData) {
		this.omrData = omrData;
	}
	public String getJobCnt() {
		return jobCnt;
	}
	public void setJobCnt(String jobCnt) {
		this.jobCnt = jobCnt;
	}    
	public String getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(String pageCnt) {
		this.pageCnt = pageCnt;
	}
	public String getCaseCnt() {
		return caseCnt;
	}
	public void setCaseCnt(String caseCnt) {
		this.caseCnt = caseCnt;
	}
	public String getMiscCnt() {
		return miscCnt;
	}
	public void setMiscCnt(String miscCnt) {
		this.miscCnt = miscCnt;
	}

	public String getFormName1() {
		return formName1;
	}
	public void setFormName1(String formName1) {
		this.formName1 = formName1;
	}
	public String getFormName2() {
		return formName2;
	}
	public void setFormName2(String formName2) {
		this.formName2 = formName2;
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
	public String getDefendantNameImage() {
		return defendantNameImage;
	}
	public void setDefendantNameImage(String defendantNameImage) {
		this.defendantNameImage = defendantNameImage;
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
	public String getDefendantDocType() {
		return defendantDocType;
	}
	public void setDefendantDocType(String defendantDocType) {
		this.defendantDocType = defendantDocType;
	}
	public String getDefendantDocNo() {
		return defendantDocNo;
	}
	public void setDefendantDocNo(String defendantDocNo) {
		this.defendantDocNo = defendantDocNo;
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
	public String getChargeParticularFontSize() {
		return chargeParticularFontSize;
	}
	public void setChargeParticularFontSize(String chargeParticularFontSize) {
		this.chargeParticularFontSize = chargeParticularFontSize;
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
	public String getVenueOfHearing() {
		return venueOfHearing;
	}
	public void setVenueOfHearing(String venueOfHearing) {
		this.venueOfHearing = venueOfHearing;
	}
	public String getAddressOfHearing() {
		return addressOfHearing;
	}
	public void setAddressOfHearing(String addressOfHearing) {
		this.addressOfHearing = addressOfHearing;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getTemplateNo() {
		return templateNo;
	}
	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}
	public String getAdditionalPage() {
		return additionalPage;
	}
	public void setAdditionalPage(String additionalPage) {
		this.additionalPage = additionalPage;
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
	public String getDefendantDrivingLicenseNo() {
		return defendantDrivingLicenseNo;
	}
	public void setDefendantDrivingLicenseNo(String defendantDrivingLicenseNo) {
		this.defendantDrivingLicenseNo = defendantDrivingLicenseNo;
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
	public List<DisqualificationDTO> getDisqualifications() {
		return disqualifications;
	}
	public void setDisqualifications(List<DisqualificationDTO> disqualifications) {
		this.disqualifications = disqualifications;
	}
}