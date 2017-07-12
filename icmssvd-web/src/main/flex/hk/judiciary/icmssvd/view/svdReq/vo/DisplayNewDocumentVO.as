package hk.judiciary.icmssvd.view.svdReq.vo
{
	[Bindable]
	public class DisplayNewDocumentVO 
	{
		public var documentId:int;
		public var documentType:String;
		public var documentReferenceNo:String;
		public var documentVO:DocumentVO = new DocumentVO;
		public var drnEmpty:Boolean = true;
		public var seq:int;
	}
}