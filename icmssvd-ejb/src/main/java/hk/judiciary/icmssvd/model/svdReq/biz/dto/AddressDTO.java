package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HkDistrictDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HkRegionDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class AddressDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer addressId;
    private String englishAddress1;
    private String englishAddress2;
    private String englishAddress3;
    private String chineseAddress1;
    private String chineseAddress2;
    private String chineseAddress3;
    private HkDistrictDTO hkDistrict;
    private HkRegionDTO hkRegion;
    private boolean foreignAddressInd;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getEnglishAddress1() {
        return englishAddress1;
    }

    public void setEnglishAddress1(String englishAddress1) {
        this.englishAddress1 = englishAddress1;
    }

    public String getEnglishAddress2() {
        return englishAddress2;
    }

    public void setEnglishAddress2(String englishAddress2) {
        this.englishAddress2 = englishAddress2;
    }

    public String getEnglishAddress3() {
        return englishAddress3;
    }

    public void setEnglishAddress3(String englishAddress3) {
        this.englishAddress3 = englishAddress3;
    }

    public String getChineseAddress1() {
        return chineseAddress1;
    }

    public void setChineseAddress1(String chineseAddress1) {
        this.chineseAddress1 = chineseAddress1;
    }

    public String getChineseAddress2() {
        return chineseAddress2;
    }

    public void setChineseAddress2(String chineseAddress2) {
        this.chineseAddress2 = chineseAddress2;
    }

    public String getChineseAddress3() {
        return chineseAddress3;
    }

    public void setChineseAddress3(String chineseAddress3) {
        this.chineseAddress3 = chineseAddress3;
    }

    public HkDistrictDTO getHkDistrict() {
        return hkDistrict;
    }

    public void setHkDistrict(HkDistrictDTO hkDistrict) {
        this.hkDistrict = hkDistrict;
    }

    public HkRegionDTO getHkRegion() {
        return hkRegion;
    }

    public void setHkRegion(HkRegionDTO hkRegion) {
        this.hkRegion = hkRegion;
    }

    public boolean isForeignAddressInd() {
        return foreignAddressInd;
    }

    public void setForeignAddressInd(boolean foreignAddressInd) {
        this.foreignAddressInd = foreignAddressInd;
    }

    @Override
    public String toString() {
        return "AddressDTO [addressId=" + addressId + ", englishAddress1=" + englishAddress1
                + ", englishAddress2=" + englishAddress2 + ", englishAddress3=" + englishAddress3
                + ", chineseAddress1=" + chineseAddress1 + ", chineseAddress2=" + chineseAddress2
                + ", chineseAddress3=" + chineseAddress3 + ", hkDistrict=" + hkDistrict
                + ", hkRegion=" + hkRegion + ", foreignAddressInd=" + foreignAddressInd + "]";
    }

}
