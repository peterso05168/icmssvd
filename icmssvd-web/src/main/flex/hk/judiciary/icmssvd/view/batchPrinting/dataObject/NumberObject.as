package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{

	public class NumberObject extends StringObject
	{
		public function NumberObject()
		{
			super();
			inputFormat = "0-9";
			zeroEnable = true;
		}
		
		private var _zeroEnable:Boolean = true;
		[Bindable]
		public function get zeroEnable():Boolean { return _zeroEnable; }
		public function set zeroEnable(value:Boolean):void {
			_zeroEnable = value;
			if (value) {
				valueFormat = "^[0-9]+$";
			} else {
				valueFormat = "^[1-9]+[0-9]*$";
			}
		}
		
		[Bindable]
		public var textAlign:String = "right";
		[Bindable]
		public var textAlignLast:String = "left";
	}
}