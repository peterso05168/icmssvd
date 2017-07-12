package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.SpecialRequestTypeDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class SpecialRequestDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer specialRequestId;
    private Integer requestId;
    private SpecialRequestTypeDTO specialRequestType;

    public Integer getSpecialRequestId() {
        return specialRequestId;
    }

    public void setSpecialRequestId(Integer specialRequestId) {
        this.specialRequestId = specialRequestId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public SpecialRequestTypeDTO getSpecialRequestType() {
        return specialRequestType;
    }

    public void setSpecialRequestType(SpecialRequestTypeDTO specialRequestType) {
        this.specialRequestType = specialRequestType;
    }

    @Override
    public String toString() {
        return "SpecialRequestDTO [specialRequestId=" + specialRequestId + ", requestId="
                + requestId + ", specialRequestType=" + specialRequestType + "]";
    }

}
