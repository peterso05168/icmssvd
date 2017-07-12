package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2780 $ $Date: 2017-01-05 11:15:08 +0800 (週四, 05 一月 2017) $
 * @author $Author: vicki.huang $
 */
public class ServiceModeTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer serviceModeTypeId;
    private String serviceModeTypeCode;
    private String serviceModeTypeName;

    public Integer getServiceModeTypeId() {
        return serviceModeTypeId;
    }

    public void setServiceModeTypeId(Integer serviceModeTypeId) {
        this.serviceModeTypeId = serviceModeTypeId;
    }

    public String getServiceModeTypeCode() {
        return serviceModeTypeCode;
    }

    public void setServiceModeTypeCode(String serviceModeTypeCode) {
        this.serviceModeTypeCode = serviceModeTypeCode;
    }

    public String getServiceModeTypeName() {
        return serviceModeTypeName;
    }

    public void setServiceModeTypeName(String serviceModeTypeName) {
        this.serviceModeTypeName = serviceModeTypeName;
    }

    @Override
    public String toString() {
        return "ServiceModeTypeDTO [serviceModeTypeId=" + serviceModeTypeId
                + ", serviceModeTypeCode=" + serviceModeTypeCode + ", serviceModeTypeName="
                + serviceModeTypeName + "]";
    }

}
