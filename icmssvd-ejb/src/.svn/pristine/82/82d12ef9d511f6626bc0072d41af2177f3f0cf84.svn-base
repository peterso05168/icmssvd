package hk.judiciary.icmssvd.model.report.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import hk.judiciary.fmk.common.util.ReportUtil;
import hk.judiciary.fmk.model.report.biz.dto.ReportRequestRequestParameterDTO;
import hk.judiciary.icms.model.dao.entity.Addr;
import hk.judiciary.icms.model.dao.entity.AddrRole;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.CaseType;
import hk.judiciary.icms.model.dao.entity.ChrgApp;
import hk.judiciary.icms.model.dao.entity.ChrgNat;
import hk.judiciary.icms.model.dao.entity.CompsCourt;
import hk.judiciary.icms.model.dao.entity.CourtVenue;
import hk.judiciary.icms.model.dao.entity.Org;
import hk.judiciary.icms.model.dao.entity.Partcp;
import hk.judiciary.icms.model.dao.entity.Pd;
import hk.judiciary.icms.model.dao.entity.Person;
import hk.judiciary.icms.model.dao.entity.SummonNoti;
import hk.judiciary.icmscase.model.cmcCriminal.biz.dto.ws.FormattedChrgPartcrDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.ComprisingCourtDTO;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.CourtVenueDTO;
import hk.judiciary.icmssvd.model.courtCase.constant.CaseTypeConstant;
import hk.judiciary.icmssvd.model.courtCase.constant.PartcpTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.CourtInfoConstant;
import hk.judiciary.icmssvd.model.report.constant.ReportContentConstant;
import hk.judiciary.icmssvd.model.report.constant.ReportLangTypeConstant;
import hk.judiciary.icmssvd.model.report.constant.SvdReportConstant;


public class SvdReportUtil {

	public static String LANG_CODE_ENG = ReportLangTypeConstant.ENGLISH.getCode();
	public static String LANG_CODE_CHI = ReportLangTypeConstant.CHINESE.getCode();
	
	public static String FLAG_VALID_CODE = "1";
	public static String FLAG_INVALID_CODE = "0";	
	
	public static String FONT_SIZE_SMALL = "S";
	public static String FONT_SIZE_NORMAL = "N";
	
	public static ReportRequestRequestParameterDTO generateRequestParameterDTO(SvdReportConstant svdReportConstant) {    	
    	return generateRequestParameterDTO(svdReportConstant.getReportName(), svdReportConstant.getReportTypeCode(), svdReportConstant.getReportFormat());
    }

    public static ReportRequestRequestParameterDTO generateRequestPdfParameterDTO(SvdReportConstant svdReportConstant) {
        return generateRequestParameterDTO(svdReportConstant.getReportName(), svdReportConstant.getReportTypeCode(), ReportUtil.ReportFormat.PDF);
    }

    public static ReportRequestRequestParameterDTO generateExcelRequestParameterDTO(SvdReportConstant svdReportConstant) {
        return generateRequestParameterDTO(svdReportConstant.getReportName(), svdReportConstant.getReportTypeCode(), ReportUtil.ReportFormat.XLSX);
    }
    
    public static ReportRequestRequestParameterDTO generateWordRequestParameterDTO(SvdReportConstant svdReportConstant) {
        return generateRequestParameterDTO(svdReportConstant.getReportName(), svdReportConstant.getReportTypeCode(), ReportUtil.ReportFormat.DOCX);
    }

    public static ReportRequestRequestParameterDTO generateRequestParameterDTO(String name, String typeCode, String format) {
    	return generateRequestParameterDTO(name, typeCode, ReportUtil.ReportMode.ADHOC, format, ReportUtil.ReportLocale.ENGLISH);
    }
    
    public static ReportRequestRequestParameterDTO generateRequestParameterDTO(String name, String typeCode, String mode, String format, String locale) {
        ReportRequestRequestParameterDTO dto = new ReportRequestRequestParameterDTO();
        dto.setReportName(name);
        dto.setReportTypeCode(typeCode);
        dto.setReportMode(mode);
        dto.setReportFormat(format);
        dto.setLocale(locale);
        return dto;
    }
	
