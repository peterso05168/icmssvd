package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.FpApplicationNatureTypeDTO")]
	[Bindable]
	public class FpApplicationNatureTypeVO extends BaseVO
	{
		public var fpApplicationNatureTypeId:int;
		public var seqNo:int;
		public var fpApplicationNatureCode:String;
		public var englishFpApplicationNatureTypeName:String;
		public var chineseFpApplicationNatureTypeName:String;
	}
}