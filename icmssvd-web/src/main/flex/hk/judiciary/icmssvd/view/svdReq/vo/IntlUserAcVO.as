package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.IntlUserAcDTO")]
	public class IntlUserAcVO extends BaseVO
	{
		public var intlUserAcId:int;
		public var loginName:String;
		public var englishSurname:String;
		public var englishGivenName:String;
		public var chineseSurname:String;
		public var chineseGivenName:String;
	}
}