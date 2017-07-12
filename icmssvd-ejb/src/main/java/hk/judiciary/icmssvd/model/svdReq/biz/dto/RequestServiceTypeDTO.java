package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class RequestServiceTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer requestServiceType;
    private String requestServiceTypeName;

    public Integer getRequestServiceType() {
        return requestServiceType;
    }

    public void setRequestServiceType(Integer requestServiceType) {
        this.requestServiceType = requestServiceType;
    }

    public String getRequestServiceTypeName() {
        return requestServiceTypeName;
    }

    public void setRequestServiceTypeName(String requestServiceTypeName) {
        this.requestServiceTypeName = requestServiceTypeName;
    }

    @Override
    public String toString() {
        return "RequestServiceTypeDTO [requestServiceType=" + requestServiceType
                + ", requestServiceTypeName=" + requestServiceTypeName + "]";
    }

}
