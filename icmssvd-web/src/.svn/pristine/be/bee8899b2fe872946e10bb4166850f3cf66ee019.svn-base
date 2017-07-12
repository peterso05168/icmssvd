package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.fmk.view.component.MessageHandler;
	import hk.judiciary.fmk.view.component.event.AlertResponseEvent;
	import hk.judiciary.icmssvd.view.common.constant.CommonConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageBoxIdConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.util.DateUtil;
	import hk.judiciary.icmssvd.view.common.util.PartyVOUtil;
	import hk.judiciary.icmssvd.view.common.util.ValidateUtil;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.CourtRoomChambersVO;
	import hk.judiciary.icmssvd.view.common.vo.CourtVenueVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentFileVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.ProofEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayPosRequestDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DocumentVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosDocumentTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestDetailVO;
	
	[Event(name="initInputParams,submitPosRequest,downloadDocFile", 
		type="hk.judiciary.icmssvd.view.svdReq.event.ProofEvent")]
	
	[ManagedEvents("initInputParams", scope="local")]
	[ManagedEvents("submitPosRequest", scope="local")]
	[ManagedEvents("downloadDocFile", scope="local")]
	public class InputProofPanelPM extends EventDispatcher
	{
		private var _errorBoxId:String;
		private var _panelId:String;
		private var _dateFormat:String = SvdReqConstant.DEFAULT_DATE_PATTERN;
		private var _editable:Boolean = false;
		private var _posRequestDetailVO:PosRequestDetailVO;
		private var _displayPosRequestDetailVO:DisplayPosRequestDetailVO = new DisplayPosRequestDetailVO;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayDocumentVO")]
		public var _document:ArrayCollection = new ArrayCollection;
		public var _affofServ:Boolean = false;
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.PosDocumentTypeVO")]
		public var _posDocumentTypeVOs:ArrayCollection = new ArrayCollection;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
		private var _comprisingCourtVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.CourtRoomChambersVO")]
		private var _courtNumberVOs:ArrayCollection = new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.CourtRoomChambersVO")]
		private var _displayCourtNumberVOs:ArrayCollection = new ArrayCollection();
		
		[Bindable]
		public function get errorBoxId():String { return _errorBoxId; } 
		public function set errorBoxId(value:String):void { this._errorBoxId=value; }
		[Bindable]
		public function get panelId():String { return _panelId; } 
		public function set panelId(value:String):void { this._panelId=value; }
		[Bindable]
		public function get dateFormat():String { return _dateFormat; } 
		public function set dateFormat(value:String):void { this._dateFormat=value; }
		[Bindable]
		public function get editable():Boolean{ return this._editable; }
		public function set editable(value:Boolean):void{ this._editable = value; }
		[Bindable]
		public function get posRequestDetailVO():PosRequestDetailVO{ return this._posRequestDetailVO; }
		public function set posRequestDetailVO(value:PosRequestDetailVO):void{ this._posRequestDetailVO = value; }
		[Bindable]
		public function get displayPosRequestDetailVO():DisplayPosRequestDetailVO{ return this._displayPosRequestDetailVO; }
		public function set displayPosRequestDetailVO(value:DisplayPosRequestDetailVO):void{ this._displayPosRequestDetailVO = value; }		
		[Bindable]
		public function get document():ArrayCollection{ return this._document; }
		public function set document(value:ArrayCollection):void { this._document=value; }
		[Bindable]
		public function get affofServ():Boolean{ return this._affofServ; }
		public function set affofServ(value:Boolean):void{ this._affofServ = value; }
		[Bindable]
		public function get posDocumentTypeVOs():ArrayCollection{ return this._posDocumentTypeVOs; }
		public function set posDocumentTypeVOs(value:ArrayCollection):void { this._posDocumentTypeVOs=value; }
		
		[Bindable]
		public function get comprisingCourtVOs():ArrayCollection { return this._comprisingCourtVOs; }
		public function set comprisingCourtVOs(value:ArrayCollection):void { this._comprisingCourtVOs=value; }
		
		[Bindable]
		public function get displayCourtNumberVOs():ArrayCollection{return this._displayCourtNumberVOs;}
		public function set displayCourtNumberVOs(value:ArrayCollection):void{this._displayCourtNumberVOs=value;}
		
		[Bindable]
		public function get courtNumberVOs():ArrayCollection{return this._courtNumberVOs;}
		public function set courtNumberVOs(value:ArrayCollection):void{this._courtNumberVOs=value;}
		
		private var _hourList:ArrayCollection = DateUtil.hourList;
		private var _minList:ArrayCollection = DateUtil.minList;
		
		[Bindable]
		public function get hourList():ArrayCollection {return this._hourList;}
		public function set hourList(value:ArrayCollection):void {this._hourList=value;}
		
		[Bindable]
		public function get minList():ArrayCollection {return this._minList;}
		public function set minList(value:ArrayCollection):void {this._minList=value;}
		
		private var _selectedDocType:String;
		private var _selectedHour:String="09";
		private var _selectedMin:String="00";
		private var _selectComprisingCourt:String;
		private var _selectCourtRm:String;
		
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectComprisingCourt():String { return _selectComprisingCourt;} 
		public function set selectComprisingCourt(value:String):void { this._selectComprisingCourt=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		[Bindable(event="updateCourtRm")]
		public function get selectCourtRm():String { return _selectCourtRm; } 
		public function set selectCourtRm(value:String):void { this._selectCourtRm=value; }
		
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get selectedDocType():String {return this._selectedDocType;}
		public function set selectedDocType(value:String):void {this._selectedDocType=value;}
		
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get selectedHour():String {return this._selectedHour;}
		public function set selectedHour(value:String):void {this._selectedHour=value;}
		
		[Bindable]
		[Bindable(event="updateSelectedVal")]
		public function get selectedMin():String {return this._selectedMin;}
		public function set selectedMin(value:String):void {this._selectedMin=value;}

		public function changAffOfServ():void{
			if(affofServ){
				affofServ = false;
			}else{
				affofServ = true;
			}
		}
		
		public function changDocType(obj:Object):void{
			var selected:PosDocumentTypeVO = obj as PosDocumentTypeVO;
			posRequestDetailVO.posRequest.posDocumentType = selected;
		}
		
		
		public function changCourt(court:Object):void{
			selectCourtRm = "";
			var comprisingCourtVO:ComprisingCourtVO = court as ComprisingCourtVO;
			posRequestDetailVO.posRequest.comprisingCourt = comprisingCourtVO;
			filterCourtNumByCom(comprisingCourtVO);
			dispatchEvent(new Event("updateCourtRm"));
		}
		private function filterCourtNumByCom(comprisingCourt:ComprisingCourtVO):void{
			displayCourtNumberVOs.removeAll();
			var courtVen:CourtVenueVO = comprisingCourt.courtVenue;
			if(courtVen != null){
				var courtVenId:int = courtVen.courtVenueId;
				for each(var courtRm:CourtRoomChambersVO in courtNumberVOs){
					if(courtRm.courtVenue != null && (courtRm.courtVenue.courtVenueId == courtVenId)){
						displayCourtNumberVOs.addItem(courtRm);
					}
				}
			}
		}
		
		public function changCourtRm(courtRm:Object):void{
			var selectedCourtRm:CourtRoomChambersVO = courtRm as CourtRoomChambersVO;
			posRequestDetailVO.posRequest.courtRoomChambers = selectedCourtRm;
		}
		
		public function toProofRecord(posDetail:PosRequestDetailVO):void{
			posRequestDetailVO = posDetail;
			dispatchEvent(ProofEvent.initInputParams(posRequestDetailVO));
			if(posRequestDetailVO.func.courtLevelTypeCode == SvdReqConstant.COURT_LEVEL_TYPE_MAGISTRATES){
				panelId = "inputProofPanelMC.";
				errorBoxId = MessageBoxIdConstant.INPUT_PROOF_ERROR_MC;
			}else{
				panelId = "inputProofPanelDC.";
				errorBoxId = MessageBoxIdConstant.INPUT_PROOF_ERROR_DC;
			}
			if(posRequestDetailVO.errorBoxComponentId != null && posRequestDetailVO.errorBoxComponentId != ""){
				ValidateUtil.clearValidationMessage(errorBoxId);
			}
			
			if(posRequestDetailVO != null && posRequestDetailVO.posPanelMode == CommonConstant.COMMON_PANEL_MODE_EDIT){
				editable = true;
			}else{
				editable = false;
			}
			
			displayPosRequestDetailVO.requesterName = PartyVOUtil.getRequestName(posRequestDetailVO.requester);
			displayPosRequestDetailVO.recipientName = PartyVOUtil.getRequestName(posRequestDetailVO.recipient);
			displayPosRequestDetailVO.servedByName = posRequestDetailVO.processedBy;
			displayPosRequestDetailVO.posRequestDetailVO = posRequestDetailVO;
			setDocList();
			
			selectedDocType = "";
			selectedHour = "09";
			selectedMin = "00";
			selectComprisingCourt = "";
			selectCourtRm = "";
			if(posRequestDetailVO.posRequest.posDocumentInd){
				affofServ = true;
				if(posRequestDetailVO.posRequest.posDocumentType != null){
					selectedDocType = posRequestDetailVO.posRequest.posDocumentType.posDocumentTypeName;
				}
			}else{
				affofServ = false;
				if(posRequestDetailVO.posRequest.posHearingDatetime != null){
					selectedHour = DateUtil.zeroPad(posRequestDetailVO.posRequest.posHearingDatetime.getHours());
					selectedMin = DateUtil.zeroPad(posRequestDetailVO.posRequest.posHearingDatetime.getMinutes());
				}
				if(posRequestDetailVO.posRequest.comprisingCourt != null){
					var compsCourt:ComprisingCourtVO = posRequestDetailVO.posRequest.comprisingCourt;
					if(compsCourt.comprisingCourtCode != null && compsCourt.comprisingCourtName != null){
						selectComprisingCourt = compsCourt.comprisingCourtCode + "-" + compsCourt.comprisingCourtName;
					}
				}
				if(posRequestDetailVO.posRequest.courtRoomChambers != null){
					selectCourtRm = posRequestDetailVO.posRequest.courtRoomChambers.courtRoomChambersName;
				}
			}
			dispatchEvent(new Event("updateSelectedVal"));
		}
		
		private function setDocList():void{
			document.removeAll();
			if(posRequestDetailVO.documents != null && posRequestDetailVO.documents.length > 0){
				for each(var docVO:DocumentVO in posRequestDetailVO.documents){
					if(docVO.documentId > 0){
						var displayDoc:DisplayDocumentVO = new DisplayDocumentVO;
						displayDoc.documentId = docVO.documentId;
						if(docVO.documentType != null){
							displayDoc.documentName = docVO.documentType.documentTypeName;
						}
						if(docVO.documentFileBy != null){
							displayDoc.documentFileBy = docVO.documentFileBy.englishSurname 
								+ " " 
								+ docVO.documentFileBy.englishGivenName;
						} 
						displayDoc.documentFileDate = docVO.documentFileDate;
						displayDoc.documentRecordVO.document = docVO;
						if(docVO.cfsFileId != null && docVO.cfsFileId != ""){
							displayDoc.downloadAble = true;
						}
						if(!displayDoc.downloadAble){
							displayDoc.documentName += CommonConstant.PENDING_FOR_SCANNING;
						}
						document.addItem(displayDoc);
					}
				}
			}
		}
		
		public function doSubmit():void{
			if(validate()){
				MessageHandler.createConfirmationMessageBox(MessageConstant.CONFIRM_SAVE_MSG, null, null, doSubmitHandler);
			}
		}
		
		private function doSubmitHandler(event:AlertResponseEvent):void {
			if (event.type == AlertResponseEvent.YES) {
				if(!affofServ){
					posRequestDetailVO.posRequest.posHearingDatetime.setHours(this._selectedHour, this._selectedMin, "00");
				}
				posRequestDetailVO.posRequest.attendCourtPersonInd = !affofServ;
				posRequestDetailVO.posRequest.posDocumentInd = affofServ;
				posRequestDetailVO.errorBoxComponentId = errorBoxId;
				dispatchEvent(ProofEvent.submitPosRequestEvent(posRequestDetailVO));
			}
		}
		
		public function validate():Boolean{
			ValidateUtil.clearValidationMessage(errorBoxId);
			var dueDate:Boolean = true;
			var docType:Boolean = true;
			var hrnDate:Boolean = true;
			if(affofServ){
				dueDate = (posRequestDetailVO.posRequest.posDocumentDueDate != null);
				docType = (posRequestDetailVO.posRequest.posDocumentType != null && posRequestDetailVO.posRequest.posDocumentType.posDocumentTypeId > 0);
			}else{
				hrnDate = (posRequestDetailVO.posRequest.posHearingDatetime != null);
			}
			if(!dueDate){
				ValidateUtil.addValidationMessage(MessageConstant.DUE_DATE_EMPTY, panelId + "due", errorBoxId);
			}
			if(!docType){
				ValidateUtil.addValidationMessage(MessageConstant.DOC_TYPE_EMPTY, panelId + "bindableType", errorBoxId);
			}
			if(!hrnDate){
				ValidateUtil.addValidationMessage(MessageConstant.HRN_DATE_EMPTY, panelId + "hrn", errorBoxId);
			}
			var result:Boolean = (dueDate && docType && hrnDate);
			if(!result){
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
		
		public function downloadDocFile(id:int):void{
			var docFileVO:DocumentFileVO = new DocumentFileVO;
			docFileVO.documentId = id;
			dispatchEvent(ProofEvent.createDownloadFileEvent(docFileVO));
		}
	}
}

