package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1052 $ $Date: 2016-11-30 16:56:51 +0800 (週三, 30 十一月 2016) $
 * @author $Author: vicki.huang $
 */
public class ParticipantRoleTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer participantRoleTypeId;
    private String participantRoleTypeName;
    private String participantRoleTypeCode;
    private String applicantIndicator;
    private ParticipantRoleCategoryDTO participantRoleCategory;
    private CourtLevelTypeDTO courtLevelType;
    private CaseTypeDTO caseType;

    public Integer getParticipantRoleTypeId() {
        return participantRoleTypeId;
    }

    public void setParticipantRoleTypeId(Integer participantRoleTypeId) {
        this.participantRoleTypeId = participantRoleTypeId;
    }

    public String getParticipantRoleTypeName() {
        return participantRoleTypeName;
    }

    public void setParticipantRoleTypeName(String participantRoleTypeName) {
        this.participantRoleTypeName = participantRoleTypeName;
    }

    public String getParticipantRoleTypeCode() {
        return participantRoleTypeCode;
    }

    public void setParticipantRoleTypeCode(String participantRoleTypeCode) {
        this.participantRoleTypeCode = participantRoleTypeCode;
    }

    public String getApplicantIndicator() {
        return applicantIndicator;
    }

    public void setApplicantIndicator(String applicantIndicator) {
        this.applicantIndicator = applicantIndicator;
    }

    public ParticipantRoleCategoryDTO getParticipantRoleCategory() {
        return participantRoleCategory;
    }

    public void setParticipantRoleCategory(ParticipantRoleCategoryDTO participantRoleCategory) {
        this.participantRoleCategory = participantRoleCategory;
    }

    public CourtLevelTypeDTO getCourtLevelType() {
        return courtLevelType;
    }

    public void setCourtLevelType(CourtLevelTypeDTO courtLevelType) {
        this.courtLevelType = courtLevelType;
    }

    public CaseTypeDTO getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseTypeDTO caseType) {
        this.caseType = caseType;
    }

    @Override
    public String toString() {
        return "ParticipantRoleTypeDTO [participantRoleTypeId=" + participantRoleTypeId
                + ", participantRoleTypeName=" + participantRoleTypeName
                + ", participantRoleTypeCode=" + participantRoleTypeCode + ", applicantIndicator="
                + applicantIndicator + ", participantRoleCategory=" + participantRoleCategory
                + ", courtLevelType=" + courtLevelType + ", caseType=" + caseType + "]";
    }

}
