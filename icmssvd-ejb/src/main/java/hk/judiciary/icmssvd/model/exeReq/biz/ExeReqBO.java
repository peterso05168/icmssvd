package hk.judiciary.icmssvd.model.exeReq.biz;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import hk.judiciary.fmk.common.exception.BusinessMessage;
import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.BlfDocStatusType;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.Doc;
import hk.judiciary.icms.model.dao.entity.DocType;
import hk.judiciary.icms.model.dao.entity.ExecReqs;
import hk.judiciary.icms.model.dao.entity.HandlingAgt;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsAddr;
import hk.judiciary.icms.model.dao.entity.ReqsDoc;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icms.model.dao.entity.ReqsStatusType;
import hk.judiciary.icms.model.dao.entity.ReqsType;
import hk.judiciary.icmssvd.model.BaseBO;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.biz.CommonBO;
import hk.judiciary.icmssvd.model.common.biz.assembler.HandlingAgentDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestStatusTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.RequestTypeDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.common.dao.BailiffDocumentStatusTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.DocumentTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.HandlingAgentDAO;
import hk.judiciary.icmssvd.model.common.dao.RequestParticipantRoleDAO;
import hk.judiciary.icmssvd.model.common.dao.RequestStatusTypeDAO;
import hk.judiciary.icmssvd.model.common.dao.RequestTypeDAO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.courtCase.biz.dto.criteria.CaseRetrieveCriteriaDTO;
import hk.judiciary.icmssvd.model.courtCase.dao.CaseDAO;
import hk.judiciary.icmssvd.model.exeReq.biz.assembler.ExecutionRequestDetailDTOAssembler;
import hk.judiciary.icmssvd.model.exeReq.biz.assembler.ExecutionRequestSearchResultDTOAssembler;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDetailDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.exeReq.dao.ExecutionRequestDAO;
import hk.judiciary.icmssvd.model.exeReq.util.AppExecutionValidationUtil;
import hk.judiciary.icmssvd.model.svdReq.MessageConstant;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.SvdReqBO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentRecordDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.MaintainRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PartyDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestAddressDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDocumentDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestParticipantRoleDTO;
import hk.judiciary.icmssvd.model.svdReq.dao.DocDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.RequestAddressDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.RequestDAO;
import hk.judiciary.icmssvd.model.svdReq.dao.RequestDocumentDAO;

