package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.fmk.view.component.MessageHandler;
	import hk.judiciary.fmk.web.application.util.ValidationUtil;
	import hk.judiciary.fmk.web.infrastructure.OpenFunctionHandler;
	import hk.judiciary.fmk.web.infrastructure.PortalEventConstant;
	import hk.judiciary.fmk.web.infrastructure.ServerWindow;
	import hk.judiciary.icmssvd.view.common.constant.CommonConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageBoxIdConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.util.DateUtil;
	import hk.judiciary.icmssvd.view.common.util.PartyVOUtil;
	import hk.judiciary.icmssvd.view.common.util.ValidateUtil;
	import hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.CourtRoomChambersVO;
	import hk.judiciary.icmssvd.view.common.vo.CourtVenueVO;
	import hk.judiciary.icmssvd.view.common.vo.FpApplicationNatureTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.ProsecutionDepartmentVO;
	import hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.ReServEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.BatchSearchVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.CertifcateBulkPostingVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayReServiceDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.NextHearingDateGenerationVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.NextHearingDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ReserviceBatchSearchResultVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ReserviceRequestDetailVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestVO;
	
	[Event(name="initSearchParams,searchAbsentDefenantsList,clearEquireReServResult,reGenDefHrnDate,confirmHearingSchedule,maintainRequest,generateCertificateBulkPosting,saveDraftAndGenDoc,saveDraftReserviceRequest,submitReserviceRequest", 
		type="hk.judiciary.icmssvd.view.svdReq.event.ReServEvent")]
	
	[ManagedEvents("initSearchParams", scope="local")]
	[ManagedEvents("searchAbsentDefenantsList", scope="local")]
	[ManagedEvents("clearEquireReServResult", scope="local")]
	[ManagedEvents("reGenDefHrnDate", scope="local")]
	[ManagedEvents("confirmHearingSchedule", scope="local")]
	[ManagedEvents("maintainRequest", scope="local")]
	[ManagedEvents("generateCertificateBulkPosting", scope="local")]
	[ManagedEvents("saveDraftAndGenDoc", scope="local")]
	[ManagedEvents("saveDraftReserviceRequest", scope="local")]
	[ManagedEvents("submitReserviceRequest", scope="local")]
	public class EnquireReServiceFormPanelPM extends EventDispatcher
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
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO")]
		private var _serviceModeTypeVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO")]
		private var _handlingAgentVOs:ArrayCollection=new ArrayCollection();
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.BailiffOfficeVO")]
		public var _bailiffOfficeVOs:ArrayCollection = new ArrayCollection;
		
		[Bindable]
		public function get serviceModeTypeVOs():ArrayCollection { return this._serviceModeTypeVOs; }
		public function set serviceModeTypeVOs(value:ArrayCollection):void { this._serviceModeTypeVOs=value; }
		[Bindable]
		public function get handlingAgentVOs():ArrayCollection { return this._handlingAgentVOs; }
		public function set handlingAgentVOs(value:ArrayCollection):void { this._handlingAgentVOs=value; }
		[Bindable]
		public function get bailiffOfficeVOs():ArrayCollection {return _bailiffOfficeVOs;  } 
		public function set bailiffOfficeVOs(value:ArrayCollection):void { this._bailiffOfficeVOs=value; }
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.ReserviceBatchSearchResultVO")]
		private var _reserviceBatchSearchResultVOs:ArrayCollection=new ArrayCollection();

		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayReServiceDetailVO")]
		private var _nextHearingDetailVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayReServiceDetailVO")]
		private var _reserviceRequestDetailVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayReServiceDetailVO")]
		private var _dopReserviceRequestDetailVOs:ArrayCollection=new ArrayCollection();
		
		private var _overridDays:String = "";
		private var _mailBarcodeFrom:String = "";
		private var _mailBarcodeTo:String = "";
		private var _forFirstClerk:String = "";
		private var _posFee:String = "";
		private var _regenDefHrnVisable:Boolean = false;
		private var _genDefHrnAble:Boolean = false;
		private var _regenDefHrnAble:Boolean = false;
		private var _confirmAble:Boolean = false;
		private var _fillInAble:Boolean = false;
		private var _genCerAble:Boolean = false;
		
		[Bindable]
		public function get reserviceBatchSearchResultVOs():ArrayCollection { return this._reserviceBatchSearchResultVOs; }
		public function set reserviceBatchSearchResultVOs(value:ArrayCollection):void { this._reserviceBatchSearchResultVOs=value; }
		//TODO:  to test if clear can work(searchResult change to empty)
		[Bindable]
		[Bindable(event="updateSearchResult")]
		public function get nextHearingDetailVOs():ArrayCollection { return this._nextHearingDetailVOs; }
		public function set nextHearingDetailVOs(value:ArrayCollection):void { this._nextHearingDetailVOs=value; }
		[Bindable]
		[Bindable(event="updateSearchResult")]
		public function get reserviceRequestDetailVOs():ArrayCollection { return this._reserviceRequestDetailVOs; }
		public function set reserviceRequestDetailVOs(value:ArrayCollection):void { this._reserviceRequestDetailVOs=value; }
		[Bindable]
		[Bindable(event="updateSearchResult")]
		public function get dopReserviceRequestDetailVOs():ArrayCollection { return this._dopReserviceRequestDetailVOs; }
		public function set dopReserviceRequestDetailVOs(value:ArrayCollection):void { this._dopReserviceRequestDetailVOs=value; }
		[Bindable]
		public function get overridDays():String {return this._overridDays;}
		public function set overridDays(value:String):void {this._overridDays=value;}
		[Bindable]
		public function get mailBarcodeFrom():String {return this._mailBarcodeFrom;}
		public function set mailBarcodeFrom(value:String):void {this._mailBarcodeFrom=value;}
		[Bindable]
		public function get mailBarcodeTo():String {return this._mailBarcodeTo;}
		public function set mailBarcodeTo(value:String):void {this._mailBarcodeTo=value;}
		[Bindable]
		public function get forFirstClerk():String {return this._forFirstClerk;}
		public function set forFirstClerk(value:String):void {this._forFirstClerk=value;}
		[Bindable]
		public function get posFee():String {return this._posFee;}
		public function set posFee(value:String):void {this._posFee=value;}
		[Bindable]
		public function get regenDefHrnVisable():Boolean {return this._regenDefHrnVisable;}
		public function set regenDefHrnVisable(value:Boolean):void {this._regenDefHrnVisable=value;}
		[Bindable]
		public function get genDefHrnAble():Boolean {return this._genDefHrnAble;}
		public function set genDefHrnAble(value:Boolean):void {this._genDefHrnAble=value;}
		[Bindable]
		public function get regenDefHrnAble():Boolean {return this._regenDefHrnAble;}
		public function set regenDefHrnAble(value:Boolean):void {this._regenDefHrnAble=value;}
		[Bindable]
		public function get confirmAble():Boolean {return this._confirmAble;}
		public function set confirmAble(value:Boolean):void {this._confirmAble=value;}
		[Bindable]
		public function get fillInAble():Boolean {return this._fillInAble;}
		public function set fillInAble(value:Boolean):void {this._fillInAble=value;}
		[Bindable]
		public function get genCerAble():Boolean {return this._genCerAble;}
		public function set genCerAble(value:Boolean):void {this._genCerAble=value;}
		
		
		private var _saveAble:Boolean = false;
		private var _submitAble:Boolean = false;
		[Bindable]
		public function get saveAble():Boolean {return this._saveAble;}
		public function set saveAble(value:Boolean):void {this._saveAble=value;}
		[Bindable]
		public function get submitAble():Boolean {return this._submitAble;}
		public function set submitAble(value:Boolean):void {this._submitAble=value;}
		
		public function init():void
		{
			selectedAccordionIndex = [0,1,2];
			errorBoxId = MessageBoxIdConstant.ENQ_RESERV_ERROR;
			functionVO.courtLevelTypeCode = SvdReqConstant.COURT_LEVEL_TYPE_MAGISTRATES;
			dispatchEvent(ReServEvent.initSearchParams(functionVO));
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
				batchSearchVO.func = functionVO;
				batchSearchVO.hearingStartTime.setHours(this._selectedHour, this._selectedMin);
				dispatchEvent(ReServEvent.searchAbsentDefenantsList(batchSearchVO));
			}
		}
		
		public function doClear():void{
			dispatchEvent(ReServEvent.clearEquireReServResultEvent());
		}
		
		[MessageHandler(selector="clearEquireReServResult", scope="local")]
		public function clearEquireReServResultHandler(event:ReServEvent):void{
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
			
			nextHearingDetailVOs.removeAll();
			reserviceRequestDetailVOs.removeAll();
			dopReserviceRequestDetailVOs.removeAll();
			resetInputAndBtns();
			
			dispatchEvent(new Event("updateSelectVal"));
		}
		
		private function resetInputAndBtns():void{
			genDefHrnAble = false;
			regenDefHrnAble = false;
			confirmAble = false;
			fillInAble = false;
			genCerAble = false;
			saveAble = false;
			submitAble = false;
			overridDays = "";
			mailBarcodeFrom = "";
			mailBarcodeTo = "";
			forFirstClerk = "";
			posFee = "";
		}
		
		public function validate():Boolean{
			this.resetValidation();
			resetInputAndBtns();
			var courtCheck:Boolean = (batchSearchVO.comprisingCourt != null && batchSearchVO.comprisingCourt.comprisingCourtId > 0);
			if(!courtCheck){
				ValidateUtil.addValidationMessage(MessageConstant.COURT_EMPTY, "courtDropDown", errorBoxId);
			}
			var courtRmCheck:Boolean = (batchSearchVO.courtRoomChambers != null && batchSearchVO.courtRoomChambers.courtRoomChambersId > 0);
			if(!courtRmCheck){
				ValidateUtil.addValidationMessage(MessageConstant.COURT_RM_EMPTY, "courtRoom", errorBoxId);
			}
			var hrnDateCheck:Boolean = (batchSearchVO.hearingScheduleDate != null);
			if(!hrnDateCheck){
				ValidateUtil.addValidationMessage(MessageConstant.HRN_DATE_EMPTY, "hrnDateInput", errorBoxId);
			}
			var result:Boolean = courtCheck && courtRmCheck && hrnDateCheck;
			
			if(!result){
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
		
		public function showSearchResult(value:ArrayCollection):void{
			nextHearingDetailVOs.removeAll();
			reserviceRequestDetailVOs.removeAll();
			dopReserviceRequestDetailVOs.removeAll();
			resetInputAndBtns();
			
			var bailiff:HandlingAgentVO;
			var police:HandlingAgentVO;
			for each(var agent:HandlingAgentVO in handlingAgentVOs){
				if(agent.handlingAgentCode == SvdReqConstant.BAILIFF_CODE){
					bailiff = agent;
				}else if(agent.handlingAgentCode == SvdReqConstant.POLICE_CODE){
					police = agent;
				}
			}
			
			var personal:ServiceModeTypeVO;
			var registered:ServiceModeTypeVO;
			for each(var modeType:ServiceModeTypeVO in serviceModeTypeVOs){
				if(modeType.serviceModeTypeCode == SvdReqConstant.SERVICE_MODE_CODE_PERSONAL){
					personal = modeType;
				}else if(modeType.serviceModeTypeCode == SvdReqConstant.SERVICE_MODE_CODE_REGISTERED){
					registered = modeType;
				}
			}
			
			reserviceBatchSearchResultVOs = value;
			if(reserviceBatchSearchResultVOs != null && reserviceBatchSearchResultVOs.length > 0){
				for each(var resultVO:ReserviceBatchSearchResultVO in reserviceBatchSearchResultVOs){
					if(resultVO.recordMode == CommonConstant.RECORD_MODE_SCHEDULE_NEXT_HEARING){
						addNextHrnDetails(resultVO);
					}else if(resultVO.recordMode == CommonConstant.RECORD_MODE_GENERATE_RESERVICE){
						addReservReqsDetails(resultVO, bailiff, police, personal);
					}else if(resultVO.recordMode == CommonConstant.RECORD_MODE_GENERATE_DOP_SUMMONS_RESERVICE){
						addDopReservReqsDetails(resultVO, registered);
					}
				}
			}
			if(_nextHearingDetailVOs.length > 0){
				var i:int = 0;
				for each(var nextHrnDate:DisplayReServiceDetailVO in _nextHearingDetailVOs){
					i++;
					nextHrnDate.seq = i;
				}
			}
			if(_reserviceRequestDetailVOs.length > 0){
				var j:int = 0;
				for each(var reserviceRequest:DisplayReServiceDetailVO in _reserviceRequestDetailVOs){
					j++;
					reserviceRequest.seq = j;
				}
			}
			if(_dopReserviceRequestDetailVOs.length > 0){
				var k:int = 0;
				for each(var dopReserviceRequest:DisplayReServiceDetailVO in _dopReserviceRequestDetailVOs){
					k++;
					dopReserviceRequest.seq = k;
				}
			}
		}
		
		private function addNextHrnDetails(resultVO:ReserviceBatchSearchResultVO):void{
			var nextHearingDetail:NextHearingDetailVO = resultVO.nextHearingDetail;
			if(nextHearingDetail != null){
				var nextHrnDate:DisplayReServiceDetailVO = new DisplayReServiceDetailVO;
				nextHrnDate.caseNo = nextHearingDetail.caseNo;
				if(nextHearingDetail.prosecutionDepartment != null){
					nextHrnDate.pdCode = nextHearingDetail.prosecutionDepartment.prosecutionDepartmentCode;
				}
				nextHrnDate.defendantName = PartyVOUtil.getRequestName(nextHearingDetail.defendant);
				if(nextHearingDetail.listId > 0){
					nextHrnDate.dayFromAllocation = nextHearingDetail.dayFromAllocation + "";
					nextHrnDate.hearingScheduleDate = nextHearingDetail.hearingScheduleDate;
					nextHrnDate.hearingStartTime = nextHearingDetail.hearingStartTime;
					nextHrnDate.courtRoomChambersName = nextHearingDetail.courtRoomChambersName;
				}
				nextHrnDate.reserviceBatchSearchResultVO = resultVO;
				this._nextHearingDetailVOs.addItem(nextHrnDate);
			}
		}
		private function addReservReqsDetails(resultVO:ReserviceBatchSearchResultVO, bailiff:HandlingAgentVO, police:HandlingAgentVO, personal:ServiceModeTypeVO):void{
			var reserviceRequestDetail:ReserviceRequestDetailVO = resultVO.reserviceRequestDetail;
			if(reserviceRequestDetail != null){
				var reserviceRequest:DisplayReServiceDetailVO = new DisplayReServiceDetailVO;
				reserviceRequest.caseNo = reserviceRequestDetail.request.caseNo;
				reserviceRequest.recipientName = PartyVOUtil.getRequestName(reserviceRequestDetail.recipient);
				reserviceRequest.hearingScheduleDate = resultVO.nextHearingDetail.hearingScheduleDate;
				reserviceRequest.summonsGeneratedInd = reserviceRequestDetail.summonsGeneratedInd;
				var serviceRequest:ServiceRequestVO = reserviceRequestDetail.serviceRequest;
				if(serviceRequest != null && (serviceRequest.serviceModeType == null || "" == serviceRequest.serviceModeType.serviceModeTypeName)){
					serviceRequest.serviceModeType = personal;
				}
				if(serviceRequest.serviceModeType != null){
					reserviceRequest.serviceModeName = serviceRequest.serviceModeType.serviceModeTypeName;
				}
				if(reserviceRequestDetail.requestAddress != null && reserviceRequestDetail.requestAddress.hkRegion != null){
					reserviceRequest.regionName = reserviceRequestDetail.requestAddress.hkRegion.hkRegionName;
				}
				if(reserviceRequest.serviceModeName == personal.serviceModeTypeName){
					var regionName:String = reserviceRequest.regionName;
					if(regionName == SvdReqConstant.KOWLOON || regionName == SvdReqConstant.HONG_KONG_ISLAND){
						reserviceRequestDetail.request.handlingAgent = bailiff;
					}else if(regionName == SvdReqConstant.NEW_TERRITORIES){
						reserviceRequestDetail.request.handlingAgent = police;
					}
				}
				if(reserviceRequestDetail.request.handlingAgent != null){
					reserviceRequest.serviceAgentName = reserviceRequestDetail.request.handlingAgent.handlingAgentName;
					if(reserviceRequest.serviceAgentName == bailiff.handlingAgentName){
						reserviceRequest.isBailiff = true;
						if(reserviceRequestDetail.request.bailiffOffice != null){
							reserviceRequest.baiOfficeName = reserviceRequestDetail.request.bailiffOffice.bailiffOfficeName;
						}
					}
				}
				if(reserviceRequestDetail.request.requestStatusType != null && reserviceRequestDetail.request.requestStatusType.requestStatusTypeName != null){
					reserviceRequest.reqStatusName = reserviceRequestDetail.request.requestStatusType.requestStatusTypeName;
					reserviceRequest.detailAble = true;
				}
				reserviceRequest.reserviceBatchSearchResultVO = resultVO;
				if(!reserviceRequestDetail.allowSaveDraftInd && !reserviceRequestDetail.allowSubmitInd){
					reserviceRequest.editable = false;
					reserviceRequest.isBailiff = false;
				}
				this._reserviceRequestDetailVOs.addItem(reserviceRequest);
			}
		}
		private function addDopReservReqsDetails(resultVO:ReserviceBatchSearchResultVO, registered:ServiceModeTypeVO):void{
			var dopReserviceRequestDetail:ReserviceRequestDetailVO = resultVO.reserviceRequestDetail;
			if(dopReserviceRequestDetail != null){
				var dopReserviceRequest:DisplayReServiceDetailVO = new DisplayReServiceDetailVO;
				dopReserviceRequest.caseNo = dopReserviceRequestDetail.request.caseNo;
				dopReserviceRequest.recipientName = PartyVOUtil.getRequestName(dopReserviceRequestDetail.recipient);
				dopReserviceRequest.hearingScheduleDate = resultVO.nextHearingDetail.hearingScheduleDate;
				dopReserviceRequest.summonsGeneratedInd = dopReserviceRequestDetail.summonsGeneratedInd;
				if(dopReserviceRequestDetail.requestAddress.hkRegion != null){
					dopReserviceRequest.regionName = dopReserviceRequestDetail.requestAddress.hkRegion.hkRegionName;
				}
				dopReserviceRequest.registeredMailBarcode = dopReserviceRequestDetail.serviceRequest.registeredMailBarcode;
				if(dopReserviceRequestDetail.serviceRequest.serviceModeType == null || "" == dopReserviceRequestDetail.serviceRequest.serviceModeType.serviceModeTypeName){
					dopReserviceRequestDetail.serviceRequest.serviceModeType = registered;
				}
				dopReserviceRequest.serviceModeName = dopReserviceRequestDetail.serviceRequest.serviceModeType.serviceModeTypeName;
				if(dopReserviceRequestDetail.request.requestStatusType != null && dopReserviceRequestDetail.request.requestStatusType.requestStatusTypeName != null){
					dopReserviceRequest.reqStatusName = dopReserviceRequestDetail.request.requestStatusType.requestStatusTypeName;
					dopReserviceRequest.detailAble = true;
				}
				dopReserviceRequest.reserviceBatchSearchResultVO = resultVO;
				if(dopReserviceRequestDetail.serviceRequest.serviceModeType.serviceModeTypeCode != SvdReqConstant.SERVICE_MODE_CODE_REGISTERED){
					dopReserviceRequest.editable = false;
				}
				this._dopReserviceRequestDetailVOs.addItem(dopReserviceRequest);
			}
		}
		
		public function resetValidation():void
		{
			ValidationUtil.clearValidationMessage(errorBoxId);
		}
		
		public function checkNextHrnBtnAble():void{
			confirmAble = false;
			genDefHrnAble = false;
			regenDefHrnVisable = false;
			
			var selectedRecord:Boolean = false;
			for each(var displayNextHrn:DisplayReServiceDetailVO in nextHearingDetailVOs){
				if(displayNextHrn.checked){
					selectedRecord = true;
					break;
				}
			}
			
			for each(var nextHrn:DisplayReServiceDetailVO in nextHearingDetailVOs){
				if(nextHrn.checked && nextHrn.reserviceBatchSearchResultVO.nextHearingDetail.listId <= 0){
					genDefHrnAble = true;
					break;
				}
			}
			
			if(selectedRecord && !genDefHrnAble){
				confirmAble = true;
			}
			
			var hasList:Boolean = false;
			for each(var nextHrnVO:DisplayReServiceDetailVO in nextHearingDetailVOs){
				if(nextHrnVO.checked && nextHrnVO.reserviceBatchSearchResultVO.nextHearingDetail.listId > 0){
					hasList = true;
					break;
				}
			}
			if(hasList){
				regenDefHrnVisable = true;
			} else {
				overridDays = ""
			}
			checkRegenDefHrnAble();
		}
		
		public function checkRegenDefHrnAble():void{
			regenDefHrnAble = false;
			if(confirmAble && overridDays != "" && int(overridDays) >0){
				regenDefHrnAble = true;
			}
		}
		
		public function changeServModeType(obj:Object,servModeType:ServiceModeTypeVO):void{
			var currData:DisplayReServiceDetailVO = obj as DisplayReServiceDetailVO;
			currData.serviceModeName = servModeType.serviceModeTypeName;
			currData.reserviceBatchSearchResultVO.reserviceRequestDetail.serviceRequest.serviceModeType = servModeType;
			dispatchEvent(new Event("updateSearchResult"));
		}
		
		public function changeHkRegion(data:Object, selectedAgent:HandlingAgentVO):void{
			var changData:DisplayReServiceDetailVO = data as DisplayReServiceDetailVO;
			changData.reserviceBatchSearchResultVO.reserviceRequestDetail.request.handlingAgent = selectedAgent;
			changData.serviceAgentName = selectedAgent.handlingAgentName;
			if(selectedAgent.handlingAgentCode == SvdReqConstant.BAILIFF_CODE){
				changData.isBailiff = true;
			}else{
				changData.isBailiff = false;
				changData.baiOfficeName = "";
				changData.reserviceBatchSearchResultVO.reserviceRequestDetail.request.bailiffOffice = null;
			}
			dispatchEvent(new Event("updateSearchResult"));
		}
		
		public function changeBaiOffice(obj:Object,baiOff:BailiffOfficeVO):void{
			var currData:DisplayReServiceDetailVO = obj as DisplayReServiceDetailVO;
			currData.baiOfficeName = baiOff.bailiffOfficeName;
			currData.reserviceBatchSearchResultVO.reserviceRequestDetail.request.bailiffOffice = baiOff;
			dispatchEvent(new Event("updateSearchResult"));
		}
		
		private var searchDateIndex:int;
		private var serverWindow:ServerWindow;
		public function nextHrnSearch(obj:Object):void{				
			var currData:DisplayReServiceDetailVO = obj as DisplayReServiceDetailVO;
			searchDateIndex = currData.seq;
			serverWindow = OpenFunctionHandler.getInstance().connect(
					SvdReqConstant.COURTDIARY_PROJECT_ID, 
					SvdReqConstant.COURTDIARY_FUNCTION_ID, 
					callBackCourtDiaryMCSchedulePopup, 
					PortalEventConstant.POPUP,
					1440, 850);
			var hrnDtl:NextHearingDetailVO = currData.reserviceBatchSearchResultVO.nextHearingDetail;
			serverWindow.setAttribute("caseId", hrnDtl.caseId);
			serverWindow.setAttribute("comprisingCourtId", hrnDtl.comprisingCourtId);
			serverWindow.setAttribute("listTypeId", hrnDtl.listTypeId);
			serverWindow.setAttribute("hearingNatureId", hrnDtl.hearingNatureId);
			serverWindow.setAttribute("hearingTimeWeightId", hrnDtl.hearingTimeWeightId);
			serverWindow.setAttribute("noOfHearingDays", 0.5);
			serverWindow.setAttribute("noOfCaseSchdTogether", 0);
			serverWindow.setAttribute("dateFrom ", hrnDtl.hearingScheduleDate);
			serverWindow.setAttribute("lastHearingDate ", hrnDtl.hearingScheduleDate);
			serverWindow.setAttribute("jjoProfileId", -1);
			
			serverWindow.send("loadPrerequisite");
		}
		
		public function callBackCourtDiaryMCSchedulePopup(value:Object):void{
			if (value.eventCode == "CALLBACK") {
				var hrnSchdObjs:ArrayCollection = value.hrnSchdObjs;
				if (hrnSchdObjs != null && hrnSchdObjs.length > 0) {
					var hrnSchdObj:ArrayCollection = hrnSchdObjs.getItemAt(0) as ArrayCollection;
					// Pre-set value
					var listSchdObj:ArrayCollection = lookupValue(hrnSchdObj, "listSchd") as ArrayCollection;
					var hrnSchdDate:Date = lookupValue(listSchdObj, "listSchdDate") as Date;
					var hrnStartTime:String = lookupValue(listSchdObj, "listSchdSessStartTime") as String;
					var listObj:ArrayCollection = lookupValue(listSchdObj, "list") as ArrayCollection;
					var listId:int = lookupValue(listObj, "listId") as int;
					for each(var displayData:DisplayReServiceDetailVO in nextHearingDetailVOs){
						if(displayData.seq == searchDateIndex){
							displayData.hearingScheduleDate = hrnSchdDate;
							displayData.hearingStartTime = hrnStartTime;
							displayData.courtRoomChambersName = value.courtRoom;
							displayData.reserviceBatchSearchResultVO.nextHearingDetail.listId = listId;						
							displayData.reserviceBatchSearchResultVO.nextHearingDetail.hearingScheduleDate = displayData.hearingScheduleDate;
							displayData.reserviceBatchSearchResultVO.nextHearingDetail.hearingStartTime = displayData.hearingStartTime;
							dispatchEvent(new Event("updateSearchResult"));
							break;
						}
					}	
					checkNextHrnBtnAble();
					closeCourtDairy();
				}				
			}else if (value.eventCode == "CLOSE"){
				closeCourtDairy();
			}
		}
		
		private function closeCourtDairy():void{
			serverWindow.closeClientFunction();
		}
		
		private function lookupValue(objList:ArrayCollection, targetObject:String):Object {
			var j:int;
			var obj:String;
			var attr:String;
			var value:Object;
			if (objList.length > 0) {
				for (j=0; j<objList.length; j++) {
					obj = objList.getItemAt(j).obj;
					attr = objList.getItemAt(j).attr;
					value = objList.getItemAt(j).value;					
					if ((obj != null && obj == targetObject) || (attr != null && attr == targetObject)) {
						return value;
					}
				}
			}
			return null;
		}
		
		private var indexs:ArrayCollection = new ArrayCollection;
		public function reGenDefHrn():void{
			var selecteResultVOs:ArrayCollection = getSelectedNextHrn();
			dispatchEvent(ReServEvent.reGenDefHrnDate(selecteResultVOs));
		}
		
		public function refreshReGenDefHrn(selectedResults:ArrayCollection):void{
			if(selectedResults != null && selectedResults.length > 0){
				var i:int = 0;
				for each(var index:int in indexs){
					for each(var displayData:DisplayReServiceDetailVO in nextHearingDetailVOs){
						if(displayData.checked && displayData.seq == index){
							var nextHrnDetail:NextHearingDetailVO = selectedResults.getItemAt(i) as NextHearingDetailVO;
							if(nextHrnDetail != null){
								displayData.dayFromAllocation = nextHrnDetail.dayFromAllocation + "";
								displayData.hearingScheduleDate = nextHrnDetail.hearingScheduleDate;
								displayData.hearingStartTime = nextHrnDetail.hearingStartTime;
								displayData.courtRoomChambersName = nextHrnDetail.courtRoomChambersName;
								displayData.reserviceBatchSearchResultVO.nextHearingDetail = nextHrnDetail;
							}
							i++;
							break;
						}
					}
				}
			}
			checkNextHrnBtnAble();
			dispatchEvent(new Event("updateSearchResult"));
		}
		
		public function refreshResult():void{
			batchSearchVO.func = functionVO;
			batchSearchVO.hearingStartTime.setHours(this._selectedHour, this._selectedMin);
			dispatchEvent(ReServEvent.searchAbsentDefenantsList(batchSearchVO));
		}
		
		public function confirmSchd():void{
			var selecteResultVOs:ArrayCollection = getSelectedNextHrn();
			dispatchEvent(ReServEvent.confirmHearingSchedule(selecteResultVOs));
		}

		private function getSelectedNextHrn():ArrayCollection{
			indexs.removeAll();
			var selecteResultVOs:ArrayCollection = new ArrayCollection;
			for each(var displayData:DisplayReServiceDetailVO in nextHearingDetailVOs){
				if(displayData.checked){
					indexs.addItem(displayData.seq);
					selecteResultVOs.addItem(displayData.reserviceBatchSearchResultVO);
				}
			}
			return selecteResultVOs;
		}
		
		public function genReServDetail(obj:Object):void{
			var selectedReqDetail:DisplayReServiceDetailVO = obj as DisplayReServiceDetailVO;
			var maintainVO:MaintainRequestVO = new MaintainRequestVO;
			maintainVO.func = functionVO;
			maintainVO.requestId = selectedReqDetail.reserviceBatchSearchResultVO.reserviceRequestDetail.request.requestId;
			maintainVO.errorBoxComponentId = errorBoxId;
			dispatchEvent(ReServEvent.createMaintainRequestEvent(maintainVO));
		}
		
		public function reServOfDOPDetail(obj:Object):void{
			var selectedReqDetail:DisplayReServiceDetailVO = obj as DisplayReServiceDetailVO;
			var maintainVO:MaintainRequestVO = new MaintainRequestVO;
			maintainVO.func = functionVO;
			maintainVO.requestId = selectedReqDetail.reserviceBatchSearchResultVO.reserviceRequestDetail.request.requestId;
			maintainVO.errorBoxComponentId = errorBoxId;
			dispatchEvent(ReServEvent.createMaintainRequestEvent(maintainVO));
		}
		
		public function checkFillInRegAble():void{
			fillInAble = false;
			if(mailBarcodeFrom != "" && mailBarcodeTo != ""){
				fillInAble = true;
			}
		}
		
		public function changMailBoard(obj:Object, mail:String):void{
			var displayDopReServ:DisplayReServiceDetailVO = obj as DisplayReServiceDetailVO;
			displayDopReServ.registeredMailBarcode = mail;
			displayDopReServ.reserviceBatchSearchResultVO.reserviceRequestDetail.serviceRequest.registeredMailBarcode = mail;
		}
		
		public function fillInReg():void{
			mailBarcodeFrom = mailBarcodeFrom.replace(/\s/g,"");
			mailBarcodeTo = mailBarcodeTo.replace(/\s/g,"");
			if(fillInValidate()){
				var patternNum:RegExp = PATTERN_BARCODE_NUM;
				var pattern:RegExp = PATTERN_BARCODE;
				var formatedFromNumber:Object = patternNum.exec(mailBarcodeFrom);
				var formatedToNumber:Object = patternNum.exec(mailBarcodeTo);
				var numLen:int = String(formatedFromNumber).length;
				var prefixFromIdx:int = mailBarcodeFrom.length - numLen;
				var preNumInt:int = int(formatedFromNumber);
				
				var prefixStr:String = mailBarcodeFrom.substring(0, prefixFromIdx);
				
				for(preNumInt; preNumInt<=int(formatedToNumber); preNumInt++){
					for each(var displayDopReServ:DisplayReServiceDetailVO in dopReserviceRequestDetailVOs){
						if(displayDopReServ.checked
							&& (displayDopReServ.registeredMailBarcode == null || displayDopReServ.registeredMailBarcode == "")){
							displayDopReServ.registeredMailBarcode = prefixStr + fillLeftWithZero(String(preNumInt), numLen);
							displayDopReServ.reserviceBatchSearchResultVO.reserviceRequestDetail.serviceRequest.registeredMailBarcode = displayDopReServ.registeredMailBarcode;
							break;
						}
					}
				}
				dispatchEvent(new Event("updateSearchResult"));
			}
		}
		
		private function fillLeftWithZero(preNum:String, length:int):String{
			while(preNum.length < length){
				preNum = "0" + preNum;
			};
			return preNum;
		}
		
		private const PATTERN_BARCODE_NUM:RegExp = /[0-9]+(?=[^0-9]*$)/;
		private const PATTERN_BARCODE:RegExp = /[0-9]$/;
		private function fillInValidate():Boolean{
			this.resetValidation();
			var mailFormInput:String = "mailFormInput";
			var mailToInput:String = "mailToInput";
			var endNum:int = int(mailBarcodeFrom.substring((mailBarcodeFrom.length - 1), mailBarcodeFrom.length));
			var patternMatchBl:Boolean = false;
			var prefixBl:Boolean = true;
			var toGreaterBl:Boolean = true;
			var patternNum:RegExp = PATTERN_BARCODE_NUM;
			var pattern:RegExp = PATTERN_BARCODE;
			if (pattern.test(mailBarcodeFrom) && pattern.test(mailBarcodeTo) && mailBarcodeFrom.length == mailBarcodeTo.length){
				var formatedFromNumber:Object = patternNum.exec(mailBarcodeFrom);
				var formatedToNumber:Object = patternNum.exec(mailBarcodeTo);
				var prefixFromIdx:int = mailBarcodeFrom.length - String(formatedFromNumber).length;
				var prefixToIdx:int = mailBarcodeTo.length - String(formatedToNumber).length;
				if(mailBarcodeFrom.substring(0, prefixFromIdx) == mailBarcodeTo.substring(0, prefixToIdx)){
					if(int(formatedFromNumber) > int(formatedToNumber)){
						toGreaterBl = false;
					}
				}else{
					prefixBl = false;
				}
				patternMatchBl = true;
			}
			if(!patternMatchBl){
				ValidateUtil.addMultiplyValidationMessage(MessageConstant.BARCODE_NO_FORMAT, new ArrayCollection([mailFormInput, mailToInput]), errorBoxId);
			}else if(!prefixBl){
				ValidateUtil.addMultiplyValidationMessage(MessageConstant.BARCODE_PREFIX_SAME, new ArrayCollection([mailFormInput, mailToInput]), errorBoxId);
			}
			if(!toGreaterBl){
				ValidateUtil.addMultiplyValidationMessage(MessageConstant.BARCODE_FROM_GREATER_THAN_TO, new ArrayCollection([mailFormInput, mailToInput]), errorBoxId);
			}
			
			var result:Boolean = patternMatchBl && prefixBl && toGreaterBl;
			if(!result){
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
		
		public function checkGenCerAble():void{
			genCerAble = false;
			if(forFirstClerk != "" && posFee != ""){
				genCerAble = true;
			}
		}
		
		public function genCer():void{
			if(posFeeValidate()){
				var certifcateBulkPostingVO:CertifcateBulkPostingVO = new CertifcateBulkPostingVO;
				certifcateBulkPostingVO.firstClerkName = forFirstClerk;
				certifcateBulkPostingVO.postageFee = Number(posFee);
				var selecteResultVOs:ArrayCollection = getSelectedReService();
				certifcateBulkPostingVO.reserviceBatchSearchResults = selecteResultVOs;
				dispatchEvent(ReServEvent.generateCertificateBulkPosting(certifcateBulkPostingVO));
			}
		}
		
		private const PATTERN_FEE:RegExp = /^(\d*)\.?(\d*)$/;
		private function posFeeValidate():Boolean{
			this.resetValidation();
			var feeCheck:Boolean = false;
			var pattern:RegExp = PATTERN_FEE;
			if(pattern.test(posFee)){
				feeCheck = true;
			}
			if(!feeCheck){
				ValidateUtil.addValidationMessage(MessageConstant.FEE_NOT_FORMATE, "posFeeInput", errorBoxId);
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return feeCheck;
		}
		
		public function checkGenReServBtnAble():void{
			saveAble = false;
			submitAble = false;
			var selecteResultVOs:ArrayCollection = getSelectedReService();
			var selecteSaveDetailVOs:ArrayCollection = new ArrayCollection;
			var selecteSubmitDetailVOs:ArrayCollection = new ArrayCollection;
			if(selecteResultVOs.length > 0){
				for each(var resultVO:ReserviceBatchSearchResultVO in selecteResultVOs){
					if(resultVO.reserviceRequestDetail.allowSaveDraftInd){
						selecteSaveDetailVOs.addItem(resultVO.reserviceRequestDetail);
					}
					if(resultVO.reserviceRequestDetail.allowSubmitInd){
						selecteSubmitDetailVOs.addItem(resultVO.reserviceRequestDetail);
					}
				}
				if(selecteSaveDetailVOs.length == selecteResultVOs.length){
					saveAble = true;
				}
				if(selecteSubmitDetailVOs.length == selecteResultVOs.length){
					submitAble = true;
				}
			}
		}
		
		private function getSelectedReService():ArrayCollection{
			var selecteResultVOs:ArrayCollection = new ArrayCollection;
			var hasError:Boolean = false;
			for each(var displayReServ:DisplayReServiceDetailVO in reserviceRequestDetailVOs){
				if(displayReServ.checked){
					if(!displayReServ.reserviceBatchSearchResultVO.reserviceRequestDetail.allowSaveDraftInd 
						&& !displayReServ.reserviceBatchSearchResultVO.reserviceRequestDetail.allowSubmitInd){
						hasError = true;
						displayReServ.checked = false;
					}else{
						selecteResultVOs.addItem(displayReServ.reserviceBatchSearchResultVO);
					}
				}
			}
			for each(var displayDopReServ:DisplayReServiceDetailVO in dopReserviceRequestDetailVOs){
				if(displayDopReServ.checked){
					if(!displayDopReServ.reserviceBatchSearchResultVO.reserviceRequestDetail.allowSaveDraftInd 
						&& !displayDopReServ.reserviceBatchSearchResultVO.reserviceRequestDetail.allowSubmitInd){
						displayDopReServ.checked = false;
						hasError = true;
					}else{
						selecteResultVOs.addItem(displayDopReServ.reserviceBatchSearchResultVO);
					}
				}
			}
			if(hasError){
				MessageHandler.createErrorMessageBox(MessageConstant.CANNOT_SAVE_OR_SUBMIT, null, null);
			}
			dispatchEvent(new Event("updateSearchResult"));
			return selecteResultVOs;
		}
		
		
		public function genDocDra():void{
			if(validMailBorad()){
				var selecteResultVOs:ArrayCollection = getSelectedReService();
				dispatchEvent(ReServEvent.saveDraftAndGenDocEvent(selecteResultVOs));
			}
		}	
		
		public function saveDraft():void{
			if(validMailBorad()){
				var selecteResultVOs:ArrayCollection = getSelectedReService();
				dispatchEvent(ReServEvent.saveDraftReserviceRequest(selecteResultVOs));
			}
		}
		
		public function submitReServ():void{
			if(validMailBorad()){
				var selecteResultVOs:ArrayCollection = getSelectedReService();
				dispatchEvent(ReServEvent.submitReserviceRequest(selecteResultVOs));
			}
		}
		
		private function validMailBorad():Boolean{
			this.resetValidation();
			var bl:Boolean = true;
			var invalideIndexs:ArrayCollection = new ArrayCollection;
			if(_dopReserviceRequestDetailVOs.length > 0){
				for each(var displayDopReServ:DisplayReServiceDetailVO in _dopReserviceRequestDetailVOs){
					if(displayDopReServ.checked
						&& (displayDopReServ.reserviceBatchSearchResultVO.reserviceRequestDetail.serviceRequest.registeredMailBarcode == null 
							|| displayDopReServ.reserviceBatchSearchResultVO.reserviceRequestDetail.serviceRequest.registeredMailBarcode == "")){
						invalideIndexs.addItem(displayDopReServ.seq);
					}
				}
			}
			if(invalideIndexs.length > 0){
				bl = false;
			}
			if(!bl){
				ValidateUtil.addValidationMessageDataGrid(MessageConstant.MAIL_EMPTY, "dopDataGrid", errorBoxId,
					7, invalideIndexs);
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return bl;
		}
	}
}
