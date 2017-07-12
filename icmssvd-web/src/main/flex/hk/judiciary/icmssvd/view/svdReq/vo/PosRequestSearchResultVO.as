package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.IdVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchResultDTO")]
	public class PosRequestSearchResultVO extends BaseVO
	{
		public var requestId:IdVO;
		public var submitDate:Date;
		public var caseNo:String;
		public var requester:PartyVO;
		public var recipient:PartyVO;
		public var handlingAgent:HandlingAgentVO;
		public var posOrAcip:String;
		public var dueOrHearingDate:Date;
	}
}