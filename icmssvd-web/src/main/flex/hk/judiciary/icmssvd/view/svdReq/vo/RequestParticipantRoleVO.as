package hk.judiciary.icmssvd.view.svdReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestParticipantRoleDTO")]
	[Bindable]
	public class RequestParticipantRoleVO extends BaseVO
	{
		public var requestParticipantRoleId:int;
		public var requestId:int;
		public var participantId:int;
		public var originalParticipantRoleId:int;
		public var partyCategoryId:int;
		public var participantRoleTypeId:int;
		public var respondentSeqNo:int;
		public var respondentSubSeqNo:int;
		public var recipientRequesterIndicator:int;
	}
}