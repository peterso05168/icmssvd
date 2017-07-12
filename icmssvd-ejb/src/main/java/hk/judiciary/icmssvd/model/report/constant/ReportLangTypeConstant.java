package hk.judiciary.icmssvd.model.report.constant;

public enum ReportLangTypeConstant {	
	ENGLISH ("E", "ENGLISH"),
	CHINESE ("C", "CHINESE");
	
	private String code;
	private String locale;
	
	private ReportLangTypeConstant(String code, String locale) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}	
	public String getLocale() {
		return locale;
	}	
}
