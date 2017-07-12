package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 3390 $ $Date: 2017-01-17 10:30:43 +0800 (週二, 17 一月 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffTaskResultStatusDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer bailiffTaskResultStatusId;
    private String bailiffTaskResultStatusName;

    public Integer getBailiffTaskResultStatusId() {
        return bailiffTaskResultStatusId;
    }

    public void setBailiffTaskResultStatusId(Integer bailiffTaskResultStatusId) {
        this.bailiffTaskResultStatusId = bailiffTaskResultStatusId;
    }

    public String getBailiffTaskResultStatusName() {
        return bailiffTaskResultStatusName;
    }

    public void setBailiffTaskResultStatusName(String bailiffTaskResultStatusName) {
        this.bailiffTaskResultStatusName = bailiffTaskResultStatusName;
    }

    @Override
    public String toString() {
        return "BailiffTaskResultStatusDTO [bailiffTaskResultStatusId=" + bailiffTaskResultStatusId
                + ", bailiffTaskResultStatusName=" + bailiffTaskResultStatusName + "]";
    }

}
