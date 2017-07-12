package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.fmk.web.application.util.ValidationUtil;
	import hk.judiciary.icmssvd.view.common.constant.MessageBoxIdConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.util.DateUtil;
	import hk.judiciary.icmssvd.view.common.util.PartyVOUtil;
	import hk.judiciary.icmssvd.view.common.util.ValidateUtil;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.CourtRoomChambersVO;
	import hk.judiciary.icmssvd.view.common.vo.CourtVenueVO;
	import hk.judiciary.icmssvd.view.common.vo.FpApplicationNatureTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ProsecutionDepartmentVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.ProofEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.BatchSearchVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayPosReqBatchSearchResultVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.NextHearingDateGenerationVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestVO;
	
	[Event(name="initBatchSearchParams,searchPosRequestBatchList,clearEquireBatchResult,submitPosRequestList", 
		type="hk.judiciary.icmssvd.view.svdReq.event.ProofEvent")]
	
	[ManagedEvents("initBatchSearchParams", scope="local")]
	[ManagedEvents("searchPosRequestBatchList", scope="local")]
	[ManagedEvents("clearEquireBatchResult", scope="local")]
	[ManagedEvents("submitPosRequestList", scope="local")]
	public class EnquireProofOfSvdBatchFormPanelPM extends EventDispatcher
	{
		private var _selectedAccordionIndex:Array = [];
		
		private var _batchSearchVO:BatchSearchVO = new BatchSearchVO;
		
		private var _nextHearingDateGenerationVO:NextHearingDateGenerationVO = new NextHearingDateGenerationVO;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
		private var _comprisingCourtVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.CaseTypeVO")]
		private var _caseTypeVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.CourtRoomChambersVO")]
		private var _courtNumberVOs:ArrayCollection = new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.CourtRoomChambersVO")]
		private var _displayCourtNumberVOs:ArrayCollection = new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.FpApplicationNatureTypeVO")]
		private var _fpApplicationNatureTypeVOs:ArrayCollection = new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ProsecutionDepartmentVO")]
		private var _prosecutionDepartmentVOs:ArrayCollection = new ArrayCollection();
		
		private var _dateFormat:String = SvdReqConstant.DEFAULT_DATE_PATTERN;
		
		private var _functionVO:FunctionVO = new FunctionVO;
		
		private var _errorBoxId:String;
		
		[Bindable]
		public function get selectedAccordionIndex():Array {return this._selectedAccordionIndex;}
		public function set selectedAccordionIndex(value:Array):void {this._selectedAccordionIndex = value;}
		
		[Bindable]
		public function get functionVO():FunctionVO{ return this._functionVO; }
		public function set functionVO(value:FunctionVO):void { this._functionVO=value; }
		
		private var _selectComprisingCourt:String;
		private var _selectCaseType:String;
		private var _selectCourtRm:String;
		private var _selectApplicationNat:String;
		private var _selectProsecution:String;
		
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectComprisingCourt():String { return _selectComprisingCourt;} 
		public function set selectComprisingCourt(value:String):void { this._selectComprisingCourt=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectCaseType():String { return _selectCaseType;} 
		public function set selectCaseType(value:String):void { this._selectCaseType=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		[Bindable(event="updateCourtRm")]
		public function get selectCourtRm():String { return _selectCourtRm; } 
		public function set selectCourtRm(value:String):void { this._selectCourtRm=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectApplicationNat():String { return _selectApplicationNat; } 
		public function set selectApplicationNat(value:String):void { this._selectApplicationNat=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectProsecution():String { return _selectProsecution; } 
		public function set selectProsecution(value:String):void { this._selectProsecution=value; }
	
		[Bindable]
		public function get dateFormat():String { return _dateFormat; } 
		public function set dateFormat(value:String):void { this._dateFormat=value; }
		
		[Bindable]
		public function get errorBoxId():String { return _errorBoxId; } 
		public function set errorBoxId(value:String):void { this._errorBoxId=value; }
		
		[Bindable]
		public function get batchSearchVO():BatchSearchVO { return this._batchSearchVO; }
		public function set batchSearchVO(value:BatchSearchVO):void { this._batchSearchVO=value; }
		
		[Bindable]
		public function get nextHearingDateGenerationVO():NextHearingDateGenerationVO { return this._nextHearingDateGenerationVO; }
		public function set nextHearingDateGenerationVO(value:NextHearingDateGenerationVO):void { this._nextHearingDateGenerationVO=value; }
		
		[Bindable]
		public function get comprisingCourtVOs():ArrayCollection { return this._comprisingCourtVOs; }
		public function set comprisingCourtVOs(value:ArrayCollection):void { this._comprisingCourtVOs=value; }
		
		[Bindable]
		public function get caseTypeVOs():ArrayCollection { return this._caseTypeVOs; }
		public function set caseTypeVOs(value:ArrayCollection):void { this._caseTypeVOs=value; }
		
		[Bindable]
		public function get courtNumberVOs():ArrayCollection{return this._courtNumberVOs;}
		public function set courtNumberVOs(value:ArrayCollection):void{this._courtNumberVOs=value;}
		
		[Bindable]
		public function get displayCourtNumberVOs():ArrayCollection{return this._displayCourtNumberVOs;}
		public function set displayCourtNumberVOs(value:ArrayCollection):void{this._displayCourtNumberVOs=value;}
		
		[Bindable]
		public function get fpApplicationNatureTypeVOs():ArrayCollection{return this._fpApplicationNatureTypeVOs;}
		public function set fpApplicationNatureTypeVOs(value:ArrayCollection):void{this._fpApplicationNatureTypeVOs=value;}
		
		[Bindable]
		public function get prosecutionDepartmentVOs():ArrayCollection{return this._prosecutionDepartmentVOs;}
		public function set prosecutionDepartmentVOs(value:ArrayCollection):void{this._prosecutionDepartmentVOs=value;}
		
		private var _hourList:ArrayCollection = DateUtil.hourList;
		private var _minList:ArrayCollection = DateUtil.minList;
		
		[Bindable]
		public function get hourList():ArrayCollection {return this._hourList;}
		public function set hourList(value:ArrayCollection):void {this._hourList=value;}
		
		[Bindable]
		public function get minList():ArrayCollection {return this._minList;}
		public function set minList(value:ArrayCollection):void {this._minList=value;}
		
		private var _selectedHour:String;
		private var _selectedMin:String;
		
		[Bindable]
		public function get selectedHour():String {return this._selectedHour;}
		public function set selectedHour(value:String):void {this._selectedHour=value;}
		
		[Bindable]
		public function get selectedMin():String {return this._selectedMin;}
		public function set selectedMin(value:String):void {this._selectedMin=value;}
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayPosReqBatchSearchResultVO")]
		private var _displayPosReqBatchSearchResultVOs:ArrayCollection = new ArrayCollection();
		
		private var _submitAble:Boolean = false;
		
		[Bindable]
		[Bindable(event="updateResult")]
		public function get displayPosReqBatchSearchResultVOs():ArrayCollection {return this._displayPosReqBatchSearchResultVOs;}
		public function set displayPosReqBatchSearchResultVOs(value:ArrayCollection):void {this._displayPosReqBatchSearchResultVOs=value;}
		
		[Bindable]
		public function get submitAble():Boolean {return this._submitAble;}
		public function set submitAble(value:Boolean):void {this._submitAble=value;}
		
		public function init():void
		{
			selectedAccordionIndex = [0,1];
			errorBoxId = MessageBoxIdConstant.ENQ_PROOF_BATCH_ERROR;
			functionVO.courtLevelTypeCode = SvdReqConstant.COURT_LEVEL_TYPE_MAGISTRATES;
			dispatchEvent(ProofEvent.initBatchSearchParams(functionVO));
		}
		
		public function changCourt(court:Object):void{
			selectCourtRm = "";
			batchSearchVO.courtRoomChambers = null;
			var comprisingCourtVO:ComprisingCourtVO = court as ComprisingCourtVO;
			batchSearchVO.comprisingCourt = comprisingCourtVO;
			filterCourtNumByCom(batchSearchVO.comprisingCourt);
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
			batchSearchVO.courtRoomChambers = selectedCourtRm;
		}
		
		public function changCaseType(caseType:Object):void{
			batchSearchVO.caseType = caseType as CaseTypeVO;
		}
		
		public function changAppNature(appNature:Object):void{
			batchSearchVO.fpApplicationNatureType = appNature as FpApplicationNatureTypeVO;
		}
		
		public function changProsecution(prosecution:Object):void{
			batchSearchVO.prosecutionDepartment = prosecution as ProsecutionDepartmentVO;
		}
		
		public function doSearch():void
		{
			if(validate()){
				selectedAccordionIndex = [-1];
				batchSearchVO.func = functionVO;
				batchSearchVO.hearingStartTime.setHours(this._selectedHour, this._selectedMin);
				batchSearchVO.errorBoxComponentId = errorBoxId;
				dispatchEvent(ProofEvent.searchPosRequestBatchList(batchSearchVO));
			}
		}
		
		public function doClear():void{
			dispatchEvent(ProofEvent.clearEquireBatchResultEvent());
		}
		
		[MessageHandler(selector="clearEquireBatchResult", scope="local")]
		public function clearEquireBatchResultHandler(event:ProofEvent):void{
			this.resetValidation();
			batchSearchVO = new BatchSearchVO;
			selectComprisingCourt = "";
			selectCourtRm = "";
			displayCourtNumberVOs.removeAll();
			selectedHour = "";
			selectedMin = "";
			if(caseTypeVOs.length > 1){
				selectCaseType = SvdReqConstant.ALL;
			}else if(caseTypeVOs.length == 1){
				batchSearchVO.caseType = caseTypeVOs[0];
				selectCaseType = caseTypeVOs[0].caseTypeName;
			}
			if(fpApplicationNatureTypeVOs.length > 1){
				selectApplicationNat = SvdReqConstant.ALL;
			}else if(fpApplicationNatureTypeVOs.length == 1){
				batchSearchVO.fpApplicationNatureType = fpApplicationNatureTypeVOs[0];
				selectApplicationNat = fpApplicationNatureTypeVOs[0].englishFpApplicationNatureTypeName;
			}
			if(prosecutionDepartmentVOs.length > 1){
				selectProsecution = SvdReqConstant.ALL;
			}else if(prosecutionDepartmentVOs.length == 1){
				batchSearchVO.prosecutionDepartment = prosecutionDepartmentVOs[0];
				selectProsecution = prosecutionDepartmentVOs[0].prosecutionDepartmentName;
			}
			displayPosReqBatchSearchResultVOs.removeAll();
			dispatchEvent(new Event("updateSelectVal"));
		}
		
		public function validate():Boolean{
			this.resetValidation();
			var courtCheck:Boolean = (batchSearchVO.comprisingCourt != null && batchSearchVO.comprisingCourt.comprisingCourtId > 0);
			if(!courtCheck){
				ValidateUtil.addValidationMessage(MessageConstant.COURT_EMPTY, "batchCourtDropDown", errorBoxId);
			}
			var courtRmCheck:Boolean = (batchSearchVO.courtRoomChambers != null && batchSearchVO.courtRoomChambers.courtRoomChambersId > 0);
			if(!courtRmCheck){
				ValidateUtil.addValidationMessage(MessageConstant.COURT_RM_EMPTY, "batchCourtRoom", errorBoxId);
			}
			var hrnDateCheck:Boolean = (batchSearchVO.hearingScheduleDate != null);
			if(!hrnDateCheck){
				ValidateUtil.addValidationMessage(MessageConstant.HRN_DATE_EMPTY, "batchHrnDateInput", errorBoxId);
			}
			var result:Boolean = courtCheck && courtRmCheck && hrnDateCheck;
			
			if(!result){
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
		
		public function showSearchResult(value:ArrayCollection):void{
			displayPosReqBatchSearchResultVOs.removeAll();
			if(value != null && value.length > 0){
				for each (var posRequestDetailVO:PosRequestDetailVO in value){
					var tempDisplayVO:DisplayPosReqBatchSearchResultVO = new DisplayPosReqBatchSearchResultVO;
					var request:RequestVO = posRequestDetailVO.request;
					tempDisplayVO.caseNo = request.caseNo;
					tempDisplayVO.requesterName = PartyVOUtil.getRequestName(posRequestDetailVO.requester);
					tempDisplayVO.recipientName = PartyVOUtil.getRequestName(posRequestDetailVO.recipient);
					tempDisplayVO.handlingAgentName = request.handlingAgent.handlingAgentName;
					tempDisplayVO.servedByName = posRequestDetailVO.processedBy;
					tempDisplayVO.affirmation = posRequestDetailVO.posRequest.posDocumentInd;
					tempDisplayVO.dueDate = posRequestDetailVO.posRequest.posDocumentDueDate;
					tempDisplayVO.posRequestDetailVO = posRequestDetailVO;
					displayPosReqBatchSearchResultVOs.addItem(tempDisplayVO);
				}
			}
		}

		public function resetValidation():void
		{
			ValidationUtil.clearValidationMessage(errorBoxId);
		}
		
		public function checkSubmitAble():void{
			var selectedVOs:ArrayCollection = getSelectedResultVOs();
			if(selectedVOs.length > 0){
				submitAble = true;
			}else{
				submitAble = false;
			}
		}
		
		private function getSelectedResultVOs():ArrayCollection{
			var selectedVOs:ArrayCollection = new ArrayCollection;
			if(displayPosReqBatchSearchResultVOs.length > 0){
				for each(var displayVO:DisplayPosReqBatchSearchResultVO in displayPosReqBatchSearchResultVOs){
					if(displayVO.checked){
						displayVO.posRequestDetailVO.posRequest.posDocumentInd = displayVO.affirmation;
						displayVO.posRequestDetailVO.posRequest.attendCourtPersonInd = !displayVO.affirmation;
						displayVO.posRequestDetailVO.posRequest.posDocumentDueDate = displayVO.dueDate;
						selectedVOs.addItem(displayVO.posRequestDetailVO);
					}
				}
			}
			return selectedVOs;
		}
		
		public function submit():void{
			if(validAffirmation()){
				var selectedVOs:ArrayCollection = getSelectedResultVOs();
				dispatchEvent(ProofEvent.submitPosRequestListEvent(selectedVOs));
			}
		}
		
		public function changeAffirmation(obj:Object):void{
			var item:DisplayPosReqBatchSearchResultVO = obj as DisplayPosReqBatchSearchResultVO;
			item.dueDate = null;
			dispatchEvent(new Event("updateResult"));
		}
		
		public function validAffirmation():Boolean{
			var result:Boolean = true;
			var i:int = 0;
			var emptyIndexs:ArrayCollection = new ArrayCollection;
			if(displayPosReqBatchSearchResultVOs.length > 0){
				i++;
				for each(var displayVO:DisplayPosReqBatchSearchResultVO in displayPosReqBatchSearchResultVOs){
					if(displayVO.checked && displayVO.affirmation){
						if(displayVO.dueDate == null){
							emptyIndexs.addItem(i);
						}
					}
				}
			}
			if(emptyIndexs.length > 0){
				result = false;
			}
			if(!result){
				ValidateUtil.addValidationMessageDataGrid(MessageConstant.DUE_DATE_EMPTY, "dataGrid", errorBoxId,
					7, emptyIndexs);
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
	}
}
