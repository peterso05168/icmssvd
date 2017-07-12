package hk.judiciary.icmssvd.model.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import hk.judiciary.fmk.logging.FmkLogger;

public class DbCommonUtil {

    public static final FmkLogger logger = new FmkLogger(DbCommonUtil.class);

    /**
     * Get System DateTime
     * 
     * @return Date
     */
    public static Date getCurrentSystemDateTime() {
         return new Date();
    }


    /**
     * Get input value or empty string (if input value is null)
     * 
     * @param dbValue
     * @return returnDbValue
     */
    public static String getDbValueOrEmpty(String dbValue) {
//    	logger.info("getDbValueOrEmpty() starts : dbValue = " + dbValue);
        String returnDbValue = "";
        if (dbValue != null) {
        	returnDbValue = dbValue.trim();
        }
//        logger.info("getDbValueOrEmpty() ends : returnDbValue =  " + returnDbValue);
        return returnDbValue;
    }

    /**
     * Get the start datetime of input date
     * 
     * @param inputDate
     * @return startDateTime
     */
    public static Date getStartDateTime(Date inputDate) {
//    	logger.info("getStartDateTime() starts : inputDate = " + inputDate);
        Date startDateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer sb = new StringBuffer(sdf.format(inputDate));
        sb.append(" 00:00");
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
        	startDateTime = sdf.parse(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
//        logger.info("getStartDateTime() ends : startDateTime = " + startDateTime);
        return startDateTime;
    }

    
    /**
     * Get the end datetime of input date
     * 
     * @param inputDate
     * @return endDateTime
     */
    public static Date getEndDateTime(Date inputDate) {
//    	logger.info("getEndDateTime() starts : inputDate = " + inputDate);
        Date endDateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer sb = new StringBuffer(sdf.format(inputDate));
        sb.append(" 23:59");
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
        	endDateTime = sdf.parse(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
//        logger.info("getEndDateTime() ends : endDateTime = " + endDateTime);
        return endDateTime;
    }


    /**
     * Check the id is valid or not
     * 
     * @param id
     * @return true if the id is valid (i.e. not null and value > 0)
     */
    public static boolean isValidDbId(Integer id) {
//    	logger.info("isValidDbId() starts : id = " + id);
    	boolean returnVal = false;
    	if (id != null && id.intValue() > 0) {
    		returnVal = true;
    	}
//    	logger.info("isValidDbId() ends : returnVal = " + returnVal);
        return returnVal;
    }
}
