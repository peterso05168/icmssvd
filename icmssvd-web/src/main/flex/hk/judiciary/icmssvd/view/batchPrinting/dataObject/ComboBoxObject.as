package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.batchPrinting.component.CommonUtils;
	import hk.judiciary.icmssvd.view.batchPrinting.vo.ComboBoxDataGridHeaderVO;
	
	public class ComboBoxObject extends FieldObject
	{
		public function ComboBoxObject()
		{
			super();
		}
		
		private var _pickListScrollBarWidth:int = 18;
		
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
		
		private var _dataProvider:ArrayCollection;
		[Bindable]
		public function get dataProvider():ArrayCollection {
			return this._dataProvider;
		}
		public function set dataProvider(value:ArrayCollection):void {
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
		
		[ArrayTypeElement ("hk.judiciary.icms.view.shared.vo.ComboBoxDataGridHeaderVO")]
		private var _dataGridHeader:ArrayCollection = new ArrayCollection();
		[Bindable]
		public function get dataGridHeader():ArrayCollection { return _dataGridHeader; }
		public function set dataGridHeader(value:ArrayCollection):void { this._dataGridHeader = value; }
		
		public function addDataGridHeaderSetting(value:ComboBoxDataGridHeaderVO):void {
			var vo:Object = new Object();
			vo.attr = value.attr;
			vo.setting = new Array();
			vo.setting["title"] = value.title;
			vo.setting["width"] = CommonUtils.convertNumberToString(value.width + this._pickListScrollBarWidth);
			
			dataGridHeader.addItem(vo);
		}
		
		private var _textInput:String;
		[Bindable]
		public function get textInput():String { return _textInput; }
		public function set textInput(value:String):void { this._textInput = value; }
	}
}