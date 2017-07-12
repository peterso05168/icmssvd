package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 1251 $ $Date: 2016-12-06 11:28:35 +0800 (週二, 06 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class ParticipantRoleCategoryDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer participantRoleCategoryId;
    private String participantRoleCategoryName;
    private String participantRoleCategoryCode;

    public Integer getParticipantRoleCategoryId() {
        return participantRoleCategoryId;
    }

    public void setParticipantRoleCategoryId(Integer participantRoleCategoryId) {
        this.participantRoleCategoryId = participantRoleCategoryId;
    }

    public String getParticipantRoleCategoryName() {
        return participantRoleCategoryName;
    }

    public void setParticipantRoleCategoryName(String participantRoleCategoryName) {
        this.participantRoleCategoryName = participantRoleCategoryName;
    }

    public String getParticipantRoleCategoryCode() {
        return participantRoleCategoryCode;
    }

    public void setParticipantRoleCategoryCode(String participantRoleCategoryCode) {
        this.participantRoleCategoryCode = participantRoleCategoryCode;
    }

    @Override
    public String toString() {
        return "ParticipantRoleCategoryDTO [participantRoleCategoryId=" + participantRoleCategoryId
                + ", participantRoleCategoryName=" + participantRoleCategoryName
                + ", participantRoleCategoryCode=" + participantRoleCategoryCode + "]";
    }

}
