package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO")]
	[Bindable]
	public class FunctionVO extends BaseVO
	{
		public var courtLevelTypeCode:String;
	}
}