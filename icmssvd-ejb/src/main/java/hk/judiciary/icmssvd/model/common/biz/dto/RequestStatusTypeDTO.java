package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1659 $ $Date: 2016-12-13 19:37:57 +0800 (週二, 13 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class RequestStatusTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer requestStatusTypeId;
    private String requestStatusTypeName;
    private String requestStatusTypeCode;

    public Integer getRequestStatusTypeId() {
        return requestStatusTypeId;
    }

    public void setRequestStatusTypeId(Integer requestStatusTypeId) {
        this.requestStatusTypeId = requestStatusTypeId;
    }

    public String getRequestStatusTypeName() {
        return requestStatusTypeName;
    }

    public void setRequestStatusTypeName(String requestStatusTypeName) {
        this.requestStatusTypeName = requestStatusTypeName;
    }

    public String getRequestStatusTypeCode() {
        return requestStatusTypeCode;
    }

    public void setRequestStatusTypeCode(String requestStatusTypeCode) {
        this.requestStatusTypeCode = requestStatusTypeCode;
    }

    @Override
    public String toString() {
        return "RequestStatusTypeDTO [requestStatusTypeId=" + requestStatusTypeId
                + ", requestStatusTypeName=" + requestStatusTypeName + ", requestStatusTypeCode="
                + requestStatusTypeCode + "]";
    }

}
