package hk.judiciary.icmssvd.model.report.constant;

import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public enum ReportContentConstant {
	UNKNOWN_AGE ("Unknown", "不詳"),
	PERSON_NON_PGBL ("Personal appearance is required, even if you intend to plead guilty.", "縱使你有意認罪，仍須親自到庭。"),
	ORG_NON_PGBL ("Your representative should bring proof that you have duly appointed him / her to represent your corporation. Personal appearance is required, even if you intend to plead guilty.", "代表你者須備有獲你正式委派代表你公司的證明，縱使你有意認罪，仍須親自到庭。"),
	SEE_ATTACHMENT ("(Please see attached sheet)", "(請參閱附頁)");
	
	private String descEng;
	private String descChi;
	
	private ReportContentConstant(String descEng, String descChi) {
		this.descEng = descEng;
		this.descChi = descChi;
	}
	
	public String getDesc(String langCode) {
		String desc = "";
		if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
			desc = descEng;
		} else if (langCode.equals(SvdReportUtil.LANG_CODE_CHI)) {
			desc = descChi;
		}
		return desc;
	}
}
