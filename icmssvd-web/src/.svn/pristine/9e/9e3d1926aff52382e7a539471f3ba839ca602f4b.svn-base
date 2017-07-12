package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.HkRegionVO;
	import hk.judiciary.icmssvd.view.common.vo.IdVO;
	import hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO;
	
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchResultDTO")]
	[Bindable]
	public class ServiceRequestSearchResultVO extends BaseVO
	{
		public var requestId:IdVO = new IdVO;
		public var submitDate:Date = new Date;
		public var caseNo:String;
		public var requester:PartyVO = new PartyVO;
		public var recipient:PartyVO = new PartyVO;
		public var hkRegion:HkRegionVO = new HkRegionVO;
		public var serviceModeType:ServiceModeTypeVO = new ServiceModeTypeVO;
		public var handlingAgent:HandlingAgentVO = new HandlingAgentVO;
		public var requestServiceType:RequestServiceTypeVO = new RequestServiceTypeVO;
		public var urgentServiceInd:Boolean;
		public var requestStatusType:RequestStatusTypeVO = new RequestStatusTypeVO;
		public var allowCompleteInd:Boolean;
		
	}
}