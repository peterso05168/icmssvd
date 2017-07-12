package hk.judiciary.icmssvd.model.report.biz;

import java.util.Map;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestRequestParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icmssvd.model.BaseBO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;

public abstract class SvdReportBaseBO extends BaseBO {	
	protected JudiciaryUser user;
	protected Map<String, Object> reportCriteria;
	protected CopyTypeConstant copyType;
	protected int jobNo;
	protected int totalPageCount;
	protected int totalCaseCount;
	protected int groupPageCount;
	protected ReportRequestRequestParameterDTO requestParameter;
	
	public SvdReportBaseBO(JudiciaryUser user) {
		this.user = user;
	}
	
	public ReportRequestRequestParameterDTO getRequestParameter() {
		return requestParameter;
	}

	protected String genOmrMark(boolean lastPage, int groupNo, int pageNo) {
		String omrMark = "000000000";
		String mNMKBM1 = "1";
		String mNMEOC1 = "0";
		String mGRPSQ = "";
		String mNMKSQ = "";
		String mParity = "";
		if (lastPage) {
			mNMEOC1 = "1";
		}
		switch (groupNo) {
			case 1: mGRPSQ =  "0001"; break;
			case 2: mGRPSQ =  "0010"; break;
			case 3: mGRPSQ =  "0011"; break;
			case 4: mGRPSQ =  "0100"; break;
			case 5: mGRPSQ =  "0101"; break;
			case 6: mGRPSQ =  "0110"; break;
			case 7: mGRPSQ =  "0111"; break;
			case 8: mGRPSQ =  "1000"; break;
			case 9: mGRPSQ =  "1001"; break;
			case 10: mGRPSQ = "1010"; break;
			case 11: mGRPSQ = "1011"; break;
			case 12: mGRPSQ = "1100"; break;
			case 13: mGRPSQ = "1101"; break;
			case 14: mGRPSQ = "1110"; break;
			case 15: mGRPSQ = "1111"; break;
			default: mGRPSQ = "0000"; break;
		}
		mGRPSQ = new StringBuilder(mGRPSQ).reverse().toString();
		
		switch (pageNo) {
			case 1: mNMKSQ =  "00001"; break;
			case 2: mNMKSQ =  "00010"; break;
			case 3: mNMKSQ =  "00011"; break;
			case 4: mNMKSQ =  "00100"; break;
			case 5: mNMKSQ =  "00101"; break;
			case 6: mNMKSQ =  "00110"; break;
			case 7: mNMKSQ =  "00111"; break;
			case 8: mNMKSQ =  "01000"; break;
			case 9: mNMKSQ =  "01001"; break;
			case 10: mNMKSQ = "01010"; break;
			case 11: mNMKSQ = "01011"; break;
			case 12: mNMKSQ = "01100"; break;
			case 13: mNMKSQ = "01101"; break;
			case 14: mNMKSQ = "01110"; break;
			case 15: mNMKSQ = "01111"; break;
			case 16: mNMKSQ = "10000"; break;
			case 17: mNMKSQ = "10001"; break;
			case 18: mNMKSQ = "10010"; break;
			case 19: mNMKSQ = "10011"; break;
			case 20: mNMKSQ = "10100"; break;
			case 21: mNMKSQ = "10101"; break;
			case 22: mNMKSQ = "10110"; break;
			case 23: mNMKSQ = "10111"; break;
			case 24: mNMKSQ = "11000"; break;
			case 25: mNMKSQ = "11001"; break;
			case 26: mNMKSQ = "11010"; break;
			case 27: mNMKSQ = "11011"; break;
			case 28: mNMKSQ = "11100"; break;
			case 29: mNMKSQ = "11101"; break;
			case 30: mNMKSQ = "11110"; break;
			case 31: mNMKSQ = "11111"; break;			
			default: mNMKSQ = "00000"; break;
		}
		mNMKSQ = new StringBuilder(mNMKSQ).reverse().toString();
		
		String omrPrefix = mNMKBM1 + mNMEOC1;
		String omrSuffix = mNMKSQ + mGRPSQ;
		
		String omrTmp = omrPrefix + omrSuffix;
		int markCourt = 0;
		for (int i=0; i<omrTmp.length(); i++) {
			if (omrTmp.substring(i, i+1).equals("1")) {
				markCourt ++;
			}
		}
		mParity = String.valueOf(markCourt%2);
		
		omrMark += omrPrefix + mParity + omrSuffix;
		
		info(">>>>> OMR Mark: "+omrMark);
		
		return omrMark;
	}
	
	protected void addPage() {
		totalPageCount++;
		groupPageCount++;
		
		info(">>>>> totalPage "+totalPageCount+" groupPage "+groupPageCount);
	}
	
	protected void resetGroupPageCount() {
		groupPageCount = -1;
	}
	
	protected abstract void retrieveData() throws Exception;
	protected abstract Object constructReportData() throws Exception;
	protected abstract ReportResultDTO genReport(Map<String, Object> reportCriteria, CopyTypeConstant copyType) throws Exception;
	
	public int getGroupPageCount() {
		return groupPageCount;
	}
	
	public void setGroupPageCount(int groupPageCount) {
		this.groupPageCount = groupPageCount;
	}
	
	protected int getJobPageCount() {
		if (totalPageCount > 0) {
			return totalPageCount%32;
		} else {
			return totalPageCount;
		}
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void setTotalCaseCount(int totalCaseCount) {
		this.totalCaseCount = totalCaseCount;
	}

	// For JobNo
	public String getJobCnt() {
		return String.format("%08d", jobNo);
	}
	public String getPageCnt() {
		return String.format("%05d", totalPageCount + 1);
	}
	public String getCaseCnt() {
		return String.format("%04d", totalCaseCount);
	}

	public boolean isPgblRequired() {
		return false;
	}
}
