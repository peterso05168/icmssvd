package hk.judiciary.icmssvd.model.report.biz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.ejb.report.ReportService;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestDataParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdPgblDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;


public class RptSvdPgblBO extends SvdReportBaseBO {
	
	public static final String NAME = "rptSvdPgblBO";

	public RptSvdPgblBO(JudiciaryUser user) {
		super(user);
	}
	
	private Case loadedCase;
	private Integer caseId;
	private HrnSchd loadedHrnSchd;
	
	@Override
	protected void retrieveData() throws Exception {
		loadedHrnSchd = (HrnSchd) reportCriteria.get("hrnSchd");		
		caseId = (Integer) reportCriteria.get("caseId");
		
		CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
		caseRetrieveCriteriaDTO.setCaseId(caseId);
		List<Case> cases = getDAO(CaseDAO.CASE_DAO, CaseDAO.class).retrieve(caseRetrieveCriteriaDTO);
		if (cases != null && cases.size() > 0) {
			loadedCase = cases.get(0);
			caseId = loadedCase.getCaseId();
		}
	}

	@Override
	protected Object constructReportData() throws Exception {
		// TODO Auto-generated method stub
		try {
			List<String> langCodes = new ArrayList<String>();
			if (copyType.getCode().equals(CopyTypeConstant.DEFENDANT.getCode())) {
				langCodes.add(SvdReportUtil.LANG_CODE_CHI);
				langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			} else if (copyType.getCode().equals(CopyTypeConstant.COURT.getCode()) ||
					   copyType.getCode().equals(CopyTypeConstant.PROSECUTION_DEPARTMENT.getCode())) {
				langCodes.add(SvdReportUtil.LANG_CODE_CHI);
				langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			} 
			
			List<RptSvdPgblDTO> dataObjects = new ArrayList<RptSvdPgblDTO>();
			RptSvdPgblDTO dataObject = null;
			String langCode;
			addPage();
			
			for (int i=0; i<langCodes.size(); i++) {
				langCode = langCodes.get(i);
				dataObject = new RptSvdPgblDTO();
				
				String enquiryPhoneNo = "2886 6775";
				
				dataObject.setCopyType(copyType.getCode());
				dataObject.setLangType(langCode);
				
				dataObject.setCaseNo(loadedCase.getCompsCourt().getCompsCourtPrfx() +
						loadedCase.getCaseType().getCaseTypeCd() + " " +
						loadedCase.getCaseSerNo() + "/" +
						loadedCase.getCaseYr());
				
				dataObject.setJobCnt(getJobCnt());
				dataObject.setPageCnt(getPageCnt());
				dataObject.setCaseCnt(getCaseCnt());
				dataObject.setMiscCnt("001");
				
				dataObject.setEnquiryPhoneNo(enquiryPhoneNo);
				
				if (loadedHrnSchd != null) {
					dataObject.setDateOfHearing(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), langCode));
					dataObject.setCourtOfHearing(SvdReportUtil.getComprisingCourtName(loadedHrnSchd.getListSchd().getList().getCompsCourt(), langCode));
					dataObject.setVenueOfHearing(SvdReportUtil.getCourtVenueName(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getCourtVenue(), langCode));
					dataObject.setAddressOfHearing(SvdReportUtil.getCourtVenueAddress(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getCourtVenue(), langCode));

					GregorianCalendar gCalendar = new GregorianCalendar();
					gCalendar.setTime(loadedHrnSchd.getListSchd().getListSchdDate());
					gCalendar.add(GregorianCalendar.DATE, 10);
					
					SimpleDateFormat enquiryDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
					dataObject.setEnquiryDate(enquiryDateFormat.format(gCalendar.getTime()));
					dataObject.setEnquiryPhoneNo(enquiryPhoneNo);
				} else {
					// Below Data are Dummy
					if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
						dataObject.setCourtOfHearing("Kowloon City Magistrates' Courts");
					} else if (langCode.equals(SvdReportUtil.LANG_CODE_CHI)) {
						dataObject.setCourtOfHearing("九龍城裁判法院");
					}
				}
				
				if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
					boolean isLastPage = true;
					dataObject.setOmrData(genOmrMark(isLastPage, getGroupPageCount(), getJobPageCount()));
				}
				dataObjects.add(dataObject);
			}
			
			return dataObjects;
		} catch (Exception e) {
			error(e);			
			throw e;
		}
	}

	@Override
	protected ReportResultDTO genReport(Map<String, Object> reportCriteria, CopyTypeConstant copyType) throws Exception {
		// TODO Auto-generated method stub
		this.reportCriteria = reportCriteria;
		this.copyType = copyType;
		
		retrieveData();
		
		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_PGBL);
		
		Object dataDTOList = constructReportData();
		
		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);
		
		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);
		
		return reportResultDTO;
	}

}
