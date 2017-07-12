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
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdCertOfSerDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdCertOfSerBO extends SvdReportBaseBO {
	public static final String NAME = "rptSvdCertPosDsBO";

	public RptSvdCertOfSerBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdCertOfSerDTO> dataObjects;
	private Integer caseId;
	private String regNo;
	private Case loadedCase;
	private Partcp loadedDefendant;
	private HrnSchd loadedHrnSchd;

	@Override
	protected void retrieveData() throws Exception {
		caseId = (Integer) reportCriteria.get("caseId");
		regNo = (String) reportCriteria.get("regNo");
		
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

	private RptSvdCertOfSerDTO constructDetails(RptSvdCertOfSerDTO dataObjectIn, String langCode, boolean withAttachment)
			throws IOException, ParseException {
		
		RptSvdCertOfSerDTO dataObject = dataObjectIn;

		dataObject.setRegNo(regNo);
		dataObject.setCaseNo(loadedCase.getCompsCourt().getCompsCourtPrfx() +
				loadedCase.getCaseType().getCaseTypeCd() + " " +
				loadedCase.getCaseSerNo() + "/" +
				loadedCase.getCaseYr());
		if (loadedHrnSchd != null && loadedHrnSchd.getListSchd() != null) {
			dataObject.setHearingDate(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), langCode));
		}
		
		if(loadedCase.getChrgApp().size()>0) {
			dataObject.setProsecutionDept(loadedCase.getChrgNat().getProsUnit());
		}
		
		dataObject.setDefendantName(SvdReportUtil.getPartcpName(loadedDefendant, false, langCode));

		return dataObject;
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			dataObjects = new ArrayList<RptSvdCertOfSerDTO>();
			RptSvdCertOfSerDTO dataObject = new RptSvdCertOfSerDTO();
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
		
		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_CERT_SER);

		Object dataDTOList = constructReportData();

		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);

		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);

		return reportResultDTO;
	}

}
