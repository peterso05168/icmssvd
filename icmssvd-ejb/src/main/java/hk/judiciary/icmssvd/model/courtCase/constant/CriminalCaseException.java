package hk.judiciary.icmssvd.model.courtCase.constant;

public enum CriminalCaseException {
	MISSING_CORE_DATA ("SRV0001", "Missing core data:"),
	MISSING_MANDATORY_FIELD ("SRV0002", "Missing mandatory field:"),
	INVALID_FIELD_DATA ("SRV0003", "Invalid field data:"),
	
	OPTIMISTIC_LOCK_EXCEPTION ("SRV0101", "Record is updated by other user."),
	
	DUPLICATE_RECORD_RETRIEVED ("SRV201", "Duplicate records is retrieved."),
	
	DUPLICATE_SOD ("SRV0501", "Standard Offence Description is already existed");
	
	private String code;
	private String desc;
	
	private CriminalCaseException(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
}
