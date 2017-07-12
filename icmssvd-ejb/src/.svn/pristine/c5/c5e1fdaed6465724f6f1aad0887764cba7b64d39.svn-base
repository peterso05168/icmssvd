package hk.judiciary.icmssvd.model.report.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.ejb.report.ReportService;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestDataParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.ChrgApp;
import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icms.model.dao.entity.Partcp;
import hk.judiciary.icms.model.dao.entity.PartcpRole;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgAppRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.PartcpRoleRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.PartcpRoleTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgAppDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.PartcpRoleDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdLoDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;


public class RptSvdLoBO extends SvdReportBaseBO {
	
	public static final String NAME = "rptSvdLoBO";

	public RptSvdLoBO(JudiciaryUser user) {
		super(user);
	}
	
	private int caseId;
	private Case loadedCase;
	private ChrgApp loadedChrgApp;
	private Partcp loadedDefendant;
	private HrnSchd loadedHrnSchd;
	
	public boolean isPgblRequired() {
		return false;
	}
	
	@Override
	protected void retrieveData() throws Exception {
		caseId = (Integer) reportCriteria.get("caseId");
		loadedHrnSchd = (HrnSchd) reportCriteria.get("hrnSchd");
		
		CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
		caseRetrieveCriteriaDTO.setCaseId(caseId);
		List<Case> cases = getDAO(CaseDAO.CASE_DAO, CaseDAO.class).retrieve(caseRetrieveCriteriaDTO);
		if (cases != null && cases.size() > 0) {
			loadedCase = cases.get(0);
			caseId = loadedCase.getCaseId();
		}
		
		PartcpRoleRetrieveCriteriaDTO partcpRoleRetrieveCriteriaDTO = new PartcpRoleRetrieveCriteriaDTO();
		partcpRoleRetrieveCriteriaDTO.setCaseId(caseId);
		List<PartcpRole> partcpRoles = getDAO(PartcpRoleDAO.PARTCP_ROLE_DAO, PartcpRoleDAO.class).retrieve(partcpRoleRetrieveCriteriaDTO);
		if (partcpRoles != null && partcpRoles.size() > 0) {
			for (PartcpRole partcpRole : partcpRoles) {
				if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.DEFENDANT.getCode()) ||
						   partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.ACCUSED.getCode())) {
					loadedDefendant = partcpRole.getPartcp();
				}
			}
		}
		
		ChrgAppRetrieveCriteriaDTO chrgAppRetrieveCriteriaDTO = new ChrgAppRetrieveCriteriaDTO();
		chrgAppRetrieveCriteriaDTO.setCaseId(caseId);
		List<ChrgApp> chrgApps = getDAO(ChrgAppDAO.CHRG_APP_DAO, ChrgAppDAO.class).retrieve(chrgAppRetrieveCriteriaDTO);
		if (chrgApps != null && chrgApps.size() > 0) {
			loadedChrgApp = chrgApps.get(0);
		}
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			List<String> langCodes = new ArrayList<String>();
			if (copyType.getCode().equals(CopyTypeConstant.DEFENDANT.getCode())) {
				//langCodes.add(SvdReportUtil.LANG_CODE_CHI);
				langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			} else if (copyType.getCode().equals(CopyTypeConstant.COURT.getCode()) ||
					   copyType.getCode().equals(CopyTypeConstant.PROSECUTION_DEPARTMENT.getCode())) {
				//langCodes.add(SvdReportUtil.LANG_CODE_CHI);
				langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			} 
			
			List<RptSvdLoDTO> dataObjects = new ArrayList<RptSvdLoDTO>();
			RptSvdLoDTO dataObject = null;
			String langCode;
			addPage();
			
			for (int i=0; i<langCodes.size(); i++) {
				langCode = langCodes.get(i);
				dataObject = new RptSvdLoDTO();
				dataObject.setCopyType(copyType.getCode());
				dataObject.setLangType(langCode);
				dataObject.setJobCnt(getJobCnt());
				dataObject.setPageCnt(getPageCnt());
				dataObject.setCaseCnt(getCaseCnt());
				dataObject.setMiscCnt("001");
				
				dataObject.setCaseNo(loadedCase.getCompsCourt().getCompsCourtPrfx() +
						loadedCase.getCaseType().getCaseTypeCd() + " " +
						loadedCase.getCaseSerNo() + "/" +
						loadedCase.getCaseYr());				
				dataObject.setRemarks("");
				
				
				//FIXME: DUMMY DATA FOR TOTAL CASE AND TOTAL AMENDED CASE
				dataObject.setTotalCase("1");
				dataObject.setTotalAmendedCase("1");
				
				if (loadedCase != null) {				
				}
				
				if (loadedDefendant != null) {
					dataObject.setDefendantNameEng(SvdReportUtil.getPartcpName(loadedDefendant, false, "E"));
					dataObject.setDefendantNameChi(SvdReportUtil.getPartcpName(loadedDefendant, false, "C"));
				}
				
				if (loadedChrgApp != null) {	
					//FIXME: THE AMENEDED VALUE ARE DUMMIES
					dataObject.setChapAmd("100");
					dataObject.setSubLegAmd("100");
					dataObject.setSectAmd("100");
					dataObject.setSubSectAmd("100");
					dataObject.setParaAmd("100");
					dataObject.setSubParaAmd("100");
					dataObject.setLesserOffenceAmdEng(loadedChrgApp.getOfncDesc());
					dataObject.setLesserOffenceAmdChi("中文!!!!!!");
					dataObject.setLawAmdEng(loadedChrgApp.getContryToLaw());
					dataObject.setLawAmdChi("中文!!!!!!");
					
					dataObject.setProsecutionDept(loadedChrgApp.getProsUnit());
					dataObject.setChap(loadedChrgApp.getChapNo().toString());
					dataObject.setSubLeg(loadedChrgApp.getSubLeg());
					dataObject.setSect(loadedChrgApp.getSectNo());
					dataObject.setSubSect(loadedChrgApp.getSubsectNo());
					dataObject.setPara(loadedChrgApp.getPara());
					dataObject.setSubPara(loadedChrgApp.getSubPara());
					dataObject.setLesserOffenceEng(loadedChrgApp.getOfncDesc());
					dataObject.setLesserOffenceChi(loadedChrgApp.getOfncDescChin());
					dataObject.setLawEng(loadedChrgApp.getContryToLaw());
					dataObject.setLawChi(loadedChrgApp.getContryToLawChin());
				}
				
				if (loadedHrnSchd != null) {
					dataObject.setCourtRoomOfHearing(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getName());
					dataObject.setDateTimeOfHearing(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), langCode));
				} else {
					//FIXME: Below Data are Dummy
					dataObject.setCourtRoomOfHearing("9");
					dataObject.setDateTimeOfHearing("22/11/2011");				
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
		this.reportCriteria = reportCriteria;
		this.copyType = copyType;
		
		retrieveData();
		
		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_LO);
		
		Object dataDTOList = constructReportData();
		
		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("courtName", loadedCase.getCompsCourt().getCompsCourtCd());
		dataParameter.setDataParameter(dataMap);
		
		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);
		
		return reportResultDTO;
	}

}
