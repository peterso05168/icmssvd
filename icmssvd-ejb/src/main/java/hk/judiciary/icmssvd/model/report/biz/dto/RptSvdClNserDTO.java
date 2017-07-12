package hk.judiciary.icmssvd.model.report.biz.dto;

import hk.judiciary.fmk.model.report.biz.dto.ReportRequestData;

public class RptSvdClNserDTO implements ReportRequestData {

	private String courtName;
	private String effectiveFrom;
	private String effectiveTo;
	private String caseNo;
	private String serviceMode;
	private String serviceAgent;
	private String defendantName;
	private String nextHearingDate;
	private String noOfAttemptMade;
	private String nonServiceReason;
	private String totalNoOfCase;

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public String getEffectiveTo() {
		return effectiveTo;
	}

	public void setEffectiveTo(String effectiveTo) {
		this.effectiveTo = effectiveTo;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}

	public String getServiceAgent() {
		return serviceAgent;
	}

	public void setServiceAgent(String serviceAgent) {
		this.serviceAgent = serviceAgent;
	}

	public String getDefendantName() {
		return defendantName;
	}

	public void setDefendantName(String defendantName) {
		this.defendantName = defendantName;
	}

	public String getNextHearingDate() {
		return nextHearingDate;
	}

	public void setNextHearingDate(String nextHearingDate) {
		this.nextHearingDate = nextHearingDate;
	}

	public String getNoOfAttemptMade() {
		return noOfAttemptMade;
	}

	public void setNoOfAttemptMade(String noOfAttemptMade) {
		this.noOfAttemptMade = noOfAttemptMade;
	}

	public String getNonServiceReason() {
		return nonServiceReason;
	}

	public void setNonServiceReason(String nonServiceReason) {
		this.nonServiceReason = nonServiceReason;
	}

	public String getTotalNoOfCase() {
		return totalNoOfCase;
	}

	public void setTotalNoOfCase(String totalNoOfCase) {
		this.totalNoOfCase = totalNoOfCase;
	}
}
