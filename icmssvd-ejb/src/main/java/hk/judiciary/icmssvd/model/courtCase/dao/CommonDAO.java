package hk.judiciary.icmssvd.model.courtCase.dao;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.ejb.dao.AbstractFmkJpaDAO;
import hk.judiciary.fmk.ejb.dao.AbstractJpaDAO;
import hk.judiciary.fmk.ejb.dao.entity.AbstractEntity;
import hk.judiciary.fmk.logging.FmkLogger;
import hk.judiciary.fmk.logging.LogLevel;
//comment by molly
//import hk.judiciary.fmk.model.application.biz.dto.AuditTrailSearchCodeDTO;
import hk.judiciary.fmk.model.application.dao.AuditTrailDAO;
import hk.judiciary.fmk.model.application.dao.entity.AuditTrail;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CommonRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.OrderByCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.RecordStatusConstant;


public class CommonDAO<T extends AbstractEntity> extends AbstractJpaDAO<T> {
	
	public static class Fields {
		public static final String EFFV_START_DATE_NAME = "effvStartDate";
		public static final String EFFV_END_DATE_NAME = "effvEndDate";
		public static final String ACTIVE_FLAG_NAME = "activeFlag";
		public static final String COURT_LVL_TYPE_NAME = "courtLvlType";		
		public static final String COURT_LVL_TYPE_ID_NAME = "courtLvlTypeId";
		public static final String JOIN_COURT_LVL_TYPE_NAME = "courtLvlType";
		public static final String JOIN_COURT_LVL_TYPE_ID_NAME = COURT_LVL_TYPE_NAME + "." + COURT_LVL_TYPE_ID_NAME;		
	}
	
	private Boolean debugInfoEnable = true;
	protected FmkLogger fmkLogger = null;
	
	protected <Z> CommonDAO(Class<Z> clazz) {
		fmkLogger = getLogger(clazz);
	}
	
	protected <Z> FmkLogger getLogger(Class<Z> clazz) {
		if (fmkLogger == null ){
			fmkLogger = new FmkLogger(clazz);
		}
		return fmkLogger;
	}
	
	protected String getDbUser() {
		//return "FILDEVOWN02.";
		return "";
	}
	
	protected String appendSql(String source, String sql) {
		String sqlStr = "";
		
		if (!CommonUtil.isNull(source) && !CommonUtil.isNull(sql)) {
			sqlStr = source + " " + sql + " ";
		}
		
		return sqlStr;
	}
	
	private <E extends AbstractEntity> boolean isColumnExist(String colName, E entity) {
		boolean isExist = false;
		for (Field field : entity.getClass().getDeclaredFields()) {
			if (field.getName().equals(colName)) {
				isExist = true;
				break;
			}
		}
		return isExist;
	}
	
	protected <D extends CommonRetrieveCriteriaDTO, E extends AbstractEntity> List<Predicate> appendCommonCriteriaByCriteriaBuilder(CriteriaBuilder criteriaBuilder, Root<T> entityRoot, List<Predicate> criterias, D retrieveCriteriaDTO, Class<T> entityClass) throws InstantiationException, IllegalAccessException  {
		E entity = (E) entityClass.newInstance();
		
		Predicate criteria = null;
		if (retrieveCriteriaDTO.getEffvStartDateCheck() && isColumnExist(Fields.EFFV_START_DATE_NAME, entity)) {
			GregorianCalendar gCalendar = new GregorianCalendar();
			gCalendar.setTime(new Date());
			gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
			gCalendar.set(GregorianCalendar.MINUTE, 0);
			gCalendar.set(GregorianCalendar.SECOND, 0);
			
			criteria = criteriaBuilder.equal(entityRoot.get(Fields.EFFV_START_DATE_NAME), gCalendar.getTime());
			criterias.add(criteria); 
		}
		if (retrieveCriteriaDTO.getEffvEndDateCheck() && isColumnExist(Fields.EFFV_END_DATE_NAME, entity)) {
			GregorianCalendar gCalendar = new GregorianCalendar();
			gCalendar.setTime(new Date());
			gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
			gCalendar.set(GregorianCalendar.MINUTE, 0);
			gCalendar.set(GregorianCalendar.SECOND, 0);
			gCalendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
			
			criteria = criteriaBuilder.equal(entityRoot.get(Fields.EFFV_END_DATE_NAME), gCalendar.getTime());
			criterias.add(criteria);
		}
		if (retrieveCriteriaDTO.getActiveFlag() != null && isColumnExist(Fields.ACTIVE_FLAG_NAME, entity)) {
			criteria = criteriaBuilder.equal(entityRoot.get(Fields.ACTIVE_FLAG_NAME), retrieveCriteriaDTO.getActiveFlag());
			criterias.add(criteria);
		}
		if (retrieveCriteriaDTO.getCourtLvlType() != null) {
			Join<E, CourtLvlType> entity2CourtLvlTypeJoin = null;
			entity2CourtLvlTypeJoin = entityRoot.join(Fields.JOIN_COURT_LVL_TYPE_NAME, JoinType.INNER);
			criteria = criteriaBuilder.equal(entity2CourtLvlTypeJoin.get(Fields.COURT_LVL_TYPE_ID_NAME), retrieveCriteriaDTO.getCourtLvlType().getCourtLvlTypeId());
			criterias.add(criteria);
		}
		
		return criterias;
	}
	