	public static String getFormattedChrgPartcr(FormattedChrgPartcrDTO formattedChrgPartcrDTO, String langCode) {
		String formattedChrgPartcr = "";
		if (formattedChrgPartcrDTO != null) {
			if (langCode.equals(LANG_CODE_ENG)) {
				formattedChrgPartcr = formattedChrgPartcrDTO.getFormattedChrgPartcrEng();
			} else if (langCode.equals(LANG_CODE_CHI)) {
				formattedChrgPartcr = formattedChrgPartcrDTO.getFormattedChrgPartcrChi();
			}
		}
		return formattedChrgPartcr;
	}
	

	public static FormattedChrgPartcrDTO removeParagraphFormat(FormattedChrgPartcrDTO formattedChrgPartcrDTO) {
		FormattedChrgPartcrDTO dto = formattedChrgPartcrDTO;
		dto.setFormattedChrgPartcrEng(removeParagraph(dto.getFormattedChrgPartcrEng()));
		dto.setFormattedChrgPartcrChi(removeParagraph(dto.getFormattedChrgPartcrChi()));
		return dto;
	}
	
	public static String getChargeParticularFontSize(String chargeParticular, String langCode) throws UnsupportedEncodingException {
		String fontSize = FONT_SIZE_NORMAL;
		if (langCode.equals(LANG_CODE_ENG)) {
			if (chargeParticular.length() > 3000) {
				fontSize = FONT_SIZE_SMALL;
			}
		} else if (langCode.equals(LANG_CODE_CHI)) {
			if (chargeParticular.getBytes("UTF-8").length > 1500) {
				fontSize = FONT_SIZE_SMALL;
			}
		}
		return fontSize;
	}
	
	public static boolean isAttachmentRequired(FormattedChrgPartcrDTO formattedChrgPartcrDTO) throws UnsupportedEncodingException {
		boolean attachmentRequired = false;
		if (formattedChrgPartcrDTO != null) {
			if (formattedChrgPartcrDTO.getFormattedChrgPartcrEng().length() > 700 ||
					formattedChrgPartcrDTO.getFormattedChrgPartcrChi().getBytes("UTF-8").length > 450) {
				attachmentRequired = true;
			}
		}
		return attachmentRequired;
	}
	
	public static String getRemark(CaseType caseType, SummonNoti summonNoti, Partcp partcp, String langCode) {
		String remarks = "";
		if (caseType != null) {
			if (caseType.getCaseTypeCd().equals(CaseTypeConstant.DEPARTMENTAL_SUMMONS.getCode())) {
				if (summonNoti != null && summonNoti.getPgblAllow().equals(FLAG_INVALID_CODE)) {
					if (partcp != null) {
						if (partcp.getPartcpType().getPartcpTypeCd().equals(PartcpTypeConstant.PERSON.getCode())) {
							remarks = ReportContentConstant.PERSON_NON_PGBL.getDesc(langCode);
						} else if (partcp.getPartcpType().getPartcpTypeCd().equals(PartcpTypeConstant.ORGANIZATION.getCode())) {
							remarks = ReportContentConstant.ORG_NON_PGBL.getDesc(langCode);
						}
					}
				}
			}
		}
		return remarks;
	}
	
	private static String dummyCompsCourtChi(String compsCourtCd) {
		return dummyCourtName(compsCourtCd, LANG_CODE_CHI);
	}
	
	private static String dummyCourtName(String compsCourtCd, String langCode) {
		String courtName = "";
		if (langCode.equals(LANG_CODE_ENG)) {
			switch (compsCourtCd) {
				case "ES": courtName = "Eastern Magistrates' Court"; break;
				case "KC": courtName = "Kowloon City Magistrates' Court"; break;
				case "KT": courtName = "Kwun Tung Magistrates' Court"; break;
				case "TW": courtName = "Tsuen Wan Magistrates' Court"; break;
				case "FL": courtName = "Fanling Magistrates' Court"; break;
				case "ST": courtName = "Shatin Magistrates' Court"; break;
				case "TM": courtName = "Tuen Mun Magistrates' Court"; break;
				default: break;
			}
		} else if (langCode.equals(LANG_CODE_CHI)) {
			switch (compsCourtCd) {
				case "ES": courtName = "東區裁判法院"; break;
				case "KC": courtName = "九龍城裁判法院"; break;
				case "KT": courtName = "觀塘裁判法院"; break;
				case "TW": courtName = "荃灣裁判法院"; break;
				case "FL": courtName = "粉嶺裁判法院"; break;
				case "ST": courtName = "沙田裁判法院"; break;
				case "TM": courtName = "屯門裁判法院"; break;
				default: break;
			}
		}
		return courtName;
	}
	
