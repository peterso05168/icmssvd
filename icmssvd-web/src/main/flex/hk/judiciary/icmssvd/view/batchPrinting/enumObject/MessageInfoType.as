package hk.judiciary.icmssvd.view.batchPrinting.enumObject
{
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.MessageInfoType;
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.MessageTypePriority;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.MessageInfoVO;
	
	public class MessageInfoType
	{
		public static var FIELD_IS_REQUIRED:MessageInfoVO = new MessageInfoVO().setProperties("MIC0001", "Field is required", "is required.", MessageTypePriority.REQUIRED);
		public static var FORMAT_IS_INVALID:MessageInfoVO = new MessageInfoVO().setProperties("MIC0002", "Format is invalid", "format is invalid.", MessageTypePriority.INVALID);
		public static var VALUE_IS_DUPLICATED:MessageInfoVO = new MessageInfoVO().setProperties("MIC0003", "Value is duplicated", "is duplicated.", MessageTypePriority.DUPLICATION);
		public static var DATE_IS_INVALID:MessageInfoVO = new MessageInfoVO().setProperties("MIC0004", "Date is valid", "is invalid.", MessageTypePriority.INVALID);
		public static var GRID_WITH_ISSUE:MessageInfoVO = new MessageInfoVO().setProperties("MIC0005", "Issue(s) is/are found:\n{0}", "with issue(s)", MessageTypePriority.INVALID);
		public static var ADDRESS_WITH_ISSUE:MessageInfoVO = new MessageInfoVO().setProperties("MIC006", "Issue(s) is/are found:\n{0}", "with issue(s)", MessageTypePriority.INVALID);
		
		// Date Specific
		public static var MIN_DATE_ERROR:MessageInfoVO = new MessageInfoVO().setProperties("DAT0001", "Date should not earlier than {0}", "is invalid.", MessageTypePriority.INVALID);
		public static var MAX_DATE_ERROR:MessageInfoVO = new MessageInfoVO().setProperties("DAT0002", "Date should not later than {0}", "is invalid.", MessageTypePriority.INVALID);
		
		// DOB Specific
		public static var DOB_SHOULD_NOT_EARLIER_THAN_TODAY:MessageInfoVO = new MessageInfoVO().setProperties("DOB0001", "DOB should not earlier than today", "DOB should not earlier than today.", MessageTypePriority.SPECIFIC)
		
		// HKID Specific
		public static var HKIC_NO_IS_INVALID:MessageInfoVO = new MessageInfoVO().setProperties("DOC0001", "HKIC No is invalid", "HKIC No is invalid", MessageTypePriority.INVALID);
		
		// Module Specific
		public static var MAX_YEAR_ERROR:MessageInfoVO = new MessageInfoVO().setProperties("SPC0001", "Year should not later than {0}", "is invalid.", MessageTypePriority.INVALID);
		public static var MAX_MONTH_YEAR_ERROR:MessageInfoVO = new MessageInfoVO().setProperties("SPC0002", "Month and Year should not later than {0}", "is invalid.", MessageTypePriority.INVALID);
		public static var NO_DEFENDANT_SELECTED:MessageInfoVO = new MessageInfoVO().setProperties("SPC0003", "At least ONE {0} should be selected", "is required.", MessageTypePriority.REQUIRED);
		public static var NON_JUVENILE_DEFENDANT_TYPE:MessageInfoVO = new MessageInfoVO().setProperties("SPC0004", "Defendant type should be Juvenile when age is under sixteen", "is invalid.", MessageTypePriority.INVALID);
		public static var EITHER_ENG_OR_CHI_ADDRESS_IS_REQUIRED:MessageInfoVO = new MessageInfoVO().setProperties("SPC0005", "Either English or Chinese address is required", "is required.", MessageTypePriority.REQUIRED);
		public static var NON_ADULT_DEFENDANT_TYPE:MessageInfoVO = new MessageInfoVO().setProperties("SPC0006", "Defendant type should be Adult when age is equal or above sixteen", "is invalid.", MessageTypePriority.INVALID);
		public static var SOD_SYSTEM_VARIABLE_IS_DUPLICATED:MessageInfoVO = new MessageInfoVO().setProperties("SPC0007", "{0} is duplicated", "{0} is duplicated.", MessageTypePriority.INVALID);
		
		// FMK Specific
		public static var FMK_SPECIFIC:MessageInfoVO = new MessageInfoVO().setProperties("FMK0000", "", "",MessageTypePriority.REQUIRED);
	}
}