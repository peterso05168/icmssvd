package hk.judiciary.icmssvd.model.svdReq.biz;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hk.judiciary.fmk.common.exception.BusinessMessage;
import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.model.cfs.biz.dto.FileDTO;
import hk.judiciary.icms.model.dao.entity.BlfDocStatusType;
import hk.judiciary.icms.model.dao.entity.BlfOffice;
import hk.judiciary.icms.model.dao.entity.BlfTask;
import hk.judiciary.icms.model.dao.entity.BlfTaskRsltRsn;
import hk.judiciary.icms.model.dao.entity.BlfTaskRsltStatus;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.CompsCourt;
import hk.judiciary.icms.model.dao.entity.CourtRmChmbr;
import hk.judiciary.icms.model.dao.entity.Doc;
import hk.judiciary.icms.model.dao.entity.DocType;
import hk.judiciary.icms.model.dao.entity.HandlingAgt;
import hk.judiciary.icms.model.dao.entity.HkDist;
import hk.judiciary.icms.model.dao.entity.HkRgn;
import hk.judiciary.icms.model.dao.entity.HrnDtl;
import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icms.model.dao.entity.IntlUserAc;
import hk.judiciary.icms.model.dao.entity.Partcp;
import hk.judiciary.icms.model.dao.entity.PartcpRole;
import hk.judiciary.icms.model.dao.entity.PartcpRoleType;
import hk.judiciary.icms.model.dao.entity.PostOffice;
import hk.judiciary.icms.model.dao.entity.ProofOfServDocType;
import hk.judiciary.icms.model.dao.entity.ProofOfServReqs;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsAddr;
import hk.judiciary.icms.model.dao.entity.ReqsDoc;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icms.model.dao.entity.ReqsRslt;
import hk.judiciary.icms.model.dao.entity.ReqsStatusType;
import hk.judiciary.icms.model.dao.entity.ReqsType;
import hk.judiciary.icms.model.dao.entity.ServModeType;
import hk.judiciary.icms.model.dao.entity.ServReqs;
import hk.judiciary.icms.model.dao.entity.SpecialReqs;
import hk.judiciary.icms.model.dao.entity.SpecialReqsType;
import hk.judiciary.icms.model.dao.entity.StnceOrdrToDoc;
import hk.judiciary.icms.model.dao.entity.SummonNoti;
import hk.judiciary.icmssvd.model.BaseBO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.biz.CommonBO;
import hk.judiciary.icmssvd.model.common.biz.assembler.DocumentTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.HandlingAgentDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestStatusTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.ServiceModeTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.SpecialRequestTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultReasonDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultStatusDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DrnDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HandlingAgentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HkDistrictDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HkRegionDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.IntegerFieldDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ParticipantRoleTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.PostOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.SpecialRequestTypeDTO;
import hk.judiciary.icmssvd.model.common.dao.BailiffDocumentStatusTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.BailiffOfficeDAO;
import hk.judiciary.icmssvd.model.common.dao.BailiffTaskResultReasonDAO;
import hk.judiciary.icmssvd.model.common.dao.BailiffTaskResultStatusDAO;
import hk.judiciary.icmssvd.model.common.dao.ComprisingCourtDAO;
import hk.judiciary.icmssvd.model.common.dao.CourtRmChmbrDAO;
import hk.judiciary.icmssvd.model.common.dao.DocumentTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.HandlingAgentDAO;
import hk.judiciary.icmssvd.model.common.dao.HkDistrictDAO;
import hk.judiciary.icmssvd.model.common.dao.HkRegionDAO;
import hk.judiciary.icmssvd.model.common.dao.IntlUserAcDAO;
import hk.judiciary.icmssvd.model.common.dao.ParticipantDAO;
import hk.judiciary.icmssvd.model.common.dao.ParticipantRoleDAO;
import hk.judiciary.icmssvd.model.common.dao.ParticipantRoleTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.PosDocumentTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.PostOfficeDAO;
import hk.judiciary.icmssvd.model.common.dao.RequestParticipantRoleDAO;
import hk.judiciary.icmssvd.model.common.dao.RequestStatusTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.RequestTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.ServiceModeTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.SpecialRequestTypeDAO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.common.util.DocumentFileUtil;
import hk.judiciary.icmssvd.model.common.util.HearingScheduleUtil;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.courtCase.exception.CriminalGenericException;
import hk.judiciary.icmssvd.model.report.biz.ReportBO;
import hk.judiciary.icmssvd.model.report.biz.dto.ReportResultPackDTO;
import hk.judiciary.icmssvd.model.svdReq.HearingConstant;
import hk.judiciary.icmssvd.model.svdReq.MessageConstant;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.NextHearingDetailDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.PosRequestDetailDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.PosRequestSearchResultDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.RequestServiceTypeDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.ReserviceRequestDetailDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.ServiceRequestDetailDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.ServiceRequestSearchResultDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.AddressDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.AddressRoleDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.BatchSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.CertifcateBulkPostingDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDraftDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentRecordDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.MaintainRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDateGenerationDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PartyDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosDocumentTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestAddressDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDocumentDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestParticipantRoleDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceBatchSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.SpecialRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.dao.BailiffTaskDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.DocDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.HearingDetailDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.HearingScheduleDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.PosRequestDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.ReqsRsltDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.RequestAddressDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.RequestDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.RequestDocumentDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.SentenceOrderToDocumentDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.ServiceRequestDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.SpecialRequestDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.SummonsNoticeDAO;
import hk.judiciary.icmssvd.model.svdReq.util.AppServiceDocValidationUtil;

/**
 * 
 * @version $Revision: 7895 $ $Date: 2017-07-10 10:36:55 +0800 (Mon, 10 Jul 2017) $
 * @author $Author: mtse $
 */
public class SvdReqBO extends BaseBO {
    public static final String NAME = "svdReqBO";

    private ReportBO getReportBO() {
        return getBO(ReportBO.NAME, ReportBO.class);
    }

    private CommonBO getCommonBO() {
        return getBO(CommonBO.NAME, CommonBO.class);
    }

    private ComprisingCourtDAO getComprisingCourtDAO() {
        return getDAO(ComprisingCourtDAO.COMPS_COURT_DAO, ComprisingCourtDAO.class);
    }

    private CourtRmChmbrDAO getCourtRmChmbrDAO() {
        return getDAO(CourtRmChmbrDAO.COURTRMCHMBR_DAO, CourtRmChmbrDAO.class);
    }

    private RequestDAO getRequestDAO() {
        return getDAO(RequestDAO.REQUEST_DAO, RequestDAO.class);
    }

    private BailiffTaskDAO getBailiffTaskDAO() {
        return getDAO(BailiffTaskDAO.BAILIFF_TASK_DAO, BailiffTaskDAO.class);
    }

    private RequestStatusTypeDAO getRequestStatusTypeDAO() {
        return getDAO(RequestStatusTypeDAO.REQS_STATUS_TYPE_DAO, RequestStatusTypeDAO.class);
    }

    private CaseDAO getCaseDAO() {
        return getDAO(CaseDAO.CASE_DAO, CaseDAO.class);
    }

    private DocDAO getDocDAO() {
        return getDAO(DocDAO.DOC_DAO, DocDAO.class);
    }

    private ReqsRsltDAO getReqsRsltDAO() {
        return getDAO(ReqsRsltDAO.REQS_RSLT_DAO, ReqsRsltDAO.class);
    }

    private BailiffTaskResultReasonDAO getBailiffTaskResultReasonDAO() {
        return getDAO(BailiffTaskResultReasonDAO.BAILIFFTASK_RESULT_REASON_DAO,
                BailiffTaskResultReasonDAO.class);
    }

    private BailiffTaskResultStatusDAO getBailiffTaskResultStatusDAO() {
        return getDAO(BailiffTaskResultStatusDAO.BAILIFFTASK_RESULT_STATUS_DAO,
                BailiffTaskResultStatusDAO.class);
    }

    private RequestTypeDAO getRequestTypeDAO() {
        return getDAO(RequestTypeDAO.REQS_TYPE_DAO, RequestTypeDAO.class);
    }

    private HandlingAgentDAO getHandlingAgentDAO() {
        return getDAO(HandlingAgentDAO.HANDLING_AGT_DAO, HandlingAgentDAO.class);
    }

    private BailiffOfficeDAO getBailiffOfficeDAO() {
        return getDAO(BailiffOfficeDAO.BLF_OFFICE_DAO, BailiffOfficeDAO.class);
    }

    private ServiceRequestDAO getServiceRequestDAO() {
        return getDAO(ServiceRequestDAO.SERVICE_REQUEST_DAO, ServiceRequestDAO.class);
    }

    private SpecialRequestTypeDAO getSpecialRequestTypeDAO() {
        return getDAO(SpecialRequestTypeDAO.SPECIAL_REQS_TYPE_DAO, SpecialRequestTypeDAO.class);
    }

    private SpecialRequestDAO getSpecialRequestDAO() {
        return getDAO(SpecialRequestDAO.SPECIAL_REQUEST_DAO, SpecialRequestDAO.class);
    }

    private RequestAddressDAO getRequestAddressDAO() {
        return getDAO(RequestAddressDAO.REQUEST_ADDRESS_DAO, RequestAddressDAO.class);
    }

    private RequestDocumentDAO getRequestDocumentDAO() {
        return getDAO(RequestDocumentDAO.REQUEST_DOCUMENT_DAO, RequestDocumentDAO.class);
    }

    private RequestParticipantRoleDAO getRequestParticipantRoleDAO() {
        return getDAO(RequestParticipantRoleDAO.REQUEST_PARTICIPANT_ROLE_DAO,
                RequestParticipantRoleDAO.class);
    }

    private ParticipantRoleTypeDAO getParticipantRoleTypeDAO() {
        return getDAO(ParticipantRoleTypeDAO.PARTICIPANT_ROLE_TYPE_DAO,
                ParticipantRoleTypeDAO.class);
    }

    private ServiceModeTypeDAO getServiceModeTypeDAO() {
        return getDAO(ServiceModeTypeDAO.SERV_MODEL_TYPE_DAO, ServiceModeTypeDAO.class);
    }

    private PostOfficeDAO getPostOfficeDAO() {
        return getDAO(PostOfficeDAO.POST_OFFICE_DAO, PostOfficeDAO.class);
    }

    private HkDistrictDAO getHkDistrictDAO() {
        return getDAO(HkDistrictDAO.HK_DISTRICT_DAO, HkDistrictDAO.class);
    }

    private HkRegionDAO getHkRegionDAO() {
        return getDAO(HkRegionDAO.HK_RGN_DAO, HkRegionDAO.class);
    }

    private ParticipantDAO getParticipantDAO() {
        return getDAO(ParticipantDAO.PARTICIPANT_DAO, ParticipantDAO.class);
    }

    private ParticipantRoleDAO getParticipantRoleDAO() {
        return getDAO(ParticipantRoleDAO.PARTICIPANT_ROLE_DAO, ParticipantRoleDAO.class);
    }

    private SummonsNoticeDAO getSummonsNoticeDAO() {
        return getDAO(SummonsNoticeDAO.SUMMONS_NOTICE_DAO, SummonsNoticeDAO.class);
    }

    private HearingScheduleDAO getHearingScheduleDAO() {
        return getDAO(HearingScheduleDAO.HEARING_SCHEDULE_DAO, HearingScheduleDAO.class);
    }

    private PosRequestDAO getPosRequestDAO() {
        return getDAO(PosRequestDAO.POS_REQUEST_DAO, PosRequestDAO.class);
    }

    private IntlUserAcDAO getIntlUserAcDAO() {
        return getDAO(IntlUserAcDAO.INTL_USERAC_DAO, IntlUserAcDAO.class);
    }

    private PosDocumentTypeDAO getPosDocumentTypeDAO() {
        return getDAO(PosDocumentTypeDAO.POS_DOCUMENT_TYPE_DAO, PosDocumentTypeDAO.class);
    }

    private BailiffDocumentStatusTypeDAO getBailiffDocumentStatusTypeDAO() {
        return getDAO(BailiffDocumentStatusTypeDAO.BAILIFF_DOCUMENT_STATUSTYPE_DAO,
                BailiffDocumentStatusTypeDAO.class);
    }

    private DocumentTypeDAO getDocumentTypeDAO() {
        return getDAO(DocumentTypeDAO.DOC_TYPE_DAO, DocumentTypeDAO.class);
    }

    private SentenceOrderToDocumentDAO getSentenceOrderToDocumentDAO() {
        return getDAO(SentenceOrderToDocumentDAO.SENTENCE_ORDERTODOCUMENT_DAO,
                SentenceOrderToDocumentDAO.class);
    }

    private HearingDetailDAO getHearingDetailDAO() {
        return getDAO(HearingDetailDAO.HEARING_DETAIL_DAO, HearingDetailDAO.class);
    }

    /**
     * Assign DRN
     * 
     * @throws Exception
     */
    public DrnDTO assignDrn() throws Exception {
        info("assignDrn() start");
        DrnDTO drnDTO = new DrnDTO();
        drnDTO.setDocumentReferenceNo(DocumentFileUtil.generateDrn(this.getJudiciaryUser()));
        info("assignDrn() end - return " + drnDTO);
        return drnDTO;
    }

