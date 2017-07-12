package hk.judiciary.icmssvd.view.batchPrinting.component
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	
	import hk.judiciary.fmk.view.component.AlertMessageBox;
	import hk.judiciary.fmk.web.infrastructure.ContextController;
	
	import org.granite.tide.events.TideFaultEvent;

	public class CommonPresentor extends EventDispatcher
	{
		// Must be public
		[Inject]
		public var contextController:ContextController;
		
		protected function faultHandler(evt:TideFaultEvent):void {
			trace("############ error ######################");
			trace("faultDetail: " + evt.fault.faultDetail);
			trace("message: " + evt.fault.message);
			trace("content: " + evt.fault.content);
			trace("rootCause: " + evt.fault.rootCause);
			
			showErrorBox(evt);
		}
		
		protected function showErrorBox(evt:TideFaultEvent):void {
			/*
			var alertBox:AlertMessageBox =  AlertMessageBox(PopUpManager.createPopUp(FlexGlobals.topLevelApplication.document, AlertMessageBox, true));
			alertBox.showAlertBox("Error","Error Alert",evt.fault.faultDetail,"Error Message: " + evt.fault.message + " Error content: " + evt.fault.content + " Root Cause: " + evt.fault.rootCause, button1EventHandler, button2EventHandler);
			PopUpManager.centerPopUp(alertBox);
			*/
		}
		
		private function button1EventHandler(event:Event):void 
		{
			// Alert.show("yesevent From outside");
		}
		private function button2EventHandler(event:Event):void 
		{
			// Alert.show("noEvent From outside");
		}
		
		// Debug Only
		public function showDebugInfo(debugMsg:String):void {
			var alertBox:AlertMessageBox =  AlertMessageBox(PopUpManager.createPopUp(FlexGlobals.topLevelApplication.document, AlertMessageBox, true));
			alertBox.showAlertBox("Info","Info Alert", debugMsg,"Message: "+debugMsg, null, null);
			PopUpManager.centerPopUp(alertBox);
		}
	}
}