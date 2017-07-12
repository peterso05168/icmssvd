package hk.judiciary.icmssvd.view.exeReq.vo
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PartyVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestAddressVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestParticipantRoleVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestResultVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestVO;

	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDetailDTO")]
	public class ExecutionRequestDetailVO extends BaseVO
	{
		public var request:RequestVO = new RequestVO;
		public var executionRequest:ExecutionRequestVO = new ExecutionRequestVO;
		public var requestAddress:RequestAddressVO = new RequestAddressVO;
		public var requestParticipantRole:RequestParticipantRoleVO = new RequestParticipantRoleVO;
		public var applicant:PartyVO;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DocumentRecordVO")]
		public var documentRecords:ArrayCollection = new ArrayCollection;
		
		public var requestResult:RequestResultVO = new RequestResultVO;
		public var executionRequestPanelMode:String;
		public var documentListPanelMode:String;
		public var executionResultPanelMode:String;
		public var submittedModeInd:Boolean;
		public var allowSaveDraftInd:Boolean;
		public var allowSubmitInd:Boolean;
		public var allowWithdrawInd:Boolean;
		public var func:FunctionVO = new FunctionVO;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.PartyVO")]
		public var applicants:ArrayCollection = new ArrayCollection;
	}
}