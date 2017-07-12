package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	import mx.collections.IList;

	public class BDDObject extends FieldObject
	{
		public function BDDObject()
		{
			super();
			value = null;
		}
		
		[Bindable]
		public function get value():Object {
			return super.getValue();
		}
		public function set value(value:Object):void {
			if (value == null) {
				this.selectedIndex = -1;
			} else {
				this.selectedIndex = this._dataProvider.getItemIndex(value);
			}
			return super.setValue(value);
		}
		[Bindable]
		public function get prevValue():Object {
			return super.getPrevValue();
		}
		public function set prevValue(value:Object):void {
			return super.setPrevValue(value);	
		}
		
		private var _dataProvider:IList;
		[Bindable]
		public function get dataProvider():IList {
			return this._dataProvider;
		}
		public function set dataProvider(value:IList):void {
			this._dataProvider = value;
		}
		
		private var _labelField:String;
		[Bindable]
		public function get labelField():String {
			return this._labelField;
		}
		public function set labelField(value:String):void {
			this._labelField = value;
		}
		
		private var _selectedIndex:int=-1;
		[Bindable]
		public function get selectedIndex():int {
			return this._selectedIndex;
		}
		public function set selectedIndex(value:int):void {
			this._selectedIndex = value;
		}
	}
}