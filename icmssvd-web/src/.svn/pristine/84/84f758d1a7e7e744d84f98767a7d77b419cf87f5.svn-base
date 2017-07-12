package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultReasonVO;
	import hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultStatusVO;
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestResultDTO")]
	[Bindable]
	public class RequestResultVO extends BaseVO
	{
		public var requestResultId:int;
		public var requestId:int;
		public var bailiffTaskResultStatus:BailiffTaskResultStatusVO = new BailiffTaskResultStatusVO;
		public var endorsementDate:Date;
		public var bailiffTaskResultReason:BailiffTaskResultReasonVO = new BailiffTaskResultReasonVO;
		public var serviceDate:Date;
		public var serviceReturnDate:Date;
		public var requestResultNotes:String;
		public var processedBy:String;
		public var attemptNo:int;
	}
}