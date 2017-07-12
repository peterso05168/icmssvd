package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO")]
	[Bindable]
	public class ServiceModeTypeVO extends BaseVO
	{
		public var serviceModeTypeId:int;
		public var serviceModeTypeCode:String;
		public var serviceModeTypeName:String;
	}
}