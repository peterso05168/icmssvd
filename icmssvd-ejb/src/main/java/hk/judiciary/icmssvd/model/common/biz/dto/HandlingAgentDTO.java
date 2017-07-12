package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class HandlingAgentDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer handlingAgentId;
    private String handlingAgentCode;
    private String handlingAgentName;

    public Integer getHandlingAgentId() {
        return handlingAgentId;
    }

    public void setHandlingAgentId(Integer handlingAgentId) {
        this.handlingAgentId = handlingAgentId;
    }

    public String getHandlingAgentCode() {
        return handlingAgentCode;
    }

    public void setHandlingAgentCode(String handlingAgentCode) {
        this.handlingAgentCode = handlingAgentCode;
    }

    public String getHandlingAgentName() {
        return handlingAgentName;
    }

    public void setHandlingAgentName(String handlingAgentName) {
        this.handlingAgentName = handlingAgentName;
    }

    @Override
    public String toString() {
        return "HandlingAgentDTO [handlingAgentId=" + handlingAgentId + ", handlingAgentCode="
                + handlingAgentCode + ", handlingAgentName=" + handlingAgentName + "]";
    }

}
