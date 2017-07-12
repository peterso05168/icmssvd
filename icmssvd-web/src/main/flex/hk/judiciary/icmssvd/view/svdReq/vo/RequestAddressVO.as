package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO;
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.HkDistrictVO;
	import hk.judiciary.icmssvd.view.common.vo.HkRegionVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestAddressDTO")]
	[Bindable]
	public class RequestAddressVO extends BaseVO
	{
		public var requestAddressId:int;
		public var requestId:int;
		public var englishAddress1:String;
		public var englishAddress2:String;
		public var englishAddress3:String;
		public var chineseAddress1:String;
		public var chineseAddress2:String;
		public var chineseAddress3:String;
		public var primaryAddressInd:Boolean;
		public var actionAddressInd:Boolean;
		public var foreignAddressInd:Boolean;
		public var bailiffOffice:BailiffOfficeVO = new BailiffOfficeVO;
		public var hkDistrict:HkDistrictVO = new HkDistrictVO;
		public var hkRegion:HkRegionVO = new HkRegionVO;
	}
}