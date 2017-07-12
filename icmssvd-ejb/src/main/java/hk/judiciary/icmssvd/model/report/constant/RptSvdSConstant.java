package hk.judiciary.icmssvd.model.report.constant;

import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public enum RptSvdSConstant {
	FORM_NAME_1 ("Magistrates Ordinance, Cap.277", "裁判官條例(第227章)第8及72條"),
	FORM_NAME_2 ("ss. 8 & 72, Form 1", "表格一"),
	TEMPLATE_NO ("S405A2-C", "S405A1");
	
	private String descEng;
	private String descChi;
	
	private RptSvdSConstant(String descEng, String descChi) {
		this.descEng = descEng;
		this.descChi = descChi;
	}
	
	public String getDesc(String langCode) {
		String desc = "";
		if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
			desc =  descEng;
		} else if (langCode.equals(SvdReportUtil.LANG_CODE_CHI)) {
			desc = descChi;
		}
		return desc;
	}
}
