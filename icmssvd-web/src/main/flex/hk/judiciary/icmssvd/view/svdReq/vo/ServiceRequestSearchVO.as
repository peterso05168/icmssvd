package hk.judiciary.icmssvd.view.svdReq.vo
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchDTO")]
	[Bindable]
	public class ServiceRequestSearchVO extends BaseVO
	{
		public var submitStartDate:Date;
		public var submitEndDate:Date;
		public var caseNo:String;
		public var comprisingCourt:ComprisingCourtVO = new ComprisingCourtVO;
		public var caseType:CaseTypeVO = new CaseTypeVO;
		public var serviceModeType:ServiceModeTypeVO = new ServiceModeTypeVO;
		public var handlingAgent:HandlingAgentVO = new HandlingAgentVO;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO")]
		public var requestStatusType:ArrayCollection = new ArrayCollection;
		
		public var requestServiceType:RequestServiceTypeVO = new RequestServiceTypeVO;
		
		public var func:FunctionVO = new FunctionVO;
	}
}