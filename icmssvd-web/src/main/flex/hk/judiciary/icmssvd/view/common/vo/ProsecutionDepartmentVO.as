package hk.judiciary.icmssvd.view.common.vo
{
	import hk.judiciary.icmssvd.view.svdReq.vo.AddressVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.ProsecutionDepartmentDTO")]
	[Bindable]
	public class ProsecutionDepartmentVO extends BaseVO
	{
		public var prosecutionDepartmentCodeId:int;
		public var seqNo:int;
		public var prosecutionDepartmentCode:String;
		public var prosecutionDepartmentName:String;
		public var prosecutionDepartmentChineseName:String;
		public var telephoneNo:String;
		public var faxNo:String;
		public var mobileNo:String;
		public var address:AddressVO = new AddressVO;
		public var englishDepartmentHeadTitle:String;
		public var chineseDepartmentHeadTitle:String;
	}
}