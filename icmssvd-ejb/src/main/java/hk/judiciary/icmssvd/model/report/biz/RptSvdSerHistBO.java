/**
 * The logic of this is not yet confirmed
 * Only to generate the report
 * 
 */

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
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdSerHistDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdSerHistBO extends SvdReportBaseBO {
	public static final String NAME = "rptSvdCertPosDsBO";

	public RptSvdSerHistBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdSerHistDTO> dataObjects;
	private Integer caseId;
	private String regNo;
	private Case loadedCase;
	
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
	}

	private RptSvdSerHistDTO constructDetails(RptSvdSerHistDTO dataObjectIn, String langCode, boolean withAttachment)
			throws IOException, ParseException {
		
		RptSvdSerHistDTO dataObject = dataObjectIn;
		dataObject.setCaseNo(loadedCase.getCompsCourt().getCompsCourtPrfx() +
				loadedCase.getCaseType().getCaseTypeCd() + " " +
				loadedCase.getCaseSerNo() + "/" +
				loadedCase.getCaseYr());
		dataObject.setRegID(regNo);
		dataObject.setAssignDate("");
		dataObject.setDefendantTel("");
		dataObject.setProcessServer("");
		dataObject.setResult("");
		dataObject.setRemark("");
		
		return dataObject;
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			boolean withAttachment = false;

			List<String> langCodes = new ArrayList<String>();		
			langCodes.add(SvdReportUtil.LANG_CODE_ENG);
			

			dataObjects = new ArrayList<RptSvdSerHistDTO>();
			RptSvdSerHistDTO dataObject = null;
			String langCode = null;
			addPage();

			for (int i = 0; i < langCodes.size(); i++) {
				langCode = langCodes.get(i);
				dataObject = new RptSvdSerHistDTO();
				dataObject = constructDetails(dataObject, langCode, withAttachment);
				dataObjects.add(dataObject);
			}

			if (withAttachment) {
				addPage();
				for (int i = 0; i < langCodes.size(); i++) {
					langCode = langCodes.get(i);
					dataObject = new RptSvdSerHistDTO();
					dataObject = constructDetails(dataObject, langCode, withAttachment);

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
	protected ReportResultDTO genReport(Map<String, Object> reportCriteria, CopyTypeConstant copyType)
			throws Exception {
		this.reportCriteria = reportCriteria;
		this.copyType = copyType;

		retrieveData();
		
		requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_POS_DS);

		
		this.copyType = copyType;
		Object dataDTOList = constructReportData();

		ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataParameter.setDataParameter(dataMap);

		ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);

		return reportResultDTO;
	}

}