    /**
     * Complete Service Requests
     * 
     * @param requestIds
     * @return
     */
    public IntegerFieldDTO completeServiceRequestList(List<IdDTO> requestIds) {
        IntegerFieldDTO returnVal = new IntegerFieldDTO();
        int i = 0;
        for (IdDTO idDTO : requestIds) {
            MaintainRequestDTO maintainRequest = new MaintainRequestDTO();
            maintainRequest.setRequestId(idDTO.getId());
            FunctionDTO func = new FunctionDTO();
            func.setCourtLevelTypeCode(RequestConstant.COURT_LEVEL_TYPE_MAGISTRATES);
            maintainRequest.setFunc(func);
            ServiceRequestDetailDTO serviceRequestDetail = maintainRequest(maintainRequest);
            IdDTO id = completeServiceRequest(serviceRequestDetail);
            if (id != null && DbCommonUtil.isValidDbId(id.getId())) {
                i++;
            }
        }
        returnVal.setIntegerField1(i);
        returnVal.setIntegerField2(requestIds.size());
        return returnVal;
    }

    /**
     * Service Request Enquiry
     * 
     * @param ServiceRequestSearchDTO
     *            searchDTO
     * @return list of ServiceRequestSearchResultDTO
     */
    public List<ServiceRequestSearchResultDTO> searchServiceRequestList(
            ServiceRequestSearchDTO searchDTO) {
        info("searchServiceRequestList() start - " + searchDTO);
        List<ServiceRequestSearchResultDTO> returnVal = new ArrayList<ServiceRequestSearchResultDTO>();
        if (searchDTO.getSubmitStartDate() != null) {
            searchDTO.setSubmitStartDate(DbCommonUtil.getStartDateTime(searchDTO
                    .getSubmitStartDate()));
        }
        if (searchDTO.getSubmitEndDate() != null) {
            searchDTO.setSubmitEndDate(DbCommonUtil.getEndDateTime(searchDTO.getSubmitEndDate()));
        }
        if (searchDTO.getCaseNo() != null && !"".equals(searchDTO.getCaseNo())) {
            searchDTO.setCaseNo(searchDTO.getCaseNo().toUpperCase());
        }
        List<Reqs> reqs = getRequestDAO().findRequestListByServiceRequestSearch(searchDTO);
        if (!CommonUtil.isNullOrEmpty(reqs)) {
            for (Reqs r : reqs) {
                ServiceRequestSearchResultDTO dto = ServiceRequestSearchResultDTOAssembler.toDto(r);
                boolean allowCompleteRequest = AppServiceDocValidationUtil
                        .isAllowCompleteRequest(dto.getRequestStatusType());
                dto.setAllowCompleteInd(allowCompleteRequest);
                returnVal.add(dto);
            }
        }
        info("searchServiceRequestList end returnVal: " + returnVal);
        return returnVal;
    }

    /**
     * Complete the service request
     * 
     * @return
     */
    public IdDTO completeServiceRequest(ServiceRequestDetailDTO serviceRequestDetail) {
        info("completeServiceRequest() start - " + serviceRequestDetail);
        IdDTO returnVal = new IdDTO();
        if (serviceRequestDetail != null && serviceRequestDetail.getRequest() != null) {
            BusinessMessage businessMessage = AppServiceDocValidationUtil
                    .validateCompleteRequest(serviceRequestDetail.getRequest());
            if (businessMessage != null) {
                this.addMessage(businessMessage);
                this.throwException(serviceRequestDetail.getErrorBoxComponentId());
            }

            if (RequestConstant.HANDLING_AGENT_BAILIFF.equals(serviceRequestDetail.getRequest().getHandlingAgent()        		
                    .getHandlingAgentCode())) {
            	// send complete request to Bailiff
            } else {
	            ReqsStatusType completedType = getRequestStatusTypeDAO().findByRequestStatusTypeCode(
	                    RequestConstant.REQUEST_STATUS_COMPLETED);
	            if (completedType != null
	                    && DbCommonUtil.isValidDbId(completedType.getReqsStatusTypeId())) {
	                RequestStatusTypeDTO requestStatusType = RequestStatusTypeDTOAssembler
	                        .toDto(completedType);
	                serviceRequestDetail.getRequest().setRequestStatusType(requestStatusType);
	                Reqs reqs = toEntity(serviceRequestDetail.getRequest());
	                getRequestDAO().merge(reqs);
	            }
            }
            returnVal.setId(serviceRequestDetail.getRequest().getRequestId());
        }
        info("completeServiceRequest end returnVal: " + returnVal);
        return returnVal;
    }

    /**
     * Enquire the service request
     * 
     * @param idDTO
     * @return
     */
    public ServiceRequestDetailDTO enquireServiceRequest(IdDTO idDTO) {
        return null;
    }

    /**
     * Generate Report of Documents
     * 
     * @param serviceRequestDetailDTO
     * @return
     * @throws CriminalGenericException
     */
    public List<ReportResultPackDTO> generateReports(ServiceRequestDetailDTO serviceRequestDetailDTO)
            throws CriminalGenericException {
        List<ReportResultPackDTO> returnVal = new ArrayList<ReportResultPackDTO>();
        RequestDTO request = serviceRequestDetailDTO.getRequest();
        if (DbCommonUtil.isValidDbId(request.getRequestId())) {
            if (RequestConstant.REQUEST_SERVICE_TYPE_FRIST.equals(serviceRequestDetailDTO
                    .getRequestServiceType().getRequestServiceType())) {
                List<ReportResultPackDTO> reportResultPacks = getReportBO().genSummons(
                        request.getCaseType(), request.getCaseId(), request.getRegistrationNo());
                returnVal.addAll(reportResultPacks);
            } else if (RequestConstant.REQUEST_SERVICE_TYPE_RESERVICE
                    .equals(serviceRequestDetailDTO.getRequestServiceType().getRequestServiceType())) {
                List<ReportResultPackDTO> reportResultPacks = getReportBO().genReserviceSummons(
                        request.getCaseType(), request.getCaseId(), request.getRegistrationNo());
                returnVal.addAll(reportResultPacks);
            }
        } else {
            if (RequestConstant.REQUEST_SERVICE_TYPE_FRIST.equals(serviceRequestDetailDTO
                    .getRequestServiceType().getRequestServiceType())) {
                List<ReportResultPackDTO> reportResultPacks = getReportBO().genSummons(
                        request.getCaseType(), request.getCaseId());
                returnVal.addAll(reportResultPacks);
            } else if (RequestConstant.REQUEST_SERVICE_TYPE_RESERVICE
                    .equals(serviceRequestDetailDTO.getRequestServiceType().getRequestServiceType())) {
                List<ReportResultPackDTO> reportResultPacks = getReportBO().genReserviceSummons(
                        request.getCaseType(), request.getCaseId());
                returnVal.addAll(reportResultPacks);
            }
        }
        return returnVal;
    }

    /**
     * Generate/Re-Generate documents
     * 
     * @param serviceRequestDetailDTO
     * @return
     * @throws CriminalGenericException
     */
    public List<DocumentDraftDTO> generateDocuments(ServiceRequestDetailDTO serviceRequestDetailDTO)
            throws Exception {

        List<DocumentDraftDTO> documentDrafts = serviceRequestDetailDTO.getDocumentDrafts();

        if (RequestConstant.COURT_LEVEL_TYPE_MAGISTRATES.equals(serviceRequestDetailDTO.getFunc()
                .getCourtLevelTypeCode())
                && RequestConstant.REQUEST_SERVICE_TYPE_RESERVICE.equals(serviceRequestDetailDTO
                        .getRequestServiceType().getRequestServiceType())) {

            // Un-select document for deletion
            if (CommonUtil.isNullOrEmpty(documentDrafts)) {
                documentDrafts = new ArrayList<DocumentDraftDTO>();
            }
            for (DocumentDraftDTO documentDraft : documentDrafts) {
                documentDraft.setSelectedDocumentInd(false);
            }

            List<ReportResultPackDTO> reportResultPacks = generateReports(serviceRequestDetailDTO);
            if (!CommonUtil.isNullOrEmpty(reportResultPacks)) {
                for (ReportResultPackDTO reportResultPackDTO : reportResultPacks) {

                    String documentTypeCode = reportResultPackDTO.getReportTypeCode();

                    String sourceFileId = null;
                    // Search the existing Document Draft with same document type
                    for (DocumentDraftDTO documentDraft : documentDrafts) {
                        if (documentDraft.getDocumentType() != null
                                && documentTypeCode.equals(documentDraft.getDocumentType()
                                        .getDocumentTypeCode())) {
                            sourceFileId = documentDraft.getRequestDocument()
                                    .getDocumentReferenceNo();
                            documentDraft.setSelectedDocumentInd(true);
                            info("Found same document type : sourceFileId " + sourceFileId);
                            break;
                        }
                    }

                    // Create new Document Draft
                    if (CommonUtil.isNullOrEmpty(sourceFileId)) {
                        sourceFileId = DocumentFileUtil.genSourceFileId(this.getJudiciaryUser(),
                                documentTypeCode);

                        RequestDocumentDTO requestDocument = new RequestDocumentDTO();
                        requestDocument.setDocumentReferenceNo(sourceFileId);
                        requestDocument.setReturnedDocumentInd(false);
                        requestDocument.setActionRequestInd(true);
                        requestDocument.setPrintedInd(false);
                        requestDocument
                                .setBailiffDocumentStatusId(RequestConstant.BALIFF_DOCUMENT_STATUS_GENERATED);
                        requestDocument.setIssueDate(new Date());
                        requestDocument.setHardcopyInd(false);

                        DocumentDraftDTO newDocumentDraft = new DocumentDraftDTO();
                        newDocumentDraft.setRequestDocument(requestDocument);
                        DocType docType = getDocumentTypeDAO().findByDocumentTypeCode(
                                documentTypeCode);
                        newDocumentDraft.setDocumentType(DocumentTypeDTOAssembler.toDto(docType));
                        newDocumentDraft.setSelectedDocumentInd(true);

                        documentDrafts.add(newDocumentDraft);
                        
                        info("New document is added to document draft list : document type code = " + newDocumentDraft.getDocumentType().getDocumentTypeCode());
                    }

                    // Save the document to CFS repository
                    DocumentFileUtil
                            .addCfsFile(this.getJudiciaryUser(), sourceFileId, DocumentFileUtil
                                    .generateFileDTO(reportResultPackDTO.getReportResult()));
                }

            } else {
                info("No documents is generated.");
            }

        }

        return documentDrafts;
    }

