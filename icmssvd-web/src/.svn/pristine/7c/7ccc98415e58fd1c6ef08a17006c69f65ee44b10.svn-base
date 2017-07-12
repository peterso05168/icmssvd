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
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.FpApplicationNatureTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.OpenFunctionParameterVO;
	import hk.judiciary.icmssvd.view.common.vo.ProsecutionDepartmentVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.ReServEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestDetailVO;
	
	import org.granite.tide.events.TideResultEvent;

	public class ReServPresenter extends EventDispatcher
	{
		[Inject]
		public var contextController:ContextController;
		
		[Inject]
		public var enquireReServiceFormPanelPM:EnquireReServiceFormPanelPM;
		
		[Inject]
		public var moduleController:IModuleController;
		
		private var func:FunctionVO;
		
		//=============================================Enquiry Start=============================================================
		[MessageHandler(selector="initSearchParams", scope="local")]
		public function initSearchParams(event:ReServEvent):void
		{
			func = event.functionVO;
			contextController.context.svdReq.getCompsCourt(event.functionVO,getCompsCourtResultHandler);
			contextController.context.svdReq.getCourtRoomChambers(getCourtRoomChambersResultHandler);
			contextController.context.svdReq.getSummonsCaseTypeList(event.functionVO,getCaseTypeResultHandler);
			contextController.context.svdReq.getFpAppNatTypeList(getFpAppNatTypeListResultHandler);
			contextController.context.svdReq.getProsecutionDepartmentList(getProsecutionDepartmentListResultHandler);
			contextController.context.svdReq.getServiceModeType(getServiceModeTypeResultHandler);
			contextController.context.svdReq.getHandlingAgent(event.functionVO,getHandlingAgentResultHandler);
			contextController.context.svdReq.getBailiffOffice(getBailiffOfficeResultHandler);
		}
		
		private function getCompsCourtResultHandler(evt:TideResultEvent):void{
			enquireReServiceFormPanelPM.comprisingCourtVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
			var compsCourtList:ArrayCollection = evt.result as ArrayCollection;
			if(compsCourtList != null){
				for each(var compsCourt:ComprisingCourtVO in compsCourtList){
					compsCourt.comprisingCourtName = compsCourt.comprisingCourtCode + "-" + compsCourt.comprisingCourtName;
					enquireReServiceFormPanelPM.comprisingCourtVOs.addItem(compsCourt);
				}
			}
		}
		
		private function getCourtRoomChambersResultHandler(evt:TideResultEvent):void{
			enquireReServiceFormPanelPM.courtNumberVOs.removeAll();
			var courtNumberList:ArrayCollection = evt.result as ArrayCollection;
			if(courtNumberList != null){
				enquireReServiceFormPanelPM.courtNumberVOs = courtNumberList;
			}
		}
		private function getCaseTypeResultHandler(evt:TideResultEvent):void{
			enquireReServiceFormPanelPM.caseTypeVOs.removeAll();
			var caseTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(caseTypeList != null){
				for each(var caseType:CaseTypeVO in caseTypeList){
					caseType.caseTypeName = caseType.caseTypeCode + '-' + caseType.caseTypeName;
					enquireReServiceFormPanelPM.caseTypeVOs.addItem(caseType);
				}
				if(caseTypeList.length > 1){
					var emptyCaseTypeVO:CaseTypeVO = new CaseTypeVO;
					emptyCaseTypeVO.caseTypeName = SvdReqConstant.ALL;
					enquireReServiceFormPanelPM.selectCaseType = emptyCaseTypeVO.caseTypeName;
					enquireReServiceFormPanelPM.caseTypeVOs.addItem(emptyCaseTypeVO);
				}else if(caseTypeList.length == 1){
					enquireReServiceFormPanelPM.batchSearchVO.caseType = enquireReServiceFormPanelPM.caseTypeVOs[0];
					enquireReServiceFormPanelPM.selectCaseType = enquireReServiceFormPanelPM.caseTypeVOs[0].caseTypeName;
				}
			}
		}
		
		private function getFpAppNatTypeListResultHandler(evt:TideResultEvent):void{
			enquireReServiceFormPanelPM.fpApplicationNatureTypeVOs.removeAll();
			var fpApplicationNatureTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(fpApplicationNatureTypeList != null){
				for each(var fpApplicationNatureType:FpApplicationNatureTypeVO in fpApplicationNatureTypeList){
					fpApplicationNatureType.englishFpApplicationNatureTypeName = fpApplicationNatureType.fpApplicationNatureCode + '-' + fpApplicationNatureType.englishFpApplicationNatureTypeName;
					enquireReServiceFormPanelPM.fpApplicationNatureTypeVOs.addItem(fpApplicationNatureType);
				}
				if(fpApplicationNatureTypeList.length > 1){
					var emptyFpApplicationNatureTypeVO:FpApplicationNatureTypeVO = new FpApplicationNatureTypeVO;
					emptyFpApplicationNatureTypeVO.englishFpApplicationNatureTypeName = SvdReqConstant.ALL;
					enquireReServiceFormPanelPM.selectApplicationNat = emptyFpApplicationNatureTypeVO.englishFpApplicationNatureTypeName;
					enquireReServiceFormPanelPM.fpApplicationNatureTypeVOs.addItem(emptyFpApplicationNatureTypeVO);
				}else if(fpApplicationNatureTypeList.length == 1){
					enquireReServiceFormPanelPM.batchSearchVO.fpApplicationNatureType = enquireReServiceFormPanelPM.fpApplicationNatureTypeVOs[0];
					enquireReServiceFormPanelPM.selectApplicationNat = enquireReServiceFormPanelPM.fpApplicationNatureTypeVOs[0].fpApplicationNatureName;
				}
			}
		}
		
		private function getProsecutionDepartmentListResultHandler(evt:TideResultEvent):void{
			enquireReServiceFormPanelPM.prosecutionDepartmentVOs.removeAll();
			var prosecutionDepartmentList:ArrayCollection = evt.result as ArrayCollection;
			if(prosecutionDepartmentList != null){
				for each(var prosecutionDepartment:ProsecutionDepartmentVO in prosecutionDepartmentList){
					prosecutionDepartment.prosecutionDepartmentName = prosecutionDepartment.prosecutionDepartmentCode + '-' + prosecutionDepartment.prosecutionDepartmentName;
					enquireReServiceFormPanelPM.prosecutionDepartmentVOs.addItem(prosecutionDepartment);
				}
				if(prosecutionDepartmentList.length > 1){
					var emptyProsecutionDepartmentVO:ProsecutionDepartmentVO = new ProsecutionDepartmentVO;
					emptyProsecutionDepartmentVO.prosecutionDepartmentName = SvdReqConstant.ALL;
					enquireReServiceFormPanelPM.selectProsecution = emptyProsecutionDepartmentVO.prosecutionDepartmentName;
					enquireReServiceFormPanelPM.prosecutionDepartmentVOs.addItem(emptyProsecutionDepartmentVO);
				}else if(prosecutionDepartmentList.length == 1){
					enquireReServiceFormPanelPM.batchSearchVO.prosecutionDepartment = enquireReServiceFormPanelPM.prosecutionDepartmentVOs[0];
					enquireReServiceFormPanelPM.selectProsecution = enquireReServiceFormPanelPM.prosecutionDepartmentVOs[0].prosecutionDepartmentName;
				}
			}
		}
		private function getServiceModeTypeResultHandler(evt:TideResultEvent):void{
			enquireReServiceFormPanelPM.serviceModeTypeVOs.removeAll();
			var serviceModeList:ArrayCollection = evt.result as ArrayCollection;
			enquireReServiceFormPanelPM.serviceModeTypeVOs = serviceModeList;
		}
		private function getHandlingAgentResultHandler(evt:TideResultEvent):void{
			enquireReServiceFormPanelPM.handlingAgentVOs.removeAll();
			var hanglingAgentList:ArrayCollection = evt.result as ArrayCollection;
			enquireReServiceFormPanelPM.handlingAgentVOs = hanglingAgentList;
		}
		private function getBailiffOfficeResultHandler(evt:TideResultEvent):void{
			enquireReServiceFormPanelPM.bailiffOfficeVOs.removeAll();
			var bailiffOfficeList:ArrayCollection = evt.result as ArrayCollection;
			enquireReServiceFormPanelPM.bailiffOfficeVOs = bailiffOfficeList;
		}

		[MessageHandler(selector="searchAbsentDefenantsList", scope="local")]
		public function searchAbsentDefenantsList(event:ReServEvent):void{
			contextController.context.svdReq.searchReserviceBatchList(event.batchSearchVO, searchAbsentDefenantsListResultHandler);
		}
		private function searchAbsentDefenantsListResultHandler(evt:TideResultEvent):void
		{
			enquireReServiceFormPanelPM.showSearchResult(evt.result as ArrayCollection);
		}
		
		[MessageHandler(selector="reGenDefHrnDate", scope="local")]
		public function reGenDefHrnDate(event:ReServEvent):void{
			contextController.context.svdReq.generateNextHearingDate(event.selecteResultVOs, int(enquireReServiceFormPanelPM.overridDays), reGenDefHrnDateResultHandler);
		}
		private function reGenDefHrnDateResultHandler(evt:TideResultEvent):void
		{
			var returnVal:ArrayCollection = evt.result as ArrayCollection;
			enquireReServiceFormPanelPM.refreshReGenDefHrn(returnVal);
		}
		
		[MessageHandler(selector="confirmHearingSchedule", scope="local")]
		public function confirmHearingSchedule(event:ReServEvent):void{
			contextController.context.svdReq.confirmHearingSchedule(event.selecteResultVOs, confirmHearingScheduleResultHandler);
		}
		private function confirmHearingScheduleResultHandler(evt:TideResultEvent):void
		{
			enquireReServiceFormPanelPM.refreshResult();
		}
		
		[MessageHandler(selector="maintainRequest", scope="local")]
		public function maintainRequest(event:ReServEvent):void {
			contextController.context.svdReq.maintainRequest(event.maintainRequestVO,maintainRequestHandler);
		}
		private function maintainRequestHandler(evt:TideResultEvent):void
		{
			var returnVal:ServiceRequestDetailVO = evt.result as ServiceRequestDetailVO;
			if(returnVal != null){
				var inputPageId:String;
				if(returnVal.func.courtLevelTypeCode == SvdReqConstant.COURT_LEVEL_TYPE_DISTRICT){
					inputPageId = SvdReqConstant.DC_DETAIL_FUNCTION_ID;
				}else{
					inputPageId = SvdReqConstant.MC_DETAIL_FUNCTION_ID;
				}
				
				var sevDocResult:OpenFunctionParameterVO = new OpenFunctionParameterVO;
				sevDocResult.name = SvdReqConstant.SERVICE_REQUEST_DETAIL;
				sevDocResult.value = returnVal;
				
				var parameterList:ArrayCollection = new ArrayCollection;
				parameterList.addItem(sevDocResult);
				
				OpenFunction.openFunction(moduleController, inputPageId, parameterList);
			}
		}
		
		[MessageHandler(selector="generateCertificateBulkPosting", scope="local")]
		public function generateCertificateBulkPosting(event:ReServEvent):void{
			contextController.context.svdReq.generateCertificateBulkPosting(event.certifcateBulkPostingVO, generateCertificateBulkPostingResultHandler);
		}
		private function generateCertificateBulkPostingResultHandler(evt:TideResultEvent):void
		{
		}
		
		[MessageHandler(selector="saveDraftAndGenDoc", scope="local")]
		public function saveDraftAndGenDoc(event:ReServEvent):void{
			contextController.context.svdReq.saveDraftReserviceRequestAndGenerateDocuments(event.selecteResultVOs, saveDraftAndGenDocResultHandler);
		}
		private function saveDraftAndGenDocResultHandler(evt:TideResultEvent):void
		{
			var returnVal:ArrayCollection = evt.result as ArrayCollection;
			contextController.context.svdReq.maintainReserviceRequests(returnVal, maintainReserviceRequestsResultHandler);
//			Alert.show("Generate Documents And Draft Re-Service Request Successful.");
			MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_GENERATE_DOC_AND_DRAFT_RESERVICE, null, null);
		}
		
		[MessageHandler(selector="saveDraftReserviceRequest", scope="local")]
		public function saveDraftReserviceRequest(event:ReServEvent):void{
			contextController.context.svdReq.saveDraftReserviceRequest(event.selecteResultVOs, saveDraftReserviceRequestResultHandler);
		}
		private function saveDraftReserviceRequestResultHandler(evt:TideResultEvent):void
		{
			var returnVal:ArrayCollection = evt.result as ArrayCollection;
			contextController.context.svdReq.maintainReserviceRequests(returnVal, maintainReserviceRequestsResultHandler);
//			Alert.show("Save Draft Request Successful.");
			MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SAVE_DRAFT, null, null);
		}
		
		[MessageHandler(selector="submitReserviceRequest", scope="local")]
		public function submitReserviceRequest(event:ReServEvent):void{
			contextController.context.svdReq.submitReserviceRequest(event.selecteResultVOs, submitReserviceRequestResultHandler);
		}
		private function submitReserviceRequestResultHandler(evt:TideResultEvent):void
		{
			var returnVal:ArrayCollection = evt.result as ArrayCollection;
			contextController.context.svdReq.maintainReserviceRequests(returnVal, maintainReserviceRequestsResultHandler);
//			Alert.show("Submit Re-Service Request Successful.");
			MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SUBMIT_RESERVICE, null, null);
		}
		
		private function maintainReserviceRequestsResultHandler(evt:TideResultEvent):void
		{
			enquireReServiceFormPanelPM.refreshResult();
		}
		
		//=============================================Enquiry End=============================================================
	}
	
}