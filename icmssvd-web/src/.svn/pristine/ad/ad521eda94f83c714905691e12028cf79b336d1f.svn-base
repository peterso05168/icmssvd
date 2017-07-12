package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	import hk.judiciary.icmssvd.view.batchPrinting.component.CommonUtils;
	import hk.judiciary.icmssvd.view.batchPrinting.component.DateTimeField;
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.MessageInfoType;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.ErrorMessageInfoVO;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.ValidateResultVO;

	public class DateObject extends FieldObject
	{
		private var _valueText:String = "";
		[Bindable]
		public function get valueText():String { return _valueText; }
		public function set valueText(value:String):void { _valueText = value; }
		
		public function DateObject()
		{
			super();
			value = null;
			inputFormat = "0-9\\-/";
			editable = false;
		}
		
		public static var DATE_PAIR_FROM:String = "[FROM]";
		public static var DATE_PAIR_TO:String = "[TO]";
		
		public static function getMinToday():Date {
			var today:Date = new Date();
			today.hours = 0;
			today.minutes = 0;
			today.seconds = 0;
			today.milliseconds = 0;
			
			return today;
		}
		
		public static function getMaxToday():Date {
			var today:Date = new Date();
			today.hours = 23;
			today.minutes = 59;
			today.seconds = 59;
			today.milliseconds = 999;
			
			return today;
		}
		
		[Bindable]
		public function get value():Date {
			if (this.viewObject != null && this.viewObject is DateTimeField) {
				return DateTimeField(this.viewObject).model.constructSelectedDate();
			} else {
				return super.getValue() as Date;
			}
		}
		public function set value(value:Date):void {
			if (this.viewObject != null && this.viewObject is DateTimeField) {
				DateTimeField(this.viewObject).model.configSelectedDate(value);
			} else {
				super.setValue(value as Date);
			}
		}
		
		override public function set fieldLabel(value:String):void
		{
			// TODO Auto Generated method stub
			if (this.viewObject != null && this.viewObject is DateTimeField) {
				DateTimeField(this.viewObject).model.fieldLabel = value;
			}
			super.fieldLabel = value;
		}
		
		
		override public function set required(value:Boolean):void
		{
			// TODO Auto Generated method stub
			if (this.viewObject != null && this.viewObject is DateTimeField) {
			 	DateTimeField(this.viewObject).model.configRequiredProperty(value);
			} 
			super.required = value;
		}
		
		override public function clearInvalid():void
		{
			// TODO Auto Generated method stub
			if (this.viewObject != null && this.viewObject is DateTimeField) {
				DateTimeField(this.viewObject).model.clearValidate();
			} else {
				super.clearInvalid();
			}
		}
		
		private var _disableDays:Array = [];
		[Bindable] 
		public function get disableDays():Array { return this._disableDays; }
		public function set disableDays(value:Array):void { this._disableDays = value; }
		
		private var _minDate:Date = null;
		[Bindable]
		public function get minDate():Date { return this._minDate; }
		public function set minDate(value:Date):void { this._minDate = value; }
		
		private var _maxDate:Date = null;
		[Bindable]
		public function get maxDate():Date { return this._maxDate; }
		public function set maxDate(value:Date):void { this._maxDate = value; }
		
		private var _datePair:DateObject = null;
		[Bindable]
		public function get datePair():DateObject { return this._datePair; }
		public function set datePair(value:DateObject):void { this._datePair = value; }
		
		private var _datePairType:String = "";
		[Bindable]
		public function get datePairType():String { return this._datePairType; }
		public function set datePairType(value:String):void { this._datePairType = value; }
		
		override public function validate(silenceValidate:Boolean = false):Boolean
		{
			// TODO Auto Generated method stub
			var isValid:Boolean = true;
			try {
			if (!silenceValidate) {
				clearInvalid();
			}
			
			if (this.viewObject != null && this.viewObject is DateTimeField) {
				var validateResultVO:ValidateResultVO;
				var errorMessageInfoVO:ErrorMessageInfoVO;
				if (isValid) {
					validateResultVO = DateTimeField(this.viewObject).model.proceedValidate();
					if (!validateResultVO.validateResult) {
						if (validateResultVO.errorMessageInfos != null && validateResultVO.errorMessageInfos.length > 0) {
							var errorMessageInfo:ErrorMessageInfoVO = validateResultVO.errorMessageInfos.getItemAt(0) as ErrorMessageInfoVO;
							messageInfoVO = errorMessageInfo.messageInfoType;
						}
						isValid = false;
					}
					/*
					isValid = validateResultVO.validateResult;
					if (validateResultVO.errorMessageInfos != null && validateResultVO.errorMessageInfos.length > 0) {
						this.messageInfoVO = ErrorMessageInfoVO(validateResultVO.errorMessageInfos.getItemAt(0)).messageInfoType;
					}
					*/
					//this.value = DateTimeField(this.viewObject).model.constructSelectedDate();
					
				}
			} 
			
			if (isValid) {
				isValid = requiredValidation(value);
			}
			if (isValid) {
				isValid = valueFormatValidation(value);
			}
			if (isValid) {
				isValid = dateRangeValidation(value);
			}
			if (isValid) {
				isValid = datePairValidation(value);
			}
			
			if (!silenceValidate) {
				if (this.viewObject != null && this.viewObject is DateTimeField) {
					DateTimeField(this.viewObject).model.markExtValidateResult(this.messageInfoVO);
				} else {
					showErrorTooltip(getErrorTooltip());
				}
			}
			} catch (error:Error) {
				CommonUtils.showExceptionInfo(error);
			}
			return isValid;
		}
		
		override protected function requiredValidation(value:Object):Boolean
		{
			// TODO Auto Generated method stub
			//return super.requiredValidation();
			var isValid:Boolean = true;
			
			if (isViewObjectVisible() && this.required && value == null) {
				isValid = false;
				this.messageInfoVO = MessageInfoType.FIELD_IS_REQUIRED; 
			}
			
			return isValid;
		}
		
		protected function dateRangeValidation(value:Date):Boolean {
			var isValid:Boolean = true;
			
			try {
			if (isViewObjectVisible()) {
				if (value != null && this.minDate != null && this.maxDate == null) {
					//CommonUtils.showDebugInfo("dateMin validate "+this.value+" "+this.minDate+" | "+this.value.getTime()+" "+this.minDate.getTime());
					if (value.getTime() < this.minDate.getTime()) {
						isValid = false;
						this.messageInfoVO = MessageInfoType.MIN_DATE_ERROR;
						this.messageInfoVO.args = [CommonUtils.getFormattedDate(this.minDate)];
					}
				} else if (value != null && this.minDate == null && this.maxDate != null) {
					//CommonUtils.showDebugInfo("dateMax validate "+this.value+" "+this.maxDate)
					if (value.getTime() > this.maxDate.getTime()) {
						isValid = false;
						this.messageInfoVO = MessageInfoType.MAX_DATE_ERROR;
						this.messageInfoVO.args = [CommonUtils.getFormattedDate(this.maxDate)];
					}
				}
			} 
			} catch (error:Error) {
				CommonUtils.showExceptionInfo(error);
			}
			return isValid;
		}
		
		protected function datePairValidation(value:Date):Boolean {
			var isValid:Boolean = true;
			
			if (this.datePair != null) {
				if (this.messageInfoVO == null && datePair.messageInfoVO == null && value != null && datePair.value != null) {
					if (this.datePairType == DATE_PAIR_FROM) {
						if (value.getTime() < datePair.value.getTime()) {
							isValid = false;
							this.messageInfoVO = MessageInfoType.MIN_DATE_ERROR;
							this.messageInfoVO.args = [CommonUtils.getFormattedDate(datePair.value)];
						}
					} else if (this.datePairType == DATE_PAIR_TO) {
						if (value.getTime() > datePair.value.getTime()) {
							isValid = false;
							this.messageInfoVO = MessageInfoType.MAX_DATE_ERROR;
							this.messageInfoVO.args = [CommonUtils.getFormattedDate(datePair.value)];
						}
					}
				}
			}
			return isValid;
		}
	}
}