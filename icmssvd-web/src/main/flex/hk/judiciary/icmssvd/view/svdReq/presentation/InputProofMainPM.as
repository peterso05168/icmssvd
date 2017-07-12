package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import hk.judiciary.fmk.web.infrastructure.ClientWindow;
	import hk.judiciary.fmk.web.infrastructure.OpenablePMAdapter;
	import hk.judiciary.fmk.web.infrastructure.OpenablePMConfiguration;
	import hk.judiciary.icmssvd.view.svdReq.event.ProofEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestDetailVO;
	
	[Event(name="formProof",
		   type="hk.judiciary.icmssvd.view.svdReq.event.ProofEvent")]
	
	[ManagedEvents("formProof", scope="local")]
	public class InputProofMainPM extends OpenablePMAdapter
	{
//		override public function init(parameters:Array=null):void
//		{
//			if (parameters != null && parameters.length >0)
//			{
//				var posRequestDetailVO:PosRequestDetailVO = new PosRequestDetailVO;
//				if (parameters.length > 0)
//				{
//					posRequestDetailVO = parameters[0];
//				}
//				dispatchEvent(ProofEvent.createFormProofEvent(posRequestDetailVO));
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
				if(client.serverAttributes.posRequestDetail != null){
					var temp_posRequestDetailVO:PosRequestDetailVO = new PosRequestDetailVO;
					var clientParam:PosRequestDetailVO = client.serverAttributes.posRequestDetail;
					temp_posRequestDetailVO = clientParam;
					if(errorBox != null){
						temp_posRequestDetailVO.errorBoxComponentId = errorBox.id;
					}else{
						temp_posRequestDetailVO.errorBoxComponentId = null;
					}
					dispatchEvent(ProofEvent.createFormProofEvent(temp_posRequestDetailVO));
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
