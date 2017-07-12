package hk.judiciary.icmssvd.view.batchPrinting.component
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.BDDObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.DateObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.StringObject;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.LocaleCodeTableVO;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.MessageInfoVO;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.ValidateResultVO;

	public class DateTimeFieldPM extends CommonUI
	{
		public function DateTimeFieldPM()
		{
		}
		
		/** Constant **/
		public static var HOUR_12_DISPLAY:int = 0;
		public static var HOUR_24_DISPLAY:int = 1;
		
		/** Variable **/
		private var _amPmVisible:Boolean;
		[Bindable]
		public function get amPmVisible():Boolean { return this._amPmVisible; }
		public function set amPmVisible(value:Boolean):void { this._amPmVisible = value; }
		private var _displaySetting:int;
		[Bindable]
		public function get displaySetting():int { return this._displaySetting; }
		public function set displaySetting(value:int):void { this._displaySetting = value; }
		[Bindable]
		public var txtHour:StringObject = new StringObject();
		[Bindable]
		public var txtMinute:StringObject = new StringObject();
		[Bindable]
		public var amPmBDDObject:BDDObject = new BDDObject();
		[Bindable]
		public var dtDate:DateObject = new DateObject();
		[Bindable]
		public var required:Boolean;
		[Bindable]
		public var selectedDate:DateObject = new DateObject();
		private var _fieldLabel:String = "";
		[Bindable]
		public function get fieldLabel():String { return _fieldLabel; }
		public function set fieldLabel(value:String):void {
			_fieldLabel = value;
			this.txtHour.fieldLabel = fieldLabel;
			this.txtMinute.fieldLabel = fieldLabel;
			this.dtDate.fieldLabel = fieldLabel;
			this.amPmBDDObject.fieldLabel = fieldLabel;
		}
		
		private var _viewObject:DateTimeField;
		private var _codeTableVOs:ArrayCollection = new ArrayCollection();
		
		public function init(viewObject:DateTimeField):void {
			this._viewObject = viewObject;
			
			//this.showDebugInfo(" displaySetting "+displaySetting);
			
			uiConfig();
			propertyConfig()
		}
		
		private function uiConfig():void {
			this.txtHour.width = 22;
			this.txtMinute.width = 22;
			this.amPmBDDObject.width = 50;
		}
		
		private function propertyConfig():void {
			var codeTableVO:LocaleCodeTableVO = new LocaleCodeTableVO();
			codeTableVO.id = 1;
			codeTableVO.code = "AM";
			codeTableVO.descEng = "AM";
			_codeTableVOs.addItem(codeTableVO);
			
			codeTableVO = new LocaleCodeTableVO();
			codeTableVO.id = 2;
			codeTableVO.code = "PM";
			codeTableVO.descEng = "PM";
			_codeTableVOs.addItem(codeTableVO);
			
			this.amPmBDDObject.dataProvider = _codeTableVOs;
			this.amPmBDDObject.labelField = "descEng";
			
			this.txtHour.inputFormat = "0-9";
			this.txtMinute.inputFormat = "0-9";
			
			this.txtMinute.valueFormat = "^[0-5]?[0-9]{1}$";
			
			this.txtHour.viewObject = this._viewObject.txtHour;
			this.txtMinute.viewObject = this._viewObject.txtMinute;
			this.dtDate.viewObject = this._viewObject.dtDate;
			this.amPmBDDObject.viewObject = this._viewObject.amPmBDD;
			
			this.addField(this.dtDate);
			this.addField(this.txtHour);
			this.addField(this.txtMinute);
			this.addField(this.amPmBDDObject);
		}
		
		public function configDisplaySettingProperty(value:int):void {
			if (value == HOUR_12_DISPLAY) {
				this.amPmVisible = true;
				this.txtHour.valueFormat = "(^[0]?[0-9]{1}$)|(^[1]{1}[0-1]{1}$)";
			} else {
				this.amPmVisible = false;
				this.txtHour.valueFormat = "(^[0]?[0-9]{1}$)|(^[1]{1}[0-9]{1}$)|(^[2]{1}[0-3]{1}$)";
			}
		}
		
		public function configRequiredProperty(value:Boolean):void {
			this.dtDate.required = value;
			//this.txtHour.required = value;
			//this.txtMinute.required = value;
			//this.amPmBDDObject.required = value;
		}
		
		public function constructSelectedDate():Date {
			var dtConstruct:Date = null;
			
			try {
			
			if (this.formProceedValidate(true)) {
				if (this.dtDate.value != null) {
					dtConstruct = this.dtDate.value;
					dtConstruct.hours = 0;
					dtConstruct.minutes = 0;
					
					if (!isEmptyString(txtHour.value)) {
						if (this.displaySetting == HOUR_12_DISPLAY) {
							if (this.amPmBDDObject.value != null) {
								if (LocaleCodeTableVO(this.amPmBDDObject.value).code == "AM") {
									dtConstruct.hours = convertStringToNumber(txtHour.value);
								} else {
									dtConstruct.hours = convertStringToNumber(txtHour.value) + 12;
								}
							}
						} else {
							dtConstruct.hours = convertStringToNumber(txtHour.value); 
						}
					} 
					
					if (!isEmptyString(txtMinute.value)) {
						dtConstruct.minutes = convertStringToNumber(txtMinute.value);
					}
				}
			}
			
			} catch (error:Error) {
				this.showExceptionInfo(error);
			}
			
			this.selectedDate.value = dtConstruct;
			return dtConstruct;
		}
		
		public function configSelectedDate(value:Date):void {
			try {
				this.formResetAll();
				this.formClearInvalid();
				
				if (value != null) {
					this.dtDate.value = value;
					
					if (this.displaySetting == HOUR_12_DISPLAY) {
						if (value.hours > 12) {
							txtHour.value = convertNumberToString(value.hours - 12);
							this.amPmBDDObject.value = this._codeTableVOs.getItemAt(1);
						} else {
							txtHour.value = convertNumberToString(value.hours);
							this.amPmBDDObject.value = this._codeTableVOs.getItemAt(0);
						}
					} else {
						txtHour.value = convertNumberToString(value.hours);
					}
					
					txtMinute.value = convertNumberToString(value.minutes);
					
				} 
				datetimeUIControl();
			} catch (error:Error) {
				this.showExceptionInfo(error);
			}
		}
		
		public function configWidgetEnabled(value:Boolean):void {
			this.dtDate.enable = value;
			this.txtHour.enable = value;
			this.txtMinute.enable = value;
			this.amPmBDDObject.enable = value;
		}
		
		/** Validation related **/
		public function clearValidate():void {
			this.formClearInvalid();
		}
		
		public function proceedValidate():ValidateResultVO {
			clearValidate();
			
			var validateResultVO:ValidateResultVO = new ValidateResultVO();
			
			validateResultVO.validateResult = this.formProceedValidate();
			validateResultVO.errorMessageInfos = this.errorMessageInfos;
			
			return validateResultVO;
		}
		
		public function markExtValidateResult(messageInfoVO:MessageInfoVO):void {
			this.dtDate.messageInfoVO = messageInfoVO;
			this.dtDate.showErrorTooltip(dtDate.getErrorTooltip());
		}
		
		private function datetimeUIControl():void {
			if (isEmptyString(this.txtHour.value) &&
				isEmptyString(this.txtMinute.value) &&
				amPmBDDObject.value == null) {
				txtHour.required = false;
				txtMinute.required = false;
				amPmBDDObject.required = false;
			} else {
				txtHour.required = true;
				txtMinute.required = true;
				amPmBDDObject.required = true;
			}
		}
		
		/** Action **/
		public function dateTimeFieldFocusOut():void {
			this.constructSelectedDate();
		}
		
		public function testClickedEvent():void {
			this.showDebugInfo("Widget value "+this.constructSelectedDate());
		}
		
		public function timeChangeEvent():void {
			datetimeUIControl();
		}
		
		public function amPmBDDChangeEvent(index:int, item:Object):void {
			datetimeUIControl();
		}
	}
}