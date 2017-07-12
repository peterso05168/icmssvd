package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (Wed, 30 Nov 2016) $
 * @author $Author: vicki.huang $
 */
public class AddressRoleTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer addressRoleTypeId;
    private String addressRoleTypeCode;
    private String addressRoleTypeName;

    public Integer getAddressRoleTypeId() {
        return addressRoleTypeId;
    }

    public void setAddressRoleTypeId(Integer addressRoleTypeId) {
        this.addressRoleTypeId = addressRoleTypeId;
    }

    public String getAddressRoleTypeCode() {
        return addressRoleTypeCode;
    }

    public void setAddressRoleTypeCode(String addressRoleTypeCode) {
        this.addressRoleTypeCode = addressRoleTypeCode;
    }

    public String getAddressRoleTypeName() {
        return addressRoleTypeName;
    }

    public void setAddressRoleTypeName(String addressRoleTypeName) {
        this.addressRoleTypeName = addressRoleTypeName;
    }

    @Override
    public String toString() {
        return "AddressRoleDTO [addressRoleTypeId=" + addressRoleTypeId + ", addressRoleTypeCode="
                + addressRoleTypeCode + ", addressRoleTypeName=" + addressRoleTypeName + "]";
    }

}
