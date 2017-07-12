package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class CaseTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer caseTypeId;
    private String caseTypeCode;
    private String caseTypeName;
    private CourtLevelTypeDTO courtLevelType;

    public Integer getCaseTypeId() {
        return caseTypeId;
    }

    public void setCaseTypeId(Integer caseTypeId) {
        this.caseTypeId = caseTypeId;
    }

    public String getCaseTypeCode() {
        return caseTypeCode;
    }

    public void setCaseTypeCode(String caseTypeCode) {
        this.caseTypeCode = caseTypeCode;
    }

    public String getCaseTypeName() {
        return caseTypeName;
    }

    public void setCaseTypeName(String caseTypeName) {
        this.caseTypeName = caseTypeName;
    }

    public CourtLevelTypeDTO getCourtLevelType() {
        return courtLevelType;
    }

    public void setCourtLevelType(CourtLevelTypeDTO courtLevelType) {
        this.courtLevelType = courtLevelType;
    }

    @Override
    public String toString() {
        return "CaseTypeDTO [caseTypeId=" + caseTypeId + ", caseTypeCode=" + caseTypeCode
                + ", caseTypeName=" + caseTypeName + ", courtLevelType=" + courtLevelType + "]";
    }

}
