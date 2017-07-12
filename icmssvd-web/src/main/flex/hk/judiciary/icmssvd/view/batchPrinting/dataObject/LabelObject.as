package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	import spark.components.supportClasses.TextBase;
	
	import hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.component.CommonUI;

	public class LabelObject extends FieldObject
	{
		public function LabelObject()
		{
			super();
			this.width = 1;
		}
		
		private var _sourceViewObject:Object = null;
		[Bindable]
		public function get sourceViewObject():Object { return this._sourceViewObject; }
		public function set sourceViewObject(value:Object):void { this._sourceViewObject = value; }
		
		private var _suffixViewObject:Object = null;
		[Bindable]
		public function get suffixViewObject():Object { return this._suffixViewObject; }
		public function set suffixViewObject(value:Object):void { this._suffixViewObject = value; } 
		
		[ArrayElementType ("hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.FieldObject")]
		private var _valueObjects:Array = null;
		[Bindable]
		public function get valueObjects():Array { return this._valueObjects; }
		public function set valueObjects(value:Array):void { this._valueObjects = value; }
		
		private var _colonEnable:Boolean = true;
		[Bindable]
		public function get colonEnable():Boolean { return this._colonEnable; }
		public function set colonEnable(value:Boolean):void { this._colonEnable = value; }
		
		public function setProperties(viewObject:Object, sourceObject:Object, valueObject:FieldObject):void {
			this.viewObject = viewObject;
			this.sourceViewObject = sourceObject;
			if (valueObject != null) {
				this.valueObjects = [valueObject];
			} else {
				this.valueObjects = null;
			}
		}
		
		public function setPropertiesMultiValue(viewObject:Object, sourceObject:Object, valueObjects:Array):void {
			this.viewObject = viewObject;
			this.sourceViewObject = sourceObject;
			this.valueObjects = valueObjects;
		}
			
		public function redraw():void {
			if (this.sourceViewObject != null && this.viewObject != null) {
				var newLabelText:String = TextBase(this.sourceViewObject).text;
				
				var requiredProperty:Boolean = false;
				if (valueObjects != null) {
					for (var i:int=0; i<valueObjects.length; i++) {
						if (FieldObject(valueObjects[i]).required) {
							requiredProperty = true;
							break;
						}
					}
				}
				
				if (CommonUI.mandatorySymbolEnable && requiredProperty) {
					newLabelText += " *";
				}
				if (this.suffixViewObject != null) {
					var suffixLabelText:String = TextBase(this.suffixViewObject).text;
					newLabelText += " "+suffixLabelText;
				}
				if (CommonUI.colonEnable && this.colonEnable) {
					newLabelText += " :";
				}
				
				TextBase(this.viewObject).text = newLabelText;
			}
		}
		
		public function getLabelText():String {
			return TextBase(this.viewObject).text;
		}
	}
}