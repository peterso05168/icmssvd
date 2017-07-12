package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.AddressRoleTypeDTO")]
	[Bindable]
	public class AddressRoleTypeVO extends BaseVO
	{
		public var addressRoleTypeId:int;
		public var addressRoleTypeCode:String;
		public var addressRoleTypeName:String;
	}
}