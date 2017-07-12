package hk.judiciary.icmssvd.model.courtCase.exception;

import hk.judiciary.icmssvd.model.courtCase.constant.CriminalCaseException;

public class CriminalGenericException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private CriminalCaseException criminalCaseException;
	private String exceptionDetails;
	
	public CriminalGenericException() {}
	
	public CriminalGenericException(Exception e) {
		super(e.getMessage(), e.getCause());
	}

	public CriminalCaseException getCriminalCaseException() {
		return criminalCaseException;
	}

	public void setCriminalCaseException(CriminalCaseException criminalCaseException) {
		this.criminalCaseException = criminalCaseException;
	}

	public String getExceptionDetails() {
		return exceptionDetails;
	}

	public void setExceptionDetails(String exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}
	
	
}