    /**
     * Maintain service request
     * 
     * @param maintainRequest
     * @return
     */
    public ServiceRequestDetailDTO maintainRequest(MaintainRequestDTO maintainRequestDTO) {
        info("maintainRequest() start - " + maintainRequestDTO);
        ServiceRequestDetailDTO serviceRequestDetail = new ServiceRequestDetailDTO();
        if (maintainRequestDTO != null) {
            // Set the case no. to uppercase
            if (maintainRequestDTO.getCaseNo() != null
                    && !"".equals(maintainRequestDTO.getCaseNo())) {
                maintainRequestDTO.setCaseNo(maintainRequestDTO.getCaseNo().toUpperCase());
            }
            if (maintainRequestDTO.getRequestId() == null || maintainRequestDTO.getRequestId() == 0) {
                CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
                caseRetrieveCriteriaDTO.setCaseNo(maintainRequestDTO.getCaseNo());
                caseRetrieveCriteriaDTO.setFunc(maintainRequestDTO.getFunc());
                List<Case> cases = getCaseDAO().retrieve(caseRetrieveCriteriaDTO);
                if (cases != null && cases.size() > 0) {
                    Case vCase = cases.get(0);

                    List<Doc> docs = null;
                    if (vCase.getCaseId() != null && vCase.getCaseId() != 0) {
                        docs = getDocDAO().findDocByCaseId(vCase.getCaseId());
                    }

                    serviceRequestDetail = ServiceRequestDetailDTOAssembler.toDto(vCase, docs);
                    serviceRequestDetail.getRequest().setSequenceNoForCase(
                            genSequenceNoForCase(vCase.getCaseId()));

                    ReqsType reqsType = getRequestTypeDAO().findRequestType(
                            RequestConstant.REQUEST_TYPE_ID_SER);
                    RequestTypeDTO serviceType = RequestTypeDTOAssembler.toDto(reqsType);
                    serviceRequestDetail.getRequest().setRequestType(serviceType);
                    HrnSchd latestHearingSchedule = getHearingScheduleDAO()
                            .findLatestHearingSchedule(vCase.getCaseId(),
                                    DbCommonUtil.getCurrentSystemDateTime());
                    if (latestHearingSchedule != null) {
                        serviceRequestDetail.getServiceRequest().setServiceBeforeDate(
                                SvdCommonUtil.getLatestDate(
                                        DbCommonUtil.getCurrentSystemDateTime(),
                                        SvdCommonUtil.addWorkingDate(
                                                latestHearingSchedule.getHrnSchdDate(), -3)));
                    }

                } else {
                    error(MessageConstant.CASE_NO_NOT_EXISTED + ":Case No."
                            + maintainRequestDTO.getCaseNo() + " doesn't existed!");
                    List<String> mainMsgParameters = new ArrayList<String>();
                    mainMsgParameters.add(maintainRequestDTO.getCaseNo());
                    BusinessMessage businessMessage = new BusinessMessage(
                            MessageConstant.CASE_NO_NOT_EXISTED, mainMsgParameters, null, "");
                    this.addMessage(businessMessage);
                    this.throwException(maintainRequestDTO.getErrorBoxComponentId());
                }
            } else {
                Reqs reqs = getRequestDAO().findRequest(maintainRequestDTO.getRequestId());
                Case vCase = reqs.getVcase();
                List<Doc> docs = null;
                if (vCase != null && vCase.getCaseId() != null && vCase.getCaseId() != 0) {
                    docs = getDocDAO().findDocByCaseId(reqs.getVcase().getCaseId());
                }
                if (maintainRequestDTO.isMakeNewRequestInd()) {
                    serviceRequestDetail = ServiceRequestDetailDTOAssembler.toDto(reqs, docs);
                    serviceRequestDetail = copyToNewServiceRequest(serviceRequestDetail);
                } else {
                    serviceRequestDetail = ServiceRequestDetailDTOAssembler.toDto(reqs, docs);
                }

            }

            // Update each document type of DocumentDraftDTO by the document type code of request
            // document
            if (!CommonUtil.isNullOrEmpty(serviceRequestDetail.getDocumentDrafts())) {
                for (DocumentDraftDTO documentDraftDTO : serviceRequestDetail.getDocumentDrafts()) {
                    String documentTypeCode = DocumentFileUtil.getDocumentTypeCode(documentDraftDTO
                            .getRequestDocument().getDocumentReferenceNo());
                    DocType docType = getDocumentTypeDAO().findByDocumentTypeCode(documentTypeCode);
                    documentDraftDTO.setDocumentType(DocumentTypeDTOAssembler.toDto(docType));
                }
            }

            serviceRequestDetail.setRequestServiceType(RequestServiceTypeDTOAssembler
                    .toDto(serviceRequestDetail.getRequest().getSequenceNoForCase()));

            serviceRequestDetail.setFunc(maintainRequestDTO.getFunc());
            // Set all control indicators
            if (serviceRequestDetail.getRequest() != null
                    && serviceRequestDetail.getRequest().getRequestStatusType() != null) {
                RequestStatusTypeDTO statusType = serviceRequestDetail.getRequest()
                        .getRequestStatusType();
                serviceRequestDetail.setAllowCompleteInd(AppServiceDocValidationUtil
                        .isAllowCompleteRequest(statusType));
                serviceRequestDetail.setAllowSaveDraftInd(AppServiceDocValidationUtil
                        .isAllowSaveDraftRequest(statusType));
                serviceRequestDetail.setAllowSubmitInd(AppServiceDocValidationUtil
                        .isAllowSubmitRequest(statusType));
                serviceRequestDetail.setAllowWithdrawInd(AppServiceDocValidationUtil
                        .isAllowWithdrawRequest(statusType));
                serviceRequestDetail.setSubmittedModeInd(AppServiceDocValidationUtil
                        .isSubmittedMode(statusType));
                serviceRequestDetail.setAllowUpdateServiceTypeInd(AppServiceDocValidationUtil
                        .isAllowUpdateServiceType(serviceRequestDetail.getFunc(),
                                serviceRequestDetail.getRequestServiceType()));
                if (serviceRequestDetail.getRequestResult() != null) {
                    serviceRequestDetail.setAllowProofOfServiceInd(AppServiceDocValidationUtil
                            .isAllowProofOfService(serviceRequestDetail.getRequestResult()
                                    .getBailiffTaskResultStatus()));
                }
            }
            if (!serviceRequestDetail.isSubmittedModeInd()) {
                serviceRequestDetail
                        .setServiceOfDocumentPanelMode(CommonConstant.COMMON_PANEL_MODE_EDIT);
                serviceRequestDetail
                        .setDocumentListPanelMode(CommonConstant.COMMON_PANEL_MODE_EDIT);
                serviceRequestDetail.setServiceResultPanelMode(CommonConstant.COMMON_PANEL_MODE_NA);
            } else {
                serviceRequestDetail
                        .setServiceOfDocumentPanelMode(CommonConstant.COMMON_PANEL_MODE_READONLY);
                serviceRequestDetail
                        .setDocumentListPanelMode(CommonConstant.COMMON_PANEL_MODE_READONLY);
                if (!RequestConstant.REQUEST_STATUS_COMPLETED.equals(serviceRequestDetail
                        .getRequest().getRequestStatusType().getRequestStatusTypeCode())
                        || RequestConstant.COURT_LEVEL_TYPE_DISTRICT.equals(serviceRequestDetail
                                .getFunc().getCourtLevelTypeCode())) {
                    serviceRequestDetail
                            .setServiceResultPanelMode(CommonConstant.COMMON_PANEL_MODE_READONLY);
                } else if (RequestConstant.COURT_LEVEL_TYPE_MAGISTRATES.equals(serviceRequestDetail
                        .getFunc().getCourtLevelTypeCode())) {
                    serviceRequestDetail
                            .setServiceResultPanelMode(CommonConstant.COMMON_PANEL_MODE_EDIT);
                }
            }
        }
        info("maintainRequest end returnVal: " + serviceRequestDetail);
        return serviceRequestDetail;
    }

    /**
     * Copy Details to Create a New Service Request
     * 
     * @param serviceRequestDetail
     * @return
     */
    private ServiceRequestDetailDTO copyToNewServiceRequest(
            ServiceRequestDetailDTO serviceRequestDetail) {
        RequestDTO request = serviceRequestDetail.getRequest();
        if (request != null) {
            request.setRequestId(null);
            request.setRegistrationNo(null);
            request.setRegistrationYear(null);
            request.setRegistrationSerialNo(null);
            request.setSequenceNoForCase(1);
            request.setRequestStatusType(new RequestStatusTypeDTO());
            request.setSubmissionDatetime(null);
            request.setAcceptanceDatetime(null);
        }

        ServiceRequestDTO serviceRequest = serviceRequestDetail.getServiceRequest();
        if (serviceRequest != null) {
            serviceRequest.setServiceRequestId(null);
            serviceRequest.setRequestId(null);
        }

        RequestAddressDTO requestAddress = serviceRequestDetail.getRequestAddress();
        if (requestAddress != null) {
            requestAddress.setRequestAddressId(null);
            requestAddress.setRequestId(null);
        }

        RequestParticipantRoleDTO requesterRequestParticipantRole = serviceRequestDetail
                .getRequesterRequestParticipantRole();
        if (requesterRequestParticipantRole != null) {
            requesterRequestParticipantRole.setRequestParticipantRoleId(null);
            requesterRequestParticipantRole.setRequestId(null);
        }

        RequestParticipantRoleDTO recipientRequestParticipantRole = serviceRequestDetail
                .getRecipientRequestParticipantRole();
        if (recipientRequestParticipantRole != null) {
            recipientRequestParticipantRole.setRequestParticipantRoleId(null);
            recipientRequestParticipantRole.setRequestId(null);
        }

        SpecialRequestDTO specialRequest = serviceRequestDetail.getSpecialRequest();
        if (specialRequest != null) {
            specialRequest.setSpecialRequestId(null);
            specialRequest.setRequestId(null);
        }

        List<DocumentRecordDTO> documentRecords = serviceRequestDetail.getDocumentRecords();
        if (!CommonUtil.isNullOrEmpty(documentRecords)) {
            for (DocumentRecordDTO documentRecordDTO : documentRecords) {
                RequestDocumentDTO requestDocument = documentRecordDTO.getRequestDocument();
                if (requestDocument != null) {
                    documentRecordDTO.getRequestDocument().setRequestDocumentId(null);
                    documentRecordDTO.getRequestDocument().setRequestId(null);
                }
            }
        }
        serviceRequestDetail.setRequestResult(null);
        return serviceRequestDetail;
    }

    /**
     * Save the draft of service request
     * 
     * @param serviceRequestDetail
     */
    public IdDTO saveDraftServiceRequest(ServiceRequestDetailDTO serviceRequestDetail)
            throws CriminalGenericException {
        IdDTO returnVal = new IdDTO();
        BusinessMessage businessMessage = AppServiceDocValidationUtil
                .validateSaveDraftServiceRequest(serviceRequestDetail);
        if (businessMessage == null) {
            ReqsStatusType darftStatus = getRequestStatusTypeDAO().findByRequestStatusTypeCode(
                    RequestConstant.REQUEST_STATUS_DRAFT);
            if (darftStatus != null && DbCommonUtil.isValidDbId(darftStatus.getReqsStatusTypeId())) {
                RequestStatusTypeDTO statusType = RequestStatusTypeDTOAssembler.toDto(darftStatus);
                serviceRequestDetail.getRequest().setRequestStatusType(statusType);
                RequestTypeDTO requestType = new RequestTypeDTO();
                requestType.setRequestTypeId(RequestConstant.REQUEST_TYPE_ID_SER);
                serviceRequestDetail.getRequest().setRequestType(requestType);
                serviceRequestDetail.getRequest().setSequenceNoForCase(1);
                saveServiceRequest(serviceRequestDetail);
            }
        } else {
            error(MessageConstant.SAVE_DRAFT_DISABLE + ":Can't save draft.");
            this.addMessage(businessMessage);
            this.throwException(serviceRequestDetail.getErrorBoxComponentId());
        }
        returnVal.setId(serviceRequestDetail.getRequest().getRequestId());

        return returnVal;
    }

    /**
     * Save the result of service request
     * 
     * @throws Exception
     */
    public IdDTO saveServiceRequestResult(ServiceRequestDetailDTO detailDTO) throws Exception {
        IdDTO returnVal = new IdDTO();
        RequestResultDTO requestResult = detailDTO.getRequestResult();
        BusinessMessage businessMessage = AppServiceDocValidationUtil
                .validateSaveRequestResult(requestResult);
        if (businessMessage == null) {
            ReqsRslt reqsRslt = toEntity(requestResult);
            if (DbCommonUtil.isValidDbId(reqsRslt.getBlfReqsRsltId())) {
                getReqsRsltDAO().merge(reqsRslt);
            } else {
                getReqsRsltDAO().persist(reqsRslt);
            }
            List<DocumentDTO> newReturnDocuments = detailDTO.getNewReturnDocuments();
            if (!CommonUtil.isNullOrEmpty(newReturnDocuments)) {
                for (DocumentDTO documentDTO : newReturnDocuments) {
                    int docId = DocumentFileUtil.createReturnDocument(getJudiciaryUser(), detailDTO
                            .getRequest().getCaseId(), documentDTO.getDocumentType()
                            .getDocumentTypeCode(), documentDTO.getDocumentReferenceNo());
                    DocumentRecordDTO documentRecordDTO = new DocumentRecordDTO();
                    documentRecordDTO.setSelectedDocumentInd(true);
                    documentRecordDTO.setReturnedDocumentInd(true);
                    DocumentDTO document = new DocumentDTO();
                    document.setDocumentId(docId);
                    documentRecordDTO.setDocument(document);
                    detailDTO.getDocumentRecords().add(documentRecordDTO);
                }
                saveRequestDocuments(detailDTO.getRequest().getRequestId(),
                        detailDTO.getDocumentRecords());
            }

        } else {
            error(MessageConstant.SAVE_REQUEST_RESULT_DISABLE
                    + ":Can't save service request result.");
            this.addMessage(businessMessage);
            this.throwException(detailDTO.getErrorBoxComponentId());
        }
        returnVal.setId(requestResult.getRequestId());
        return returnVal;
    }

    private ReqsRslt toEntity(RequestResultDTO dto) {
        ReqsRslt reqsRslt = null;
        if (DbCommonUtil.isValidDbId(dto.getRequestResultId())) {
            Timestamp version = dto.getVersion();
            reqsRslt = getReqsRsltDAO().find(ReqsRslt.class, dto.getRequestResultId(), version);
            reqsRslt.setPreviousVersion(version);
        } else {
            reqsRslt = new ReqsRslt();
        }
        if (DbCommonUtil.isValidDbId(dto.getRequestId())) {
            Reqs reqs = getRequestDAO().find(Reqs.class, dto.getRequestId());
            reqsRslt.setBlfReqs(reqs);
        }
        BailiffTaskResultStatusDTO resultStatus = dto.getBailiffTaskResultStatus();
        if (resultStatus != null
                && DbCommonUtil.isValidDbId(resultStatus.getBailiffTaskResultStatusId())) {
            BlfTaskRsltStatus blfTaskRsltStatus = getBailiffTaskResultStatusDAO().find(
                    BlfTaskRsltStatus.class, resultStatus.getBailiffTaskResultStatusId());
            reqsRslt.setRsltStatus(blfTaskRsltStatus);
        }
        reqsRslt.setEndorDate(dto.getEndorsementDate());
        BailiffTaskResultReasonDTO resultReason = dto.getBailiffTaskResultReason();
        if (resultReason != null
                && DbCommonUtil.isValidDbId(resultReason.getBailiffTaskResultReasonId())) {
            BlfTaskRsltRsn blfTaskRsltRsn = getBailiffTaskResultReasonDAO().find(
                    BlfTaskRsltRsn.class, resultReason.getBailiffTaskResultReasonId());
            reqsRslt.setRsltRsn(blfTaskRsltRsn);
        }
        reqsRslt.setServDate(dto.getServiceDate());
        reqsRslt.setServRtnDate(dto.getServiceReturnDate());
        reqsRslt.setBlfReqsRsltNote(dto.getRequestResultNotes());
        return reqsRslt;
    }

