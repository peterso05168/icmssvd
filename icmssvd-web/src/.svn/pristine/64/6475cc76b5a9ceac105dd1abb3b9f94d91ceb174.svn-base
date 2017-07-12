package hk.judiciary.icmssvd.view.common.presentation
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.fmk.web.infrastructure.IModuleController;
	import hk.judiciary.fmk.web.infrastructure.OpenFunctionHandler;
	import hk.judiciary.fmk.web.infrastructure.PortalEventConstant;
	import hk.judiciary.fmk.web.infrastructure.ServerWindow;
	import hk.judiciary.icmssvd.view.common.vo.OpenFunctionParameterVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;

	public class OpenFunction{
		public static function openMain(moduleController:IModuleController, requestId:int, requestTypeId:int, control:int, newFunctionId:String):void{
			var paraRequestId:OpenFunctionParameterVO = new OpenFunctionParameterVO;
			var parameterList:ArrayCollection = new ArrayCollection;
			parameterList.addItem(paraRequestId);
			
			OpenFunction.openFunction(moduleController, newFunctionId, parameterList);
		}

		public static function openFunction(moduleController:IModuleController, functionId:String, parameterList:ArrayCollection, callBackHandler:Function = null):void{
//			var navigateParameters:Array = new Array();
//			
//			for each(var parameter:OpenFunctionParameterVO in parameterList){
//				navigateParameters.push(parameter.value);
//			}
//			moduleController.closeAndOpenFunction(functionId, navigateParameters);
			
			var server:ServerWindow = OpenFunctionHandler.getInstance().connect(SvdReqConstant.PROJECT_ID, functionId, callBackHandler, PortalEventConstant.TAB);
			if (server != null)
			{
				for each(var parameter:OpenFunctionParameterVO in parameterList)
				{
					server.setAttribute(parameter.name, parameter.value);
				}
				server.send("init");
			}
		}
	}
}