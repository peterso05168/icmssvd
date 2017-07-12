package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.ParticipantRoleTypeDTO")]
	[Bindable]
	public class ParticipantRoleTypeVO extends BaseVO
	{
		public var participantRoleTypeId:int;
		public var participantRoleTypeName:String;
		public var participantRoleTypeCode:String;
		public var applicantIndicator:String;
		public var participantRoleCategory:ParticipantRoleCategoryVO = new ParticipantRoleCategoryVO;
		public var courtLevelType:CourtLevelTypeVO = new CourtLevelTypeVO;
		public var caseType:CaseTypeVO = new CaseTypeVO;
	}
}