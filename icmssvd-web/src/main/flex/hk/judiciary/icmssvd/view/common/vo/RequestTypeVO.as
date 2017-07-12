package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.RequestTypeDTO")]
	[Bindable]
	public class RequestTypeVO extends BaseVO
	{
		public var requestTypeId:int;
		public var requestTypeName:String;
	}
}