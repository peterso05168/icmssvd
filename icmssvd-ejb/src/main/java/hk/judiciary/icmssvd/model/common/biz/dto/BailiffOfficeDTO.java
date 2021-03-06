package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class BailiffOfficeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer bailiffOfficeId;
    private String bailiffOfficeName;
    private String bailiffOfficeCode;
    private String bailiffOfficeGroup;

    public Integer getBailiffOfficeId() {
        return bailiffOfficeId;
    }

    public void setBailiffOfficeId(Integer bailiffOfficeId) {
        this.bailiffOfficeId = bailiffOfficeId;
    }

    public String getBailiffOfficeName() {
        return bailiffOfficeName;
    }

    public void setBailiffOfficeName(String bailiffOfficeName) {
        this.bailiffOfficeName = bailiffOfficeName;
    }

    public String getBailiffOfficeCode() {
        return bailiffOfficeCode;
    }

    public void setBailiffOfficeCode(String bailiffOfficeCode) {
        this.bailiffOfficeCode = bailiffOfficeCode;
    }

    public String getBailiffOfficeGroup() {
        return bailiffOfficeGroup;
    }

    public void setBailiffOfficeGroup(String bailiffOfficeGroup) {
        this.bailiffOfficeGroup = bailiffOfficeGroup;
    }

    @Override
    public String toString() {
        return "BailiffOfficeDTO [bailiffOfficeId=" + bailiffOfficeId + ", bailiffOfficeName="
                + bailiffOfficeName + ", bailiffOfficeCode=" + bailiffOfficeCode
                + ", bailiffOfficeGroup=" + bailiffOfficeGroup + "]";
    }

}
