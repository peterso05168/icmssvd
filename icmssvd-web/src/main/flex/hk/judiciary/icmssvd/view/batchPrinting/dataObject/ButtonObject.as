package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	import hk.judiciary.fmk.view.component.Button;

	public class ButtonObject extends FieldObject
	{
		private var _maxWidthException:Boolean = false;
		[Bindable]
		public function get maxWidthException():Boolean { return this._maxWidthException; }
		public function set maxWidthException(value:Boolean):void {
			this._maxWidthException = value;
			
			widthUIControl();
		}
		
		public function ButtonObject()
		{
			
		}
		
		override public function set viewObject(value:Object):void
		{
			// TODO Auto Generated method stub
			super.viewObject = value;
			
			widthUIControl();
		}
		
		private function widthUIControl():void {
			if (viewObject is Button) {
				Button(viewObject).minWidth = 70;
				if (!maxWidthException) {
					Button(viewObject).maxWidth = 240;
				} else {
					Button(viewObject).maxWidth = 0;
				}
			}
		}
	}
}