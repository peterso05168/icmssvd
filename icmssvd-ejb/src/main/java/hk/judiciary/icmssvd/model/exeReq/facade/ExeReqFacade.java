package hk.judiciary.icmssvd.model.exeReq.facade;

import java.util.List;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDetailDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.MaintainRequestDTO;

/**
 * 
 * @version $Revision: 4744 $ $Date: 2017-02-28 20:05:55 +0800 (Tue, 28 Feb 2017) $
 * @author $Author: vicki.huang $
 */
public interface ExeReqFacade {

    public static final String NAME = "exeReqFacade";

    public List<ExecutionRequestSearchResultDTO> searchExecutionRequestList(JudiciaryUser user,
            ExecutionRequestSearchDTO searchDTO);

    public ExecutionRequestDetailDTO maintainExecutionRequest(JudiciaryUser user,
            MaintainRequestDTO maintainRequestDTO);

    public IdDTO saveDraftExecutionRequest(JudiciaryUser user,
            ExecutionRequestDetailDTO executionRequestDetail);

    public IdDTO submitExecutionRequest(JudiciaryUser user,
            ExecutionRequestDetailDTO executionRequestDetail);

    public IdDTO withdrawExecutionRequest(JudiciaryUser user,
            ExecutionRequestDetailDTO executionRequestDetail);

    public void saveExecutionRequest(JudiciaryUser user,
            ExecutionRequestDetailDTO executionRequestDetail);
}
