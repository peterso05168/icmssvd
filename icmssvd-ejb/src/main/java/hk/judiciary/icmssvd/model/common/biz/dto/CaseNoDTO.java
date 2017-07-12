package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

public class CaseNoDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private String comprisingCourt;
    private String caseType;
    private Integer caseSerialNo;
    private Integer caseYear;

    public CaseNoDTO() {
    }

    public CaseNoDTO(String comprisingCourt, String caseType, Integer caseSerialNo,
            Integer caseYear) {
        this.comprisingCourt = comprisingCourt;
        this.caseType = caseType;
        this.caseSerialNo = caseSerialNo;
        this.caseYear = caseYear;
    }

    public String getComprisingCourt() {
        return comprisingCourt;
    }

    public void setComprisingCourt(String comprisingCourt) {
        this.comprisingCourt = comprisingCourt;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Integer getCaseSerialNo() {
        return caseSerialNo;
    }

    public void setCaseSerialNo(Integer caseSerialNo) {
        this.caseSerialNo = caseSerialNo;
    }

    public Integer getCaseYear() {
        return caseYear;
    }

    public void setCaseYear(Integer caseYear) {
        this.caseYear = caseYear;
    }

    @Override
    public String toString() {
        return "CaseNoDTO [comprisingCourt=" + comprisingCourt + ", caseType=" + caseType
                + ", caseSerialNo=" + caseSerialNo + ", caseYear=" + caseYear + "]";
    }

}
