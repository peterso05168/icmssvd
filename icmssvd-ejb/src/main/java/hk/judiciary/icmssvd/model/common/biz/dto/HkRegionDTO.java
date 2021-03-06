package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class HkRegionDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer hkRegionId;
    private String hkRegionName;
    private String hkRegionChineseName;
    private String hkRegionCode;

    public Integer getHkRegionId() {
        return hkRegionId;
    }

    public void setHkRegionId(Integer hkRegionId) {
        this.hkRegionId = hkRegionId;
    }

    public String getHkRegionName() {
        return hkRegionName;
    }

    public void setHkRegionName(String hkRegionName) {
        this.hkRegionName = hkRegionName;
    }

    public String getHkRegionChineseName() {
        return hkRegionChineseName;
    }

    public void setHkRegionChineseName(String hkRegionChineseName) {
        this.hkRegionChineseName = hkRegionChineseName;
    }

    public String getHkRegionCode() {
        return hkRegionCode;
    }

    public void setHkRegionCode(String hkRegionCode) {
        this.hkRegionCode = hkRegionCode;
    }

    @Override
    public String toString() {
        return "HkRegionDTO [hkRegionId=" + hkRegionId + ", hkRegionName=" + hkRegionName
                + ", hkRegionChineseName=" + hkRegionChineseName + ", hkRegionCode=" + hkRegionCode
                + "]";
    }

}
