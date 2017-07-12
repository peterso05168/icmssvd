package hk.judiciary.icmssvd.view.exeReq.presentation
{
	import hk.judiciary.fmk.web.infrastructure.ClientWindow;
	import hk.judiciary.fmk.web.infrastructure.OpenablePMAdapter;
	import hk.judiciary.fmk.web.infrastructure.OpenablePMConfiguration;
	import hk.judiciary.icmssvd.view.exeReq.event.ExeReqEvent;
	import hk.judiciary.icmssvd.view.exeReq.vo.ExecutionRequestDetailVO;
	
	[Event(name="formRequest",
		   type="hk.judiciary.icmssvd.view.exeReq.event.ExeReqEvent")]
	
	[ManagedEvents("formRequest", scope="local")]
	public class InputExeReqMainPM extends OpenablePMAdapter
	{
//		override public function init(parameters:Array=null):void
//		{
//			if (parameters != null && parameters.length >0)
//			{
//				var executionRequestDetailVO:ExecutionRequestDetailVO = new ExecutionRequestDetailVO;
//				if (parameters.length > 0)
//				{
//					executionRequestDetailVO = parameters[0];
//				}
//				dispatchEvent(ExeReqEvent.createFormRequestEvent(executionRequestDetailVO));
//				
//			}
//		}
		private var errorBox:Object;
		
		public function setErrorBox(box:Object):void{
			errorBox = box;
		}
		
		/*New Lib Code. Don't delete*/
		private var _clientWindow:ClientWindow;
		override public function initTab():OpenablePMConfiguration
		{
			return initOpenFunction();
		}
		
		override public function initPopUpWindow():OpenablePMConfiguration
		{
			return initOpenFunction();
		}
		
		private function initOpenFunction():OpenablePMConfiguration
		{
			var openablePMConfig:OpenablePMConfiguration = new OpenablePMConfiguration();
			openablePMConfig.addEventListener(initHandler, "init");
			openablePMConfig.addEventListener(updateHandler, "update");
			return openablePMConfig;
		}
		
		private function initHandler(client:ClientWindow):void
		{
			if (client != null)
			{
				if(client.serverAttributes.executionRequestDetail != null){
					var temp_executionRequestDetailVO:ExecutionRequestDetailVO = new ExecutionRequestDetailVO;
					var clientParam:ExecutionRequestDetailVO = client.serverAttributes.executionRequestDetail;
					temp_executionRequestDetailVO = clientParam;
					if(errorBox != null){
						temp_executionRequestDetailVO.errorBoxComponentId = errorBox.id;
					}else{
						temp_executionRequestDetailVO.errorBoxComponentId = null;
					}
					dispatchEvent(ExeReqEvent.createFormRequestEvent(temp_executionRequestDetailVO));	
				}
				_clientWindow = client;
			}
		}
		
		private function updateHandler(client:ClientWindow):void
		{
			if (client != null)
			{
				_clientWindow = client;
			}
		}
	}
}
