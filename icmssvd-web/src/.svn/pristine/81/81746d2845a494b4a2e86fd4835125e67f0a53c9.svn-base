package hk.judiciary.icmssvd.view.batchPrinting.vo
{
	public class MessageInfoVO
	{
		public var code:String;
		public var priority:int;
		public var tooltipMsg:String;
		public var boxMsg:String;
		public var args:Array;
		/*
		private var _args:Array;
		public function get args():Array {
			return this._args;
		}
		public function set args(value:Array):void {
			this._args = value;
			
			if (this._args != null && this._args.length > 0) {
				var i:int;
				for (i=0; i<this._args.length; i++) {
					this.tooltipMsg = this.tooltipMsg.replace("{"+i+"}", this._args[i]);
				}
			}
		}
		*/
		public function MessageInfoVO():void {
			
		}
		
		public function setProperties(code:String, tooltipMsg:String, boxMsg:String, priority:int):MessageInfoVO {
			this.code = code;
			this.tooltipMsg = tooltipMsg;
			this.boxMsg = boxMsg;
			this.priority = priority;
			return this;
		}
		
		public function getAmendedTooltip():String {
			var result:String = this.tooltipMsg;
			if (this.args != null && this.args.length > 0) {
				var i:int;
				for (i=0; i<this.args.length; i++) {
					result = result.replace("{"+i+"}", this.args[i]);
				}
			}
			return result;
		}
	}
}