package hk.judiciary.icmssvd.view.batchPrinting.vo
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.MessageInfoType;

	public class ErrorMessageInfoVO
	{
		public var fieldName:String;
		public var messageInfoType:MessageInfoVO;
		public var fmkErrorCodes:ArrayCollection;
		
		public function ErrorMessageInfoVO()
		{
			
		}
		
		public function getFormattedBoxMessage():String {
			var boxMsg:String = "";
			
			if (messageInfoType.code == MessageInfoType.FIELD_IS_REQUIRED.code) {
				if (fieldName != null || !fieldName) {
					boxMsg = fieldName + " ";
				}
				boxMsg += messageInfoType.boxMsg;
			} else if (messageInfoType.code == MessageInfoType.FORMAT_IS_INVALID.code) {
				if (fieldName != null || !fieldName) {
					boxMsg = fieldName + " ";
				}
				boxMsg += messageInfoType.boxMsg;
			} else {
				// By Default
				var newBoxMsg:String = messageInfoType.boxMsg;
				if (messageInfoType.args != null && messageInfoType.args.length > 0) {
					var i:int;
					for (i=0; i<messageInfoType.args.length; i++) {
						newBoxMsg = newBoxMsg.replace("{"+i+"}", messageInfoType.args[i]);
					}
				}
				
				if (fieldName != null || !fieldName) {
					boxMsg = fieldName + " ";
				}
				boxMsg += newBoxMsg;
			}
			
			return boxMsg;
		}
	}
	
	
	
}