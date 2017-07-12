package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[Bindable]
	public class DisplayAddressRoleVO extends BaseVO
	{
		public var addressRoleId:int;
		public var addressRoleTypeName:String;
		public var addressRoleVO:AddressRoleVO;
	}
}