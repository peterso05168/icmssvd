package hk.judiciary.icmssvd.view.batchPrinting.presentation.cspuCentralPrinting
{
	import flash.events.EventDispatcher;
	
	import mx.controls.Alert;
	
	import hk.judiciary.icmssvd.view.batchPrinting.component.CommonUtils;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.ButtonObject;
	import hk.judiciary.icmssvd.view.batchPrinting.dataObject.StringObject;
	import hk.judiciary.icmssvd.view.batchPrinting.event.cspuCentralPrinting.CspuCentralPrintingModuleEvent;

	[Event(name="cspuCentralPrintingModuleTestPrintReport", type="hk.judiciary.icmssvd.view.batchPrinting.event.cspuCentralPrinting.CspuCentralPrintingModuleEvent")]
	[ManagedEvents("cspuCentralPrintingModuleTestPrintReport", scope="local")]
	public class CspuCentralPrintingModulePM extends EventDispatcher
	{
		public function CspuCentralPrintingModulePM()
		{
		}
		
		/** Button **/
		[Bindable]
		public var btnDeptSummonsPS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnDopSummonsPS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpSummonsGenericPS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpSummonsPakingPS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpSummonsMovingPS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpSummonsAntiLitterPS:ButtonObject = new ButtonObject();
		
		[Bindable]
		public var btnDeptSummonsPRS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnDopSummonsPRS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpSummonsGenericPRS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpSummonsPakingPRS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpSummonsMovingPRS:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpSummonsAntiLitterPRS:ButtonObject = new ButtonObject();
		
		[Bindable]
		public var btnFpNoticeGeneric:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpNoticePaking:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpNoticeMoving:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnFpNoticeAntiLitter:ButtonObject = new ButtonObject();
		
		[Bindable]
		public var btnLessesOffenceReport:ButtonObject = new ButtonObject();
		[Bindable]
		public var btnXeroxPrintJobChecklist:ButtonObject = new ButtonObject();
		
		/** Variable **/
		[Bindable]
		public var viewStackIndex:int = 0;
		[Bindable]
		public var txtCaseNo:StringObject = new StringObject();
		
		
		private var _viewObject:CspuCentralPrintingModule;
		
		private function uiConfig():void {
			this.btnDeptSummonsPS.width = 300;
			this.btnDopSummonsPS.width = 300;
			this.btnFpSummonsGenericPS.width = 300;
			this.btnFpSummonsPakingPS.width = 300;
			this.btnFpSummonsMovingPS.width = 300;
			this.btnFpSummonsAntiLitterPS.width = 300;
			
			this.btnDeptSummonsPRS.width = 300;
			this.btnDopSummonsPRS.width = 300;
			this.btnFpSummonsGenericPRS.width = 300;
			this.btnFpSummonsPakingPRS.width = 300;
			this.btnFpSummonsMovingPRS.width = 300;
			this.btnFpSummonsAntiLitterPRS.width = 300;
			
			this.btnFpNoticeGeneric.width = 300;
			this.btnFpNoticePaking.width = 300;
			this.btnFpNoticeMoving.width = 300;
			this.btnFpNoticeAntiLitter.width = 300;
			
			this.btnLessesOffenceReport.width = 300;
			this.btnXeroxPrintJobChecklist.width = 300;
			
			this.txtCaseNo.width = 200;
		}
		
		private function propertyConfig():void {
			
		}
		
		private function labelConfig():void {
//			this.btnDeptSummonsPS.fieldLabel = this._viewObject.lblDepartmentalSummons.text;
//			this.btnDopSummonsPS.fieldLabel = this._viewObject.lblDOPSummons.text;
//			this.btnFpSummonsGenericPS.fieldLabel = this._viewObject.lblFpSummonsGeneric.text;
//			this.btnFpSummonsPakingPS.fieldLabel = this._viewObject.lblFpSummonsParking.text;
//			this.btnFpSummonsMovingPS.fieldLabel = this._viewObject.lblFpSummonsMoving.text;
//			this.btnFpSummonsAntiLitterPS.fieldLabel = this._viewObject.lblFpSummonsAntiLitter.text;
//			
//			this.btnDeptSummonsPRS.fieldLabel = this._viewObject.lblDepartmentalSummons.text;
//			this.btnDopSummonsPRS.fieldLabel = this._viewObject.lblDOPSummons.text;
//			this.btnFpSummonsGenericPRS.fieldLabel = this._viewObject.lblFpSummonsGeneric.text;
//			this.btnFpSummonsPakingPRS.fieldLabel = this._viewObject.lblFpSummonsParking.text;
//			this.btnFpSummonsMovingPRS.fieldLabel = this._viewObject.lblFpSummonsMoving.text;
//			this.btnFpSummonsAntiLitterPRS.fieldLabel = this._viewObject.lblFpSummonsAntiLitter.text;
//			
//			this.btnFpNoticeGeneric.fieldLabel = this._viewObject.lblFpNoticeGeneric.text;
//			this.btnFpNoticePaking.fieldLabel = this._viewObject.lblFpNoticeParking.text;
//			this.btnFpNoticeMoving.fieldLabel = this._viewObject.lblFpNoticeMoving.text;
//			this.btnFpNoticeAntiLitter.fieldLabel = this._viewObject.lblFpNoticeAntiLitter.text;
//			
//			this.btnLessesOffenceReport.fieldLabel = this._viewObject.lblLessesOffenceReport.text;
//			this.btnXeroxPrintJobChecklist.fieldLabel = this._viewObject.lblXeroxPrintJobChecklist.text;
		}
		
		public function init(viewObject:CspuCentralPrintingModule):void {
			this._viewObject = viewObject;
			
			uiConfig();
			propertyConfig();
			labelConfig();
			
//			this.screenPanelWidth = this._viewObject.parent.width;
//			this.screenPanelHeight = this._viewObject.parent.height;
			this._viewObject.invalidateDisplayList();
		}
		
		/** Action **/
		public function deptSummonsPSClickedEvent():void {
			
		}
		public function dopSummonsPSClickedEvent():void {
			
		}
		public function fpSummonsGenericPSClickedEvent():void {
			
		}
		public function fpSummonsParkingPSClickedEvent():void {
			
		}
		public function fpSummonsMovingPSClickedEvent():void {
			
		}
		public function fpSummonsAntiLitterPSClickedEvent():void {
			
		}
		
		public function textClickedEvent(obj:Object):void {
			dispatchEvent(CspuCentralPrintingModuleEvent.createTestPrintReportEvent(obj as String));
		}
		
		/** Handler **/
	}
}