    /**
     * Submit the service request
     * 
     * @param serviceRequestDetail
     * @throws Exception
     */
    public IdDTO submitServiceRequest(ServiceRequestDetailDTO serviceRequestDetail)
            throws Exception {
        IdDTO returnVal = new IdDTO();
        BusinessMessage businessMessage = AppServiceDocValidationUtil
                .validateSaveDraftServiceRequest(serviceRequestDetail);
        if (businessMessage == null) {
            RequestDTO request = serviceRequestDetail.getRequest();
            // Determine request status
            String requestStatus = RequestConstant.REQUEST_STATUS_SUBMITTED;
            SummonNoti summonNoti = getSummonsNoticeDAO().findSummonsNoticeByCaseId(
                    serviceRequestDetail.getRequest().getCaseId());
            if (AppServiceDocValidationUtil.isSentPGBL(summonNoti)) {
                requestStatus = RequestConstant.REQUEST_STATUS_PENDING_SUBMIT;
            }

            Timestamp current = new Timestamp(DbCommonUtil.getCurrentSystemDateTime().getTime());
            if (RequestConstant.REQUEST_STATUS_SUBMITTED.equals(requestStatus)) {
                request.setSubmissionDatetime(current);
                if (RequestConstant.HANDLING_AGENT_BAILIFF.equals(request.getHandlingAgent()
                        .getHandlingAgentCode())) {
                    if (request.getRegistrationNo() == null
                            || "".equals(request.getRegistrationNo())) {
                        Calendar cal = Calendar.getInstance();
                        request.setRegistrationYear(cal.get(Calendar.YEAR));
                        String requestType = getCommonBO().getRequestTypeCode(
                                request.getRequestType().getRequestTypeId());
                        String bailiffSeqKey = "REG" + "|" + requestType + "|"
                                + request.getRegistrationYear();

                        Integer registrationSerialNo = getCommonBO().genNextBailiffSequenceNo(
                                bailiffSeqKey);
                        request.setRegistrationSerialNo(String.valueOf(registrationSerialNo));

                        request.setRegistrationNo(String.format(
                                RequestConstant.REGISTRATION_NO_PATTERN, requestType,
                                request.getRegistrationSerialNo(), request.getRegistrationYear()));
                    }
                } else {
                    request.setAcceptanceDatetime(current);
                    requestStatus = RequestConstant.REQUEST_STATUS_ACCEPTED;
                }

                // Re-generate documents
                serviceRequestDetail.setDocumentDrafts(generateDocuments(serviceRequestDetail));

                // Save draft document to ECF repository
                if (!CommonUtil.isNullOrEmpty(serviceRequestDetail.getDocumentDrafts())) {
                    for (DocumentDraftDTO documentDraft : serviceRequestDetail.getDocumentDrafts()) {
                        if (documentDraft.isSelectedDocumentInd()) {
                            String drn = DocumentFileUtil.getDrn(documentDraft.getRequestDocument()
                                    .getDocumentReferenceNo());
                            int documentId = DocumentFileUtil.createDocument(this
                                    .getJudiciaryUser(), serviceRequestDetail.getRequest()
                                    .getCaseId(), documentDraft.getDocumentType()
                                    .getDocumentTypeCode(), drn);
                            FileDTO file = DocumentFileUtil.getCfsFile(this.getJudiciaryUser(),
                                    documentDraft.getRequestDocument().getDocumentReferenceNo());
                            DocumentFileUtil.addEcfFile(this.getJudiciaryUser(), documentId, file);
                            
                            if (AppServiceDocValidationUtil.isRequestDocument(
                            			request.getHandlingAgent().getHandlingAgentCode(),
                            			documentDraft.getDocumentType().getDocumentTypeCode())) {
                            	
	                            DocumentDTO documentDTO = new DocumentDTO();
	                            documentDTO.setDocumentId(documentId);
	                            documentDTO.setDocumentReferenceNo(drn);
	
	                            DocumentRecordDTO documentRecordDTO = new DocumentRecordDTO();
	                            documentRecordDTO.setSelectedDocumentInd(true);
	                            documentRecordDTO.setReturnedDocumentInd(false);
	                            documentRecordDTO.setDocument(documentDTO);

	                            // Add the draft document to request document list
	                            serviceRequestDetail.getDocumentRecords().add(documentRecordDTO);
                            }

                            // Un-selected the document draft for deletion
                            documentDraft.setSelectedDocumentInd(false);
                            DocumentFileUtil.deleteCfsFile(this.getJudiciaryUser(), documentDraft
                                    .getRequestDocument().getDocumentReferenceNo());
                        }
                    }
                }
            }

            // Update 'Pending to Submit'/'Submitted'/'Accepted' request status
            // to RequestDTO
            ReqsStatusType statusType = getRequestStatusTypeDAO().findByRequestStatusTypeCode(
                    requestStatus);
            if (statusType != null && DbCommonUtil.isValidDbId(statusType.getReqsStatusTypeId())) {
                RequestStatusTypeDTO statusTypeDTO = RequestStatusTypeDTOAssembler
                        .toDto(statusType);
                request.setRequestStatusType(statusTypeDTO);
            }

            saveServiceRequest(serviceRequestDetail);

        } else {
            error(MessageConstant.SAVE_DRAFT_DISABLE + ":Can't save draft.");
            this.addMessage(businessMessage);
            this.throwException(serviceRequestDetail.getErrorBoxComponentId());
        }
        returnVal.setId(serviceRequestDetail.getRequest().getRequestId());
        return returnVal;
    }

    /**
     * Withdraw the service request
     * 
     * @param serviceRequestDetail
     */
    public IdDTO withdrawServiceRequest(ServiceRequestDetailDTO serviceRequestDetail) {
        BusinessMessage businessMessage = AppServiceDocValidationUtil
                .validateWithdrawRequest(serviceRequestDetail.getRequest());
        if (businessMessage != null) {
            this.addMessage(businessMessage);
            this.throwException(serviceRequestDetail.getErrorBoxComponentId());
        }
        if (RequestConstant.HANDLING_AGENT_BAILIFF.equals(serviceRequestDetail.getRequest().getHandlingAgent()        		
                .getHandlingAgentCode())) {
        	// send withdraw request to Bailiff
        } else {
	        ReqsStatusType type = getRequestStatusTypeDAO().findByRequestStatusTypeCode(
	                RequestConstant.REQUEST_STATUS_WITHDRAWN);
	        RequestStatusTypeDTO typeDTO = RequestStatusTypeDTOAssembler.toDto(type);
	        serviceRequestDetail.getRequest().setRequestStatusType(typeDTO);
	        Reqs reqs = toEntity(serviceRequestDetail.getRequest());
	        getRequestDAO().merge(reqs);
        }
        IdDTO returnVal = new IdDTO();
        returnVal.setId(serviceRequestDetail.getRequest().getRequestId());

        return returnVal;
    }

    public Reqs toEntity(RequestDTO request) {
        Reqs reqs = null;
        if (DbCommonUtil.isValidDbId(request.getRequestId())) {
            Timestamp version = request.getVersion();
            reqs = getRequestDAO().find(Reqs.class, request.getRequestId(), version);
            reqs.setPreviousVersion(version);
        } else {
            reqs = new Reqs();
        }
        reqs.setRegNo(request.getRegistrationNo());
        reqs.setRegYr(request.getRegistrationYear());
        reqs.setRegSerNo(request.getRegistrationSerialNo());
        Integer caseId = request.getCaseId();
        if (DbCommonUtil.isValidDbId(caseId)) {
            Case vcase = getCaseDAO().find(Case.class, caseId);
            reqs.setVcase(vcase);
            if (vcase.getCompsCourt() != null) {
                reqs.setCourtSys(vcase.getCompsCourt().getCompsCourtCd());
            }
            if (vcase.getCaseType() != null) {
                reqs.setCaseType(vcase.getCaseType().getCaseTypeCd());
            }
            reqs.setCaseSerNo(vcase.getCaseSerNo());
            reqs.setCaseYr(vcase.getCaseYr());
        }
        RequestTypeDTO requestType = request.getRequestType();
        if (requestType != null && DbCommonUtil.isValidDbId(requestType.getRequestTypeId())) {
            ReqsType reqsType = getRequestTypeDAO().find(ReqsType.class,
                    requestType.getRequestTypeId());
            reqs.setReqsType(reqsType);
        }
        reqs.setSubmitDt(request.getSubmissionDatetime());
        reqs.setAcptDt(request.getAcceptanceDatetime());
        reqs.setSeqNoForCase(request.getSequenceNoForCase());
        HandlingAgentDTO handlingAgent = request.getHandlingAgent();
        if (handlingAgent != null && DbCommonUtil.isValidDbId(handlingAgent.getHandlingAgentId())) {
            HandlingAgt handlingAgt = getHandlingAgentDAO().find(HandlingAgt.class,
                    handlingAgent.getHandlingAgentId());
            reqs.setHandlingAgt(handlingAgt);
        }
        RequestStatusTypeDTO requestStatusType = request.getRequestStatusType();
        if (requestStatusType != null
                && DbCommonUtil.isValidDbId(requestStatusType.getRequestStatusTypeId())) {
            ReqsStatusType reqsStatusType = getRequestStatusTypeDAO().find(ReqsStatusType.class,
                    requestStatusType.getRequestStatusTypeId());
            reqs.setReqsStatus(reqsStatusType);
        }
        reqs.setSeqNoForCase(request.getSequenceNoForCase());
        BailiffOfficeDTO bailiffOffice = request.getBailiffOffice();
        if (bailiffOffice != null && DbCommonUtil.isValidDbId(bailiffOffice.getBailiffOfficeId())) {
            BlfOffice blfOffice = getBailiffOfficeDAO().find(BlfOffice.class,
                    bailiffOffice.getBailiffOfficeId());
            reqs.setBlfOffice(blfOffice);
        } else {
            reqs.setBlfOffice(null);
        }
        return reqs;
    }

    /**
     * Generate sequence no for case of request
     * 
     * @param caseId
     * @return
     */
    public Integer genSequenceNoForCase(Integer caseId) {
        Integer returnVal = 0;
        List<ServReqs> latestServReqs = getServiceRequestDAO().findLatestServiceRequestByCaseId(
                caseId);
        // Determine the sequence no for case
        if (CommonUtil.isNullOrEmpty(latestServReqs)) {
            returnVal = 1;
        } else {
            ServReqs servReqs = latestServReqs.get(0);
            if (servReqs.getReqs() != null && servReqs.getReqs().getSeqNoForCase() != null) {
                returnVal = servReqs.getReqs().getSeqNoForCase();
                if ((servReqs.getServBefDate() != null && servReqs.getServBefDate().before(
                        new Date()))
                        || (servReqs.getReqs().getReqsStatus() != null && RequestConstant.REQUEST_STATUS_COMPLETED
                                .equals(servReqs.getReqs().getReqsStatus().getReqsStatusTypeCd()))) {
                    returnVal += 1;
                }
            }
        }
        return returnVal;
    }

    /**
     * Generate Special Request DTO with urgent type
     * 
     * @return
     */
    public SpecialRequestDTO genUrgentSpecialRequestDTO() {
        SpecialRequestDTO returnVal = new SpecialRequestDTO();
        SpecialReqsType urgentStatus = getSpecialRequestTypeDAO().findBySpecialRequestTypeCode(
                RequestConstant.SPECIAL_REQUEST_TYPE_URGENT);
        returnVal.setSpecialRequestType(SpecialRequestTypeDTOAssembler.toDto(urgentStatus));
        return returnVal;
    }

    private void saveRequestSection(ServiceRequestDetailDTO serviceRequestDetail) {
        RequestDTO requestDTO = serviceRequestDetail.getRequest();
        if (requestDTO != null) {
            if (requestDTO.getSequenceNoForCase().equals(1)) {
                requestDTO.setSequenceNoForCase(serviceRequestDetail.getRequestServiceType()
                        .getRequestServiceType());
            }
            Reqs reqs = toEntity(requestDTO);
            if (DbCommonUtil.isValidDbId(reqs.getReqsId())) {
                getRequestDAO().merge(reqs);
            } else {
                getRequestDAO().persist(reqs);
                requestDTO.setRequestId(reqs.getReqsId());
            }
        }
    }

    private void saveServiceRequestSection(ServiceRequestDetailDTO serviceRequestDetail) {
        Integer requestId = serviceRequestDetail.getRequest().getRequestId();
        ServiceRequestDTO serviceRequestDTO = serviceRequestDetail.getServiceRequest();
        if (serviceRequestDTO == null) {
            serviceRequestDTO = new ServiceRequestDTO();
        }
        boolean serviceRequestDTOEmpty = !DbCommonUtil.isValidDbId(serviceRequestDTO
                .getServiceRequestId());
        if (serviceRequestDTOEmpty) {
            serviceRequestDTO.setRequestId(requestId);
            ServReqs servReqs = toEntity(serviceRequestDTO);
            getServiceRequestDAO().persist(servReqs);
            serviceRequestDTO.setServiceRequestId(servReqs.getServReqsId());
        } else {
            ServReqs servReqs = toEntity(serviceRequestDTO);
            getServiceRequestDAO().merge(servReqs);
        }
    }

    private void saveSpecialRequestSection(ServiceRequestDetailDTO serviceRequestDetail) {
        Integer requestId = serviceRequestDetail.getRequest().getRequestId();
        SpecialRequestDTO specialRequestDTO = serviceRequestDetail.getSpecialRequest();
        boolean specialRequestDTOEmpty = (specialRequestDTO == null || !DbCommonUtil
                .isValidDbId(specialRequestDTO.getSpecialRequestId()));
        if (serviceRequestDetail.isUrgentRequireInd() && specialRequestDTOEmpty) {
            specialRequestDTO = genUrgentSpecialRequestDTO();
            specialRequestDTO.setRequestId(requestId);
            SpecialReqs specialReqs = toEntity(specialRequestDTO);
            getSpecialRequestDAO().persist(specialReqs);
        } else if (!serviceRequestDetail.isUrgentRequireInd() && !specialRequestDTOEmpty) {
            SpecialReqs specialReqs = toEntity(specialRequestDTO);
            getSpecialRequestDAO().remove(specialReqs);
        }
    }

