package hk.judiciary.icmssvd.view.exeReq.presentation
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	
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
	import hk.judiciary.icmssvd.view.common.vo.HkDistrictVO;
	import hk.judiciary.icmssvd.view.common.vo.HkRegionVO;
	import hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO;
	import hk.judiciary.icmssvd.view.exeReq.event.ExeReqEvent;
	import hk.judiciary.icmssvd.view.exeReq.vo.ExecutionRequestDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.vo.AddressRoleVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.AddressVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayAddressRoleVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayPartyVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DocumentRecordVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PartyVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestAddressVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestParticipantRoleVO;
	
	[Event(name="initInputParams,initResultParams,saveDraftExecutionRequest,submitExecutionRequest,withdrawExecutionRequest,downloadDocFile", 
			type="hk.judiciary.icmssvd.view.svdReq.event.ExeReqEvent")]
	
	[ManagedEvents("initInputParams", scope="local")]
	[ManagedEvents("initResultParams", scope="local")]
	[ManagedEvents("saveDraftExecutionRequest", scope="local")]
	[ManagedEvents("submitExecutionRequest", scope="local")]
	[ManagedEvents("withdrawExecutionRequest", scope="local")]
	[ManagedEvents("downloadDocFile", scope="local")]
	public class InputExeReqPanelPM extends EventDispatcher
	{
		[Inject]
		public var moduleController:IModuleController;
		
		private var _selectedAccordionIndex:Array = [];
		private var _errorBoxId:String;
		private var _panelId:String;
		private var _exeReqsEditable:Boolean=true;
		private var _docListEditable:Boolean=true;
		private var _exeResEditable:Boolean=true;
		
		private var _executionRequestDetailVO:ExecutionRequestDetailVO = null;
		private var _applicantDisplayName:String;
		private var _addrSeqName:String;
		private var _hkDistrictName:String;
		private var _hkRegionName:String;
		private var _bailiffOfficeName:String;
		private var _documentType:String;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentVO")]
		public var _document:ArrayCollection = new ArrayCollection;
		public var _submitDate:String;
		
		private var _dateFormat:String = SvdReqConstant.DEFAULT_DATE_PATTERN;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayPartyVO")]
		public var _displayApplicantVOs:ArrayCollection = new ArrayCollection;
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
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO")]
		private var _documentTypeVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultReasonVO")]
		private var _bailiffTaskResultReasonVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffTaskResultStatusVO")]
		private var _bailiffTaskResultStatusVOs:ArrayCollection=new ArrayCollection();
		
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
		public function get executionRequestDetailVO():ExecutionRequestDetailVO{ return this._executionRequestDetailVO; }
		public function set executionRequestDetailVO(value:ExecutionRequestDetailVO):void { this._executionRequestDetailVO=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get applicantDisplayName():String {return _applicantDisplayName;  } 
		public function set applicantDisplayName(value:String):void { this._applicantDisplayName=value; }
		[Bindable]
		[Bindable (event="updateAddrSeq")]
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
		public function get bailiffOfficeName():String {return _bailiffOfficeName;  } 
		public function set bailiffOfficeName(value:String):void { this._bailiffOfficeName=value; }
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get documentType():String {return _documentType;  } 
		public function set documentType(value:String):void { this._documentType=value; }
		[Bindable]
		public function get document():ArrayCollection{ return this._document; }
		public function set document(value:ArrayCollection):void { this._document=value; }
		[Bindable]
		public function get submitDate():String { return _submitDate; } 
		public function set submitDate(value:String):void { this._submitDate=value; }
		
		[Bindable]
		public function get dateFormat():String { return _dateFormat; } 
		public function set dateFormat(value:String):void { this._dateFormat=value; }
		[Bindable]
		public function get exeReqsEditable():Boolean{ return this._exeReqsEditable; }
		public function set exeReqsEditable(value:Boolean):void { this._exeReqsEditable=value; }
		[Bindable]
		public function get docListEditable():Boolean{ return this._docListEditable; }
		public function set docListEditable(value:Boolean):void { this._docListEditable=value; }
		[Bindable]
		public function get exeResEditable():Boolean{ return this._exeResEditable; }
		public function set exeResEditable(value:Boolean):void { this._exeResEditable=value; }
		[Bindable]
		public function get displayApplicantVOs():ArrayCollection {return _displayApplicantVOs;  } 
		public function set displayApplicantVOs(value:ArrayCollection):void { this._displayApplicantVOs=value; }
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
		public function get documentTypeVOs():ArrayCollection {return _documentTypeVOs;  } 
		public function set documentTypeVOs(value:ArrayCollection):void { this._documentTypeVOs=value; }
		[Bindable]
		public function get bailiffTaskResultReasonVOs():ArrayCollection {return _bailiffTaskResultReasonVOs;  } 
		public function set bailiffTaskResultReasonVOs(value:ArrayCollection):void { this._bailiffTaskResultReasonVOs=value; }
		[Bindable]
		public function get bailiffTaskResultStatusVOs():ArrayCollection {return _bailiffTaskResultStatusVOs;  } 
		public function set bailiffTaskResultStatusVOs(value:ArrayCollection):void { this._bailiffTaskResultStatusVOs=value; }
		
		public function init():void{
			selectedAccordionIndex = [0,1];
			panelId = "inputExeReqPanel.";
			errorBoxId = MessageBoxIdConstant.INPUT_EXEREQ_ERROR;
		}
		
		public function toExecutionRequestDetailVO(returnVal:ExecutionRequestDetailVO):void{
			executionRequestDetailVO = returnVal as ExecutionRequestDetailVO;
			if(executionRequestDetailVO.errorBoxComponentId != null && executionRequestDetailVO.errorBoxComponentId != ""){
				ValidationUtil.clearValidationMessage(errorBoxId);
			}
			
			//to do with null object
			dealWithNullObj();
			
			//private method to set enabled
			setEnabledField();
			
			if(exeReqsEditable){
				dispatchEvent(ExeReqEvent.initInputParams(executionRequestDetailVO));
			}

			if(exeResEditable){
				dispatchEvent(ExeReqEvent.initResultParams(executionRequestDetailVO.func));
			}
			
			//private method to set applicant and applicants
			setApplicantOfExe();
			
			//set vaules to selected item(focus on)
			setValToSelected();
				
			//to display Document List
			setDocList();
			
			//to display Service Result fields
			setServiceRsltFields();
		}
		
		private function dealWithNullObj():void{
			if(executionRequestDetailVO.request.submissionDatetime != null){
				submitDate = DateUtil.toFormattedDateString(executionRequestDetailVO.request.submissionDatetime);
			}
			
			if(executionRequestDetailVO.request.requestStatusType == null){
				executionRequestDetailVO.request.requestStatusType = new RequestStatusTypeVO;
			}
			
			if(executionRequestDetailVO.request.bailiffOffice == null){
				executionRequestDetailVO.request.bailiffOffice = new BailiffOfficeVO;
			}
			if(executionRequestDetailVO.requestAddress == null){
				executionRequestDetailVO.requestAddress = new RequestAddressVO;
			}
		}
		
		private function setEnabledField():void{
			if(CommonConstant.COMMON_PANEL_MODE_READONLY == executionRequestDetailVO.executionRequestPanelMode){
				this.exeReqsEditable = false;
			}else if(CommonConstant.COMMON_PANEL_MODE_EDIT == executionRequestDetailVO.executionRequestPanelMode){
				this.exeReqsEditable = true;
			}
			if(CommonConstant.COMMON_PANEL_MODE_READONLY == executionRequestDetailVO.documentListPanelMode){
				this.docListEditable = false;
			}else if(CommonConstant.COMMON_PANEL_MODE_EDIT == executionRequestDetailVO.documentListPanelMode){
				this.docListEditable = true;
			}
			if(CommonConstant.COMMON_PANEL_MODE_READONLY == executionRequestDetailVO.executionResultPanelMode){
				this.exeResEditable = false;
			}else if(CommonConstant.COMMON_PANEL_MODE_EDIT == executionRequestDetailVO.executionResultPanelMode){
				this.exeResEditable = true;
			}
		}
		
		private function setApplicantOfExe():void{
			displayApplicantVOs.removeAll();
			displayAddressRoleVOs.removeAll();
			if(executionRequestDetailVO.applicants != null && executionRequestDetailVO.applicants.length > 0){
				for each (var applicant:PartyVO in executionRequestDetailVO.applicants){
					var displayApp:DisplayPartyVO = new DisplayPartyVO;
					displayApp.participantId = applicant.participantId;
					displayApp.displayName = PartyVOUtil.getRequestNameWithChi(applicant);;
					displayApp.partyVO = applicant;
					displayApplicantVOs.addItem(displayApp);
					if(executionRequestDetailVO.applicant != null 
						&& executionRequestDetailVO.applicant.participantId == applicant.participantId){
						var addrRoles:ArrayCollection = applicant.addressRoles;
						if(addrRoles != null && addrRoles.length > 0){
							for each(var addrRole:AddressRoleVO in addrRoles){
								var displayAddressRoleVO:DisplayAddressRoleVO = new DisplayAddressRoleVO;
								displayAddressRoleVO.addressRoleId = addrRole.addressRoleId;
								displayAddressRoleVO.addressRoleTypeName = getAddrSeqName(addrRole);
								displayAddressRoleVO.addressRoleVO = addrRole;
								displayAddressRoleVOs.addItem(displayAddressRoleVO);
							}
						}
					}
				}
			}
		}
		
		private function setValToSelected():void{
			applicantDisplayName = "";
			hkDistrictName = "";
			hkRegionName = "";
			bailiffOfficeName = "";
			documentType = "";
			addrSeqName = "";
			applicantDisplayName = PartyVOUtil.getRequestNameWithChi(executionRequestDetailVO.applicant);
			if(executionRequestDetailVO.requestAddress.hkDistrict != null){
				hkDistrictName = executionRequestDetailVO.requestAddress.hkDistrict.hkDistrictName;
				if(executionRequestDetailVO.requestAddress.hkDistrict.hkRegion != null){
					hkRegionName = executionRequestDetailVO.requestAddress.hkDistrict.hkRegion.hkRegionName;
				}
			}
			
			if(executionRequestDetailVO.request.bailiffOffice != null){
				bailiffOfficeName = executionRequestDetailVO.request.bailiffOffice.bailiffOfficeName;
			}
			
			if(executionRequestDetailVO.executionRequest.documentType != null){
				documentType = executionRequestDetailVO.executionRequest.documentType.documentTypeName;
			}
			
			//to default start
			if(executionRequestDetailVO.requestAddress.hkRegion != null){
				hkRegionName = executionRequestDetailVO.requestAddress.hkRegion.hkRegionName;
			}
			//to default end
			dispatchEvent(new Event("updateSelectedVal"));
		}
		
		private function setDocList():void{
			document.removeAll();
			if(executionRequestDetailVO.documentRecords != null && executionRequestDetailVO.documentRecords.length > 0){
				for each(var reqsDoc:DocumentRecordVO in executionRequestDetailVO.documentRecords){
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
			if(executionRequestDetailVO.submittedModeInd){
				if(executionRequestDetailVO.requestResult != null){
					if(executionRequestDetailVO.requestResult.bailiffTaskResultStatus != null){
						resultStatusName = executionRequestDetailVO.requestResult.bailiffTaskResultStatus.bailiffTaskResultStatusName;
					}
					if(executionRequestDetailVO.requestResult.bailiffTaskResultReason != null){
						resultReasonName = executionRequestDetailVO.requestResult.bailiffTaskResultReason.bailiffTaskResultReasonName;
					}
				}
			}
		}
		
		public function changApplicant(obj:Object):void{
			var bindableApplicant:DisplayPartyVO = obj as DisplayPartyVO;
			executionRequestDetailVO.applicant = bindableApplicant.partyVO;
			displayAddressRoleVOs.removeAll();
			var addr:AddressVO;
			var addrRoles:ArrayCollection = executionRequestDetailVO.applicant.addressRoles;
			if(addrRoles != null && addrRoles.length > 0){
				for each(var addrRole:AddressRoleVO in addrRoles){
					var displayAddressRoleVO:DisplayAddressRoleVO = new DisplayAddressRoleVO;
					displayAddressRoleVO.addressRoleId = addrRole.addressRoleId;
					displayAddressRoleVO.addressRoleTypeName = getAddrSeqName(addrRole);
					displayAddressRoleVO.addressRoleVO = addrRole;
					displayAddressRoleVOs.addItem(displayAddressRoleVO);
					if(addrRole.executionServiceInd){
						addr = addrRole.address;
						addrSeqName = displayAddressRoleVO.addressRoleTypeName;
					}
				}
			}
			if(addr != null){
				executionRequestDetailVO.requestAddress.hkDistrict = addr.hkDistrict;
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
			dispatchEvent(new Event("updateAddrSeq"));
		}
		
		private function setAddr(addr:AddressVO):void{
			if(addr == null){
				addr = new AddressVO;
			}
			executionRequestDetailVO.requestAddress.englishAddress1 = addr.englishAddress1;
			executionRequestDetailVO.requestAddress.englishAddress2 = addr.englishAddress2;
			executionRequestDetailVO.requestAddress.englishAddress3 = addr.englishAddress3;
			executionRequestDetailVO.requestAddress.chineseAddress1 = addr.chineseAddress1;
			executionRequestDetailVO.requestAddress.chineseAddress2 = addr.chineseAddress2;
			executionRequestDetailVO.requestAddress.chineseAddress3 = addr.chineseAddress3;
			executionRequestDetailVO.requestAddress.foreignAddressInd = addr.foreignAddressInd;
			
		}
		
		public function changeAddrSeq(obj:Object):void{
			var bindableAddressRoleVO:DisplayAddressRoleVO = obj as DisplayAddressRoleVO;
			if(bindableAddressRoleVO != null && bindableAddressRoleVO.addressRoleVO != null){
				var addrRole:AddressRoleVO = bindableAddressRoleVO.addressRoleVO;
				if(addrRole.executionServiceInd && addrRole.addressRoleType != null){
						addrSeqName = getAddrSeqName(addrRole);
						setAddr(addrRole.address);
				}
			}
		}
		
		private function getAddrSeqName(addrRole:AddressRoleVO):String{
			var name:String = "(" + addrRole.addressSequenceNo + ") ";
			if(addrRole.addressRoleType != null){
				name += addrRole.addressRoleType.addressRoleTypeName;
			}
			return name;
		}
		
		public function changHkDistrict(obj:Object):void{
			var bindableHkDistrict:HkDistrictVO = obj as HkDistrictVO;
			executionRequestDetailVO.requestAddress.hkDistrict = bindableHkDistrict;
		}
		
		public function changHkRegion(obj:Object):void{
			if(obj != null){
				var bindableHkRegion:HkRegionVO = obj as HkRegionVO;
				executionRequestDetailVO.requestAddress.hkRegion = bindableHkRegion;
				filterDistrictByRgn(bindableHkRegion);
			}else{
				executionRequestDetailVO.requestAddress.hkRegion = new HkRegionVO;
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
			
			if(executionRequestDetailVO.requestAddress.hkDistrict != null 
				&& executionRequestDetailVO.requestAddress.hkDistrict.hkRegion != null 
				&& executionRequestDetailVO.requestAddress.hkDistrict.hkRegion.hkRegionId != rgn.hkRegionId){
				executionRequestDetailVO.requestAddress.hkDistrict = new HkDistrictVO;
				hkDistrictName = " ";
			}
		}
		
		public function changBailiffOffice(obj:Object):void{
			var bindableBailiffOffice:BailiffOfficeVO = obj as BailiffOfficeVO;
			executionRequestDetailVO.request.bailiffOffice = bindableBailiffOffice;
			executionRequestDetailVO.requestAddress.bailiffOffice = bindableBailiffOffice;
		}
		
		public function changDocumentType(obj:Object):void{
			var bindableDocumentType:DocumentTypeVO = obj as DocumentTypeVO;
			executionRequestDetailVO.executionRequest.documentType = bindableDocumentType;
		}

		public function doSaveDraft():void{
			if(validate()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doSaveHandler);
			}
		}
		
		private function doSaveHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				formExecutionRequestDetailVO();
				dispatchEvent(ExeReqEvent.saveDraftEvent(executionRequestDetailVO));
			}
		}
		
		public function doSubmit():void{
			if(validate()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doSubmitHandler);
			}
		}
		
		private function doSubmitHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				formExecutionRequestDetailVO();
				dispatchEvent(ExeReqEvent.submitEvent(executionRequestDetailVO));
			}
		}
		
		public function doWithdraw():void{
			if(validate()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doWithdrawHandler);
			}
		}
		
		private function doWithdrawHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				formExecutionRequestDetailVO();
				dispatchEvent(ExeReqEvent.withdrawEvent(executionRequestDetailVO));
			}
		}

		private function validate():Boolean{
			resetValidation();
			var addrBl:Boolean = true;
			var regionBl:Boolean = false;
			var bailiffOffice:Boolean = false;
			var docType:Boolean = false;
				
			var applicantBl:Boolean = (executionRequestDetailVO.applicant != null && executionRequestDetailVO.applicant.participantId > 0);
			if(!applicantBl){
				ValidateUtil.addValidationMessage(MessageConstant.APPLICANT_EMPTY, panelId + "bindableApplicant", errorBoxId);
			}
				
			var addrErrBoxs:ArrayCollection = new ArrayCollection;
			if(executionRequestDetailVO.requestAddress != null){
				if(!emptyStrValid(executionRequestDetailVO.requestAddress.englishAddress1)){
					addrErrBoxs.addItem(panelId + "AddressEng1");
				}
				if(!emptyStrValid(executionRequestDetailVO.requestAddress.englishAddress2)){
					addrErrBoxs.addItem(panelId + "AddressEng2");
				}
				if(!emptyStrValid(executionRequestDetailVO.requestAddress.englishAddress3)){
					addrErrBoxs.addItem(panelId + "AddressEng3");
				}
				if(!emptyStrValid(executionRequestDetailVO.requestAddress.chineseAddress1)){
					addrErrBoxs.addItem(panelId + "AddressChi1");
				}
				if(!emptyStrValid(executionRequestDetailVO.requestAddress.chineseAddress2)){
					addrErrBoxs.addItem(panelId + "AddressChi2");
				}
				if(!emptyStrValid(executionRequestDetailVO.requestAddress.chineseAddress3)){
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
			
			if(executionRequestDetailVO.requestAddress.hkRegion != null && executionRequestDetailVO.requestAddress.hkRegion.hkRegionId != 0){
				regionBl = true;
			}else{
				ValidateUtil.addValidationMessage(MessageConstant.REGION_EMPTY, panelId + "bindableHkRegion", errorBoxId);
			}
			
			if(executionRequestDetailVO.request.bailiffOffice != null && executionRequestDetailVO.request.bailiffOffice.bailiffOfficeId != 0){
				bailiffOffice = true;
			}else{
				ValidateUtil.addValidationMessage(MessageConstant.BAI_OFFI_EMPTY, panelId + "bindableBailiffOffice", errorBoxId);
			}

			if(executionRequestDetailVO.executionRequest.documentType != null && executionRequestDetailVO.executionRequest.documentType.documentTypeId != 0){
				docType = true;
			}else{
				ValidateUtil.addValidationMessage(MessageConstant.DOCTYPE_EMPTY, panelId + "bindableDocType", errorBoxId);
			}
			
			var result:Boolean = applicantBl && addrBl && regionBl && bailiffOffice && docType;
			if(!result){
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
		
		public function emptyStrValid(obj:String):Boolean{
			return obj != null && obj != "";
		}
		
		private function formExecutionRequestDetailVO():void{
			var requestParticipantRole:RequestParticipantRoleVO = null;
			if(executionRequestDetailVO.requestParticipantRole != null){
				requestParticipantRole = executionRequestDetailVO.requestParticipantRole;
				requestParticipantRole.requestId = executionRequestDetailVO.request.requestId;
				requestParticipantRole.participantId = executionRequestDetailVO.applicant.participantId;
				requestParticipantRole.originalParticipantRoleId = executionRequestDetailVO.applicant.participantRoleId
				requestParticipantRole.participantRoleTypeId = executionRequestDetailVO.applicant.partyCategoryId;
				requestParticipantRole.participantRoleTypeId = executionRequestDetailVO.applicant.participantRoleType.participantRoleTypeId;
				requestParticipantRole.respondentSeqNo = executionRequestDetailVO.applicant.respondentSeqNo;
				requestParticipantRole.respondentSubSeqNo = executionRequestDetailVO.applicant.respondentSubSeqNo;
			}
			executionRequestDetailVO.requestParticipantRole = requestParticipantRole;
			
			executionRequestDetailVO.documentRecords.removeAll();
			if(document != null && document.length > 0){
				for each (var displayDoc:DisplayDocumentVO in document){
					if(displayDoc.checked){
						displayDoc.documentRecordVO.selectedDocumentInd = true;
					}else{
						displayDoc.documentRecordVO.selectedDocumentInd = false;
					}
					executionRequestDetailVO.documentRecords.addItem(displayDoc.documentRecordVO);
				}
			}
			executionRequestDetailVO.errorBoxComponentId = errorBoxId;
		}
		
		public function resetValidation():void
		{
			ValidationUtil.clearValidationMessage(errorBoxId);
		}
		
		public function resultHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
//				if (_isEdit) {
//					_updateRosterRecordVO.rosterRecordDTO.needValidate = false;
//					dispatchEvent(JjoRosterFormEvent.createUpdateDutyJudgeRosterEvent(_updateRosterRecordVO));
//				} else {
//					_rosterRecordVO.needValidate = false;
//					dispatchEvent(JjoRosterFormEvent.createCreateDutyJudgeRosterEvent(_rosterRecordVO));
//				}
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
			executionRequestDetailVO.requestResult.bailiffTaskResultStatus = status;
		}
		public function changeBailiffTaskResultReason(obj:Object):void{
			var reason:BailiffTaskResultReasonVO = obj as BailiffTaskResultReasonVO;
			executionRequestDetailVO.requestResult.bailiffTaskResultReason = reason;
		}
		
		public function downloadDocFile(id:int):void{
			var docFileVO:DocumentFileVO = new DocumentFileVO;
			docFileVO.documentId = id;
			dispatchEvent(ExeReqEvent.createDownloadFileEvent(docFileVO));
		}
	}
}

