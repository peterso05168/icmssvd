package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.HkDistrictVO;
	import hk.judiciary.icmssvd.view.common.vo.HkRegionVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.AddressDTO")]
	public class AddressVO extends BaseVO
	{
		public var addressId:int;
		public var englishAddress1:String;
		public var englishAddress2:String;
		public var englishAddress3:String;
		public var chineseAddress1:String;
		public var chineseAddress2:String;
		public var chineseAddress3:String;
		public var hkDistrict:HkDistrictVO = new HkDistrictVO;
		public var hkRegion:HkRegionVO = new HkRegionVO;
		public var foreignAddressInd:Boolean;
	}
}