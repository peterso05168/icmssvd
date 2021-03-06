package hk.judiciary.icmssvd.webservice.snGenerationService.internal;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.webservice.AbstractController;
import hk.judiciary.icmssvd.model.courtCase.exception.CriminalGenericException;
import hk.judiciary.icmssvd.model.report.biz.dto.PrintCheckListAndCoverSheetResultDTO;
import hk.judiciary.icmssvd.model.report.biz.dto.PrintFreshSummonsResultDTO;
import hk.judiciary.icmssvd.model.report.facade.ReportFacade;
import hk.judiciary.icmssvd.webservice.snGenerationService.SnGenerationService;

@WebService(endpointInterface = "hk.judiciary.icmssvd.webservice.snGenerationService.SnGenerationService")
@InInterceptors(interceptors = { "hk.judiciary.fmk.webservice.security.WSSecurityInterceptor" })

public class SnGenerationServiceImpl extends AbstractController implements SnGenerationService {

    private ReportFacade getReportFacade() {
        return getFacade("reportFacade", ReportFacade.class);
    }
   

	@Override
	public PrintFreshSummonsResultDTO batchGenSummons(Integer caseId, String copyType, String caseTypeCode, String jobNo, boolean isReservice, String totalCaseCount,
			String totalPageCount) {
		
    	ReportFacade reportFacade = this.getReportFacade();
        if (!CommonUtil.isNullOrEmpty(reportFacade)) {
            try {
				return reportFacade.batchGenSummons("", caseId, copyType, isReservice, caseTypeCode, this.getUser());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return null;
	}
	
	@Override
	public PrintCheckListAndCoverSheetResultDTO batchGenCheckList(List<Integer> caseIds, String caseTypeCode) {
		
    	ReportFacade reportFacade = this.getReportFacade();
        if (!CommonUtil.isNullOrEmpty(reportFacade)) {
            try {
				return reportFacade.batchGenCheckList(caseIds, caseTypeCode, this.getUser());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return new PrintCheckListAndCoverSheetResultDTO();
	}
	
	@Override
	public PrintCheckListAndCoverSheetResultDTO batchGenCover(List<String> caseNos) {
		
    	ReportFacade reportFacade = this.getReportFacade();
        if (!CommonUtil.isNullOrEmpty(reportFacade)) {
            try {
				return reportFacade.batchGenCover(caseNos, this.getUser());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return new PrintCheckListAndCoverSheetResultDTO();
	}
}
