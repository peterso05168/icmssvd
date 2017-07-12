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
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdClNserDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdClNserBO extends SvdReportBaseBO {

	public static final String NAME = "rptSvdClSSerBo";

	public RptSvdClNserBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<Case> cases;
	private List<Integer> caseIds;

	@Override
	protected void retrieveData() throws Exception {
		caseIds = (List<Integer>) reportCriteria.get("caseIds");
		CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
		
		caseRetrieveCriteriaDTO.setCaseIds(caseIds);
		cases = getDAO(CaseDAO.CASE_DAO, CaseDAO.class).retrieve(caseRetrieveCriteriaDTO);
	
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			List<RptSvdClNserDTO> dataObjects = new ArrayList<RptSvdClNserDTO>();
			addPage();
			

			for (Case vcase: cases) {
				RptSvdClNserDTO dataObject = new RptSvdClNserDTO();
				dataObject.setCourtName(SvdReportUtil.getCaseCourtName(vcase, SvdReportUtil.LANG_CODE_ENG));
				
				//Load defendant for each case
				Partcp loadedDefendant = null;
				PartcpRoleRetrieveCriteriaDTO partcpRoleRetrieveCriteriaDTO = new PartcpRoleRetrieveCriteriaDTO();
				partcpRoleRetrieveCriteriaDTO.setCaseId(vcase.getCaseId());
				List<PartcpRole> partcpRoles = getDAO(PartcpRoleDAO.PARTCP_ROLE_DAO, PartcpRoleDAO.class).retrieve(partcpRoleRetrieveCriteriaDTO);
				if (partcpRoles != null && partcpRoles.size() > 0) {
					for (PartcpRole partcpRole : partcpRoles) {
						if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.DEFENDANT.getCode()) ||
								   partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.ACCUSED.getCode())) {
							loadedDefendant = partcpRole.getPartcp();
						}
					}
				}				
				dataObject.setDefendantName(SvdReportUtil.getPartcpName(loadedDefendant, false, SvdReportUtil.LANG_CODE_ENG));
				
				//Load hearing schedule for each case
				HrnSchd loadedHrnSchd = null;
				HrnSchdRetrieveCriteriaDTO hrnSchdRetrieveCriteriaDTO = new HrnSchdRetrieveCriteriaDTO();
				hrnSchdRetrieveCriteriaDTO.setCaseId(vcase.getCaseId());
				hrnSchdRetrieveCriteriaDTO.setStatus("A");
				List<HrnSchd> hrnSchds = getDAO(HrnSchdDAO.HRN_SCHD_DAO, HrnSchdDAO.class).retrieve(hrnSchdRetrieveCriteriaDTO);
				if (hrnSchds != null && hrnSchds.size() > 0) {
					loadedHrnSchd = hrnSchds.get(0);
				}
				
				if (loadedHrnSchd != null && loadedHrnSchd.getListSchd() != null) {
					dataObject.setNextHearingDate(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), SvdReportUtil.LANG_CODE_ENG));
				}
				
				// TODO
//				dataObject.setEffectiveFrom(SvdReportUtil.getFormattedDate(date, langCode));
//				dataObject.setEffectiveTo(SvdReportUtil.getFormattedDate(date, langCode));
				dataObject.setCaseNo(vcase.getCompsCourt().getCompsCourtCd() + 
				vcase.getCaseType().getCaseTypeCd() + " " + vcase.getCaseSerNo() + "/" + vcase.getCaseYr());
//				dataObject.setServiceMode();
//				dataObject.setServiceAgent(serviceAgent);
//				dataObject.setNoOfAttemptMade(noOfAttemptMade);
//				dataObject.setNonServiceReason(nonServiceReason);
//				dataObject.setTotalNoOfCase(Integer.toBinaryString(cases.size()));
				dataObjects.add(dataObject);
			}
			
		
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
		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_CL);

		Object dataDTOList = constructReportData();

		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);

		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);

		return reportResultDTO;
	}
}
