package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.CourtRoomChambersVO;

	[Bindable]
	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDTO")]
	public class PosRequestVO extends BaseVO
	{
		public var posRequestId:int;
		public var requestId:int
		public var serviceRequestId:int
		public var successfulTaskId:int;
		public var posDocumentInd:Boolean;
		public var posDocumentDueDate:Date;
		public var posDocumentType:PosDocumentTypeVO;
		public var attendCourtPersonInd:Boolean;
		public var posHearingDatetime:Date;
		public var requestedBy:int;
		public var comprisingCourt:ComprisingCourtVO;
		public var courtRoomChambers:CourtRoomChambersVO;
	}
}