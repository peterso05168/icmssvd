package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import hk.judiciary.fmk.view.component.MessageHandler;
	import hk.judiciary.fmk.web.infrastructure.ContextController;
	import hk.judiciary.fmk.web.infrastructure.IModuleController;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.presentation.OpenFunction;
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.FpApplicationNatureTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.IdVO;
	import hk.judiciary.icmssvd.view.common.vo.OpenFunctionParameterVO;
	import hk.judiciary.icmssvd.view.common.vo.ProsecutionDepartmentVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.ProofEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.BatchSearchVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestDetailVO;
	
	import org.granite.tide.events.TideResultEvent;
	
	[Event(name="searchPosRequestBatchList", type="hk.judiciary.icmssvd.view.svdReq.event.ProofEvent")]
	
	[ManagedEvents("searchPosRequestBatchList", scope="local")]
	public class ProofPresenter extends EventDispatcher
	{
		[Inject]
		public var contextController:ContextController;
		
		[Inject]
		public var moduleController:IModuleController;
		
		[Inject]
		public var enquireProofOfSvdPanelPM:EnquireProofOfSvdPanelPM;
		
		[Inject]
		public var inputProofPanelPM:InputProofPanelPM;
		
		[Inject]
		public var enquireProofOfSvdBatchFormPanelPM:EnquireProofOfSvdBatchFormPanelPM;
		
		private var func:FunctionVO;
		
		private var batchSearchVO:BatchSearchVO;

		[MessageHandler(selector="initSearchParams", scope="local")]
		public function initSearchParams(event:ProofEvent):void
		{
			func = event.functionVO;
			contextController.context.svdReq.getCompsCourt(event.functionVO,getCompsCourtResultHandler);
			contextController.context.svdReq.getCaseType(event.functionVO,getCaseTypeResultHandler);
			contextController.context.svdReq.getHandlingAgent(event.functionVO,getHandlingAgentResultHandler);
		}
		
		private function getCompsCourtResultHandler(evt:TideResultEvent):void{
			enquireProofOfSvdPanelPM.comprisingCourtVOs.removeAll();
			var compsCourtList:ArrayCollection = evt.result as ArrayCollection;
			if(compsCourtList != null){
				for each(var compsCourt:ComprisingCourtVO in compsCourtList){
					compsCourt.comprisingCourtName = compsCourt.comprisingCourtCode + "-" + compsCourt.comprisingCourtName;
					enquireProofOfSvdPanelPM.comprisingCourtVOs.addItem(compsCourt);
				}
				if(compsCourtList.length > 1){
					var emptyCompsCourt:ComprisingCourtVO = new ComprisingCourtVO;
					emptyCompsCourt.comprisingCourtName = SvdReqConstant.ALL;
					enquireProofOfSvdPanelPM.selectComprisingCourt = emptyCompsCourt.comprisingCourtName;
					enquireProofOfSvdPanelPM.comprisingCourtVOs.addItem(emptyCompsCourt);
				}else if(compsCourtList.length == 1){
					enquireProofOfSvdPanelPM.posRequestSearchVO.comprisingCourt = compsCourtList[0];
					enquireProofOfSvdPanelPM.selectComprisingCourt = enquireProofOfSvdPanelPM.comprisingCourtVOs[0].comprisingCourtName;
				}
			}
		}
		private function getCaseTypeResultHandler(evt:TideResultEvent):void{
			enquireProofOfSvdPanelPM.caseTypeVOs.removeAll();
			var caseTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(caseTypeList != null){
				enquireProofOfSvdPanelPM.caseTypeVOs = caseTypeList;
				if(caseTypeList.length > 1){
					var emptyCaseTypeVO:CaseTypeVO = new CaseTypeVO;
					emptyCaseTypeVO.caseTypeName = SvdReqConstant.ALL;
					enquireProofOfSvdPanelPM.selectCaseType = emptyCaseTypeVO.caseTypeName;
					enquireProofOfSvdPanelPM.caseTypeVOs.addItem(emptyCaseTypeVO);
				}else if(caseTypeList.length == 1){
					enquireProofOfSvdPanelPM.posRequestSearchVO.caseType = caseTypeList[0];
					enquireProofOfSvdPanelPM.selectCaseType = caseTypeList[0].caseTypeName;
				}
			}
		}
		private function getHandlingAgentResultHandler(evt:TideResultEvent):void{
			enquireProofOfSvdPanelPM.handlingAgentVOs.removeAll();
			var hanglingAgentList:ArrayCollection = evt.result as ArrayCollection;
			if(hanglingAgentList != null){
				enquireProofOfSvdPanelPM.handlingAgentVOs = hanglingAgentList;
				if(hanglingAgentList.length > 1){
					var emptyHandlingAgent:HandlingAgentVO = new HandlingAgentVO;
					emptyHandlingAgent.handlingAgentName = SvdReqConstant.ALL;
					enquireProofOfSvdPanelPM.selectHandlingAgent = emptyHandlingAgent.handlingAgentName;
					enquireProofOfSvdPanelPM.handlingAgentVOs.addItem(emptyHandlingAgent);
				}else if(hanglingAgentList.length == 1){
					enquireProofOfSvdPanelPM.posRequestSearchVO.handlingAgent = hanglingAgentList[0];
					enquireProofOfSvdPanelPM.selectHandlingAgent = hanglingAgentList[0].handlingAgentName;
				}
			}
		}
		
		[MessageHandler(selector="searchProofOfSevList", scope="local")]
		public function searchProofOfSevList(event:ProofEvent):void{
			contextController.context.svdReq.searchPosRequestList(event.posRequestSearchVO,searchProofOfSevListResultHandler);
		}
		private function searchProofOfSevListResultHandler(evt:TideResultEvent):void
		{
			enquireProofOfSvdPanelPM.showSearchResult(evt.result as ArrayCollection);
		}
		
		[MessageHandler(selector="maintainPosRequest", scope="local")]
		public function maintainPosRequest(event:ProofEvent):void {
			contextController.context.svdReq.maintainPosRequest(event.maintainRequestVO,maintainPosRequestHandler);
		}
		private function maintainPosRequestHandler(evt:TideResultEvent):void
		{
			var returnVal:PosRequestDetailVO = evt.result as PosRequestDetailVO;
			if(returnVal != null){
				var inputPageId:String;
				if(returnVal.func.courtLevelTypeCode == SvdReqConstant.COURT_LEVEL_TYPE_DISTRICT){
					inputPageId = SvdReqConstant.DC_PROOF_DETAIL_FUNCTION_ID;
				}else{
					inputPageId = SvdReqConstant.MC_PROOF_DETAIL_FUNCTION_ID;
				}
				var posReqResult:OpenFunctionParameterVO = new OpenFunctionParameterVO;
				posReqResult.name = SvdReqConstant.POS_REQUEST_DETAIL;
				posReqResult.value = returnVal;
				
				var parameterList:ArrayCollection = new ArrayCollection;
				parameterList.addItem(posReqResult);
				
				OpenFunction.openFunction(moduleController, inputPageId, parameterList);
			}
		}
		
		[MessageHandler(selector="formProof", scope="local")]
		public function formProof(event:ProofEvent):void {
			func = event.functionVO;
			inputProofPanelPM.toProofRecord(event.posRequestDetailVO);
		}
		
		[MessageHandler(selector="initInputParams", scope="local")]
		public function initInputParams(event:ProofEvent):void
		{
			func = event.functionVO;
			contextController.context.svdReq.getPosDocumentTypeList(getPosDocumentTypeListResultHandler);
			contextController.context.svdReq.getCompsCourt(func,getInputCompsCourtResultHandler);
			contextController.context.svdReq.getCourtRoomChambers(getInputCourtRoomChambersResultHandler);
		}
		
		private function getInputCompsCourtResultHandler(evt:TideResultEvent):void{
			inputProofPanelPM.comprisingCourtVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
			var compsCourtList:ArrayCollection = evt.result as ArrayCollection;
			if(compsCourtList != null){
				for each(var compsCourt:ComprisingCourtVO in compsCourtList){
					compsCourt.comprisingCourtName = compsCourt.comprisingCourtCode + "-" + compsCourt.comprisingCourtName;
					inputProofPanelPM.comprisingCourtVOs.addItem(compsCourt);
				}
			}
		}
		
		private function getInputCourtRoomChambersResultHandler(evt:TideResultEvent):void{
			inputProofPanelPM.courtNumberVOs.removeAll();
			var courtNumberList:ArrayCollection = evt.result as ArrayCollection;
			if(courtNumberList != null){
				inputProofPanelPM.courtNumberVOs = courtNumberList;
			}
		}
		
		private function getPosDocumentTypeListResultHandler(evt:TideResultEvent):void{
			inputProofPanelPM.posDocumentTypeVOs.removeAll();
			var posDocumentTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(posDocumentTypeList != null){
				inputProofPanelPM.posDocumentTypeVOs = posDocumentTypeList;
			}
		}
		
		[MessageHandler(selector="submitPosRequest", scope="local")]
		public function submitPosRequest(event:ProofEvent):void {
			func = event.posRequestDetailVO.func;
			contextController.context.svdReq.submitPosRequest(event.posRequestDetailVO,submitPosRequestHandler);
		}
		private function submitPosRequestHandler(evt:TideResultEvent):void
		{
			var returnVal:IdVO = evt.result as IdVO;
			if(returnVal.id != 0){
				refresh(returnVal.id);
//				Alert.show("Submit successfully!");
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SUBMIT, null, null);
			}
		}
		
		private function refresh(reqsId:int):void{
			var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
			maintainRequestVO.func = func;
			maintainRequestVO.requestId = reqsId;
			contextController.context.svdReq.maintainPosRequest(maintainRequestVO,maintainHandler);
		}
		private function maintainHandler(evt:TideResultEvent):void{
			var returnVal:PosRequestDetailVO = evt.result as PosRequestDetailVO;
			inputProofPanelPM.toProofRecord(returnVal);
		}
		
		[MessageHandler(selector="initBatchSearchParams", scope="local")]
		public function initBatchSearchParams(event:ProofEvent):void
		{
			func = event.functionVO;
			contextController.context.svdReq.getCompsCourt(event.functionVO,getBatchCompsCourtResultHandler);
			contextController.context.svdReq.getCourtRoomChambers(getCourtRoomChambersResultHandler);
			contextController.context.svdReq.getCaseType(event.functionVO,getBatchCaseTypeResultHandler);
			contextController.context.svdReq.getFpAppNatTypeList(getFpAppNatTypeListResultHandler);
			contextController.context.svdReq.getProsecutionDepartmentList(getProsecutionDepartmentListResultHandler);
		}
		
		private function getBatchCompsCourtResultHandler(evt:TideResultEvent):void{
			enquireProofOfSvdBatchFormPanelPM.comprisingCourtVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
			var compsCourtList:ArrayCollection = evt.result as ArrayCollection;
			if(compsCourtList != null){
				for each(var compsCourt:ComprisingCourtVO in compsCourtList){
					compsCourt.comprisingCourtName = compsCourt.comprisingCourtCode + "-" + compsCourt.comprisingCourtName;
					enquireProofOfSvdBatchFormPanelPM.comprisingCourtVOs.addItem(compsCourt);
				}
			}
		}
		
		private function getCourtRoomChambersResultHandler(evt:TideResultEvent):void{
			enquireProofOfSvdBatchFormPanelPM.courtNumberVOs.removeAll();
			var courtNumberList:ArrayCollection = evt.result as ArrayCollection;
			if(courtNumberList != null){
				enquireProofOfSvdBatchFormPanelPM.courtNumberVOs = courtNumberList;
			}
		}
		private function getBatchCaseTypeResultHandler(evt:TideResultEvent):void{
			enquireProofOfSvdBatchFormPanelPM.caseTypeVOs.removeAll();
			var caseTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(caseTypeList != null){
				for each(var caseType:CaseTypeVO in caseTypeList){
					caseType.caseTypeName = caseType.caseTypeCode + '-' + caseType.caseTypeName;
					enquireProofOfSvdBatchFormPanelPM.caseTypeVOs.addItem(caseType);
				}
				if(caseTypeList.length > 1){
					var emptyCaseTypeVO:CaseTypeVO = new CaseTypeVO;
					emptyCaseTypeVO.caseTypeName = SvdReqConstant.ALL;
					enquireProofOfSvdBatchFormPanelPM.selectCaseType = emptyCaseTypeVO.caseTypeName;
					enquireProofOfSvdBatchFormPanelPM.caseTypeVOs.addItem(emptyCaseTypeVO);
				}else if(caseTypeList.length == 1){
					enquireProofOfSvdBatchFormPanelPM.batchSearchVO.caseType = enquireProofOfSvdBatchFormPanelPM.caseTypeVOs[0];
					enquireProofOfSvdBatchFormPanelPM.selectCaseType = enquireProofOfSvdBatchFormPanelPM.caseTypeVOs[0].caseTypeName;
				}
			}
		}
		
		private function getFpAppNatTypeListResultHandler(evt:TideResultEvent):void{
			enquireProofOfSvdBatchFormPanelPM.fpApplicationNatureTypeVOs.removeAll();
			var fpApplicationNatureTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(fpApplicationNatureTypeList != null){
				for each(var fpApplicationNatureType:FpApplicationNatureTypeVO in fpApplicationNatureTypeList){
					fpApplicationNatureType.englishFpApplicationNatureTypeName = fpApplicationNatureType.fpApplicationNatureCode + '-' + fpApplicationNatureType.englishFpApplicationNatureTypeName;
					enquireProofOfSvdBatchFormPanelPM.fpApplicationNatureTypeVOs.addItem(fpApplicationNatureType);
				}
				if(fpApplicationNatureTypeList.length > 1){
					var emptyFpApplicationNatureTypeVO:FpApplicationNatureTypeVO = new FpApplicationNatureTypeVO;
					emptyFpApplicationNatureTypeVO.englishFpApplicationNatureTypeName = SvdReqConstant.ALL;
					enquireProofOfSvdBatchFormPanelPM.selectApplicationNat = emptyFpApplicationNatureTypeVO.englishFpApplicationNatureTypeName;
					enquireProofOfSvdBatchFormPanelPM.fpApplicationNatureTypeVOs.addItem(emptyFpApplicationNatureTypeVO);
				}else if(fpApplicationNatureTypeList.length == 1){
					enquireProofOfSvdBatchFormPanelPM.batchSearchVO.fpApplicationNatureType = enquireProofOfSvdBatchFormPanelPM.fpApplicationNatureTypeVOs[0];
					enquireProofOfSvdBatchFormPanelPM.selectApplicationNat = enquireProofOfSvdBatchFormPanelPM.fpApplicationNatureTypeVOs[0].fpApplicationNatureName;
				}
			}
		}
		
		private function getProsecutionDepartmentListResultHandler(evt:TideResultEvent):void{
			enquireProofOfSvdBatchFormPanelPM.prosecutionDepartmentVOs.removeAll();
			var prosecutionDepartmentList:ArrayCollection = evt.result as ArrayCollection;
			if(prosecutionDepartmentList != null){
				for each(var prosecutionDepartment:ProsecutionDepartmentVO in prosecutionDepartmentList){
					prosecutionDepartment.prosecutionDepartmentName = prosecutionDepartment.prosecutionDepartmentCode + '-' + prosecutionDepartment.prosecutionDepartmentName;
					enquireProofOfSvdBatchFormPanelPM.prosecutionDepartmentVOs.addItem(prosecutionDepartment);
				}
				if(prosecutionDepartmentList.length > 1){
					var emptyProsecutionDepartmentVO:ProsecutionDepartmentVO = new ProsecutionDepartmentVO;
					emptyProsecutionDepartmentVO.prosecutionDepartmentName = SvdReqConstant.ALL;
					enquireProofOfSvdBatchFormPanelPM.selectProsecution = emptyProsecutionDepartmentVO.prosecutionDepartmentName;
					enquireProofOfSvdBatchFormPanelPM.prosecutionDepartmentVOs.addItem(emptyProsecutionDepartmentVO);
				}else if(prosecutionDepartmentList.length == 1){
					enquireProofOfSvdBatchFormPanelPM.batchSearchVO.prosecutionDepartment = enquireProofOfSvdBatchFormPanelPM.prosecutionDepartmentVOs[0];
					enquireProofOfSvdBatchFormPanelPM.selectProsecution = enquireProofOfSvdBatchFormPanelPM.prosecutionDepartmentVOs[0].prosecutionDepartmentName;
				}
			}
		}
		
		[MessageHandler(selector="searchPosRequestBatchList", scope="local")]
		public function searchPosRequestBatchList(event:ProofEvent):void{
			batchSearchVO = event.batchSearchVO;
			contextController.context.svdReq.searchPosRequestBatchList(event.batchSearchVO,searchPosRequestBatchListResultHandler);
		}
		private function searchPosRequestBatchListResultHandler(evt:TideResultEvent):void
		{
			enquireProofOfSvdBatchFormPanelPM.showSearchResult(evt.result as ArrayCollection);
		}
		
		[MessageHandler(selector="submitPosRequestList", scope="local")]
		public function submitPosRequestList(event:ProofEvent):void {
			contextController.context.svdReq.submitPosRequestList(event.posRequestDetailVOs,submitPosRequestListHandler);
		}
		private function submitPosRequestListHandler(evt:TideResultEvent):void
		{
			var returnVal:ArrayCollection = evt.result as ArrayCollection;
			var succ:Boolean = true;
			for each(var idVO:IdVO in returnVal){
				if(idVO.id == 0){
					succ = false;
					break;
				}
			}
			if(succ){
//				Alert.show("Submit successfully!");
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SUBMIT, null, null);
				dispatchEvent(ProofEvent.searchPosRequestBatchList(batchSearchVO));
			}
		}
		
		[MessageHandler(selector="downloadDocFile", scope="local")]
		public function downloadDocFile(event:ProofEvent):void {
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