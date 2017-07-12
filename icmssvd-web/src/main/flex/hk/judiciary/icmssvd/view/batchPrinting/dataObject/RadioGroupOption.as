package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	public class RadioGroupOption extends ObjectObject
	{
		public function RadioGroupOption(){
		}
		/*
		private var _tabIndex:int;
		[Bindable]
		public function get tabIndex():int { return this._tabIndex; }
		public function set tabIndex(value:int):void { this._tabIndex = value; }
		
		private var _value:Object;
		[Bindable]
		public function get value():Object { return this._value; }
		public function set value(value:Object):void { this._value = value; }
		*/
		private var _desc:String;
		[Bindable]
		public function get desc():String { return this._desc; }
		public function set desc(value:String):void { this._desc = value; }
	}
}