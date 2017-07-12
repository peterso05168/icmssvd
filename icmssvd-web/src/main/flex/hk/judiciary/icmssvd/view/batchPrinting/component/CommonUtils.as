package hk.judiciary.icmssvd.view.batchPrinting.component
{
	import mx.core.FlexGlobals;
	import mx.formatters.DateFormatter;
	import mx.formatters.NumberFormatter;
	import mx.managers.PopUpManager;
	
	import hk.judiciary.fmk.view.component.AlertMessageBox;
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.LangInd;
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.MessageInfoType;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.MessageInfoVO;

	public class CommonUtils
	{
		public static function isEmptyString(value:String):Boolean {
			if (!value || value == null) {
				return true;
			} else {
				if (value.replace(" ", "").length == 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		public static function isEmptyReplacedBy(value:String, replacedBy:String):String {
			if (!isEmptyString(value)) {
				return value;
			} else {
				return replacedBy;
			}
		}
		
		public static function trim(value:String):String {
			if (!isEmptyString(value)) {
				return value.replace(" ", "");
			} else {
				return "";
			}
		}
		
		public static function getFormattedDate(value:Date):String {
			var formatter:DateFormatter = new DateFormatter();
			formatter.formatString = "DD/MM/YYYY";
			return formatter.format(value);
		}
		
		public static function getCustomFormattedDate(value:Date, dateFormat:String):String {
			var formatter:DateFormatter = new DateFormatter();
			if (isEmptyString(dateFormat)) {
				formatter.formatString = "DD/MM/YYYY";
			} else {
				formatter.formatString = dateFormat;
			}
			return formatter.format(value);
		}
		
		public static function getCompareDateNumber(value:Date):int {
			var formatter:DateFormatter = new DateFormatter();
			formatter.formatString = "YYYYMMDD";
			var dateStr:String = formatter.format(value);
			return convertStringToNumber(dateStr);
		}
		
		public static function getFormattedNumber(value:int):String {
			var formatter:NumberFormatter = new NumberFormatter();
			
			formatter.useThousandsSeparator = true;
			formatter.thousandsSeparatorTo = ",";
			formatter.precision = -1;
			formatter.rounding = "none";
			
			return formatter.format(value);
		}
		
		public static function getFormattedName(surname:String, givenName:String, langInd:String):String {
			var formattedName:String = "";
			
			if (langInd == LangInd.ENGLISH) {
				if (!isEmptyString(surname)) {
					formattedName += surname;
				}
				if (!isEmptyString(givenName)) {
					if (!isEmptyString(formattedName)) {
						formattedName += " ";
					}
					formattedName += givenName;
				}
			} else if (langInd == LangInd.CHINESE) {
				if (!isEmptyString(surname)) {
					formattedName += surname;
				}
				if (!isEmptyString(givenName)) {
					formattedName += givenName;
				}
			}
			
			return formattedName;
		}
		
		public static function getMaskedValue(value:String, maskChar:String, maskPos:int):String {
			var maskedValue:String = "";
			
			if (!isEmptyString(value)) {
				var i:int;
				for (i=0; i<value.length; i++) {
					if (i < maskPos) {
						maskedValue += value.substr(i, 1);
					} else {
						maskedValue += maskChar;
					}
				}
			}
			
			return maskedValue;
		}
		
		public static function convertNumberToString(value:int):String {
			return String(value);
		}
		
		public static function convertStringToNumber(value:String):int {
			if (value != null || !value) {
				var deformattedNumber:String = value.replace(",", "");
				return int(deformattedNumber);
			} else {
				return 0;
			}
		}
		
		public static function convertStringToBoolean(value:String):Boolean {
			if (!isEmptyString(value) && value == "1") {
				return true;
			} else {
				return false;
			}
		}
		
		public static function convertBooleanToString(value:Boolean):String {
			if (value) {
				return "1";
			} else {
				return "0";
			}
		}
		
		public static function genEventToken():String {
			var token:String = "";
			
			token = getCustomFormattedDate(new Date(), "YYYYMMDD-T-HHNNSSQQQ");
			
			return token;
		}
		
		public static function getMessageInfoTypeByCode(code:String):MessageInfoVO {
			var messageInfoVO:MessageInfoVO;
			switch (code) {
				case MessageInfoType.FIELD_IS_REQUIRED.code: messageInfoVO = MessageInfoType.FIELD_IS_REQUIRED; break;
				case MessageInfoType.FORMAT_IS_INVALID.code: messageInfoVO = MessageInfoType.FORMAT_IS_INVALID; break;
				case MessageInfoType.VALUE_IS_DUPLICATED.code: messageInfoVO = MessageInfoType.VALUE_IS_DUPLICATED; break;
				case MessageInfoType.DATE_IS_INVALID.code: messageInfoVO = MessageInfoType.DATE_IS_INVALID; break;
				case MessageInfoType.DOB_SHOULD_NOT_EARLIER_THAN_TODAY.code: messageInfoVO = MessageInfoType.DOB_SHOULD_NOT_EARLIER_THAN_TODAY; break;
				case MessageInfoType.HKIC_NO_IS_INVALID.code: messageInfoVO = MessageInfoType.HKIC_NO_IS_INVALID; break;
				default: messageInfoVO = null; break;
			}
			return messageInfoVO;
		}
		
		// Debug Only
		public static function showDebugPopup(debugMsg:String, exceptionCase:Boolean):void {
			if (CommonUI.debugEnable || exceptionCase) {
				var alertBox:AlertMessageBox =  AlertMessageBox(PopUpManager.createPopUp(FlexGlobals.topLevelApplication.document, AlertMessageBox, true));
				alertBox.showAlertBox("Info","Info Alert", debugMsg,"Message: "+debugMsg, null, null);
				PopUpManager.centerPopUp(alertBox);
			}
		}
		
		public static function showExceptionInfo(error:Error):void {
			showDebugPopup("Error Exception ("+error.errorID+"):\n"+error.message+"\n"+error.getStackTrace(), true);
		}
		
		public static function showDebugInfo(debugMsg:String):void {
			showDebugPopup(debugMsg, false);
		}
	}
}