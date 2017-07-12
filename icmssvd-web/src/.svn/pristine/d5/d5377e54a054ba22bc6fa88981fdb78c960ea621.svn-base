package hk.judiciary.icmssvd.view.batchPrinting.component
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.dataObject.BDDObject;
	import hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.dataObject.BooleanObject;
	import hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.dataObject.ComboBoxObject;
	import hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.dataObject.DateObject;
	import hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.dataObject.GridObject;
	import hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.dataObject.ObjectObject;
	import hk.judiciary.icmscdy.view.courtdiary.presentation.courtdiary.mc.dataObject.StringObject;
	import hk.judiciary.icmscdy.view.courtdiary.vo.courtdiary.mc.ErrorMessageInfoVO;

	public class CommonGridUI extends CommonUI
	{
		public function CommonGridUI()
		{
			
		}
		
		private var _defaultGridPaddingTop:int=0;
		private var _defaultGridPaddingBottom:int=0;
		private var _defaultGridTextAlign:String="left";
		private var _defaultGridVerticalAlign:String="top";
		private var _defaultGridHeaderHeight:int=30;
		
		private var _defaultGridWordWrap:String="true";
		private var _defaultGridSortable:String="true";
		private var _defaultGridDraggable:String="false";
		private var _defaultGridResizable:String="false";
		private var _defaultGridHeaderWordWrap:String="true";
		private var _defaultGridHeaderVerticalAlignment:String="centre";
		private var _defaultGridDoubleClickEnable:String="false";
		
		private var _defaultGridCellLeftPadding:int=5;
		private var _defaultGridCellLabelTopPadding:int=5;
		private var _defaultGridCellLabelLeftPadding:int=5;
		private var _defaultGridCellLinkButtonLeftPadding:int=2;

		public function get defaultGridPaddingTop():int {
			return this._defaultGridPaddingTop;
		}
		public function get defaultGridPaddingBottom():int {
			return this._defaultGridPaddingBottom;
		}
		public function get defaultGridTextAlign():String {
			return this._defaultGridTextAlign;
		}
		public function get defaultGridVerticalAlign():String {
			return this._defaultGridVerticalAlign;
		}
		public function get defaultGridHeaderHeight():int {
			return this._defaultGridHeaderHeight;
		}
		
		public function get defaultGridWordWrap():String { return this._defaultGridWordWrap; }
		public function get defaultGridSortable():String { return this._defaultGridSortable; }
		public function get defaultGridDraggable():String { return this._defaultGridDraggable; }
		public function get defaultGridResizeable():String { return this._defaultGridResizable; }
		public function get defaultGridHeaderWordWrap():String { return this._defaultGridHeaderWordWrap; }
		public function get defaultGridHeaderVerticalAlignment():String { return this._defaultGridHeaderVerticalAlignment; }
		public function get defaultGridDoubleClickEnable():String { return this._defaultGridDoubleClickEnable; }
		
		public function get defaultGridCellLeftPadding():int {
			return this._defaultGridCellLeftPadding;
		}
		public function get defaultGridCellLabelTopPadding():int {
			return this._defaultGridCellLabelTopPadding;
		}
		public function get defaultGridCellLabelLeftPadding():int {
			return this._defaultGridCellLabelLeftPadding;
		}
		public function get defaultGridCellLinkButtonLeftPadding():int {
			return this._defaultGridCellLinkButtonLeftPadding;
		}
		
		private var _gridPanelMaxWidth:int;
		[Bindable]
		public function get gridPanelMaxWidth():int { return this._gridPanelMaxWidth; }
		public function set gridPanelMaxWidth(value:int):void { this._gridPanelMaxWidth = value; }
		private var _pageSize:int = 10;
		[Bindable]
		public function get pageSize():int { return this._pageSize; }
		public function set pageSize(value:int):void { this._pageSize = value; }
		[Bindable]
		public var paginationTotalRow:int=0;
		
		/*[Bindable]
		public var pagnateController:PagnateControls;*/
		[Bindable]
		public var pagingControllerPanel:PagingControllerPanel;
		
		protected var _gridColumns:ArrayCollection;
		
		protected function recalculateColumnWidth():void {
			var remainingWidth:int = gridPanelMaxWidth;
			
			var gridObject:GridObject;
			
			var log:String = "remainingWidth:"+remainingWidth+"\n";
			
			// calculate remaining width
			for (var i:int=0; i<_gridColumns.length; i++) {
				gridObject = _gridColumns.getItemAt(i) as GridObject;
				
				if (gridObject.visible && (gridObject.minWidth > 0 || gridObject.width > 0)) {
					remainingWidth -= gridObject.width;
				}
				
				log += "["+i+"] visible:"+gridObject.visible+" remainingWidth:"+remainingWidth+"\n";
			}
			//this.showDebugInfo(log);
			
			// calculate width by ratio
			for (var j:int=0; j<_gridColumns.length; j++) {
				gridObject = _gridColumns.getItemAt(j) as GridObject;
				
				if (remainingWidth > 0 && gridObject.visible && gridObject.widthRatio > 0 && gridObject.widthRatio <= 1) {
					gridObject.width = remainingWidth * gridObject.widthRatio;
				}
			}
		}
		
		protected var gridFields:ArrayCollection = new ArrayCollection();
		public var gridErrorMessageInfos:ArrayCollection;
		protected function addGridField(field:Object):void {
			this.gridFields.addItem(field);
		}
		protected function resetGridValidationData():void {
			gridErrorMessageInfos = new ArrayCollection();
		}
		protected function addGridErrorMessageInfo(errorMessageInfo:ErrorMessageInfoVO):void {
			for (var i:int=0; i<gridErrorMessageInfos.length; i++) {
				var vo:ErrorMessageInfoVO = gridErrorMessageInfos.getItemAt(i) as ErrorMessageInfoVO;
				if (vo.fieldName == errorMessageInfo.fieldName && vo.messageInfoType.priority <= errorMessageInfo.messageInfoType.priority) {
					return ;
				} else if (vo.fieldName == errorMessageInfo.fieldName && vo.messageInfoType.priority > errorMessageInfo.messageInfoType.priority) {
					gridErrorMessageInfos.removeItemAt(i);
					gridErrorMessageInfos.addItemAt(errorMessageInfo, i);
				}
			}
			gridErrorMessageInfos.addItem(errorMessageInfo);
		}
		protected function getGridErrorTooltip():String {
			var vo:ErrorMessageInfoVO;
			var i:int;
			var tooltip:String = "";
			for (i=0; i<gridErrorMessageInfos.length; i++) {
				vo = gridErrorMessageInfos.getItemAt(i) as ErrorMessageInfoVO;
				if (i == 0) {
					tooltip = vo.getFormattedBoxMessage()
				} else {
					tooltip += "\n" + vo.getFormattedBoxMessage();
				}
			}
			return tooltip;
		}
		protected function gridFieldProceedValidate(silenceValidate:Boolean = false):Boolean {
			var validationResult:Boolean = true;
			
			var i:int;
			var stringObject:StringObject;
			var dateObject:DateObject;
			var booleanObject:BooleanObject;
			var bDDObject:BDDObject;
			var comboBoxObject:ComboBoxObject;
			var objectObject:ObjectObject;
			
			for (i=0; i<gridFields.length; i++) {
				if (gridFields.getItemAt(i) is StringObject) {
					stringObject = gridFields.getItemAt(i) as StringObject;
					if (!stringObject.validate(silenceValidate)) {
						addGridErrorMessageInfo(stringObject.getErrorMessageInfo());
						validationResult = false;
					}
				} else if (gridFields.getItemAt(i) is DateObject) {
					dateObject = gridFields.getItemAt(i) as DateObject;
					if (!dateObject.validate(silenceValidate)) {
						addGridErrorMessageInfo(dateObject.getErrorMessageInfo());
						validationResult = false;
					}
				} else if (gridFields.getItemAt(i) is BDDObject) {
					bDDObject = gridFields.getItemAt(i) as BDDObject;
					if (!bDDObject.validate(silenceValidate)) {
						addGridErrorMessageInfo(bDDObject.getErrorMessageInfo());
						validationResult = false;
					}
				} else if (gridFields.getItemAt(i) is ComboBoxObject) {
					comboBoxObject = gridFields.getItemAt(i) as ComboBoxObject;
					if (!comboBoxObject.validate(silenceValidate)) {
						addGridErrorMessageInfo(comboBoxObject.getErrorMessageInfo());
						validationResult = false;
					}
				} else if (gridFields.getItemAt(i) is BooleanObject) {
					booleanObject = gridFields.getItemAt(i) as BooleanObject;
					if (!booleanObject.validate(silenceValidate)) {
						addGridErrorMessageInfo(booleanObject.getErrorMessageInfo());
						validationResult = false;
					}
				} else if (gridFields.getItemAt(i) is ObjectObject) {
					objectObject = gridFields.getItemAt(i) as ObjectObject;
					if (!objectObject.validate(silenceValidate)) {
						addGridErrorMessageInfo(objectObject.getErrorMessageInfo());
						validationResult = false;
					}
				}
			}
			return validationResult;
		}
		/*
		public function updatePagingControl(value:int, pagingInitiated:Boolean):void {
			if (this.pagnateController != null) {
				if (value != 0) {
					this.pagnateController.totalNoOfPage = Math.round(Math.ceil(value/pageSize));
				}
				if (!pagingInitiated) {
					this.pagnateController.currPageNum = 1;
				}
			}
		}
		public function setPagnateControllerListener():void {
			if (this.pagnateController != null) {
				this.pagnateController.removeEventListener("next", pageUpdate);
				this.pagnateController.removeEventListener("prev", pageUpdate);
				this.pagnateController.removeEventListener("first", pageUpdate);
				this.pagnateController.removeEventListener("last", pageUpdate);
				this.pagnateController.removeEventListener("goto", pageUpdate);
				this.pagnateController.addEventListener("next", pageUpdate);
				this.pagnateController.addEventListener("prev", pageUpdate);
				this.pagnateController.addEventListener("first", pageUpdate);
				this.pagnateController.addEventListener("last", pageUpdate);
				this.pagnateController.addEventListener("goto", pageUpdate);
			}
		}
		private function pageUpdate(event:PaginateEvent):void {
			this.showDebugInfo("pageUpdate ");
			this.pagnateController.doPagination(pageSize);
		}
		public function setPagnateControllerListenerDyn(pageUpdate:Function):void {
			if (this.pagnateController != null) {
				this.pagnateController.removeEventListener("next", pageUpdate);
				this.pagnateController.removeEventListener("prev", pageUpdate);
				this.pagnateController.removeEventListener("first", pageUpdate);
				this.pagnateController.removeEventListener("last", pageUpdate);
				this.pagnateController.removeEventListener("goto", pageUpdate);
				this.pagnateController.addEventListener("next", pageUpdate);
				this.pagnateController.addEventListener("prev", pageUpdate);
				this.pagnateController.addEventListener("first", pageUpdate);
				this.pagnateController.addEventListener("last", pageUpdate);
				this.pagnateController.addEventListener("goto", pageUpdate);
			}
		}
		*/
	}
}