	protected <D extends CommonRetrieveCriteriaDTO> List<Order> genCommonCriteriaOrderList(CriteriaBuilder criteriaBuilder, Root<T> entityRoot, D retrieveCriteriaDTO) {
		List<Order> orders = null;
		Order order = null;
		if (retrieveCriteriaDTO.getOrderByCriterias() != null) {
			orders = new ArrayList<Order>();
			OrderByCriteriaDTO orderByCriteriaDTO = null;
			for (int i=0; i<retrieveCriteriaDTO.getOrderByCriterias().size(); i++) {
				orderByCriteriaDTO = retrieveCriteriaDTO.getOrderByCriterias().get(i);
				if ("ASC".equals(orderByCriteriaDTO.getSortOrder())) {
					order = criteriaBuilder.asc(entityRoot.get(orderByCriteriaDTO.getFieldName()));
				} else if ("DESC".equals(orderByCriteriaDTO.getSortOrder())) {
					order = criteriaBuilder.desc(entityRoot.get(orderByCriteriaDTO.getFieldName()));
				}
				if (!CommonUtil.isNull(order)) {
					orders.add(order);
				}
			}
		}
		return orders;
	}
	
	protected <D extends CommonRetrieveCriteriaDTO, E extends AbstractEntity> String appendCommonCodeTableCriteria(String queryStrIn, D retrieveCriteriaDTO, Class<T> entityClass) throws InstantiationException, IllegalAccessException {
		String queryStr = queryStrIn;
		
		E entity = (E) entityClass.newInstance();
		
		if (retrieveCriteriaDTO.getEffvStartDateCheck() && isColumnExist(Fields.EFFV_START_DATE_NAME, entity)) {
			queryStr = appendSql(queryStr, "AND t."+Fields.EFFV_START_DATE_NAME+" <= :effvStartDate");
		}
		if (retrieveCriteriaDTO.getEffvEndDateCheck() && isColumnExist(Fields.EFFV_END_DATE_NAME, entity)) {
			queryStr = appendSql(queryStr, "AND t."+Fields.EFFV_END_DATE_NAME+" > :effvEndDate");
		}
		if (retrieveCriteriaDTO.getActiveFlag() != null && isColumnExist(Fields.ACTIVE_FLAG_NAME, entity)) {
			queryStr = appendSql(queryStr, "AND t."+Fields.ACTIVE_FLAG_NAME+" = :activeFlag");
		}
		if (retrieveCriteriaDTO.getCourtLvlType() != null && isColumnExist(Fields.COURT_LVL_TYPE_NAME, entity)) {
			queryStr = appendSql(queryStr, "AND t."+Fields.JOIN_COURT_LVL_TYPE_ID_NAME+" = :courtLvlTypeId");
		}
		
		if (retrieveCriteriaDTO.getOrderByCriterias() != null) {
			queryStr = appendSql(queryStr, "ORDER BY");
			OrderByCriteriaDTO orderByCriteriaDTO = null;
			for (int i=0; i<retrieveCriteriaDTO.getOrderByCriterias().size(); i++) {
				orderByCriteriaDTO = retrieveCriteriaDTO.getOrderByCriterias().get(i);
				queryStr = appendSql(queryStr, "t."+orderByCriteriaDTO.getFieldName()+" "+orderByCriteriaDTO.getSortOrder());
				
				if (i + 1< retrieveCriteriaDTO.getOrderByCriterias().size()) {
					queryStr = appendSql(queryStr, ",");
				}
			}
		}
		
		return queryStr;
	}
	
