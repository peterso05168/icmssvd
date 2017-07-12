package hk.judiciary.icmssvd.view.common.vo
{
	[RemoteClass(alias="hk.judiciary.icmssvd.model.common.biz.dto.ComprisingCourtDTO")]
	[Bindable]
	public class ComprisingCourtVO extends BaseVO
	{
		public var comprisingCourtId:int;
		public var comprisingCourtCode:String;
		public var comprisingCourtName:String;
		public var comprisingCourtPrefix:String;
		public var courtLevelType:CourtLevelTypeVO = new CourtLevelTypeVO;
		public var courtVenue:CourtVenueVO = new CourtVenueVO;
	}
}