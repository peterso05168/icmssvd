package hk.judiciary.icmssvd.model.report.biz;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.ejb.report.ReportService;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestDataParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icms.model.dao.entity.Addr;
import hk.judiciary.icms.model.dao.entity.AddrRole;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.Partcp;
import hk.judiciary.icms.model.dao.entity.PartcpRole;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.PartcpRoleRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.PartcpRoleTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.dao.PartcpRoleDAO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdCertPosBkDTO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdCertPosBkSubDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public class RptSvdCertPosBkBO extends SvdReportBaseBO {
	public static final String NAME = "rptSvdCertPosBkBo";

	public RptSvdCertPosBkBO(JudiciaryUser user) {
		super(user);
		resetGroupPageCount();
	}

	private List<RptSvdCertPosBkDTO> dataObjects;
	List<Case> cases;
	private Integer caseId;
	private Case loadedCase;

	@Override
	protected void retrieveData() throws Exception {
		caseId = (Integer) reportCriteria.get("caseId");

		CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
		caseRetrieveCriteriaDTO.setCaseId(caseId);
		cases = getDAO(CaseDAO.CASE_DAO, CaseDAO.class).retrieve(caseRetrieveCriteriaDTO);
	}

	private RptSvdCertPosBkDTO constructDetails(RptSvdCertPosBkDTO dataObjectIn, String langCode, boolean withAttachment)
			throws IOException, ParseException {
		
		RptSvdCertPosBkDTO dataObject = dataObjectIn;
		dataObject.setCourtNameEng(SvdReportUtil.getCaseCourtName(loadedCase, langCode));
		dataObject.setCourtTel("");

		List<RptSvdCertPosBkSubDTO> rptSub = new ArrayList<RptSvdCertPosBkSubDTO>();
		
		//Sub template DTO for generating multiple records
		if (!CommonUtil.isNullOrEmpty(cases)) {
		    for (Case vcase: cases) {
	            RptSvdCertPosBkSubDTO rptSubDTO = new RptSvdCertPosBkSubDTO();
	            
	            Partcp loadedDefendant = null;
	            PartcpRoleRetrieveCriteriaDTO partcpRoleRetrieveCriteriaDTO = new PartcpRoleRetrieveCriteriaDTO();
	            partcpRoleRetrieveCriteriaDTO.setCaseId(vcase.getCaseId());
	            List<PartcpRole> partcpRoles = getDAO(PartcpRoleDAO.PARTCP_ROLE_DAO, PartcpRoleDAO.class)
	                    .retrieve(partcpRoleRetrieveCriteriaDTO);
	            if (partcpRoles != null && partcpRoles.size() > 0) {
	                for (PartcpRole partcpRole : partcpRoles) {
	                    if (partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.DEFENDANT.getCode())
	                            || partcpRole.getPartcpRoleType().getPartcpRoleTypeCd().equals(PartcpRoleTypeConstant.ACCUSED.getCode())) {
	                        loadedDefendant = partcpRole.getPartcp();
	                        break;
	                    }
	                }
	            }
	            rptSubDTO.setDefendantName(SvdReportUtil.getPartcpName(loadedDefendant, false, langCode));

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
	            List<String> addrLines = SvdReportUtil.getAddrLine(addr, langCode);
	            rptSubDTO.setDefendantAddress1(addrLines.get(0));
	            rptSubDTO.setDefendantAddress2(addrLines.get(1));
	            rptSubDTO.setDefendantAddress3(addrLines.get(2));
	            rptSubDTO.setCaseNo(vcase.getCompsCourt().getCompsCourtCd() + 
	                    vcase.getCaseType() + " " + vcase.getCaseSerNo() + "/" + vcase.getCaseYr());
	            rptSubDTO.setDrnNo("");
	            rptSubDTO.setTotalPostage("");
	            rptSubDTO.setArService("");
	            rptSub.add(rptSubDTO);
	        }
        }

		
		//Set the arrayList to the reportDTO
		dataObject.setArrayList(rptSub);
		return dataObject;
	}

	@Override
	protected Object constructReportData() throws Exception {
		try {
			dataObjects = new ArrayList<RptSvdCertPosBkDTO>();
			RptSvdCertPosBkDTO dataObject = new RptSvdCertPosBkDTO();
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

//		retrieveData();
        requestParameter = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_POS_BK);

        Object dataDTOList = constructReportData();

        ReportRequestDataParameterDTO dataParameter = new ReportRequestDataParameterDTO();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataParameter.setDataParameter(dataMap);

        ReportResultDTO reportResultDTO = ReportService.generateDocument(user, requestParameter, dataParameter, dataDTOList, null);

        return reportResultDTO;
    }

}
