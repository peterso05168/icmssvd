package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.SpecialRequestTypeVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.SpecialRequestDTO")]
	[Bindable]
	public class SpecialRequestVO extends BaseVO
	{
		public var requestId:int;
		public var specialRequestId:int;
		public var specialRequestType:SpecialRequestTypeVO = new SpecialRequestTypeVO;
	}
}