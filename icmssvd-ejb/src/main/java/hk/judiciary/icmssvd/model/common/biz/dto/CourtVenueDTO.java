package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 43 $ $Date: 2016-09-23 12:15:30 +0800 (Fri, 23 Sep 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class CourtVenueDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer courtVenueId;
    private String courtVenueCode;
    private String courtVenueName;
    private String courtVenueChineseName;
    private String courtVenueDescription;
    private String courtVenueChineseDescription;

    public Integer getCourtVenueId() {
        return courtVenueId;
    }

    public void setCourtVenueId(Integer courtVenueId) {
        this.courtVenueId = courtVenueId;
    }

    public String getCourtVenueCode() {
        return courtVenueCode;
    }

    public void setCourtVenueCode(String courtVenueCode) {
        this.courtVenueCode = courtVenueCode;
    }

    public String getCourtVenueName() {
        return courtVenueName;
    }

    public void setCourtVenueName(String courtVenueName) {
        this.courtVenueName = courtVenueName;
    }

    public String getCourtVenueChineseName() {
        return courtVenueChineseName;
    }

    public void setCourtVenueChineseName(String courtVenueChineseName) {
        this.courtVenueChineseName = courtVenueChineseName;
    }

    public String getCourtVenueDescription() {
        return courtVenueDescription;
    }

    public void setCourtVenueDescription(String courtVenueDescription) {
        this.courtVenueDescription = courtVenueDescription;
    }

    public String getCourtVenueChineseDescription() {
        return courtVenueChineseDescription;
    }

    public void setCourtVenueChineseDescription(String courtVenueChineseDescription) {
        this.courtVenueChineseDescription = courtVenueChineseDescription;
    }

    @Override
    public String toString() {
        return "CourtVenueDTO [courtVenueId=" + courtVenueId + ", courtVenueCode=" + courtVenueCode
                + ", courtVenueName=" + courtVenueName + ", courtVenueChineseName="
                + courtVenueChineseName + ", courtVenueDescription=" + courtVenueDescription
                + ", courtVenueChineseDescription=" + courtVenueChineseDescription + "]";
    }

}