	public static String getComprisingCourtName(CompsCourt compsCourt, String langCode) {
		String compsCourtName = "";
		if (compsCourt != null) {
			if (langCode.equals(LANG_CODE_ENG)) {
				compsCourtName = compsCourt.getCompsCourtDesc();
			} else if (langCode.equals(LANG_CODE_CHI)) {
				//compsCourtName = compsCourt.getCompsCourtDesc();				
				compsCourtName = dummyCompsCourtChi(compsCourt.getCompsCourtCd());
			}
		}
		return compsCourtName;
	}
	
	public static String getComprisingCourtName(ComprisingCourtDTO compsCourtDTO, String langCode) {
		String compsCourtName = "";
		if (compsCourtDTO != null) {
			if (langCode.equals(LANG_CODE_ENG)) {
				compsCourtName = compsCourtDTO.getCompsCourtDesc();
			} else if (langCode.equals(LANG_CODE_CHI)) {
				//compsCourtName = compsCourtDTO.getCompsCourtDesc();
				compsCourtName = dummyCompsCourtChi(compsCourtDTO.getCompsCourtPrfx());
			}
		}
		return compsCourtName;
	}

	
	public static String getCaseCourtName(Case vCase, String langCode) {
		String caseCourtName = "";
		if (vCase != null && vCase.getCompsCourt() != null) {
			caseCourtName = getComprisingCourtName(vCase.getCompsCourt(), langCode);
		}
		return caseCourtName;
	}

	public static String getCaseCourtAddress(Case vCase, String langCode) {
		// Dummy only
		String caseCourtAddress = "";
		if (vCase != null && vCase.getCompsCourt() != null) {
			if (vCase.getCompsCourt().getCompsCourtCd().equals(CourtInfoConstant.EASTERN_MAGISTRATES_COURT.getCode())) {
				caseCourtAddress = CourtInfoConstant.EASTERN_MAGISTRATES_COURT.getAddress(langCode);
			} else if (vCase.getCompsCourt().getCompsCourtCd().equals(CourtInfoConstant.KOWLOON_CITY_MAGISTRATES_COURT.getCode())) {
				caseCourtAddress = CourtInfoConstant.KOWLOON_CITY_MAGISTRATES_COURT.getAddress(langCode);
			} else if (vCase.getCompsCourt().getCompsCourtCd().equals(CourtInfoConstant.KWUN_TONG_MAGISTRATES_COURT.getCode())) {
				caseCourtAddress = CourtInfoConstant.KWUN_TONG_MAGISTRATES_COURT.getAddress(langCode);
			} else if (vCase.getCompsCourt().getCompsCourtCd().equals(CourtInfoConstant.TSUEN_WAN_MAGISTRATES_COURT.getCode())) {
				caseCourtAddress = CourtInfoConstant.TSUEN_WAN_MAGISTRATES_COURT.getAddress(langCode);
			} else if (vCase.getCompsCourt().getCompsCourtCd().equals(CourtInfoConstant.FAILING_MAGISTRATES_COURT.getCode())) {
				caseCourtAddress = CourtInfoConstant.FAILING_MAGISTRATES_COURT.getAddress(langCode);
			} else if (vCase.getCompsCourt().getCompsCourtCd().equals(CourtInfoConstant.SHATIN_MAGISTRATES_COURT.getCode())) {
				caseCourtAddress = CourtInfoConstant.SHATIN_MAGISTRATES_COURT.getAddress(langCode);
			} else if (vCase.getCompsCourt().getCompsCourtCd().equals(CourtInfoConstant.TUEN_MUN_MAGISTRATES_COURT.getCode())) {
				caseCourtAddress = CourtInfoConstant.TUEN_MUN_MAGISTRATES_COURT.getAddress(langCode);
			} 
		}
		return caseCourtAddress;
	}
	
	public static String getCourtVenueName(CourtVenueDTO courtVenueDTO, String langCode) {
		String courtVenueName = "";
		if (courtVenueDTO != null) {
			if (langCode.equals(LANG_CODE_ENG)) {
				courtVenueName = courtVenueDTO.getCourtVenueName();
			} else if (langCode.equals(LANG_CODE_CHI)) {
				courtVenueName = courtVenueDTO.getCourtVenueNameInChinTrad();
			}
		}
		return courtVenueName;
	}
	
