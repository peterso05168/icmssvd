package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class FunctionDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private String courtLevelTypeCode;

    public String getCourtLevelTypeCode() {
        return courtLevelTypeCode;
    }

    public void setCourtLevelTypeCode(String courtLevelTypeCode) {
        this.courtLevelTypeCode = courtLevelTypeCode;
    }

    @Override
    public String toString() {
        return "FunctionDTO [courtLevelTypeCode=" + courtLevelTypeCode + "]";
    }

}
