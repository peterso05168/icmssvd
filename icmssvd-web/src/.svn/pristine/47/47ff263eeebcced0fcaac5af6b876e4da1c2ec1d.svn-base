package hk.judiciary.icmssvd.view.svdReq.event
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.DocumentFileVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DocumentVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestSearchVO;

	public class SvdReqEvent extends Event
	{
		public function SvdReqEvent(type:String)
		{
			super(type);
		}
		
		private var _functionVO:FunctionVO;
		private var _serviceRequestSearchVO:ServiceRequestSearchVO;
		private var _requestIdDTOs:ArrayCollection = new ArrayCollection;
		
		public function get functionVO():FunctionVO
		{
			return this._functionVO;
		}
		
		public function get serviceRequestSearchVO():ServiceRequestSearchVO
		{
			return this._serviceRequestSearchVO;
		}
		
		public function get requestIdDTOs():ArrayCollection{ 
			return this._requestIdDTOs; 
		}
		
		
		public static function initSearchParams(func:FunctionVO):SvdReqEvent
		{
			var evt:SvdReqEvent=new SvdReqEvent("initSearchParams");
			evt._functionVO = func;
			return evt;
		}
		
		public static function searchServiceRequestList(searchVO:ServiceRequestSearchVO):SvdReqEvent
		{
			var evt:SvdReqEvent=new SvdReqEvent("searchServiceRequestList");
			evt._serviceRequestSearchVO = searchVO;
			return evt;
		}
		
		public static function completeServiceRequestList(ids:ArrayCollection):SvdReqEvent
		{
			var evt:SvdReqEvent=new SvdReqEvent("completeServiceRequestList");
			evt._requestIdDTOs = ids;
			return evt;
		}
		
		public static function initInputParams(detailVO:ServiceRequestDetailVO):SvdReqEvent
		{
			var evt:SvdReqEvent=new SvdReqEvent("initInputParams");
			evt._serviceRequestDetailVO = detailVO;
			evt._functionVO = detailVO.func;
			return evt;
		}
		
		public static function initResultParams(func:FunctionVO):SvdReqEvent
		{
			var evt:SvdReqEvent=new SvdReqEvent("initResultParams");
			evt._functionVO = func;
			return evt;
		}
		
		
		public static function clearEquireSvdReqResultEvent():SvdReqEvent
		{
			var evt:SvdReqEvent = new SvdReqEvent("clearEquireSvdReqResult");
			return evt;
		}
		
		private var _maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
		
		
		public function get maintainRequestVO():MaintainRequestVO { return _maintainRequestVO; } 
		
		private var _serviceRequestDetailVO:ServiceRequestDetailVO = new ServiceRequestDetailVO;
		
		public function get serviceRequestDetailVO():ServiceRequestDetailVO{ return this._serviceRequestDetailVO; }
		
		public static function createMaintainRequestEvent(maintainRequestVO:MaintainRequestVO):SvdReqEvent {
			var evt:SvdReqEvent = new SvdReqEvent("maintainRequest");
			evt._maintainRequestVO = maintainRequestVO;
			return evt;
		}
		
		public static function createOutMaintainRequestEvent(maintainRequestVO:MaintainRequestVO):SvdReqEvent {
			var evt:SvdReqEvent = new SvdReqEvent("outMaintainRequest");
			evt._maintainRequestVO = maintainRequestVO;
			return evt;
		}
		
		public static function createFormRequestEvent(detailVO:ServiceRequestDetailVO):SvdReqEvent {
			var evt:SvdReqEvent = new SvdReqEvent("formRequest");
			evt._serviceRequestDetailVO = detailVO;
			evt._functionVO = detailVO.func;
			return evt;
		}

		public static function saveDraftEvent(detailVO:ServiceRequestDetailVO):SvdReqEvent{
			var evt:SvdReqEvent = new SvdReqEvent("saveDraftServiceRequest");
			evt._serviceRequestDetailVO = detailVO;
			return evt;
		}
		
		public static function submitEvent(detailVO:ServiceRequestDetailVO):SvdReqEvent{
			var evt:SvdReqEvent = new SvdReqEvent("submitServiceRequest");
			evt._serviceRequestDetailVO = detailVO;
			return evt;
		}
		
		public static function withdrawEvent(detailVO:ServiceRequestDetailVO):SvdReqEvent{
			var evt:SvdReqEvent = new SvdReqEvent("withdrawServiceRequest");
			evt._serviceRequestDetailVO = detailVO;
			return evt;
		}
		
		public static function completeEvent(detailVO:ServiceRequestDetailVO):SvdReqEvent{
			var evt:SvdReqEvent = new SvdReqEvent("completeServiceRequest");
			evt._serviceRequestDetailVO = detailVO;
			return evt;
		}
		
		public static function previewDocumentsEvent(docFileVO:DocumentFileVO):SvdReqEvent {
			var evt:SvdReqEvent = new SvdReqEvent("previewDocuments");
			evt._documentFileVO = docFileVO;
			return evt;
		}
		
		public static function generateDocumentsEvent(detailVO:ServiceRequestDetailVO):SvdReqEvent {
			var evt:SvdReqEvent = new SvdReqEvent("generateDocuments");
			evt._serviceRequestDetailVO = detailVO;
			return evt;
		}

		private var _documentVO:DocumentVO = new DocumentVO;
		
		public function get documentVO():DocumentVO{ return this._documentVO; }
		
		public static function assignDrnEvent(doc:DocumentVO):SvdReqEvent{
			var evt:SvdReqEvent = new SvdReqEvent("assignDrn");
			evt._documentVO = doc;
			return evt;
		}
		
		public static function saveRsltEvent(detailVO:ServiceRequestDetailVO):SvdReqEvent{
			var evt:SvdReqEvent = new SvdReqEvent("saveServiceRequestResult");
			evt._serviceRequestDetailVO = detailVO;
			return evt;
		}
		
		public static function createMaintainPosRequestEvent(maintainRequestVO:MaintainRequestVO):SvdReqEvent {
			var evt:SvdReqEvent = new SvdReqEvent("maintainPosRequest");
			evt._maintainRequestVO = maintainRequestVO;
			return evt;
		}
		
		private var _documentFileVO:DocumentFileVO = new DocumentFileVO;
		
		public function get documentFileVO():DocumentFileVO { return _documentFileVO; } 
		
		public static function createDownloadFileEvent(docVO:DocumentFileVO):SvdReqEvent {
			var evt:SvdReqEvent = new SvdReqEvent("downloadDocFile");
			evt._documentFileVO = docVO;
			return evt;
		}
	}
}