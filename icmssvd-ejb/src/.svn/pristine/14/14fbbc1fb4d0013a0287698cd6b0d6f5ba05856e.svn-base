package hk.judiciary.icmssvd.model.report.biz;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.ejb.report.ReportService;
import hk.judiciary.fmk.ejb.webservice.WSClientHandler;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestDataParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icms.model.dao.entity.Addr;
import hk.judiciary.icms.model.dao.entity.AddrRole;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.ChrgApp;
import hk.judiciary.icms.model.dao.entity.ChrgNat;
import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icms.model.dao.entity.Partcp;
import hk.judiciary.icms.model.dao.entity.PartcpRole;
import hk.judiciary.icmscase.model.cmcCriminal.biz.dto.ws.FormattedChrgPartcrDTO;
import hk.judiciary.icmscase.webservice.cmc.CaseService;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgAppRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgNatRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.HrnSchdRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.PartcpRoleRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.PartcpRoleTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgAppDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgNatDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.HrnSchdDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.PartcpRoleDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdZDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.ReportContentConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;


public class RptSvdZBO extends SvdReportBaseBO {
	
	public static final String NAME = "rptSvdZBO";

	public RptSvdZBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdZDTO> dataObjects;
	
	private Integer caseId;
	private FormattedChrgPartcrDTO loadedFormattedChrgPartcrDTO;
	private Case loadedCase;
	private ChrgNat loadedChrgNat;
	private ChrgApp loadedChrgApp;
	private Partcp loadedDefendant;
	private HrnSchd loadedHrnSchd;
	
