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
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdClSSerDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdClSSerBO extends SvdReportBaseBO {
	public static final String NAME = "rptSvdClSSerBo";

	public RptSvdClSSerBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdClSSerDTO> dataObjects;
	
	private List<Integer> caseIds;
	private List<Case> cases;


	@Override
	protected void retrieveData() throws Exception {
		cases = new ArrayList<Case>();
		caseIds = (List<Integer>) reportCriteria.get("caseIds");
		CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();

		caseRetrieveCriteriaDTO.setCaseIds(caseIds);
		cases = getDAO(CaseDAO.CASE_DAO, CaseDAO.class).retrieve(caseRetrieveCriteriaDTO);
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			dataObjects = new ArrayList<RptSvdClSSerDTO>();
			addPage();

			for (Case vcase: cases) {
				RptSvdClSSerDTO dataObject = new RptSvdClSSerDTO();

				dataObject.setTimestamp("");
				dataObject.setMagistrateCourt(vcase.getCompsCourt().getCompsCourtCd());
				if (vcase.getChrgNat() != null) {
					if (vcase.getChrgNat().getProsUnit() != null) {
						dataObject.setProsecutionDept(vcase.getChrgNat().getProsUnit());
					}
				}
				dataObject.setAuthorisationDate("");
				dataObject.setBatchSerialNo("");
				dataObject.setCaseNo(vcase.getCompsCourt().getCompsCourtCd() + 
						vcase.getCaseType().getCaseTypeCd() + " " + vcase.getCaseSerNo() + "/" + vcase.getCaseYr());
				
				//Load defendant data
				Partcp loadedDefendant = null;
				PartcpRoleRetrieveCriteriaDTO partcpRoleRetrieveCriteriaDTO = new PartcpRoleRetrieveCriteriaDTO();
				partcpRoleRetrieveCriteriaDTO.setCaseId(vcase.getCaseId());
				List<PartcpRole> partcpRoles = getDAO(PartcpRoleDAO.PARTCP_ROLE_DAO, PartcpRoleDAO.class)
						.retrieve(partcpRoleRetrieveCriteriaDTO);
				if (partcpRoles != null && partcpRoles.size() > 0) {
					for (PartcpRole partcpRole : partcpRoles) {
						if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd()
								.equals(PartcpRoleTypeConstant.DEFENDANT.getCode())
								|| partcpRole.getPartcpRoleType().getPartcpRoleTypeCd()
										.equals(PartcpRoleTypeConstant.ACCUSED.getCode())) {
							loadedDefendant = partcpRole.getPartcp();
						}
					}
				}
				dataObject.setDefendantRefNo(SvdReportUtil.getPartcpIdNo(loadedDefendant));
				
				//Load hearing schedule
				HrnSchd loadedHrnSchd = null;
				HrnSchdRetrieveCriteriaDTO hrnSchdRetrieveCriteriaDTO = new HrnSchdRetrieveCriteriaDTO();
				hrnSchdRetrieveCriteriaDTO.setCaseId(vcase.getCaseId());
				hrnSchdRetrieveCriteriaDTO.setStatus("A");
				List<HrnSchd> hrnSchds = getDAO(HrnSchdDAO.HRN_SCHD_DAO, HrnSchdDAO.class).retrieve(hrnSchdRetrieveCriteriaDTO);
				if (hrnSchds != null && hrnSchds.size() > 0) {
					loadedHrnSchd = hrnSchds.get(0);
				}
				
				if (loadedHrnSchd != null && loadedHrnSchd.getListSchd() != null) {
					dataObject.setHearingDate(SvdReportUtil.getFormattedDate(loadedHrnSchd.getListSchd().getListSchdDate(), SvdReportUtil.LANG_CODE_ENG));
					dataObject.setHearingTime(SvdReportUtil.getFormattedTime(loadedHrnSchd.getListSchd().getListSchdDate(), SvdReportUtil.LANG_CODE_ENG));
					if (loadedHrnSchd.getListSchd().getList().getCourtRmToList().size() > 0) {
						dataObject.setCourtNo(loadedHrnSchd.getListSchd().getList().getCourtRmToList().get(0).getCourtRmChmbr().getName());
					}
				}
				dataObject.setItRequest("");				
				dataObject.setNameOfHolder("");
				dataObject.setServiceDate("");
				
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
		this.copyType = copyType;

		retrieveData();

		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_CL);

		Object dataDTOList = constructReportData();

		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);

		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter,
				dataDTOList, null);

		return reportResultDTO;
	}

}
