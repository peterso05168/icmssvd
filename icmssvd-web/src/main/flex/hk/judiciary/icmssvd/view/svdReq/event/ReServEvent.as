package hk.judiciary.icmssvd.view.svdReq.event
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.svdReq.vo.BatchSearchVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.CertifcateBulkPostingVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;

	public class ReServEvent extends Event
	{
		public function ReServEvent(type:String)
		{
			super(type);
		}
		
		private var _functionVO:FunctionVO;
		private var _batchSearchVO:BatchSearchVO;
		private var _selecteResultVOs:ArrayCollection = new ArrayCollection;
		
		public function get functionVO():FunctionVO
		{
			return this._functionVO;
		}
		
		public function get batchSearchVO():BatchSearchVO
		{
			return this._batchSearchVO;
		}
		
		public function get selecteResultVOs():ArrayCollection
		{
			return this._selecteResultVOs;
		}
		
		
		public static function initSearchParams(func:FunctionVO):ReServEvent
		{
			var evt:ReServEvent=new ReServEvent("initSearchParams");
			evt._functionVO = func;
			return evt;
		}
		
		public static function searchAbsentDefenantsList(searchVO:BatchSearchVO):ReServEvent
		{
			var evt:ReServEvent=new ReServEvent("searchAbsentDefenantsList");
			evt._batchSearchVO = searchVO;
			return evt;
		}
		
		public static function confirmHearingSchedule(resultVOs:ArrayCollection):ReServEvent
		{
			var evt:ReServEvent=new ReServEvent("confirmHearingSchedule");
			evt._selecteResultVOs = resultVOs;
			return evt;
		}
		
		public static function reGenDefHrnDate(resultVOs:ArrayCollection):ReServEvent
		{
			var evt:ReServEvent=new ReServEvent("reGenDefHrnDate");
			evt._selecteResultVOs = resultVOs;
			return evt;
		}
		
		public static function clearEquireReServResultEvent():ReServEvent
		{
			var evt:ReServEvent = new ReServEvent("clearEquireReServResult");
			return evt;
		}
		
		private var _maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
		
		public function get maintainRequestVO():MaintainRequestVO { return _maintainRequestVO; } 
		
		public static function createMaintainRequestEvent(maintainRequestVO:MaintainRequestVO):ReServEvent {
			var evt:ReServEvent = new ReServEvent("maintainRequest");
			evt._maintainRequestVO = maintainRequestVO;
			return evt;
		}
		
		private var _certifcateBulkPostingVO:CertifcateBulkPostingVO;
		
		public function get certifcateBulkPostingVO():CertifcateBulkPostingVO { return _certifcateBulkPostingVO; } 
		
		public static function generateCertificateBulkPosting(postingVO:CertifcateBulkPostingVO):ReServEvent {
			var evt:ReServEvent = new ReServEvent("generateCertificateBulkPosting");
			evt._certifcateBulkPostingVO = postingVO;
			return evt;
		}

		public static function saveDraftAndGenDocEvent(resultVOs:ArrayCollection):ReServEvent{
			var evt:ReServEvent = new ReServEvent("saveDraftAndGenDoc");
			evt._selecteResultVOs = resultVOs;
			return evt;
		}
		
		public static function saveDraftReserviceRequest(resultVOs:ArrayCollection):ReServEvent{
			var evt:ReServEvent = new ReServEvent("saveDraftReserviceRequest");
			evt._selecteResultVOs = resultVOs;
			return evt;
		}
		
		public static function submitReserviceRequest(resultVOs:ArrayCollection):ReServEvent{
			var evt:ReServEvent = new ReServEvent("submitReserviceRequest");
			evt._selecteResultVOs = resultVOs;
			return evt;
		}
	}
}