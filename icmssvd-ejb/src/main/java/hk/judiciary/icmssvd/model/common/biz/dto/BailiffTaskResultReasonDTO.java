package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 3390 $ $Date: 2017-01-17 10:30:43 +0800 (週二, 17 一月 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffTaskResultReasonDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer bailiffTaskResultReasonId;
    private String bailiffTaskResultReasonName;

    public Integer getBailiffTaskResultReasonId() {
        return bailiffTaskResultReasonId;
    }

    public void setBailiffTaskResultReasonId(Integer bailiffTaskResultReasonId) {
        this.bailiffTaskResultReasonId = bailiffTaskResultReasonId;
    }

    public String getBailiffTaskResultReasonName() {
        return bailiffTaskResultReasonName;
    }

    public void setBailiffTaskResultReasonName(String bailiffTaskResultReasonName) {
        this.bailiffTaskResultReasonName = bailiffTaskResultReasonName;
    }

    @Override
    public String toString() {
        return "BailiffTaskResultReasonDTO [bailiffTaskResultReasonId=" + bailiffTaskResultReasonId
                + ", bailiffTaskResultReasonName=" + bailiffTaskResultReasonName + "]";
    }

}
