package hk.judiciary.icmssvd.view.exeReq.presentation
{
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import hk.judiciary.fmk.view.component.MessageHandler;
	import hk.judiciary.fmk.web.infrastructure.ContextController;
	import hk.judiciary.fmk.web.infrastructure.IModuleController;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.presentation.OpenFunction;
	import hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO;
	import hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultReasonVO;
	import hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultStatusVO;
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.HkDistrictVO;
	import hk.judiciary.icmssvd.view.common.vo.HkRegionVO;
	import hk.judiciary.icmssvd.view.common.vo.IdVO;
	import hk.judiciary.icmssvd.view.common.vo.OpenFunctionParameterVO;
	import hk.judiciary.icmssvd.view.exeReq.event.ExeReqEvent;
	import hk.judiciary.icmssvd.view.exeReq.vo.ExecutionRequestDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	
	import org.granite.tide.events.TideResultEvent;

	public class ExeReqPresenter extends EventDispatcher
	{
		[Inject]
		public var contextController:ContextController;
		
		[Inject]
		public var enquireExeReqFormPanelPM:EnquireExeReqFormPanelPM;
		
		[Inject]
		public var inputExeReqPanelPM:InputExeReqPanelPM;
		
		[Inject]
		public var moduleController:IModuleController;
		
		private var func:FunctionVO;
		
		private var executionRequestDetailVO:ExecutionRequestDetailVO;
		
		
		//=============================================Enquiry Start=============================================================
		[MessageHandler(selector="initSearchParams", scope="local")]
		public function initSearchParams(event:ExeReqEvent):void
		{
			func = event.functionVO;
			contextController.context.svdReq.getCompsCourt(event.functionVO,getCompsCourtResultHandler);
			contextController.context.svdReq.getCaseType(event.functionVO,getCaseTypeResultHandler);
			contextController.context.svdReq.getRequestStatusType(getRequestStatusTypeResultHandler);
		}
		
		private function getCompsCourtResultHandler(evt:TideResultEvent):void{
			enquireExeReqFormPanelPM.comprisingCourtVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
			var compsCourtList:ArrayCollection = evt.result as ArrayCollection;
			if(compsCourtList != null){
				for each(var compsCourt:ComprisingCourtVO in compsCourtList){
					compsCourt.comprisingCourtName = compsCourt.comprisingCourtCode + "-" + compsCourt.comprisingCourtName;
					enquireExeReqFormPanelPM.comprisingCourtVOs.addItem(compsCourt);
				}
				if(compsCourtList.length > 1){
					var emptyCompsCourt:ComprisingCourtVO = new ComprisingCourtVO;
					emptyCompsCourt.comprisingCourtName = SvdReqConstant.ALL;
					enquireExeReqFormPanelPM.selectComprisingCourt = emptyCompsCourt.comprisingCourtName;
					enquireExeReqFormPanelPM.comprisingCourtVOs.addItem(emptyCompsCourt);
				}else if(compsCourtList.length == 1){
					enquireExeReqFormPanelPM.executionRequestSearchVO.comprisingCourt = compsCourtList[0];
					enquireExeReqFormPanelPM.selectComprisingCourt = enquireExeReqFormPanelPM.comprisingCourtVOs[0].comprisingCourtName;
				}
			}
		}
		private function getCaseTypeResultHandler(evt:TideResultEvent):void{
			enquireExeReqFormPanelPM.caseTypeVOs.removeAll();
			var caseTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(caseTypeList != null){
				for each(var caseType:CaseTypeVO in caseTypeList){
					caseType.caseTypeName = caseType.caseTypeCode + '-' + caseType.caseTypeName;
					enquireExeReqFormPanelPM.caseTypeVOs.addItem(caseType);
				}
				if(caseTypeList.length > 1){
					var emptyCaseTypeVO:CaseTypeVO = new CaseTypeVO;
					emptyCaseTypeVO.caseTypeName = SvdReqConstant.ALL;
					enquireExeReqFormPanelPM.selectCaseType = emptyCaseTypeVO.caseTypeName;
					enquireExeReqFormPanelPM.caseTypeVOs.addItem(emptyCaseTypeVO);
				}else if(caseTypeList.length == 1){
					enquireExeReqFormPanelPM.executionRequestSearchVO.caseType = enquireExeReqFormPanelPM.caseTypeVOs[0];
					enquireExeReqFormPanelPM.selectCaseType = enquireExeReqFormPanelPM.caseTypeVOs[0].caseTypeName;
				}
			}
		}
		private function getRequestStatusTypeResultHandler(evt:TideResultEvent):void{
			enquireExeReqFormPanelPM.requestStatusTypeVOs.removeAll();
			enquireExeReqFormPanelPM.requestStatusTypeVOs = evt.result as ArrayCollection;
			enquireExeReqFormPanelPM.displayRequestStatusType();
		}

		[MessageHandler(selector="searchExecutionRequestList", scope="local")]
		public function searchExecutionRequestList(event:ExeReqEvent):void{
			contextController.context.exeReq.searchExecutionRequestList(event.executionRequestSearchVO,searchExecutionRequestListResultHandler);
		}
		private function searchExecutionRequestListResultHandler(evt:TideResultEvent):void
		{
			enquireExeReqFormPanelPM.showSearchResult(evt.result as ArrayCollection);
		}
		
		[MessageHandler(selector="maintainExecutionRequest", scope="local")]
		public function maintainExecutionRequest(event:ExeReqEvent):void {
			contextController.context.exeReq.maintainExecutionRequest(event.maintainRequestVO,maintainRequestHandler);
		}
		private function maintainRequestHandler(evt:TideResultEvent):void
		{
			var returnVal:ExecutionRequestDetailVO = evt.result as ExecutionRequestDetailVO;
			if(returnVal != null){
				var inputPageId:String = SvdReqConstant.EXECUTION_DETAIL_FUNCTION_ID;

				var exeSevResult:OpenFunctionParameterVO = new OpenFunctionParameterVO;
				exeSevResult.name = SvdReqConstant.EXECUTION_REQUEST_DETAIL;
				exeSevResult.value = returnVal;
				
				var parameterList:ArrayCollection = new ArrayCollection;
				parameterList.addItem(exeSevResult);
				
				OpenFunction.openFunction(moduleController, inputPageId, parameterList);
			}
		}
		//=============================================Enquiry End=============================================================
		
		[MessageHandler(selector="formRequest", scope="local")]
		public function formRequest(event:ExeReqEvent):void {
			func = event.functionVO;
			inputExeReqPanelPM.toExecutionRequestDetailVO(event.executionRequestDetailVO);
		}
		
		[MessageHandler(selector="saveDraftExecutionRequest", scope="local")]
		public function saveDraftExecutionRequest(event:ExeReqEvent):void {
			func = event.executionRequestDetailVO.func;
			contextController.context.exeReq.saveDraftExecutionRequest(event.executionRequestDetailVO,saveDraftExecutionRequestHandler);
		}
		private function saveDraftExecutionRequestHandler(evt:TideResultEvent):void{
			var returnVal:IdVO = evt.result as IdVO;
			if(returnVal.id != 0){
				refresh(returnVal.id);
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SAVE_DRAFT, null, null);
//				Alert.show("Save draft successfully!");
			}
		}
		
		[MessageHandler(selector="submitExecutionRequest", scope="local")]
		public function submitExecutionRequest(event:ExeReqEvent):void {
			func = event.executionRequestDetailVO.func;
			contextController.context.exeReq.submitExecutionRequest(event.executionRequestDetailVO,submitExecutionRequestHandler);
		}
		private function submitExecutionRequestHandler(evt:TideResultEvent):void
		{
			var returnVal:IdVO = evt.result as IdVO;
			if(returnVal.id != 0){
				refresh(returnVal.id);
//				Alert.show("Submit successfully!");
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SUBMIT, null, null);
			}
		}
		
		[MessageHandler(selector="withdrawExecutionRequest", scope="local")]
		public function withdrawExecutionRequest(event:ExeReqEvent):void {
			func = event.executionRequestDetailVO.func;
			contextController.context.exeReq.withdrawExecutionRequest(event.executionRequestDetailVO,withdrawExecutionRequestHandler);
		}
		private function withdrawExecutionRequestHandler(evt:TideResultEvent):void{
			var returnVal:IdVO = evt.result as IdVO;
			if(returnVal.id != 0){
				refresh(returnVal.id);
//				Alert.show("Withdraw successfully!");
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_WITHDRAW, null, null);
			}
		}
		
		private function refresh(reqsId:int):void{
			var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
			maintainRequestVO.func = func;
			maintainRequestVO.requestId = reqsId;
			contextController.context.exeReq.maintainExecutionRequest(maintainRequestVO,maintainHandler);
		}
		private function maintainHandler(evt:TideResultEvent):void{
			var returnVal:ExecutionRequestDetailVO = evt.result as ExecutionRequestDetailVO;
			inputExeReqPanelPM.toExecutionRequestDetailVO(returnVal);
		}
		
		//=============================================Input(Execution Request) Start=============================================================
		[MessageHandler(selector="initInputParams", scope="local")]
		public function initInputParams(event:ExeReqEvent):void
		{
			func = event.functionVO;
			executionRequestDetailVO = event.executionRequestDetailVO;
			contextController.context.svdReq.getHkRegion(getHkRegionResultHandler);
			contextController.context.svdReq.getHkDistrict(getHkDistrictResultHandler);
			contextController.context.svdReq.getBailiffOffice(getBailiffOfficeResultHandler);
			contextController.context.svdReq.getDocumentTypeList(event.functionVO,getDocumentTypeResultHandler);
		}
		
		private function getHkDistrictResultHandler(evt:TideResultEvent):void{
			inputExeReqPanelPM.hkDistrictVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HkDistrictVO")]
			var hkDistrictVOList:ArrayCollection = evt.result as ArrayCollection;
			if(hkDistrictVOList != null){
				inputExeReqPanelPM.hkDistrictVOs.addItem(new HkDistrictVO());
				inputExeReqPanelPM.hkDistrictVOs.addAll(hkDistrictVOList);
			}
			if(executionRequestDetailVO.requestAddress.hkRegion != null){
				inputExeReqPanelPM.displayHkDistrictVOs.removeAll();
				inputExeReqPanelPM.displayHkDistrictVOs.addItem(new HkDistrictVO());
				if(hkDistrictVOList.length > 0){
					for each(var dis:HkDistrictVO in hkDistrictVOList){
						if(dis.hkRegion != null && dis.hkRegion.hkRegionId == executionRequestDetailVO.requestAddress.hkRegion.hkRegionId){
							inputExeReqPanelPM.displayHkDistrictVOs.addItem(dis);
						}
					}
				}
			}
		}
		private function getBailiffOfficeResultHandler(evt:TideResultEvent):void{
			inputExeReqPanelPM.bailiffOfficeVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO")]
			var bailiffOfficeList:ArrayCollection = evt.result as ArrayCollection;
			inputExeReqPanelPM.bailiffOfficeVOs = bailiffOfficeList;
		}
		private function getDocumentTypeResultHandler(evt:TideResultEvent):void{
			inputExeReqPanelPM.documentTypeVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO")]
			var documentTypeList:ArrayCollection = evt.result as ArrayCollection;
			inputExeReqPanelPM.documentTypeVOs.addItem(new DocumentTypeVO);
			inputExeReqPanelPM.documentTypeVOs.addAll(documentTypeList);
		}
		private function getHkRegionResultHandler(evt:TideResultEvent):void{
			inputExeReqPanelPM.hkRegionVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HkRegionVO")]
			var hkRegionVOList:ArrayCollection = evt.result as ArrayCollection;
			if(hkRegionVOList != null){
				inputExeReqPanelPM.hkRegionVOs = hkRegionVOList;
				if(executionRequestDetailVO.requestAddress.hkRegion == null){
					for each(var defaultHkRegion:HkRegionVO in hkRegionVOList){
						if(defaultHkRegion.hkRegionName == SvdReqConstant.HONG_KONG_ISLAND){
							executionRequestDetailVO.requestAddress.hkRegion = defaultHkRegion;
							inputExeReqPanelPM.executionRequestDetailVO.requestAddress.hkRegion = defaultHkRegion;
							inputExeReqPanelPM.hkRegionName = defaultHkRegion.hkRegionName;
							break;
						}
					}
				}
			}	
		}
		
		//=============================================Input(Execution Request) End=============================================================
		
		//=============================================Input(Execution Result) Start=============================================================
		[MessageHandler(selector="initResultParams", scope="local")]
		public function initResultParams(event:ExeReqEvent):void{
			func = event.functionVO;
			contextController.context.svdReq.getBailiffTaskResultStatusList(getBailiffTaskResultStatusResultHandler);
			contextController.context.svdReq.getBailiffTaskResultReasonList(getBailiffTaskResultReasonResultHandler);
		}
		
		private function getBailiffTaskResultStatusResultHandler(evt:TideResultEvent):void{
			inputExeReqPanelPM.bailiffTaskResultStatusVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultStatusVO")]
			var bailiffTaskResultStatusList:ArrayCollection = new ArrayCollection;
			bailiffTaskResultStatusList = evt.result as ArrayCollection;
			inputExeReqPanelPM.bailiffTaskResultStatusVOs.addItem(new BailiffTaskResultStatusVO);
			inputExeReqPanelPM.bailiffTaskResultStatusVOs.addAll(bailiffTaskResultStatusList);
		}
		private function getBailiffTaskResultReasonResultHandler(evt:TideResultEvent):void{
			inputExeReqPanelPM.bailiffTaskResultReasonVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultReasonVO")]
			var bailiffTaskResultReasonList:ArrayCollection = new ArrayCollection;
			bailiffTaskResultReasonList = evt.result as ArrayCollection;
			inputExeReqPanelPM.bailiffTaskResultReasonVOs.addItem(new BailiffTaskResultReasonVO);
			inputExeReqPanelPM.bailiffTaskResultReasonVOs.addAll(bailiffTaskResultReasonList);
		}
		//=============================================Input(Execution Result) End=============================================================
		[MessageHandler(selector="downloadDocFile", scope="local")]
		public function downloadDocFile(event:ExeReqEvent):void {
			contextController.context.svdReq.downloadDocFile(event.documentFileVO,downloadDocFileHandler);
		}
		private function downloadDocFileHandler(evt:TideResultEvent):void
		{
			var returnVal:BaseVO = evt.result as BaseVO;
			if(returnVal == null){
//				Alert.show("The copy of the file has not yet uploaded!");
				MessageHandler.createWarningMessageBox(MessageConstant.MSG_NO_FILE_UPLOADED, null, null);
			}
		}
	}
	
}