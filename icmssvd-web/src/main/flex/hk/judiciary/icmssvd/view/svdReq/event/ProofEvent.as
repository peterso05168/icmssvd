package hk.judiciary.icmssvd.view.svdReq.event
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.DocumentFileVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.BatchSearchVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestSearchVO;

	public class ProofEvent extends Event
	{
		public function ProofEvent(type:String)
		{
			super(type);
		}
		
		private var _functionVO:FunctionVO;
		private var _posRequestSearchVO:PosRequestSearchVO;
		private var _batchSearchVO:BatchSearchVO;
		private var _posRequestDetailVO:PosRequestDetailVO;
		private var _posRequestDetailVOs:ArrayCollection;
		private var _maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
		
		public function get functionVO():FunctionVO
		{
			return this._functionVO;
		}
		public function get posRequestSearchVO():PosRequestSearchVO
		{
			return this._posRequestSearchVO;
		}
		public function get batchSearchVO():BatchSearchVO
		{
			return this._batchSearchVO;
		}
		public function get posRequestDetailVO():PosRequestDetailVO
		{
			return this._posRequestDetailVO;
		}
		public function get posRequestDetailVOs():ArrayCollection
		{
			return this._posRequestDetailVOs;
		}
		public function get maintainRequestVO():MaintainRequestVO { 
			return _maintainRequestVO;
		} 
		
		public static function initSearchParams(func:FunctionVO):ProofEvent
		{
			var evt:ProofEvent=new ProofEvent("initSearchParams");
			evt._functionVO = func;
			return evt;
		}
		
		public static function clearEquireProofResultEvent():ProofEvent
		{
			var evt:ProofEvent = new ProofEvent("clearEquireProofResult");
			return evt;
		}
		
		public static function searchProofOfSevList(searchVO:PosRequestSearchVO):ProofEvent
		{
			var evt:ProofEvent=new ProofEvent("searchProofOfSevList");
			evt._posRequestSearchVO = searchVO;
			return evt;
		}
		
		public static function createMaintainPosRequestEvent(maintainRequestVO:MaintainRequestVO):ProofEvent {
			var evt:ProofEvent = new ProofEvent("maintainPosRequest");
			evt._maintainRequestVO = maintainRequestVO;
			return evt;
		}
		
		public static function createFormProofEvent(detailVO:PosRequestDetailVO):ProofEvent {
			var evt:ProofEvent = new ProofEvent("formProof");
			evt._posRequestDetailVO = detailVO;
			evt._functionVO = detailVO.func;
			return evt;
		}
		
		public static function initInputParams(detailVO:PosRequestDetailVO):ProofEvent
		{
			var evt:ProofEvent=new ProofEvent("initInputParams");
			evt._functionVO = detailVO.func;
			return evt;
		}
		
		public static function submitPosRequestEvent(detailVO:PosRequestDetailVO):ProofEvent
		{
			var evt:ProofEvent=new ProofEvent("submitPosRequest");
			evt._posRequestDetailVO = detailVO;
			return evt;
		}
		
		public static function initBatchSearchParams(func:FunctionVO):ProofEvent
		{
			var evt:ProofEvent=new ProofEvent("initBatchSearchParams");
			evt._functionVO = func;
			return evt;
		}
		
		public static function searchPosRequestBatchList(searchVO:BatchSearchVO):ProofEvent
		{
			var evt:ProofEvent=new ProofEvent("searchPosRequestBatchList");
			evt._batchSearchVO = searchVO;
			return evt;
		}
		
		public static function clearEquireBatchResultEvent():ProofEvent
		{
			var evt:ProofEvent = new ProofEvent("clearEquireBatchResult");
			return evt;
		}
		
		public static function submitPosRequestListEvent(detailVOs:ArrayCollection):ProofEvent
		{
			var evt:ProofEvent=new ProofEvent("submitPosRequestList");
			evt._posRequestDetailVOs = detailVOs;
			return evt;
		}
		
		private var _documentFileVO:DocumentFileVO = new DocumentFileVO;
		
		public function get documentFileVO():DocumentFileVO { return _documentFileVO; } 
		
		public static function createDownloadFileEvent(docVO:DocumentFileVO):ProofEvent {
			var evt:ProofEvent = new ProofEvent("downloadDocFile");
			evt._documentFileVO = docVO;
			return evt;
		}
	}
}