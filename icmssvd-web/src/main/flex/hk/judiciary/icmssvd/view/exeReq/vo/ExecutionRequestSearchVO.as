package hk.judiciary.icmssvd.view.exeReq.vo
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;

	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchDTO")]
	public class ExecutionRequestSearchVO extends BaseVO
	{
		public var submitStartDate:Date;
		public var submitEndDate:Date;
		public var caseNo:String;
		public var comprisingCourt:ComprisingCourtVO;
		public var caseType:CaseTypeVO;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO")]
		public var requestStatusTypes:ArrayCollection = new ArrayCollection;
		
		public var func:FunctionVO;
	}
}