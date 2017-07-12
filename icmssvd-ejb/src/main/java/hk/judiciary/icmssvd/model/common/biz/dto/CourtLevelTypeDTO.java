package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class CourtLevelTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer courtLevelTypeId;
    private String courtLevelTypeCode;
    private String courtLevelTypeName;

    public Integer getCourtLevelTypeId() {
        return courtLevelTypeId;
    }

    public void setCourtLevelTypeId(Integer courtLevelTypeId) {
        this.courtLevelTypeId = courtLevelTypeId;
    }

    public String getCourtLevelTypeCode() {
        return courtLevelTypeCode;
    }

    public void setCourtLevelTypeCode(String courtLevelTypeCode) {
        this.courtLevelTypeCode = courtLevelTypeCode;
    }

    public String getCourtLevelTypeName() {
        return courtLevelTypeName;
    }

    public void setCourtLevelTypeName(String courtLevelTypeName) {
        this.courtLevelTypeName = courtLevelTypeName;
    }

    @Override
    public String toString() {
        return "CourtLevelTypeDTO [courtLevelTypeId=" + courtLevelTypeId + ", courtLevelTypeCode="
                + courtLevelTypeCode + ", courtLevelTypeName=" + courtLevelTypeName + "]";
    }

}
