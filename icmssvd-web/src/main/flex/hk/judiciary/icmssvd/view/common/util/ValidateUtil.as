package hk.judiciary.icmssvd.view.common.util
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.fmk.web.application.util.ValidationUtil;

	public class ValidateUtil
	{
		public static function addValidationMessage(messageCode:String, componentPath:String, messageBoxId:String):void
		{
			ValidationUtil.addValidationMessage(messageCode, componentPath, messageBoxId);
		}
		
		public static function addMultiplyValidationMessage(messageCode:String, componentPaths:ArrayCollection, messageBoxId:String):void
		{
			for each (var compPath:String in componentPaths)
			{
				ValidationUtil.addValidationMessage(messageCode, compPath, messageBoxId);
			}
		}
		
		public static function addValidationMessageDataGrid(messageCode:String, componentPath:String, messageBoxId:String, columnNuber:int, rowNumbers:ArrayCollection):void
		{
			ValidationUtil.addValidationMessageDataGrid(messageCode, componentPath, messageBoxId, columnNuber, rowNumbers);
		}
		
		public static function showValidationMessages(messageBoxId:String):void
		{
			ValidationUtil.showValidationMessages(messageBoxId);			
		}
		
		public static function clearValidationMessage(messageBoxId:String):void
		{
			ValidationUtil.clearValidationMessage(messageBoxId);			
		}
	}
}