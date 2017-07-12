package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import hk.judiciary.fmk.web.application.util.ValidationUtil;
	import hk.judiciary.icmssvd.view.common.constant.MessageBoxIdConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.util.PartyVOUtil;
	import hk.judiciary.icmssvd.view.common.util.ValidateUtil;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.ProofEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayPosRequestSearchResultVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestSearchResultVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.PosRequestSearchVO;
	
	[Event(name="initSearchParams,clearEquireProofResult,searchProofOfSevList,maintainPosRequest", 
		type="hk.judiciary.icmssvd.view.svdReq.event.ProofEvent")]
	
	[ManagedEvents("initSearchParams", scope="local")]
	[ManagedEvents("clearEquireProofResult", scope="local")]
	[ManagedEvents("searchProofOfSevList", scope="local")]
	[ManagedEvents("maintainPosRequest", scope="local")]
	public class EnquireProofOfSvdPanelPM extends EventDispatcher
	{
		private var _selectedAccordionIndex:Array = [];
		
		private var _errorBoxId:String;
		private var _panelId:String;
		
		private var _dateFormat:String = SvdReqConstant.DEFAULT_DATE_PATTERN;
		
		private var _functionVO:FunctionVO = new FunctionVO;
		
		private var _newAble:Boolean=false;
		private var _newCaseNo:String;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
		private var _comprisingCourtVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.CaseTypeVO")]
		private var _caseTypeVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO")]
		private var _handlingAgentVOs:ArrayCollection=new ArrayCollection();
		
		private var _selectComprisingCourt:String;
		private var _selectCaseType:String;
		private var _selectHandlingAgent:String;
		
		private var _posRequestSearchVO:PosRequestSearchVO = new PosRequestSearchVO;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayPosRequestSearchResultVO")]
		private var _displayPosRequestSearchResultVOs:ArrayCollection = new ArrayCollection;
		
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
		public function get dateFormat():String { return _dateFormat; } 
		public function set dateFormat(value:String):void { this._dateFormat=value; }
		
		[Bindable]
		public function get functionVO():FunctionVO{ return this._functionVO; }
		public function set functionVO(value:FunctionVO):void { this._functionVO=value; }
		
		[Bindable]
		public function get newAble():Boolean{ return this._newAble; }
		public function set newAble(value:Boolean):void { this._newAble=value; }
		[Bindable]
		public function get newCaseNo():String{ return this._newCaseNo; }
		public function set newCaseNo(value:String):void { this._newCaseNo=value; }
		
		[Bindable]
		public function get comprisingCourtVOs():ArrayCollection { return this._comprisingCourtVOs; }
		public function set comprisingCourtVOs(value:ArrayCollection):void { this._comprisingCourtVOs=value; }
		
		[Bindable]
		public function get caseTypeVOs():ArrayCollection { return this._caseTypeVOs; }
		public function set caseTypeVOs(value:ArrayCollection):void { this._caseTypeVOs=value; }
		
		[Bindable]
		public function get handlingAgentVOs():ArrayCollection { return this._handlingAgentVOs; }
		public function set handlingAgentVOs(value:ArrayCollection):void { this._handlingAgentVOs=value; }
		
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
		public function get selectHandlingAgent():String { return _selectHandlingAgent; } 
		public function set selectHandlingAgent(value:String):void { this._selectHandlingAgent=value; }
		
		[Bindable]
		public function get posRequestSearchVO():PosRequestSearchVO { return this._posRequestSearchVO; }
		public function set posRequestSearchVO(value:PosRequestSearchVO):void { this._posRequestSearchVO=value; }
		
		[Bindable]
		public function get displayPosRequestSearchResultVOs():ArrayCollection { return this._displayPosRequestSearchResultVOs; }
		public function set displayPosRequestSearchResultVOs(value:ArrayCollection):void { this._displayPosRequestSearchResultVOs = value; }
		
		public function init(func:String):void
		{
			selectedAccordionIndex = [0];
			functionVO.courtLevelTypeCode = func;
			if(func == SvdReqConstant.COURT_LEVEL_TYPE_DISTRICT){
				errorBoxId = MessageBoxIdConstant.ENQ_PROOF_ERROR_DC;
				panelId = "enquireProofOfSvdPanelDC.";
			}else{
				errorBoxId = MessageBoxIdConstant.ENQ_PROOF_ERROR_MC;
				panelId = "enquireProofOfSvdPanelMC.";
			}
			dispatchEvent(ProofEvent.initSearchParams(functionVO));
		}
		
		public function changeCaseNo():void{
			newCaseNo = posRequestSearchVO.caseNo;
			newAbleCheck(newCaseNo);
		}
		
		public function newAbleCheck(obj:Object):void{
			var caseNo:String = obj as String;
			if(caseNo.length > 0){
				newAble = true;
			}else{
				newAble = false;
			}
		}
		
		public function changCourt(court:Object):void{
			var comprisingCourtVO:ComprisingCourtVO = court as ComprisingCourtVO;
			posRequestSearchVO.comprisingCourt = comprisingCourtVO;
		}
		
		public function changCaseType(caseType:Object):void{
			posRequestSearchVO.caseType = caseType as CaseTypeVO;
		}
		
		public function changHandlingAgent(handlingAgent:Object):void{
			posRequestSearchVO.handlingAgent = handlingAgent as HandlingAgentVO;
		}
		
		public function doSearch():void
		{
			if(validate()){
				selectedAccordionIndex = [-1];
				posRequestSearchVO.func = functionVO;
				var draft:RequestStatusTypeVO = new RequestStatusTypeVO;
				dispatchEvent(ProofEvent.searchProofOfSevList(posRequestSearchVO));
			}
		}
		
		public function validate():Boolean{
			this.resetValidation();
			var submitDate:Boolean = submitDateValid();
			var caseNo:Boolean = checkRegCaseNumber(posRequestSearchVO.caseNo, 1);
			var result:Boolean = submitDate && caseNo;
			
			if(!result){
				ValidateUtil.showValidationMessages(errorBoxId);
			}
			return result;
		}
		
		private const PATTERN_CASE_NO:RegExp = /^([a-zA-Z]{2})([a-zA-Z]{1,2})\s*(\d{1,6})\s*\/\s*(\d{1,4})$/;
		private function checkRegCaseNumber(inputCaseNo:String,errIdx:int):Boolean
		{
			var result:Boolean = false;
			var caseNoBox:String = "caseNoInput";
			var caseNo2Box:String = "caseNoNew";
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
					if(errIdx == 1){
						posRequestSearchVO.caseNo = correctCaseNo;
					}
					newCaseNo = correctCaseNo;
					
					result = true;
				}
				
			}else{
				result = true;
			}
			if(!result)
			{
				if(errIdx == 1){
					ValidateUtil.addValidationMessage(MessageConstant.CASE_NO_FORMAT, panelId + caseNoBox, errorBoxId);
				}
				ValidateUtil.addValidationMessage(MessageConstant.CASE_NO_FORMAT, panelId + caseNo2Box, errorBoxId);
			}
			return result;
		}
		
		private function isNumber(sValue:String):Boolean
		{
			var iValue:int = int( sValue );
			return (iValue.toString() == sValue);
		}
		
		private function submitDateValid():Boolean{
			var bl:Boolean = true;
			var startDate:Date = posRequestSearchVO.submitStartDate;
			var endDate:Date = posRequestSearchVO.submitEndDate;
			var startDateBox:String = "from";
			var endDateBox:String = "to";
			if(startDate != null && endDate != null && ObjectUtil.dateCompare(startDate,endDate) > 0){
				ValidateUtil.addMultiplyValidationMessage(MessageConstant.END_TIME_LARGER_START_TIME, new ArrayCollection([panelId + startDateBox, panelId + endDateBox]), errorBoxId);
				bl = false;
			}
			return bl;
		}
		
		public function showSearchResult(value:ArrayCollection):void
		{
			this._displayPosRequestSearchResultVOs.removeAll();
			if(value != null && value.length > 0){
				for each (var posRequestSearchResultVO:PosRequestSearchResultVO in value){
					var tmpDisplayPosRequestSearchResultVO:DisplayPosRequestSearchResultVO = new DisplayPosRequestSearchResultVO();
					tmpDisplayPosRequestSearchResultVO.requestId = posRequestSearchResultVO.requestId;
					tmpDisplayPosRequestSearchResultVO.submitDate = posRequestSearchResultVO.submitDate;
					tmpDisplayPosRequestSearchResultVO.caseNo = posRequestSearchResultVO.caseNo;
					tmpDisplayPosRequestSearchResultVO.requesterName = PartyVOUtil.getRequestName(posRequestSearchResultVO.requester);
					tmpDisplayPosRequestSearchResultVO.recipientName = PartyVOUtil.getRequestName(posRequestSearchResultVO.recipient);
					if(posRequestSearchResultVO.handlingAgent != null){
						tmpDisplayPosRequestSearchResultVO.handlingAgentName = PartyVOUtil.getStr(posRequestSearchResultVO.handlingAgent.handlingAgentName);
					}
					tmpDisplayPosRequestSearchResultVO.posOrAcip = posRequestSearchResultVO.posOrAcip;
					tmpDisplayPosRequestSearchResultVO.dueOrHearingDate = posRequestSearchResultVO.dueOrHearingDate;
					tmpDisplayPosRequestSearchResultVO.posRequestSearchResultVO = posRequestSearchResultVO;
					
					this._displayPosRequestSearchResultVOs.addItem(tmpDisplayPosRequestSearchResultVO);
				}
			}
		}
		
		public function doClear():void{
			dispatchEvent(ProofEvent.clearEquireProofResultEvent());
		}
		
		[MessageHandler(selector="clearEquireProofResult", scope="local")]
		public function clearEquireProofResultHandler(event:ProofEvent):void{
			this.resetValidation();
			posRequestSearchVO = new PosRequestSearchVO;
			newCaseNo = new String;
			newAble = false;
			displayPosRequestSearchResultVOs.removeAll();
			if(comprisingCourtVOs.length > 1){
				selectComprisingCourt = SvdReqConstant.ALL;
			}else if(comprisingCourtVOs.length == 1){
				posRequestSearchVO.comprisingCourt = comprisingCourtVOs[0];
				selectComprisingCourt = comprisingCourtVOs[0].comprisingCourtName;
			}
			if(caseTypeVOs.length > 1){
				selectCaseType = SvdReqConstant.ALL;
			}else if(caseTypeVOs.length == 1){
				posRequestSearchVO.caseType = caseTypeVOs[0];
				selectCaseType = caseTypeVOs[0].caseTypeName;
			}
			if(handlingAgentVOs.length > 1){
				selectHandlingAgent = SvdReqConstant.ALL;
			}else if(handlingAgentVOs.length == 1){
				posRequestSearchVO.handlingAgent = handlingAgentVOs[0];
				selectHandlingAgent = handlingAgentVOs[0].handlingAgentName;
			}
			dispatchEvent(new Event("updateSelectVal"));
		}
		
		public function resetValidation():void
		{
			ValidationUtil.clearValidationMessage(errorBoxId);
		}
		
		public function doShowContact(obj:Object):void
		{
			var selectedPosRequestSearchResultVO:DisplayPosRequestSearchResultVO = obj as DisplayPosRequestSearchResultVO;
			var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
			maintainRequestVO.requestId = selectedPosRequestSearchResultVO.posRequestSearchResultVO.requestId.id;
			maintainRequestVO.func = functionVO;
			maintainRequestVO.errorBoxComponentId = errorBoxId;
			dispatchEvent(ProofEvent.createMaintainPosRequestEvent(maintainRequestVO));
		}
		
		public function doNew():void
		{
			var caseNoCheck:Boolean = checkRegCaseNumber(newCaseNo,2);
			if(!caseNoCheck){
				ValidateUtil.showValidationMessages(errorBoxId);
			}else{
				resetValidation();
				var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
				maintainRequestVO.func = functionVO;
				maintainRequestVO.caseNo = newCaseNo;
				maintainRequestVO.errorBoxComponentId = errorBoxId;
				dispatchEvent(ProofEvent.createMaintainPosRequestEvent(maintainRequestVO));
			}
		}
	}
}