    private void saveRequestAddressSection(ServiceRequestDetailDTO serviceRequestDetail) {
        Integer requestId = serviceRequestDetail.getRequest().getRequestId();
        RequestAddressDTO requestAddressDTO = serviceRequestDetail.getRequestAddress();
        if (requestAddressDTO == null) {
            requestAddressDTO = new RequestAddressDTO();
        }
        boolean requestAddressDTOEmpty = !DbCommonUtil.isValidDbId(requestAddressDTO
                .getRequestAddressId());
        if (requestAddressDTOEmpty) {
            requestAddressDTO.setRequestId(requestId);
            requestAddressDTO.setPrimaryAddressInd(true);
            requestAddressDTO.setActionAddressInd(true);
            ReqsAddr reqsAddr = toEntity(requestAddressDTO);
            getRequestAddressDAO().persist(reqsAddr);
            requestAddressDTO.setRequestAddressId(reqsAddr.getReqsAddrId());
        } else {
            ReqsAddr reqsAddr = toEntity(requestAddressDTO);
            getRequestAddressDAO().merge(reqsAddr);
        }
    }

    private void saveDraftDocuments(ServiceRequestDetailDTO serviceRequestDetail) {
        Integer requestId = serviceRequestDetail.getRequest().getRequestId();

        List<DocumentDraftDTO> documentDraftDTOs = serviceRequestDetail.getDocumentDrafts();
        if (!CommonUtil.isNullOrEmpty(documentDraftDTOs)) {
            for (DocumentDraftDTO documentDraftDTO : documentDraftDTOs) {
                RequestDocumentDTO requestDocumentDTO = documentDraftDTO.getRequestDocument();
                requestDocumentDTO.setRequestId(requestId);
                ReqsDoc reqsDoc = toEntity(requestDocumentDTO);

                if (documentDraftDTO.isSelectedDocumentInd()) {
                    if (!DbCommonUtil.isValidDbId(requestDocumentDTO.getRequestDocumentId())) {
                        getRequestDocumentDAO().persist(reqsDoc);
                        requestDocumentDTO.setRequestDocumentId(reqsDoc.getReqsDocId());
                    } else {
                        getRequestDocumentDAO().merge(reqsDoc);
                    }
                } else {
                    if (DbCommonUtil.isValidDbId(requestDocumentDTO.getRequestDocumentId())) {
                        getRequestDocumentDAO().remove(reqsDoc);
                    }
                }
            }
        }

    }

    private void saveRequestDocuments(Integer requestId, List<DocumentRecordDTO> documentRecords)
            throws CriminalGenericException {
        BlfDocStatusType blfDocStatusType = getBailiffDocumentStatusTypeDAO()
                .findByBailiffDocumentStatusTypeCode(RequestConstant.BAILIFF_DOC_STATUS_RECEIVED);
        Integer documentSequenceNo = 1;
        if (!CommonUtil.isNullOrEmpty(documentRecords)) {
            for (DocumentRecordDTO documentRecordDTO : documentRecords) {
                RequestDocumentDTO requestDocumentDTO = documentRecordDTO.getRequestDocument();
                boolean requestDocumentDTOEmpty = (requestDocumentDTO == null || !DbCommonUtil
                        .isValidDbId(requestDocumentDTO.getRequestDocumentId()));
                if (documentRecordDTO.isSelectedDocumentInd()) {
                    if (requestDocumentDTOEmpty) {
                        RequestDocumentDTO newRequestDocumentDTO = new RequestDocumentDTO();
                        newRequestDocumentDTO.setRequestId(requestId);
                        newRequestDocumentDTO.setDocumentSeqNo(documentSequenceNo++);
                        newRequestDocumentDTO.setDocumentId(documentRecordDTO.getDocument()
                                .getDocumentId());
                        newRequestDocumentDTO.setDocumentReferenceNo(documentRecordDTO
                                .getDocument().getDocumentReferenceNo());
                        newRequestDocumentDTO.setBailiffDocumentStatusId(blfDocStatusType
                                .getBlfDocStatusTypeId());
                        newRequestDocumentDTO.setActionRequestInd(true);
                        newRequestDocumentDTO.setPrintedInd(false);
                        newRequestDocumentDTO.setReturnedDocumentInd(documentRecordDTO
                                .isReturnedDocumentInd());
                        newRequestDocumentDTO.setReceiveDate(new Date());
                        newRequestDocumentDTO.setHardcopyInd(false);
                        ReqsDoc reqsDoc = toEntity(newRequestDocumentDTO);
                        getRequestDocumentDAO().persist(reqsDoc);
                        newRequestDocumentDTO.setRequestDocumentId(reqsDoc.getReqsDocId());
                        documentRecordDTO.setRequestDocument(newRequestDocumentDTO);
                    } else if (!requestDocumentDTOEmpty) {
                        requestDocumentDTO.setDocumentSeqNo(documentSequenceNo++);
                        ReqsDoc reqsDoc = toEntity(requestDocumentDTO);
                        getRequestDocumentDAO().merge(reqsDoc);
                    }
                } else {
                    if (!requestDocumentDTOEmpty) {
                        ReqsDoc reqsDoc = toEntity(documentRecordDTO.getRequestDocument());
                        getRequestDocumentDAO().remove(reqsDoc);
                    }
                }
            }
        }
    }

    private void saveRequestParticipantRoleSection(ServiceRequestDetailDTO serviceRequestDetail,
            Integer indicator) {
        Integer requestId = serviceRequestDetail.getRequest().getRequestId();
        PartyDTO partyDTO = null;
        RequestParticipantRoleDTO requestParticipantRoleDTO = null;
        if (RequestConstant.REQUEST_REQUESTER.equals(indicator)) {
            partyDTO = serviceRequestDetail.getRequester();
            requestParticipantRoleDTO = serviceRequestDetail.getRequesterRequestParticipantRole();
        } else if (RequestConstant.REQUEST_RECIPIENT.equals(indicator)) {
            partyDTO = serviceRequestDetail.getRecipient();
            requestParticipantRoleDTO = serviceRequestDetail.getRecipientRequestParticipantRole();
        }

        boolean partyEmpty = (partyDTO != null && DbCommonUtil.isValidDbId(partyDTO
                .getParticipantId()));
        boolean requestParticipantRoleEmpty = (requestParticipantRoleDTO != null && DbCommonUtil
                .isValidDbId(requestParticipantRoleDTO.getRequestParticipantRoleId()));
        if (partyEmpty && !requestParticipantRoleEmpty) {
            RequestParticipantRoleDTO newRequestParticipantRoleDTO = new RequestParticipantRoleDTO();
            newRequestParticipantRoleDTO.setRequestId(requestId);
            newRequestParticipantRoleDTO.setParticipantId(partyDTO.getParticipantId());
            newRequestParticipantRoleDTO.setOriginalParticipantRoleId(partyDTO
                    .getParticipantRoleId());
            newRequestParticipantRoleDTO.setPartyCategoryId(partyDTO.getPartyCategoryId());
            newRequestParticipantRoleDTO.setParticipantRoleTypeId(partyDTO.getParticipantRoleType()
                    .getParticipantRoleTypeId());
            newRequestParticipantRoleDTO.setRespondentSeqNo(partyDTO.getRespondentSeqNo());
            newRequestParticipantRoleDTO.setRespondentSubSeqNo(partyDTO.getRespondentSubSeqNo());
            newRequestParticipantRoleDTO.setRecipientRequesterIndicator(indicator);
            ReqsPartcpRole reqsPartcpRole = toEntity(newRequestParticipantRoleDTO);
            getRequestParticipantRoleDAO().persist(reqsPartcpRole);
            newRequestParticipantRoleDTO.setRequestParticipantRoleId(reqsPartcpRole
                    .getReqsPartcpRoleId());
            serviceRequestDetail.setRequesterRequestParticipantRole(newRequestParticipantRoleDTO);
        } else if (partyEmpty && requestParticipantRoleEmpty) {
            if (!partyDTO.getParticipantRoleId().equals(
                    requestParticipantRoleDTO.getRequestParticipantRoleId())) {
                ReqsPartcpRole reqsPartcpRole = toEntity(requestParticipantRoleDTO);
                getRequestParticipantRoleDAO().merge(reqsPartcpRole);
            }
        } else if (!partyEmpty && requestParticipantRoleEmpty) {
            ReqsPartcpRole reqsPartcpRole = toEntity(requestParticipantRoleDTO);
            getRequestParticipantRoleDAO().remove(reqsPartcpRole);
        }
    }

    private void saveRequesterSection(ServiceRequestDetailDTO serviceRequestDetail) {
        saveRequestParticipantRoleSection(serviceRequestDetail, RequestConstant.REQUEST_REQUESTER);
    }

    private void saveRecipientSection(ServiceRequestDetailDTO serviceRequestDetail) {
        saveRequestParticipantRoleSection(serviceRequestDetail, RequestConstant.REQUEST_RECIPIENT);
    }

    /**
     * Save Service Request
     * 
     * @param serviceRequestDetail
     */
    public void saveServiceRequest(ServiceRequestDetailDTO serviceRequestDetail)
            throws CriminalGenericException {
        BusinessMessage businessMessage = AppServiceDocValidationUtil
                .validateSaveServiceRequest(serviceRequestDetail);
        if (businessMessage == null) {
            // Remove all not necessary data before save
            String handAgtCode = serviceRequestDetail.getRequest().getHandlingAgent()
                    .getHandlingAgentCode();
            if (RequestConstant.HANDLING_AGENT_BAILIFF.equals(handAgtCode)) {
                serviceRequestDetail.getServiceRequest().setPostOffice(null);
                serviceRequestDetail.getServiceRequest().setRegisteredMailBarcode(null);
                serviceRequestDetail.setUrgentRequireInd(false);
            } else if (RequestConstant.HANDLING_AGENT_HKPF.equals(handAgtCode)) {
                serviceRequestDetail.getRequest().setBailiffOffice(null);
                serviceRequestDetail.getServiceRequest().setPostOffice(null);
                serviceRequestDetail.getServiceRequest().setRegisteredMailBarcode(null);
            } else if (RequestConstant.HANDLING_AGENT_POST_OFFICE.equals(handAgtCode)) {
                serviceRequestDetail.getRequest().setBailiffOffice(null);
                serviceRequestDetail.getServiceRequest().setDeliveryInstruction(null);
                serviceRequestDetail.setUrgentRequireInd(false);
            }
            if (!RequestConstant.SERVICE_MODE_TYPE_PERSONAL.equals(serviceRequestDetail
                    .getServiceRequest().getServiceModeType().getServiceModeTypeCode().trim())) {
                serviceRequestDetail.getServiceRequest().setDeliveryInstruction(null);
            }

            // Save Request
            saveRequestSection(serviceRequestDetail);

            // Save Service Request
            saveServiceRequestSection(serviceRequestDetail);

            // Save Special Request
            saveSpecialRequestSection(serviceRequestDetail);

            // Save Request Address
            saveRequestAddressSection(serviceRequestDetail);

            // Save Draft Documents
            saveDraftDocuments(serviceRequestDetail);

            // Save the Request Documents
            saveRequestDocuments(serviceRequestDetail.getRequest().getRequestId(),
                    serviceRequestDetail.getDocumentRecords());

            // Save Requester
            saveRequesterSection(serviceRequestDetail);

            // Save Recipient
            saveRecipientSection(serviceRequestDetail);

        } else {
            error(MessageConstant.SAVE_SERVICE_REQUEST_DISABLE + ":Can't save service request.");
            this.addMessage(businessMessage);
            this.throwException(serviceRequestDetail.getErrorBoxComponentId());
        }
    }

    private ServReqs toEntity(ServiceRequestDTO dto) {
        ServReqs servReqs = null;
        if (DbCommonUtil.isValidDbId(dto.getServiceRequestId())) {
            Timestamp version = dto.getVersion();
            servReqs = getServiceRequestDAO().find(ServReqs.class, dto.getServiceRequestId(),
                    version);
            servReqs.setPreviousVersion(version);
        } else {
            servReqs = new ServReqs();
        }

        if (DbCommonUtil.isValidDbId(dto.getRequestId())) {
            Reqs reqs = getRequestDAO().find(Reqs.class, dto.getRequestId());
            servReqs.setReqs(reqs);
        }
        if (dto.isRequireAffirmationInd()) {
            servReqs.setAffidavitReqFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            servReqs.setAffidavitReqFlag(CommonConstant.COMMON_FLAG_FALSE);
        }
        servReqs.setServBefDate(dto.getServiceBeforeDate());
        ParticipantRoleTypeDTO roleTypeDto = dto.getParticipantRoleType();
        if (roleTypeDto != null && DbCommonUtil.isValidDbId(roleTypeDto.getParticipantRoleTypeId())) {
            PartcpRoleType recipPartcpRoleType = getParticipantRoleTypeDAO().find(
                    PartcpRoleType.class, roleTypeDto.getParticipantRoleTypeId());
            servReqs.setRecipPartcpRoleType(recipPartcpRoleType);
        }
        servReqs.setRecipSurname(dto.getEnglishRecipientSurname());
        servReqs.setRecipGivenName(dto.getEnglishRecipientGivenName());
        servReqs.setRecipSurnameChin(dto.getChineseRecipientSurname());
        servReqs.setRecipGivenNameChin(dto.getChineseRecipientGivenName());
        servReqs.setDlvryInstr(dto.getDeliveryInstruction());
        servReqs.setRegMailBarcd(dto.getRegisteredMailBarcode());
        ServiceModeTypeDTO serviceModeTypeDto = dto.getServiceModeType();
        if (serviceModeTypeDto != null
                && DbCommonUtil.isValidDbId(serviceModeTypeDto.getServiceModeTypeId())) {
            ServModeType servModeType = getServiceModeTypeDAO().find(ServModeType.class,
                    serviceModeTypeDto.getServiceModeTypeId());
            servReqs.setServMode(servModeType);
        }
        PostOfficeDTO postOfficeDTO = dto.getPostOffice();
        if (postOfficeDTO != null && DbCommonUtil.isValidDbId(postOfficeDTO.getPostOfficeId())) {
            PostOffice postOffice = getPostOfficeDAO().find(PostOffice.class,
                    postOfficeDTO.getPostOfficeId());
            servReqs.setPostOffice(postOffice);
        } else {
            servReqs.setPostOffice(null);
        }
        return servReqs;
    }

