package hk.judiciary.icmssvd.model.report.biz;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import hk.judiciary.icms.model.dao.entity.SummonNoti;
import hk.judiciary.icmscase.model.cmcCriminal.biz.dto.ws.FormattedChrgPartcrDTO;
import hk.judiciary.icmscase.webservice.cmc.CaseService;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgAppRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgNatRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.HrnSchdRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.PartcpRoleRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.SummonNotiRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.CaseTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.constant.PartcpRoleTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgAppDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgNatDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.HrnSchdDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.PartcpRoleDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.SummonNotiDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdFPSDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdFPSBO extends SvdReportBaseBO {
	public static final String NAME = "rptSvdClSSerBo";

	public RptSvdFPSBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdFPSDTO> dataObjects;
	private boolean isReservice;
	private Integer caseId;
	private String regNo;
	private hk.judiciary.icmscase.model.cmcCriminal.biz.dto.ws.FormattedChrgPartcrDTO loadedFormattedChrgPartcrDTO;
	private Case loadedCase;
	private SummonNoti loadedSummonNoti;
	private ChrgNat loadedChrgNat;
	private ChrgApp loadedChrgApp;
	private Partcp loadedInformant;
	private Partcp loadedDefendant;
	private HrnSchd loadedHrnSchd;
	private CopyTypeConstant copyType;

	@Override
	protected void retrieveData() throws Exception {
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

		SummonNotiRetrieveCriteriaDTO summonNotiRetrieveCriteriaDTO = new SummonNotiRetrieveCriteriaDTO();
		summonNotiRetrieveCriteriaDTO.setCaseId(caseId);
		List<SummonNoti> summonNotis = getDAO(SummonNotiDAO.SUMMON_NOTI_DAO, SummonNotiDAO.class).retrieve(summonNotiRetrieveCriteriaDTO);
		if (summonNotis != null && summonNotis.size() > 0) {
			loadedSummonNoti = summonNotis.get(0);
		}
		
		String endpoint = WSClientHandler.getEndpointByWSConfigCode(CaseService.WEBSERV_CD);
		CaseService caseService = WSClientHandler.handleMessage(user, CaseService.class, endpoint);
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
		List<PartcpRole> partcpRoles = getDAO(PartcpRoleDAO.PARTCP_ROLE_DAO, PartcpRoleDAO.class)
				.retrieve(partcpRoleRetrieveCriteriaDTO);
		if (partcpRoles != null && partcpRoles.size() > 0) {
			for (PartcpRole partcpRole : partcpRoles) {
				if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.INFORMANT.getCode())) {
					loadedInformant = partcpRole.getPartcp();
				} else if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.DEFENDANT.getCode())
						|| partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.ACCUSED.getCode())) {
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

	private RptSvdFPSDTO constructDetails(RptSvdFPSDTO dataObjectIn, String langCode, boolean withAttachment)
			throws IOException, ParseException {
		RptSvdFPSDTO dataObject = dataObjectIn;

		dataObject.setLangType(langCode);
		dataObject.setCopyType(copyType.getCode());
		dataObject.setCaseNo(loadedCase.getCompsCourt().getCompsCourtPrfx() +
				loadedCase.getCaseType().getCaseTypeCd() + " " +
				loadedCase.getCaseSerNo() + "/" +
				loadedCase.getCaseYr());
		dataObject.setRegNo(regNo);

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
		dataObject.setDefendantIdNo(SvdReportUtil.getPartcpIdNo(loadedDefendant));
		dataObject.setDefendantGender(SvdReportUtil.getPartcpGender(loadedDefendant, langCode));
		dataObject.setDefendantAge(SvdReportUtil.getPartcpAge(loadedDefendant, langCode));
		dataObject.setPdRefNo((loadedChrgNat!=null) ? loadedChrgNat.getProsRefNo() : "");
		dataObject.setChargeParticular(SvdReportUtil.getFormattedChrgPartcr(loadedFormattedChrgPartcrDTO, langCode));
		dataObject.setContraryToLaw(SvdReportUtil.getContraryToLaw(loadedChrgApp, langCode));
		dataObject.setInformant(SvdReportUtil.getInformantInfo(loadedInformant, loadedChrgNat, langCode));
		dataObject.setCaseInitiateDate(SvdReportUtil.getFormattedDate(loadedCase.getInitDate(), langCode));

		if (loadedHrnSchd != null && loadedHrnSchd.getListSchd() != null) {
			dataObject.setDateOfHearing(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), langCode));
			Date timeOfHearing = loadedHrnSchd.getListSchd().getListSchdDate();
			dataObject.setTimeOfHearing(SvdReportUtil.getFormattedTime(timeOfHearing, langCode));
			dataObject.setCourtRoomOfHearing(SvdReportUtil.getComprisingCourtName(loadedHrnSchd.getListSchd().getList().getCompsCourt(), langCode));

			if (loadedHrnSchd.getListSchd().getList().getCourtRmToList().size() > 0) {
				dataObject.setCourtOfHearing(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getName());
			}
		}

		dataObject.setIssueDate(SvdReportUtil.getFormattedDate(new Date(), langCode));

		
		if(loadedChrgApp != null) {
			if(loadedChrgApp.getCasemanOfncCd() != null) {
				if(loadedChrgApp.getCasemanOfncCd().getFpAmt()!=null) {
					dataObject.setFixedPenaltyAmt(loadedChrgApp.getCasemanOfncCd().getFpAmt().getDescEng());
				} else {
					dataObject.setFixedPenaltyAmt("0");
				}
				
				if(loadedChrgApp.getCasemanOfncCd().getFpCost() != null
						&& loadedChrgApp.getCasemanOfncCd().getFpCost().getDescEng() != null) {
					dataObject.setCosts(loadedChrgApp.getCasemanOfncCd().getFpCost().getDescEng());
				} else {
					dataObject.setCosts("0");
				}
			}
		}
		// FIXME
		dataObject.setAdditionalPenaltyAmt("");
		dataObject.setPaymentAmt("");
		dataObject.setDrnNo("");
		dataObject.setDefendantDrivingLicenseNo("");
		
		return dataObject;
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			List<String> langCodes = new ArrayList<String>();
			if (copyType.getCode().equals(CopyTypeConstant.DEFENDANT.getCode())) {
				langCodes.add(SvdReportUtil.LANG_CODE_CHI);
				langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			} else if (copyType.getCode().equals(CopyTypeConstant.COURT.getCode())
					|| copyType.getCode().equals(CopyTypeConstant.PROSECUTION_DEPARTMENT.getCode())) {
				langCodes.add(SvdReportUtil.LANG_CODE_CHI);
				langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			}

			dataObjects = new ArrayList<RptSvdFPSDTO>();
			RptSvdFPSDTO dataObject = null;
			String langCode = null;
			addPage();

			for (int i = 0; i < langCodes.size(); i++) {
				langCode = langCodes.get(i);
				dataObject = new RptSvdFPSDTO();
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
	protected ReportResultDTO genReport(Map<String, Object> reportCriteria, CopyTypeConstant copyType)
			throws Exception {
		this.reportCriteria = reportCriteria;
		this.copyType = copyType;

		retrieveData();
		String reportTypeCode = (String) reportCriteria.get("reportTypeCode");
		if(!isReservice) {
			if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_GENERIC.getCode().equals(reportTypeCode)){
				requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_FS_RES);
			}else if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_PARKING.getCode().equals(reportTypeCode)){
				requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_K_RES);
			}else if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_MOVING.getCode().equals(reportTypeCode)){
				requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_V_RES);
			}else if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_ANTI_LITTER.getCode().equals(reportTypeCode)) {
				requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_R_RES);
	        }	
		} else {
			if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_GENERIC.getCode().equals(reportTypeCode)){
				requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_FS);
			}else if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_PARKING.getCode().equals(reportTypeCode)){
				requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_K);
			}else if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_MOVING.getCode().equals(reportTypeCode)){
				requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_V);
			}else if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_ANTI_LITTER.getCode().equals(reportTypeCode)) {
				requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_R);
	        }	
		}
		
		this.copyType = copyType;
		Object dataDTOList = constructReportData();

		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);

		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);

		return reportResultDTO;
	}

}
