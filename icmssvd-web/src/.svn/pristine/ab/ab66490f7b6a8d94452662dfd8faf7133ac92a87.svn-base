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
	import hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultReasonVO;
	import hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultStatusVO;
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.HkDistrictVO;
	import hk.judiciary.icmssvd.view.common.vo.HkRegionVO;
	import hk.judiciary.icmssvd.view.common.vo.IdVO;
	import hk.judiciary.icmssvd.view.common.vo.IntegerFieldVO;
	import hk.judiciary.icmssvd.view.common.vo.OpenFunctionParameterVO;
	import hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.SvdReqEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentDraftVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DocumentDraftVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DocumentVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestServiceTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestDetailVO;
	
	import org.granite.tide.events.TideResultEvent;
	
	[Event(name="formRequest",
		   type="hk.judiciary.icmssvd.view.svdReq.event.SvdReqEvent")]
	
	[ManagedEvents("formRequest", scope="local")]
	public class SvdReqPresenter extends EventDispatcher
	{
		[Inject]
		public var contextController:ContextController;
		
		[Inject]
		public var enquireSvdReqFormPanelPM:EnquireSvdReqFormPanelPM;
		
		[Inject]
		public var inputSvdReqPanelPM:InputSvdReqPanelPM;
		
		[Inject]
		public var inputSvdReqMainPM:InputSvdReqMainPM;
		
		[Inject]
		public var moduleController:IModuleController;
		
		private var func:FunctionVO;
		
		private var serviceRequestDetailVO:ServiceRequestDetailVO;
		
		
		//=============================================Enquiry Start=============================================================
		[MessageHandler(selector="initSearchParams", scope="local")]
		public function initSearchParams(event:SvdReqEvent):void
		{
			func = event.functionVO;
			contextController.context.svdReq.getCompsCourt(event.functionVO,getCompsCourtResultHandler);
			contextController.context.svdReq.getServiceModeType(getServiceModeTypeResultHandler);
			contextController.context.svdReq.getCaseType(event.functionVO,getCaseTypeResultHandler);
			contextController.context.svdReq.getHandlingAgent(event.functionVO,getHandlingAgentResultHandler);
			contextController.context.svdReq.getRequestStatusType(getRequestStatusTypeResultHandler);
			contextController.context.svdReq.getRequestServiceTypeList(getRequestServiceTypeResultHandler);
		}
		
		private function getCompsCourtResultHandler(evt:TideResultEvent):void{
			enquireSvdReqFormPanelPM.comprisingCourtVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
			var compsCourtList:ArrayCollection = evt.result as ArrayCollection;
			if(compsCourtList != null){
				for each(var compsCourt:ComprisingCourtVO in compsCourtList){
					compsCourt.comprisingCourtName = compsCourt.comprisingCourtCode + "-" + compsCourt.comprisingCourtName;
					enquireSvdReqFormPanelPM.comprisingCourtVOs.addItem(compsCourt);
				}
				if(compsCourtList.length > 1){
					var emptyCompsCourt:ComprisingCourtVO = new ComprisingCourtVO;
					emptyCompsCourt.comprisingCourtName = SvdReqConstant.ALL;
					enquireSvdReqFormPanelPM.selectComprisingCourt = emptyCompsCourt.comprisingCourtName;
					enquireSvdReqFormPanelPM.comprisingCourtVOs.addItem(emptyCompsCourt);
				}else if(compsCourtList.length == 1){
					enquireSvdReqFormPanelPM.serviceRequestSearchVO.comprisingCourt = enquireSvdReqFormPanelPM.comprisingCourtVOs[0];
					enquireSvdReqFormPanelPM.selectComprisingCourt = enquireSvdReqFormPanelPM.comprisingCourtVOs[0].comprisingCourtName;
				}
			}
		}
		private function getServiceModeTypeResultHandler(evt:TideResultEvent):void{
			enquireSvdReqFormPanelPM.serviceModeTypeVOs.removeAll();
			var serviceModeList:ArrayCollection = evt.result as ArrayCollection;
			if(serviceModeList != null){
				if(serviceModeList.length > 1){
					enquireSvdReqFormPanelPM.serviceModeTypeVOs = serviceModeList;
					var emptyServiceModeVO:ServiceModeTypeVO = new ServiceModeTypeVO;
					emptyServiceModeVO.serviceModeTypeName = SvdReqConstant.ALL;
					enquireSvdReqFormPanelPM.selectServiceMode = emptyServiceModeVO.serviceModeTypeName;
					enquireSvdReqFormPanelPM.serviceModeTypeVOs.addItem(emptyServiceModeVO);
				}else if(serviceModeList.length == 1){
					enquireSvdReqFormPanelPM.serviceRequestSearchVO.serviceModeType = enquireSvdReqFormPanelPM.serviceModeTypeVOs[0];
					enquireSvdReqFormPanelPM.selectServiceMode = enquireSvdReqFormPanelPM.serviceModeTypeVOs[0].serviceModeTypeName;
				}
			}
		}
		private function getCaseTypeResultHandler(evt:TideResultEvent):void{
			enquireSvdReqFormPanelPM.caseTypeVOs.removeAll();
			var caseTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(caseTypeList != null){
				for each(var caseType:CaseTypeVO in caseTypeList){
					caseType.caseTypeName = caseType.caseTypeCode + '-' + caseType.caseTypeName;
					enquireSvdReqFormPanelPM.caseTypeVOs.addItem(caseType);
				}
				if(caseTypeList.length > 1){
					var emptyCaseTypeVO:CaseTypeVO = new CaseTypeVO;
					emptyCaseTypeVO.caseTypeName = SvdReqConstant.ALL;
					enquireSvdReqFormPanelPM.selectCaseType = emptyCaseTypeVO.caseTypeName;
					enquireSvdReqFormPanelPM.caseTypeVOs.addItem(emptyCaseTypeVO);
				}else if(caseTypeList.length == 1){
					enquireSvdReqFormPanelPM.serviceRequestSearchVO.caseType = enquireSvdReqFormPanelPM.caseTypeVOs[0];
					enquireSvdReqFormPanelPM.selectCaseType = enquireSvdReqFormPanelPM.caseTypeVOs[0].caseTypeName;
				}
			}
		}
		private function getHandlingAgentResultHandler(evt:TideResultEvent):void{
			enquireSvdReqFormPanelPM.handlingAgentVOs.removeAll();
			var hanglingAgentList:ArrayCollection = evt.result as ArrayCollection;
			if(hanglingAgentList != null){
				enquireSvdReqFormPanelPM.handlingAgentVOs = hanglingAgentList;
				if(hanglingAgentList.length > 1){
					var emptyHandlingAgent:HandlingAgentVO = new HandlingAgentVO;
					emptyHandlingAgent.handlingAgentName = SvdReqConstant.ALL;
					enquireSvdReqFormPanelPM.selectHandlingAgent = emptyHandlingAgent.handlingAgentName;
					enquireSvdReqFormPanelPM.handlingAgentVOs.addItem(emptyHandlingAgent);
				}else if(hanglingAgentList.length == 1){
					enquireSvdReqFormPanelPM.serviceRequestSearchVO.handlingAgent = enquireSvdReqFormPanelPM.handlingAgentVOs[0];
					enquireSvdReqFormPanelPM.selectHandlingAgent = enquireSvdReqFormPanelPM.handlingAgentVOs[0].handlingAgentName;
				}
			}
		}
		private function getRequestStatusTypeResultHandler(evt:TideResultEvent):void{
			enquireSvdReqFormPanelPM.requestStatusTypeVOs.removeAll();
			enquireSvdReqFormPanelPM.requestStatusTypeVOs = evt.result as ArrayCollection;
			enquireSvdReqFormPanelPM.displayRequestStatusType();
		}
		private function getRequestServiceTypeResultHandler(evt:TideResultEvent):void{
			enquireSvdReqFormPanelPM.requestServiceTypeVOs.removeAll();
			enquireSvdReqFormPanelPM.requestServiceTypeVOs = evt.result as ArrayCollection;
			if(enquireSvdReqFormPanelPM.requestServiceTypeVOs != null){
				if(enquireSvdReqFormPanelPM.requestServiceTypeVOs.length > 1){
					var emptyRequestServiceType:RequestServiceTypeVO = new RequestServiceTypeVO;
					emptyRequestServiceType.requestServiceTypeName = SvdReqConstant.ALL;
					enquireSvdReqFormPanelPM.selectRequestServiceType = emptyRequestServiceType.requestServiceTypeName;
					enquireSvdReqFormPanelPM.requestServiceTypeVOs.addItem(emptyRequestServiceType);
				}else if(enquireSvdReqFormPanelPM.requestServiceTypeVOs.length == 1){
					enquireSvdReqFormPanelPM.serviceRequestSearchVO.requestServiceType = enquireSvdReqFormPanelPM.requestServiceTypeVOs[0];
					enquireSvdReqFormPanelPM.selectRequestServiceType = enquireSvdReqFormPanelPM.requestServiceTypeVOs[0].requestServiceTypeName;
				}
			}
		}

		[MessageHandler(selector="searchServiceRequestList", scope="local")]
		public function searchServiceRequestList(event:SvdReqEvent):void{
			contextController.context.svdReq.searchServiceRequestList(event.serviceRequestSearchVO,searchServiceRequestListResultHandler);
		}
		private function searchServiceRequestListResultHandler(evt:TideResultEvent):void
		{
			enquireSvdReqFormPanelPM.showSearchResult(evt.result as ArrayCollection);
		}
		
		[MessageHandler(selector="completeServiceRequestList", scope="local")]
		public function completeServiceRequestList(event:SvdReqEvent):void{
			contextController.context.svdReq.completeServiceRequestList(event.requestIdDTOs,completeServiceRequestListHandler);
		}
		private function completeServiceRequestListHandler(evt:TideResultEvent):void
		{
			var returnVal:IntegerFieldVO = evt.result as IntegerFieldVO;
//			Alert.show("completed:" + returnVal.integerField1 + "     total:" + returnVal.integerField2);
			var param:Array = new Array(returnVal.integerField1, returnVal.integerField2);
			MessageHandler.createInformationMessageBox(MessageConstant.COMPLETED_INFO, param, param);
		}
		
		[MessageHandler(selector="maintainRequest", scope="local")]
		public function maintainRequest(event:SvdReqEvent):void {
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
		
		[MessageHandler(selector="outMaintainRequest", scope="local")]
		public function outMaintainRequest(event:SvdReqEvent):void {
			contextController.context.svdReq.maintainRequest(event.maintainRequestVO,outMaintainRequestHandler);
		}
		
		private function outMaintainRequestHandler(evt:TideResultEvent):void
		{
			var returnVal:ServiceRequestDetailVO = evt.result as ServiceRequestDetailVO;
			if(returnVal != null){
				dispatchEvent(SvdReqEvent.createFormRequestEvent(returnVal));	
			}
		}
		
		//=============================================Enquiry End=============================================================
		
		[MessageHandler(selector="formRequest", scope="local")]
		public function formRequest(event:SvdReqEvent):void {
			func = event.functionVO;
			inputSvdReqPanelPM.toServiceRequestDetailVO(event.serviceRequestDetailVO);
			inputSvdReqMainPM.newVisable = true;
			if(event.serviceRequestDetailVO.func != null){
				inputSvdReqMainPM.newVisable = false;
			}
		}
		
		[MessageHandler(selector="saveDraftServiceRequest", scope="local")]
		public function saveDraftServiceRequest(event:SvdReqEvent):void {
			func = event.serviceRequestDetailVO.func;
			contextController.context.svdReq.saveDraftServiceRequest(event.serviceRequestDetailVO,saveDraftServiceRequestHandler);
		}
		private function saveDraftServiceRequestHandler(evt:TideResultEvent):void{
			var returnVal:IdVO = evt.result as IdVO;
			if(returnVal.id != 0){
				refresh(returnVal.id);
//				Alert.show("Save draft successfully!");
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SAVE_DRAFT, null, null);
			}
		}
		
		[MessageHandler(selector="submitServiceRequest", scope="local")]
		public function submitServiceRequest(event:SvdReqEvent):void {
			func = event.serviceRequestDetailVO.func;
			contextController.context.svdReq.submitServiceRequest(event.serviceRequestDetailVO,submitServiceRequestHandler);
		}
		private function submitServiceRequestHandler(evt:TideResultEvent):void
		{
			var returnVal:IdVO = evt.result as IdVO;
			if(returnVal.id != 0){
				refresh(returnVal.id);
//				Alert.show("Submit successfully!");
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SUBMIT, null, null);
			}
		}
		
		[MessageHandler(selector="withdrawServiceRequest", scope="local")]
		public function withdrawServiceRequest(event:SvdReqEvent):void {
			func = event.serviceRequestDetailVO.func;
			contextController.context.svdReq.withdrawServiceRequest(event.serviceRequestDetailVO,withdrawServiceRequestHandler);
		}
		private function withdrawServiceRequestHandler(evt:TideResultEvent):void{
			var reqsId:IdVO = evt.result as IdVO;
			refresh(reqsId.id);
//			Alert.show("Withdraw successfully!");
			MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_WITHDRAW, null, null);
		}
		
		[MessageHandler(selector="completeServiceRequest", scope="local")]
		public function completeServiceRequest(event:SvdReqEvent):void {
			func = event.serviceRequestDetailVO.func;
			contextController.context.svdReq.completeServiceRequest(event.serviceRequestDetailVO,completeServiceRequestHandler);
		}
		private function completeServiceRequestHandler(evt:TideResultEvent):void{
			var returnVal:IdVO = evt.result as IdVO;
			if(returnVal.id != 0){
				refresh(returnVal.id);
//				Alert.show("Complete successfully!");
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_COMPLETE, null, null);
			}
		}
		
		private function refresh(reqsId:int):void{
			var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
			maintainRequestVO.func = func;
			maintainRequestVO.requestId = reqsId;
			contextController.context.svdReq.maintainRequest(maintainRequestVO,maintainHandler);
		}
		private function maintainHandler(evt:TideResultEvent):void{
			var returnVal:ServiceRequestDetailVO = evt.result as ServiceRequestDetailVO;
			inputSvdReqPanelPM.toServiceRequestDetailVO(returnVal);
		}
		
		//=============================================Input(Service Of Document) Start=============================================================
		[MessageHandler(selector="initInputParams", scope="local")]
		public function initInputParams(event:SvdReqEvent):void
		{
			func = event.functionVO;
			serviceRequestDetailVO = event.serviceRequestDetailVO;
			contextController.context.svdReq.getParticipantRoleType(event.functionVO,getParticipantRoleTypeResultHandler);
			contextController.context.svdReq.getHkRegion(getHkRegionResultHandler);
			contextController.context.svdReq.getHkDistrict(getHkDistrictResultHandler);
			contextController.context.svdReq.getBailiffOffice(getBailiffOfficeResultHandler);
			contextController.context.svdReq.getPostOffice(getPostOfficeResultHandler);
			contextController.context.svdReq.getRequestServiceTypeList(getRequestServiceTypeInputResultHandler);
			contextController.context.svdReq.getServiceModeType(getServiceModeTypeInputResultHandler);
			contextController.context.svdReq.getHandlingAgent(event.functionVO,getHandlingAgentInputResultHandler);
		}
		
		private function getParticipantRoleTypeResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.participantRoleTypeVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ParticipantRoleTypeVO")]
			var participantRoleTypeVOList:ArrayCollection = evt.result as ArrayCollection;
			if(participantRoleTypeVOList != null){
				inputSvdReqPanelPM.participantRoleTypeVOs = participantRoleTypeVOList;
			}
		}
		private function getHkDistrictResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.hkDistrictVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HkDistrictVO")]
			var hkDistrictVOList:ArrayCollection = evt.result as ArrayCollection;
			if(hkDistrictVOList != null){
				inputSvdReqPanelPM.hkDistrictVOs.addItem(new HkDistrictVO());
				inputSvdReqPanelPM.hkDistrictVOs.addAll(hkDistrictVOList);
			}
			if(serviceRequestDetailVO.requestAddress.hkRegion != null){
				inputSvdReqPanelPM.displayHkDistrictVOs.removeAll();
				inputSvdReqPanelPM.displayHkDistrictVOs.addItem(new HkDistrictVO());
				if(hkDistrictVOList.length > 0){
					for each(var dis:HkDistrictVO in hkDistrictVOList){
						if(dis.hkRegion != null && dis.hkRegion.hkRegionId == serviceRequestDetailVO.requestAddress.hkRegion.hkRegionId){
							inputSvdReqPanelPM.displayHkDistrictVOs.addItem(dis);
						}
					}
				}
			}
		}
		private function getBailiffOfficeResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.bailiffOfficeVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO")]
			var bailiffOfficeList:ArrayCollection = evt.result as ArrayCollection;
			inputSvdReqPanelPM.bailiffOfficeVOs = bailiffOfficeList;
		}
		private function getPostOfficeResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.postOfficeVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.PostOfficeVO")]
			var postOfficeList:ArrayCollection = evt.result as ArrayCollection;
			inputSvdReqPanelPM.postOfficeVOs = postOfficeList;
		}
		private function getHkRegionResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.hkRegionVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HkRegionVO")]
			var hkRegionVOList:ArrayCollection = evt.result as ArrayCollection;
			if(hkRegionVOList != null){
				inputSvdReqPanelPM.hkRegionVOs = hkRegionVOList;
				if(serviceRequestDetailVO.requestAddress.hkRegion == null){
					for each(var defaultHkRegion:HkRegionVO in hkRegionVOList){
						if(defaultHkRegion.hkRegionName == SvdReqConstant.HONG_KONG_ISLAND){
							serviceRequestDetailVO.requestAddress.hkRegion = defaultHkRegion;
							inputSvdReqPanelPM.serviceRequestDetailVO.requestAddress.hkRegion = defaultHkRegion;
							inputSvdReqPanelPM.hkRegionName = defaultHkRegion.hkRegionName;
							break;
						}
					}
				}
			}	
		}
		private function getRequestServiceTypeInputResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.requestServiceTypeVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.RequestServiceTypeVO")]
			var requestServiceTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(requestServiceTypeList != null){
				inputSvdReqPanelPM.requestServiceTypeVOs = requestServiceTypeList;
				if(serviceRequestDetailVO.requestServiceType == null){
					for each(var defaultServiceType:RequestServiceTypeVO in requestServiceTypeList){
						if(defaultServiceType.requestServiceType == SvdReqConstant.REQUEST_SERVICE_TYPE_FRIST){
							inputSvdReqPanelPM.serviceRequestDetailVO.requestServiceType = defaultServiceType;
							inputSvdReqPanelPM.requestServiceTypeName = defaultServiceType.requestServiceTypeName;
							break;
						}
					}
				}
			}
		}
		private function getServiceModeTypeInputResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.serviceModeTypeVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO")]
			var serviceModeTypeList:ArrayCollection = evt.result as ArrayCollection;
			if(serviceModeTypeList != null){
				inputSvdReqPanelPM.serviceModeTypeVOs = serviceModeTypeList;
				if(serviceRequestDetailVO.serviceRequest.serviceModeType == null ){
					for each(var defaultMode:ServiceModeTypeVO in serviceModeTypeList){
						if(defaultMode.serviceModeTypeCode == SvdReqConstant.SERVICE_MODE_CODE_PERSONAL){
							inputSvdReqPanelPM.serviceRequestDetailVO.serviceRequest.serviceModeType = defaultMode;
							inputSvdReqPanelPM.serviceModeTypeName = defaultMode.serviceModeTypeName;
							break;
						}
					}
				}
			}
		}
		private function getHandlingAgentInputResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.handlingAgentVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO")]
			var handlingAgentList:ArrayCollection = evt.result as ArrayCollection;
			if(handlingAgentList != null){
				inputSvdReqPanelPM.handlingAgentVOs = handlingAgentList;
				if(serviceRequestDetailVO.request.handlingAgent == null){
					for each(var defaultHand:HandlingAgentVO in handlingAgentList){
						if(defaultHand.handlingAgentCode == SvdReqConstant.BAILIFF_CODE){
							inputSvdReqPanelPM.serviceRequestDetailVO.request.handlingAgent = defaultHand;
							inputSvdReqPanelPM.handlingAgentName = defaultHand.handlingAgentName;
							break;
						}
					}
				}
			}
		}

		private function initGeneratedDocsHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.documentDrafts.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DocumentDraftVO")]
			var documentDraftList:ArrayCollection = evt.result as ArrayCollection;
			if(documentDraftList != null){
				for each(var docDraft:DocumentDraftVO in documentDraftList){
					var displayDoc:DisplayDocumentDraftVO = new DisplayDocumentDraftVO;
					displayDoc.documentTypeName = docDraft.documentType.documentTypeName;
					displayDoc.documentDraftVO = docDraft;
					inputSvdReqPanelPM.documentDrafts.addItem(displayDoc);
				}
			}
			
			inputSvdReqPanelPM.reGenDocVis = false;
			inputSvdReqPanelPM.genDocVis = false;
			if(serviceRequestDetailVO.requestServiceType.requestServiceType == SvdReqConstant.REQUEST_SERVICE_TYPE_RESERVICE){
				if(documentDraftList != null && documentDraftList.length > 0){
					inputSvdReqPanelPM.reGenDocVis = true;
				}else{
					inputSvdReqPanelPM.genDocVis = true;
				}
			}
		}
		//=============================================Input(Service Of Document) End=============================================================
		
		//=============================================Input(Document List) Start=============================================================
		[MessageHandler(selector="previewDocuments", scope="local")]
		public function previewDocuments(event:SvdReqEvent):void {
			contextController.context.svdReq.previewDocFile(event.documentFileVO, previewDocumentsHandler);
		}
		private function previewDocumentsHandler(evt:TideResultEvent):void{
		}
		
		[MessageHandler(selector="generateDocuments", scope="local")]
		public function generateDocuments(event:SvdReqEvent):void {
			contextController.context.svdReq.generateDocuments(event.serviceRequestDetailVO, initGeneratedDocsHandler);
		}
		//=============================================Input(Document List) End=============================================================
		
		//=============================================Input(Service Result) Start=============================================================
		[MessageHandler(selector="initResultParams", scope="local")]
		public function initResultParams(event:SvdReqEvent):void{
			func = event.functionVO;
			contextController.context.svdReq.getBailiffTaskResultStatusList(getBailiffTaskResultStatusResultHandler);
			contextController.context.svdReq.getBailiffTaskResultReasonList(getBailiffTaskResultReasonResultHandler);
			contextController.context.svdReq.getDocumentTypeList(event.functionVO,getDocumentTypeResultHandler);
			
		}
		
		private function getBailiffTaskResultStatusResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.bailiffTaskResultStatusVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultStatusVO")]
			var bailiffTaskResultStatusList:ArrayCollection = new ArrayCollection;
			bailiffTaskResultStatusList = evt.result as ArrayCollection;
			inputSvdReqPanelPM.bailiffTaskResultStatusVOs.addItem(new BailiffTaskResultStatusVO);
			inputSvdReqPanelPM.bailiffTaskResultStatusVOs.addAll(bailiffTaskResultStatusList);
		}
		private function getBailiffTaskResultReasonResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.bailiffTaskResultReasonVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultReasonVO")]
			var bailiffTaskResultReasonList:ArrayCollection = new ArrayCollection;
			bailiffTaskResultReasonList = evt.result as ArrayCollection;
			inputSvdReqPanelPM.bailiffTaskResultReasonVOs.addItem(new BailiffTaskResultReasonVO);
			inputSvdReqPanelPM.bailiffTaskResultReasonVOs.addAll(bailiffTaskResultReasonList);
		}
		private function getDocumentTypeResultHandler(evt:TideResultEvent):void{
			inputSvdReqPanelPM.documentTypeVOs.removeAll();
			[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO")]
			var documentTypeList:ArrayCollection = evt.result as ArrayCollection;
			inputSvdReqPanelPM.documentTypeVOs.addItem(new DocumentTypeVO);
			inputSvdReqPanelPM.documentTypeVOs.addAll(documentTypeList);
		}
		
		[MessageHandler(selector="assignDrn", scope="local")]
		public function assignDrn(event:SvdReqEvent):void {
			contextController.context.svdReq.assignDrn(event.documentVO, assignDrnHandler);
		}
		private function assignDrnHandler(evt:TideResultEvent):void{
			var returnDoc:DocumentVO = evt.result as DocumentVO;
			inputSvdReqPanelPM.refreshDrn(returnDoc);
		}

		[MessageHandler(selector="saveServiceRequestResult", scope="local")]
		public function saveServiceRequestResult(event:SvdReqEvent):void {
			contextController.context.svdReq.saveServiceRequestResult(event.serviceRequestDetailVO,saveServiceRequestResultHandler);
		}
		private function saveServiceRequestResultHandler(evt:TideResultEvent):void{
			var returnVal:IdVO = evt.result as IdVO;
			if(returnVal.id != 0){
				refresh(returnVal.id);
//				Alert.show("Save Service Request Result successfully!");
				MessageHandler.createInformationMessageBox(MessageConstant.SUCCESS_TO_SAVE_RESULT, null, null);
			}
		}
		
		[MessageHandler(selector="maintainPosRequest", scope="local")]
		public function maintainPosRequest(event:SvdReqEvent):void {
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
		//=============================================Input(Service Result) End=============================================================
		[MessageHandler(selector="downloadDocFile", scope="local")]
		public function downloadDocFile(event:SvdReqEvent):void {
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