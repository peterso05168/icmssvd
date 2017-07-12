package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	import spark.components.supportClasses.TextBase;
	
	import hk.judiciary.fmk.view.component.AdvancedDataGridColumn;

	public class GridObject extends FieldObject
	{
		public function GridObject() {
			super();
			this.width = 0;
		}
		
/*		private var _visible:Boolean = true;
		[Bindable]
		public function get visible():Boolean { return this._visible; }
		public function set visible(value:Boolean):void { this._visible = value; }*/
		
		private var _minWidth:int = -1;
		[Bindable]
		public function get minWidth():int { return this._minWidth; }
		public function set minWidth(value:int):void {
			// 10 for left right padding
			this._minWidth = value + 10;
			this.width = value + 10;
		}
		
		private var _maxWidth:int = -1;
		[Bindable]
		public function get maxWidth():int { return this._maxWidth; }
		public function set maxWidth(value:int):void { this._maxWidth = value; }
		
		private var _autoExpand:Boolean = false;
		[Bindable]
		public function get autoExpand():Boolean { return this._autoExpand; }
		public function set autoExpand(value:Boolean):void { this._autoExpand = value; }
		
		private var _widthRatio:Number = -1;
		[Bindable]
		public function get widthRatio():Number { return this._widthRatio; }
		public function set widthRatio(value:Number):void { this._widthRatio = value; }
		
		private var _sourceViewObject:Object = null;
		[Bindable]
		public function get sourceViewObject():Object { return this._sourceViewObject; }
		public function set sourceViewObject(value:Object):void { this._sourceViewObject = value; }
		
		public function setHeaderTextProperties(viewObject:Object, sourceObject:Object):void {
			this.viewObject = viewObject;
			this.sourceViewObject = sourceObject;
		}
		
		public function redrawHeaderText():void {
			if (this.sourceViewObject != null && this.viewObject != null) {
				var newLabelText:String = TextBase(this.sourceViewObject).text;
				
				AdvancedDataGridColumn(this.viewObject).headerText = newLabelText;
			}
		}
	}
}