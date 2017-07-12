package hk.judiciary.icmssvd.model.report.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hk.judiciary.fmk.ejb.report.ReportService;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestDataParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestRequestParameterDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icmssvd.model.BaseBO;
import hk.judiciary.icmssvd.model.courtCase.constant.CaseTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.exception.CriminalGenericException;
import hk.judiciary.icmssvd.model.report.biz.dto.ReportResultPackDTO;
import hk.judiciary.icmssvd.model.report.biz.dto.RptSvdSummonsDTO;
import hk.judiciary.icmssvd.model.report.constant.CopyTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;
import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;
import hk.judiciary.icmssvd.model.svdReq.DocumentConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.CertifcateBulkPostingDTO;

public class ReportBO extends BaseBO {

    public static final String NAME = "reportBO";
    
    public List<ReportResultPackDTO> genSummons(String caseTypeCode, Integer caseId) throws CriminalGenericException {
        return genSummons(caseTypeCode, caseId, "");
    }

    public List<ReportResultPackDTO> genSummons(String caseTypeCode, Integer caseId, String regNo) throws CriminalGenericException {
        return genRptSummons(false, caseTypeCode, caseId, regNo);
    }

    public List<ReportResultPackDTO> genReserviceSummons(String caseTypeCode, Integer caseId) throws CriminalGenericException {
    	return genReserviceSummons(caseTypeCode ,caseId, "");
    }

    public List<ReportResultPackDTO> genReserviceSummons(String caseTypeCode, Integer caseId, String regNo) throws CriminalGenericException {
        return genRptSummons(true, caseTypeCode, caseId, regNo);
    }

    public ReportResultPackDTO genRptSvdCertPosBk(CertifcateBulkPostingDTO  certifcateBulkPosting) throws CriminalGenericException {
        List<ReportResultPackDTO> reportResultPackDTOs = new ArrayList<ReportResultPackDTO>();

        reportResultPackDTOs = genRptSvd(null, null, CopyTypeConstant.PROSECUTION_DEPARTMENT, false, CaseTypeConstant.CERTIFICATE_OF_BULKING_POSTING.getCode());
        
        return reportResultPackDTOs.get(0);
    }
    
    private List<ReportResultPackDTO> genRptSummons(boolean isReservice, String caseTypeCode, Integer caseId, String regNo) throws CriminalGenericException {    	
        List<ReportResultPackDTO> reportResultPackDTOs = new ArrayList<ReportResultPackDTO>();
        
        if (CaseTypeConstant.DEPARTMENTAL_SUMMONS.getCode().equals(caseTypeCode) || 
        	CaseTypeConstant.DRIVING_OFFENCE_POINTS_SUMMONS.getCode().equals(caseTypeCode) ||
        	CaseTypeConstant.FIXED_PENALTY_SUMMONS_GENERIC.getCode().equals(caseTypeCode) ||
        	CaseTypeConstant.FIXED_PENALTY_SUMMONS_PARKING.getCode().equals(caseTypeCode) ||
        	CaseTypeConstant.FIXED_PENALTY_SUMMONS_MOVING.getCode().equals(caseTypeCode)  ||
        	CaseTypeConstant.FIXED_PENALTY_SUMMONS_ANTI_LITTER.getCode().equals(caseTypeCode)) {
        	
        	reportResultPackDTOs.addAll(genRptSvd(regNo, caseId, CopyTypeConstant.COURT, isReservice, caseTypeCode));	
        }

        reportResultPackDTOs.addAll(genRptSvd(regNo, caseId, CopyTypeConstant.DEFENDANT, isReservice, caseTypeCode));
        
        return reportResultPackDTOs;
    }
    
