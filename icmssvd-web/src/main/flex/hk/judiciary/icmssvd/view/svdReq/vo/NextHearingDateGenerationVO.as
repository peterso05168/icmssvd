package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDateGenerationDTO")]
	public class NextHearingDateGenerationVO extends BaseVO
	{
		public var dayFromAllocation:int;
		public var nextHearingDetail:NextHearingDetailVO;
	}
}