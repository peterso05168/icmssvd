package hk.judiciary.icmssvd.model.courtCase.biz.dto;

import java.io.Serializable;

public class GenericCodeTableDTO extends CommonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer seqNo;
	private String code;
	private String descEng;
	private String descChi;
	private String descSimp;
	private CourtLvlTypeDTO courtLvlType;
	private CourtVenueDTO courtVenue;
	private String option1;
	private String option1Label;
	private String option2;
	private String option2Label;
	private String option3;
	private String option3Label;
	private String option4;
	private String option4Label;
	private Boolean seqNoEnable = false;
	private Boolean codeEnable = false;
	private Boolean descEngEnable = false;
	private Boolean descChiEnable = false;
	private Boolean descSimpEnable = false;
	private Boolean courtLvlTypeEnable = false;
	private Boolean courtVenueEnable = false;
	private Boolean option1Enable = false;
	private Boolean option2Enable = false;
	private Boolean option3Enable = false;
	private Boolean option4Enable = false;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescEng() {
		return descEng;
	}
	public void setDescEng(String descEng) {
		this.descEng = descEng;
	}
	public String getDescChi() {
		return descChi;
	}
	public void setDescChi(String descChi) {
		this.descChi = descChi;
	}
	public String getDescSimp() {
		return descSimp;
	}
	public void setDescSimp(String descSimp) {
		this.descSimp = descSimp;
	}
	public Boolean getSeqNoEnable() {
		return seqNoEnable;
	}
	public void setSeqNoEnable(Boolean seqNoEnable) {
		this.seqNoEnable = seqNoEnable;
	}
	public Boolean getCodeEnable() {
		return codeEnable;
	}
	public void setCodeEnable(Boolean codeEnable) {
		this.codeEnable = codeEnable;
	}
	public Boolean getDescEngEnable() {
		return descEngEnable;
	}
	public void setDescEngEnable(Boolean descEngEnable) {
		this.descEngEnable = descEngEnable;
	}
	public Boolean getDescChiEnable() {
		return descChiEnable;
	}
	public void setDescChiEnable(Boolean descChiEnable) {
		this.descChiEnable = descChiEnable;
	}
	public Boolean getDescSimpEnable() {
		return descSimpEnable;
	}
	public void setDescSimpEnable(Boolean descSimpEnable) {
		this.descSimpEnable = descSimpEnable;
	}
	public CourtLvlTypeDTO getCourtLvlType() {
		return courtLvlType;
	}
	public void setCourtLvlType(CourtLvlTypeDTO courtLvlType) {
		this.courtLvlType = courtLvlType;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public Boolean getCourtLvlTypeEnable() {
		return courtLvlTypeEnable;
	}
	public void setCourtLvlTypeEnable(Boolean courtLvlTypeEnable) {
		this.courtLvlTypeEnable = courtLvlTypeEnable;
	}
	public Boolean getOption1Enable() {
		return option1Enable;
	}
	public void setOption1Enable(Boolean option1Enable) {
		this.option1Enable = option1Enable;
	}
	public String getOption1Label() {
		return option1Label;
	}
	public void setOption1Label(String option1Label) {
		this.option1Label = option1Label;
	}
	public CourtVenueDTO getCourtVenue() {
		return courtVenue;
	}
	public void setCourtVenue(CourtVenueDTO courtVenue) {
		this.courtVenue = courtVenue;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption2Label() {
		return option2Label;
	}
	public void setOption2Label(String option2Label) {
		this.option2Label = option2Label;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption3Label() {
		return option3Label;
	}
	public void setOption3Label(String option3Label) {
		this.option3Label = option3Label;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getOption4Label() {
		return option4Label;
	}
	public void setOption4Label(String option4Label) {
		this.option4Label = option4Label;
	}
	public Boolean getCourtVenueEnable() {
		return courtVenueEnable;
	}
	public void setCourtVenueEnable(Boolean courtVenueEnable) {
		this.courtVenueEnable = courtVenueEnable;
	}
	public Boolean getOption2Enable() {
		return option2Enable;
	}
	public void setOption2Enable(Boolean option2Enable) {
		this.option2Enable = option2Enable;
	}
	public Boolean getOption3Enable() {
		return option3Enable;
	}
	public void setOption3Enable(Boolean option3Enable) {
		this.option3Enable = option3Enable;
	}
	public Boolean getOption4Enable() {
		return option4Enable;
	}
	public void setOption4Enable(Boolean option4Enable) {
		this.option4Enable = option4Enable;
	}
	
	
}