    private SpecialReqs toEntity(SpecialRequestDTO dto) {
        SpecialReqs specialReqs = null;
        if (DbCommonUtil.isValidDbId(dto.getSpecialRequestId())) {
            Timestamp version = dto.getVersion();
            specialReqs = getSpecialRequestDAO().find(SpecialReqs.class, dto.getSpecialRequestId(),
                    version);
            specialReqs.setPreviousVersion(version);
        } else {
            specialReqs = new SpecialReqs();
        }

        if (DbCommonUtil.isValidDbId(dto.getRequestId())) {
            Reqs reqs = getRequestDAO().find(Reqs.class, dto.getRequestId());
            specialReqs.setReqs(reqs);
        }
        SpecialRequestTypeDTO specialRequestTypeDTO = dto.getSpecialRequestType();
        if (specialRequestTypeDTO != null
                && DbCommonUtil.isValidDbId(specialRequestTypeDTO.getSpecialRequestTypeId())) {
            SpecialReqsType specialReqsType = getSpecialRequestTypeDAO().find(
                    SpecialReqsType.class, specialRequestTypeDTO.getSpecialRequestTypeId());
            specialReqs.setSpecialReqsType(specialReqsType);
        }
        return specialReqs;
    }

    public ReqsAddr toEntity(RequestAddressDTO dto) {
        ReqsAddr reqsAddr = null;
        if (DbCommonUtil.isValidDbId(dto.getRequestAddressId())) {
            Timestamp version = dto.getVersion();
            reqsAddr = getRequestAddressDAO().find(ReqsAddr.class, dto.getRequestAddressId(),
                    version);
            reqsAddr.setPreviousVersion(version);
        } else {
            reqsAddr = new ReqsAddr();
        }

        if (DbCommonUtil.isValidDbId(dto.getRequestId())) {
            Reqs reqs = getRequestDAO().find(Reqs.class, dto.getRequestId());
            reqsAddr.setReqs(reqs);
        }
        reqsAddr.setAddrLine1(dto.getEnglishAddress1());
        reqsAddr.setAddrLine2(dto.getEnglishAddress2());
        reqsAddr.setAddrLine3(dto.getEnglishAddress3());
        reqsAddr.setAddrLine1Chin(dto.getChineseAddress1());
        reqsAddr.setAddrLine2Chin(dto.getChineseAddress2());
        reqsAddr.setAddrLine3Chin(dto.getChineseAddress3());
        if (dto.isPrimaryAddressInd()) {
            reqsAddr.setPriAddrFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            reqsAddr.setPriAddrFlag(CommonConstant.COMMON_FLAG_FALSE);
        }
        if (dto.isActionAddressInd()) {
            reqsAddr.setActAddrFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            reqsAddr.setActAddrFlag(CommonConstant.COMMON_FLAG_FALSE);
        }
        if (dto.isForeignAddressInd()) {
            reqsAddr.setFgnAddrFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            reqsAddr.setFgnAddrFlag(CommonConstant.COMMON_FLAG_FALSE);
        }

        BailiffOfficeDTO bailiffOfficeDTO = dto.getBailiffOffice();
        if (bailiffOfficeDTO != null
                && DbCommonUtil.isValidDbId(bailiffOfficeDTO.getBailiffOfficeId())) {
            BlfOffice blfOffice = getBailiffOfficeDAO().find(BlfOffice.class,
                    bailiffOfficeDTO.getBailiffOfficeId());
            reqsAddr.setBlfOffice(blfOffice);
        }
        HkDistrictDTO hkDistrictDTO = dto.getHkDistrict();
        if (hkDistrictDTO != null && DbCommonUtil.isValidDbId(hkDistrictDTO.getHkDistrictId())) {
            HkDist hkDist = getHkDistrictDAO().find(HkDist.class, hkDistrictDTO.getHkDistrictId());
            reqsAddr.setHkDist(hkDist);
        }
        HkRegionDTO hkRegionDTO = dto.getHkRegion();
        if (hkRegionDTO != null && DbCommonUtil.isValidDbId(hkRegionDTO.getHkRegionId())) {
            HkRgn hkRgn = getHkRegionDAO().find(HkRgn.class, hkRegionDTO.getHkRegionId());
            reqsAddr.setHkRgn(hkRgn);
        }
        return reqsAddr;
    }

    public ReqsDoc toEntity(RequestDocumentDTO dto) {
        ReqsDoc reqsDoc = null;
        if (DbCommonUtil.isValidDbId(dto.getRequestDocumentId())) {
            Timestamp version = dto.getVersion();
            reqsDoc = getRequestDocumentDAO().find(ReqsDoc.class, dto.getRequestDocumentId(),
                    version);
            reqsDoc.setPreviousVersion(version);
        } else {
            reqsDoc = new ReqsDoc();
        }

        if (DbCommonUtil.isValidDbId(dto.getRequestId())) {
            Reqs reqs = getRequestDAO().find(Reqs.class, dto.getRequestId());
            reqsDoc.setBlfReqs(reqs);
        }
        reqsDoc.setDocSeqNo(dto.getDocumentSeqNo());

        if (DbCommonUtil.isValidDbId(dto.getDocumentId())) {
            Doc doc = getDocDAO().find(Doc.class, dto.getDocumentId());
            reqsDoc.setDoc(doc);
        }

        if (DbCommonUtil.isValidDbId(dto.getBailiffDocumentStatusId())) {
            BlfDocStatusType blfDocStatusType = getBailiffDocumentStatusTypeDAO().find(
                    BlfDocStatusType.class, dto.getBailiffDocumentStatusId());
            reqsDoc.setBlfDocStatusType(blfDocStatusType);
        }

        reqsDoc.setAdmAndSuppFileId(dto.getAdminSupportFileId());

        reqsDoc.setDocRefNo(dto.getDocumentReferenceNo());

        if (dto.isActionRequestInd()) {
            reqsDoc.setActReqFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            reqsDoc.setActReqFlag(CommonConstant.COMMON_FLAG_FALSE);
        }

        if (dto.isPrintedInd()) {
            reqsDoc.setPrtFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            reqsDoc.setPrtFlag(CommonConstant.COMMON_FLAG_FALSE);
        }

        if (dto.isReturnedDocumentInd()) {
            reqsDoc.setRtnDocFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            reqsDoc.setRtnDocFlag(CommonConstant.COMMON_FLAG_FALSE);
        }

        // if (dto.isHardcopyInd()) {
        // reqsDoc.setHardcopyFlag(CommonConstant.COMMON_FLAG_TRUE);
        // } else {
        // reqsDoc.setHardcopyFlag(CommonConstant.COMMON_FLAG_FALSE);
        // }

        reqsDoc.setRecvDate(dto.getReceiveDate());
        reqsDoc.setIssueDate(dto.getIssueDate());

        return reqsDoc;
    }

    public ReqsPartcpRole toEntity(RequestParticipantRoleDTO dto) {
        ReqsPartcpRole reqsPartcpRole = null;
        if (DbCommonUtil.isValidDbId(dto.getRequestParticipantRoleId())) {
            Timestamp version = dto.getVersion();
            reqsPartcpRole = getRequestParticipantRoleDAO().find(ReqsPartcpRole.class,
                    dto.getRequestParticipantRoleId(), version);
            reqsPartcpRole.setPreviousVersion(version);
        } else {
            reqsPartcpRole = new ReqsPartcpRole();
        }

        if (DbCommonUtil.isValidDbId(dto.getRequestId())) {
            Reqs reqs = getRequestDAO().find(Reqs.class, dto.getRequestId());
            reqsPartcpRole.setReqs(reqs);
        }
        if (DbCommonUtil.isValidDbId(dto.getParticipantId())) {
            Partcp partcp = getParticipantDAO().find(Partcp.class, dto.getParticipantId());
            reqsPartcpRole.setPartcp(partcp);
        }
        if (DbCommonUtil.isValidDbId(dto.getOriginalParticipantRoleId())) {
            PartcpRole partcpRole = getParticipantRoleDAO().find(PartcpRole.class,
                    dto.getOriginalParticipantRoleId());
            reqsPartcpRole.setOrigPartcpRole(partcpRole);
            reqsPartcpRole.setPtyCat(partcpRole.getPtyCat());
        }
        if (DbCommonUtil.isValidDbId(dto.getParticipantRoleTypeId())) {
            PartcpRoleType partcpRoleType = getParticipantRoleTypeDAO().find(PartcpRoleType.class,
                    dto.getParticipantRoleTypeId());
            reqsPartcpRole.setPartcpRoleType(partcpRoleType);
        }
        reqsPartcpRole.setRespondentSeqNo(dto.getRespondentSeqNo());
        reqsPartcpRole.setRespondentSubseqNo(dto.getRespondentSubSeqNo());
        reqsPartcpRole.setRecipReqserInd(dto.getRecipientRequesterIndicator());
        return reqsPartcpRole;
    }

    /**
     * Search the proof of service requests according to inputted criteria
     * 
     * @param searchDTO
     * @return
     */
    public List<PosRequestSearchResultDTO> searchPosRequestList(PosRequestSearchDTO searchDTO) {
        info("searchPosRequestList() start - " + searchDTO);

        if (searchDTO.getSubmitStartDate() != null) {
            searchDTO.setSubmitStartDate(DbCommonUtil.getStartDateTime(searchDTO
                    .getSubmitStartDate()));
        }
        if (searchDTO.getSubmitEndDate() != null) {
            searchDTO.setSubmitEndDate(DbCommonUtil.getEndDateTime(searchDTO.getSubmitEndDate()));
        }
        if (searchDTO.getCaseNo() != null && !"".equals(searchDTO.getCaseNo())) {
            searchDTO.setCaseNo(searchDTO.getCaseNo().toUpperCase());
        }
        List<Reqs> reqs = getRequestDAO().findRequestListByPosRequestSearch(searchDTO);
        List<PosRequestSearchResultDTO> returnVal = PosRequestSearchResultDTOAssembler
                .toDtoList(reqs);
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
        PosRequestDetailDTO returnVal = new PosRequestDetailDTO();
        // search-->detail
        if (!maintainRequestDTO.isMakeNewRequestInd() && maintainRequestDTO.getRequestId() != null
                && maintainRequestDTO.getRequestId() > 0) {
            ProofOfServReqs proofOfServReqs = getPosRequestDAO().findPosRequest(
                    maintainRequestDTO.getRequestId());
            if (proofOfServReqs != null && proofOfServReqs.getProofOfServReqsId() > 0) {
                returnVal = PosRequestDetailDTOAssembler.toDto(proofOfServReqs);
            }
        } else {
            Reqs reqs = null;
            // search-->new
            if ((maintainRequestDTO.getRequestId() == null)
                    || (maintainRequestDTO.getRequestId().intValue() <= 0)) {
                reqs = getRequestDAO().findLastSuccessServiceRequestByCaseNo(maintainRequestDTO);
                // service of document detail -->proof of service
            } else if (maintainRequestDTO.isMakeNewRequestInd()) {
                reqs = getRequestDAO().findSuccessServiceRequestByRequestId(maintainRequestDTO);
            }
            if (reqs == null) {
                error(MessageConstant.NO_SUCC_SERVREQ + ":No successful service request is found.");
                this.addMessage(new BusinessMessage(MessageConstant.NO_SUCC_SERVREQ, ""));
                this.throwException(maintainRequestDTO.getErrorBoxComponentId());
            } else {
                HandlingAgt handlingAgt = reqs.getHandlingAgt();
                if (handlingAgt == null
                        || (!RequestConstant.HANDLING_AGENT_BAILIFF.equals(handlingAgt
                                .getHandlingAgtCd()) && !RequestConstant.HANDLING_AGENT_HKPF
                                .equals(handlingAgt.getHandlingAgtCd()))) {
                    error(MessageConstant.PROOF_EXISTED
                            + ":The service request is NOT served by Bailiff or Police.");
                    this.addMessage(new BusinessMessage(MessageConstant.NOT_SERVEDBY_BAI_OR_POLI,
                            ""));
                    this.throwException(maintainRequestDTO.getErrorBoxComponentId());
                }
                if (reqs.getServReqs() != null) {
                    ProofOfServReqs proofOfServReqs = getPosRequestDAO()
                            .findPosRequestByServiceRequestId(reqs.getServReqs().getServReqsId());
                    if (proofOfServReqs != null) {
                        error(MessageConstant.PROOF_EXISTED
                                + ":The proof of service request for the successful service request has been already created.");
                        this.addMessage(new BusinessMessage(MessageConstant.PROOF_EXISTED, ""));
                        this.throwException(maintainRequestDTO.getErrorBoxComponentId());
                    }
                }

                if (reqs.getBlfTask() != null) {
                    returnVal = PosRequestDetailDTOAssembler.toDto(reqs);

                    ReqsType reqsType = getRequestTypeDAO().findRequestType(
                            RequestConstant.REQUEST_TYPE_ID_POS);
                    returnVal.getRequest().setRequestType(RequestTypeDTOAssembler.toDto(reqsType));

                    IntlUserAc intlUserAc = getIntlUserAcDAO().findInternalLoginUser();
                    if (intlUserAc != null) {
                        returnVal.getPosRequest().setRequestedBy(intlUserAc.getIntlUserAcId());
                    }
                }
            }
        }
        returnVal.setFunc(maintainRequestDTO.getFunc());
        if (returnVal.getRequest() != null && returnVal.getRequest().getRequestStatusType() != null) {
            if (AppServiceDocValidationUtil.isAllowSubmitRequest(returnVal.getRequest()
                    .getRequestStatusType())) {
                returnVal.setPosPanelMode(CommonConstant.COMMON_PANEL_MODE_READONLY);
            } else {
                returnVal.setPosPanelMode(CommonConstant.COMMON_PANEL_MODE_EDIT);
            }
        }
        return returnVal;
    }

