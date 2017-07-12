package hk.judiciary.icmssvd.model.exeReq.facade.internal;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.PersistenceContext;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.ejb.facade.DefaultFacadeInterceptor;
import hk.judiciary.icmssvd.model.BaseFacade;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.ExeReqBO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDetailDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchDTO;
import hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.exeReq.facade.ExeReqFacade;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.MaintainRequestDTO;

/**
 * 
 * @version $Revision: 4744 $ $Date: 2017-02-28 20:05:55 +0800 (Tue, 28 Feb 2017) $
 * @author $Author: vicki.huang $
 */
@Stateless(mappedName = "ejb/exeReqFacade")
@Interceptors(DefaultFacadeInterceptor.class)
@PersistenceContext(name = "icmssvdEJBPU", unitName = "icmssvdEJBPU")
public class ExeReqFacadeBean extends BaseFacade implements ExeReqFacade {
    public static final String name = "exeReqFacade";

    private ExeReqBO getExeReqBO() {
        return getBO(ExeReqBO.NAME, ExeReqBO.class);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<ExecutionRequestSearchResultDTO> searchExecutionRequestList(JudiciaryUser user,
            ExecutionRequestSearchDTO searchDTO) {
        return getExeReqBO().searchExecutionRequestList(searchDTO);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public ExecutionRequestDetailDTO maintainExecutionRequest(JudiciaryUser user,
            MaintainRequestDTO maintainRequestDTO) {
        return getExeReqBO().maintainExecutionRequest(maintainRequestDTO);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public IdDTO saveDraftExecutionRequest(JudiciaryUser user,
            ExecutionRequestDetailDTO executionRequestDetail) {
        return getExeReqBO().saveDraftExecutionRequest(executionRequestDetail);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public IdDTO submitExecutionRequest(JudiciaryUser user,
            ExecutionRequestDetailDTO executionRequestDetail) {
        return getExeReqBO().submitExecutionRequest(executionRequestDetail);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public IdDTO withdrawExecutionRequest(JudiciaryUser user,
            ExecutionRequestDetailDTO executionRequestDetail) {
        return getExeReqBO().withdrawExecutionRequest(executionRequestDetail);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void saveExecutionRequest(JudiciaryUser user,
            ExecutionRequestDetailDTO executionRequestDetail) {
        getExeReqBO().saveDraftExecutionRequest(executionRequestDetail);
    }
}
