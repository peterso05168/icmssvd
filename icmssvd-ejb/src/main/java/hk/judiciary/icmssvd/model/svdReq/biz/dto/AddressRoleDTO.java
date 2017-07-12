package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.AddressRoleTypeDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class AddressRoleDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer addressRoleId;
    private AddressDTO address;
    private AddressRoleTypeDTO addressRoleType;
    private Integer addressSequenceNo;
    private boolean postalServiceInd;
    private boolean personalServiceInd;
    private boolean executionServiceInd;

    public Integer getAddressRoleId() {
        return addressRoleId;
    }

    public void setAddressRoleId(Integer addressRoleId) {
        this.addressRoleId = addressRoleId;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public AddressRoleTypeDTO getAddressRoleType() {
        return addressRoleType;
    }

    public void setAddressRoleType(AddressRoleTypeDTO addressRoleType) {
        this.addressRoleType = addressRoleType;
    }

    public Integer getAddressSequenceNo() {
        return addressSequenceNo;
    }

    public void setAddressSequenceNo(Integer addressSequenceNo) {
        this.addressSequenceNo = addressSequenceNo;
    }

    public boolean isPostalServiceInd() {
        return postalServiceInd;
    }

    public void setPostalServiceInd(boolean postalServiceInd) {
        this.postalServiceInd = postalServiceInd;
    }

    public boolean isPersonalServiceInd() {
        return personalServiceInd;
    }

    public void setPersonalServiceInd(boolean personalServiceInd) {
        this.personalServiceInd = personalServiceInd;
    }

    public boolean isExecutionServiceInd() {
        return executionServiceInd;
    }

    public void setExecutionServiceInd(boolean executionServiceInd) {
        this.executionServiceInd = executionServiceInd;
    }

    @Override
    public String toString() {
        return "AddressRoleDTO [addressRoleId=" + addressRoleId + ", address=" + address
                + ", addressRoleType=" + addressRoleType + ", addressSequenceNo="
                + addressSequenceNo + ", postalServiceInd=" + postalServiceInd
                + ", personalServiceInd=" + personalServiceInd + ", executionServiceInd="
                + executionServiceInd + "]";
    }

}
