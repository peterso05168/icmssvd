package hk.judiciary.icmssvd.view.svdReq.vo
{
	[Bindable]
	public class DisplayReServiceDetailVO
	{
		public var checked:Boolean;
		public var caseNo:String = "";
		public var pdCode:String = "";
		public var defendantName:String = "";
		public var dayFromAllocation:String = "";
		public var hearingScheduleDate:Date;
		public var hearingStartTime:String = "";
		public var courtRoomChambersName:String = "";
		
		public var recipientName:String= "";
		
		public var summonsGeneratedInd:Boolean;
		
		public var regionName:String = "";
		public var serviceModeName:String = "";
		public var serviceAgentName:String = "";
		public var isBailiff:Boolean = false;
		public var baiOfficeName:String = "";
		public var detailAble:Boolean = false;
		public var reqStatusName:String = "";
		
		public var registeredMailBarcode:String = "";
		
		public var reserviceBatchSearchResultVO:ReserviceBatchSearchResultVO;
		
		public var seq:int;
		
		public var editable:Boolean = true;
	}
}