    /**
     * Submit the proof of service request
     * 
     * @param posRequestDetailDTO
     * @return
     */
    public IdDTO submitPosRequest(PosRequestDetailDTO posRequestDetailDTO) {
        BusinessMessage businessMessage = AppServiceDocValidationUtil
                .validateSubmitPosRequest(posRequestDetailDTO);
        RequestDTO request = posRequestDetailDTO.getRequest();
        if (businessMessage == null) {
            // Save Request
            if (!DbCommonUtil.isValidDbId(posRequestDetailDTO.getRequest().getRequestId())) {
                savePosReqsSection(posRequestDetailDTO);
            }

            // Save ProofOfServReqs
            saveProofOfServReqsSection(posRequestDetailDTO);
        } else {
            error("");
        }
        IdDTO returnVal = new IdDTO();
        returnVal.setId(request.getRequestId());
        return returnVal;
    }

    private void savePosReqsSection(PosRequestDetailDTO posRequestDetailDTO) {
        RequestDTO request = posRequestDetailDTO.getRequest();
        Timestamp curr = new Timestamp(DbCommonUtil.getCurrentSystemDateTime().getTime());
        String requestStatus = RequestConstant.REQUEST_STATUS_SUBMITTED;
        if (!RequestConstant.HANDLING_AGENT_BAILIFF.equals(request.getHandlingAgent()
                .getHandlingAgentCode())) {
            requestStatus = RequestConstant.REQUEST_STATUS_ACCEPTED;
            request.setAcceptanceDatetime(curr);
        } else {
            Calendar cal = Calendar.getInstance();
            request.setRegistrationYear(cal.get(Calendar.YEAR));
            String requestType = getCommonBO().getRequestTypeCode(
                    request.getRequestType().getRequestTypeId());
            String bailiffSeqKey = "REG" + "|" + requestType + "|" + request.getRegistrationYear();

            Integer registrationSerialNo = getCommonBO().genNextBailiffSequenceNo(bailiffSeqKey);
            request.setRegistrationSerialNo(String.valueOf(registrationSerialNo));

            request.setRegistrationNo(String.format(RequestConstant.REGISTRATION_NO_PATTERN,
                    requestType, request.getRegistrationSerialNo(), request.getRegistrationYear()));
        }

        ReqsStatusType reqsStatusType = getRequestStatusTypeDAO().findByRequestStatusTypeCode(
                requestStatus);
        request.setRequestStatusType(RequestStatusTypeDTOAssembler.toDto(reqsStatusType));

        request.setSubmissionDatetime(curr);

        Reqs reqs = toEntity(request);
        getRequestDAO().persist(reqs);
        request.setRequestId(reqs.getReqsId());
    }

    private void saveProofOfServReqsSection(PosRequestDetailDTO posRequestDetailDTO) {
        Integer requestId = posRequestDetailDTO.getRequest().getRequestId();
        PosRequestDTO posRequest = posRequestDetailDTO.getPosRequest();
        posRequest.setRequestId(requestId);
        if (posRequest.isPosDocumentInd()) {
            posRequest.setPosHearingDatetime(null);
            posRequest.setComprisingCourt(null);
            posRequest.setCourtRoomChambers(null);
        } else if (posRequest.isAttendCourtPersonInd()) {
            posRequest.setPosDocumentDueDate(null);
            posRequest.setPosDocumentType(null);
        }
        ProofOfServReqs proofOfServReqs = toEntity(posRequest);
        if (DbCommonUtil.isValidDbId(proofOfServReqs.getProofOfServReqsId())) {
            getPosRequestDAO().merge(proofOfServReqs);
        } else {
            getPosRequestDAO().persist(proofOfServReqs);
            posRequestDetailDTO.getPosRequest().setPosRequestId(
                    proofOfServReqs.getProofOfServReqsId());
        }
    }

    private ProofOfServReqs toEntity(PosRequestDTO dto) {
        ProofOfServReqs proofOfServReqs = null;
        if (DbCommonUtil.isValidDbId(dto.getPosRequestId())) {
            Timestamp version = dto.getVersion();
            proofOfServReqs = getPosRequestDAO().find(ProofOfServReqs.class, dto.getPosRequestId(),
                    version);
            proofOfServReqs.setPreviousVersion(version);
        } else {
            proofOfServReqs = new ProofOfServReqs();
        }
        proofOfServReqs.setProofByDocDueDate(dto.getPosDocumentDueDate());
        proofOfServReqs.setProofOfServHrnDt(dto.getPosHearingDatetime());
        if (dto.isPosDocumentInd()) {
            proofOfServReqs.setProofOfDocFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            proofOfServReqs.setProofOfDocFlag(CommonConstant.COMMON_FLAG_FALSE);
        }
        if (dto.isAttendCourtPersonInd()) {
            proofOfServReqs.setAttdCourtInPersonFlag(CommonConstant.COMMON_FLAG_TRUE);
        } else {
            proofOfServReqs.setAttdCourtInPersonFlag(CommonConstant.COMMON_FLAG_FALSE);
        }
        PosDocumentTypeDTO posDocumentType = dto.getPosDocumentType();
        ProofOfServDocType proofByDocType = null;
        if (posDocumentType != null && posDocumentType.getPosDocumentTypeId() != null
                && posDocumentType.getPosDocumentTypeId().intValue() > 0) {
            proofByDocType = getPosDocumentTypeDAO().find(ProofOfServDocType.class,
                    posDocumentType.getPosDocumentTypeId());
        }
        proofOfServReqs.setProofByDocType(proofByDocType);
        if (dto.getRequestedBy() != null && dto.getRequestedBy().intValue() > 0) {
            IntlUserAc intlUserAc = getIntlUserAcDAO().find(IntlUserAc.class, dto.getRequestedBy());
            proofOfServReqs.setReqsBy(intlUserAc);
        }
        if (dto.getSuccessfulTaskId() != null && dto.getSuccessfulTaskId().intValue() > 0) {
            BlfTask blfTask = getBailiffTaskDAO().find(BlfTask.class, dto.getSuccessfulTaskId());
            proofOfServReqs.setSuccessTask(blfTask);
        }
        if (dto.getRequestId() != null && dto.getRequestId().intValue() > 0) {
            Reqs reqs = getRequestDAO().find(Reqs.class, dto.getRequestId());
            proofOfServReqs.setReqs(reqs);
        }
        if (dto.getServiceRequestId() != null && dto.getServiceRequestId().intValue() > 0) {
            ServReqs servReqs = getServiceRequestDAO().find(ServReqs.class,
                    dto.getServiceRequestId());
            proofOfServReqs.setServReqs(servReqs);
        }
        CompsCourt compsCourt = null;
        if (dto.getComprisingCourt() != null
                && DbCommonUtil.isValidDbId(dto.getComprisingCourt().getComprisingCourtId())) {
            compsCourt = getComprisingCourtDAO().find(CompsCourt.class,
                    dto.getComprisingCourt().getComprisingCourtId());
        }
        proofOfServReqs.setCompsCourt(compsCourt);
        CourtRmChmbr courtRmChmbr = null;
        if (dto.getCourtRoomChambers() != null
                && DbCommonUtil.isValidDbId(dto.getCourtRoomChambers().getCourtRoomChambersId())) {
            courtRmChmbr = getCourtRmChmbrDAO().find(CourtRmChmbr.class,
                    dto.getCourtRoomChambers().getCourtRoomChambersId());
        }
        proofOfServReqs.setCourtRmChmbr(courtRmChmbr);
        return proofOfServReqs;
    }

    /**
     * Search the re-service requests in batch according to inputted criteria
     * 
     * @param searchDTO
     * @return
     */
    public List<ReserviceBatchSearchResultDTO> searchReserviceBatchList(BatchSearchDTO searchDTO) {
        info("searchReserviceBatchList() start - " + searchDTO);
        List<ReserviceBatchSearchResultDTO> returnVal = new ArrayList<ReserviceBatchSearchResultDTO>();

        Integer batchSeqNo = 0;
        List<HrnDtl> hrnDtls = getHearingDetailDAO().findHearingDetailListByBatchSearch(searchDTO,
                HearingConstant.HEARING_RESULT_RESERVICE);
        if (!CommonUtil.isNullOrEmpty(hrnDtls)) {
            for (HrnDtl hrnDtl : hrnDtls) {
                HrnSchd hrnSchd = null;
                if (hrnDtl.getHrnSchd() != null) {
                    hrnSchd = getHearingScheduleDAO().findLatestHearingSchedule(
                            hrnDtl.getVcase().getCaseId(), hrnDtl.getHrnSchd().getHrnSchdDate());
                }
                ReserviceBatchSearchResultDTO resultDTO = new ReserviceBatchSearchResultDTO();
                batchSeqNo++;
                resultDTO.setBatchSeqNo(batchSeqNo);
                resultDTO.setFunc(searchDTO.getFunc());
                resultDTO
                        .setNextHearingDetail(NextHearingDetailDTOAssembler.toDto(hrnDtl, hrnSchd));
                if (!CommonUtil.isNullOrEmpty(hrnDtl.getStnceOrdr())) {
                    resultDTO.setReserviceRequestDetail(maintainReserviceRequest(
                            resultDTO.getNextHearingDetail(), hrnDtl.getStnceOrdr().get(0)
                                    .getStnceOrdrId()));
                }
                resultDTO.setRecordMode(getRecordMode(resultDTO.getNextHearingDetail()));
                returnVal.add(resultDTO);
            }
        }
        info("searchReserviceBatchList() end - " + returnVal);
        return returnVal;
    }

    /**
     * Generate the next hearing date
     * 
     * @param generationDTO
     * @return
     */
    public NextHearingDetailDTO generateNextHearingDate(NextHearingDateGenerationDTO generationDTO) {
        NextHearingDetailDTO nextHearingDetailDTO = generationDTO.getNextHearingDetail();
        if (generationDTO.getDayFromAllocation() != null
                && generationDTO.getDayFromAllocation().intValue() > 0) {
            nextHearingDetailDTO.setDayFromAllocation(generationDTO.getDayFromAllocation());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nextHearingDetailDTO.getOriginalHearingDate());
            calendar.add(Calendar.DATE, nextHearingDetailDTO.getDayFromAllocation());
            nextHearingDetailDTO.setHearingScheduleDate(calendar.getTime());
        }

        nextHearingDetailDTO = HearingScheduleUtil.updateNextHearingDetail(this.getJudiciaryUser(),
                nextHearingDetailDTO);

