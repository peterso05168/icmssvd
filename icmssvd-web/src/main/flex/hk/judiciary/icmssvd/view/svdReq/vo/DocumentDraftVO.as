package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDraftDTO")]
	public class DocumentDraftVO extends BaseVO
	{
		public var requestDocument:RequestDocumentVO;
		public var documentType:DocumentTypeVO;
		public var selectedDocumentInd:Boolean;
	}
}