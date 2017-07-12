package hk.judiciary.icmssvd.view.svdReq.vo
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.ParticipantRoleTypeVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.svdReq.biz.dto.PartyDTO")]
	[Bindable]
	public class PartyVO extends BaseVO
	{
		public var participantRoleId:int;
		public var participantId:int;
		public var partyCategoryId:int;
		public var participantRoleType:ParticipantRoleTypeVO = new ParticipantRoleTypeVO;
		public var respondentSeqNo:int;
		public var respondentSubSeqNo:int;
		public var englishSurname:String;
		public var englishGivenName:String;
		public var chineseSurname:String;
		public var chineseGivenName:String;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.AddressRoleVO")]
		public var addressRoles:ArrayCollection = new ArrayCollection;
	}
}