    //FIXME: Cover Detail is not yet confirmed
    public ReportResultDTO genCover(List<String> caseNos) {
    	info("genCover() start");    
    	ReportRequestDataParameterDTO dataParmDto = null;
		ReportRequestRequestParameterDTO requestDto = null;
		requestDto = SvdReportUtil.generateRequestParameterDTO(SvdReportConstant.RPT_SVD_COVER);
		
        //FILL IN CONTENT HERE.
        List<RptSvdSummonsDTO> rptDtoList = new ArrayList<>();
        RptSvdSummonsDTO reportDto = new RptSvdSummonsDTO();
        String caseNoString = "";
        for (String caseNo: caseNos) {
        	caseNoString += caseNo + " ";
        }
        reportDto.setCaseNo(caseNoString);
        rptDtoList.add(reportDto);
		//CALL REPORT SERVICE TO GENERATE RE PORT
    	ReportResultDTO reportResultDTO = null;
		try {
			reportResultDTO = ReportService.generateDocument(getJudiciaryUser(),
			        requestDto, dataParmDto, rptDtoList, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
        info("genCover() end");       
		return reportResultDTO;    	
    }

    public ReportResultDTO genCheckList(List<Integer> caseIds, String caseTypeCode) {
    	ReportResultDTO reportResultDTO = new ReportResultDTO();
    	Map<String, Object> reportCriteria = new HashMap<String, Object>();
        reportCriteria.put("caseIds", caseIds);
    	try {
    		SvdReportBaseBO report = null;
        	if (CaseTypeConstant.CHECKLIST_FOR_BATCH_PRINTING_OF_FRESH_SUMMONS.getCode().equals(caseTypeCode)) {
            	report = new RptSvdClSSerBO(getJudiciaryUser());
            }else if (CaseTypeConstant.CHECKLIST_OF_NON_SERVICE.getCode().equals(caseTypeCode)) {
            	report = new RptSvdClNserBO(getJudiciaryUser());
            }else if (CaseTypeConstant.CHECKLIST_OF_FIXED_PENALTY_EX_PARTE_APPLICATION.getCode().equals(caseTypeCode)) {
            	report = new RptSvdClFpepaBO(getJudiciaryUser());
            }
        	
        	reportResultDTO = report.genReport(reportCriteria, null);

    	}catch (Exception e) {
    		e.printStackTrace();
    	}        
        
		return reportResultDTO;    	
    }
    
    // Generic template generation
    public List<ReportResultPackDTO> genRptSvd(String regNo, Integer caseId,
            CopyTypeConstant copyType, boolean isReservice, String caseTypeCode) throws CriminalGenericException {
        List<ReportResultPackDTO> reportResultPackDTOs = new ArrayList<ReportResultPackDTO>();
        try {
        	
        	int totalPageCount = -1;
            int totalCaseCount = 1;
            int jobNo = 6185;

            Map<String, Object> reportCriteria = new HashMap<String, Object>();
            reportCriteria.put("caseId", caseId);
            reportCriteria.put("regNo", SvdReportUtil.getEmptyOrValue(regNo));
            reportCriteria.put("isReservice", isReservice);            
            
            SvdReportBaseBO report = null;
            if (CaseTypeConstant.DEPARTMENTAL_SUMMONS.getCode().equals(caseTypeCode)) {
            	report = new RptSvdSBO(getJudiciaryUser());
            } else if (CaseTypeConstant.DRIVING_OFFENCE_POINTS_SUMMONS.getCode().equals(caseTypeCode)) {
            	report = new RptSvdDBO(getJudiciaryUser());
            } else if (CaseTypeConstant.FIXED_PENALTY_SUMMONS_GENERIC.getCode().equals(caseTypeCode) ||
            		  CaseTypeConstant.FIXED_PENALTY_SUMMONS_PARKING.getCode().equals(caseTypeCode) ||
            		  CaseTypeConstant.FIXED_PENALTY_SUMMONS_MOVING.getCode().equals(caseTypeCode)  ||
            		  CaseTypeConstant.FIXED_PENALTY_SUMMONS_ANTI_LITTER.getCode().equals(caseTypeCode)) {
            	report = new RptSvdFPSBO(getJudiciaryUser());
            	reportCriteria.put("reportTypeCode", caseTypeCode);
            } else if (CaseTypeConstant.FIXED_PENALTY_NOTICE_OF_ORDER_GENERIC.getCode().equals(caseTypeCode) ||
            		  CaseTypeConstant.FIXED_PENALTY_NOTICE_OF_ORDER_PARKING.getCode().equals(caseTypeCode) ||
            		  CaseTypeConstant.FIXED_PENALTY_NOTICE_OF_ORDER_MOVING.getCode().equals(caseTypeCode)  ||
            		  CaseTypeConstant.FIXED_PENALTY_NOTICE_OF_ORDER_ANTI_LITTER.getCode().equals(caseTypeCode)) {
            	report = new RptSvdFPNoOBO(getJudiciaryUser());
            	reportCriteria.put("reportTypeCode", caseTypeCode);
            } else if (CaseTypeConstant.LESSER_OFFENCE_REPORT.getCode().equals(caseTypeCode)) {
            	report = new RptSvdLoBO(getJudiciaryUser());
            } else if (CaseTypeConstant.WITNESS_SUMMONS.getCode().equals(caseTypeCode)) {
            	report = new RptSvdZBO(getJudiciaryUser());
            } else if (CaseTypeConstant.DEPARTMENTAL_NOTICE.getCode().equals(caseTypeCode)) {
            	report = new RptSvdNBO(getJudiciaryUser());
            } else if (CaseTypeConstant.CERTIFICATE_OF_BULKING_POSTING.getCode().equals(caseTypeCode)) {
            	report = new RptSvdCertPosBkBO(getJudiciaryUser());
            } else if (CaseTypeConstant.CERTIFICATE_OF_POSTING.getCode().equals(caseTypeCode)) {
            	report = new RptSvdCertPosDsBO(getJudiciaryUser());
            } else if (CaseTypeConstant.CERTIFICATE_OF_SERVICE.getCode().equals(caseTypeCode)) {
            	report = new RptSvdCertOfSerBO(getJudiciaryUser());
            } else if (CaseTypeConstant.SERVICE_HISTORY_RECORD.getCode().equals(caseTypeCode)) {
            	report = new RptSvdSerHistBO(getJudiciaryUser());
            }            
            
            report.setJobNo(jobNo);
            report.setTotalPageCount(totalPageCount);
            report.setTotalCaseCount(totalCaseCount);
            
            ReportResultDTO reportResultDTO = report.genReport(reportCriteria, copyType);
            if (reportResultDTO.getDocument() != null) {
                reportResultPackDTOs.add(new ReportResultPackDTO(report.getRequestParameter(),
                		reportResultDTO, getDocumentTypeCode(report.getRequestParameter().getReportTypeCode(), copyType)));
            }
            totalPageCount = report.getTotalPageCount();
           
            if (!CopyTypeConstant.COURT.equals(copyType) && report.isPgblRequired()) {
                RptSvdPgblBO pgblReport = new RptSvdPgblBO(getJudiciaryUser());
                pgblReport.setJobNo(jobNo);
                pgblReport.setTotalPageCount(totalPageCount);
                pgblReport.setTotalCaseCount(totalCaseCount);
                // special setup for continue group counting
                pgblReport.setGroupPageCount(report.getGroupPageCount());

                ReportResultDTO pgblResultDTO = pgblReport.genReport(reportCriteria, copyType);
                if (pgblResultDTO.getDocument() != null) {
                    reportResultPackDTOs.add(new ReportResultPackDTO(pgblReport.getRequestParameter(),
                            pgblResultDTO, getDocumentTypeCode(pgblReport.getRequestParameter().getReportTypeCode(), copyType)));
                }

                totalPageCount = report.getTotalPageCount() + pgblReport.getTotalPageCount();
            }
        } catch (Exception e) {
            error(e);
            throw new CriminalGenericException(e);
        }
        return reportResultPackDTOs;
    }
    
    /**
     * Get the document type code by report type code
     * 
     * @param reportTypeCode
     * @param copyType
     * @return documentTypeCode
    */
	private String getDocumentTypeCode(String reportTypeCode, CopyTypeConstant copyType) {
        String documentTypeCode = ""; 

        if (SvdReportConstant.RPT_SVD_S.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_S_RES.getReportTypeCode().equals(reportTypeCode)) {        	
        	documentTypeCode = DocumentConstant.DOCUMENT_TYPE_DSD;        	
        	if (CopyTypeConstant.COURT.equals(copyType)) {
        		documentTypeCode = DocumentConstant.DOCUMENT_TYPE_DSC;
        	}
        } else if (SvdReportConstant.RPT_SVD_D.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_D_RES.getReportTypeCode().equals(reportTypeCode)) {
            documentTypeCode = DocumentConstant.DOCUMENT_TYPE_DOPSD;
        	if (CopyTypeConstant.COURT.equals(copyType)) {
        		documentTypeCode = DocumentConstant.DOCUMENT_TYPE_DOPSC;
        	}
        } else if (SvdReportConstant.RPT_SVD_K.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_V.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_R.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_FS.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_K_RES.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_V_RES.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_R_RES.getReportTypeCode().equals(reportTypeCode)
                || SvdReportConstant.RPT_SVD_FS_RES.getReportTypeCode().equals(reportTypeCode)) {
            documentTypeCode = DocumentConstant.DOCUMENT_TYPE_FPSD;
            if (CopyTypeConstant.COURT.equals(copyType)) {
        		documentTypeCode = DocumentConstant.DOCUMENT_TYPE_FPSC;
        	}
        } else if (SvdReportConstant.RPT_SVD_PGBL.getReportTypeCode().equals(reportTypeCode)) {
            documentTypeCode = DocumentConstant.DOCUMENT_TYPE_PGBL;
        }
        return documentTypeCode;
    }
}
