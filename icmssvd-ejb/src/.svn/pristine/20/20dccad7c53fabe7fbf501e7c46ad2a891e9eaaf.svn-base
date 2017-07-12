package hk.judiciary.icmssvd.model.courtCase.biz.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericExceptionDTO extends CommonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String message;
	private List<String> stacktraces = new ArrayList<String>();
	public <E extends Exception> GenericExceptionDTO(E e) {
		message = e.getMessage();
		if (e.getStackTrace() != null && e.getStackTrace().length > 0) {
			int maxStackTrace = 100;
			int cnt = 0;
			for (int i=0; i<e.getStackTrace().length; i++) {
				stacktraces.add(e.getStackTrace()[i].toString());
				cnt++;
				
				if (cnt > maxStackTrace) {
					break;
				}
			}
		}
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getStacktraces() {
		return stacktraces;
	}
	public void setStacktraces(List<String> stacktraces) {
		this.stacktraces = stacktraces;
	}
	
}
