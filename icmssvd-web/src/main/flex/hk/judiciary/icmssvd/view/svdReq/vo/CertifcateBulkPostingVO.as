package hk.judiciary.icmssvd.view.svdReq.vo
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	

	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.CertifcateBulkPostingDTO")]
	public class CertifcateBulkPostingVO extends BaseVO
	{
		public var firstClerkName:String;
		public var postageFee:Number;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.svdReq.ReserviceBatchSearchResultVO")]
		public var reserviceBatchSearchResults:ArrayCollection=new ArrayCollection();
	}
}