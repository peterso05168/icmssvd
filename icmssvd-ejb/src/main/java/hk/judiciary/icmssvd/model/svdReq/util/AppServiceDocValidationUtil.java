package hk.judiciary.icmssvd.model.svdReq.util;

import java.util.Arrays;

import hk.judiciary.fmk.common.exception.BusinessMessage;
import hk.judiciary.icms.model.dao.entity.SummonNoti;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultStatusDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseNoDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.CaseConstant;
import hk.judiciary.icmssvd.model.svdReq.DocumentConstant;
import hk.judiciary.icmssvd.model.svdReq.MessageConstant;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestServiceTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDetailDTO;

/**
 * 
 * @version $Revision: 7895 $ $Date: 2017-07-10 10:36:55 +0800 (Mon, 10 Jul 2017) $
 * @author $Author: mtse $
 */
public class AppServiceDocValidationUtil {
    /**
     * Check whether allow to complete request
     * 
     * @param requestStatusType
     * @return
     */
    public static boolean isAllowCompleteRequest(RequestStatusTypeDTO requestStatusType) {
        boolean result = false;
        String code = requestStatusType.getRequestStatusTypeCode();
        if (RequestConstant.REQUEST_STATUS_ACCEPTED.equals(code)
                || RequestConstant.REQUEST_STATUS_WITHHELD.equals(code)
                || RequestConstant.REQUEST_STATUS_ASSIGNED.equals(code)) {
            result = true;
        }
        return result;
    }

    /**
     * Check whether allow to save draft request
     * 
     * @param requestStatusType
     * @return
     */
    public static boolean isAllowSaveDraftRequest(RequestStatusTypeDTO requestStatusType) {
        boolean result = false;
        String code = requestStatusType.getRequestStatusTypeCode();
        if (code == null || "".equals(code) || RequestConstant.REQUEST_STATUS_DRAFT.equals(code)) {
            result = true;
        }
        return result;
    }

    /**
     * Check whether allow to submit request
     * 
     * @param requestStatusType
     * @return
     */
    public static boolean isAllowSubmitRequest(RequestStatusTypeDTO requestStatusType) {
        boolean result = false;
        String code = requestStatusType.getRequestStatusTypeCode();
        if (code == null || "".equals(code) || RequestConstant.REQUEST_STATUS_DRAFT.equals(code)
                || RequestConstant.REQUEST_STATUS_PENDING_SUBMIT.equals(code)) {
            result = true;
        }
        return result;
    }

    /**
     * Check whether allow to withdraw request
     * 
     * @param requestStatusType
     * @return
     */
    public static boolean isAllowWithdrawRequest(RequestStatusTypeDTO requestStatusType) {
        boolean result = false;
        String code = requestStatusType.getRequestStatusTypeCode();
        if (!RequestConstant.REQUEST_STATUS_DRAFT.equals(code)
                && !RequestConstant.REQUEST_STATUS_PENDING_SUBMIT.equals(code)
                && !RequestConstant.REQUEST_STATUS_COMPLETED.equals(code)
                && !RequestConstant.REQUEST_STATUS_WITHDRAWN.equals(code)) {
            result = true;
        }
        return result;
    }

    /**
     * Check whether request under submitted mode
     * 
     * @param requestStatusType
     * @return
     */
    public static boolean isSubmittedMode(RequestStatusTypeDTO requestStatusType) {
        boolean result = false;
        String code = requestStatusType.getRequestStatusTypeCode();
        if (code != null && !"".equals(code) && !RequestConstant.REQUEST_STATUS_DRAFT.equals(code)
                && !RequestConstant.REQUEST_STATUS_PENDING_SUBMIT.equals(code)) {
            result = true;
        }
        return result;
    }

    /**
     * Validation to complete request
     * 
     * @param request
     * @return
     */
    public static BusinessMessage validateCompleteRequest(RequestDTO request) {
        BusinessMessage businessMessage = null;
        if (!isAllowCompleteRequest(request.getRequestStatusType())
                && !RequestConstant.REQUEST_STATUS_COMPLETED.equals(request.getRequestStatusType()
                        .getRequestStatusTypeCode())) {
            businessMessage = new BusinessMessage(MessageConstant.COMPLETE_DISABLE, "");
        }
        return businessMessage;
    }

    /**
     * Validation to withdraw request
     * 
     * @param request
     * @return
     */

    public static BusinessMessage validateWithdrawRequest(RequestDTO request) {
        BusinessMessage businessMessage = null;
        if (!isAllowWithdrawRequest(request.getRequestStatusType())
                && !RequestConstant.REQUEST_STATUS_WITHDRAWN.equals(request.getRequestStatusType()
                        .getRequestStatusTypeCode())) {
            businessMessage = new BusinessMessage(MessageConstant.WITHDRAW_DISABLE, "");
        }
        return businessMessage;
    }

    /**
     * Validation to save request result
     * 
     * @param requestResult
     * @return
     */
    public static BusinessMessage validateSaveRequestResult(RequestResultDTO requestResult) {
        BusinessMessage businessMessage = null;
        // businessMessage = new BusinessMessage(MessageConstant.SAVE_REQUEST_RESULT_DISABLE,"");
        return businessMessage;
    }

    /**
     * Validation to save draft of service request
     * 
     * @param serviceRequestDetail
     * @return
     */
    public static BusinessMessage validateSaveDraftServiceRequest(
            ServiceRequestDetailDTO serviceRequestDetail) {
        BusinessMessage businessMessage = null;
        // businessMessage = new BusinessMessage(MessageConstant.SAVE_DRAFT_DISABLE,"");
        return businessMessage;
    }

