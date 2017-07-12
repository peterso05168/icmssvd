package hk.judiciary.icmssvd.view.exeReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO;
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.IdVO;
	import hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PartyVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchResultDTO")]
	public class ExecutionRequestSearchResultVO extends BaseVO
	{
		public var requestId:IdVO;
		public var submitDate:Date;
		public var caseNo:String;
		public var applicant:PartyVO;
		public var bailiffOffice:BailiffOfficeVO;
		public var requestStatusType:RequestStatusTypeVO;
	}
}