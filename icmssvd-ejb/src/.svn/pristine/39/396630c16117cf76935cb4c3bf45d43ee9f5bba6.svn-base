package hk.judiciary.icmssvd.model.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hk.judiciary.fmk.common.resource.AppHoliday;
import hk.judiciary.fmk.common.resource.AppResourceUtil;
import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.logging.FmkLogger;
import hk.judiciary.fmk.model.application.biz.dto.FmkHolidayCodeDTO;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseNoDTO;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;

/**
 * 
 * @version $Revision: 3663 $ $Date: 2017-01-22 17:48:48 +0800 (Sun, 22 Jan 2017) $
 * @author $Author: vicki.huang $
 */

public class SvdCommonUtil {

    public static final FmkLogger logger = new FmkLogger(SvdCommonUtil.class);

    /**
     * Check the date is holiday
     * 
     * @param date
     * @return true if the date is holiday
     */
    public static boolean isHoliday(Date date) {
        logger.info("isHoliday() starts : date = " + date);
        boolean returnVal = false;

        if (!CommonUtil.isNull(date)) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            AppHoliday appHoliday = AppResourceUtil.getInstance().getAppHoliday();
            FmkHolidayCodeDTO fmkHolidayCodeDTO = appHoliday.getHolidays().get(c.getTime());
            if (fmkHolidayCodeDTO != null) {
                returnVal = true;
            }
        }

        logger.info("isHoliday() ends : returnVal: " + returnVal);
        return returnVal;
    }


    /**
     * Retrieve working date
     * 
     * @param date
     * @param numOfdays
     * @return Date
     */
    public static Date addWorkingDate(Date date, int numOfdays) {
        logger.info("addWorkingDate() starts : date = " + date + ", numOfdays = " + numOfdays);
        Date returnDate = null;
        if (!CommonUtil.isNull(date)) {
        	returnDate = date;
            int dayCount = 0;
            int addOrMinusDay = 0;

            if (numOfdays > 0) {
                addOrMinusDay = 1;
            }
            if (numOfdays < 0) {
                addOrMinusDay = -1;
            }

            while (numOfdays != dayCount) {
                Calendar c = Calendar.getInstance();
                c.setTime(returnDate);
                c.add(Calendar.DATE, addOrMinusDay);
                returnDate = c.getTime();

                if (isWorkingDate(returnDate)) {
                    dayCount = dayCount + addOrMinusDay;
                }
            }
        }
        logger.info("addWorkingDate() ends : returnDate = " + returnDate);
        return returnDate;
    }

    /**
     * Check the date is working day
     * 
     * @param date
     * @return true if the date is working day
     */
    public static boolean isWorkingDate(Date date) {
        logger.info("isWorkingDate() starts : date = " + date);
        boolean returnVal = false;

        if (!CommonUtil.isNull(date)) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            int day = c.get(Calendar.DAY_OF_WEEK);

            if (!isHoliday(date) && day != Calendar.SATURDAY && day != Calendar.SUNDAY) {
                returnVal = true;
            }
        }
        logger.info("isWorkingDate() ends : returnVal = " + returnVal);
        return returnVal;
    }

    /**
     * Get the earliest date among two date
     * 
     * @param date1
     * @param date2
     * @return one of the input date that is the earliest
     */
    public static Date getEarliestDate(Date date1, Date date2) {
        logger.info("getEarliestDate() starts : date1 = " + date1 + ", date2 = " + date2);
        Date returnDate = null;
        if (CommonUtil.isNull(date1)) {
        	returnDate = date2;
        } else if (CommonUtil.isNull(date2)) {
        	returnDate = date1;
        } else if (date1.getTime() <= date2.getTime()) {
        	returnDate = date1;
        } else {
        	returnDate = date2;
        }
        logger.info("getEarliestDate() ends : returnDate = " + returnDate);
        return returnDate;
    }

    /**
     * Get the latest date among two date
     * 
     * @param date1
     * @param date2
     * @return one of the input date that is the latest
     */
    public static Date getLatestDate(Date date1, Date date2) {
        logger.info("getLatestDate() starts : date1 = " + date1 + ", date2 = " + date2);
        Date returnDate = null;
        if (CommonUtil.isNull(date1)) {
        	returnDate = date2;
        } else if (CommonUtil.isNull(date2)) {
        	returnDate = date1;
        } else if (date1.getTime() >= date2.getTime()) {
        	returnDate = date1;
        } else {
        	returnDate = date2;
        }
        logger.info("getEarliestDate() ends : returnDate = " + returnDate);
        return returnDate;
    }

    /**
     * Split case no to CaseDTO
     * 
     * @param caseNo
     * @return CaseNoDTO
     */
	public static CaseNoDTO splitCaseNoToDTO(String caseNo) {
		logger.info("splitCaseNoToDTO() starts : caseNo = " + caseNo);
		CaseNoDTO caseNoDTO = null;
		if (!CommonUtil.isNullOrEmpty(caseNo.trim())) {			
			Pattern caseNoPattern = Pattern.compile("([A-Za-z]+)\\s*(\\d+)/(\\d+)");
			Matcher matcher = caseNoPattern.matcher(caseNo.trim().toUpperCase());
			while (matcher.find()) {
				String comprisingCourt = matcher.group(1).substring(0, 2);
				String caseType = matcher.group(1).substring(2, matcher.group(1).length());
				Integer caseSerialNo = Integer.valueOf(matcher.group(2));
				Integer caseYear = Integer.valueOf(matcher.group(3));
				if (matcher.group(3).length() < 4) {
					caseYear = caseYear + 2000;
				}
				
				caseNoDTO = new CaseNoDTO();
				caseNoDTO.setComprisingCourt(comprisingCourt);
				caseNoDTO.setCaseType(caseType);
				caseNoDTO.setCaseSerialNo(caseSerialNo);
				caseNoDTO.setCaseYear(caseYear);
			}            
		}
		logger.info("splitCaseNoToDTO() ends : caseNoDTO = " + caseNoDTO);
		return caseNoDTO;
	}
	

    /**
     * Get case No. by case entity
     * 
     * @param vCase
     * @return caseNo
     */
    public static String getCaseNo(Case vCase) {
    	logger.info("getCaseNo() starts : vCase = " + vCase);
        String caseNo;
        String caseCourtSystem = "";
        String caseType = "";
        if (vCase.getCompsCourt() != null) {
            caseCourtSystem = DbCommonUtil.getDbValueOrEmpty(vCase.getCompsCourt().getCompsCourtCd());
        }
        if (vCase.getCaseType() != null) {
            caseType = DbCommonUtil.getDbValueOrEmpty(vCase.getCaseType().getCaseTypeCd());
        }

        caseNo = String.format(RequestConstant.CASE_NO_PATTERN, caseCourtSystem, caseType,
                String.valueOf(vCase.getCaseSerNo()), String.valueOf(vCase.getCaseYr()));
        
        logger.info("getCaseNo() ends : caseNo = " + caseNo);
        return caseNo;
    }
}
