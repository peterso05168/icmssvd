package hk.judiciary.icmssvd.view.batchPrinting.event.cspuCentralPrinting
{
	import flash.events.Event;

	public class CspuCentralPrintingModuleEvent extends Event
	{
		public function CspuCentralPrintingModuleEvent(type:String)
		{
			super(type);
		}
		
		public static var EVENT_PREFIX:String = "cspuCentralPrintingModule"; 
		public static var EVENT_TEST_PRINT_REPORT_NAME:String = EVENT_PREFIX+"TestPrintReport";
		
		public var caseNo:String;
		
		public static function createTestPrintReportEvent(caseNo:String):CspuCentralPrintingModuleEvent {
			var evt:CspuCentralPrintingModuleEvent = new CspuCentralPrintingModuleEvent(EVENT_TEST_PRINT_REPORT_NAME);
			evt.caseNo = caseNo;
			return evt;
		}

	}
}