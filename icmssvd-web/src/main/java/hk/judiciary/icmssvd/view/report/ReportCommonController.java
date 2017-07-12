package hk.judiciary.icmssvd.view.report;

import java.util.HashMap;
import java.util.Map;

import hk.judiciary.icmssvd.model.courtCase.biz.dto.CustomAccessInfoDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.ServerValidationExceptionDTO;
import hk.judiciary.icmssvd.model.courtCase.exception.CriminalGenericException;
import hk.judiciary.icmssvd.model.courtCase.exception.CriminalServerValidationException;
import hk.judiciary.icmssvd.view.BaseController;

public class ReportCommonController extends BaseController {

	protected CustomAccessInfoDTO getCustomAccessInfo() throws CriminalGenericException {
		CustomAccessInfoDTO customAccessInfoDTO = new CustomAccessInfoDTO();
		return customAccessInfoDTO;
	}
	
	protected Map<String, Object> exceptionMainHandler(Exception e) throws Exception {
		Map<String, Object> results = new HashMap<String, Object>();
		if (e instanceof CriminalServerValidationException) {
			CriminalServerValidationException exception = (CriminalServerValidationException) e;
			results.put("exceptionType", "SERVER_VALIDATION");
			results.put("exceptionDetails", new ServerValidationExceptionDTO(exception));
		} else if (e instanceof CriminalGenericException) {
			CriminalGenericException ge = (CriminalGenericException) e;
			if (ge.getCriminalCaseException() != null) {
				// Known exception
				results.put("exceptionType", "GENERIC_EXCEPTION");
				results.put("exceptionDetails", new ServerValidationExceptionDTO(ge));
			} else {
				throw ge;
			}
		} else {
			throw e;
		}
		return results;
	}
}
