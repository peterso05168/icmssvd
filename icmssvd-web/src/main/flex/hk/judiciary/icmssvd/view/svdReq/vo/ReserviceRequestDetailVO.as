package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceRequestDetailDTO")]
	public class ReserviceRequestDetailVO extends BaseVO
	{
		public var request:RequestVO;
		public var recipient:PartyVO;
		public var serviceRequest:ServiceRequestVO;
		public var requestAddress:RequestAddressVO;
		public var summonsGeneratedInd:Boolean;
		public var allowSaveDraftInd:Boolean;
		public var allowSubmitInd:Boolean;
	}
}