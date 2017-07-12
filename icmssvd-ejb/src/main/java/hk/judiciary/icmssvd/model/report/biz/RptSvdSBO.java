package hk.judiciary.icmssvd.model.report.biz;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

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
import hk.judiciary.icms.model.dao.entity.SummonNoti;
import hk.judiciary.icmscase.model.cmcCriminal.biz.dto.ws.FormattedChrgPartcrDTO;
import hk.judiciary.icmscase.webservice.cmc.CaseService;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgAppRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgNatRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.HrnSchdRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.PartcpRoleRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.SummonNotiRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.PartcpRoleTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgAppDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgNatDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.HrnSchdDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.PartcpRoleDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.SummonNotiDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdSummonsDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.ReportContentConstant;
import hk.judiciary.icmssvd.model.report.constant.RptSvdSConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;


public class RptSvdSBO extends SvdReportBaseBO {
	
	public static final String NAME = "rptSvdSBO";

	public RptSvdSBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdSummonsDTO> dataObjects;

	private boolean isReservice;
	private Integer caseId;
	private String regNo;
	private FormattedChrgPartcrDTO loadedFormattedChrgPartcrDTO;
	private Case loadedCase;
	private ChrgNat loadedChrgNat;
	private SummonNoti loadedSummonNoti;
	private ChrgApp loadedChrgApp;
	private Partcp loadedInformant;
	private Partcp loadedDefendant;
	private HrnSchd loadedHrnSchd;
	
	@Override
	protected void retrieveData() throws Exception {
		// TODO Auto-generated method stub
		isReservice = (boolean) reportCriteria.get("isReservice");
		caseId = (Integer) reportCriteria.get("caseId");
		regNo = (String) reportCriteria.get("regNo");		
		
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
		
		SummonNotiRetrieveCriteriaDTO summonNotiRetrieveCriteriaDTO = new SummonNotiRetrieveCriteriaDTO();
		summonNotiRetrieveCriteriaDTO.setCaseId(caseId);
		List<SummonNoti> summonNotis = getDAO(SummonNotiDAO.SUMMON_NOTI_DAO, SummonNotiDAO.class).retrieve(summonNotiRetrieveCriteriaDTO);
		if (summonNotis != null && summonNotis.size() > 0) {
			loadedSummonNoti = summonNotis.get(0);
		}
		
		PartcpRoleRetrieveCriteriaDTO partcpRoleRetrieveCriteriaDTO = new PartcpRoleRetrieveCriteriaDTO();
		partcpRoleRetrieveCriteriaDTO.setCaseId(caseId);
		List<PartcpRole> partcpRoles = getDAO(PartcpRoleDAO.PARTCP_ROLE_DAO, PartcpRoleDAO.class).retrieve(partcpRoleRetrieveCriteriaDTO);
		if (partcpRoles != null && partcpRoles.size() > 0) {
			for (PartcpRole partcpRole : partcpRoles) {
				if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.INFORMANT.getCode())) {
					loadedInformant = partcpRole.getPartcp();
				} else if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.DEFENDANT.getCode()) ||
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
	
	private RptSvdSummonsDTO constructCommonContent(RptSvdSummonsDTO dataObjectIn, String langCode) {
		RptSvdSummonsDTO dataObject = dataObjectIn;
		
		dataObject.setCopyType(copyType.getCode());
		dataObject.setLangType(langCode);
		
		dataObject.setFormName1(RptSvdSConstant.FORM_NAME_1.getDesc(langCode));
		dataObject.setFormName2(RptSvdSConstant.FORM_NAME_2.getDesc(langCode));		
		
		dataObject.setCourtName(SvdReportUtil.getCaseCourtName(loadedCase, langCode));
		dataObject.setCourtAddress(SvdReportUtil.getCaseCourtAddress(loadedCase, langCode));
		dataObject.setCaseNo(loadedCase.getCompsCourt().getCompsCourtCd() +
				loadedCase.getCaseType().getCaseTypeCd() + " " +
				loadedCase.getCaseSerNo() + "/" +
				loadedCase.getCaseYr());
		dataObject.setRegNo(regNo);
		
		dataObject.setJobCnt(getJobCnt());
		dataObject.setPageCnt(getPageCnt());
		dataObject.setCaseCnt(getCaseCnt());
		dataObject.setMiscCnt("001");
		
		return dataObject;
	}
	
