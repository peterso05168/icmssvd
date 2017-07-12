package hk.judiciary.icmssvd.view.batchPrinting.enumObject
{
	public class ScreenSize
	{
		public static var rAuto:String = "SAutoXAuto";
		public static var r1024x768:String = "S1024X768";
		public static var r1440x900:String = "S1440X900";
		public static var r1920x1080:String = "S1920X1808";
		
		public static function getScreenWidth(screenSize:String):int {
			var widthOffset:int = -40;
			if (screenSize == r1024x768) {
				return 1024 + widthOffset;
			} else if (screenSize == r1440x900) {
				return 1440 + widthOffset;
			} else if (screenSize == r1920x1080) {
				return 1920 + widthOffset;
			} else {
				return 0;
			}
		}
		public static function getScreenHeight(screenSize:String):int {
			var screenIdHeight:int = -24;
			var heightOffset:int = -57-17-150 + screenIdHeight;
			if (screenSize == r1024x768) {
				return 768 + heightOffset;
			} else if (screenSize == r1440x900) {
				return 900 + heightOffset;;
			} else if (screenSize == r1920x1080) {
				return 1080 + heightOffset;;
			} else {
				return 0;
			}
		}
	}
}