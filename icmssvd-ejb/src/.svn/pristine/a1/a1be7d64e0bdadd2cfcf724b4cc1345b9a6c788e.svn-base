package hk.judiciary.icmssvd.model.report.constant;

import hk.judiciary.icmssvd.model.report.util.SvdReportUtil;

public enum CourtInfoConstant {
	
	EASTERN_MAGISTRATES_COURT("ES", "ES", "Eastern Law Courts Building, 29 Tai On Street, Sai Wan Ho, Hong Kong", "香港西灣河太安街29號東區法院大樓"),
	KOWLOON_CITY_MAGISTRATES_COURT("KC", "KC","Kowloon City Law Courts Building, 147M, Argyle Street, Kowloon", "香港九龍亞皆老街147M號"),
	KWUN_TONG_MAGISTRATES_COURT("KT", "KT", "Kuwn Tong  Law Courts Building, 10 Lei Yue Mun Road, Kowloon", "香港九龍鯉魚門道10號"),
	TSUEN_WAN_MAGISTRATES_COURT("TW", "TW", "Tsuen Wan Law Courts Building, 70 Tai Ho Road, Tsuen Wan, New Territories", "香港荃灣大河道70號"),
	FAILING_MAGISTRATES_COURT("FL", "FL", "Failing Law Courts Building, 1 Pik Fung Road, Fanling", "新界粉嶺璧峰路一號"),
	SHATIN_MAGISTRATES_COURT("ST", "ST", "Shatin Law Courts Building, 1 Yi Ching Lane, Shatin, New Territories", "香港新界宜正里1號"),
	TUEN_MUN_MAGISTRATES_COURT("ST", "ST", "Tuen Mun Law Courts Building, 1 Tuen Hi Road, Tuen Mun, New Territories", "香港新界屯喜路1號");
	
	private String code;
	private String prefixType;
	private String addressEng;
	private String addressChi;
	
	private CourtInfoConstant(String code, String prefixType, String addressEng, String addressChi) {
		this.code = code;
		this.prefixType = prefixType;
		this.addressEng = addressEng;
		this.addressChi = addressChi;
	}
	
	public String getCode() {
		return code;
	}	
	public String getPrefixType() {
		return prefixType;
	}	
	public String getAddress(String langCode) {
		String address = "";
		if (langCode.equals(SvdReportUtil.LANG_CODE_ENG)) {
			address = addressEng;
		} else if (langCode.equals(SvdReportUtil.LANG_CODE_CHI)) {
			address = addressChi;
		}
		return address;
	}
}
