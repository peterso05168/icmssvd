package hk.judiciary.icmssvd.view.common.util
{
	import mx.collections.ArrayCollection;
	import mx.controls.DateField;
	import mx.utils.ObjectUtil;
	import mx.utils.StringUtil;
	
	import hk.judiciary.fmk.view.component.AdvancedDataGridColumn;
	import hk.judiciary.fmk.view.component.DateFormatter;
	import hk.judiciary.icmssvd.view.common.vo.HourVO;
	import hk.judiciary.icmssvd.view.common.vo.MinuteVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;

	public class DateUtil
	{
		public static function toFormattedDateString(date:Date, pattern:String=SvdReqConstant.DEFAULT_DATE_PATTERN):String
		{
			return convertDateToString(date, pattern);
		}
		
		public static function toFormattedDayString(date:Date, pattern:String=SvdReqConstant.DEFAULT_DAY_PATTERN):String
		{
			return convertDateToString(date, pattern);
		}
		
		public static function toFormattedTimeString(date:Date, pattern:String=SvdReqConstant.DEFAULT_TIME_PATTERN):String
		{
			return convertDateToString(date, pattern);
		}
		
		public static function toFormattedDateTimeString(date:Date, pattern:String=SvdReqConstant.DEFAULT_DATE_TIME_PATTERN):String
		{
			return convertDateToString(date, pattern);
		}
		
		public static function stringToDate(date:String, pattern:String=SvdReqConstant.DEFAULT_DATE_PATTERN):Date
		{
			return DateField.stringToDate(date,pattern);
		}
		
		public static function stringToDateTime(date:String):Date
		{
			var d:Date = new Date();
			var matches : Array = date.match(/(\d\d)\/(\d\d)\/(\d\d\d\d) (\d\d):(\d\d)/);
			
			if (matches != null)
			{
				d.setFullYear(int(matches[3]), int(matches[2]) - 1, int(matches[1]));
				d.setHours(int(matches[4]), int(matches[5]), 0, 0);
			}
			return d;
		}
		
		public static function compareDateWithoutTime(date1:Date, date2:Date):int
		{
			var result:int = 0;
			if (date1 != null && date2 != null)
			{
				var firstDate:Date = new Date(date1.fullYear, date1.month, date1.date);
				var secondDate:Date = new Date(date2.fullYear, date2.month, date2.date);
				result = ObjectUtil.dateCompare(secondDate, firstDate);
			}
			return result;
		}
		
		public static function zeroPad(number:int, width:int=2):String
		{
			var ret:String = ""+number;
			while( ret.length < width )
				ret="0" + ret;
			return ret;
		}
		
		public static function parseDate(valueString:String, inputFormat:String):Date
		{
			if (StringUtil.trim(valueString) == "")
				return null;
			
			var date:Date = DateUtil.stringToDate(valueString, inputFormat);
			if (date == null)
				date = new Date();
			return date;
		}
		
		private static function convertDateToString(date:Date, pattern:String):String
		{
			var formatter:DateFormatter=new DateFormatter();
			if (date != null)
			{
				formatter.formatString=pattern;
				return formatter.format(date);
			}
			return "";
		}
		
		public static function labelFuncForDate(item:Object, column:AdvancedDataGridColumn):String 
		{
			var value:Date = item[column.dataField] as Date;
			
			if (value == null)
			{
				return "";
			}
			
			return toFormattedDateString(value);
		}
		
		public static function labelFuncForDateTime(item:Object, column:AdvancedDataGridColumn):String 
		{
			var value:Date = item[column.dataField] as Date;
			
			if (value == null)
			{
				return "";
			}
			
			return toFormattedDateTimeString(value);
		}
		
		public static function labelFuncForTime(item:Object, column:AdvancedDataGridColumn):String 
		{
			var value:Date = item[column.dataField] as Date;
			
			if (value == null)
			{
				return "";
			}
			
			return toFormattedTimeString(value);
		}
		
		public static function get hourList():ArrayCollection
		{
			[ArrayElementType("hk.judiciary.icmscdy.view.courtdiary.vo.common.HourVO")]
			var hourVOs:ArrayCollection = new ArrayCollection;
			
			for (var i:int = 0; i < 24; ++i)
			{
				var curHour:HourVO = new HourVO;
				if (i < 10)
				{
					curHour.hour = "0" + i;
				}
				else
				{
					curHour.hour = i.toString();
				}
				hourVOs.addItem(curHour);
			}
			
			return hourVOs;
		}
		
		public static function get minList():ArrayCollection
		{
			[ArrayElementType("hk.judiciary.icmscdy.view.courtdiary.vo.common.MinuteVO")]
			var minVOs:ArrayCollection = new ArrayCollection;
			
			for (var i:int = 0; i < 60; ++i)
			{
				var curMin:MinuteVO = new MinuteVO;
				if (i < 10)
				{
					curMin.minute = "0" + i;
				}
				else
				{
					curMin.minute = i.toString();
				}
				minVOs.addItem(curMin);
			}
			
			return minVOs;
		}
	}
}