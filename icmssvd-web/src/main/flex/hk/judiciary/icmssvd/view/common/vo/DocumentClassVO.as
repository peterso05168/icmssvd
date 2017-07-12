package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.DocumentClassDTO")]
	[Bindable]
	public class DocumentClassVO extends BaseVO
	{
		public var documentClassId:int;
		public var documentClassName:String;
		public var documentClassCode:String;
	}
}