	public static String getCourtVenueName(CourtVenue courtVenue, String langCode) {
		String courtVenueName = "";
		if (langCode.equals(LANG_CODE_ENG)) {
			courtVenueName = courtVenue.getCourtVenueName();
		} else if (langCode.equals(LANG_CODE_CHI)) {
			courtVenueName = courtVenue.getCourtVenueNameInChinTrad();
		}
		return courtVenueName;
	}
	
	public static String getCourtAddress(CourtVenueDTO courtVenueDTO, String langCode) {
		String courtAddress = "";
		if (langCode.equals(LANG_CODE_ENG)) {
			courtAddress = courtVenueDTO.getCourtVenueDesc();
		} else if (langCode.equals(LANG_CODE_CHI)) {
			courtAddress = courtVenueDTO.getCourtVenueDescInChinTrad();
		}
		return courtAddress;
	}
	
	public static String getCourtVenueAddress(CourtVenue courtVenue, String langCode) {
		String courtAddress = "";
		if (langCode.equals(LANG_CODE_ENG)) {
			courtAddress = courtVenue.getCourtVenueDesc();
		} else if (langCode.equals(LANG_CODE_CHI)) {
			courtAddress = courtVenue.getCourtVenueDescInChinTrad();
		}
		return courtAddress;
	}
		
	public static String getContraryToLaw(ChrgApp chrgApp, String langCode) {
		String contraryToLaw = "";
		if (chrgApp != null) {
			if (langCode.equals(LANG_CODE_ENG)) {
				contraryToLaw = chrgApp.getContryToLaw();
			} else if (langCode.equals(LANG_CODE_CHI)) {
				contraryToLaw = chrgApp.getContryToLawChin();
			}
		}
		return contraryToLaw;
	}
	
	public static String getPartcpAge(Partcp partcp, String langCode) {
		String partcpAge = ReportContentConstant.UNKNOWN_AGE.getDesc(langCode);
		if (partcp != null && partcp.getPerson() != null) {
			if (partcp.getPerson().getPersonAge() != null && partcp.getPerson().getPersonAge().intValue() > 0) {
				partcpAge = partcp.getPerson().getPersonAge().toString();
			}
		}
		return partcpAge;
	}
	
	public static String getPartcpGender(Partcp partcp, String langCode) {
		String partcpGender = "";
		if (partcp != null && partcp.getPerson() != null) {
			if (partcp.getPerson().getGendrType() != null) {
				if (langCode.equals(LANG_CODE_ENG)) {
					partcpGender = partcp.getPerson().getGendrType().getDescEng();
				} else if (langCode.equals(LANG_CODE_CHI)) {
					partcpGender = partcp.getPerson().getGendrType().getDescChin();
				}
			}
		}
		return partcpGender;
	}

	public static String getPartcpIdNo(Partcp partcp) {
		String partcpIdNo = "";
		if (partcp != null) {
			if (partcp.getPerson() != null) {
				if (partcp.getPerson().getPersonIdentNo() != null) {
					partcpIdNo = partcp.getPerson().getPersonIdentNo();
				}
			} else if (partcp.getOrg() != null) {
				if (partcp.getOrg().getOrgIdentNo() != null) {
					partcpIdNo = partcp.getOrg().getOrgIdentNo();
				}
			}
		}
		return partcpIdNo.toUpperCase();
	}
	
	public static String getPartcpIdType(Partcp partcp, String langCode) {
		String partcpIdType = "";
		if (partcp != null) {
			if (partcp.getPerson() != null) {
				if (partcp.getPerson().getPersonIdType() != null) {
					if (langCode.equals(LANG_CODE_ENG)) {
						partcpIdType = partcp.getPerson().getPersonIdType().getDescEng();
					} else if (langCode.equals(LANG_CODE_CHI)) {
						partcpIdType = partcp.getPerson().getPersonIdType().getDescChin();
					}
				}
			} else if (partcp.getOrg() != null) {
				if (partcp.getOrg().getOrgIdType() != null) {
					if (langCode.equals(LANG_CODE_ENG)) {
						partcpIdType = partcp.getOrg().getOrgIdType().getDescEng();
					} else if (langCode.equals(LANG_CODE_CHI)) {
						partcpIdType = partcp.getOrg().getOrgIdType().getDescChin();
					}
				}
			}
		}
		return partcpIdType;
	}
	