	private RptSvdSummonsDTO constructDetailsContent(RptSvdSummonsDTO dataObjectIn, String langCode, boolean withAttachment) throws ParseException, IOException {
		RptSvdSummonsDTO dataObject = dataObjectIn;
		
		Addr addr = null;
		if (loadedDefendant != null) {
			if (loadedDefendant.getAddrRole() != null) {
				for (AddrRole addrRole : loadedDefendant.getAddrRole()) {
					if (SvdReportUtil.FLAG_VALID_CODE.equals(addrRole.getPostalServFlag())) {
						addr = addrRole.getAddr();
						break;
					}
				}
			}
		}		

		// Chinese Image Name
		boolean withNameImage = false;
		String base64Image = "";
		if (withNameImage) {
			String dirPath = "H:/Chrono/workspaces/icms/pdfExport";		// temp. use. 
			String fileName = "ChiName.PNG";
			String imagePath = dirPath+"/"+fileName;
			
			byte[] imageByte = SvdReportUtil.convertImageToByte(imagePath);
			base64Image = Base64.encodeBase64String(imageByte);
		}	
		
		dataObject.setDefendantName(SvdReportUtil.getPartcpName(loadedDefendant, withNameImage, langCode));
		if (withNameImage && dataObject.getDefendantName().equals("")) {
			dataObject.setDefendantNameImage(base64Image);
		}
		
		Date issueDate = new Date();
		String pdRefNo = (loadedChrgNat != null ? loadedChrgNat.getProsRefNo() : "");
		String drnNo = "DRN123456";		// temp. use. 
		
		List<String> addrLines = SvdReportUtil.getAddrLine(addr, langCode);
		dataObject.setDefendantAddress1(addrLines.get(0) != null ? addrLines.get(0).toUpperCase() : "");
		dataObject.setDefendantAddress2(addrLines.get(1) != null ? addrLines.get(1).toUpperCase() : "");
		dataObject.setDefendantAddress3(addrLines.get(2) != null ? addrLines.get(2).toUpperCase() : "");
		
		dataObject.setDrnNo(drnNo);
		
		dataObject.setDefendantDocType(SvdReportUtil.getPartcpIdType(loadedDefendant, langCode));
		dataObject.setDefendantDocNo(SvdReportUtil.getPartcpIdNo(loadedDefendant));
		
		dataObject.setDefendantGender(SvdReportUtil.getPartcpGender(loadedDefendant, langCode));
		dataObject.setDefendantAge(SvdReportUtil.getPartcpAge(loadedDefendant, langCode));

		dataObject.setPdRefNo(pdRefNo);
		
		if (withAttachment) {
			dataObject.setChargeParticular(ReportContentConstant.SEE_ATTACHMENT.getDesc(langCode));
		} else {
			dataObject.setChargeParticular(SvdReportUtil.getFormattedChrgPartcr(loadedFormattedChrgPartcrDTO, langCode));
		}
		dataObject.setAdditionalPage("N");
		
		dataObject.setContraryToLaw(SvdReportUtil.getContraryToLaw(loadedChrgApp, langCode));

		dataObject.setInformant(SvdReportUtil.getInformantInfo(loadedInformant, loadedChrgNat, langCode));
		
		if (loadedCase != null) {
			if (loadedCase.getInitDate() != null) {
				dataObject.setCaseInitiateDate(SvdReportUtil.getFormattedDate(loadedCase.getInitDate(), langCode));			
			}
			
			if (loadedCase.getCaseType() != null) {
				dataObject.setRemarks(SvdReportUtil.getRemark(loadedCase.getCaseType(), loadedSummonNoti, loadedDefendant, langCode));
			}
		}
		
		dataObject.setIssueDate(SvdReportUtil.getFormattedDate(issueDate, langCode));
		
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
		} else {
			// Below Data are Dummy
			if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
				dataObject.setDateOfHearing("22 October 2014");
				dataObject.setTimeOfHearing("9:30 a.m.");
				dataObject.setCourtOfHearing("Kowloon City Magistrates' Courts");
				dataObject.setCourtRoomOfHearing("3");
			} else if (langCode.equals(SvdReportUtil.LANG_CODE_CHI)) {
				dataObject.setDateOfHearing("2014年10月22日");
				dataObject.setTimeOfHearing("上午9時30分");
				dataObject.setCourtOfHearing("九龍城裁判法院");
				dataObject.setCourtRoomOfHearing("3");
			}
		}
		
		return dataObject;
	}
	
	private RptSvdSummonsDTO constructAttachmentContent(RptSvdSummonsDTO dataObjectIn, String langCode) throws UnsupportedEncodingException {
		RptSvdSummonsDTO dataObject = dataObjectIn;
		
		dataObject.setChargeParticular(SvdReportUtil.getFormattedChrgPartcr(loadedFormattedChrgPartcrDTO, langCode));
		dataObject.setChargeParticularFontSize(SvdReportUtil.getChargeParticularFontSize(dataObject.getChargeParticular(), langCode));
		dataObject.setAdditionalPage("Y");
		
		return dataObject;
	}
		
	@Override
	public boolean isPgblRequired() {
		boolean pgblRequired = false;
		if (loadedSummonNoti != null) {
			if (SvdReportUtil.FLAG_VALID_CODE.equals(loadedSummonNoti.getPgblAllow())) {
				pgblRequired = true;
			}
		}
		return pgblRequired;
	}
	
	@Override
	protected Object constructReportData() throws Exception {
		// TODO Auto-generated method stub
		try {
			boolean withAttachment = SvdReportUtil.isAttachmentRequired(loadedFormattedChrgPartcrDTO);
			boolean withPgbl = isPgblRequired();
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
			
			dataObjects = new ArrayList<RptSvdSummonsDTO>();
			RptSvdSummonsDTO dataObject = null;
			String langCode;
			addPage();
			
			for (int i=0; i<langCodes.size(); i++) {
				langCode = langCodes.get(i);
				dataObject = new RptSvdSummonsDTO();
				dataObject = constructCommonContent(dataObject, langCode);
				dataObject = constructDetailsContent(dataObject, langCode, withAttachment);
				
				if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
					boolean isLastPage = true;
					if (withAttachment || withPgbl) { isLastPage = false; }
					dataObject.setOmrData(genOmrMark(isLastPage, getGroupPageCount(), getJobPageCount()));
				}
				dataObjects.add(dataObject);
			}
			
			if (withAttachment) {
				addPage();
				for (int i=0; i<langCodes.size(); i++) {
					langCode = langCodes.get(i);
					dataObject = new RptSvdSummonsDTO();
					dataObject = constructCommonContent(dataObject, langCode);
					dataObject = constructAttachmentContent(dataObject, langCode);
					
					if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
						boolean isLastPage = true;
						if (withPgbl) { isLastPage = false; }
						dataObject.setOmrData(genOmrMark(isLastPage, getGroupPageCount(), getJobPageCount()));
					}
					dataObjects.add(dataObject);
				}
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

		if (isReservice) {
			requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_S_RES);
		} else {
			requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_S);
		}
		
		Object dataDTOList = constructReportData();
		
		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);
		
		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);
		
		return reportResultDTO;
	}

}
