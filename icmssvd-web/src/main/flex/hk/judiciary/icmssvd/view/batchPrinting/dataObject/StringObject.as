package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	public class StringObject extends FieldObject
	{
		public function StringObject()
		{
			super();
			value = "";
		}
		
		[Bindable]
		public function get value():String {
			if (super.getValue() == null) {
				return "";
			} else {
				return super.getValue() as String;
			}
		}
		public function set value(value:String):void {
			if (value == "") {
				super.setValue(null);	
			} else {
				super.setValue(value as String);
			}
		}
		private var _maxLength:int = 0;
		[Bindable]
		public function get maxLength():int { return this._maxLength; }
		public function set maxLength(value:int):void { this._maxLength = value; }
	}
}