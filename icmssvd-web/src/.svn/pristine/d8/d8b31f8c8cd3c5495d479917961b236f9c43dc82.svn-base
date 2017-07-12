package hk.judiciary.icmssvd.view.svdReq.vo
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDetailDTO")]
	public class PosRequestDetailVO extends BaseVO
	{
		public var posRequest:PosRequestVO = new PosRequestVO;
		public var request:RequestVO = new RequestVO;
		public var requester:PartyVO = new PartyVO;
		public var recipient:PartyVO = new PartyVO;
		public var processedBy:String;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DocumentVO")]
		public var documents:ArrayCollection = new ArrayCollection;
		public var posPanelMode:String;
		public var func:FunctionVO = new FunctionVO;
	}
}