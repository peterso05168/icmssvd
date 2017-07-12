package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 5748 $ $Date: 2017-03-24 17:54:18 +0800 (週五, 24 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class ComprisingCourtDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer comprisingCourtId;
    private String comprisingCourtCode;
    private String comprisingCourtName;
    private String comprisingCourtPrefix;
    private CourtLevelTypeDTO courtLevelType;
    private CourtVenueDTO courtVenue;

    public Integer getComprisingCourtId() {
        return comprisingCourtId;
    }

    public void setComprisingCourtId(Integer comprisingCourtId) {
        this.comprisingCourtId = comprisingCourtId;
    }

    public String getComprisingCourtCode() {
        return comprisingCourtCode;
    }

    public void setComprisingCourtCode(String comprisingCourtCode) {
        this.comprisingCourtCode = comprisingCourtCode;
    }

    public String getComprisingCourtName() {
        return comprisingCourtName;
    }

    public void setComprisingCourtName(String comprisingCourtName) {
        this.comprisingCourtName = comprisingCourtName;
    }

    public String getComprisingCourtPrefix() {
        return comprisingCourtPrefix;
    }

    public void setComprisingCourtPrefix(String comprisingCourtPrefix) {
        this.comprisingCourtPrefix = comprisingCourtPrefix;
    }

    public CourtLevelTypeDTO getCourtLevelType() {
        return courtLevelType;
    }

    public void setCourtLevelType(CourtLevelTypeDTO courtLevelType) {
        this.courtLevelType = courtLevelType;
    }

    public CourtVenueDTO getCourtVenue() {
        return courtVenue;
    }

    public void setCourtVenue(CourtVenueDTO courtVenue) {
        this.courtVenue = courtVenue;
    }

    @Override
    public String toString() {
        return "ComprisingCourtDTO [comprisingCourtId=" + comprisingCourtId
                + ", comprisingCourtCode=" + comprisingCourtCode + ", comprisingCourtName="
                + comprisingCourtName + ", comprisingCourtPrefix=" + comprisingCourtPrefix
                + ", courtLevelType=" + courtLevelType + ", courtVenue=" + courtVenue + "]";
    }

}