	protected <D extends CommonRetrieveCriteriaDTO, E extends AbstractEntity> TypedQuery<T> appendCommonCodeTableCriteriaParameter(TypedQuery<T> queryIn, D retrieveCriteriaDTO, Class<T> entityClass) throws InstantiationException, IllegalAccessException {
		TypedQuery<T> query = queryIn;
		
		E entity = (E) entityClass.newInstance();
		
		if (retrieveCriteriaDTO.getEffvStartDateCheck() && isColumnExist(Fields.EFFV_START_DATE_NAME, entity)) {
			GregorianCalendar gCalendar = new GregorianCalendar();
			gCalendar.setTime(new Date());
			gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
			gCalendar.set(GregorianCalendar.MINUTE, 0);
			gCalendar.set(GregorianCalendar.SECOND, 0);
			query.setParameter("effvStartDate", gCalendar.getTime());
		}
		if (retrieveCriteriaDTO.getEffvEndDateCheck() && isColumnExist(Fields.EFFV_END_DATE_NAME, entity)) {
			GregorianCalendar gCalendar = new GregorianCalendar();
			gCalendar.setTime(new Date());
			gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
			gCalendar.set(GregorianCalendar.MINUTE, 0);
			gCalendar.set(GregorianCalendar.SECOND, 0);
			gCalendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
			query.setParameter("effvEndDate", gCalendar.getTime());
		}
		if (retrieveCriteriaDTO.getActiveFlag() != null && isColumnExist(Fields.ACTIVE_FLAG_NAME, entity)) {
			query.setParameter("activeFlag", retrieveCriteriaDTO.getActiveFlag());
		}
		if (retrieveCriteriaDTO.getCourtLvlType() != null && isColumnExist(Fields.COURT_LVL_TYPE_NAME, entity)) {
			query.setParameter("courtLvlTypeId", retrieveCriteriaDTO.getCourtLvlType().getCourtLvlTypeId());
		}
		return query;
	}
	
	protected void logDebugInfo(String title, String info) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS", Locale.US);
		String titleEd = "";
		if (!CommonUtil.isNull(title)) {
			titleEd = title+": ";
		}
		String infoEd = "";
		if (!CommonUtil.isNull(info)) {
			infoEd = info;
		}
		
		if (debugInfoEnable) {
			System.out.println(sdf.format(new Date())+" [DEBUG] "+titleEd+infoEd);
			log(LogLevel.DEBUG, titleEd+infoEd, null);
		}
	}
	
	protected void log(LogLevel logLevel, String message, Throwable t) {
		if (fmkLogger != null) {
			fmkLogger.log(logLevel, message, t);
		}
	}
	
	protected boolean isNewRecord(String recordStatusCode) {
		boolean reordResult = false;
		if (recordStatusCode != null && recordStatusCode.equals(RecordStatusConstant.NEW.getCode())) {
			reordResult = true;
		}
		return reordResult;
	}
	
	protected boolean isUpdateRecord(String recordStatusCode) {
		boolean reordResult = false;
		if (recordStatusCode != null && recordStatusCode.equals(RecordStatusConstant.UPDATE.getCode())) {
			reordResult = true;
		}
		return reordResult;
	}
	
	protected boolean isDeleteRecord(String recordStatusCode) {
		boolean reordResult = false;
		if (recordStatusCode != null && recordStatusCode.equals(RecordStatusConstant.DELETE.getCode())) {
			reordResult = true;
		}
		return reordResult;
	}
	
	protected static String convertTableName(String tableName) {
		String convertedName = null;
		if (tableName != null) {
			convertedName = tableName;
			convertedName = convertedName.substring(0, 1).toLowerCase() + convertedName.substring(1);
		} 
		return convertedName;
	}
	
	protected <E extends AbstractEntity> boolean isSearchKeyExist(E entity) {
		AbstractFmkJpaDAO<AuditTrail> auditTrailDAO = new AuditTrailDAO(entity.getPersistenceUnit());
		String tableName = auditTrailDAO.getTableName(entity.getClass());
//		Map<String, AuditTrailSearchCodeDTO> auditTrailSearchMap = (Map)AppResourceUtil.getInstance().getAppAuditTrailSearch().getAuditTrailSearches().get(tableName.toLowerCase());
//		if (CommonUtil.isNullOrEmpty(auditTrailSearchMap)) {
//			System.out.println(">>>>> Search key of "+tableName+" is missing!");
//			return false;
//		} else {
//			return true;
//		}
		return false;
	}
	
	protected Date convertDateFrom(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
		String dateFromStr = sdf.format(date);
		dateFromStr = dateFromStr.substring(0, 8) + "000000";
		
		Date dateFrom = sdf.parse(dateFromStr);
		return dateFrom;		
	}
	
	protected Date convertDateTo(Date date, boolean plusOneDay) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
			
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		if (plusOneDay) {
			gCalendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
			
		String dateFormatStr = sdf.format(gCalendar.getTime());
		if (plusOneDay) {
			dateFormatStr = dateFormatStr.substring(0, 8) + "000000";
		} else {
			dateFormatStr = dateFormatStr.substring(0, 8) + "235959";
		}
		Date dateTo = sdf.parse(dateFormatStr);
		return dateTo;
	}
	
	public Integer getMax() throws InstantiationException, IllegalAccessException { 
		return 0; 
	}
	public String getSeqName() {
		return "";
	}
}
