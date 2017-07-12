package hk.judiciary.icmssvd.model.report.biz;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.ejb.report.ReportService;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestDataParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icms.model.dao.entity.Addr;
import hk.judiciary.icms.model.dao.entity.AddrRole;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icms.model.dao.entity.Partcp;
import hk.judiciary.icms.model.dao.entity.PartcpRole;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.HrnSchdRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.PartcpRoleRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.PartcpRoleTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.HrnSchdDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.PartcpRoleDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdCertPosDsDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdCertPosDsBO extends SvdReportBaseBO {
	public static final String NAME = "rptSvdCertPosDsBO";

	public RptSvdCertPosDsBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdCertPosDsDTO> dataObjects;
	private Integer caseId;
	private String regNo;
	private Case loadedCase;
	private Partcp loadedDefendant;
	private HrnSchd loadedHrnSchd;

	@Override
	protected void retrieveData() throws Exception {
		caseId = (Integer) reportCriteria.get("caseId");
		regNo = (String) reportCriteria.get("regNo");

		Integer caseId = null;
		CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
		caseRetrieveCriteriaDTO.setCaseId(caseId);
		List<Case> cases = getDAO(CaseDAO.CASE_DAO, CaseDAO.class).retrieve(caseRetrieveCriteriaDTO);
		if (cases != null && cases.size() > 0) {
			loadedCase = cases.get(0);
			caseId = loadedCase.getCaseId();
		}

		PartcpRoleRetrieveCriteriaDTO partcpRoleRetrieveCriteriaDTO = new PartcpRoleRetrieveCriteriaDTO();
		partcpRoleRetrieveCriteriaDTO.setCaseId(caseId);
		List<PartcpRole> partcpRoles = getDAO(PartcpRoleDAO.PARTCP_ROLE_DAO, PartcpRoleDAO.class)
				.retrieve(partcpRoleRetrieveCriteriaDTO);
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

	private RptSvdCertPosDsDTO constructDetails(RptSvdCertPosDsDTO dataObjectIn, String langCode, boolean withAttachment)
			throws IOException, ParseException {
		
		RptSvdCertPosDsDTO dataObject = dataObjectIn;

		dataObject.setSummonsNo(loadedCase.getCompsCourt().getCompsCourtPrfx() +
				loadedCase.getCaseType().getCaseTypeCd() + " " +
				loadedCase.getCaseSerNo() + "/" +
				loadedCase.getCaseYr());

		if (loadedHrnSchd != null && loadedHrnSchd.getListSchd() != null) {
			dataObject.setHearingDate(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), langCode));
		}
		
		if(loadedCase.getChrgApp().size()>0) {
			dataObject.setProsecutionDept(loadedCase.getChrgNat().getProsUnit());
		}
		
		dataObject.setNameOfDefendant(SvdReportUtil.getPartcpName(loadedDefendant, false, langCode));

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
		
		dataObject.setDrnNo("");
		dataObject.setPostOffice("");
		dataObject.setDateOfCertificate("");
		dataObject.setNameOfPersonnel("");
		dataObject.setCourtName(SvdReportUtil.getCaseCourtName(loadedCase, langCode));

		return dataObject;
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			dataObjects = new ArrayList<RptSvdCertPosDsDTO>();
			RptSvdCertPosDsDTO dataObject = new RptSvdCertPosDsDTO();
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
	protected ReportResultDTO genReport(Map<String, Object> reportCriteria, CopyTypeConstant copyType)
			throws Exception {
		this.reportCriteria = reportCriteria;
		retrieveData();
		
		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_POS_DS);

		Object dataDTOList = constructReportData();

		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);

		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);

		return reportResultDTO;
	}

}
