package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class PostOfficeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer postOfficeId;
    private String postOfficeCode;
    private String postOfficeName;

    public Integer getPostOfficeId() {
        return postOfficeId;
    }

    public void setPostOfficeId(Integer postOfficeId) {
        this.postOfficeId = postOfficeId;
    }

    public String getPostOfficeCode() {
        return postOfficeCode;
    }

    public void setPostOfficeCode(String postOfficeCode) {
        this.postOfficeCode = postOfficeCode;
    }

    public String getPostOfficeName() {
        return postOfficeName;
    }

    public void setPostOfficeName(String postOfficeName) {
        this.postOfficeName = postOfficeName;
    }

    @Override
    public String toString() {
        return "PostOfficeDTO [postOfficeId=" + postOfficeId + ", postOfficeCode=" + postOfficeCode
                + ", postOfficeName=" + postOfficeName + "]";
    }

}
