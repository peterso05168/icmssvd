package hk.judiciary.icmssvd.view.svdReq;

import java.util.ArrayList;
import java.util.List;

import org.granite.tide.annotations.TideEnabled;

import hk.judiciary.fmk.model.cfs.biz.dto.FileDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultReasonDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultStatusDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ComprisingCourtDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtLevelTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtRoomChambersDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentFileDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DrnDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.FpApplicationNatureTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HandlingAgentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HkDistrictDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HkRegionDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.IntegerFieldDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ParticipantRoleTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.PostOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ProsecutionDepartmentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO;
import hk.judiciary.icmssvd.model.common.facade.CommonFacade;
import hk.judiciary.icmssvd.model.courtCase.exception.CriminalGenericException;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.BatchSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.CertifcateBulkPostingDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDraftDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.MaintainRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDateGenerationDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosDocumentTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestServiceTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceBatchSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.facade.SvdReqFacade;
import hk.judiciary.icmssvd.util.DocumentFileUtil;
import hk.judiciary.icmssvd.view.BaseController;

@TideEnabled
public class SvdReqController extends BaseController {

    /**
     * retrieve a list of Court Level Type Detail code
     */
    public List<CourtLevelTypeDTO> getCourtLevelType() {
        info("getCourtLevelType start");
        List<CourtLevelTypeDTO> courtLvlTypeList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findCourtLevelTypeList(getUser());
        info("getCourtLevelType end");
        return courtLvlTypeList;
    }

    /**
     * retrieve a list of Service Mode Type Detail code
     */
    public List<ServiceModeTypeDTO> getServiceModeType() {
        info("getServiceModeType start");
        List<ServiceModeTypeDTO> serviceModeTypeList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findServiceModeTypeList(getUser());
        info("getServiceModeType end");
        return serviceModeTypeList;
    }

    /**
     * retrieve a list of Case Type Detail code
     */
    public List<CaseTypeDTO> getCaseType(FunctionDTO function) {
        info("getCaseType start " + function);
        List<CaseTypeDTO> caseTypeList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findCaseTypeList(getUser(), function);
        info("getCaseType end");
        return caseTypeList;
    }

    /**
     * retrieve a list of Case Type Detail code
     */
    public List<CaseTypeDTO> getSummonsCaseTypeList(FunctionDTO function) {
        info("getSummonsCaseTypeList start " + function);
        List<CaseTypeDTO> caseTypeList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findSummonsCaseTypeList(getUser(), function);
        info("getSummonsCaseTypeList end");
        return caseTypeList;
    }

    /**
     * retrieve a list of Comps Court Detail code
     */
    public List<ComprisingCourtDTO> getCompsCourt(FunctionDTO function) {
        info("getCompsCourt start " + function);
        List<ComprisingCourtDTO> comprisingCourtList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findComprisingCourtList(getUser(), function);
        info("getCompsCourt end");
        return comprisingCourtList;
    }

    /**
     * retrieve a list of Comps Court Detail code
     */
    public List<CourtRoomChambersDTO> getCourtRoomChambers() {
        info("getCourtRoomChambers start ");
        List<CourtRoomChambersDTO> courtRoomChambersDetailList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findCourtRoomChambers(getUser());
        info("getCourtRoomChambers end");
        return courtRoomChambersDetailList;
    }

    /**
     * retrieve a list of Handling Agent Detail code
     */
    public List<HandlingAgentDTO> getHandlingAgent(FunctionDTO function) {
        info("getHandlingAgents start " + function);
        List<HandlingAgentDTO> handlingAgentList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findHandlingAgentList(getUser(), function);
        info("getHandlingAgents end");
        return handlingAgentList;
    }

    /**
     * retrieve a list of Request Status Type Detail code
     */
    public List<RequestStatusTypeDTO> getRequestStatusType() {
        info("getRequestStatusType start");
        List<RequestStatusTypeDTO> requestStatusTypeList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findRequestStatusTypeList(getUser());
        info("getRequestStatusType end");
        return requestStatusTypeList;
    }

    /**
     * retrieve a list of Request Type Detail code
     */
    public List<RequestTypeDTO> getRequestType() {
        info("getRequestType start");
        List<RequestTypeDTO> requestTypeList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findRequestTypeList(getUser());
        info("getRequestType end");
        return requestTypeList;
    }

