package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.List;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ParticipantRoleTypeDTO;

/**
 * 
 * @version $Revision: 7357 $ $Date: 2017-06-06 18:35:03 +0800 (週二, 06 六月 2017) $
 * @author $Author: vicki.huang $
 */
public class PartyDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer participantRoleId;
    private Integer participantId;
    private Integer partyCategoryId;
    private ParticipantRoleTypeDTO participantRoleType;
    private Integer respondentSeqNo;
    private Integer respondentSubSeqNo;
    private String englishSurname;
    private String englishGivenName;
    private String chineseSurname;
    private String chineseGivenName;
    private List<AddressRoleDTO> addressRoles;

    public Integer getParticipantRoleId() {
        return participantRoleId;
    }

    public void setParticipantRoleId(Integer participantRoleId) {
        this.participantRoleId = participantRoleId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getPartyCategoryId() {
        return partyCategoryId;
    }

    public void setPartyCategoryId(Integer partyCategoryId) {
        this.partyCategoryId = partyCategoryId;
    }

    public ParticipantRoleTypeDTO getParticipantRoleType() {
        return participantRoleType;
    }

    public void setParticipantRoleType(ParticipantRoleTypeDTO participantRoleType) {
        this.participantRoleType = participantRoleType;
    }

    public Integer getRespondentSeqNo() {
        return respondentSeqNo;
    }

    public void setRespondentSeqNo(Integer respondentSeqNo) {
        this.respondentSeqNo = respondentSeqNo;
    }

    public Integer getRespondentSubSeqNo() {
        return respondentSubSeqNo;
    }

    public void setRespondentSubSeqNo(Integer respondentSubSeqNo) {
        this.respondentSubSeqNo = respondentSubSeqNo;
    }

    public String getEnglishSurname() {
        return englishSurname;
    }

    public void setEnglishSurname(String englishSurname) {
        this.englishSurname = englishSurname;
    }

    public String getEnglishGivenName() {
        return englishGivenName;
    }

    public void setEnglishGivenName(String englishGivenName) {
        this.englishGivenName = englishGivenName;
    }

    public String getChineseSurname() {
        return chineseSurname;
    }

    public void setChineseSurname(String chineseSurname) {
        this.chineseSurname = chineseSurname;
    }

    public String getChineseGivenName() {
        return chineseGivenName;
    }

    public void setChineseGivenName(String chineseGivenName) {
        this.chineseGivenName = chineseGivenName;
    }

    public List<AddressRoleDTO> getAddressRoles() {
        return addressRoles;
    }

    public void setAddressRoles(List<AddressRoleDTO> addressRoles) {
        this.addressRoles = addressRoles;
    }

    @Override
    public String toString() {
        return "PartyDTO [participantRoleId=" + participantRoleId + ", participantId="
                + participantId + ", partyCategoryId=" + partyCategoryId + ", participantRoleType="
                + participantRoleType + ", respondentSeqNo=" + respondentSeqNo
                + ", respondentSubSeqNo=" + respondentSubSeqNo + ", englishSurname="
                + englishSurname + ", englishGivenName=" + englishGivenName + ", chineseSurname="
                + chineseSurname + ", chineseGivenName=" + chineseGivenName + ", addressRoles="
                + addressRoles + "]";
    }

}
