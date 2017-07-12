package hk.judiciary.icmssvd.view.batchPrinting.presentation.cspuCentralPrinting
{
	import hk.judiciary.icmssvd.view.batchPrinting.component.CommonPresentor;
	import hk.judiciary.icmssvd.view.batchPrinting.event.cspuCentralPrinting.CspuCentralPrintingModuleEvent;
	
	import org.granite.tide.events.TideResultEvent;

	public class CspuCentralPrintingModulePresentor extends CommonPresentor
	{
		public function CspuCentralPrintingModulePresentor()
		{
		}
		
		/** CSPU_CENTRAL_PRINTING_MODULE **/
		[MessageHandler(selector="cspuCentralPrintingModuleTestPrintReport", scope="local")]
		public function cspuCentralPrintingModuleTestPrintReportHandler(event:CspuCentralPrintingModuleEvent):void {
			contextController.context.snGenerationService.cspuCentralPrintingModuleTestPrintReport(event.caseNo, cspuCentralPrintingModuleTestPrintReportResultHandler, faultHandler);
		}
		public function cspuCentralPrintingModuleTestPrintReportResultHandler(event:TideResultEvent):void {
			var results:Object = event.result;
		}
	}
}