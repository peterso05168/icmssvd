package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class HkDistrictDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer hkDistrictId;
    private String hkDistrictName;
    private String hkDistrictChineseName;
    private String hkDistrictCode;
    private HkRegionDTO hkRegion;

    public Integer getHkDistrictId() {
        return hkDistrictId;
    }

    public void setHkDistrictId(Integer hkDistrictId) {
        this.hkDistrictId = hkDistrictId;
    }

    public String getHkDistrictName() {
        return hkDistrictName;
    }

    public void setHkDistrictName(String hkDistrictName) {
        this.hkDistrictName = hkDistrictName;
    }

    public String getHkDistrictChineseName() {
        return hkDistrictChineseName;
    }

    public void setHkDistrictChineseName(String hkDistrictChineseName) {
        this.hkDistrictChineseName = hkDistrictChineseName;
    }

    public String getHkDistrictCode() {
        return hkDistrictCode;
    }

    public void setHkDistrictCode(String hkDistrictCode) {
        this.hkDistrictCode = hkDistrictCode;
    }

    public HkRegionDTO getHkRegion() {
        return hkRegion;
    }

    public void setHkRegion(HkRegionDTO hkRegion) {
        this.hkRegion = hkRegion;
    }

    @Override
    public String toString() {
        return "HkDistrictDTO [hkDistrictId=" + hkDistrictId + ", hkDistrictName=" + hkDistrictName
                + ", hkDistrictChineseName=" + hkDistrictChineseName + ", hkDistrictCode="
                + hkDistrictCode + ", hkRegion=" + hkRegion + "]";
    }

}
