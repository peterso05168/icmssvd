package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class SpecialRequestTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer specialRequestTypeId;
    private String specialRequestTypeName;

    public Integer getSpecialRequestTypeId() {
        return specialRequestTypeId;
    }

    public void setSpecialRequestTypeId(Integer specialRequestTypeId) {
        this.specialRequestTypeId = specialRequestTypeId;
    }

    public String getSpecialRequestTypeName() {
        return specialRequestTypeName;
    }

    public void setSpecialRequestTypeName(String specialRequestTypeName) {
        this.specialRequestTypeName = specialRequestTypeName;
    }

    @Override
    public String toString() {
        return "SpecialRequestTypeDTO [specialRequestTypeId=" + specialRequestTypeId
                + ", specialRequestTypeName=" + specialRequestTypeName + "]";
    }

}
