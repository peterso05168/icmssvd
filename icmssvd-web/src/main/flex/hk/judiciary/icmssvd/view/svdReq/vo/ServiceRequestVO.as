package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.ParticipantRoleTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.PostOfficeVO;
	import hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDTO")]
	[Bindable]
	public class ServiceRequestVO extends BaseVO
	{
		public var serviceRequestId:int;
		public var requestId:int;
		public var requireAffirmationInd:Boolean;
		public var serviceBeforeDate:Date;
		public var participantRoleType:ParticipantRoleTypeVO = new ParticipantRoleTypeVO;
		public var englishRecipientSurname:String;
		public var englishRecipientGivenName:String;
		public var chineseRecipientSurname:String;
		public var chineseRecipientGivenName:String;
		public var deliveryInstruction:String;
		public var registeredMailBarcode:String;
		public var serviceModeType:ServiceModeTypeVO = new ServiceModeTypeVO;
		public var postOffice:PostOfficeVO = new PostOfficeVO;
	}
}