    /**
     * Validation to save service request
     * 
     * @param serviceRequestDetail
     * @return
     */
    public static BusinessMessage validateSaveServiceRequest(
            ServiceRequestDetailDTO serviceRequestDetail) {
        BusinessMessage businessMessage = null;
        // businessMessage = new BusinessMessage(MessageConstant.SAVE_SERVICE_REQUEST_DISABLE,"");
        return businessMessage;
    }

    /**
     * Check whether allow to update service type
     * 
     * @param fuc
     * @param requestServiceType
     * @return
     */
    public static boolean isAllowUpdateServiceType(FunctionDTO fuc,
            RequestServiceTypeDTO requestServiceType) {
        boolean result = false;
        if (RequestConstant.COURT_LEVEL_TYPE_MAGISTRATES.equals(fuc.getCourtLevelTypeCode())
                && RequestConstant.REQUEST_SERVICE_TYPE_FRIST.equals(requestServiceType
                        .getRequestServiceType())) {
            result = true;
        }
        return result;
    }

    /**
     * Check whether has sent PGBL
     * 
     * @param caseId
     * @return
     */
    public static boolean isSentPGBL(SummonNoti summonNoti) {
        boolean result = false;
        if (summonNoti != null && DbCommonUtil.isValidDbId(summonNoti.getSummonNotiId())) {
            if (CommonConstant.COMMON_FLAG_TRUE.equals(summonNoti.getPgblAllow())) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Check Whether Allow to Create Proof of Service
     * 
     * @param caseId
     * @return
     */
    public static boolean isAllowProofOfService(BailiffTaskResultStatusDTO bailiffTaskResultStatus) {
        boolean result = false;
        if (bailiffTaskResultStatus != null
                && RequestConstant.BAILIFF_TASK_RESULT_STATUS_ID_SUCCESS
                        .equals(bailiffTaskResultStatus.getBailiffTaskResultStatusId())) {
            result = true;
        }
        return result;
    }

    /**
     * Validation to submit proof of service request
     * 
     * @param posRequestDetailDTO
     * @return
     */
    public static BusinessMessage validateSubmitPosRequest(PosRequestDetailDTO posRequestDetailDTO) {
        BusinessMessage businessMessage = null;
        return businessMessage;
    }

    /**
     * Check whether a summons case type
     * 
     * @param caseNo
     * @return
     */
    public static boolean isSummonsCaseType(String caseTypeCode) {
        boolean result = false;
        String[] summonsCaseTypes = { CaseConstant.CASE_TYPE_DOP_SUMMONS,
                CaseConstant.CASE_TYPE_DEPT_SUMMONS, CaseConstant.CASE_TYPE_FP_SUMMONS_FS,
                CaseConstant.CASE_TYPE_FP_SUMMONS_V, CaseConstant.CASE_TYPE_FP_SUMMONS_K,
                CaseConstant.CASE_TYPE_FP_SUMMONS_R };
        if (Arrays.asList(summonsCaseTypes).contains(caseTypeCode)) {
            result = true;
        }
        return result;
    }

    /**
     * Check whether a summons document
     * 
     * @param docTypeCode
     * @return
     */
    public static boolean isSummonsDocumentType(String docTypeCode) {
        boolean result = false;
        String[] summonsDocTypes = { DocumentConstant.DOCUMENT_TYPE_DSD,
        							 DocumentConstant.DOCUMENT_TYPE_DSC,
        							 DocumentConstant.DOCUMENT_TYPE_DOPSD, 
        							 DocumentConstant.DOCUMENT_TYPE_DOPSC,
        							 DocumentConstant.DOCUMENT_TYPE_FPSD,
        							 DocumentConstant.DOCUMENT_TYPE_FPSC };
        if (Arrays.asList(summonsDocTypes).contains(docTypeCode)) {
            result = true;
        }
        return result;
    }

    /**
     * Check whether a DOP summons case type
     * 
     * @param caseNo
     * @return
     */
    public static boolean isDopSummons(String caseNo) {
        boolean result = false;
        CaseNoDTO caseNoDTO = SvdCommonUtil.splitCaseNoToDTO(caseNo);
        if (CaseConstant.CASE_TYPE_DOP_SUMMONS.equals(caseNoDTO.getCaseType())) {
            result = true;
        }
        return result;
    }

    /**
     * Check whether a court copy document
     * 
     * @param docTypeCode
     * @return
     */
    public static boolean isCourtCopy(String docTypeCode) {
        boolean result = false;
        String[] courtCopyDocTypes = { DocumentConstant.DOCUMENT_TYPE_DSC,        							  
        							   DocumentConstant.DOCUMENT_TYPE_DOPSC,
        							   DocumentConstant.DOCUMENT_TYPE_FPSC };
        if (Arrays.asList(courtCopyDocTypes).contains(docTypeCode)) {
            result = true;
        }
        return result;
    }
    
    /**
     * Check whether a request document
     * 
     * @param handlingAgentCode
     * @param docTypeCode
     * @return
     */
    public static boolean isRequestDocument(String handlingAgentCode, String docTypeCode) {
        boolean result = true;
        
        if (RequestConstant.HANDLING_AGENT_BAILIFF.equals(handlingAgentCode) && isCourtCopy(docTypeCode)) {
        	result = false;
        }
        
        return result;
    }

}
