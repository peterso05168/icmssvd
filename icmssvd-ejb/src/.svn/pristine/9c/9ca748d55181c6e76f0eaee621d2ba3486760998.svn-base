package hk.judiciary.icmssvd.model.courtCase.biz.dto;

import hk.judiciary.icmssvd.model.courtCase.exception.CriminalGenericException;
import hk.judiciary.icmssvd.model.courtCase.exception.CriminalServerValidationException;

public class ServerValidationExceptionDTO extends GenericExceptionDTO {

	private static final long serialVersionUID = 1L;
	private String msgCode;
	private String msgTitle;
	private String msgDetails;
	public ServerValidationExceptionDTO(CriminalServerValidationException e) {
		super(e);
		// TODO Auto-generated constructor stub
		this.msgCode = e.getCriminalCaseException().getCode();
		this.msgTitle = e.getCriminalCaseException().getDesc();
		this.msgDetails = e.getExceptionDetails();
	}
	public ServerValidationExceptionDTO(CriminalGenericException e) {
		super(e);
		this.msgCode = e.getCriminalCaseException().getCode();
		this.msgTitle = e.getCriminalCaseException().getDesc();
		this.msgDetails = e.getExceptionDetails();
	}
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	public String getMsgDetails() {
		return msgDetails;
	}
	public void setMsgDetails(String msgDetails) {
		this.msgDetails = msgDetails;
	}
	
}
