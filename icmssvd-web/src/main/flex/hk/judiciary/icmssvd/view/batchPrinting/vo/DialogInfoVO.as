package hk.judiciary.icmssvd.view.batchPrinting.vo
{
	public class DialogInfoVO
	{
		public var code:String;
		public var type:String;
		public var title:String;
		public var content:String;
		public var contentDetail:String;
		public var fmkMsgCode:String;
		
		public function DialogInfoVO():void {
			
		}
		
		public function setProperties(code:String, type:String, title:String, content:String, contentDetail:String, fmkMsgCode:String=null):DialogInfoVO {
			this.code = code;
			this.type = type;
			this.title = title;
			this.content = content;
			this.contentDetail = contentDetail;
			this.fmkMsgCode = fmkMsgCode;
			return this;
		}
	}
}