	public static String getInformantInfo(Partcp partcp, ChrgNat chrgNat, String langCode) {
		String informantInfo = "";
		Person person = null;
		Pd pd = null;
		
		if (partcp != null) {
			person = partcp.getPerson();
		}		
		if (chrgNat != null) {
			pd = chrgNat.getPd();
		}
		
		if (langCode.equals(LANG_CODE_ENG)) {
			informantInfo += getPersonName(person, false, langCode);
			informantInfo += " of ";			
			informantInfo += (pd != null ? pd.getPdName() : "");
		} else if (langCode.equals(LANG_CODE_CHI)) {
			informantInfo += (pd != null ? pd.getPdNameChin() : "");
			informantInfo += "的";
			informantInfo += getPersonName(person, false, langCode);
		}
		
		return informantInfo;
	}
	
	public static String getPartcpName(Partcp partcp, boolean withNameImage, String langCode) {
		String partcpName = "";
		if (partcp != null) {
			if (partcp.getPerson() != null) {
				partcpName = getPersonName(partcp.getPerson(), withNameImage, langCode);
			} else if (partcp.getOrg() != null) {
				partcpName = getOrgName(partcp.getOrg(), langCode);
			}
		}
		return partcpName;
	}	
	
	private static String getPersonName(Person person, boolean withNameImage, String langCode) {
		String personName = "";
		
		if (person != null) {
			String personNameEng = "";
			if (person.getSurname() != null) {
				personNameEng = person.getSurname();
			}
			if (person.getGivenName() != null) {
				if (!personNameEng.equals("")) {
					personNameEng += ", ";
				}
				personNameEng += person.getGivenName();
			}
			String personNameChi = "";
			if (person.getSurnameChin() != null) {
				personNameChi += person.getSurnameChin();
			}
			if (person.getGivenNameChin() != null) {
				personNameChi += person.getGivenNameChin();
			}
			
			if (langCode.equals(LANG_CODE_ENG)) {
				if (!personNameEng.equals("")) {
					return personNameEng;
				} else {
					if (withNameImage) {
						return "";
					} else {
						return personNameChi;
					}
				}
			} else if (langCode.equals(LANG_CODE_CHI)) {
				if (withNameImage) {
					return "";
				} else {
					if (!personNameChi.equals("")) {
						return personNameChi;
					} else {
						return personNameEng;
					}
				}
			}
		}
		
		return personName;
	}
	
	private static String getOrgName(Org orgDTO, String langCode) {
		String orgName = "";
		
		if (orgDTO != null) {
			String orgNameEng = "";
			if (orgDTO.getOrgName() != null) {
				orgNameEng = orgDTO.getOrgName();
			}
			String orgNameChi = "";
			if (orgDTO.getOrgNameChin() != null) {
				orgNameChi = orgDTO.getOrgNameChin();
			}
			
			if (langCode.equals(LANG_CODE_ENG)) {
				if (!orgNameEng.equals("")) {
					return orgNameEng;
				} else {
					return orgNameChi;
				}
			} else if (langCode.equals(LANG_CODE_CHI)) {
				if (!orgNameChi.equals("")) {
					return orgNameChi;
				} else {
					return orgNameEng;
				}
			}
		}
		
		return orgName;
	}
	
	public static List<String> getAddrLine(Addr addr, String langCode) {
		List<String> addrLineEngs = null;
		List<String> addrLineChis = null;
		List<String> addrLineDefs = new ArrayList<String>();
		addrLineDefs.add("");
		addrLineDefs.add("");
		addrLineDefs.add("");
		
		if(addr != null){
		    if (addr.getAddrLine1() != null ||
		            addr.getAddrLine2() != null ||
		            addr.getAddrLine3() != null) {
		            addrLineEngs = new ArrayList<String>();
		            addrLineEngs.add(addr.getAddrLine1());
		            addrLineEngs.add(addr.getAddrLine2());
		            addrLineEngs.add(addr.getAddrLine3());
		        }
		        if (addr.getAddrLine1Chin() != null ||
		            addr.getAddrLine2Chin() != null ||
		            addr.getAddrLine3Chin() != null) {
		            addrLineChis = new ArrayList<String>();
		            addrLineChis.add(addr.getAddrLine1Chin());
		            addrLineChis.add(addr.getAddrLine2Chin());
		            addrLineChis.add(addr.getAddrLine3Chin());
		        }
		}
		
		if (langCode.equals(LANG_CODE_ENG)) {
			if (addrLineEngs != null) {
				return addrLineEngs;
			} else if (addrLineChis != null) {
				return addrLineChis;
			} else {
				return addrLineDefs;
			}
		} else if (langCode.equals(LANG_CODE_CHI)) {
			if (addrLineChis != null) {
				return addrLineChis;
			} else if (addrLineEngs != null) {
				return addrLineEngs;
			} else {
				return addrLineDefs;
			}
		}
		return addrLineDefs;
	}		
	
