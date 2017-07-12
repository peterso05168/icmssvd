package hk.judiciary.icmssvd.model.courtCase.constant;

public enum PartcpRoleTypeConstant {
	INFORMANT ("OCC"),
	DEFENDANT ("D"),
	ACCUSED ("A");
	
	private String code;
	
	private PartcpRoleTypeConstant(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
}
