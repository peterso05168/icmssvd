package hk.judiciary.icmssvd.view.common.util
{
	import hk.judiciary.fmk.view.component.AdvancedDataGridColumn;

	public class BooleanUtil
	{
		public static const DEFAULT_YES:String = "Y";
		public static const DEFAULT_NO:String = "N";
		
		
		public static function stringToBoolean(value:String):Boolean{
			var returnVal:Boolean = false;
			
			if (DEFAULT_YES == value){
				returnVal = true;
			}
			
			return returnVal;
		}
		
		public static function booleanToString(value:Boolean):String{
			var returnVal:String = BooleanUtil.DEFAULT_NO;
			
			if (value) {
				returnVal = BooleanUtil.DEFAULT_YES;
			}
			
			return returnVal;
		}
		
		public static function labelFuncForBoolean(item:Object, column:AdvancedDataGridColumn):String 
		{
			var value:Boolean = item[column.dataField] as Boolean;
			
			return booleanToString(value);
		}
	}
}