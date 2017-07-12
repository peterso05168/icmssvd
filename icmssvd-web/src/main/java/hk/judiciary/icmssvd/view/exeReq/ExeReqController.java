package hk.judiciary.icmssvd.view.exeReq;

import java.util.List;

import org.granite.tide.annotations.TideEnabled;

import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDetailDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.exeReq.facade.ExeReqFacade;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.MaintainRequestDTO;
import hk.judiciary.icmssvd.view.BaseController;

@TideEnabled
public class ExeReqController extends BaseController {

    /**
     * Search the execution requests according to inputted criteria
     * 
     * @param searchDTO
     * @return
     */
    public List<ExecutionRequestSearchResultDTO> searchExecutionRequestList(
            ExecutionRequestSearchDTO searchDTO) {
        info("searchExecutionRequestList() start - " + searchDTO);
        List<ExecutionRequestSearchResultDTO> returnVal = getFacade(ExeReqFacade.NAME,
                ExeReqFacade.class).searchExecutionRequestList(getUser(), searchDTO);
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
        ExecutionRequestDetailDTO returnVal = getFacade(ExeReqFacade.NAME, ExeReqFacade.class)
                .maintainExecutionRequest(getUser(), maintainRequestDTO);
        info("maintainExecutionRequest() end - " + returnVal);
        return returnVal;
    }

    /**
     * Save the draft of execution request
     * 
     * @param executionRequestDetail
     * @return
     */
    public IdDTO saveDraftExecutionRequest(ExecutionRequestDetailDTO executionRequestDetail) {
        info("saveDraftExecutionRequest() start - " + executionRequestDetail);
        IdDTO returnVal = getFacade(ExeReqFacade.NAME, ExeReqFacade.class)
                .saveDraftExecutionRequest(getUser(), executionRequestDetail);
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
        IdDTO returnVal = getFacade(ExeReqFacade.NAME, ExeReqFacade.class)
                .submitExecutionRequest(getUser(), executionRequestDetail);
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
        IdDTO returnVal = getFacade(ExeReqFacade.NAME, ExeReqFacade.class)
                .withdrawExecutionRequest(getUser(), executionRequestDetail);
        info("withdrawExecutionRequest() end - " + returnVal);
        return returnVal;
    }

}
