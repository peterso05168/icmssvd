package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	
	import hk.judiciary.fmk.view.component.MessageHandler;
	import hk.judiciary.fmk.view.component.event.AlertResponseEvent;
	import hk.judiciary.fmk.web.application.util.ValidationUtil;
	import hk.judiciary.fmk.web.infrastructure.IModuleController;
	import hk.judiciary.icmssvd.view.common.constant.CommonConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageBoxIdConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.util.DateUtil;
	import hk.judiciary.icmssvd.view.common.util.PartyVOUtil;
	import hk.judiciary.icmssvd.view.common.util.ValidateUtil;
	import hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO;
	import hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultReasonVO;
	import hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultStatusVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentFileVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.HkDistrictVO;
	import hk.judiciary.icmssvd.view.common.vo.HkRegionVO;
	import hk.judiciary.icmssvd.view.common.vo.ParticipantRoleTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.PostOfficeVO;
	import hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.SvdReqEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.AddressRoleVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.AddressVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayAddressRoleVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentDraftVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayNewDocumentVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayPartyVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DocumentDraftVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DocumentRecordVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DocumentVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PartyVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestAddressVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestParticipantRoleVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestServiceTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestDetailVO;
	
	[Event(name="initInputParams,initResultParams,saveDraftServiceRequest,submitServiceRequest,withdrawServiceRequest,completeServiceRequest,previewDocuments,generateDocuments,saveServiceRequestResult,assignDrn,maintainRequest,maintainPosRequest,downloadDocFile", 
			type="hk.judiciary.icmssvd.view.svdReq.event.SvdReqEvent")]
	
	[ManagedEvents("initInputParams", scope="local")]
	[ManagedEvents("initResultParams", scope="local")]
	[ManagedEvents("saveDraftServiceRequest", scope="local")]
	[ManagedEvents("submitServiceRequest", scope="local")]
	[ManagedEvents("withdrawServiceRequest", scope="local")]
	[ManagedEvents("completeServiceRequest", scope="local")]
	[ManagedEvents("previewDocuments", scope="local")]
	[ManagedEvents("generateDocuments", scope="local")]
	[ManagedEvents("saveServiceRequestResult", scope="local")]
	[ManagedEvents("assignDrn", scope="local")]
	[ManagedEvents("maintainRequest", scope="local")]
	[ManagedEvents("maintainPosRequest", scope="local")]
	[ManagedEvents("downloadDocFile", scope="local")]
	public class InputSvdReqPanelPM extends EventDispatcher
	{
		[Inject]
		public var moduleController:IModuleController;
		
		private var _selectedAccordionIndex:Array = [];
		private var _errorBoxId:String;
		private var _panelId:String;
		private var _servDocEditable:Boolean=true;
		private var _docListEditable:Boolean=true;
		private var _servResEditable:Boolean=true;
		private var _baiServResEditable:Boolean=true;
		
		private var _serviceRequestDetailVO:ServiceRequestDetailVO = new ServiceRequestDetailVO;
		private var _selectRequester:DisplayPartyVO = new DisplayPartyVO;
		private var _selectRecipient:DisplayPartyVO = new DisplayPartyVO;
		private var _requesterDisplayName:String;
		private var _recipientDisplayName:String;
		private var _participantRoleTypeName:String;
		private var _addrSeqName:String;
		private var _hkDistrictName:String;
		private var _hkRegionName:String;
		private var _postOfficeName:String;
		private var _bailiffOfficeName:String;
		private var _serviceModeTypeName:String;
		private var _requestServiceTypeName:String;
		private var _handlingAgentName:String;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentDraftVO")]
		public var _documentDrafts:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentVO")]
		public var _document:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentVO")]
		public var _returnDocument:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayNewDocumentVO")]
		public var _newReturnDocuments:ArrayCollection = new ArrayCollection;
		public var _submitDate:String;
		
		private var _dateFormat:String = SvdReqConstant.DEFAULT_DATE_PATTERN;
		private var _accAble:Boolean = false;
		private var _mcCourtLvl:Boolean = false;
		private var _postOffice:Boolean = false;
		private var _bailiffOffice:Boolean = false;
		private var _police:Boolean = false;
		private var _registeredPost:Boolean = false;
		private var _mailVis:Boolean = false;
		private var _recipientEditAble:Boolean = false;
		private var _seqVis:Boolean = false;
		private var _serviceTypeEditAble:Boolean = false;
		private var _personalServ:Boolean = false;
		private var _completeBtnVis:Boolean = false;
		
		private var _mcDocEditable:Boolean = false;
		private var _genDocVis:Boolean = false;
		private var _reGenDocVis:Boolean = false;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayPartyVO")]
		public var _displayRequesterVOs:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayPartyVO")]
		public var _displayRecipientVOs:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ParticipantRoleTypeVO")]
		private var _participantRoleTypeVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayAddressRoleVO")]
		private var _displayAddressRoleVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HkDistrictVO")]
		public var _hkDistrictVOs:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HkDistrictVO")]
		public var _displayHkDistrictVOs:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HkRegionVO")]
		public var _hkRegionVOs:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO")]
		public var _bailiffOfficeVOs:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.PostOfficeVO")]
		public var _postOfficeVOs:ArrayCollection = new ArrayCollection;
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO")]
		private var _serviceModeTypeVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO")]
		private var _handlingAgentVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.RequestServiceTypeVO")]
		private var _requestServiceTypeVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultReasonVO")]
		private var _bailiffTaskResultReasonVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultStatusVO")]
		private var _bailiffTaskResultStatusVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO")]
		private var _documentTypeVOs:ArrayCollection=new ArrayCollection();
		
		[Bindable]
		public function get selectedAccordionIndex():Array {return this._selectedAccordionIndex;}
		public function set selectedAccordionIndex(value:Array):void {this._selectedAccordionIndex = value;}
		[Bindable]
		public function get errorBoxId():String { return _errorBoxId; } 
		public function set errorBoxId(value:String):void { this._errorBoxId=value; }
		[Bindable]
		public function get panelId():String { return _panelId; } 
		public function set panelId(value:String):void { this._panelId=value; }
		
		[Bindable]
		public function get serviceRequestDetailVO():ServiceRequestDetailVO{ return this._serviceRequestDetailVO; }
		public function set serviceRequestDetailVO(value:ServiceRequestDetailVO):void { this._serviceRequestDetailVO=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get selectRequester():DisplayPartyVO {return _selectRequester;  } 
		public function set selectRequester(value:DisplayPartyVO):void { this._selectRequester=value; }
		[Bindable]
		public function get selectRecipient():DisplayPartyVO {return _selectRecipient;  } 
		public function set selectRecipient(value:DisplayPartyVO):void { this._selectRecipient=value; }
		[Bindable]
		public function get requesterDisplayName():String {return _requesterDisplayName;  } 
		public function set requesterDisplayName(value:String):void { this._requesterDisplayName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get recipientDisplayName():String {return _recipientDisplayName;  } 
		public function set recipientDisplayName(value:String):void { this._recipientDisplayName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get participantRoleTypeName():String {return _participantRoleTypeName;  } 
		public function set participantRoleTypeName(value:String):void { this._participantRoleTypeName=value; }
		[Bindable]
		[Bindable(event="updateAddrSeq")]
		[Bindable(event="updateSelectedVal")]
		public function get addrSeqName():String {return _addrSeqName;  } 
		public function set addrSeqName(value:String):void { this._addrSeqName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get hkDistrictName():String {return _hkDistrictName;  } 
		public function set hkDistrictName(value:String):void { this._hkDistrictName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get hkRegionName():String {return _hkRegionName;  } 
		public function set hkRegionName(value:String):void { this._hkRegionName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get postOfficeName():String {return _postOfficeName;  } 
		public function set postOfficeName(value:String):void { this._postOfficeName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get bailiffOfficeName():String {return _bailiffOfficeName;  } 
		public function set bailiffOfficeName(value:String):void { this._bailiffOfficeName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get serviceModeTypeName():String {return _serviceModeTypeName;  } 
		public function set serviceModeTypeName(value:String):void { this._serviceModeTypeName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get requestServiceTypeName():String {return _requestServiceTypeName;  } 
		public function set requestServiceTypeName(value:String):void { this._requestServiceTypeName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get handlingAgentName():String {return _handlingAgentName;  } 
		public function set handlingAgentName(value:String):void { this._handlingAgentName=value; }
		[Bindable]
		public function get documentDrafts():ArrayCollection{ return this._documentDrafts; }
		public function set documentDrafts(value:ArrayCollection):void { this._documentDrafts=value; }
		[Bindable]
		public function get document():ArrayCollection{ return this._document; }
		public function set document(value:ArrayCollection):void { this._document=value; }
		[Bindable]
		public function get returnDocument():ArrayCollection{ return this._returnDocument; }
		public function set returnDocument(value:ArrayCollection):void { this._returnDocument=value; }
		[Bindable]
		[Bindable(event="updateNewReturnDoc")]
		public function get newReturnDocuments():ArrayCollection{ return this._newReturnDocuments; }
		public function set newReturnDocuments(value:ArrayCollection):void { this._newReturnDocuments=value; }
		[Bindable]
		public function get submitDate():String { return _submitDate; } 
		public function set submitDate(value:String):void { this._submitDate=value; }
		
		[Bindable]
		public function get dateFormat():String { return _dateFormat; } 
		public function set dateFormat(value:String):void { this._dateFormat=value; }
		[Bindable]
		public function get servDocEditable():Boolean{ return this._servDocEditable; }
		public function set servDocEditable(value:Boolean):void { this._servDocEditable=value; }
		[Bindable]
		public function get docListEditable():Boolean{ return this._docListEditable; }
		public function set docListEditable(value:Boolean):void { this._docListEditable=value; }
		[Bindable]
		public function get servResEditable():Boolean{ return this._servResEditable; }
		public function set servResEditable(value:Boolean):void { this._servResEditable=value; }
		[Bindable]
		public function get baiServResEditable():Boolean{ return this._baiServResEditable; }
		public function set baiServResEditable(value:Boolean):void { this._baiServResEditable=value; }
		[Bindable]
		public function get accAble():Boolean { return _accAble; } 
		public function set accAble(value:Boolean):void { this._accAble=value; }
		[Bindable]
		public function get mcCourtLvl():Boolean { return _mcCourtLvl; } 
		public function set mcCourtLvl(value:Boolean):void { this._mcCourtLvl=value; }
		[Bindable]
		[Bindable(event="updateFormBtn")]
		public function get postOffice():Boolean { return _postOffice; } 
		public function set postOffice(value:Boolean):void { this._postOffice=value; }
		[Bindable]
		[Bindable(event="updateFormBtn")]
		public function get bailiffOffice():Boolean { return _bailiffOffice; } 
		public function set bailiffOffice(value:Boolean):void { this._bailiffOffice=value; }
		[Bindable]
		[Bindable(event="updateFormBtn")]
		public function get police():Boolean { return _police; } 
		public function set police(value:Boolean):void { this._police=value; }
		[Bindable]
		public function get registeredPost():Boolean { return _registeredPost; } 
		public function set registeredPost(value:Boolean):void { this._registeredPost=value; }
		[Bindable]
		public function get mailVis():Boolean { return _mailVis; } 
		public function set mailVis(value:Boolean):void { this._mailVis=value; }
		[Bindable]
		public function get mcDocEditable():Boolean { return _mcDocEditable; } 
		public function set mcDocEditable(value:Boolean):void { this._mcDocEditable=value; }
		[Bindable]
		public function get genDocVis():Boolean { return _genDocVis; } 
		public function set genDocVis(value:Boolean):void { this._genDocVis=value; }
		[Bindable]
		public function get reGenDocVis():Boolean { return _reGenDocVis; } 
		public function set reGenDocVis(value:Boolean):void { this._reGenDocVis=value; }
		[Bindable]
		public function get recipientEditAble():Boolean { return _recipientEditAble; } 
		public function set recipientEditAble(value:Boolean):void { this._recipientEditAble=value; }
		[Bindable]
		public function get seqVis():Boolean { return _seqVis; } 
		public function set seqVis(value:Boolean):void { this._seqVis=value; }
		[Bindable]
		public function get serviceTypeEditAble():Boolean { return _serviceTypeEditAble; } 
		public function set serviceTypeEditAble(value:Boolean):void { this._serviceTypeEditAble=value; }
		[Bindable]
		public function get personalServ():Boolean { return _personalServ; } 
		public function set personalServ(value:Boolean):void { this._personalServ=value; }
		[Bindable]
		public function get completeBtnVis():Boolean { return _completeBtnVis; } 
		public function set completeBtnVis(value:Boolean):void { this._completeBtnVis=value; }
		
		[Bindable]
		public function get displayRequesterVOs():ArrayCollection {return _displayRequesterVOs;  } 
		public function set displayRequesterVOs(value:ArrayCollection):void { this._displayRequesterVOs=value; }
		[Bindable]
		public function get displayRecipientVOs():ArrayCollection {return _displayRecipientVOs;  } 
		public function set displayRecipientVOs(value:ArrayCollection):void { this._displayRecipientVOs=value; }
		[Bindable]
		public function get participantRoleTypeVOs():ArrayCollection {return _participantRoleTypeVOs;  } 
		public function set participantRoleTypeVOs(value:ArrayCollection):void { this._participantRoleTypeVOs=value; }
		[Bindable]
		public function get displayAddressRoleVOs():ArrayCollection {return _displayAddressRoleVOs;  } 
		public function set displayAddressRoleVOs(value:ArrayCollection):void { this._displayAddressRoleVOs=value; }
		[Bindable]
		public function get hkDistrictVOs():ArrayCollection {return _hkDistrictVOs;  } 
		public function set hkDistrictVOs(value:ArrayCollection):void { this._hkDistrictVOs=value; }
		[Bindable]
		public function get displayHkDistrictVOs():ArrayCollection {return _displayHkDistrictVOs;  } 
		public function set displayHkDistrictVOs(value:ArrayCollection):void { this._displayHkDistrictVOs=value; }
		[Bindable]
		public function get hkRegionVOs():ArrayCollection {return _hkRegionVOs;  } 
		public function set hkRegionVOs(value:ArrayCollection):void { this._hkRegionVOs=value; }
		[Bindable]
		public function get bailiffOfficeVOs():ArrayCollection {return _bailiffOfficeVOs;  } 
		public function set bailiffOfficeVOs(value:ArrayCollection):void { this._bailiffOfficeVOs=value; }
		[Bindable]
		public function get postOfficeVOs():ArrayCollection {return _postOfficeVOs;  } 
		public function set postOfficeVOs(value:ArrayCollection):void { this._postOfficeVOs=value; }
		[Bindable]
		public function get serviceModeTypeVOs():ArrayCollection {return _serviceModeTypeVOs;  } 
		public function set serviceModeTypeVOs(value:ArrayCollection):void { this._serviceModeTypeVOs=value; }
		[Bindable]
		public function get handlingAgentVOs():ArrayCollection {return _handlingAgentVOs;  } 
		public function set handlingAgentVOs(value:ArrayCollection):void { this._handlingAgentVOs=value; }
		[Bindable]
		public function get requestServiceTypeVOs():ArrayCollection {return _requestServiceTypeVOs;  } 
		public function set requestServiceTypeVOs(value:ArrayCollection):void { this._requestServiceTypeVOs=value; }
		[Bindable]
		public function get bailiffTaskResultReasonVOs():ArrayCollection {return _bailiffTaskResultReasonVOs;  } 
		public function set bailiffTaskResultReasonVOs(value:ArrayCollection):void { this._bailiffTaskResultReasonVOs=value; }
		[Bindable]
		public function get bailiffTaskResultStatusVOs():ArrayCollection {return _bailiffTaskResultStatusVOs;  } 
		public function set bailiffTaskResultStatusVOs(value:ArrayCollection):void { this._bailiffTaskResultStatusVOs=value; }
		[Bindable]
		public function get documentTypeVOs():ArrayCollection {return _documentTypeVOs;  } 
		public function set documentTypeVOs(value:ArrayCollection):void { this._documentTypeVOs=value; }
		
		[Bindable]
		public function get startDateRangeEnd():Date {
			var result:Date = new Date;
			result.date -= 1;
			return result;
		}
		
		public function toServiceRequestDetailVO(returnVal:ServiceRequestDetailVO):void{
			serviceRequestDetailVO = returnVal as ServiceRequestDetailVO;
			
			if(serviceRequestDetailVO.func != null){
				accAble = true;
				selectedAccordionIndex = [0,1,2];
				if(serviceRequestDetailVO.func.courtLevelTypeCode == SvdReqConstant.COURT_LEVEL_TYPE_MAGISTRATES){
					panelId = "inputSvdReqPanelMC.";
					errorBoxId = MessageBoxIdConstant.INPUT_SVDREQ_ERROR_MC;
				}else{
					panelId = "inputSvdReqPanelDC.";
					errorBoxId = MessageBoxIdConstant.INPUT_SVDREQ_ERROR_DC;
				}
				if(serviceRequestDetailVO.errorBoxComponentId != null && serviceRequestDetailVO.errorBoxComponentId != ""){
					this.resetValidation();
				}
				//to do with null object
				dealWithNullObj();
				
				//private method to set enabled
				setEnabledField();
				
				if(servDocEditable){
					dispatchEvent(SvdReqEvent.initInputParams(serviceRequestDetailVO));
				}
				
				reGenDocVis = false;
				genDocVis = false;
				if(mcCourtLvl && docListEditable){
					documentDrafts.removeAll();
					if(serviceRequestDetailVO.documentDrafts != null){
						for each(var docDraft:DocumentDraftVO in serviceRequestDetailVO.documentDrafts){
							if(docDraft.selectedDocumentInd){
								var displayDoc:DisplayDocumentDraftVO = new DisplayDocumentDraftVO;
								displayDoc.documentTypeName = docDraft.documentType.documentTypeName;
								displayDoc.documentDraftVO = docDraft;
								documentDrafts.addItem(displayDoc);
							}
						}
					}
					
					if(serviceRequestDetailVO.requestServiceType.requestServiceType == SvdReqConstant.REQUEST_SERVICE_TYPE_RESERVICE){
						if(documentDrafts.length > 0){
							reGenDocVis = true;
						}else{
							genDocVis = true;
						}
					}
				}
				
				if(servResEditable){
					dispatchEvent(SvdReqEvent.initResultParams(serviceRequestDetailVO.func));
				}
				
				//private method to set requester and requesters
				setRequesterOfSvd();
				//private method to set recipient and recipients
				setRecipientOfSvd();
				
				//set vaules to selected item(focus on)
				setValToSelected();
				
				//to display Document List
				setDocList();
				
				//to display Service Result fields
				setServiceRsltFields();
				
				//to display or hide button of service document form
				btnController();	
			}else{
				accAble = false;
				selectedAccordionIndex = [];
			}
		}
		
		private function setEnabledField():void{
			bailiffOffice = false;
			postOffice = false;
			police = false;
			
			if(serviceRequestDetailVO.func.courtLevelTypeCode == SvdReqConstant.COURT_LEVEL_TYPE_MAGISTRATES){
				mcCourtLvl = true;
			}else{
				mcCourtLvl = false;
			}
			
			if(serviceRequestDetailVO.serviceRequest.serviceModeType == null || 
				(serviceRequestDetailVO.serviceRequest.serviceModeType != null 
					&& serviceRequestDetailVO.serviceRequest.serviceModeType.serviceModeTypeCode == SvdReqConstant.SERVICE_MODE_CODE_PERSONAL)){
				personalServ = true;
			}else{
				personalServ = false;
			}
			
			
			if(serviceRequestDetailVO.request.handlingAgent==null){
				bailiffOffice = true;
			}else{
				var handAgtCode:String = serviceRequestDetailVO.request.handlingAgent.handlingAgentCode;
				if(SvdReqConstant.BAILIFF_CODE == handAgtCode){
					bailiffOffice = true;
				}else if(SvdReqConstant.POST_OFFICE_CODE == handAgtCode){
					postOffice = true;
				}else if(SvdReqConstant.POLICE_CODE == handAgtCode){
					police = true;
				}
			}
			
			serviceTypeEditAble = false;
			if(CommonConstant.COMMON_PANEL_MODE_READONLY == serviceRequestDetailVO.serviceOfDocumentPanelMode){
				this.servDocEditable = false;
			}else if(CommonConstant.COMMON_PANEL_MODE_EDIT == serviceRequestDetailVO.serviceOfDocumentPanelMode){
				this.servDocEditable = true;
				if(serviceRequestDetailVO.allowUpdateServiceTypeInd){
					serviceTypeEditAble = true;
				}
			}
			if(CommonConstant.COMMON_PANEL_MODE_READONLY == serviceRequestDetailVO.documentListPanelMode){
				this.docListEditable = false;
			}else if(CommonConstant.COMMON_PANEL_MODE_EDIT == serviceRequestDetailVO.documentListPanelMode){
				this.docListEditable = true;
			}
			if(CommonConstant.COMMON_PANEL_MODE_READONLY == serviceRequestDetailVO.serviceResultPanelMode){
				this.servResEditable = false;
			}else if(CommonConstant.COMMON_PANEL_MODE_EDIT == serviceRequestDetailVO.serviceResultPanelMode){
				this.servResEditable = true;
			}
			
			baiServResEditable = servResEditable && !bailiffOffice;
		}
		
		private function dealWithNullObj():void{
			if(serviceRequestDetailVO.request.submissionDatetime != null){
				submitDate = DateUtil.toFormattedDateString(serviceRequestDetailVO.request.submissionDatetime);
			}
			
			if(serviceRequestDetailVO.request.requestStatusType == null){
				serviceRequestDetailVO.request.requestStatusType = new RequestStatusTypeVO;
			}
			
			if(serviceRequestDetailVO.request.bailiffOffice == null){
				serviceRequestDetailVO.request.bailiffOffice = new BailiffOfficeVO;
			}
			
			if(serviceRequestDetailVO.serviceRequest.participantRoleType == null){
				serviceRequestDetailVO.serviceRequest.participantRoleType = new ParticipantRoleTypeVO;
			}
			if(serviceRequestDetailVO.serviceRequest.postOffice == null){
				serviceRequestDetailVO.serviceRequest.postOffice = new PostOfficeVO;
			}
			
			if(serviceRequestDetailVO.requestAddress == null){
				serviceRequestDetailVO.requestAddress = new RequestAddressVO;
			}
		}
		
		private function setRequesterOfSvd():void{
			displayRequesterVOs.removeAll();
			selectRequester = new DisplayPartyVO;
			if(serviceRequestDetailVO.requester != null){
				selectRequester.participantId = serviceRequestDetailVO.requester.participantId;
				selectRequester.displayName = PartyVOUtil.getRequestNameWithChi(serviceRequestDetailVO.requester);
				selectRequester.partyVO = serviceRequestDetailVO.requester;
			}
			if(serviceRequestDetailVO.requesters != null && serviceRequestDetailVO.requesters.length > 0){
				for each (var requester:PartyVO in serviceRequestDetailVO.requesters){
					var displayReqs:DisplayPartyVO = new DisplayPartyVO;
					displayReqs.participantId = requester.participantId;
					displayReqs.displayName = PartyVOUtil.getRequestNameWithChi(requester);;
					displayReqs.partyVO = requester;
					displayRequesterVOs.addItem(displayReqs);
				}
			}
		}
		
		private function setRecipientOfSvd():void{
			var otherPerson:DisplayPartyVO = new DisplayPartyVO;
			otherPerson.participantId = -1;
			otherPerson.displayName = "Other";
			var partyVO:PartyVO = new PartyVO;
			partyVO.participantRoleType = new ParticipantRoleTypeVO;
			otherPerson.partyVO = partyVO;
			selectRecipient = new DisplayPartyVO;
			if(serviceRequestDetailVO.recipient != null){
				selectRecipient.participantId = serviceRequestDetailVO.recipient.participantId;
				selectRecipient.displayName = PartyVOUtil.getRequestNameWithChi(serviceRequestDetailVO.recipient);
				selectRecipient.partyVO = serviceRequestDetailVO.recipient;
			}
			
			displayRecipientVOs.removeAll();
			
			var isOther:Boolean = true;
			if(serviceRequestDetailVO.recipients != null && serviceRequestDetailVO.recipients.length > 0){
				for each (var recipient:PartyVO in serviceRequestDetailVO.recipients){
					var displayRec:DisplayPartyVO = new DisplayPartyVO;
					displayRec.participantId = recipient.participantId;
					displayRec.displayName = PartyVOUtil.getRequestNameWithChi(recipient);
					displayRec.partyVO = recipient;
					displayRecipientVOs.addItem(displayRec);
					if(selectRecipient.participantId == displayRec.participantId){
						isOther = false;
					}
				}
			}
			if(isOther){
				seqVis = false;
				if(serviceRequestDetailVO.request == null || serviceRequestDetailVO.request.requestId == 0){
					if(serviceRequestDetailVO.serviceRequest.participantRoleType != null 
						&& serviceRequestDetailVO.serviceRequest.participantRoleType.participantRoleTypeId != 0){
						selectRecipient = otherPerson;
						recipientEditAble = servDocEditable;
					}
				}else{
					selectRecipient = otherPerson;
					recipientEditAble = servDocEditable;
				}
			}else{
				seqVis = servDocEditable;
			}
			displayRecipientVOs.addItem(otherPerson);
		}
		
		private function setValToSelected():void{
			requesterDisplayName = "";
			recipientDisplayName = "";
			participantRoleTypeName = "";
			addrSeqName = "";
			hkDistrictName = "";
			hkRegionName = "";
			postOfficeName = "";
			bailiffOfficeName = "";
			serviceModeTypeName = "";
			requestServiceTypeName = "";
			handlingAgentName = "";
			if(selectRequester != null){
				requesterDisplayName = selectRequester.displayName;
			}
			
			if(selectRecipient != null){
				recipientDisplayName = selectRecipient.displayName;
			}
			
			participantRoleTypeName = serviceRequestDetailVO.serviceRequest.participantRoleType.participantRoleTypeName;
			
			displayAddressRoleVOs.removeAll();
			setDefaultAddrSeq();
			
			if(serviceRequestDetailVO.requestAddress.hkDistrict != null){
				hkDistrictName = serviceRequestDetailVO.requestAddress.hkDistrict.hkDistrictName;
				if(serviceRequestDetailVO.requestAddress.hkDistrict.hkRegion != null){
					hkRegionName = serviceRequestDetailVO.requestAddress.hkDistrict.hkRegion.hkRegionName;
				}
			}
			
			if(serviceRequestDetailVO.serviceRequest.postOffice != null){
				postOfficeName = serviceRequestDetailVO.serviceRequest.postOffice.postOfficeName;
			}
			
			if(serviceRequestDetailVO.request.bailiffOffice != null){
				bailiffOfficeName = serviceRequestDetailVO.request.bailiffOffice.bailiffOfficeName;
			}
			
			//to default start
			if(serviceRequestDetailVO.requestAddress.hkRegion != null){
				hkRegionName = serviceRequestDetailVO.requestAddress.hkRegion.hkRegionName;
			}
			if(serviceRequestDetailVO.serviceRequest.serviceModeType != null){
				serviceModeTypeName = serviceRequestDetailVO.serviceRequest.serviceModeType.serviceModeTypeName;
			}
			if(serviceRequestDetailVO.requestServiceType != null){
				requestServiceTypeName = serviceRequestDetailVO.requestServiceType.requestServiceTypeName;
			}
			if(serviceRequestDetailVO.request.handlingAgent != null){
				handlingAgentName = serviceRequestDetailVO.request.handlingAgent.handlingAgentName;
			}
			//to default end
			dispatchEvent(new Event("updateSelectedVal"));
		}
		
		private function setDefaultAddrSeq():AddressVO{
			var addr:AddressVO;
			if(!recipientEditAble){
				var recipientPartyVO:PartyVO = selectRecipient.partyVO;
				if(serviceRequestDetailVO.serviceRequest != null && serviceRequestDetailVO.serviceRequest.serviceModeType != null
					&& recipientPartyVO != null){
					var modetypeCd:String = serviceRequestDetailVO.serviceRequest.serviceModeType.serviceModeTypeCode;
					var addrRoles:ArrayCollection = recipientPartyVO.addressRoles;
					addAddressRoles(addrRoles);
					if(recipientPartyVO != null && modetypeCd != "" && addrRoles != null && addrRoles.length > 0){
						if(modetypeCd == SvdReqConstant.SERVICE_MODE_CODE_ORDINARY || modetypeCd == SvdReqConstant.SERVICE_MODE_CODE_REGISTERED){
							for each(var addrRole:AddressRoleVO in addrRoles){
								if(addrRole.postalServiceInd && addrRole.addressRoleType != null){
									addrSeqName = getAddrSeqName(addrRole);
									addr = addrRole.address;
									break;
								}
							}
						}else{
							for each(var role:AddressRoleVO in addrRoles){
								if(role.personalServiceInd && role.addressRoleType != null){
									addrSeqName = getAddrSeqName(role);
									addr = role.address;
									break;
								}
							}
						}
					}
				}
			}
			return addr;
		}
		
		private function getAddrSeqName(addrRole:AddressRoleVO):String{
			var name:String = "(" + addrRole.addressSequenceNo + ") ";
			if(addrRole.addressRoleType != null){
				name += addrRole.addressRoleType.addressRoleTypeName;
			}
			return name;
		}
		
		private function addAddressRoles(addrRoles:ArrayCollection):void{
			for each(var addrRole:AddressRoleVO in addrRoles){
				var displayAddressRoleVO:DisplayAddressRoleVO = new DisplayAddressRoleVO;
				displayAddressRoleVO.addressRoleId = addrRole.addressRoleId;
				displayAddressRoleVO.addressRoleTypeName = getAddrSeqName(addrRole);
				displayAddressRoleVO.addressRoleVO = addrRole;
				displayAddressRoleVOs.addItem(displayAddressRoleVO);
			}
		}
		
		private function setDocList():void{
			document.removeAll();
			if(serviceRequestDetailVO.documentRecords != null && serviceRequestDetailVO.documentRecords.length > 0){
				for each(var reqsDoc:DocumentRecordVO in serviceRequestDetailVO.documentRecords){
					if(reqsDoc.document != null && reqsDoc.document.documentId > 0){
						var displayDoc:DisplayDocumentVO = new DisplayDocumentVO;
						displayDoc.documentId = reqsDoc.document.documentId;
						if(reqsDoc.document.documentType != null){
							displayDoc.documentName = reqsDoc.document.documentType.documentTypeName;
						}
						if(reqsDoc.document.documentFileBy != null){
							displayDoc.documentFileBy = reqsDoc.document.documentFileBy.englishSurname 
								+ " " 
								+ reqsDoc.document.documentFileBy.englishGivenName;
						} 
						displayDoc.documentFileDate = reqsDoc.document.documentFileDate;
						displayDoc.documentRecordVO = reqsDoc;
						displayDoc.checked = reqsDoc.selectedDocumentInd;
						if(reqsDoc.document.cfsFileId != null && reqsDoc.document.cfsFileId != ""){
							displayDoc.downloadAble = true;
						}
						if(!displayDoc.downloadAble){
							displayDoc.documentName += CommonConstant.PENDING_FOR_SCANNING;
						}
						if(docListEditable){
							document.addItem(displayDoc);
						}else{
							if(displayDoc.checked){
								document.addItem(displayDoc);
							}
						}
					}
				}
			}
		}
		
		private function setServiceRsltFields():void{
			if(serviceRequestDetailVO.submittedModeInd){
				returnDocument.removeAll();
				if(serviceRequestDetailVO.documentRecords != null && serviceRequestDetailVO.documentRecords.length > 0){
					for each(var reqsReturnDoc:DocumentRecordVO in serviceRequestDetailVO.documentRecords){
						if(reqsReturnDoc.document != null && reqsReturnDoc.document.documentId > 0){
							if(reqsReturnDoc.selectedDocumentInd && reqsReturnDoc.returnedDocumentInd){
								var displayReturnDoc:DisplayDocumentVO = new DisplayDocumentVO;
								displayReturnDoc.documentId = reqsReturnDoc.document.documentId;
								if(reqsReturnDoc.document.documentType != null){
									displayReturnDoc.documentName = reqsReturnDoc.document.documentType.documentTypeName;
								}
								if(reqsReturnDoc.document.documentFileBy != null){
									displayReturnDoc.documentFileBy = reqsReturnDoc.document.documentFileBy.englishSurname 
										+ " " 
										+ reqsReturnDoc.document.documentFileBy.englishGivenName;
								} 
								displayReturnDoc.documentFileDate = reqsReturnDoc.document.documentFileDate;
								displayReturnDoc.documentRecordVO = reqsReturnDoc;
								displayReturnDoc.checked = reqsReturnDoc.selectedDocumentInd;
								if(reqsReturnDoc.document.cfsFileId != null && reqsReturnDoc.document.cfsFileId != ""){
									displayReturnDoc.downloadAble = true;
								}
								if(!displayReturnDoc.downloadAble){
									displayReturnDoc.documentName += CommonConstant.PENDING_FOR_SCANNING;
								}
								returnDocument.addItem(displayReturnDoc);
							}
						}
					}
				}
				if(serviceRequestDetailVO.requestResult != null){
					if(serviceRequestDetailVO.requestResult.bailiffTaskResultStatus != null){
						resultStatusName = serviceRequestDetailVO.requestResult.bailiffTaskResultStatus.bailiffTaskResultStatusName;
					}
					if(serviceRequestDetailVO.requestResult.bailiffTaskResultReason != null){
						resultReasonName = serviceRequestDetailVO.requestResult.bailiffTaskResultReason.bailiffTaskResultReasonName;
					}
				}
				newReturnDocuments.removeAll();
				if(serviceRequestDetailVO.newReturnDocuments != null && serviceRequestDetailVO.newReturnDocuments.length > 0){
					for each(var newDoc:DocumentVO in serviceRequestDetailVO.newReturnDocuments){
						curSeq++;
						var displayNewReturnDoc:DisplayNewDocumentVO = new DisplayNewDocumentVO;
						displayNewReturnDoc.documentId = newDoc.documentId;
						displayNewReturnDoc.documentType = newDoc.documentType.documentTypeName;
						displayNewReturnDoc.documentReferenceNo = newDoc.documentReferenceNo;
						if(displayNewReturnDoc.documentReferenceNo != null && "" != displayNewReturnDoc.documentReferenceNo){
							displayNewReturnDoc.drnEmpty = false;
						}
						displayNewReturnDoc.documentVO = newDoc;
						displayNewReturnDoc.seq = curSeq;
						newReturnDocuments.addItem(displayNewReturnDoc);
					}
				}
			}
		}
		
		private function btnController():void{
			mcDocEditable = false;
			if(mcCourtLvl && docListEditable){
				mcDocEditable = true;
			}
			
			if(mcCourtLvl && serviceRequestDetailVO.submittedModeInd){
				completeBtnVis = true;
			}else{
				completeBtnVis = false;
			}
			
			registeredPost = false;
			mailVis = false;
			if(serviceRequestDetailVO.serviceRequest.serviceModeType != null 
				&& serviceRequestDetailVO.serviceRequest.serviceModeType.serviceModeTypeCode == SvdReqConstant.SERVICE_MODE_CODE_REGISTERED){
				registeredPost = true;
			}
			if(registeredPost && postOffice){
				mailVis = true;
			}
		}
		
		public function changRequester(obj:Object):void{
			var bindableRequester:DisplayPartyVO = obj as DisplayPartyVO;
			selectRequester = bindableRequester;
		}
		
		public function changRecipient(obj:Object):void{
			var bindableRecipient:DisplayPartyVO = obj as DisplayPartyVO;
			selectRecipient = bindableRecipient;
			if(bindableRecipient.displayName == "Other"){
				serviceRequestDetailVO.serviceRequest.participantRoleType = new ParticipantRoleTypeVO;
				participantRoleTypeName = "";
				recipientEditAble = true;
				seqVis = false;
			}else{
				recipientEditAble = false;
				seqVis = true;
			}
			var recipientPartyVO:PartyVO;
			var addr:AddressVO;
			addrSeqName = "";
			displayAddressRoleVOs.removeAll();
			if(!recipientEditAble){
				recipientPartyVO = selectRecipient.partyVO;
				addr = setDefaultAddrSeq();
			}else{
				recipientPartyVO = new PartyVO;
			}
			if(addr != null){
				serviceRequestDetailVO.requestAddress.hkDistrict = addr.hkDistrict;
				if(addr.hkDistrict != null){
					hkDistrictName = addr.hkDistrict.hkDistrictName;
					if(addr.hkDistrict.hkRegion != null){
						hkRegionName = addr.hkDistrict.hkRegion.hkRegionName;
					}else{
						hkRegionName = "";
					}
					changHkRegion(addr.hkDistrict.hkRegion);
				}
				if(addr.hkRegion != null && hkRegionName == ""){
					hkRegionName = addr.hkRegion.hkRegionName;
					changHkRegion(addr.hkRegion);
				}else{
					hkRegionName = "";
					changHkRegion(null);
				}
			}
			setAddr(addr);
			serviceRequestDetailVO.serviceRequest.participantRoleType = recipientPartyVO.participantRoleType;
			if(recipientPartyVO.participantRoleType != null){
				participantRoleTypeName = recipientPartyVO.participantRoleType.participantRoleTypeName;
			}
			serviceRequestDetailVO.serviceRequest.englishRecipientSurname = recipientPartyVO.englishSurname;
			serviceRequestDetailVO.serviceRequest.englishRecipientGivenName = recipientPartyVO.englishGivenName;
			serviceRequestDetailVO.serviceRequest.chineseRecipientSurname = recipientPartyVO.chineseSurname;
			serviceRequestDetailVO.serviceRequest.chineseRecipientGivenName = recipientPartyVO.chineseGivenName;
			
			dispatchEvent(new Event("updateAddrSeq"));
		}
		
		public function changParticipantRole(obj:Object):void{
			var bindableParticipantRole:ParticipantRoleTypeVO = obj as ParticipantRoleTypeVO;
			serviceRequestDetailVO.serviceRequest.participantRoleType = bindableParticipantRole;
		}
		
		public function changeAddrSeq(obj:Object):void{
			var bindableAddressRoleVO:DisplayAddressRoleVO = obj as DisplayAddressRoleVO;
			if(bindableAddressRoleVO != null && bindableAddressRoleVO.addressRoleVO != null &&
				serviceRequestDetailVO.serviceRequest != null && serviceRequestDetailVO.serviceRequest.serviceModeType != null){
				var addrRole:AddressRoleVO = bindableAddressRoleVO.addressRoleVO;
				var modetypeCd:String = serviceRequestDetailVO.serviceRequest.serviceModeType.serviceModeTypeCode;
				if(modetypeCd != ""){
					var addr:AddressVO;
					if(modetypeCd == SvdReqConstant.SERVICE_MODE_CODE_ORDINARY || modetypeCd == SvdReqConstant.SERVICE_MODE_CODE_REGISTERED){
						if(addrRole.postalServiceInd && addrRole.addressRoleType != null){
							addrSeqName = getAddrSeqName(addrRole);
							addr = addrRole.address;
						}
					}else{
						if(addrRole.personalServiceInd && addrRole.addressRoleType != null){
							addrSeqName = getAddrSeqName(addrRole);
							addr = addrRole.address;
						}
					}
					setAddr(addr);
				}
			}
		}
		
		private function setAddr(addr:AddressVO):void{
			if(addr == null){
				addr = new AddressVO;
			}
			serviceRequestDetailVO.requestAddress.englishAddress1 = addr.englishAddress1;
			serviceRequestDetailVO.requestAddress.englishAddress2 = addr.englishAddress2;
			serviceRequestDetailVO.requestAddress.englishAddress3 = addr.englishAddress3;
			serviceRequestDetailVO.requestAddress.chineseAddress1 = addr.chineseAddress1;
			serviceRequestDetailVO.requestAddress.chineseAddress2 = addr.chineseAddress2;
			serviceRequestDetailVO.requestAddress.chineseAddress3 = addr.chineseAddress3;
			serviceRequestDetailVO.requestAddress.foreignAddressInd = addr.foreignAddressInd;
		}
		
		public function changHkDistrict(obj:Object):void{
			var bindableHkDistrict:HkDistrictVO = obj as HkDistrictVO;
			serviceRequestDetailVO.requestAddress.hkDistrict = bindableHkDistrict;
		}
		
		public function changHkRegion(obj:Object):void{
			if(obj != null){
				var bindableHkRegion:HkRegionVO = obj as HkRegionVO;
				serviceRequestDetailVO.requestAddress.hkRegion = bindableHkRegion;
				if(serviceRequestDetailVO.requestAddress.hkRegion.hkRegionName == SvdReqConstant.NEW_TERRITORIES
					&& personalServ){
					for each(var agent:HandlingAgentVO in handlingAgentVOs){
						if(agent.handlingAgentCode == SvdReqConstant.POLICE_CODE){
							changHandlingAgent(agent);
							break;
						}
					}
				}
				filterDistrictByRgn(bindableHkRegion);
			}else{
				serviceRequestDetailVO.requestAddress.hkRegion = new HkRegionVO;
			}
		}
		
		private function filterDistrictByRgn(rgn:HkRegionVO):void{
			displayHkDistrictVOs.removeAll();
			displayHkDistrictVOs.addItem(new HkDistrictVO());
			if(hkDistrictVOs.length > 0){
				for each(var dis:HkDistrictVO in hkDistrictVOs){
					if(dis.hkRegion != null && dis.hkRegion.hkRegionId == rgn.hkRegionId){
						displayHkDistrictVOs.addItem(dis);
					}
				}
			}
			
			if(serviceRequestDetailVO.requestAddress.hkDistrict != null 
				&& serviceRequestDetailVO.requestAddress.hkDistrict.hkRegion != null 
				&& serviceRequestDetailVO.requestAddress.hkDistrict.hkRegion.hkRegionId != rgn.hkRegionId){
				serviceRequestDetailVO.requestAddress.hkDistrict = new HkDistrictVO;
				hkDistrictName = " ";
			}
		}
		
		public function changPostOffice(obj:Object):void{
			var bindablePostOffice:PostOfficeVO = obj as PostOfficeVO;
			serviceRequestDetailVO.serviceRequest.postOffice = bindablePostOffice;
		}
		
		public function changBailiffOffice(obj:Object):void{
			var bindableBailiffOffice:BailiffOfficeVO = obj as BailiffOfficeVO;
			serviceRequestDetailVO.request.bailiffOffice = bindableBailiffOffice;
			serviceRequestDetailVO.requestAddress.bailiffOffice = bindableBailiffOffice;
		}
		
		public function changServiceMode(obj:Object):void{
			var bindableServiceMode:ServiceModeTypeVO = obj as ServiceModeTypeVO;
			serviceRequestDetailVO.serviceRequest.serviceModeType = bindableServiceMode;
			registeredPost = false;
			mailVis = false;
			personalServ = false;
			if(serviceRequestDetailVO.serviceRequest.serviceModeType.serviceModeTypeCode == SvdReqConstant.SERVICE_MODE_CODE_REGISTERED){
				registeredPost = true;
			}else if(serviceRequestDetailVO.serviceRequest.serviceModeType.serviceModeTypeCode == SvdReqConstant.SERVICE_MODE_CODE_PERSONAL){
				personalServ = true;
			}
			if(registeredPost && postOffice){
				mailVis = true;
				if(servDocEditable){
				}
			}
			if(serviceRequestDetailVO.requestAddress.hkRegion.hkRegionName == SvdReqConstant.NEW_TERRITORIES
				&& personalServ){
				for each(var agent:HandlingAgentVO in handlingAgentVOs){
					if(agent.handlingAgentCode == SvdReqConstant.POLICE_CODE){
						changHandlingAgent(agent);
						break;
					}
				}
			}
			if(!registeredPost){
				serviceRequestDetailVO.serviceRequest.registeredMailBarcode = "";
			}
			if(!personalServ){
				serviceRequestDetailVO.serviceRequest.deliveryInstruction = "";
			}
		}
		
		public function changRequestServiceType(obj:Object):void{
			var bindableRequestServiceType:RequestServiceTypeVO = obj as RequestServiceTypeVO;
			serviceRequestDetailVO.requestServiceType = bindableRequestServiceType;
			reGenDocVis = false;
			genDocVis = false;
			if(serviceRequestDetailVO.requestServiceType.requestServiceType == SvdReqConstant.REQUEST_SERVICE_TYPE_RESERVICE){
				if(documentDrafts.length > 0){
					reGenDocVis = true;
				}else{
					genDocVis = true;
				}
			}
		}
		
		public function changHandlingAgent(obj:Object):void{
			var bindableHandlingAgent:HandlingAgentVO = obj as HandlingAgentVO;
			serviceRequestDetailVO.request.handlingAgent = bindableHandlingAgent;
			handlingAgentName = bindableHandlingAgent.handlingAgentName;
			bailiffOffice = false;
			postOffice = false;
			police = false;
			if(SvdReqConstant.BAILIFF_CODE == bindableHandlingAgent.handlingAgentCode){
				bailiffOffice = true;
			}else if(SvdReqConstant.POST_OFFICE_CODE == bindableHandlingAgent.handlingAgentCode){
				postOffice = true;
			}else if(SvdReqConstant.POLICE_CODE == bindableHandlingAgent.handlingAgentCode){
				police = true;
			}
			
			if(!postOffice){
				serviceRequestDetailVO.serviceRequest.registeredMailBarcode = "";
			}
			
//			reServ = true;
			
			mailVis = false;
			if(registeredPost && postOffice){
				mailVis = true;
			}
			dispatchEvent(new Event("updateFormBtn"));
		}
		
		public function doSaveDraft():void{
			if(validate()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doSaveHandler);
			}
		}
		
		private function doSaveHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				formServiceRequestDetailVO();
				dispatchEvent(SvdReqEvent.saveDraftEvent(serviceRequestDetailVO));
			}
		}
		
		public function doSubmit():void{
			if(validate()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doSubmitHandler);
			}
		}
		
		private function doSubmitHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				formServiceRequestDetailVO();
				dispatchEvent(SvdReqEvent.submitEvent(serviceRequestDetailVO));
			}
		}
		
		public function doWithdraw():void{
			if(validate()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doWithdrawHandler);
			}
		}
		
		private function doWithdrawHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				formServiceRequestDetailVO();
				dispatchEvent(SvdReqEvent.withdrawEvent(serviceRequestDetailVO));
			}
		}
		
		public function doComplete():void{
			if(validate()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doCompleteHandler);
			}
		}
		
		private function doCompleteHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				formServiceRequestDetailVO();
				dispatchEvent(SvdReqEvent.completeEvent(serviceRequestDetailVO));
			}
		}
		
		public function previewDocuments(referenceNo:String):void{
			var docFileVO:DocumentFileVO = new DocumentFileVO;
			docFileVO.sourceFileId = referenceNo;
			dispatchEvent(SvdReqEvent.previewDocumentsEvent(docFileVO));
		}
		
		public function generateDocuments():void{
			dispatchEvent(SvdReqEvent.generateDocumentsEvent(serviceRequestDetailVO));
		}
		
		private function validate():Boolean{
			resetValidation();
			var addrBl:Boolean = true;
			var regionBl:Boolean = false;
			var baiOfficeBl:Boolean = true;
			var serviceTypeBl:Boolean = false;
			var modeOfServiceBl:Boolean = false;
			var serviceAgentBl:Boolean = false;
			var diffReqRec:Boolean = true;
			var serviceBefDate:Boolean = true;

			if(selectRequester.partyVO != null && selectRecipient.partyVO != null){
				if(selectRequester.displayName == selectRecipient.displayName){
					diffReqRec = false;
				}
			}
			
			if(!diffReqRec){
				var reqAndRec:ArrayCollection = new ArrayCollection;
				reqAndRec.addItem(panelId + "bindableRequester");
				reqAndRec.addItem(panelId + "bindableRecipient");
				ValidateUtil.addMultiplyValidationMessage(MessageConstant.REQREC_SAME, reqAndRec, errorBoxId);
			}
			
			var requesterBl:Boolean = (selectRequester != null && emptyStrValid(selectRequester.displayName));
			if(!requesterBl){
				ValidateUtil.addValidationMessage(MessageConstant.REQUESTER_EMPTY, panelId + "bindableRequester", errorBoxId);
			}
			
			var recipientBl:Boolean = (selectRecipient != null && emptyStrValid(selectRecipient.displayName));
			if(!recipientBl){
				ValidateUtil.addValidationMessage(MessageConstant.RECIPIENT_EMPTY, panelId + "bindableRecipient", errorBoxId);
			}
			
			var recipientTypeBl:Boolean = (serviceRequestDetailVO.serviceRequest.participantRoleType != null && emptyStrValid(serviceRequestDetailVO.serviceRequest.participantRoleType.participantRoleTypeName));;
			if(!recipientTypeBl){
				ValidateUtil.addValidationMessage(MessageConstant.RECIPIENT_TYPE_EMPTY, panelId + "bindableParticipantRole", errorBoxId);
			}
			
			var recipientEngBl:Boolean = true;
			var recipientEngErrBoxs:ArrayCollection = new ArrayCollection;
			if(!emptyStrValid(serviceRequestDetailVO.serviceRequest.chineseRecipientSurname) && !emptyStrValid(serviceRequestDetailVO.serviceRequest.chineseRecipientGivenName)){
				if(!emptyStrValid(serviceRequestDetailVO.serviceRequest.englishRecipientSurname)){
					recipientEngErrBoxs.addItem(panelId + "recipientEng1");
					if(!emptyStrValid(serviceRequestDetailVO.serviceRequest.englishRecipientGivenName)){
						recipientEngErrBoxs.addItem(panelId + "recipientEng2");
						recipientEngBl = false;
					}
					
				}
			}
			if(!recipientEngBl){
				ValidateUtil.addMultiplyValidationMessage(MessageConstant.RECIPIENT_ENG_EMPTY, recipientEngErrBoxs, errorBoxId);
			}
			
			var addrErrBoxs:ArrayCollection = new ArrayCollection;
			if(serviceRequestDetailVO.requestAddress != null){
				if(!emptyStrValid(serviceRequestDetailVO.requestAddress.englishAddress1)){
					addrErrBoxs.addItem(panelId + "AddressEng1");
				}
				if(!emptyStrValid(serviceRequestDetailVO.requestAddress.englishAddress2)){
					addrErrBoxs.addItem(panelId + "AddressEng2");
				}
				if(!emptyStrValid(serviceRequestDetailVO.requestAddress.englishAddress3)){
					addrErrBoxs.addItem(panelId + "AddressEng3");
				}
				if(!emptyStrValid(serviceRequestDetailVO.requestAddress.chineseAddress1)){
					addrErrBoxs.addItem(panelId + "AddressChi1");
				}
				if(!emptyStrValid(serviceRequestDetailVO.requestAddress.chineseAddress2)){
					addrErrBoxs.addItem(panelId + "AddressChi2");
				}
				if(!emptyStrValid(serviceRequestDetailVO.requestAddress.chineseAddress3)){
					addrErrBoxs.addItem(panelId + "AddressChi3");
				}
			}else{
				addrErrBoxs.addItem(panelId + "AddressEng1");
				addrErrBoxs.addItem(panelId + "AddressEng2");
				addrErrBoxs.addItem(panelId + "AddressEng3");
				addrErrBoxs.addItem(panelId + "AddressChi1");
				addrErrBoxs.addItem(panelId + "AddressChi2");
				addrErrBoxs.addItem(panelId + "AddressChi3");
			}
			addrBl = (addrErrBoxs.length < 6);
			if(!addrBl){
				ValidateUtil.addMultiplyValidationMessage(MessageConstant.ADDR_EMPTY,addrErrBoxs,errorBoxId);
			}
			
			if(serviceRequestDetailVO.requestAddress.hkRegion != null && serviceRequestDetailVO.requestAddress.hkRegion.hkRegionId != 0){
				regionBl = true;
			}else{
				ValidateUtil.addValidationMessage(MessageConstant.REGION_EMPTY, panelId + "bindableHkRegion", errorBoxId);
			}
			
			if(bailiffOffice){
				if(serviceRequestDetailVO.request.bailiffOffice == null || serviceRequestDetailVO.request.bailiffOffice.bailiffOfficeId <= 0){
					baiOfficeBl = false;
					ValidateUtil.addValidationMessage(MessageConstant.BAI_OFFI_EMPTY, panelId + "bindableBailiffOffice", errorBoxId);
				}
			}
			
			if(serviceRequestDetailVO.requestServiceType != null && serviceRequestDetailVO.requestServiceType.requestServiceType != 0){
				serviceTypeBl = true;
			}else{
				ValidateUtil.addValidationMessage(MessageConstant.SERVICETYPE_EMPTY, panelId + "bindableRequestServiceType", errorBoxId);
			}
			
			if(serviceRequestDetailVO.serviceRequest.serviceModeType != null && serviceRequestDetailVO.serviceRequest.serviceModeType.serviceModeTypeId != 0){
				modeOfServiceBl = true;
			}else{
				ValidateUtil.addValidationMessage(MessageConstant.MODEOFSERVICE_EMPTY, panelId + "bindableServiceMode", errorBoxId);
			}
			
			if(serviceRequestDetailVO.request.handlingAgent != null && serviceRequestDetailVO.request.handlingAgent.handlingAgentId != 0){
				serviceAgentBl = true;
			}else{
				ValidateUtil.addValidationMessage(MessageConstant.SERVICEAGENT_EMPTY, panelId + "bindableHandlingAgent", errorBoxId);
			}
			
			if(serviceRequestDetailVO.urgentRequireInd){
				if(serviceRequestDetailVO.serviceRequest.serviceBeforeDate == null){
					serviceBefDate = false;
				}
			}

			if(!serviceBefDate){
				ValidateUtil.addValidationMessage(MessageConstant.SERVBEF_DATE_EMPTY, panelId + "servBefDate", errorBoxId);
			}
			
			var result:Boolean = diffReqRec && requesterBl && recipientBl 
					&& recipientTypeBl && recipientEngBl && addrBl && regionBl && baiOfficeBl
					&& serviceTypeBl && modeOfServiceBl && serviceAgentBl && serviceBefDate;
			if(!result){
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
		
		public function emptyStrValid(obj:String):Boolean{
			return obj != null && obj != "";
		}
		
		private function formServiceRequestDetailVO():void{
			serviceRequestDetailVO.requester = selectRequester.partyVO;
			serviceRequestDetailVO.recipient = selectRecipient.partyVO;
			
			var requesterRequestParticipantRole:RequestParticipantRoleVO;
			if(serviceRequestDetailVO.requesterRequestParticipantRole != null){
				requesterRequestParticipantRole = serviceRequestDetailVO.requesterRequestParticipantRole;
			}else{
				requesterRequestParticipantRole = new RequestParticipantRoleVO;
			}
			requesterRequestParticipantRole.requestId = serviceRequestDetailVO.request.requestId;
			requesterRequestParticipantRole.participantId = serviceRequestDetailVO.requester.participantId;
			requesterRequestParticipantRole.originalParticipantRoleId = serviceRequestDetailVO.requester.participantRoleId
			requesterRequestParticipantRole.participantRoleTypeId = serviceRequestDetailVO.requester.partyCategoryId;
			requesterRequestParticipantRole.participantRoleTypeId = serviceRequestDetailVO.requester.participantRoleType.participantRoleTypeId;
			requesterRequestParticipantRole.respondentSeqNo = serviceRequestDetailVO.requester.respondentSeqNo;
			requesterRequestParticipantRole.respondentSubSeqNo = serviceRequestDetailVO.requester.respondentSubSeqNo;
			requesterRequestParticipantRole.recipientRequesterIndicator = 2;
			serviceRequestDetailVO.requesterRequestParticipantRole = requesterRequestParticipantRole;
			
			var recipientRequestParticipantRole:RequestParticipantRoleVO;
			if(serviceRequestDetailVO.recipientRequestParticipantRole != null){
				recipientRequestParticipantRole = serviceRequestDetailVO.recipientRequestParticipantRole; 
			}else{
				recipientRequestParticipantRole = new RequestParticipantRoleVO;
			}
			recipientRequestParticipantRole.requestId = serviceRequestDetailVO.request.requestId;
			recipientRequestParticipantRole.participantId = serviceRequestDetailVO.recipient.participantId;
			recipientRequestParticipantRole.originalParticipantRoleId = serviceRequestDetailVO.recipient.participantRoleId
			recipientRequestParticipantRole.participantRoleTypeId = serviceRequestDetailVO.recipient.partyCategoryId;
			recipientRequestParticipantRole.participantRoleTypeId = serviceRequestDetailVO.recipient.participantRoleType.participantRoleTypeId;
			recipientRequestParticipantRole.respondentSeqNo = serviceRequestDetailVO.recipient.respondentSeqNo;
			recipientRequestParticipantRole.respondentSubSeqNo = serviceRequestDetailVO.recipient.respondentSubSeqNo;
			recipientRequestParticipantRole.recipientRequesterIndicator = 1;
			serviceRequestDetailVO.recipientRequestParticipantRole = recipientRequestParticipantRole;

			if(serviceRequestDetailVO.documentDrafts != null){
				serviceRequestDetailVO.documentDrafts.removeAll();
				if(documentDrafts != null && documentDrafts.length > 0){
					for each(var disDocDraft:DisplayDocumentDraftVO in documentDrafts){
						serviceRequestDetailVO.documentDrafts.addItem(disDocDraft.documentDraftVO);
					}
				}
			}
			
			serviceRequestDetailVO.documentRecords.removeAll();
			if(document != null && document.length > 0){
				for each (var displayDoc:DisplayDocumentVO in document){
					if(displayDoc.checked){
						displayDoc.documentRecordVO.selectedDocumentInd = true;
					}else{
						displayDoc.documentRecordVO.selectedDocumentInd = false;
					}
					serviceRequestDetailVO.documentRecords.addItem(displayDoc.documentRecordVO);
				}
			}
			serviceRequestDetailVO.errorBoxComponentId = errorBoxId;
		}
		
		public function resetValidation():void
		{
			ValidationUtil.clearValidationMessage(errorBoxId);
		}
		
		public function resultHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
			}
		}

		private var _resultStatusName:String;
		private var _resultReasonName:String;
		[Bindable]
		public function get resultStatusName():String{ return this._resultStatusName; }
		public function set resultStatusName(value:String):void { this._resultStatusName=value; }
		[Bindable]
		public function get resultReasonName():String{ return this._resultReasonName; }
		public function set resultReasonName(value:String):void { this._resultReasonName=value; }
		
		public function changeBailiffTaskResultStatus(obj:Object):void{
			var status:BailiffTaskResultStatusVO = obj as BailiffTaskResultStatusVO;
			serviceRequestDetailVO.requestResult.bailiffTaskResultStatus = status;
		}
		public function changeBailiffTaskResultReason(obj:Object):void{
			var reason:BailiffTaskResultReasonVO = obj as BailiffTaskResultReasonVO;
			serviceRequestDetailVO.requestResult.bailiffTaskResultReason = reason;
		}
		
		public function doAssignDrn(obj:Object):void{
			var selectedObj:DisplayNewDocumentVO = obj as DisplayNewDocumentVO;
			index = selectedObj.seq;
			dispatchEvent(SvdReqEvent.assignDrnEvent(selectedObj.documentVO));
		}
		
		public function doPrint(obj:Object):void{
			var selectedObj:DisplayNewDocumentVO = obj as DisplayNewDocumentVO;
			Alert.show("Print DRN label with " + selectedObj.documentReferenceNo);
		}
		
		public function doDelateDoc(seq:int):void{
			index = seq;
			var i:int = 0;
			for each(var disDoc:DisplayNewDocumentVO in newReturnDocuments){
				if(index == disDoc.seq){
					newReturnDocuments.removeItemAt(i);
					break;
				}
				i++;
			}
			dispatchEvent(new Event("updateNewReturnDoc"));
		}
		
		private var curSeq:int = 0;
		private var index:int = 0;
		public function refreshDrn(currDoc:DocumentVO):void{
			for each(var disDoc:DisplayNewDocumentVO in newReturnDocuments){
				if(index == disDoc.seq){
					disDoc.documentReferenceNo = currDoc.documentReferenceNo;
					if(disDoc.documentReferenceNo != null && "" != disDoc.documentReferenceNo){
						disDoc.drnEmpty = false;
					}else{
						disDoc.drnEmpty = true;
					}
					disDoc.documentVO.documentReferenceNo = currDoc.documentReferenceNo;
					break;
				}
			}
			dispatchEvent(new Event("updateNewReturnDoc"));
		}
		
		public function addReturnDoc():void{
			curSeq++;
			var newDisplayDoc:DisplayNewDocumentVO = new DisplayNewDocumentVO;
			newDisplayDoc.seq = curSeq;
			newDisplayDoc.drnEmpty = true;
			newReturnDocuments.addItem(newDisplayDoc);
			dispatchEvent(new Event("updateNewReturnDoc"));
		}
		
		public function changeDocType(obj:Object, obj2:Object):void{
			var newDisplayDoc:DisplayNewDocumentVO = obj as DisplayNewDocumentVO;
			var docType:DocumentTypeVO = obj2 as DocumentTypeVO;
			for each(var disDoc:DisplayNewDocumentVO in newReturnDocuments){
				if(newDisplayDoc.seq == disDoc.seq){
					disDoc.documentVO.documentType = docType;
				}
			}
		}
		
		public function doSaveRslt():void{
			if(validateRslt()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doSaveRsltHandler);
			}
		}
		
		private function validateRslt():Boolean{
			resetValidation();
			var docDataGridBox:String = "docDataGrid";
			var result:Boolean = true;
			if(newReturnDocuments.length > 0){
				var docTypeList:ArrayCollection = new ArrayCollection;
				var docTypeInputColumn:int = 0;
				var drnList:ArrayCollection = new ArrayCollection;
				var drnInputColumn:int = 1;
				for(var i:int = 0; i < newReturnDocuments.length; ++i) {
					if (newReturnDocuments[i].documentVO.documentType.documentTypeId == 0) {
						docTypeList.addItem(i);
					}
					
					if (newReturnDocuments[i].drnEmpty) {
						drnList.addItem(i);
					}
				}
				var checkDocType:Boolean = (docTypeList.length == 0);
				if (!checkDocType) {
					ValidateUtil.addValidationMessageDataGrid(MessageConstant.DOCTYPE_EMPTY, panelId + docDataGridBox, errorBoxId,
						docTypeInputColumn, docTypeList);
				}
				var checkDrn:Boolean = (drnList.length == 0);
				if (!checkDrn) {
					ValidateUtil.addValidationMessageDataGrid(MessageConstant.DRN_EMPTY, panelId + docDataGridBox, errorBoxId,
						drnInputColumn, drnList);
				}
				result = checkDocType && checkDrn;
			}
			if (!result) {
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
		
		private function doSaveRsltHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				serviceRequestDetailVO.requestResult.requestId = serviceRequestDetailVO.serviceRequest.requestId;
				if(newReturnDocuments.length > 0){
					for each(var disDocVO:DisplayNewDocumentVO in newReturnDocuments){
						serviceRequestDetailVO.newReturnDocuments.addItem(disDocVO.documentVO);
					}
				}
				dispatchEvent(SvdReqEvent.saveRsltEvent(serviceRequestDetailVO));
			}
		}
		
		public function doShowProof():void{
			var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
			maintainRequestVO.requestId = serviceRequestDetailVO.request.requestId;
			maintainRequestVO.func = serviceRequestDetailVO.func;
			maintainRequestVO.errorBoxComponentId = errorBoxId;
			maintainRequestVO.makeNewRequestInd = true;
			dispatchEvent(SvdReqEvent.createMaintainPosRequestEvent(maintainRequestVO));
			
		}
		
		public function doMakeNewReqs():void{
			var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO();
			maintainRequestVO.func = serviceRequestDetailVO.func;
			maintainRequestVO.requestId = serviceRequestDetailVO.request.requestId;
			maintainRequestVO.caseNo = serviceRequestDetailVO.request.caseNo;
			maintainRequestVO.makeNewRequestInd = true;
			maintainRequestVO.errorBoxComponentId = errorBoxId;
			dispatchEvent(SvdReqEvent.createMaintainRequestEvent(maintainRequestVO));
		}
		
		public function downloadDocFile(obj:Object, type:int):void{
			var docFileVO:DocumentFileVO = new DocumentFileVO;
			if(type == 1){
				var referenceNo:String = obj as String;
				docFileVO.sourceFileId = referenceNo;
			}else if(type == 2){
				var id:int = obj as int;
				docFileVO.documentId = id;
			}
			dispatchEvent(SvdReqEvent.createDownloadFileEvent(docFileVO));
		}
	}
}