    /**
     * retrieve a list of Request Service Type Type Detail code
     */
    public List<RequestServiceTypeDTO> getRequestServiceTypeList() {
        info("findRequestServiceTypeList start");
        List<RequestServiceTypeDTO> requestServiceTypeList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findRequestServiceTypeList(getUser());
        info("findRequestServiceTypeList end");
        return requestServiceTypeList;
    }

    /**
     * retrieve a list of Fp Application Nature Types
     */
    public List<FpApplicationNatureTypeDTO> getFpAppNatTypeList() {
        info("getFpAppNatTypeList start ");
        List<FpApplicationNatureTypeDTO> fpApplicationNatureTypeList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findFpApplicationNatureTypeList(getUser());
        info("getFpAppNatTypeList end");
        return fpApplicationNatureTypeList;
    }

    /**
     * Retrieve Prosecution Department List
     */
    public List<ProsecutionDepartmentDTO> getProsecutionDepartmentList() {
        info("getProsecutionDepartmentList start ");
        List<ProsecutionDepartmentDTO> prosecutionDepartmentList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findProsecutionDepartmentList(getUser());
        info("getProsecutionDepartmentList end");
        return prosecutionDepartmentList;
    }

    /**
     * search request records by searchDto
     * 
     * @param searchDTO
     * @return
     */
    public List<ServiceRequestSearchResultDTO> searchServiceRequestList(
            ServiceRequestSearchDTO searchDTO) {
        info("searchServiceRequestList start");
        List<ServiceRequestSearchResultDTO> searchResults = getFacade(SvdReqFacade.NAME,
                SvdReqFacade.class).searchServiceRequestList(getUser(), searchDTO);
        info("searchServiceRequestList end");
        return searchResults;
    }

    /**
     * Complete Service Requests
     * 
     * @param requestIds
     * @return
     */
    public IntegerFieldDTO completeServiceRequestList(List<IdDTO> requestIds) {
        IntegerFieldDTO integerField = getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                .completeServiceRequestList(getUser(), requestIds);
        return integerField;
    }

    /**
     * Maintain service request
     * 
     * @param maintainRequest
     * @return
     */
    public ServiceRequestDetailDTO maintainRequest(MaintainRequestDTO maintainRequest) {
        info("maintainRequest start");
        ServiceRequestDetailDTO serviceRequestDetail = getFacade(SvdReqFacade.NAME,
                SvdReqFacade.class).maintainRequest(getUser(), maintainRequest);
        info("maintainRequest end");
        return serviceRequestDetail;
    }

