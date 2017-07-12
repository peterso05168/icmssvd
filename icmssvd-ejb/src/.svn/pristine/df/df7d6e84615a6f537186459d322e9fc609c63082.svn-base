package hk.judiciary.icmssvd.model.report.facade;

import java.util.List;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.icmssvd.model.courtCase.exception.CriminalGenericException;
import hk.judiciary.icmssvd.model.report.biz.dto.PrintCheckListAndCoverSheetResultDTO;
import hk.judiciary.icmssvd.model.report.biz.dto.PrintFreshSummonsResultDTO;

public interface ReportFacade {
	
	public static final String NAME = "reportFacade";

	public PrintFreshSummonsResultDTO batchGenSummons(String regNo, Integer caseId, String copyType, boolean isReservice, String reportTypeCode, JudiciaryUser user) throws CriminalGenericException;

	public PrintCheckListAndCoverSheetResultDTO batchGenCheckList(List<Integer> caseIds, String reportTypeCode, JudiciaryUser user) throws CriminalGenericException;

	public PrintCheckListAndCoverSheetResultDTO batchGenCover(List<String> caseNos, JudiciaryUser user) throws CriminalGenericException;

}