/**
 * 
 * @version $Revision: 4833 $ $Date: 2017-03-02 17:46:43 +0800 (Thu, 02 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class ExeReqBO extends BaseBO {
    public static final String NAME = "exeReqBO";

    private CommonBO getCommonBO() {
        return getBO(CommonBO.NAME, CommonBO.class);
    }

    private SvdReqBO getSvdReqBO() {
        return getBO(SvdReqBO.NAME, SvdReqBO.class);
    }

    private RequestTypeDAO getRequestTypeDAO() {
        return getDAO(RequestTypeDAO.REQS_TYPE_DAO, RequestTypeDAO.class);
    }

    private DocDAO getDocDAO() {
        return getDAO(DocDAO.DOC_DAO, DocDAO.class);
    }

    private HandlingAgentDAO getHandlingAgentDAO() {
        return getDAO(HandlingAgentDAO.HANDLING_AGT_DAO, HandlingAgentDAO.class);
    }

    private RequestDAO getRequestDAO() {
        return getDAO(RequestDAO.REQUEST_DAO, RequestDAO.class);
    }

    private RequestStatusTypeDAO getRequestStatusTypeDAO() {
        return getDAO(RequestStatusTypeDAO.REQS_STATUS_TYPE_DAO, RequestStatusTypeDAO.class);
    }

    private ExecutionRequestDAO getExecutionRequestDAO() {
        return getDAO(ExecutionRequestDAO.EXECUTION_REQUEST_DAO, ExecutionRequestDAO.class);
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

    private DocumentTypeDAO getDocumentTypeDAO() {
        return getDAO(DocumentTypeDAO.DOC_TYPE_DAO, DocumentTypeDAO.class);
    }

    private CaseDAO getCaseDAO() {
        return getDAO(CaseDAO.CASE_DAO, CaseDAO.class);
    }

    private BailiffDocumentStatusTypeDAO getBailiffDocumentStatusTypeDAO() {
        return getDAO(BailiffDocumentStatusTypeDAO.BAILIFF_DOCUMENT_STATUSTYPE_DAO,
                BailiffDocumentStatusTypeDAO.class);
    }

    /**
     * Search the execution requests according to inputted criteria
     * 
     * @param searchDTO
     * @return
     */
    public List<ExecutionRequestSearchResultDTO> searchExecutionRequestList(
            ExecutionRequestSearchDTO searchDTO) {
        info("searchExecutionRequestList() start - " + searchDTO);
        if (searchDTO.getSubmitStartDate() != null) {
            searchDTO.setSubmitStartDate(DbCommonUtil.getStartDateTime(searchDTO
                    .getSubmitStartDate()));
        }
        if (searchDTO.getSubmitEndDate() != null) {
            searchDTO.setSubmitEndDate(DbCommonUtil.getEndDateTime(searchDTO.getSubmitEndDate()));
        }
        List<Reqs> reqs = getRequestDAO().findRequestListByExecutionRequestSearch(searchDTO);
        List<ExecutionRequestSearchResultDTO> returnVal = ExecutionRequestSearchResultDTOAssembler
                .toDtoList(reqs);
        info("searchExecutionRequestList() end - " + returnVal);
        return returnVal;
    }

    /**
     * Maintain execution request
     * 
     * @param maintainRequestDTO
     * @return
     */
    public ExecutionRequestDetailDTO maintainExecutionRequest(MaintainRequestDTO maintainRequestDTO) {
        info("maintainExecutionRequest() start - " + maintainRequestDTO);
        ExecutionRequestDetailDTO executionRequestDetailDTO = new ExecutionRequestDetailDTO();
        if (DbCommonUtil.isValidDbId(maintainRequestDTO.getRequestId())) {
            Reqs reqs = getRequestDAO().findRequest(maintainRequestDTO.getRequestId());
            List<Doc> docs = getDocDAO().findDocByCaseId(reqs.getVcase().getCaseId());
            executionRequestDetailDTO = ExecutionRequestDetailDTOAssembler.toDto(reqs, docs);
        } else {
            CaseRetrieveCriteriaDTO caseRetrieveCriteriaDTO = new CaseRetrieveCriteriaDTO();
            caseRetrieveCriteriaDTO.setCaseNo(maintainRequestDTO.getCaseNo());
            caseRetrieveCriteriaDTO.setFunc(maintainRequestDTO.getFunc());
            List<Case> cases = getCaseDAO().retrieve(caseRetrieveCriteriaDTO);
            if (cases != null && cases.size() > 0) {
                Case vCase = cases.get(0);
                List<Doc> docs = getDocDAO().findDocByCaseId(vCase.getCaseId());
                executionRequestDetailDTO = ExecutionRequestDetailDTOAssembler.toDto(vCase, docs);
                RequestDTO request = executionRequestDetailDTO.getRequest();
                request.setSequenceNoForCase(getSvdReqBO().genSequenceNoForCase(vCase.getCaseId()));
                ReqsType reqsType = getRequestTypeDAO().findRequestType(
                        RequestConstant.REQUEST_TYPE_ID_EXE);
                request.setRequestType(RequestTypeDTOAssembler.toDto(reqsType));
                HandlingAgt handlingAgt = getHandlingAgentDAO().findByHandlingAgentCode(
                        RequestConstant.HANDLING_AGENT_BAILIFF);
                request.setHandlingAgent(HandlingAgentDTOAssembler.toDto(handlingAgt));
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
        }
        executionRequestDetailDTO.setFunc(maintainRequestDTO.getFunc());
        RequestDTO request = executionRequestDetailDTO.getRequest();
        if (request != null && request.getRequestStatusType() != null) {
            executionRequestDetailDTO.setAllowSaveDraftInd(AppExecutionValidationUtil
                    .isAllowSaveDraftRequest(request.getRequestStatusType()));
            executionRequestDetailDTO.setAllowSubmitInd(AppExecutionValidationUtil
                    .isAllowSubmitRequest(request.getRequestStatusType()));
            executionRequestDetailDTO.setAllowWithdrawInd(AppExecutionValidationUtil
                    .isAllowWithdrawRequest(request.getRequestStatusType()));
            executionRequestDetailDTO.setSubmittedModeInd(AppExecutionValidationUtil
                    .isSubmittedMode(request.getRequestStatusType()));
        }
        if (executionRequestDetailDTO.getSubmittedModeInd()) {
            executionRequestDetailDTO
                    .setExecutionRequestPanelMode(CommonConstant.COMMON_PANEL_MODE_READONLY);
            executionRequestDetailDTO
                    .setDocumentListPanelMode(CommonConstant.COMMON_PANEL_MODE_READONLY);
            executionRequestDetailDTO
                    .setExecutionResultPanelMode(CommonConstant.COMMON_PANEL_MODE_READONLY);
        } else {
            executionRequestDetailDTO
                    .setExecutionRequestPanelMode(CommonConstant.COMMON_PANEL_MODE_EDIT);
            executionRequestDetailDTO
                    .setDocumentListPanelMode(CommonConstant.COMMON_PANEL_MODE_EDIT);
            executionRequestDetailDTO
                    .setExecutionResultPanelMode(CommonConstant.COMMON_PANEL_MODE_NA);
        }
        info("maintainExecutionRequest() end - " + executionRequestDetailDTO);
        return executionRequestDetailDTO;
    }

    /**
     * Save the draft of execution request
     * 
     * @param executionRequestDetail
     * @return
     */
    public IdDTO saveDraftExecutionRequest(ExecutionRequestDetailDTO executionRequestDetail) {
        info("saveDraftExecutionRequest() start - " + executionRequestDetail);
        BusinessMessage businessMessage = AppExecutionValidationUtil
                .validateSaveDraftExecutionRequest(executionRequestDetail);

        IdDTO returnVal = null;
        if (businessMessage == null) {
            ReqsStatusType reqsStatusType = getRequestStatusTypeDAO().findByRequestStatusTypeCode(
                    RequestConstant.REQUEST_STATUS_DRAFT);
            executionRequestDetail.getRequest().setRequestStatusType(
                    RequestStatusTypeDTOAssembler.toDto(reqsStatusType));
            returnVal = saveExecutionRequest(executionRequestDetail);
        } else {
            error(MessageConstant.IS_NOT_BAILIFF + ":This is not a Bailiff request.");
            this.addMessage(businessMessage);
            this.throwException(executionRequestDetail.getErrorBoxComponentId());
        }

        info("saveDraftExecutionRequest() end - " + returnVal);
        return returnVal;
    }

    /**
     * Submit the execution request
     * 
     * @param executionRequestDetail
     * @return
     */
    public IdDTO submitExecutionRequest(ExecutionRequestDetailDTO executionRequestDetail) {
        info("submitExecutionRequest() start - " + executionRequestDetail);
        BusinessMessage businessMessage = AppExecutionValidationUtil
                .validateSaveDraftExecutionRequest(executionRequestDetail);

        IdDTO returnVal = null;
        if (businessMessage == null) {
            ReqsStatusType reqsStatusType = getRequestStatusTypeDAO().findByRequestStatusTypeCode(
                    RequestConstant.REQUEST_STATUS_SUBMITTED);
            RequestDTO request = executionRequestDetail.getRequest();
            request.setRequestStatusType(RequestStatusTypeDTOAssembler.toDto(reqsStatusType));
            request.setSubmissionDatetime(new Timestamp(DbCommonUtil.getCurrentSystemDateTime()
                    .getTime()));

            Calendar cal = Calendar.getInstance();
            request.setRegistrationYear(cal.get(Calendar.YEAR));
            String requestType = getCommonBO().getRequestTypeCode(
                    request.getRequestType().getRequestTypeId());
            String bailiffSeqKey = "REG" + "|" + requestType + "|" + request.getRegistrationYear();

            Integer registrationSerialNo = getCommonBO().genNextBailiffSequenceNo(bailiffSeqKey);
            request.setRegistrationSerialNo(String.valueOf(registrationSerialNo));

            request.setRegistrationNo(String.format(RequestConstant.REGISTRATION_NO_PATTERN,
                    requestType, request.getRegistrationSerialNo(), request.getRegistrationYear()));

            returnVal = saveExecutionRequest(executionRequestDetail);
        } else {
            error(MessageConstant.IS_NOT_BAILIFF + ":This is not a Bailiff request.");
            this.addMessage(businessMessage);
            this.throwException(executionRequestDetail.getErrorBoxComponentId());
        }

        info("submitExecutionRequest() end - " + returnVal);
        return returnVal;
    }

    /**
     * Withdraw the execution request
     * 
     * @param executionRequestDetail
     * @return
     */
    public IdDTO withdrawExecutionRequest(ExecutionRequestDetailDTO executionRequestDetail) {
        info("withdrawExecutionRequest() start - " + executionRequestDetail);
        RequestDTO request = executionRequestDetail.getRequest();
        BusinessMessage businessMessage = AppExecutionValidationUtil
                .validateWithdrawRequest(request);
        if (businessMessage != null) {
            this.addMessage(businessMessage);
            this.throwException(executionRequestDetail.getErrorBoxComponentId());
        }
        if (RequestConstant.HANDLING_AGENT_BAILIFF.equals(executionRequestDetail.getRequest().getHandlingAgent()        		
                .getHandlingAgentCode())) {
        	// send withdraw request to Bailiff
        } else {
	        ReqsStatusType reqsStatusType = getRequestStatusTypeDAO().findByRequestStatusTypeCode(
	                RequestConstant.REQUEST_STATUS_WITHDRAWN);
	        request.setRequestStatusType(RequestStatusTypeDTOAssembler.toDto(reqsStatusType));
	        Reqs reqs = getSvdReqBO().toEntity(request);
	        getRequestDAO().merge(reqs);
        }
        IdDTO returnVal = new IdDTO();
        returnVal.setId(request.getRequestId());
        info("withdrawExecutionRequest() end - " + returnVal);
        return returnVal;
    }

    /**
     * Save execution request
     * 
     * @param executionRequestDetail
     */
    public IdDTO saveExecutionRequest(ExecutionRequestDetailDTO executionRequestDetail) {
        info("saveExecutionRequest() start - " + executionRequestDetail);
        BusinessMessage businessMessage = AppExecutionValidationUtil
                .validateSaveExecutionRequest(executionRequestDetail);

        if (businessMessage == null) {
            // Save Request
            saveRequestSection(executionRequestDetail);

            // Save Execution Request
            saveExecutionRequestSection(executionRequestDetail);

            // Save Request Address
            saveRequestAddressSection(executionRequestDetail);

            // Save the Request Documents
            saveRequestDocumentsSection(executionRequestDetail);

            // Save Applicant
            saveApplicantSection(executionRequestDetail);

        } else {
            error(MessageConstant.IS_NOT_BAILIFF + ":This is not a Bailiff request.");
            this.addMessage(businessMessage);
            this.throwException(executionRequestDetail.getErrorBoxComponentId());
        }

        IdDTO returnVal = new IdDTO();
        returnVal.setId(executionRequestDetail.getRequest().getRequestId());
        info("saveExecutionRequest() end - " + returnVal);
        return returnVal;
    }

    private void saveRequestSection(ExecutionRequestDetailDTO executionRequestDetail) {
        RequestDTO request = executionRequestDetail.getRequest();
        Reqs reqs = getSvdReqBO().toEntity(request);
        if (DbCommonUtil.isValidDbId(reqs.getReqsId())) {
            getRequestDAO().merge(reqs);
        } else {
            getRequestDAO().persist(reqs);
            request.setRequestId(reqs.getReqsId());
        }
    }

    private void saveExecutionRequestSection(ExecutionRequestDetailDTO executionRequestDetail) {
        Integer requestId = executionRequestDetail.getRequest().getRequestId();
        ExecutionRequestDTO executionRequest = executionRequestDetail.getExecutionRequest();
        if (DbCommonUtil.isValidDbId(executionRequest.getExecutionRequestId())) {
            ExecReqs execReqs = toEntity(executionRequest);
            getExecutionRequestDAO().merge(execReqs);
        } else {
            executionRequest.setRequestId(requestId);
            ExecReqs execReqs = toEntity(executionRequest);
            getExecutionRequestDAO().persist(execReqs);
            executionRequest.setExecutionRequestId(execReqs.getExecReqsId());
        }
    }

    private void saveRequestAddressSection(ExecutionRequestDetailDTO executionRequestDetail) {
        Integer requestId = executionRequestDetail.getRequest().getRequestId();
        RequestAddressDTO requestAddress = executionRequestDetail.getRequestAddress();
        if (DbCommonUtil.isValidDbId(requestAddress.getRequestAddressId())) {
            ReqsAddr reqsAddr = getSvdReqBO().toEntity(requestAddress);
            getRequestAddressDAO().merge(reqsAddr);
        } else {
            requestAddress.setRequestId(requestId);
            requestAddress.setPrimaryAddressInd(true);
            requestAddress.setActionAddressInd(true);
            ReqsAddr reqsAddr = getSvdReqBO().toEntity(requestAddress);
            getRequestAddressDAO().persist(reqsAddr);
            requestAddress.setRequestAddressId(reqsAddr.getReqsAddrId());
        }
    }

    private void saveRequestDocumentsSection(ExecutionRequestDetailDTO executionRequestDetail) {
        Integer requestId = executionRequestDetail.getRequest().getRequestId();
        List<DocumentRecordDTO> documentRecords = executionRequestDetail.getDocumentRecords();
        if (!CommonUtil.isNullOrEmpty(documentRecords)) {
            int documentSequenceNo = 1;
            BlfDocStatusType blfDocStatusType = getBailiffDocumentStatusTypeDAO()
                    .findByBailiffDocumentStatusTypeCode(
                            RequestConstant.BAILIFF_DOC_STATUS_RECEIVED);
            for (DocumentRecordDTO documentRecordDTO : documentRecords) {
                RequestDocumentDTO requestDocument = documentRecordDTO.getRequestDocument();
                if (documentRecordDTO.isSelectedDocumentInd() && requestDocument == null) {
                    RequestDocumentDTO newRequestDocument = new RequestDocumentDTO();
                    newRequestDocument.setRequestId(requestId);
                    newRequestDocument.setDocumentSeqNo(documentSequenceNo++);
                    newRequestDocument.setDocumentId(documentRecordDTO.getDocument()
                            .getDocumentId());
                    newRequestDocument.setBailiffDocumentStatusId(blfDocStatusType
                            .getBlfDocStatusTypeId());
                    newRequestDocument.setActionRequestInd(true);
                    newRequestDocument.setPrintedInd(false);
                    newRequestDocument.setReturnedDocumentInd(documentRecordDTO
                            .isReturnedDocumentInd());
                    newRequestDocument.setHardcopyInd(false);
                    ReqsDoc reqsDoc = getSvdReqBO().toEntity(newRequestDocument);
                    getRequestDocumentDAO().persist(reqsDoc);
                    newRequestDocument.setRequestDocumentId(reqsDoc.getReqsDocId());
                    documentRecordDTO.setRequestDocument(newRequestDocument);
                } else if (documentRecordDTO.isSelectedDocumentInd() && requestDocument != null) {
                    requestDocument.setDocumentSeqNo(documentSequenceNo++);
                    ReqsDoc reqsDoc = getSvdReqBO().toEntity(requestDocument);
                    getRequestDocumentDAO().merge(reqsDoc);
                } else if (!documentRecordDTO.isSelectedDocumentInd() && requestDocument != null) {
                    ReqsDoc reqsDoc = getSvdReqBO().toEntity(requestDocument);
                    getRequestDocumentDAO().remove(reqsDoc);
                }
            }
        }
    }

    private void saveApplicantSection(ExecutionRequestDetailDTO executionRequestDetail) {
        Integer requestId = executionRequestDetail.getRequest().getRequestId();
        PartyDTO applicant = executionRequestDetail.getApplicant();
        RequestParticipantRoleDTO requestParticipantRole = executionRequestDetail
                .getRequestParticipantRole();
        if (applicant != null && requestParticipantRole == null) {
            RequestParticipantRoleDTO newRequestParticipantRole = new RequestParticipantRoleDTO();
            newRequestParticipantRole.setRequestId(requestId);
            newRequestParticipantRole.setParticipantId(applicant.getParticipantId());
            newRequestParticipantRole
                    .setOriginalParticipantRoleId(applicant.getParticipantRoleId());
            newRequestParticipantRole.setPartyCategoryId(applicant.getPartyCategoryId());
            newRequestParticipantRole.setParticipantRoleTypeId(applicant.getParticipantRoleType()
                    .getParticipantRoleTypeId());
            newRequestParticipantRole.setRespondentSeqNo(applicant.getRespondentSeqNo());
            newRequestParticipantRole.setRespondentSubSeqNo(applicant.getRespondentSubSeqNo());
            newRequestParticipantRole
                    .setRecipientRequesterIndicator(RequestConstant.REQUEST_REQUESTER);
            ReqsPartcpRole reqsPartcpRole = getSvdReqBO().toEntity(newRequestParticipantRole);
            getRequestParticipantRoleDAO().persist(reqsPartcpRole);
            newRequestParticipantRole.setRequestParticipantRoleId(reqsPartcpRole
                    .getReqsPartcpRoleId());
            executionRequestDetail.setRequestParticipantRole(newRequestParticipantRole);
        } else if (applicant != null && requestParticipantRole != null) {
            if (!applicant.getParticipantRoleId().equals(
                    requestParticipantRole.getRequestParticipantRoleId())) {
                ReqsPartcpRole reqsPartcpRole = getSvdReqBO().toEntity(requestParticipantRole);
                getRequestParticipantRoleDAO().merge(reqsPartcpRole);
            }
        } else if (applicant == null && requestParticipantRole != null) {
            ReqsPartcpRole reqsPartcpRole = getSvdReqBO().toEntity(requestParticipantRole);
            getRequestParticipantRoleDAO().remove(reqsPartcpRole);
        }
    }

    private ExecReqs toEntity(ExecutionRequestDTO dto) {
        ExecReqs execReqs = null;
        if (DbCommonUtil.isValidDbId(dto.getExecutionRequestId())) {
            Timestamp version = dto.getVersion();
            execReqs = getExecutionRequestDAO().find(ExecReqs.class, dto.getExecutionRequestId(),
                    version);
            execReqs.setPreviousVersion(version);
        } else {
            execReqs = new ExecReqs();
        }
        if (DbCommonUtil.isValidDbId(dto.getRequestId())) {
            Reqs reqs = getRequestDAO().find(Reqs.class, dto.getRequestId());
            execReqs.setReqs(reqs);
        }
        if (dto.getDocumentType() != null
                && DbCommonUtil.isValidDbId(dto.getDocumentType().getDocumentTypeId())) {
            DocType docType = getDocumentTypeDAO().find(DocType.class,
                    dto.getDocumentType().getDocumentTypeId());
            execReqs.setDocType(docType);
        }
        return execReqs;
    }
}
