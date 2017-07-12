package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO;
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.RequestTypeVO;
	
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO")]
	[Bindable]
	public class RequestVO extends BaseVO
	{
		public var requestId:int;
		public var registrationNo:String;
		public var caseNo:String;
		public var caseId:int;
		public var caseCourtSystem:String;
		public var caseType:String;
		public var caseSerialNo:int;
		public var caseYear:int;
		public var requestType:RequestTypeVO = new RequestTypeVO;
		public var registrationYear:int;
		public var registrationSerialNo:String;
		public var submissionDatetime:Date;
		public var acceptanceDatetime:Date;
		public var sequenceNoForCase:int;
		public var handlingAgent:HandlingAgentVO = new HandlingAgentVO;
		public var requestStatusType:RequestStatusTypeVO = new RequestStatusTypeVO;
		public var bailiffOffice:BailiffOfficeVO = new BailiffOfficeVO;
	}
}