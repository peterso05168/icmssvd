package hk.judiciary.icmssvd.view.svdReq.vo
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDetailDTO")]
	[Bindable]
	public class ServiceRequestDetailVO extends BaseVO
	{
		public var request:RequestVO = new RequestVO;
		public var serviceRequest:ServiceRequestVO = new ServiceRequestVO;
		public var requestAddress:RequestAddressVO = new RequestAddressVO;
		public var requesterRequestParticipantRole:RequestParticipantRoleVO = new RequestParticipantRoleVO;
		public var recipientRequestParticipantRole:RequestParticipantRoleVO = new RequestParticipantRoleVO;
		public var requester:PartyVO = new PartyVO;
		public var recipient:PartyVO = new PartyVO;
		public var requestServiceType:RequestServiceTypeVO = new RequestServiceTypeVO;
		public var specialRequest:SpecialRequestVO = new SpecialRequestVO;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DocumentRecordVO")]
		public var documentRecords:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DocumentDraftVO")]
		public var documentDrafts:ArrayCollection = new ArrayCollection;
		public var requestResult:RequestResultVO = new RequestResultVO;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DocumentVO")]
		public var newReturnDocuments:ArrayCollection = new ArrayCollection;
		public var serviceOfDocumentPanelMode:String;
		public var documentListPanelMode:String;
		public var serviceResultPanelMode:String;
		public var submittedModeInd:Boolean;
		public var allowSaveDraftInd:Boolean;
		public var allowSubmitInd:Boolean;
		public var allowWithdrawInd:Boolean;
		public var allowCompleteInd:Boolean;
		public var allowUpdateServiceTypeInd:Boolean;
		public var allowProofOfServiceInd:Boolean;
		public var urgentRequireInd:Boolean;
		public var func:FunctionVO = new FunctionVO;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.PartyVO")]
		public var requesters:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.PartyVO")]
		public var recipients:ArrayCollection = new ArrayCollection;
	}
}