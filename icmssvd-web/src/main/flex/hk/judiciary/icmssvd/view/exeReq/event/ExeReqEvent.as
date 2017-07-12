package hk.judiciary.icmssvd.view.exeReq.event
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.DocumentFileVO;
	import hk.judiciary.icmssvd.view.exeReq.vo.ExecutionRequestDetailVO;
	import hk.judiciary.icmssvd.view.exeReq.vo.ExecutionRequestSearchVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;

	public class ExeReqEvent extends Event
	{
		public function ExeReqEvent(type:String)
		{
			super(type);
		}
		
		private var _functionVO:FunctionVO;
		private var _executionRequestSearchVO:ExecutionRequestSearchVO;
		private var _requestIdDTOs:ArrayCollection = new ArrayCollection;
		
		public function get functionVO():FunctionVO
		{
			return this._functionVO;
		}
		
		public function get executionRequestSearchVO():ExecutionRequestSearchVO
		{
			return this._executionRequestSearchVO;
		}
		
		public function get requestIdDTOs():ArrayCollection{ 
			return this._requestIdDTOs; 
		}
		
		
		public static function initSearchParams(func:FunctionVO):ExeReqEvent
		{
			var evt:ExeReqEvent=new ExeReqEvent("initSearchParams");
			evt._functionVO = func;
			return evt;
		}
		
		public static function searchExecutionRequestList(searchVO:ExecutionRequestSearchVO):ExeReqEvent
		{
			var evt:ExeReqEvent=new ExeReqEvent("searchExecutionRequestList");
			evt._executionRequestSearchVO = searchVO;
			return evt;
		}
		
		public static function initInputParams(detailVO:ExecutionRequestDetailVO):ExeReqEvent
		{
			var evt:ExeReqEvent=new ExeReqEvent("initInputParams");
			evt._executionRequestDetailVO = detailVO;
			evt._functionVO = detailVO.func;
			return evt;
		}
		
		public static function initResultParams(func:FunctionVO):ExeReqEvent
		{
			var evt:ExeReqEvent=new ExeReqEvent("initResultParams");
			evt._functionVO = func;
			return evt;
		}
		
		public static function clearEquireExeReqResultEvent():ExeReqEvent
		{
			var evt:ExeReqEvent = new ExeReqEvent("clearEquireExeReqResult");
			return evt;
		}
		
		private var _maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
		
		
		public function get maintainRequestVO():MaintainRequestVO { return _maintainRequestVO; } 
		
		private var _executionRequestDetailVO:ExecutionRequestDetailVO = new ExecutionRequestDetailVO;
		
		public function get executionRequestDetailVO():ExecutionRequestDetailVO{ return this._executionRequestDetailVO; }
		
		public static function createMaintainExecutionRequestEvent(maintainRequestVO:MaintainRequestVO):ExeReqEvent {
			var evt:ExeReqEvent = new ExeReqEvent("maintainExecutionRequest");
			evt._maintainRequestVO = maintainRequestVO;
			return evt;
		}
		
		public static function createFormRequestEvent(detailVO:ExecutionRequestDetailVO):ExeReqEvent {
			var evt:ExeReqEvent = new ExeReqEvent("formRequest");
			evt._executionRequestDetailVO = detailVO;
			evt._functionVO = detailVO.func;
			return evt;
		}

		public static function saveDraftEvent(detailVO:ExecutionRequestDetailVO):ExeReqEvent{
			var evt:ExeReqEvent = new ExeReqEvent("saveDraftExecutionRequest");
			evt._executionRequestDetailVO = detailVO;
			return evt;
		}
		
		public static function submitEvent(detailVO:ExecutionRequestDetailVO):ExeReqEvent{
			var evt:ExeReqEvent = new ExeReqEvent("submitExecutionRequest");
			evt._executionRequestDetailVO = detailVO;
			return evt;
		}
		
		public static function withdrawEvent(detailVO:ExecutionRequestDetailVO):ExeReqEvent{
			var evt:ExeReqEvent = new ExeReqEvent("withdrawExecutionRequest");
			evt._executionRequestDetailVO = detailVO;
			return evt;
		}
		
		private var _documentFileVO:DocumentFileVO = new DocumentFileVO;
		
		public function get documentFileVO():DocumentFileVO { return _documentFileVO; } 
		
		public static function createDownloadFileEvent(docVO:DocumentFileVO):ExeReqEvent {
			var evt:ExeReqEvent = new ExeReqEvent("downloadDocFile");
			evt._documentFileVO = docVO;
			return evt;
		}
	}
}