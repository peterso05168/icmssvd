package hk.judiciary.icmssvd.view.svdReq.presentation
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.utils.ObjectUtil;
	
	import hk.judiciary.fmk.view.component.CheckBox;
	import hk.judiciary.fmk.view.component.FormItem;
	import hk.judiciary.fmk.view.component.HGroup;
	import hk.judiciary.fmk.view.component.MessageHandler;
	import hk.judiciary.fmk.view.component.Spacer;
	import hk.judiciary.fmk.web.application.util.ValidationUtil;
	import hk.judiciary.icmssvd.view.common.constant.MessageBoxIdConstant;
	import hk.judiciary.icmssvd.view.common.constant.MessageConstant;
	import hk.judiciary.icmssvd.view.common.util.PartyVOUtil;
	import hk.judiciary.icmssvd.view.common.util.ValidateUtil;
	import hk.judiciary.icmssvd.view.common.vo.CaseTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO;
	import hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO;
	import hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO;
	import hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.constant.SvdReqConstant;
	import hk.judiciary.icmssvd.view.svdReq.event.SvdReqEvent;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayRequestStatusTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.DisplayServiceRequestSearchResultVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.FunctionVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.MaintainRequestVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.RequestServiceTypeVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestSearchResultVO;
	import hk.judiciary.icmssvd.view.svdReq.vo.ServiceRequestSearchVO;
	
	[Event(name="initSearchParams,searchServiceRequestList,completeServiceRequestList,clearEquireSvdReqResult,maintainRequest", 
		type="hk.judiciary.icmssvd.view.svdReq.event.SvdReqEvent")]
	
	[ManagedEvents("initSearchParams", scope="local")]
	[ManagedEvents("searchServiceRequestList", scope="local")]
	[ManagedEvents("completeServiceRequestList", scope="local")]
	[ManagedEvents("clearEquireSvdReqResult", scope="local")]
	[ManagedEvents("maintainRequest", scope="local")]
	public class EnquireSvdReqFormPanelPM extends EventDispatcher
	{
		private var _selectedAccordionIndex:Array = [];
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ComprisingCourtVO")]
		private var _comprisingCourtVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.ServiceModeTypeVO")]
		private var _serviceModeTypeVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.CaseTypeVO")]
		private var _caseTypeVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.HandlingAgentVO")]
		private var _handlingAgentVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.RequestStatusTypeVO")]
		private var _requestStatusTypeVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayRequestStatusTypeVO")]
		private var _displayRequestStatusTypeVOs:ArrayCollection=new ArrayCollection();
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.RequestServiceTypeVO")]
		private var _requestServiceTypeVOs:ArrayCollection=new ArrayCollection();
		
		private var _serviceRequestSearchVO:ServiceRequestSearchVO = new ServiceRequestSearchVO;
		
		private var _dateFormat:String = SvdReqConstant.DEFAULT_DATE_PATTERN;
		
		private var _functionVO:FunctionVO = new FunctionVO;
		
		private var _errorBoxId:String;
		private var _panelId:String;
		
		[Bindable]
		public function get selectedAccordionIndex():Array {return this._selectedAccordionIndex;}
		public function set selectedAccordionIndex(value:Array):void {this._selectedAccordionIndex = value;}
		
		[Bindable]
		public function get functionVO():FunctionVO{ return this._functionVO; }
		public function set functionVO(value:FunctionVO):void { this._functionVO=value; }
		
		private var _selectComprisingCourt:String;
		private var _selectServiceMode:String;
		private var _selectCaseType:String;
		private var _selectHandlingAgent:String;
		private var _selectRequestServiceType:String;
		
		private var _checkBoxVisible:Boolean = false;
		private var _completeAble:Boolean=false;
		private var _newAble:Boolean=false;
		private var _newCaseNo:String;
		
		[ArrayElementType("hk.judiciary.icmssvd.view.common.vo.IdVO")]
		private var _requestIdDTOs:ArrayCollection = new ArrayCollection;
		[Bindable]
		public function get requestIdDTOs():ArrayCollection{ return this._requestIdDTOs; }
		public function set requestIdDTOs(value:ArrayCollection):void { this._requestIdDTOs=value; }
		
		[Bindable]
		public function get checkBoxVisible():Boolean{ return this._checkBoxVisible; }
		public function set checkBoxVisible(value:Boolean):void { this._checkBoxVisible=value; }
		[Bindable]
		public function get completeAble():Boolean{ return this._completeAble; }
		public function set completeAble(value:Boolean):void { this._completeAble=value; }
		[Bindable]
		public function get newAble():Boolean{ return this._newAble; }
		public function set newAble(value:Boolean):void { this._newAble=value; }
		[Bindable]
		public function get newCaseNo():String{ return this._newCaseNo; }
		public function set newCaseNo(value:String):void { this._newCaseNo=value; }
		
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectComprisingCourt():String { return _selectComprisingCourt;} 
		public function set selectComprisingCourt(value:String):void { this._selectComprisingCourt=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectServiceMode():String { return _selectServiceMode; } 
		public function set selectServiceMode(value:String):void { this._selectServiceMode=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectCaseType():String { return _selectCaseType;} 
		public function set selectCaseType(value:String):void { this._selectCaseType=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectHandlingAgent():String { return _selectHandlingAgent; } 
		public function set selectHandlingAgent(value:String):void { this._selectHandlingAgent=value; }
		[Bindable]
		[Bindable(event="updateSelectVal")]
		public function get selectRequestServiceType():String {return _selectRequestServiceType; } 
		public function set selectRequestServiceType(value:String):void { this._selectRequestServiceType=value; }
	
		[Bindable]
		public function get dateFormat():String { return _dateFormat; } 
		public function set dateFormat(value:String):void { this._dateFormat=value; }
		
		[Bindable]
		public function get errorBoxId():String { return _errorBoxId; } 
		public function set errorBoxId(value:String):void { this._errorBoxId=value; }
		[Bindable]
		public function get panelId():String { return _panelId; } 
		public function set panelId(value:String):void { this._panelId=value; }
		
		[Bindable]
		public function get comprisingCourtVOs():ArrayCollection { return this._comprisingCourtVOs; }
		public function set comprisingCourtVOs(value:ArrayCollection):void { this._comprisingCourtVOs=value; }
		
		[Bindable]
		public function get serviceModeTypeVOs():ArrayCollection { return this._serviceModeTypeVOs; }
		public function set serviceModeTypeVOs(value:ArrayCollection):void { this._serviceModeTypeVOs=value; }
		
		[Bindable]
		public function get caseTypeVOs():ArrayCollection { return this._caseTypeVOs; }
		public function set caseTypeVOs(value:ArrayCollection):void { this._caseTypeVOs=value; }
		
		[Bindable]
		public function get handlingAgentVOs():ArrayCollection { return this._handlingAgentVOs; }
		public function set handlingAgentVOs(value:ArrayCollection):void { this._handlingAgentVOs=value; }
		
		[Bindable]
		public function get requestStatusTypeVOs():ArrayCollection { return this._requestStatusTypeVOs; }
		public function set requestStatusTypeVOs(value:ArrayCollection):void { this._requestStatusTypeVOs=value; }
		
		[Bindable]
		public function get displayRequestStatusTypeVOs():ArrayCollection { return this._displayRequestStatusTypeVOs; }
		public function set displayRequestStatusTypeVOs(value:ArrayCollection):void { this._displayRequestStatusTypeVOs=value; }
		
		[Bindable]
		public function get requestServiceTypeVOs():ArrayCollection { return this._requestServiceTypeVOs; }
		public function set requestServiceTypeVOs(value:ArrayCollection):void { this._requestServiceTypeVOs=value; }
		
		[Bindable]
		public function get serviceRequestSearchVO():ServiceRequestSearchVO { return this._serviceRequestSearchVO; }
		public function set serviceRequestSearchVO(value:ServiceRequestSearchVO):void { this._serviceRequestSearchVO=value; }
		
		public function init(func:String):void
		{
			selectedAccordionIndex = [0];
			functionVO.courtLevelTypeCode = func;
			if(func == SvdReqConstant.COURT_LEVEL_TYPE_MAGISTRATES){
				checkBoxVisible = true;
				errorBoxId = MessageBoxIdConstant.ENQ_SVDREQ_ERROR_MC;
				panelId = "enquireSvdReqFormPanelMC.";
			}else{
				checkBoxVisible = false;
				errorBoxId = MessageBoxIdConstant.ENQ_SVDREQ_ERROR_DC;
				panelId = "enquireSvdReqFormPanelDC.";
			}
			dispatchEvent(SvdReqEvent.initSearchParams(functionVO));
		}
		
		private var _formObj:FormItem;

		public function formObj(value:Object):void {this._formObj=value as FormItem;}
		
		public function displayRequestStatusType():void
		{
			this._displayRequestStatusTypeVOs.removeAll();
			if(requestStatusTypeVOs != null){
				for each(var reqStatusType:RequestStatusTypeVO in requestStatusTypeVOs){
					var displayStatusType:DisplayRequestStatusTypeVO = new DisplayRequestStatusTypeVO;
					displayStatusType.selected = true;
					displayStatusType.requestStatusTypeVO = reqStatusType;
					this._displayRequestStatusTypeVOs.addItem(displayStatusType);
				}
			}
			
			if(this._displayRequestStatusTypeVOs!= null && this._displayRequestStatusTypeVOs.length > 0){
				this._formObj.removeAllElements();
				var len:int = this._displayRequestStatusTypeVOs.length;
				var columnNum:int=4;
				var box:CheckBox;
				var hg:HGroup;
				var spacer:Spacer = new Spacer;
				for(var k:int=0;k<(len/columnNum);k++){
					var index:int = 0;
					hg = new HGroup;
					hg.height = 30;
					hg.gap = 5;
					for(var j:int=0;j<columnNum;j++){
						index=k*columnNum+j;
						if(index<len){
							var statusType:DisplayRequestStatusTypeVO = this._displayRequestStatusTypeVOs[index] as DisplayRequestStatusTypeVO;
							var typeDisplay:String = statusType.requestStatusTypeVO.requestStatusTypeName;
							box = new CheckBox();
							box.label = typeDisplay;
							box.includeInLayout = true;
							box.minWidth = 70;
							box.selected = statusType.selected;
							box.id = "status"+statusType.requestStatusTypeVO.requestStatusTypeId;
							box.addEventListener(MouseEvent.CLICK,changeStatus);
							hg.addElement(box);
							hg.addElement(spacer);
						}
					}
					this._formObj.addElement(hg);
				}
			}
		}
		
		private function changeStatus(e:MouseEvent):void{
			var cb:CheckBox = CheckBox(e.target);
			if(this._displayRequestStatusTypeVOs!= null && this._displayRequestStatusTypeVOs.length > 0){
				for each(var statusType:DisplayRequestStatusTypeVO in this._displayRequestStatusTypeVOs){
					if(("status" + statusType.requestStatusTypeVO.requestStatusTypeId) == cb.id){
						statusType.selected = cb.selected;
						break;
					}
				}
			}
		}
		
		public function changCourt(court:Object):void{
			var comprisingCourtVO:ComprisingCourtVO = court as ComprisingCourtVO;
			serviceRequestSearchVO.comprisingCourt = comprisingCourtVO;
		}
		
		public function changServiceMode(serviceMode:Object):void{
			serviceRequestSearchVO.serviceModeType = serviceMode as ServiceModeTypeVO;
		}
		
		public function changCaseType(caseType:Object):void{
			serviceRequestSearchVO.caseType = caseType as CaseTypeVO;
		}
		
		public function changHandlingAgent(handlingAgent:Object):void{
			serviceRequestSearchVO.handlingAgent = handlingAgent as HandlingAgentVO;
		}
		
		public function changRequestServiceType(requestServiceType:Object):void{
			serviceRequestSearchVO.requestServiceType = requestServiceType as RequestServiceTypeVO;
		}
		
		public function doClear():void{
			dispatchEvent(SvdReqEvent.clearEquireSvdReqResultEvent());
		}
		
		[MessageHandler(selector="clearEquireSvdReqResult", scope="local")]
		public function clearEquireSvdReqResultHandler(event:SvdReqEvent):void{
			this.resetValidation();
			completeAble = false;
			newAble = false;
			newCaseNo = new String;
			serviceRequestSearchVO = new ServiceRequestSearchVO;
			displayServiceRequestSearchResultVOs.removeAll();
			if(comprisingCourtVOs.length > 1){
				selectComprisingCourt = SvdReqConstant.ALL;
			}else if(comprisingCourtVOs.length == 1){
				serviceRequestSearchVO.comprisingCourt = comprisingCourtVOs[0];
				selectComprisingCourt = comprisingCourtVOs[0].comprisingCourtName;
			}
			if(serviceModeTypeVOs.length > 1){
				selectServiceMode = SvdReqConstant.ALL;
			}else if(serviceModeTypeVOs.length == 1){
				serviceRequestSearchVO.serviceModeType = serviceModeTypeVOs[0];
				selectServiceMode = serviceModeTypeVOs[0].serviceModeTypeName;
			}
			if(caseTypeVOs.length > 1){
				selectCaseType = SvdReqConstant.ALL;
			}else if(caseTypeVOs.length == 1){
				serviceRequestSearchVO.caseType = caseTypeVOs[0];
				selectCaseType = caseTypeVOs[0].caseTypeName;
			}
			if(handlingAgentVOs.length > 1){
				selectHandlingAgent = SvdReqConstant.ALL;
			}else if(handlingAgentVOs.length == 1){
				serviceRequestSearchVO.handlingAgent = handlingAgentVOs[0];
				selectHandlingAgent = handlingAgentVOs[0].handlingAgentName;
			}
			displayRequestStatusType();
			if(requestServiceTypeVOs.length > 1){
				selectRequestServiceType = SvdReqConstant.ALL;
			}else if(requestServiceTypeVOs.length == 1){
				serviceRequestSearchVO.requestServiceType = requestServiceTypeVOs[0];
				selectRequestServiceType = requestServiceTypeVOs[0].requestServiceTypeName;
			}
			dispatchEvent(new Event("updateSelectVal"));
		}
		
		public function doSearch():void
		{
			if(validate()){
				selectedAccordionIndex = [-1];
				completeAble = false;
				serviceRequestSearchVO.requestStatusType.removeAll();
				if(this._displayRequestStatusTypeVOs!= null && this._displayRequestStatusTypeVOs.length > 0){
					for each(var statusType:DisplayRequestStatusTypeVO in this._displayRequestStatusTypeVOs){
						if(statusType.selected){
							serviceRequestSearchVO.requestStatusType.addItem(ObjectUtil.copy(statusType.requestStatusTypeVO));
						}
					}
				}
				serviceRequestSearchVO.func = functionVO;
				dispatchEvent(SvdReqEvent.searchServiceRequestList(serviceRequestSearchVO));
			}
		}
		
		[ArrayElementType("hk.judiciary.icmssvd.view.svdReq.vo.DisplayServiceRequestSearchResultVO")]
		private var _displayServiceRequestSearchResultVOs:ArrayCollection = new ArrayCollection;
		
		[Bindable]
		public function get displayServiceRequestSearchResultVOs():ArrayCollection { return this._displayServiceRequestSearchResultVOs; }
		public function set displayServiceRequestSearchResultVOs(value:ArrayCollection):void { this._displayServiceRequestSearchResultVOs = value; }
		
		
		public function showSearchResult(value:ArrayCollection):void
		{
			this.displayServiceRequestSearchResultVOs.removeAll();
			if(value != null && value.length > 0){
				for each (var serviceRequestSearchResultVO:ServiceRequestSearchResultVO in value){
					var tmpDisplayServiceRequestSearchResultVO:DisplayServiceRequestSearchResultVO = new DisplayServiceRequestSearchResultVO();
					tmpDisplayServiceRequestSearchResultVO.checked = false;
					tmpDisplayServiceRequestSearchResultVO.requestId = serviceRequestSearchResultVO.requestId;
					tmpDisplayServiceRequestSearchResultVO.submitDate = serviceRequestSearchResultVO.submitDate;
					tmpDisplayServiceRequestSearchResultVO.caseNo = serviceRequestSearchResultVO.caseNo;
					tmpDisplayServiceRequestSearchResultVO.requesterName = PartyVOUtil.getRequestName(serviceRequestSearchResultVO.requester);
					tmpDisplayServiceRequestSearchResultVO.recipientName = PartyVOUtil.getRequestName(serviceRequestSearchResultVO.recipient);
					tmpDisplayServiceRequestSearchResultVO.hkRegionName = PartyVOUtil.getStr(serviceRequestSearchResultVO.hkRegion.hkRegionName);
					tmpDisplayServiceRequestSearchResultVO.serviceModeTypeName = PartyVOUtil.getStr(serviceRequestSearchResultVO.serviceModeType.serviceModeTypeName);
					tmpDisplayServiceRequestSearchResultVO.handlingAgentName = PartyVOUtil.getStr(serviceRequestSearchResultVO.handlingAgent.handlingAgentName);
					tmpDisplayServiceRequestSearchResultVO.requestServiceTypeName = PartyVOUtil.getStr(serviceRequestSearchResultVO.requestServiceType.requestServiceTypeName);
					tmpDisplayServiceRequestSearchResultVO.urgentServiceInd = serviceRequestSearchResultVO.urgentServiceInd;
					tmpDisplayServiceRequestSearchResultVO.requestStatusTypeName = PartyVOUtil.getStr(serviceRequestSearchResultVO.requestStatusType.requestStatusTypeName);
					tmpDisplayServiceRequestSearchResultVO.serviceRequestSearchResultVO = serviceRequestSearchResultVO;
					
					this.displayServiceRequestSearchResultVOs.addItem(tmpDisplayServiceRequestSearchResultVO);
				}
			}
		}
		
		public function validate():Boolean{
			this.resetValidation();
			var submitDate:Boolean = submitDateValid();
			var caseNo:Boolean = checkRegCaseNumber(serviceRequestSearchVO.caseNo, 1);
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
			var caseNoBox:String = "CaseNo";
			var caseNo2Box:String = "CaseNoNew";
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
						serviceRequestSearchVO.caseNo = correctCaseNo;
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
			var startDate:Date = serviceRequestSearchVO.submitStartDate;
			var endDate:Date = serviceRequestSearchVO.submitEndDate;
			var startDateBox:String = "LastReceivedDateForm";
			var endDateBox:String = "LastReceivedDateTo";
			if(startDate != null && endDate != null && ObjectUtil.dateCompare(startDate,endDate) > 0){
				ValidateUtil.addMultiplyValidationMessage(MessageConstant.END_TIME_LARGER_START_TIME, new ArrayCollection([panelId + startDateBox, panelId + endDateBox]), errorBoxId);
				bl = false;
			}
			return bl;
		}
		
		public function resetValidation():void
		{
			ValidationUtil.clearValidationMessage(errorBoxId);
		}
		
		public function doShowContact(obj:Object):void
		{
			var selectedServiceRequestSearchResultVO:DisplayServiceRequestSearchResultVO = obj as DisplayServiceRequestSearchResultVO;
			var maintainRequestVO:MaintainRequestVO = new MaintainRequestVO;
			maintainRequestVO.requestId = selectedServiceRequestSearchResultVO.requestId.id;
			maintainRequestVO.func = functionVO;
			maintainRequestVO.errorBoxComponentId = errorBoxId;
			dispatchEvent(SvdReqEvent.createMaintainRequestEvent(maintainRequestVO));
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
				dispatchEvent(SvdReqEvent.createMaintainRequestEvent(maintainRequestVO));
			}
		}
		
		public function changeCaseNo():void{
			newCaseNo = serviceRequestSearchVO.caseNo;
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
		
		public function completeAbleCheck():void{
			requestIdDTOs.removeAll();
			if(displayServiceRequestSearchResultVOs != null && displayServiceRequestSearchResultVOs.length > 0){
				for each(var result:DisplayServiceRequestSearchResultVO in displayServiceRequestSearchResultVOs){
					if(result.checked == true){
						if(result.serviceRequestSearchResultVO.allowCompleteInd){
							requestIdDTOs.addItem(result.requestId);
						}else{
							MessageHandler.createErrorMessageBox(MessageConstant.CANNOT_COMPLETE, null, null);
							result.checked = false;
						}
					}
				}
			}
			if(requestIdDTOs.length >= 1){
				completeAble = true;
			}else{
				completeAble = false;
			}
		}
		
		public function doComplete():void{
			dispatchEvent(SvdReqEvent.completeServiceRequestList(requestIdDTOs));
			dispatchEvent(SvdReqEvent.searchServiceRequestList(serviceRequestSearchVO));
			completeAble = false;
		}
	}
}