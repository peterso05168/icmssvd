package hk.judiciary.icmssvd.model.common.facade.internal;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.PersistenceContext;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.ejb.facade.DefaultFacadeInterceptor;
import hk.judiciary.fmk.model.cfs.biz.dto.FileDTO;
import hk.judiciary.icmssvd.model.BaseFacade;
import hk.judiciary.icmssvd.model.common.biz.CommonBO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultReasonDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultStatusDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ComprisingCourtDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtLevelTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtRoomChambersDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentFileDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.FpApplicationNatureTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HandlingAgentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HkDistrictDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.HkRegionDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ParticipantRoleTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.PostOfficeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ProsecutionDepartmentDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ServiceModeTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.SpecialRequestTypeDTO;
import hk.judiciary.icmssvd.model.common.facade.CommonFacade;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.IntlUserAcDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosDocumentTypeDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestServiceTypeDTO;

/**
 * 
 * @version $Revision: 6787 $ $Date: 2017-05-09 18:09:55 +0800 (週二, 09 五月 2017) $
 * @author $Author: mtse $
 */
@Stateless(mappedName = "ejb/commonFacade")
@Interceptors(DefaultFacadeInterceptor.class)
@PersistenceContext(name = "icmssvdEJBPU", unitName = "icmssvdEJBPU")
public class CommonFacadeBean extends BaseFacade implements CommonFacade {
    public static final String name = "commonFacade";

    private CommonBO getCommonBO() {
        return getBO(CommonBO.NAME, CommonBO.class);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<BailiffOfficeDTO> findBailiffOfficeList(JudiciaryUser user) {
        return getCommonBO().findBailiffOfficeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<CaseTypeDTO> findCaseTypeList(JudiciaryUser user, FunctionDTO function) {
        return getCommonBO().findCaseTypeList(function);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<CaseTypeDTO> findSummonsCaseTypeList(JudiciaryUser user, FunctionDTO function) {
        return getCommonBO().findSummonsCaseTypeList(function);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<ComprisingCourtDTO> findComprisingCourtList(JudiciaryUser user, FunctionDTO function) {
        return getCommonBO().findComprisingCourtList(function);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<CourtLevelTypeDTO> findCourtLevelTypeList(JudiciaryUser user) {
        return getCommonBO().findCourtLevelTypeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<DocumentTypeDTO> findDocumentTypeList(JudiciaryUser user, FunctionDTO function) {
        return getCommonBO().findDocumentTypeList(function);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<HandlingAgentDTO> findHandlingAgentList(JudiciaryUser user, FunctionDTO function) {
        return getCommonBO().findHandlingAgentList(function);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<HkDistrictDTO> findHkDistrictList(JudiciaryUser user) {
        return getCommonBO().findHkDistrictList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<HkRegionDTO> findHkRegionList(JudiciaryUser user) {
        return getCommonBO().findHkRegionList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<PostOfficeDTO> findPostOfficeList(JudiciaryUser user) {
        return getCommonBO().findPostOfficeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<RequestStatusTypeDTO> findRequestStatusTypeList(JudiciaryUser user) {
        return getCommonBO().findRequestStatusTypeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<RequestTypeDTO> findRequestTypeList(JudiciaryUser user) {
        return getCommonBO().findRequestTypeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<BailiffTaskResultReasonDTO> findBailiffTaskResultReasonList(JudiciaryUser user) {
        return getCommonBO().findBailiffTaskResultReasonList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<BailiffTaskResultStatusDTO> findBailiffTaskResultStatusList(JudiciaryUser user) {
        return getCommonBO().findBailiffTaskResultStatusList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<ServiceModeTypeDTO> findServiceModeTypeList(JudiciaryUser user) {
        return getCommonBO().findServiceModeTypeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<SpecialRequestTypeDTO> findSpecialRequestTypeList(JudiciaryUser user) {
        return getCommonBO().findSpecialRequestTypeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<RequestServiceTypeDTO> findRequestServiceTypeList(JudiciaryUser user) {
        return getCommonBO().findRequestServiceTypeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<ParticipantRoleTypeDTO> findParticipantRoleTypeList(JudiciaryUser user,
            FunctionDTO function) {
        return getCommonBO().findParticipantRoleTypeList(function);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<PosDocumentTypeDTO> findPosDocumentTypeList(JudiciaryUser user) {
        return getCommonBO().findPosDocumentTypeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<CourtRoomChambersDTO> findCourtRoomChambers(JudiciaryUser user) {
        return getCommonBO().getCourtRoomChambers();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<FpApplicationNatureTypeDTO> findFpApplicationNatureTypeList(JudiciaryUser user) {
        return getCommonBO().findFpApplicationNatureTypeList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<ProsecutionDepartmentDTO> findProsecutionDepartmentList(JudiciaryUser user) {
        return getCommonBO().findProsecutionDepartmentList();
    }

    @Override
    public List<IntlUserAcDTO> findSeniorBailiffUserAccountList(JudiciaryUser user, Integer baiOffId) {
        return getCommonBO().getSeniorBailiffUserAccountList(baiOffId);
    }

    @Override
    public FileDTO getDocumentFile(JudiciaryUser user, DocumentFileDTO doc) throws Exception {
        return getCommonBO().getDocumentFile(doc);
    }

}
