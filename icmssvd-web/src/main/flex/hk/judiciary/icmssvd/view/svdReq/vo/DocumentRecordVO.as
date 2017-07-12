package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentRecordDTO")]
	[Bindable]
	public class DocumentRecordVO extends BaseVO
	{
		public var requestDocument:RequestDocumentVO = new RequestDocumentVO;
		public var document:DocumentVO = new DocumentVO;
		public var returnedDocumentInd:Boolean;
		public var selectedDocumentInd:Boolean;
	}
}