	public static Addr getPostalAddr(Partcp partcp) {	
		if (partcp != null && partcp.getAddrRole() != null) {
			for (AddrRole addrRole : partcp.getAddrRole()) {
				if (FLAG_VALID_CODE.equals(addrRole.getPostalServFlag())) {
					return addrRole.getAddr();
				}
			}
		}
		return null;
	}
	
	public static String getFormattedDate(Date date, String langCode) {
		String formattedDate = "";
		
		if (date != null) {
			if (langCode.equals(LANG_CODE_ENG)) {
				SimpleDateFormat sdf = new SimpleDateFormat("d MMMMM yyyy", Locale.US);
				formattedDate = sdf.format(date);
			} else if (langCode.equals(LANG_CODE_CHI)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日", Locale.US);
				formattedDate = sdf.format(date);
			}
		}
		
		return formattedDate;
	}
	
	public static String getFormattedTime(Date date, String langCode) {
		String formattedTime = "";
		
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
			String currentTime = sdf.format(date);
			
			if (langCode.equals("E")) {
				sdf = new SimpleDateFormat("h:mm", Locale.US);
				formattedTime = sdf.format(date);
				
				if (currentTime.contains("AM")) {
					formattedTime += " a.m.";
				} else if (currentTime.equals("12:00 PM")) {
					formattedTime += " noon";
				} else {
					formattedTime += " p.m.";
				}
			} else if (langCode.equals("C")) {
				if (currentTime.contains("00")) {
					sdf = new SimpleDateFormat("h時", Locale.US);
				} else { 
					sdf = new SimpleDateFormat("h時m分", Locale.US);
				}
				
				if (currentTime.contains("AM")) {
					formattedTime = "上午 "; 
				} else if (currentTime.equals("12:00 PM")) {
					formattedTime = "中午 ";
				} else {
					formattedTime = "上午 "; 
				}
				formattedTime += sdf.format(date);
			}
		}
		
		return formattedTime;
	}	

    /**
     * @param reportName
     * @return reportName + yyyyMMddHHmmss
     */
    public static String genReportFileName(String reportName) {
        String currentDateTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if (reportName != null) {
            return reportName + "_" + currentDateTimeStr;
        }
        return currentDateTimeStr;
    }
    
    public static String removeParagraph(String strIn) {
		String str = "";
		
		if (strIn != null) {
			str = strIn;
		}
		
		List<String> formatPatterns = new ArrayList<String>();
		formatPatterns.add(System.lineSeparator());
		formatPatterns.add("\r\n");
		formatPatterns.add("\n");
		formatPatterns.add("\t");
		
		for (String formatPattern : formatPatterns) {
			if (str.contains(formatPattern)) {
				str = str.replaceAll(formatPattern, " ");
			}
		}
		
		while (str.contains("  ")) {
			str = str.replaceAll("  ", " ");
		}
		while (str.contains("　　")) {
			str = str.replaceAll("　　", "　");
		}
		
		return str;
	}
		
	public static String isEmptyReplacedBy(String value, String replacedBy) {
		String formattedStr = replacedBy;
		
		if (value != null) {
			formattedStr = value;
		}
		
		return formattedStr;
	}
	
	public static byte[] convertImageToByte(String imagePath) throws IOException {
		Path path = Paths.get(imagePath);
				
		return Files.readAllBytes(path); 
	}
    
	public static String getEmptyOrValue(String value) {
		String formattedStr = "";
		
		if (value != null) {
			formattedStr = value.trim();
		}
		
		return formattedStr;
	}
}