	@Override
	protected void retrieveData() throws Exception {
		caseId= (Integer) reportCriteria.get("caseId");
		
		CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
		caseRetrieveCriteriaDTO.setCaseId(caseId);
		List<Case> cases = getDAO(CaseDAO.CASE_DAO, CaseDAO.class).retrieve(caseRetrieveCriteriaDTO);
		if (cases != null && cases.size() > 0) {
			loadedCase = cases.get(0);
			caseId = loadedCase.getCaseId();
		}
				
		String endpoint = WSClientHandler.getEndpointByWSConfigCode(CaseService.WEBSERV_CD);
		CaseService caseService = (CaseService) WSClientHandler.handleMessage(user, CaseService.class, endpoint);
		List<FormattedChrgPartcrDTO> formattedChrgPartcpDTOs = new ArrayList<FormattedChrgPartcrDTO>();
		
		try {
			formattedChrgPartcpDTOs = caseService.getChrgPartcr(caseId);
		} catch (Exception e) {
			error(e.toString());
		}
		
		ChrgAppRetrieveCriteriaDTO chrgAppRetrieveCriteriaDTO = new ChrgAppRetrieveCriteriaDTO();
		chrgAppRetrieveCriteriaDTO.setCaseId(caseId);
		List<ChrgApp> chrgApps = getDAO(ChrgAppDAO.CHRG_APP_DAO, ChrgAppDAO.class).retrieve(chrgAppRetrieveCriteriaDTO);
		if (chrgApps != null && chrgApps.size() > 0) {
			loadedChrgApp = chrgApps.get(0);
			if (formattedChrgPartcpDTOs != null) {
				for (FormattedChrgPartcrDTO dto : formattedChrgPartcpDTOs) {
					if (dto.getChrgAppId().equals(loadedChrgApp.getChrgAppId())) {
						loadedFormattedChrgPartcrDTO = SvdReportUtil.removeParagraphFormat(dto);
						break;
					}
				}
			}
		}
		
		ChrgNatRetrieveCriteriaDTO chrgNatRetrieveCriteriaDTO = new ChrgNatRetrieveCriteriaDTO();
		chrgNatRetrieveCriteriaDTO.setCaseId(caseId);
		List<ChrgNat> chrgNats = getDAO(ChrgNatDAO.CHRG_NAT_DAO, ChrgNatDAO.class).retrieve(chrgNatRetrieveCriteriaDTO);
		if (chrgNats != null && chrgNats.size() > 0) {
			loadedChrgNat = chrgNats.get(0);
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
		
		HrnSchdRetrieveCriteriaDTO hrnSchdRetrieveCriteriaDTO = new HrnSchdRetrieveCriteriaDTO();
		hrnSchdRetrieveCriteriaDTO.setCaseId(caseId);
		hrnSchdRetrieveCriteriaDTO.setStatus("A");
		List<HrnSchd> hrnSchds = getDAO(HrnSchdDAO.HRN_SCHD_DAO, HrnSchdDAO.class).retrieve(hrnSchdRetrieveCriteriaDTO);
		if (hrnSchds != null && hrnSchds.size() > 0) {
			loadedHrnSchd = hrnSchds.get(0);
		}
	}	
	
	private RptSvdZDTO constructDetails(RptSvdZDTO dataObjectIn, String langCode, boolean withAttachment) throws ParseException, IOException {
		RptSvdZDTO dataObject = dataObjectIn;

		dataObject.setLangType(langCode);
		dataObject.setCaseNo(loadedCase.getCompsCourt().getCompsCourtPrfx() +
				loadedCase.getCaseType().getCaseTypeCd() + " " +
				loadedCase.getCaseSerNo() + "/" +
				loadedCase.getCaseYr());
		dataObject.setCourtName(SvdReportUtil.getCaseCourtName(loadedCase, langCode));
		dataObject.setCourtAddress(SvdReportUtil.getCaseCourtAddress(loadedCase, langCode));
		dataObject.setDefendantName(SvdReportUtil.getPartcpName(loadedDefendant, false, langCode));

		Addr addr = null;
		if (loadedDefendant.getAddrRole() != null) {
			for (AddrRole addrRole : loadedDefendant.getAddrRole()) {
				if (SvdReportUtil.FLAG_VALID_CODE.equals(addrRole.getPostalServFlag())) {
					addr = addrRole.getAddr();
					break;
				}
			}
		}
		List<String> addrLines = SvdReportUtil.getAddrLine(addr, langCode);
		dataObject.setDefendantAddress1(addrLines.get(0));
		dataObject.setDefendantAddress2(addrLines.get(1));
		dataObject.setDefendantAddress3(addrLines.get(2));

		dataObject.setDefendantGender(SvdReportUtil.getPartcpGender(loadedDefendant, langCode));
		dataObject.setDefendantAge(SvdReportUtil.getPartcpAge(loadedDefendant, langCode));
		
		dataObject.setPdRefNo(loadedChrgNat.getProsRefNo());

		if (withAttachment) {
			dataObject.setChargeParticular(ReportContentConstant.SEE_ATTACHMENT.getDesc(langCode));
		} else {
			dataObject.setChargeParticular(SvdReportUtil.getFormattedChrgPartcr(loadedFormattedChrgPartcrDTO, langCode));
		}

		dataObject.setContraryToLaw(loadedChrgApp.getContryToLaw());
		dataObject.setInformant(SvdReportUtil.getInformantInfo(loadedDefendant, loadedChrgNat, langCode));

		if (loadedHrnSchd != null && loadedHrnSchd.getListSchd() != null) {
			dataObject.setDateOfHearing(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), langCode));
			Date timeOfHearing = loadedHrnSchd.getListSchd().getListSchdDate();
			dataObject.setTimeOfHearing(SvdReportUtil.getFormattedTime(timeOfHearing, langCode));
			
			dataObject.setCourtOfHearing(SvdReportUtil.getComprisingCourtName(loadedHrnSchd.getListSchd().getList().getCompsCourt(), langCode));
			
			if (loadedHrnSchd.getListSchd().getList().getCourtRmToList().size() > 0) {
				dataObject.setCourtRoomOfHearing(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getName());
				dataObject.setVenueOfHearing(SvdReportUtil.getCourtVenueName(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getCourtVenue(), langCode));
				dataObject.setAddressOfHearing(SvdReportUtil.getCourtVenueAddress(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getCourtVenue(), langCode));
			}
		}
		dataObject.setIssueDate(SvdReportUtil.getFormattedDate(new Date(), langCode));
		
		// FIXME
		dataObject.setMagistrateName("");
		dataObject.setFormName1("");
		dataObject.setFormName2("");
		dataObject.setWritNo("");
		dataObject.setDrnNo("");
		dataObject.setRemarks("");
		
		return dataObject;
	}
	
	@Override
	protected Object constructReportData() throws Exception {
		try {
			// Control language print sequence
			List<String> langCodes = new ArrayList<String>();
			if (copyType.getCode().equals(CopyTypeConstant.DEFENDANT.getCode())) {
				langCodes.add(SvdReportUtil.LANG_CODE_CHI);
				langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			} else if (copyType.getCode().equals(CopyTypeConstant.COURT.getCode()) ||
					   copyType.getCode().equals(CopyTypeConstant.PROSECUTION_DEPARTMENT.getCode())) {
				langCodes.add(SvdReportUtil.LANG_CODE_CHI);
				langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			} 
			
			dataObjects = new ArrayList<RptSvdZDTO>();
			RptSvdZDTO dataObject = null;
			String langCode;
			addPage();
			
			for (int i=0; i<langCodes.size(); i++) {
				langCode = langCodes.get(i);
				dataObject = new RptSvdZDTO();
				dataObject = constructDetails(dataObject, langCode, false);
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

		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_Z);
		
		Object dataDTOList = constructReportData();
		
		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);
		
		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);
		
		return reportResultDTO;
	}

}
