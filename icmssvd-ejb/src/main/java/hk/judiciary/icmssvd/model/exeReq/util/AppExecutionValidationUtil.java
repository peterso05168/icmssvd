package hk.judiciary.icmssvd.model.exeReq.util;

import hk.judiciary.fmk.common.exception.BusinessMessage;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.MessageConstant;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;

/**
 * 
 * @version $Revision: 4744 $ $Date: 2017-02-28 20:05:55 +0800 (Tue, 28 Feb 2017) $
 * @author $Author: vicki.huang $
 */
public class AppExecutionValidationUtil {
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
     * Validation to withdraw request
     * 
     * @param request
     * @return
     */

    public static BusinessMessage validateSaveDraftExecutionRequest(
            ExecutionRequestDetailDTO executionRequestDetail) {
        BusinessMessage businessMessage = null;
        if (!RequestConstant.HANDLING_AGENT_BAILIFF.equals(executionRequestDetail.getRequest()
                .getHandlingAgent().getHandlingAgentCode())) {
            businessMessage = new BusinessMessage(MessageConstant.IS_NOT_BAILIFF, "");
        }
        return businessMessage;
    }

    /**
     * Validation to save request result
     * 
     * @param requestResult
     * @return
     */
    public static BusinessMessage validateSaveExecutionRequest(
            ExecutionRequestDetailDTO executionRequestDetail) {
        BusinessMessage businessMessage = null;
        if (!RequestConstant.HANDLING_AGENT_BAILIFF.equals(executionRequestDetail.getRequest()
                .getHandlingAgent().getHandlingAgentCode())) {
            businessMessage = new BusinessMessage(MessageConstant.IS_NOT_BAILIFF, "");
        }
        return businessMessage;
    }

    /**
     * Validation to save draft of service request
     * 
     * @param serviceRequestDetail
     * @return
     */
    public static BusinessMessage validateWithdrawRequest(RequestDTO request) {
        BusinessMessage businessMessage = null;
        String code = request.getRequestStatusType().getRequestStatusTypeCode();
        if (!RequestConstant.REQUEST_STATUS_WITHDRAWN.equals(code) && !isAllowWithdrawRequest(request.getRequestStatusType())) {
            businessMessage = new BusinessMessage(MessageConstant.WITHDRAW_DISABLE, "");
        }
        return businessMessage;
    }
}
