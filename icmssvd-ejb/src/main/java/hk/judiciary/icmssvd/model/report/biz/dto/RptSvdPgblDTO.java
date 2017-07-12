package hk.judiciary.icmssvd.model.report.biz.dto;

import hk.judiciary.fmk.model.report.biz.dto.ReportRequestData;

public class RptSvdPgblDTO implements ReportRequestData {
    
	private String copyType;
	private String langType;
	private String omrData;
	private String jobCnt;
	private String pageCnt;
	private String caseCnt;
	private String miscCnt; 
    
	private String caseNo;
	private String dateOfHearing;
	private String courtOfHearing;
	private String venueOfHearing;
	private String addressOfHearing;
	private String enquiryPhoneNo;
	private String enquiryDate;

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
	
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getDateOfHearing() {
		return dateOfHearing;
	}
	public void setDateOfHearing(String dateOfHearing) {
		this.dateOfHearing = dateOfHearing;
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
	public String getEnquiryPhoneNo() {
		return enquiryPhoneNo;
	}
	public void setEnquiryPhoneNo(String enquiryPhoneNo) {
		this.enquiryPhoneNo = enquiryPhoneNo;
	}
	public String getEnquiryDate() {
		return enquiryDate;
	}
	public void setEnquiryDate(String enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

}
