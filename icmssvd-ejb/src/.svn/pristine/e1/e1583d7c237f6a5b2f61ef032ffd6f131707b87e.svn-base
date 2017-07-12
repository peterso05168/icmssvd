package hk.judiciary.icmssvd.model.common.util;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.common.util.DateUtil;
import hk.judiciary.fmk.ejb.webservice.WSClientHandler;
import hk.judiciary.fmk.logging.FmkLogger;
import hk.judiciary.icmscdy.model.courtdiary.biz.dto.mc.DateDiaryListCharcsDTO;
import hk.judiciary.icmscdy.model.courtdiary.biz.dto.mc.FirstFreeDateResultDTO;
import hk.judiciary.icmscdy.model.courtdiary.biz.dto.mc.LookupFirstFreeDateResultDTO;
import hk.judiciary.icmscdy.model.courtdiary.biz.mc.webservice.CourtDiaryMCService;
import hk.judiciary.icmslis.model.listing.biz.dto.ws.JudiWsUser;
import hk.judiciary.icmslis.model.listing.biz.dto.ws.JudiWsUserUtil;
import hk.judiciary.icmslis.webservice.listing.ListingService;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDetailDTO;


public class HearingScheduleUtil {
	
	public static final FmkLogger logger = new FmkLogger(HearingScheduleUtil.class);
	
	private static final String DEFAULT_NO_OF_HEARING_DAYS = "0.5";
	private static final String DEFAULT_JUVENILE_FLAG = "N";
	private static final String DEFAULT_NO_OF_CASE_SCHD_TOGETHER = "0";
	private static final String DEFAULT_JJO_PROFILE_ID = "-1";
	private static final String DEFAULT_JJO_PROFILE_OPR = "-1";
    
    private static ListingService getListingService(JudiciaryUser judiciaryUser) throws Exception {
    	String endpoint = WSClientHandler.getEndpointByWSConfigCode(ListingService.WEBSERV_CD);
    	return WSClientHandler.handleMessage(judiciaryUser, ListingService.class, endpoint);
    }
	
    private static CourtDiaryMCService getCourtDiaryMCService(JudiciaryUser judiciaryUser) throws Exception {
    	String endpoint = WSClientHandler.getEndpointByWSConfigCode(CourtDiaryMCService.WEBSERV_CD);
    	return WSClientHandler.handleMessage(judiciaryUser, CourtDiaryMCService.class, endpoint);
    } 
        
    /**
     * Update the earilest first free date and corresponding data to NextHearingDetailDTO
     */
    public static NextHearingDetailDTO updateNextHearingDetail(JudiciaryUser judiciaryUser, NextHearingDetailDTO nextHearingDetailDTO) {
    	logger.info("getDocumentFile() start : nextHearingDetailDTO = " + nextHearingDetailDTO + ", judiciaryUser = " + judiciaryUser);
    	
    	if (!CommonUtil.isNullOrEmpty(nextHearingDetailDTO)) {
    		try {
    			LookupFirstFreeDateResultDTO resultDTO = getCourtDiaryMCService(judiciaryUser).
    													 lookupFirstFreeDate(DateUtil.dateToString(nextHearingDetailDTO.getHearingScheduleDate(), "yyyyMMdd"),
    																		 nextHearingDetailDTO.getComprisingCourtId().toString(),
    																		 nextHearingDetailDTO.getListTypeId().toString(),
    																		 nextHearingDetailDTO.getHearingNatureId().toString(),
    																		 DEFAULT_NO_OF_HEARING_DAYS,
    																		 nextHearingDetailDTO.getHearingTimeWeightId().toString(),
    																		 DEFAULT_JUVENILE_FLAG,
    																		 DEFAULT_NO_OF_CASE_SCHD_TOGETHER,
    																		 DEFAULT_JJO_PROFILE_ID,
    																		 DEFAULT_JJO_PROFILE_OPR,
    																		 nextHearingDetailDTO.getCaseTypeId().toString(),    																											   
    																		 nextHearingDetailDTO.getProsecutionDepartment().getProsecutionDepartmentCodeId().toString(),
    																		 nextHearingDetailDTO.getFpApplicationNatureTypeId().toString());
    			
    			if (!CommonUtil.isNullOrEmpty(resultDTO) && !CommonUtil.isNullOrEmpty(resultDTO.getFirstFreeDateResults()) && resultDTO.getFirstFreeDateResults().size() > 0) {
    				FirstFreeDateResultDTO firstFreeDateResult = resultDTO.getFirstFreeDateResults().get(0);
    				nextHearingDetailDTO.setListId(firstFreeDateResult.getListId());
    				nextHearingDetailDTO.setCourtRoomChambersName(firstFreeDateResult.getCourtInfo());
    				
    				if (!CommonUtil.isNullOrEmpty(firstFreeDateResult.getDateDiaryListCharcss()) && firstFreeDateResult.getDateDiaryListCharcss().size() > 0) {
    					DateDiaryListCharcsDTO dateDiaryListCharcss = firstFreeDateResult.getDateDiaryListCharcss().get(0);
    					nextHearingDetailDTO.setHearingScheduleDate(dateDiaryListCharcss.getSchdDate());
    					nextHearingDetailDTO.setHearingStartTime(dateDiaryListCharcss.getSessionTime());
    				}
    			} 

    		} catch (Exception e) {
    			logger.info("Failure in call lookupFirstFreeDate()");
    		}
    	}
		
       	logger.info("updateNextHearingDetail() end : nextHearingDetailDTO = " + nextHearingDetailDTO);
        return nextHearingDetailDTO;
    }
 
    /**
     * Confirm Hearing Schedule
     */
    public static boolean confirmHearingSchedule(JudiciaryUser judiciaryUser, NextHearingDetailDTO nextHearingDetailDTO) throws Exception {
    	logger.info("confirmHearingSchedule() start : nextHearingDetailDTO = " + nextHearingDetailDTO + ", judiciaryUser = " + judiciaryUser);
		
    	boolean result = false;
    	JudiWsUser judiWsUser = JudiWsUserUtil.toWsJudiUser(judiciaryUser);
    	
    	if (!CommonUtil.isNullOrEmpty(nextHearingDetailDTO)) {
    		result = getListingService(judiciaryUser).scheduleHearingForMC(judiWsUser, 
    																	   nextHearingDetailDTO.getCaseId(), 
    																	   nextHearingDetailDTO.getListId(),
    																	   nextHearingDetailDTO.getHearingScheduleDate(), 
    																	   nextHearingDetailDTO.getHearingNatureId());
    	}
    	
       	logger.info("confirmHearingSchedule() end : result = " + result);
       	return result;
    }
}
