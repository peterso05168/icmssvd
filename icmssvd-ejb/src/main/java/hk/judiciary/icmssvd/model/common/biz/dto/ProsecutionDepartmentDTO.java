package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.AddressDTO;

/**
 * 
 * @version $Revision: 43 $ $Date: 2016-09-23 12:15:30 +0800 (Fri, 23 Sep 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class ProsecutionDepartmentDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer prosecutionDepartmentCodeId;
    private Integer seqNo;
    private String prosecutionDepartmentCode;
    private String prosecutionDepartmentName;
    private String prosecutionDepartmentChineseName;
    private String telephoneNo;
    private String faxNo;
    private String mobileNo;
    private AddressDTO address;
    private String englishDepartmentHeadTitle;
    private String chineseDepartmentHeadTitle;

    public Integer getProsecutionDepartmentCodeId() {
        return prosecutionDepartmentCodeId;
    }

    public void setProsecutionDepartmentCodeId(Integer prosecutionDepartmentCodeId) {
        this.prosecutionDepartmentCodeId = prosecutionDepartmentCodeId;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getProsecutionDepartmentCode() {
        return prosecutionDepartmentCode;
    }

    public void setProsecutionDepartmentCode(String prosecutionDepartmentCode) {
        this.prosecutionDepartmentCode = prosecutionDepartmentCode;
    }

    public String getProsecutionDepartmentName() {
        return prosecutionDepartmentName;
    }

    public void setProsecutionDepartmentName(String prosecutionDepartmentName) {
        this.prosecutionDepartmentName = prosecutionDepartmentName;
    }

    public String getProsecutionDepartmentChineseName() {
        return prosecutionDepartmentChineseName;
    }

    public void setProsecutionDepartmentChineseName(String prosecutionDepartmentChineseName) {
        this.prosecutionDepartmentChineseName = prosecutionDepartmentChineseName;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getEnglishDepartmentHeadTitle() {
        return englishDepartmentHeadTitle;
    }

    public void setEnglishDepartmentHeadTitle(String englishDepartmentHeadTitle) {
        this.englishDepartmentHeadTitle = englishDepartmentHeadTitle;
    }

    public String getChineseDepartmentHeadTitle() {
        return chineseDepartmentHeadTitle;
    }

    public void setChineseDepartmentHeadTitle(String chineseDepartmentHeadTitle) {
        this.chineseDepartmentHeadTitle = chineseDepartmentHeadTitle;
    }

    @Override
    public String toString() {
        return "ProsecutionDepartmentDTO [prosecutionDepartmentCodeId="
                + prosecutionDepartmentCodeId + ", seqNo=" + seqNo + ", prosecutionDepartmentCode="
                + prosecutionDepartmentCode + ", prosecutionDepartmentName="
                + prosecutionDepartmentName + ", prosecutionDepartmentChineseName="
                + prosecutionDepartmentChineseName + ", telephoneNo=" + telephoneNo + ", faxNo="
                + faxNo + ", mobileNo=" + mobileNo + ", address=" + address
                + ", englishDepartmentHeadTitle=" + englishDepartmentHeadTitle
                + ", chineseDepartmentHeadTitle=" + chineseDepartmentHeadTitle + "]";
    }

}
