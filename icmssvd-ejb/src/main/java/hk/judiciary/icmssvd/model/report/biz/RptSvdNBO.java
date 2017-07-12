package hk.judiciary.icmssvd.model.report.biz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.ParseException;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.ejb.report.ReportService;
import hk.judiciary.fmk.ejb.webservice.WSClientHandler;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestDataParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icms.model.dao.entity.Addr;
import hk.judiciary.icms.model.dao.entity.AddrRole;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.ChrgApp;
import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icms.model.dao.entity.Partcp;
import hk.judiciary.icms.model.dao.entity.PartcpRole;
import hk.judiciary.icms.model.dao.entity.SummonNoti;
import hk.judiciary.icmscase.model.cmcCriminal.biz.dto.ws.FormattedChrgPartcrDTO;
import hk.judiciary.icmscase.webservice.cmc.CaseService;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgAppRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.HrnSchdRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.PartcpRoleRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.SummonNotiRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.PartcpRoleTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgAppDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.HrnSchdDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.PartcpRoleDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.SummonNotiDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdNDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdNBO extends SvdReportBaseBO {

	public static final String NAME = "rptSvdNBO";

	public RptSvdNBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdNDTO> dataObjects;

	private boolean isReservice;
	private Integer caseId;
	private String regNo;
	private hk.judiciary.icmscase.model.cmcCriminal.biz.dto.ws.FormattedChrgPartcrDTO loadedFormattedChrgPartcrDTO;
	private Case loadedCase;
	private SummonNoti loadedSummonNoti;
	private ChrgApp loadedChrgApp;
	private Partcp loadedDefendant;
	private HrnSchd loadedHrnSchd;
	private List<Case> cases;

	@Override
	protected void retrieveData() throws Exception {
		isReservice = (boolean) reportCriteria.get("isReservice");
		caseId = (Integer) reportCriteria.get("caseId");
		regNo = (String) reportCriteria.get("regNo");

		Integer caseId = null;
		CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
		caseRetrieveCriteriaDTO.setCaseId(caseId);
		cases = getDAO(CaseDAO.CASE_DAO, CaseDAO.class).retrieve(caseRetrieveCriteriaDTO);
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

		PartcpRoleRetrieveCriteriaDTO partcpRoleRetrieveCriteriaDTO = new PartcpRoleRetrieveCriteriaDTO();
		partcpRoleRetrieveCriteriaDTO.setCaseId(caseId);
		List<PartcpRole> partcpRoles = getDAO(PartcpRoleDAO.PARTCP_ROLE_DAO, PartcpRoleDAO.class).retrieve(partcpRoleRetrieveCriteriaDTO);
		if (partcpRoles != null && partcpRoles.size() > 0) {
			for (PartcpRole partcpRole : partcpRoles) {
				if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.DEFENDANT.getCode())
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

	private RptSvdNDTO constructDetails(RptSvdNDTO dataObjectIn, String langCode, boolean withAttachment)
			throws ParseException, IOException, Exception {
		RptSvdNDTO dataObject = dataObjectIn;

		dataObject.setLangType(langCode);
		dataObject.setCaseCnt(getCaseCnt());
		if(copyType!=null) {
			dataObject.setCopyType(copyType.getCode());
		}
		dataObject.setJobCnt(getJobCnt());
		dataObject.setMiscCnt("001");
		dataObject.setPageCnt(getPageCnt());
		dataObject.setCaseNo(loadedCase.getCompsCourt().getCompsCourtPrfx() +
				loadedCase.getCaseType().getCaseTypeCd() + " " +
				loadedCase.getCaseSerNo() + "/" +
				loadedCase.getCaseYr());
		dataObject.setIssueDate(SvdReportUtil.getFormattedDate(new Date(), langCode));

		if(loadedCase.getChrgApp().size()>0) {
			dataObject.setProsecutionDept(loadedCase.getChrgNat().getProsUnit());
			dataObject.setDeptRefNo(loadedCase.getChrgNat().getProsRefNo());
		}
			
		dataObject.setDefendantName(SvdReportUtil.getPartcpName(loadedDefendant, false, langCode));
		dataObject.setDefendantTelNo((loadedDefendant.getPerson() != null) ? loadedDefendant.getPerson().getTelNo() : "");
		dataObject.setDefendantIdType(SvdReportUtil.getPartcpIdType(loadedDefendant, langCode));

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
		
		dataObject.setDefendantType(loadedDefendant.getPartcpType().getPartcpTypeDesc());
		dataObject.setDefendantAge(SvdReportUtil.getPartcpAge(loadedDefendant, langCode));
		dataObject.setDefendantGender(SvdReportUtil.getPartcpGender(loadedDefendant, langCode));
		dataObject.setDefendantIdNo(SvdReportUtil.getPartcpIdNo(loadedDefendant));
		dataObject.setOffenceDate(SvdReportUtil.getFormattedDate(loadedChrgApp.getDateOfOccStartDate(), langCode));
		dataObject.setOffenceTime(SvdReportUtil.getFormattedTime(loadedChrgApp.getDateOfOccStartDate(), langCode));
		dataObject.setContraryToLaw(SvdReportUtil.getContraryToLaw(loadedChrgApp, langCode));
		
		// FIXME
		dataObject.setDefendantAddressTerritory("");
		dataObject.setOffenceLocation("");
		dataObject.setOffenceDescFormat("");
		dataObject.setNoticeIssueDate("");
		dataObject.setServingOfficer("");
		dataObject.setInputUserID("");
		dataObject.setInputDate("");
		dataObject.setDrnNo("");
		dataObject.setDefendantCcc("");

		if (loadedHrnSchd != null && loadedHrnSchd.getListSchd() != null) {
			dataObject.setDateOfHearing(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), langCode));

			Date timeOfHearing = loadedHrnSchd.getListSchd().getListSchdDate();
			dataObject.setTimeOfHearing(SvdReportUtil.getFormattedTime(timeOfHearing, langCode));

			dataObject.setCourtRoomOfHearing(SvdReportUtil.getComprisingCourtName(loadedHrnSchd.getListSchd().getList().getCompsCourt(), langCode));

			if (loadedHrnSchd.getListSchd().getList().getCourtRmToList().size() > 0) {
				dataObject.setCourtOfHearing(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getName());
			}
		}

		if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
			boolean isLastPage = false;
			dataObject.setOmrData(genOmrMark(isLastPage, getGroupPageCount(), getJobPageCount()));
		}

		return dataObject;
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			dataObjects = new ArrayList<RptSvdNDTO>();
			RptSvdNDTO dataObject = new RptSvdNDTO();
			addPage();
			
			dataObject = constructDetails(dataObject, SvdReportUtil.LANG_CODE_ENG, false);
			dataObjects.add(dataObject);

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

		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_N);

		Object dataDTOList = constructReportData();

		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);

		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter,
				dataDTOList, null);

		return reportResultDTO;
	}

}
