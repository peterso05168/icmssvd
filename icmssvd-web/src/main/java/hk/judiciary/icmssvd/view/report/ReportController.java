package hk.judiciary.icmssvd.view.report;

import java.util.HashMap;
import java.util.Map;

import org.granite.tide.annotations.TideEnabled;

import hk.judiciary.icmssvd.model.report.facade.ReportFacade;

@TideEnabled
public class ReportController extends ReportCommonController {
	
	public Map<String, Object> cspuCentralPrintingModuleTestPrintReport(Integer caseId) throws Exception {
		Map<String, Object>	results = new HashMap<String, Object>();
		
		try {
			getFacade(ReportFacade.NAME, ReportFacade.class).batchGenSummons("", caseId, "", false, "S",  getUser());
		} catch (Exception e) {
			results = exceptionMainHandler(e);
		}
		
		return results;
	}
}
