package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import hk.judiciary.fmk.web.application.util.ValidationUtil;
	import hk.judiciary.fmk.web.infrastructure.ClientWindow;
	import hk.judiciary.fmk.web.infrastructure.OpenablePMAdapter;
	import hk.judiciary.fmk.web.infrastructure.OpenablePMConfiguration;
	import hk.judiciary.icmssvd.view.common.constant.MessageBoxIdConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.util.ValidateUtil;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.SvdReqEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestDetailVO;
	
	[Event(name="formRequest,outMaintainRequest,maintainRequest",
		   type="hk.judiciary.icmssvd.view.svdReq.event.SvdReqEvent")]
	
	[ManagedEvents("formRequest", scope="local")]
	[ManagedEvents("maintainRequest", scope="local")]
	[ManagedEvents("outMaintainRequest", scope="local")]
	public class InputSvdReqMainPM extends OpenablePMAdapter
	{
//		override public function init(parameters:Array=null):void
//		{
//			if (parameters != null && parameters.length >0)
//			{
//				var serviceRequestDetailVO:ServiceRequestDetailVO = new ServiceRequestDetailVO;
//				if (parameters.length > 0)
//				{
//					serviceRequestDetailVO = parameters[0];
//				}
//				dispatchEvent(SvdReqEvent.createFormRequestEvent(serviceRequestDetailVO));
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
			openablePMConfig.addEventListener(loadprerequisiteHandler, "loadprerequisite");
			return openablePMConfig;
		}
		
		private function initHandler(client:ClientWindow):void
		{
			if (client != null)
			{
				if(client.serverAttributes.serviceRequestDetail != null){
					var temp_serviceRequestDetailVO:ServiceRequestDetailVO = new ServiceRequestDetailVO;
					var clientParam:ServiceRequestDetailVO = client.serverAttributes.serviceRequestDetail;
					temp_serviceRequestDetailVO = clientParam;
					if(errorBox != null){
						temp_serviceRequestDetailVO.errorBoxComponentId = errorBox.id;
					}else{
						temp_serviceRequestDetailVO.errorBoxComponentId = null;
					}
					maintainRequestVO = new MaintainRequestVO;
					
					dispatchEvent(SvdReqEvent.createFormRequestEvent(temp_serviceRequestDetailVO));	
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
		
		private function loadprerequisiteHandler(client:ClientWindow):void
		{
			if (client != null)
			{
				if(client.serverAttributes.caseNo != null){
					var clientParam:String = client.serverAttributes.caseNo;
					
					maintainRequestVO = new MaintainRequestVO;
					maintainRequestVO.caseNo = clientParam;
					if(clientParam.length > 0){
						newCaseNo = clientParam;
						newAble = true;
					}else{
						newAble = false;
					}
					var dcFunc:FunctionVO = new FunctionVO;
					dcFunc.courtLevelTypeCode = SvdReqConstant.COURT_LEVEL_TYPE_DISTRICT;
					maintainRequestVO.func = dcFunc;
					maintainRequestVO.makeNewRequestInd = true;
					maintainRequestVO.errorBoxComponentId = errorBoxId;
					dispatchEvent(SvdReqEvent.createOutMaintainRequestEvent(maintainRequestVO));	
				}
				_clientWindow = client;
			}
		}
		
		private var maintainRequestVO:MaintainRequestVO;
		private var courtLvlType:String;
		
		public function init(courtLvl:String):void{
			courtLvlType = courtLvl;
			if(SvdReqConstant.COURT_LEVEL_TYPE_DISTRICT == courtLvlType){
				errorBoxId = MessageBoxIdConstant.INPUT_SVDREQ_ERROR_DC;
			}else{
				errorBoxId = MessageBoxIdConstant.INPUT_SVDREQ_ERROR_MC;
			}
			if(maintainRequestVO == null){
				dispatchEvent(SvdReqEvent.createOutMaintainRequestEvent(maintainRequestVO));
			}
		}
		
		private var _newAble:Boolean=false;
		private var _newVisable:Boolean=true;
		private var _newCaseNo:String = "";
		[Bindable]
		public function get newAble():Boolean{ return this._newAble; }
		public function set newAble(value:Boolean):void { this._newAble=value; }
		[Bindable]
		public function get newVisable():Boolean{ return this._newVisable; }
		public function set newVisable(value:Boolean):void { this._newVisable=value; }
		[Bindable]
		public function get newCaseNo():String{ return this._newCaseNo; }
		public function set newCaseNo(value:String):void { this._newCaseNo=value; }
		
		public function newAbleCheck(obj:Object):void{
			var caseNo:String = obj as String;
			if(caseNo.length > 0){
				newAble = true;
			}else{
				newAble = false;
			}
		}
		public function doNew():void
		{
			var caseNoCheck:Boolean = checkRegCaseNumber(newCaseNo);
			if(!caseNoCheck){
				ValidateUtil.showValidationMessages(errorBoxId);
			}else{
				resetValidation();
				var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
				maintainRequestVO.func.courtLevelTypeCode = courtLvlType;
				maintainRequestVO.caseNo = newCaseNo;
				maintainRequestVO.errorBoxComponentId = errorBoxId;
				dispatchEvent(SvdReqEvent.createOutMaintainRequestEvent(maintainRequestVO));
			}
		}
		
		public function resetValidation():void
		{
			ValidationUtil.clearValidationMessage(errorBoxId);
		}
		
		private var errorBoxId:String;
		
		private const PATTERN_CASE_NO:RegExp = /^([a-zA-Z]{2})([a-zA-Z]{1,2})\s*(\d{1,6})\s*\/\s*(\d{1,4})$/;
		private function checkRegCaseNumber(inputCaseNo:String):Boolean
		{
			var result:Boolean = false;
			var caseNoBox:String = "CaseNoNew";
			if (inputCaseNo != null && inputCaseNo != ""){
				
				var pattern:RegExp = PATTERN_CASE_NO;
				if (pattern.test(inputCaseNo))
				{
					var formatedCaseNumber:Object = pattern.exec(inputCaseNo);
					
					var caseYr:String = formatedCaseNumber[4];
					if (caseYr != null && caseYr.length < 4)
					{
						var year:int = int(caseYr);
						caseYr = (2000 + year).toString();
					}
					
					var courtCode:String = (formatedCaseNumber[1] as String).toUpperCase();
					var caseType:String = (formatedCaseNumber[2] as String).toUpperCase();
					
					var correctCaseNo:String = courtCode + caseType + " " + int(formatedCaseNumber[3]) + "/" + caseYr;
					newCaseNo = correctCaseNo;
					
					result = true;
				}
				
			}else{
				result = true;
			}
			if(!result)
			{
				ValidateUtil.addValidationMessage(MessageConstant.CASE_NO_FORMAT, caseNoBox, errorBoxId);
			}
			return result;
		}
		
		private function isNumber(sValue:String):Boolean
		{
			var iValue:int = int( sValue );
			return (iValue.toString() == sValue);
		}
		
	}
}
