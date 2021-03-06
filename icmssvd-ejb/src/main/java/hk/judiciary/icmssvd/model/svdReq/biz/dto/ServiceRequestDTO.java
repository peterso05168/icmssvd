package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.util.Date;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ParticipantRoleTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.PostOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class ServiceRequestDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer serviceRequestId;
    private Integer requestId;
    private boolean requireAffirmationInd;
    private Date serviceBeforeDate;
    private ParticipantRoleTypeDTO participantRoleType;
    private String englishRecipientSurname;
    private String englishRecipientGivenName;
    private String chineseRecipientSurname;
    private String chineseRecipientGivenName;
    private String deliveryInstruction;
    private String registeredMailBarcode;
    private ServiceModeTypeDTO serviceModeType;
    private PostOfficeDTO postOffice;

    public Integer getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(Integer serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public boolean isRequireAffirmationInd() {
        return requireAffirmationInd;
    }

    public void setRequireAffirmationInd(boolean requireAffirmationInd) {
        this.requireAffirmationInd = requireAffirmationInd;
    }

    public Date getServiceBeforeDate() {
        return serviceBeforeDate;
    }

    public void setServiceBeforeDate(Date serviceBeforeDate) {
        this.serviceBeforeDate = serviceBeforeDate;
    }

    public ParticipantRoleTypeDTO getParticipantRoleType() {
        return participantRoleType;
    }

    public void setParticipantRoleType(ParticipantRoleTypeDTO participantRoleType) {
        this.participantRoleType = participantRoleType;
    }

    public String getEnglishRecipientSurname() {
        return englishRecipientSurname;
    }

    public void setEnglishRecipientSurname(String englishRecipientSurname) {
        this.englishRecipientSurname = englishRecipientSurname;
    }

    public String getEnglishRecipientGivenName() {
        return englishRecipientGivenName;
    }

    public void setEnglishRecipientGivenName(String englishRecipientGivenName) {
        this.englishRecipientGivenName = englishRecipientGivenName;
    }

    public String getChineseRecipientSurname() {
        return chineseRecipientSurname;
    }

    public void setChineseRecipientSurname(String chineseRecipientSurname) {
        this.chineseRecipientSurname = chineseRecipientSurname;
    }

    public String getChineseRecipientGivenName() {
        return chineseRecipientGivenName;
    }

    public void setChineseRecipientGivenName(String chineseRecipientGivenName) {
        this.chineseRecipientGivenName = chineseRecipientGivenName;
    }

    public String getDeliveryInstruction() {
        return deliveryInstruction;
    }

    public void setDeliveryInstruction(String deliveryInstruction) {
        this.deliveryInstruction = deliveryInstruction;
    }

    public String getRegisteredMailBarcode() {
        return registeredMailBarcode;
    }

    public void setRegisteredMailBarcode(String registeredMailBarcode) {
        this.registeredMailBarcode = registeredMailBarcode;
    }

    public ServiceModeTypeDTO getServiceModeType() {
        return serviceModeType;
    }

    public void setServiceModeType(ServiceModeTypeDTO serviceModeType) {
        this.serviceModeType = serviceModeType;
    }

    public PostOfficeDTO getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(PostOfficeDTO postOffice) {
        this.postOffice = postOffice;
    }

    @Override
    public String toString() {
        return "ServiceRequestDTO [serviceRequestId=" + serviceRequestId + ", requestId="
                + requestId + ", requireAffirmationInd=" + requireAffirmationInd
                + ", serviceBeforeDate=" + serviceBeforeDate + ", participantRoleType="
                + participantRoleType + ", englishRecipientSurname=" + englishRecipientSurname
                + ", englishRecipientGivenName=" + englishRecipientGivenName
                + ", chineseRecipientSurname=" + chineseRecipientSurname
                + ", chineseRecipientGivenName=" + chineseRecipientGivenName
                + ", deliveryInstruction=" + deliveryInstruction + ", registeredMailBarcode="
                + registeredMailBarcode + ", serviceModeType=" + serviceModeType + ", postOffice="
                + postOffice + "]";
    }

}