        return nextHearingDetailDTO;
    }

    /**
     * Confirm hearing schedule
     * 
     * @param resultDTO
     * @return
     * @throws Exception
     */
    public ReserviceBatchSearchResultDTO confirmHearingSchedule(
            ReserviceBatchSearchResultDTO resultDTO) throws Exception {
        boolean bl = HearingScheduleUtil.confirmHearingSchedule(this.getJudiciaryUser(),
                resultDTO.getNextHearingDetail());
        if (bl) {
            HrnSchd hrnSchd = getHearingScheduleDAO().findLatestHearingSchedule(
                    resultDTO.getNextHearingDetail().getCaseId(),
                    resultDTO.getNextHearingDetail().getHearingScheduleDate());
           if (hrnSchd != null) {
               resultDTO.getNextHearingDetail().setHearingScheduleId(hrnSchd.getHrnSchdId());
               resultDTO.setRecordMode(getRecordMode(resultDTO.getNextHearingDetail()));
           }else{
               error("No hearing schedule found.");
           }
        }
        return resultDTO;
    }

    /**
     * Maintain service request for re-service
     * 
     * @param detailDTO
     * @param func
     * @return
     */
    public ServiceRequestDetailDTO maintainRequestForReservice(ReserviceRequestDetailDTO detailDTO,
            FunctionDTO func) {
        MaintainRequestDTO maintainRequestDTO = new MaintainRequestDTO();
        maintainRequestDTO.setRequestId(detailDTO.getRequest().getRequestId());
        maintainRequestDTO.setFunc(func);
        maintainRequestDTO.setCaseNo(detailDTO.getRequest().getCaseNo());
        ServiceRequestDetailDTO serviceRequestDetailDTO = maintainRequest(maintainRequestDTO);

        ServiceRequestDTO serviceRequest = serviceRequestDetailDTO.getServiceRequest();
        RequestDTO request = serviceRequestDetailDTO.getRequest();
        if (request != null && !DbCommonUtil.isValidDbId(request.getRequestId())) {
            serviceRequestDetailDTO.setRequestServiceType(RequestServiceTypeDTOAssembler
                    .toDto(RequestConstant.REQUEST_SERVICE_TYPE_RESERVICE));
            if (!CommonUtil.isNullOrEmpty(serviceRequestDetailDTO.getRequesters())) {
                serviceRequestDetailDTO
                        .setRequester(serviceRequestDetailDTO.getRequesters().get(0));
            }
            PartyDTO recipient = detailDTO.getRecipient();
            if (serviceRequest != null && recipient != null) {
                serviceRequestDetailDTO.setRecipient(recipient);
                serviceRequest.setParticipantRoleType(recipient.getParticipantRoleType());
                serviceRequest.setEnglishRecipientGivenName(recipient.getEnglishGivenName());
                serviceRequest.setEnglishRecipientSurname(recipient.getEnglishSurname());
                serviceRequest.setChineseRecipientGivenName(recipient.getChineseGivenName());
                serviceRequest.setChineseRecipientSurname(recipient.getChineseSurname());
            }
        }

        if (request != null) {
            request.setHandlingAgent(detailDTO.getRequest().getHandlingAgent());
            request.setBailiffOffice(detailDTO.getRequest().getBailiffOffice());
        }

        if (serviceRequest != null && detailDTO.getServiceRequest() != null) {
            serviceRequest.setServiceModeType(detailDTO.getServiceRequest().getServiceModeType());
            serviceRequest.setRegisteredMailBarcode(detailDTO.getServiceRequest()
                    .getRegisteredMailBarcode());
            serviceRequest.setDeliveryInstruction(detailDTO.getServiceRequest()
                    .getDeliveryInstruction());
        }
        serviceRequestDetailDTO.setRequestAddress(detailDTO.getRequestAddress());
        return serviceRequestDetailDTO;
    }

    /**
     * Maintain re-service request
     * 
     * @param maintainRequestDTO
     * @return
     */
    public ReserviceRequestDetailDTO maintainReserviceRequest(MaintainRequestDTO maintainRequestDTO) {
        return maintainReserviceRequest(maintainRequestDTO.getRequestId(), null);
    }

    /**
     * Maintain re-service request
     * 
     * @param nextHearingDetailDTO
     * @return
     */
    public ReserviceRequestDetailDTO maintainReserviceRequest(
            NextHearingDetailDTO nextHearingDetailDTO, Integer stnceOrdrId) {
        ReserviceRequestDetailDTO reserviceRequestDetailDTO = maintainReserviceRequest(0,
                nextHearingDetailDTO.getCaseId());
        if (reserviceRequestDetailDTO.getRequest() != null
                && !DbCommonUtil.isValidDbId(reserviceRequestDetailDTO.getRequest().getRequestId())) {
            reserviceRequestDetailDTO.setRecipient(nextHearingDetailDTO.getDefendant());
            boolean dopSummons = AppServiceDocValidationUtil.isDopSummons(nextHearingDetailDTO
                    .getCaseNo());
            if (dopSummons) {
                HandlingAgt handlingAgt = getHandlingAgentDAO().findByHandlingAgentCode(
                        RequestConstant.HANDLING_AGENT_POST_OFFICE);
                reserviceRequestDetailDTO.getRequest().setHandlingAgent(
                        HandlingAgentDTOAssembler.toDto(handlingAgt));
                ServModeType servModeType = getServiceModeTypeDAO().findByServiceModeTypeCode(
                        RequestConstant.SERVICE_MODE_TYPE_REG_POST);
                reserviceRequestDetailDTO.getServiceRequest().setServiceModeType(
                        ServiceModeTypeDTOAssembler.toDto(servModeType));
            }
            AddressDTO defaultAddr = null;
            if ((reserviceRequestDetailDTO.getRequestAddress() == null || !DbCommonUtil
                    .isValidDbId(reserviceRequestDetailDTO.getRequestAddress()
                            .getRequestAddressId()))
                    && reserviceRequestDetailDTO.getRecipient() != null) {
                List<AddressRoleDTO> addressRoles = reserviceRequestDetailDTO.getRecipient()
                        .getAddressRoles();
                if (!CommonUtil.isNullOrEmpty(addressRoles)) {
                    for (AddressRoleDTO addressRoleDTO : addressRoles) {
                        if (addressRoleDTO.isPostalServiceInd()) {
                            defaultAddr = addressRoleDTO.getAddress();
                            break;
                        }
                    }
                }
            }

            if (defaultAddr != null) {
                RequestAddressDTO requestAddressDTO = new RequestAddressDTO();
                requestAddressDTO.setEnglishAddress1(defaultAddr.getEnglishAddress1());
                requestAddressDTO.setEnglishAddress2(defaultAddr.getEnglishAddress2());
                requestAddressDTO.setEnglishAddress3(defaultAddr.getEnglishAddress3());
                requestAddressDTO.setChineseAddress1(defaultAddr.getChineseAddress1());
                requestAddressDTO.setChineseAddress2(defaultAddr.getChineseAddress2());
                requestAddressDTO.setChineseAddress3(defaultAddr.getChineseAddress3());
                requestAddressDTO.setHkRegion(defaultAddr.getHkRegion());
                requestAddressDTO.setHkDistrict(defaultAddr.getHkDistrict());
                requestAddressDTO.setForeignAddressInd(defaultAddr.isForeignAddressInd());
                reserviceRequestDetailDTO.setRequestAddress(requestAddressDTO);
            }

            StnceOrdrToDoc stnceOrdrToDoc = getSentenceOrderToDocumentDAO()
                    .findSentenceOrderToDocumentBySentenceOrderId(stnceOrdrId);
            if (stnceOrdrToDoc != null) {
                reserviceRequestDetailDTO.getServiceRequest().setServiceModeType(
                        ServiceModeTypeDTOAssembler.toDto(stnceOrdrToDoc.getServMode()));
                reserviceRequestDetailDTO.getServiceRequest().setDeliveryInstruction(
                        stnceOrdrToDoc.getServSpecialInstr());
            }

        }
        return reserviceRequestDetailDTO;
    }

    /**
     * Maintain re-service request
     * 
     * @param requestId
     * @param caseId
     * @return
     */
    public ReserviceRequestDetailDTO maintainReserviceRequest(Integer requestId, Integer caseId) {
        ReserviceRequestDetailDTO reserviceRequestDetailDTO = new ReserviceRequestDetailDTO();
        Reqs reqs = null;
        if (DbCommonUtil.isValidDbId(requestId)) {
            reqs = getRequestDAO().findRequest(requestId);
        } else if (DbCommonUtil.isValidDbId(caseId)) {
            reqs = getRequestDAO().findReserviceRequest(caseId);
        }

        boolean isGeneratedSummons = false;
        if (reqs != null && DbCommonUtil.isValidDbId(reqs.getReqsId())) {
            reserviceRequestDetailDTO = ReserviceRequestDetailDTOAssembler.toDto(reqs);

            if (!CommonUtil.isNullOrEmpty(reqs.getReqsDoc())) {
                for (ReqsDoc reqsDoc : reqs.getReqsDoc()) {
                    String docTypeCode = null;

                    if (!CommonUtil.isNullOrEmpty(reqsDoc.getDoc())) {
                        docTypeCode = reqsDoc.getDoc().getDocType().getDocTypeCd();
                    } else if (!CommonUtil.isNullOrEmpty(reqsDoc.getDocRefNo())) {
                        docTypeCode = DocumentFileUtil.getDocumentTypeCode(reqsDoc.getDocRefNo());
                    }

                    if (!CommonUtil.isNullOrEmpty(docTypeCode)
                            && AppServiceDocValidationUtil.isSummonsDocumentType(docTypeCode)) {
                        isGeneratedSummons = true;
                        break;
                    }
                }
            }
        } else {
            Case vCase = getCaseDAO().find(Case.class, caseId);
            reserviceRequestDetailDTO = ReserviceRequestDetailDTOAssembler.toDto(vCase);
        }

        reserviceRequestDetailDTO.setSummonsGeneratedInd(isGeneratedSummons);

        RequestDTO request = reserviceRequestDetailDTO.getRequest();
        if (request != null && request.getRequestStatusType() != null) {
            boolean dopSummons = AppServiceDocValidationUtil.isDopSummons(request.getCaseNo());
            if (dopSummons
                    && (reserviceRequestDetailDTO.getServiceRequest().getServiceModeType() != null && !RequestConstant.SERVICE_MODE_TYPE_REG_POST
                            .equals(reserviceRequestDetailDTO.getServiceRequest()
                                    .getServiceModeType().getServiceModeTypeCode()))) {
                reserviceRequestDetailDTO.setAllowSaveDraftInd(false);
                reserviceRequestDetailDTO.setAllowSubmitInd(false);
            } else {
                reserviceRequestDetailDTO.setAllowSaveDraftInd(AppServiceDocValidationUtil
                        .isAllowSaveDraftRequest(request.getRequestStatusType()));
                reserviceRequestDetailDTO.setAllowSubmitInd(AppServiceDocValidationUtil
                        .isAllowSubmitRequest(request.getRequestStatusType()));
            }
        }
        return reserviceRequestDetailDTO;
    }

    /**
     * Generate the certificate of bulk posting
     * 
     * @param postingDTO
     * @return
     */
    public FileDTO generateCertificateBulkPosting(CertifcateBulkPostingDTO postingDTO)
            throws CriminalGenericException {
        // report RPT-SVD-CERT-POS-BK
        ReportResultPackDTO reportResultPack = getReportBO().genRptSvdCertPosBk(postingDTO);
        return DocumentFileUtil.generateFileDTO(reportResultPack.getReportResult());
    }

    /**
     * Save the draft of re-service request and select to generate the re-service summons and other
     * documents for the request
     * 
     * @param reserviceBatchSearchResultDTO
     * @param isNeedGenDoc
     * @return IdDTO
     * @throws Exception
     */
    public IdDTO saveDraftReserviceRequestAndGenerateDocuments(
            ReserviceBatchSearchResultDTO resultDTO, Boolean isNeedGenDoc) throws Exception {
        ServiceRequestDetailDTO serviceRequestDetailDTO = maintainRequestForReservice(
                resultDTO.getReserviceRequestDetail(), resultDTO.getFunc());

        if (isNeedGenDoc) {
            serviceRequestDetailDTO.setDocumentDrafts(generateDocuments(serviceRequestDetailDTO));
        }

        return saveDraftServiceRequest(serviceRequestDetailDTO);
    }

    /**
     * Save the draft of re-service request and generate the re-service summons and other documents
     * for the request
     * 
     * @param reserviceBatchSearchResultDTO
     * @return IdDTO
     * @throws Exception
     */
    public IdDTO saveDraftReserviceRequestAndGenerateDocuments(
            ReserviceBatchSearchResultDTO resultDTO) throws Exception {
        return saveDraftReserviceRequestAndGenerateDocuments(resultDTO, true);
    }

    /**
     * Save the draft of re-service request
     * 
     * @param reserviceBatchSearchResultDTO
     * @return IdDTO
     * @throws Exception
     */
    public IdDTO saveDraftReserviceRequest(ReserviceBatchSearchResultDTO resultDTO)
            throws Exception {
        return saveDraftReserviceRequestAndGenerateDocuments(resultDTO, false);
    }

    /**
     * Get record mode
     * 
     * @param nextHearingDetailDTO
     * @return
     */
    public String getRecordMode(NextHearingDetailDTO nextHearingDetailDTO) {
        String recordMode;
        if (!DbCommonUtil.isValidDbId(nextHearingDetailDTO.getHearingScheduleId())) {
            recordMode = CommonConstant.RECORD_MODE_SCHEDULE_NEXT_HEARING;
        } else {
            if (AppServiceDocValidationUtil.isDopSummons(nextHearingDetailDTO.getCaseNo())) {
                recordMode = CommonConstant.RECORD_MODE_GENERATE_DOP_SUMMONS_RESERVICE;
            } else {
                recordMode = CommonConstant.RECORD_MODE_GENERATE_RESERVICE;
            }
        }
        return recordMode;
    }

    /**
     * Submit re-service request
     * 
     * @param reserviceBatchSearchResultDTO
     * @return
     * @throws Exception
     */
    public IdDTO submitReserviceRequest(ReserviceBatchSearchResultDTO resultDTO) throws Exception {
        ServiceRequestDetailDTO serviceRequestDetailDTO = maintainRequestForReservice(
                resultDTO.getReserviceRequestDetail(), resultDTO.getFunc());
        return submitServiceRequest(serviceRequestDetailDTO);
    }

    /**
     * Search the proof of service requests in batch according to inputted criteria
     * 
     * @param searchDTO
     * @return
     */
    public List<PosRequestDetailDTO> searchPosRequestBatchList(BatchSearchDTO searchDTO) {
        info("searchPosRequestBatchList() start - " + searchDTO);
        List<PosRequestDetailDTO> posRequestDetailDTOs = new ArrayList<PosRequestDetailDTO>();

        List<HrnDtl> hrnDtls = getHearingDetailDAO().findHearingDetailListByBatchSearch(searchDTO,
                HearingConstant.HEARING_RESULT_PROOF_OF_SERVICE);

        if (!CommonUtil.isNullOrEmpty(hrnDtls)) {
            for (HrnDtl hrnDtl : hrnDtls) {
                MaintainRequestDTO maintainRequestDTO = new MaintainRequestDTO();
                maintainRequestDTO.setFunc(searchDTO.getFunc());
                maintainRequestDTO.setCaseNo(SvdCommonUtil.getCaseNo(hrnDtl.getVcase()));

                try {
                    PosRequestDetailDTO posRequestDetailDTO = maintainPosRequest(maintainRequestDTO);
                    posRequestDetailDTOs.add(posRequestDetailDTO);
                } catch (Exception e) {
                    info("Cannot generate POS request for the case no. : "
                            + maintainRequestDTO.getCaseNo());
                }
            }
        }

        info("searchPosRequestBatchList() end - " + posRequestDetailDTOs);
        return posRequestDetailDTOs;
    }

}
