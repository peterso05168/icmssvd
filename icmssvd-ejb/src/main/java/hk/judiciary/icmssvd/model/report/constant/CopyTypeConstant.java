package hk.judiciary.icmssvd.model.report.constant;

public enum CopyTypeConstant {
	DEFENDANT ("D"),
	COURT ("C"),
	PROSECUTION_DEPARTMENT ("P");
	
	private String code;
	
	private CopyTypeConstant(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
