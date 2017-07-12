package hk.judiciary.icmssvd.view.batchPrinting.component
{
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.utils.ObjectUtil;
	
	import hk.judiciary.fmk.view.component.AlertMessageBox;
	import hk.judiciary.icmssvd.view.batchPrinting.component.CommonUtils;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.BDDObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.BooleanObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.ComboBoxObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.DateObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.GridPanelObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.NumberObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.ObjectObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.StringObject;
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.ScreenSize;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.DialogInfoVO;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.ErrorMessageInfoVO;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.DateObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.StringObject;
	
	public class CommonUI 
	{
		// Global Properties
		public static var colonEnable:Boolean = true;
		public static var mandatorySymbolEnable:Boolean = true;
		public static var debugEnable:Boolean = true;
		//public static var debugEnable:Boolean = false;
		private var _resolutionBorderWeight:Number = 1;
		[Bindable]
		public function get resolutionBorderWeight():Number { return this._resolutionBorderWeight; }
		public function set resolutionBorderWeight(value:Number):void {}
		private var _showResolutionBorder:Boolean = true;
		[Bindable]
		public function get showResolutionBorder():Boolean { return this._showResolutionBorder; }
		public function set showResolutionBorder(value:Boolean):void { _showResolutionBorder = value; }
		
		// Timer delay 
		public var timerDelay:uint = 500;
		
		// Resolution
		[Bindable]
		public var screenPanelWidth:int;
		[Bindable]
		public var screenPanelHeight:int;
		private var _screenSize:String = ScreenSize.r1024x768;
		//private var _screenSize:String = ScreenSize.r1440x900;
		//private var _screenSize:String = ScreenSize.rAuto;
		private var _portalWidth:int=200;//1024 -40;
		private var _portalHeight:int=200;//768-57-17 -150;
		
		[Bindable]
		public function get screenSize():String { return _screenSize; }
		public function set screenSize(value:String):void { _screenSize = value; }
		
		[Bindable]
		public function get portalWidth():int { return this._portalWidth; }
		public function set portalWidth(value:int):void { this._portalWidth = value; }
		[Bindable]
		public function get portalHeight():int {  return this._portalHeight; }
		public function set portalHeight(value:int):void { this._portalHeight = value; }
		
		public function recalcuateResolution(maxWidth:int, maxHeight:int):void  {
			if (_screenSize == ScreenSize.rAuto) {
				portalWidth = maxWidth - 10;
				portalHeight = maxHeight - 24;
			} else {
				portalWidth = ScreenSize.getScreenWidth(_screenSize);
				portalHeight = ScreenSize.getScreenHeight(_screenSize);
			}
		}
		
		// Special Arrangement
		private var _mainPageTopPadding:int=20-5;
		
		public function get mainPageTopPadding():int { 
			return _mainPageTopPadding + this.panelPadding; 
		}
		
		// Touch Screen Config
		private var _touchScreenEnable:Boolean = false;
		[Bindable]
		public function get touchScreenEnable():Boolean { return _touchScreenEnable; } 
		public function set touchScreenEnable(value:Boolean):void { _touchScreenEnable = value; }
		private var _touchScreenButtonHeight:int=30;
		
		// UI Config
		private var _panelPadding:int=10;
		private var _panelPadding_1024x768:int=10;
		private var _borderPadding:int=10;
		private var _borderPadding_1024x768:int=10;
		private var _labelFieldSpacing:int=10;
		private var _labelFieldSpacing_1024x768:int=10;
		private var _formRowHeight:int=12;
		private var _formRowWithBoxHeight:int=22;
		private var _buttonHeight:int=20+6;
		private var _buttonRowHeight:int=20+6;
		private var _buttonSpacing:int=5;
		private var _memberMargin:int=5;
		private var _memberMargin_1024x768:int=5;
		
		private var _borderColorRGB:String="#BFBFBF";
		private var _borderColorHex:uint=0xBFBFBF;
		
		private var _tabBorderColorRGB:String="#525F73"
		private var _tabBorderColorHex:uint=0x525F73;
		private var _errorBorderColorRGB:String="#FF1F33";
		private var _errorBorderColorHex:uint=0xFF1F33;
		
		private var _defaultDateFieldWidth:int=105;
		private var _defaultDateStringFormat:String="DD/MM/YYYY";
		private var _defaultDateTimeFieldWidth:int=105;
		private var _defaultDateTimeStringFormat:String="DD/MM/YYYY JJ:NN"
		
		private var _defaultRadioButtonWidth:int=12;
		private var _defaultRadioGroupLabelTopPaddding:int=3;
		
		private var _defaultBDDLabelTopPadding:int=3;
		
		private var _defaultTextAreaLabelTopPadding:int=4;
		
		public function get panelPadding():int {
			if (_screenSize == ScreenSize.r1024x768) {
				return this._panelPadding_1024x768;	
			} else {
				return this._panelPadding;
			}
		}
		public function get borderPadding():int {
			if (_screenSize == ScreenSize.r1024x768) {
				return this._borderPadding_1024x768;	
			} else {
				return this._borderPadding;
			}
		}
		public function get labelFieldSpacing():int {
			if (_screenSize == ScreenSize.r1024x768) {
				return this._labelFieldSpacing_1024x768;	
			} else {
				return this._labelFieldSpacing;
			}
		}
		public function get formRowHeight():int {
			return this._formRowHeight;
		}
		public function get formRowWithBoxHeight():int {
			return this._formRowWithBoxHeight;
		}
		public function get buttonHeight():int {
			if (this.touchScreenEnable) {
				return this._touchScreenButtonHeight;
			} else {
				return this._buttonHeight;
			}
		}
		public function get buttonRowHeight():int {
			if (this.touchScreenEnable) {
				return this._touchScreenButtonHeight;	
			} else {
				return this._buttonRowHeight;
			}
		}
		public function get buttonSpacing():int {
			return this._buttonSpacing;
		}
		public function get memberMargin():int {
			if (_screenSize == ScreenSize.r1024x768) {
				return this._memberMargin_1024x768;	
			} else {
				return this._memberMargin;
			}
		}
		
		public function get borderColorRGB():String {
			return this._borderColorRGB;
		}
		public function get borderColorHex():uint {
			return this._borderColorHex;
		}
		
		public function get tabBorderColorRGB():String {
			return this._tabBorderColorRGB;
		}
		public function get tabBorderColorHex():uint {
			return this._tabBorderColorHex;
		}
		
		public function get errorBorderColorRGB():String {
			return this._errorBorderColorRGB;
		}
		public function get errorBorderColorHex():uint {
			return this._errorBorderColorHex;
		}
		
		public function get defaultDateFieldWidth():int {
			return this._defaultDateFieldWidth;
		}
		public function get defaultDateStringFormat():String {
			return this._defaultDateStringFormat;
		}
		
		public function get defaultDateTimeFieldWidth():int {
			return this._defaultDateTimeFieldWidth;
		}
		public function get defaultDateTimeStringFormat():String {
			return this._defaultDateTimeStringFormat;
		}
		
		public function get defaultRadioButtonWidth():int { return this._defaultRadioButtonWidth; }
		public function get defaultRadioGroupLabelTopPadding():int {
			return this._defaultRadioGroupLabelTopPaddding;
		}
		
		public function get defaultBDDLabelTopPadding():int { return this._defaultBDDLabelTopPadding; }
		
		public function get defaultTextAreaLabelTopPadding():int { return this._defaultTextAreaLabelTopPadding; }
		
		protected function isEmptyString(value:String):Boolean {
			return CommonUtils.isEmptyString(value);
		}
		
		protected function isEmptyReplacedBy(value:String, replacedBy:String):String {
			return CommonUtils.isEmptyReplacedBy(value, replacedBy);
		}
		
		protected function getFormattedNumber(value:int):String {
			return CommonUtils.getFormattedNumber(value);
		}
		
		protected function getFormattedDate(value:Date):String {
			return CommonUtils.getFormattedDate(value);
		}
		
		protected function getCustomFormattedDate(value:Date, dateFormat:String):String {
			return CommonUtils.getCustomFormattedDate(value, dateFormat);
		}
		
		protected function getCompareDateNumber(value:Date):int {
			return CommonUtils.getCompareDateNumber(value);
		}
		
		protected function convertNumberToString(value:int):String {
			return CommonUtils.convertNumberToString(value);
		}
		
		protected function convertStringToNumber(value:String):int {
			return CommonUtils.convertStringToNumber(value);
		}
		
		protected function convertStringToBoolean(value:String):Boolean {
			return CommonUtils.convertStringToBoolean(value);
		}
		
		protected function convertBooleanToString(value:Boolean):String {
			return CommonUtils.convertBooleanToString(value);
		}
		
		protected function cloneObject(source:Object):Object {
			var buffer:ByteArray = new ByteArray();
			buffer.writeObject(source);
			buffer.position = 0;
			return buffer.readObject();
		}
		
		protected function compareObject(orgSource:Object, currSource:Object):Boolean {
			var orgBuffer:ByteArray = new ByteArray();
			orgBuffer.writeObject(orgSource);
			
			
			var currBuffer:ByteArray = new ByteArray();
			currBuffer.writeObject(currSource);
			
			var exclude:Array = ["password", "credentials", "uid"]
			
			var orgStr:String = ObjectUtil.toString(orgSource, null, exclude);
			orgStr = replaceAll(orgStr, "(null)", "\"\"");
			var currStr:String = ObjectUtil.toString(currSource, null, exclude);
			currStr = replaceAll(currStr, "(null)", "\"\"");
			//this.showDebugInfo("org: "+orgStr);
			//this.showDebugInfo("cur: "+currStr);
			//this.showDebugInfo("result: "+(orgStr == currStr));
			trace("org: "+orgStr);
			trace("cur: "+currStr);
			
			return orgStr == currStr;
		}
		
		protected function replaceAll(source:String, p:String, repl:String):String {
			var out:String = source;
			var count:int = 0;
			var maxCount:int = 9999;
			while (out.indexOf(p) > 0 && count < maxCount) {
				out = out.replace(p, repl);
				count++;
			}
			return out;
		}
		
		protected function compareTo(value1:Object, value2:Object):int {
			if (value1 is String) {
				return String(value1).localeCompare(String(value2));	
			} else {
				if (value1 < value2) {
					return -1;
				} else if (value1 > value2) {
					return 1;
				} else {
					return 0;
				}
			}
		}
		
		// Standard Error Tooltip
		//protected var tooltipFieldIsRequired:String = "Field is required";
		//protected var tooltipFormatIsInvalid:String = "Data format is invalid";
		
		// For Common Validator
		protected var maxErrorMessageInfoSize:int=10;
		protected var fields:ArrayCollection = new ArrayCollection();
		public var errorMessageInfos:ArrayCollection;
		public var sharedData1:String=null;
		public var sharedData2:String=null;
		public var sharedData3:String=null;
		public var sharedData4:String=null;
		public var sharedData5:String=null;
		public var sharedData6:String=null;
		public var sharedData7:String=null;
		public var sharedData8:String=null;
		public var sharedData9:String=null;
		public var sharedData10:String=null;
		public function get errorMessage1():String { return getErrorMessage(0); }
		public function get errorMessage2():String { return getErrorMessage(1); }
		public function get errorMessage3():String { return getErrorMessage(2); }
		public function get errorMessage4():String { return getErrorMessage(3); }
		public function get errorMessage5():String { return getErrorMessage(4); }
		public function get errorMessage6():String { return getErrorMessage(5); }
		public function get errorMessage7():String { return getErrorMessage(6); }
		public function get errorMessage8():String { return getErrorMessage(7); }
		public function get errorMessage9():String { return getErrorMessage(8); }
		public function get errorMessage10():String { return getErrorMessage(9); }
		
		protected function addField(field:Object):void {
			this.fields.addItem(field);
		}
		protected function formResetAll():void {
			try {
				var i:int;
				for (i=0; i<fields.length; i++) {
					if (fields.getItemAt(i) is StringObject) {
						StringObject(fields.getItemAt(i)).value = "";
					} else if (fields.getItemAt(i) is NumberObject) {
						NumberObject(fields.getItemAt(i)).value = "";
					} else if (fields.getItemAt(i) is DateObject) {
						DateObject(fields.getItemAt(i)).value = null;
					} else if (fields.getItemAt(i) is BDDObject) {
						BDDObject(fields.getItemAt(i)).value = null;
					} else if (fields.getItemAt(i) is ComboBoxObject) {
						ComboBoxObject(fields.getItemAt(i)).value = null;
					} else if (fields.getItemAt(i) is BooleanObject) {
						BooleanObject(fields.getItemAt(i)).value = false;
					} else if (fields.getItemAt(i) is ObjectObject) {
						ObjectObject(fields.getItemAt(i)).value = null;
					} 
				}
			} catch (error:Error) {
				this.showExceptionInfo(error);
			}
		}
		protected function formClearInvalid():void {
			try {
				var i:int;
				for (i=0; i<fields.length; i++) {
					if (fields.getItemAt(i) is StringObject) {
						StringObject(fields.getItemAt(i)).clearInvalid();
					} else if (fields.getItemAt(i) is NumberObject) {
						NumberObject(fields.getItemAt(i)).clearInvalid();
					} else if (fields.getItemAt(i) is DateObject) {
						DateObject(fields.getItemAt(i)).clearInvalid();
					} else if (fields.getItemAt(i) is BDDObject) {
						BDDObject(fields.getItemAt(i)).clearInvalid();
					} else if (fields.getItemAt(i) is ComboBoxObject) {
						ComboBoxObject(fields.getItemAt(i)).clearInvalid();
					} else if (fields.getItemAt(i) is BooleanObject) {
						BooleanObject(fields.getItemAt(i)).clearInvalid();
					} else if (fields.getItemAt(i) is ObjectObject) {
						ObjectObject(fields.getItemAt(i)).clearInvalid();
					} else if (fields.getItemAt(i) is GridPanelObject) {
						GridPanelObject(fields.getItemAt(i)).clearInvalid();
					}
				}
			} catch (error:Error) {
				showExceptionInfo(error);
			}
		}
		protected function formProceedValidate(silenceValidate:Boolean = false):Boolean {
			resetValidationData();
			
			var validationResult:Boolean = true;
			try {
				var i:int;
				var stringObject:StringObject;
				var numberObject:NumberObject;
				var dateObject:DateObject;
				var booleanObject:BooleanObject;
				var bDDObject:BDDObject;
				var comboBoxObject:ComboBoxObject;
				var objectObject:ObjectObject;
				var gridPanelObject:GridPanelObject;
				for (i=0; i<fields.length; i++) {
					if (fields.getItemAt(i) is StringObject) {
						stringObject = fields.getItemAt(i) as StringObject;
						if (!stringObject.validate(silenceValidate)) {
							if (stringObject.getErrorMessageInfo() != null) {
								addErrorMessageInfo(stringObject.getErrorMessageInfo());
							}
							validationResult = false;
						}
					} else if (fields.getItemAt(i) is NumberObject) {
						numberObject = fields.getItemAt(i) as NumberObject;
						if (!numberObject.validate(silenceValidate)) {
							if (numberObject.getErrorMessageInfo() != null) {
								addErrorMessageInfo(numberObject.getErrorMessageInfo());
							}
							validationResult = false;
						}
					} else if (fields.getItemAt(i) is DateObject) {
						dateObject = fields.getItemAt(i) as DateObject;
						if (!dateObject.validate(silenceValidate)) {
							if (dateObject.getErrorMessageInfo() != null) {
								addErrorMessageInfo(dateObject.getErrorMessageInfo());
							}
							validationResult = false;
						}
					} else if (fields.getItemAt(i) is BDDObject) {
						bDDObject = fields.getItemAt(i) as BDDObject;
						if (!bDDObject.validate(silenceValidate)) {
							if (bDDObject.getErrorMessageInfo() != null) {
								addErrorMessageInfo(bDDObject.getErrorMessageInfo());
							}
							validationResult = false;
						}
					} else if (fields.getItemAt(i) is ComboBoxObject) {
						comboBoxObject = fields.getItemAt(i) as ComboBoxObject;
						if (!comboBoxObject.validate(silenceValidate)) {
							if (comboBoxObject.getErrorMessageInfo() != null) {
								addErrorMessageInfo(comboBoxObject.getErrorMessageInfo());
							}
							validationResult = false;
						}
					} else if (fields.getItemAt(i) is BooleanObject) {
						booleanObject = fields.getItemAt(i) as BooleanObject;
						if (!booleanObject.validate(silenceValidate)) {
							if (booleanObject.getErrorMessageInfo() != null) {
								addErrorMessageInfo(booleanObject.getErrorMessageInfo());
							}
							validationResult = false;
						}
					} else if (fields.getItemAt(i) is ObjectObject) {
						objectObject = fields.getItemAt(i) as ObjectObject;
						if (!objectObject.validate(silenceValidate)) {
							if (objectObject.getErrorMessageInfo() != null) {
								addErrorMessageInfo(objectObject.getErrorMessageInfo());
							}
							validationResult = false;
						}
					} else if (fields.getItemAt(i) is GridPanelObject) {
						//this.showDebugInfo("this is grid panel object");
						gridPanelObject = fields.getItemAt(i) as GridPanelObject;
						if (!gridPanelObject.validate(silenceValidate)) {
							if (gridPanelObject.getErrorMessageInfo() != null) {
								addErrorMessageInfo(gridPanelObject.getErrorMessageInfo());
							}
							validationResult = false;
						}
					}
				}
			} catch (error:Error) {
				this.showExceptionInfo(error);
			}
			return validationResult;
		}
		protected function resetValidationData():void {
			sharedData1 = sharedData2 = sharedData3 = sharedData4 = sharedData5 = sharedData6 = sharedData7 = sharedData8 = sharedData9 = sharedData10 = null;
			errorMessageInfos = new ArrayCollection();
		}
		protected function addErrorMessageInfo(errorMessageInfo:ErrorMessageInfoVO):void {
			// Skip duplicate field name
			for (var i:int=0; i<errorMessageInfos.length; i++) {
				var vo:ErrorMessageInfoVO = errorMessageInfos.getItemAt(i) as ErrorMessageInfoVO;
				if (vo.fieldName == errorMessageInfo.fieldName && vo.messageInfoType.priority <= errorMessageInfo.messageInfoType.priority) {
					return ;
				} else if (vo.fieldName == errorMessageInfo.fieldName && vo.messageInfoType.priority > errorMessageInfo.messageInfoType.priority) {
					errorMessageInfos.removeItemAt(i);
					errorMessageInfos.addItemAt(errorMessageInfo, i);
					return;
				}
			}
			
			errorMessageInfos.addItem(errorMessageInfo);
			switch (errorMessageInfos.length) {
				case 1: sharedData1=""; break;
				case 2: sharedData2=""; break;
				case 3: sharedData3=""; break;
				case 4: sharedData4=""; break;
				case 5: sharedData5=""; break;
				case 6: sharedData6=""; break;
				case 7: sharedData7=""; break;
				case 8: sharedData8=""; break;
				case 9: sharedData9=""; break;
				case 10: sharedData10=""; break;
				default: break;
			}
		}
		
		public function getErrorMessage(index:int):String {
			if (index < this.maxErrorMessageInfoSize && index < this.errorMessageInfos.length) {
				var errorMessageInfoVO:ErrorMessageInfoVO = this.errorMessageInfos.getItemAt(index) as ErrorMessageInfoVO;
				//this.showDebugInfo(errorMessageInfoVO.getFormattedBoxMessage());
				return errorMessageInfoVO.getFormattedBoxMessage();
			} else {
				return "";
			}
		}
		
		public function showDialogByDialogInfo(dialogInfoVO:DialogInfoVO, buttonFunc:Function, closeFunc:Function):void {
			showDialog(dialogInfoVO.type, dialogInfoVO.title, dialogInfoVO.content, dialogInfoVO.contentDetail, buttonFunc, closeFunc);
		}
		
		public function showDialog(dialogType:String, dialogTitle:String, dialogContent:String, dialogContentDetail:String, buttonFunc:Function, closeFunc:Function):void {
			var alertBox:AlertMessageBox =  AlertMessageBox(PopUpManager.createPopUp(FlexGlobals.topLevelApplication.document, AlertMessageBox, true));
			alertBox.showAlertBox(dialogType, dialogTitle, dialogContent, dialogContentDetail, buttonFunc, closeFunc);
			PopUpManager.centerPopUp(alertBox);
		}
		
		// Debug Only
		public function showExceptionInfo(error:Error):void {
			showDebugPopup("Error Exception ("+error.errorID+"):\n"+error.message+"\n"+error.getStackTrace(), true);
		}
		
		public function showDebugInfo(debugMsg:String):void {
			showDebugPopup(debugMsg, false);
		}
		
		public function showDebugPopup(debugMsg:String, exceptionCase:Boolean):void {
			if (debugEnable || exceptionCase) {
				var alertBox:AlertMessageBox = AlertMessageBox(PopUpManager.createPopUp(FlexGlobals.topLevelApplication.document, AlertMessageBox, true));
				alertBox.showAlertBox("Info","Info Alert", debugMsg,"Message: "+debugMsg, null, null);
				PopUpManager.centerPopUp(alertBox);
			}
		}
		
		// Func due to ValidationUtil
		public function getComponentPath(parentPath:String, componentId:String):String {
			var path:String = "";
			if (!isEmptyString(parentPath)) {
				path = parentPath;
			}
			if (!isEmptyString(componentId)) {
				if (!isEmptyString(path)) {
					path += ".";
				}
				path += componentId;
			}
			return path;
		}
	}
}