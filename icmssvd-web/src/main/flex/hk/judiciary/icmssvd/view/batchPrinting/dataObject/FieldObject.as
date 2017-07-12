package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	import mx.collections.ArrayCollection;
	import mx.core.UIComponent;
	import mx.validators.EmailValidator;
	import mx.validators.ValidationResult;
	
	import spark.components.supportClasses.SkinnableComponent;
	
	import hk.judiciary.fmk.view.component.TextArea;
	import hk.judiciary.fmk.view.component.TextInput;
	import hk.judiciary.icmssvd.view.batchPrinting.component.CommonUtils;
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.MessageInfoType;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.ErrorMessageInfoVO;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.MessageInfoVO;

	public class FieldObject
	{
		// Standard Error Tooltip
		//protected var tooltipFieldIsRequired:String = "Field is required";
		//protected var tooltipFormatIsInvalid:String = "Format is invalid";
		
		// Special Tag
		public static var EMAIL_VALUE_FORMAT:String="[EMAIL_FORMAT]";
		
		public function FieldObject()
		{
		}
		
		private var _prevValue:Object = null;
		protected function getPrevValue():Object { return _prevValue; }
		protected function setPrevValue(value:Object):void { this._prevValue = value; }
		private var _value:Object = null;
		protected function getValue():Object { return _value; }
		protected function setValue(value:Object):void { this._value = value; }
		
		private var _tabIndex:int = 99;
		[Bindable]
		public function get tabIndex():int { return _tabIndex; }
		public function set tabIndex(value:int):void { _tabIndex = value; }
		
		private var _width:int = 50;
		[Bindable]
		public function get width():int { return _width; }
		public function set width(value:int):void { this._width = value; }
		
		private var _enable:Boolean = true;
		[Bindable]
		public function get enable():Boolean { return _enable; }
		public function set enable(value:Boolean):void { this._enable = value; }
	
		private var _editable:Boolean = true;
		[Bindable]
		public function get editable():Boolean { return _editable; }
		public function set editable(value:Boolean):void { 
			this._editable = value;
			editableUIControl();
		}
		
		private var _visible:Boolean = true;
		[Bindable]
		public function get visible():Boolean { return _visible; }
		public function set visible(value:Boolean):void { this._visible = value; }
		
		private var _required:Boolean = false;
		[Bindable]
		public function get required():Boolean { return _required; }
		public function set required(value:Boolean):void { this._required = value; }
		
		private var _inputFormat:String = null;
		[Bindable]
		public function get inputFormat():String { return _inputFormat; }
		public function set inputFormat(value:String):void { this._inputFormat = value; }
		
		private var _valueFormat:String = "";
		[Bindable]
		public function get valueFormat():String { return _valueFormat; }
		public function set valueFormat(value:String):void { this._valueFormat = value; }
		
//		private var _uiComponent:UIComponent = null;
//		[Bindable]
//		public function get uiComponent():UIComponent { return this._uiComponent; }
//		public function set uiComponent(value:UIComponent):void { this._uiComponent = value; }
//		private var _skinnableComponent:SkinnableComponent = null;
//		[Bindable]
//		public function get skinnableComponent():SkinnableComponent { return this._skinnableComponent; }
//		public function set skinnableComponent(value:SkinnableComponent):void { this._skinnableComponent = value; }
		private var _viewObject:Object = null;
		[Bindable]
		public function get viewObject():Object { return this._viewObject; }
		public function set viewObject(value:Object):void { 
			this._viewObject = value; 
			editableUIControl();
		}
		
		private var _messageInfoVO:MessageInfoVO=null;
		[Bindable]
		public function get messageInfoVO():MessageInfoVO { return this._messageInfoVO; }
		public function set messageInfoVO(value:MessageInfoVO):void { this._messageInfoVO = value; }
		
		private var _fieldLabel:String="";
		[Bindable]
		public function get fieldLabel():String { return this._fieldLabel; }
		public function set fieldLabel(value:String):void { this._fieldLabel = value; }

		private var _fmkErrorCodes:ArrayCollection;
		[Bindable]
		public function get fmkErrorCodes():ArrayCollection { return _fmkErrorCodes; }
		public function set fmkErrorCodes(value:ArrayCollection):void { _fmkErrorCodes = value; }
		
		private function editableUIControl():void {
			var bgColor:String = "0xFFFFFF";
			if (!this.editable) {
				bgColor = "0xD6D8DF";
			}
			
			if (this.viewObject != null) {
				if (this.viewObject is TextInput) {
					TextInput(this.viewObject).setStyle("contentBackgroundColor", bgColor);
				} else if (this.viewObject is TextArea) {
					TextArea(this.viewObject).setStyle("contentBackgroundColor", bgColor);
				}
			}
		}
		
		public function clearInvalid():void {
			this.messageInfoVO = null;
			/*
			if (this.skinnableComponent != null) {
				this.skinnableComponent.errorString = "";
			}
			*/
			if (this.viewObject != null) {
				if (this.viewObject is SkinnableComponent) {
					SkinnableComponent(this.viewObject).errorString = "";
				} else if (this.viewObject is UIComponent) {
					UIComponent(this.viewObject).errorString = "";
				}
			}
		}
		
		protected function isViewObjectVisible():Boolean {
			var isVisible:Boolean = true;
			
			if (this.viewObject != null) {
				if (this.viewObject is SkinnableComponent) {
					isVisible = SkinnableComponent(this.viewObject).visible;
				} else if (this.viewObject is UIComponent) {
					isVisible = UIComponent(this.viewObject).visible;
				}
			}
			
			return isVisible;
		}
		
		public function validate(silenceValidate:Boolean = false):Boolean {
			var isValid:Boolean = true;
			if (!silenceValidate) {
				clearInvalid();
			}
				
			/*
			if (this._required && this._value == null) {
				isValid = false;
				this.messageInfoVO = MessageInfoType.FIELD_IS_REQUIRED; 
			}
			*/
			if (isValid) {
				isValid = requiredValidation(_value);
			}
			if (isValid) {
				isValid = valueFormatValidation(_value);
			}
			
			/*
			if (this.skinnableComponent != null && this.messageInfoVO != null) {
				this.skinnableComponent.errorString = this.messageInfoVO.tooltipMsg;
			}
			*/
			if (!silenceValidate) {
				showErrorTooltip(getErrorTooltip());
			}
			return isValid;
		}
		
		public function showErrorTooltip(errorTooltip:String):void {
			if (this.viewObject != null && this.messageInfoVO != null) {
				if (this.viewObject is SkinnableComponent) {
					SkinnableComponent(this.viewObject).errorString = errorTooltip;//this.messageInfoVO.getAmendedTooltip();
				} else if (this.viewObject is UIComponent) {
					UIComponent(this.viewObject).errorString = errorTooltip;//this.messageInfoVO.getAmendedTooltip();
				}
			}
		}
		
		public function getErrorTooltip():String {
			if (this.messageInfoVO != null) {
				return this.messageInfoVO.getAmendedTooltip();
			} else {
				return "";
			}
		}
		
		protected function valueFormatValidation(value:Object):Boolean {
			var isValid:Boolean = true;
			
			if (isViewObjectVisible() && !CommonUtils.isEmptyString(this._valueFormat) && value != null) {
				if (this._valueFormat == EMAIL_VALUE_FORMAT) {
					CommonUtils.showDebugInfo("valueFormatValidation - Email");
					
					var emailValidator:EmailValidator = new EmailValidator();
					var results:Array = EmailValidator.validateEmail(emailValidator, value, "text"); 
					if (results.length > 0) {
						isValid = false;
						this.messageInfoVO = MessageInfoType.FORMAT_IS_INVALID;
						
						var result:ValidationResult = results[0] as ValidationResult;
						CommonUtils.showDebugInfo("Email Result "+isValid+" "+result.errorCode+" "+result.errorMessage);
					}
				} else {
					// REG EXP
					var regExp:RegExp = new RegExp(this._valueFormat, null);
					if (value != null) {
						var valueStr:String = value as String;
						//CommonUtils.showDebugInfo("regExt "+this._valueFormat+" valueStr "+valueStr+" result "+regExp.test(valueStr));
						if (!regExp.test(valueStr)) {
							isValid = false;
							this.messageInfoVO = MessageInfoType.FORMAT_IS_INVALID;
						}
					}
				}
			}
			
			return isValid;
		}
		
		protected function requiredValidation(value:Object):Boolean {
			var isValid:Boolean = true;
			
			if (isViewObjectVisible() && this._required && this._value == null) {
				isValid = false;
				this.messageInfoVO = MessageInfoType.FIELD_IS_REQUIRED; 
			}
			
			return isValid;
		}
		
		public function getErrorMessageInfo():ErrorMessageInfoVO {
			var errorMessageInfoVO:ErrorMessageInfoVO = new ErrorMessageInfoVO();
			errorMessageInfoVO.fieldName = this.fieldLabel;
			errorMessageInfoVO.messageInfoType = this.messageInfoVO;
			return errorMessageInfoVO;
		}
		
		public function focusInEvent():void {
			this._prevValue = this._value;
		}
	}
}