package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.HkRegionDTO")]
	[Bindable]
	public class HkRegionVO extends BaseVO
	{
		public var hkRegionId:int;
		public var hkRegionName:String;
		public var hkRegionChineseName:String;
		public var hkRegionCode:String;
	}
}