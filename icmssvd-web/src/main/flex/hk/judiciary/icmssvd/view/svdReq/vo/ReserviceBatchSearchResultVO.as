package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceBatchSearchResultDTO")]
	public class ReserviceBatchSearchResultVO extends BaseVO
	{
		public var batchSeqNo:int;
		public var recordMode:String;
		public var nextHearingDetail:NextHearingDetailVO;
		public var reserviceRequestDetail:ReserviceRequestDetailVO;
		public var func:FunctionVO;
	}
}