    /**
     * Save the draft of service request
     * 
     * @param serviceRequestDetail
     * @return
     */
    public IdDTO saveDraftServiceRequest(ServiceRequestDetailDTO serviceRequestDetail)
            throws Exception {
        info("saveDraftServiceRequest start");
        IdDTO returnVal = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).saveDraftServiceRequest(
                getUser(), serviceRequestDetail);
        info("saveDraftServiceRequest end" + returnVal);
        return returnVal;
    }

    /**
     * Submit the service request
     * 
     * @param serviceRequestDetail
     * @return
     * @throws CriminalGenericException
     */
    public IdDTO submitServiceRequest(ServiceRequestDetailDTO serviceRequestDetail)
            throws Exception {
        info("submitServiceRequest start");
        IdDTO returnVal = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).submitServiceRequest(
                getUser(), serviceRequestDetail);
        info("submitServiceRequest end" + returnVal);
        return returnVal;
    }

    /**
     * Withdraw the service request
     * 
     * @param serviceRequestDetail
     * @return
     */
    public IdDTO withdrawServiceRequest(ServiceRequestDetailDTO serviceRequestDetail) {
        info("withdrawServiceRequest start");
        IdDTO returnVal = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).withdrawServiceRequest(
                getUser(), serviceRequestDetail);
        info("withdrawServiceRequest end" + returnVal);
        return returnVal;
    }

    /**
     * Complete the service request
     * 
     * @param serviceRequestDetail
     * @return
     */
    public IdDTO completeServiceRequest(ServiceRequestDetailDTO serviceRequestDetail) {
        info("completeServiceRequest start");
        IdDTO returnVal = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).completeServiceRequest(
                getUser(), serviceRequestDetail);
        info("completeServiceRequest end" + returnVal);
        return returnVal;
    }

    /**
     * retrieve a list of Hk District
     */
    public List<HkDistrictDTO> getHkDistrict() {
        info("getHkDistrict start ");
        List<HkDistrictDTO> hkDistrictList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findHkDistrictList(getUser());
        info("getHkDistrict start");
        return hkDistrictList;
    }

    /**
     * retrieve a list of Hk Region
     */
    public List<HkRegionDTO> getHkRegion() {
        info("getHkRegion start ");
        List<HkRegionDTO> hkRegionList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findHkRegionList(getUser());
        info("getHkRegion start");
        return hkRegionList;
    }

    /**
     * retrieve a list of BailiffOffice
     */
    public List<BailiffOfficeDTO> getBailiffOffice() {
        info("getBailiffOffice start ");
        List<BailiffOfficeDTO> bailiffOfficeList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findBailiffOfficeList(getUser());
        info("getBailiffOffice start");
        return bailiffOfficeList;
    }

    /**
     * retrieve a list of PostOffice
     */
    public List<PostOfficeDTO> getPostOffice() {
        info("getPostOfficeList start ");
        List<PostOfficeDTO> postOfficeList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findPostOfficeList(getUser());
        info("getPostOfficeList start");
        return postOfficeList;
    }

    /**
     * retrieve a list of ParticipantRoleType
     */
    public List<ParticipantRoleTypeDTO> getParticipantRoleType(FunctionDTO function) {
        info("getParticipantRoleType start ");
        List<ParticipantRoleTypeDTO> participantRoleTypeList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findParticipantRoleTypeList(getUser(), function);
        info("getParticipantRoleType start");
        return participantRoleTypeList;
    }

    public List<DocumentDraftDTO> generateDocuments(ServiceRequestDetailDTO serviceRequestDetailDTO)
            throws Exception {
        info("generateDocuments start");
        List<DocumentDraftDTO> documentDraftList = getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                .generateDocuments(getUser(), serviceRequestDetailDTO);
        info("generateDocuments end return : " + documentDraftList);
        return documentDraftList;
    }

    /**
     * retrieve a list of BailiffTaskResultStatus
     */
    public List<BailiffTaskResultStatusDTO> getBailiffTaskResultStatusList() {
        info("getBailiffTaskResultStatusList start ");
        List<BailiffTaskResultStatusDTO> bailiffTaskResultStatusList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findBailiffTaskResultStatusList(getUser());
        info("getBailiffTaskResultStatusList start");
        return bailiffTaskResultStatusList;
    }

    /**
     * retrieve a list of BailiffTaskResultReason
     */
    public List<BailiffTaskResultReasonDTO> getBailiffTaskResultReasonList() {
        info("getBailiffTaskResultReasonList start ");
        List<BailiffTaskResultReasonDTO> bailiffTaskResultReasonList = getFacade(CommonFacade.NAME,
                CommonFacade.class).findBailiffTaskResultReasonList(getUser());
        info("getBailiffTaskResultReasonList start");
        return bailiffTaskResultReasonList;
    }

    /**
     * retrieve a list of Document Type Detail code
     */
    public List<DocumentTypeDTO> getDocumentTypeList(FunctionDTO function) {
        info("getDocumentTypeList start " + function);
        List<DocumentTypeDTO> documentTypeList = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findDocumentTypeList(getUser(), function);
        info("getDocumentTypeList end");
        return documentTypeList;
    }

    /**
     * Save the result of service request
     * 
     * @param RequestResultDTO
     * @return
     * @throws Exception
     */
    public IdDTO saveServiceRequestResult(ServiceRequestDetailDTO detailDTO) throws Exception {
        info("saveServiceRequestResult start");
        IdDTO returnVal = getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                .saveServiceRequestResult(getUser(), detailDTO);
        info("saveServiceRequestResult end" + returnVal);
        return returnVal;
    }

    /**
     * Search the proof of service requests according to inputted criteria
     * 
     * @param searchDTO
     * @return
     */
    public List<PosRequestSearchResultDTO> searchPosRequestList(PosRequestSearchDTO searchDTO) {
        info("searchPosRequestList() start - " + searchDTO);
        List<PosRequestSearchResultDTO> returnVal = getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                .searchPosRequestList(getUser(), searchDTO);
        info("searchPosRequestList() end - " + returnVal);
        return returnVal;
    }

    /**
     * Maintain the proof of service request
     * 
     * @param maintainRequestDTO
     * @return
     */
    public PosRequestDetailDTO maintainPosRequest(MaintainRequestDTO maintainRequestDTO) {
        info("maintainPosRequest() start - " + maintainRequestDTO);
        PosRequestDetailDTO returnVal = getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                .maintainPosRequest(getUser(), maintainRequestDTO);
        info("maintainPosRequest() end - " + returnVal);
        return returnVal;
    }

    /**
     * Submit the proof of service request
     * 
     * @param posRequestDetailDTO
     * @return
     */
    public IdDTO submitPosRequest(PosRequestDetailDTO posRequestDetailDTO) {
        info("submitPosRequest() start - " + posRequestDetailDTO);
        IdDTO returnVal = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).submitPosRequest(
                getUser(), posRequestDetailDTO);
        info("submitPosRequest() end - " + returnVal);
        return returnVal;
    }

    /**
     * Submit the proof of service request list
     * 
     * @param posRequestDetailDTOs
     * @return
     */
    public List<IdDTO> submitPosRequestList(List<PosRequestDetailDTO> posRequestDetailDTOs) {
        info("submitPosRequestList() start - " + posRequestDetailDTOs);
        List<IdDTO> returnVal = new ArrayList<IdDTO>();
        for (PosRequestDetailDTO posRequestDetailDTO : posRequestDetailDTOs) {
            IdDTO idDTO = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).submitPosRequest(
                    getUser(), posRequestDetailDTO);
            returnVal.add(idDTO);
        }
        info("submitPosRequestList() end - " + returnVal);
        return returnVal;
    }

    /**
     * Retrieve the proof of service document type list
     * 
     * @return
     */
    public List<PosDocumentTypeDTO> getPosDocumentTypeList() {
        info("findPosDocumentTypeList start");
        List<PosDocumentTypeDTO> returnVal = getFacade(CommonFacade.NAME, CommonFacade.class)
                .findPosDocumentTypeList(getUser());
        info("findPosDocumentTypeList end" + returnVal);
        return returnVal;
    }

    /**
     * search batch records by searchDto
     * 
     * @param searchDTO
     * @return
     */
    public List<ReserviceBatchSearchResultDTO> searchReserviceBatchList(BatchSearchDTO searchDTO) {
        info("searchReserviceBatchList start");
        List<ReserviceBatchSearchResultDTO> searchResults = getFacade(SvdReqFacade.NAME,
                SvdReqFacade.class).searchReserviceBatchList(getUser(), searchDTO);
        info("searchReserviceBatchList end");
        return searchResults;
    }

    /**
     * Generate the next hearing date
     * 
     * @param searchDTO
     * @return
     */
    public List<NextHearingDetailDTO> generateNextHearingDate(
            List<ReserviceBatchSearchResultDTO> resultDTOs, Integer overridDays) {
        info("generateNextHearingDate start");
        List<NextHearingDetailDTO> nextHearingDetailList = new ArrayList<NextHearingDetailDTO>();
        for (ReserviceBatchSearchResultDTO resultDTO : resultDTOs) {
            NextHearingDateGenerationDTO generationDTO = new NextHearingDateGenerationDTO();
            generationDTO.setDayFromAllocation(overridDays);
            generationDTO.setNextHearingDetail(resultDTO.getNextHearingDetail());
            nextHearingDetailList.add(getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                    .generateNextHearingDate(getUser(), generationDTO));
        }
        info("generateNextHearingDate end");
        return nextHearingDetailList;
    }

    /**
     * Confirm hearing schedule
     * 
     * @param searchDTO
     * @return
     * @throws Exception
     */
    public List<ReserviceBatchSearchResultDTO> confirmHearingSchedule(
            List<ReserviceBatchSearchResultDTO> resultDTOs) throws Exception {
        info("confirmHearingSchedule start");
        for (ReserviceBatchSearchResultDTO resultDTO : resultDTOs) {
            resultDTO = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).confirmHearingSchedule(
                    getUser(), resultDTO);
        }
        info("confirmHearingSchedule end");
        return resultDTOs;
    }

    /**
     * Generate the certificate of bulk posting
     * 
     * @param postingDTO
     * @return
     */
    public void generateCertificateBulkPosting(CertifcateBulkPostingDTO postingDTO)
            throws Exception {
        info("generateCertificateBulkPosting start");
        FileDTO fileDTO = getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                .generateCertificateBulkPosting(getUser(), postingDTO);
        DocumentFileUtil.launchPDFViewer(this, fileDTO);
        info("generateCertificateBulkPosting end");
    }

    /**
     * Save the draft of re-service request and generate the re-service summons and other documents
     * for the request
     * 
     * @param reserviceBatchSearchResultDTO
     * @return
     * @throws CriminalGenericException
     */
    public List<IdDTO> saveDraftReserviceRequestAndGenerateDocuments(
            List<ReserviceBatchSearchResultDTO> resultDTOs) throws Exception {
        info("saveDraftReserviceRequestAndGenerateDocuments start");
        List<IdDTO> idDTOs = new ArrayList<IdDTO>();
        for (ReserviceBatchSearchResultDTO resultDTO : resultDTOs) {
            IdDTO idDTO = getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                    .saveDraftReserviceRequestAndGenerateDocuments(getUser(), resultDTO);
            idDTOs.add(idDTO);
        }
        info("saveDraftReserviceRequestAndGenerateDocuments end");
        return idDTOs;
    }

    /**
     * Save the draft of re-service request
     * 
     * @param reserviceBatchSearchResultDTO
     * @return
     * @throws CriminalGenericException
     */
    public List<IdDTO> saveDraftReserviceRequest(List<ReserviceBatchSearchResultDTO> resultDTOs)
            throws Exception {
        info("saveDraftReserviceRequest start");
        List<IdDTO> idDTOs = new ArrayList<IdDTO>();
        for (ReserviceBatchSearchResultDTO resultDTO : resultDTOs) {
            IdDTO idDTO = getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                    .saveDraftReserviceRequest(getUser(), resultDTO);
            idDTOs.add(idDTO);
        }
        info("saveDraftReserviceRequest end");
        return idDTOs;
    }

    /**
     * Submit re-service request
     * 
     * @param reserviceBatchSearchResultDTO
     * @return
     * @throws CriminalGenericException
     */
    public List<IdDTO> submitReserviceRequest(List<ReserviceBatchSearchResultDTO> resultDTOs)
            throws Exception {
        info("submitReserviceRequest start");
        List<IdDTO> idDTOs = new ArrayList<IdDTO>();
        for (ReserviceBatchSearchResultDTO resultDTO : resultDTOs) {
            IdDTO idDTO = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).submitReserviceRequest(
                    getUser(), resultDTO);
            idDTOs.add(idDTO);
        }
        info("submitReserviceRequest end");
        return idDTOs;
    }

    /**
     * Maintain re-service request
     * 
     * @param maintainRequests
     * @return
     */
    public List<ReserviceRequestDetailDTO> maintainReserviceRequests(List<IdDTO> ids) {
        info("maintainReserviceRequest start");
        List<ReserviceRequestDetailDTO> requestDetails = new ArrayList<ReserviceRequestDetailDTO>();
        for (IdDTO idDTO : ids) {
            MaintainRequestDTO maintainRequestDTO = new MaintainRequestDTO();
            maintainRequestDTO.setRequestId(idDTO.getId());
            requestDetails.add(getFacade(SvdReqFacade.NAME, SvdReqFacade.class)
                    .maintainReserviceRequest(getUser(), maintainRequestDTO));
        }
        info("maintainReserviceRequest end");
        return requestDetails;
    }

    public DocumentDTO assignDrn(DocumentDTO documentDTO) throws Exception {
        DrnDTO assignDrn = getFacade(SvdReqFacade.NAME, SvdReqFacade.class).assignDrn(getUser());
        documentDTO.setDocumentReferenceNo(assignDrn.getDocumentReferenceNo());
        return documentDTO;
    }

    /**
     * Search the proof of service requests in batch according to inputted criteria
     * 
     * @param searchDTO
     * @return
     */
    public List<PosRequestDetailDTO> searchPosRequestBatchList(BatchSearchDTO searchDTO) {
        info("searchPosRequestBatchList start");
        List<PosRequestDetailDTO> posRequestDetailList = getFacade(SvdReqFacade.NAME,
                SvdReqFacade.class).searchPosRequestBatchList(getUser(), searchDTO);
        info("searchPosRequestBatchList end");
        return posRequestDetailList;
    }

    public FileDTO downloadDocFile(DocumentFileDTO documentFileDTO) throws Exception {
        FileDTO fileDTO = getFacade(CommonFacade.NAME, CommonFacade.class).getDocumentFile(
                getUser(), documentFileDTO);
        if (fileDTO != null) {
            DocumentFileUtil.launchDownload(this, fileDTO);
        }
        return fileDTO;
    }

    public void previewDocFile(DocumentFileDTO documentFileDTO) throws Exception {
        FileDTO fileDTO = getFacade(CommonFacade.NAME, CommonFacade.class).getDocumentFile(
                getUser(), documentFileDTO);
        DocumentFileUtil.launchPDFViewer(this, fileDTO);
    }
}
