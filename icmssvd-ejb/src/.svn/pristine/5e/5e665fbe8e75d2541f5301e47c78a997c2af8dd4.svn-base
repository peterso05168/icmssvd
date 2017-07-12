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
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.ChrgAppRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.ChrgAppDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdClFpepaDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdClFpepaBO extends SvdReportBaseBO {

	public static final String NAME = "rptSvdClSSerBo";

	public RptSvdClFpepaBO(JudiciaryUser user) {
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

			List<RptSvdClFpepaDTO> dataObjects = new ArrayList<RptSvdClFpepaDTO>();
			addPage();
			

			for (Case vcase: cases) {
				//Set data for each case.
				RptSvdClFpepaDTO dataObject = new RptSvdClFpepaDTO();
				dataObject.setCourtName(SvdReportUtil.getCaseCourtName(vcase, SvdReportUtil.LANG_CODE_ENG));
				ChrgAppRetrieveCriteriaDTO chrgAppRetrieveCriteriaDTO = new ChrgAppRetrieveCriteriaDTO();
				chrgAppRetrieveCriteriaDTO.setCaseId(vcase.getCaseId());
				ChrgApp loadedChrgApp = null;
				List<ChrgApp> chrgApps = getDAO(ChrgAppDAO.CHRG_APP_DAO, ChrgAppDAO.class).retrieve(chrgAppRetrieveCriteriaDTO);
				if (chrgApps != null && chrgApps.size() > 0) {
					loadedChrgApp = chrgApps.get(0);
				}
				if (loadedChrgApp.getPd() != null && loadedChrgApp.getPd().getPdName() != null) {
					dataObject.setProsecutionDept(loadedChrgApp.getPd().getPdName());							
				}		
				dataObject.setCaseNo(vcase.getCompsCourt().getCompsCourtCd() + 
						vcase.getCaseType() + " " + vcase.getCaseSerNo() + "/" + vcase.getCaseYr());
				dataObject.setCaseInitiationDate(SvdReportUtil.getFormattedDate(vcase.getInitDate(), SvdReportUtil.LANG_CODE_ENG));
				dataObject.setExParteHearingDate("");
				//dataObject.setTotalNoOfCase("");
				
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

		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter,
				dataDTOList, null);

		return reportResultDTO;
	}
}
