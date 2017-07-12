package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentClassVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentStatusVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDTO")]
	[Bindable]
	public class DocumentVO extends BaseVO
	{
		public var documentId:int;
		public var documentClass:DocumentClassVO = new DocumentClassVO;
		public var documentStatus:DocumentStatusVO = new DocumentStatusVO;
		public var documentType:DocumentTypeVO = new DocumentTypeVO;
		public var documentReferenceNo:String;
		public var documentFileBy:PartyVO = new PartyVO;
		public var documentFileDate:Date = new Date;
		public var cfsFileId:String;
	}
}