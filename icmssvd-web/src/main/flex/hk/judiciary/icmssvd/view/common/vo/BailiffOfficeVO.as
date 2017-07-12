package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.BailiffOfficeDTO")]
	[Bindable]
	public class BailiffOfficeVO extends BaseVO
	{
		public var bailiffOfficeId:int;
		public var bailiffOfficeName:String;
		public var bailiffOfficeCode:String;
		public var bailiffOfficeGroup:String;
	}
}