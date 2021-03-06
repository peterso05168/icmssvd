package hk.judiciary.icmssvd.model.svdReq.facade;

import java.util.List;

import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.model.cfs.biz.dto.FileDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.DrnDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.IntegerFieldDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.BatchSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.CertifcateBulkPostingDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDraftDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.MaintainRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDateGenerationDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceBatchSearchResultDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestSearchResultDTO;

/**
 * 
 * @version $Revision: 7398 $ $Date: 2017-06-07 18:46:54 +0800 (週三, 07 六月 2017) $
 * @author $Author: vicki.huang $
 */
public interface SvdReqFacade {
    public static final String NAME = "svdReqFacade";

    public IntegerFieldDTO completeServiceRequestList(JudiciaryUser user, List<IdDTO> requestIds);

    public List<ServiceRequestSearchResultDTO> searchServiceRequestList(JudiciaryUser user,
            ServiceRequestSearchDTO searchDTO);

    public IdDTO completeServiceRequest(JudiciaryUser user,
            ServiceRequestDetailDTO serviceRequestDetail);

    public ServiceRequestDetailDTO enquireServiceRequest(JudiciaryUser user, IdDTO idDTO);

    public List<DocumentDraftDTO> generateDocuments(JudiciaryUser user,
            ServiceRequestDetailDTO serviceRequestDetailDTO) throws Exception;

    public ServiceRequestDetailDTO maintainRequest(JudiciaryUser user,
            MaintainRequestDTO maintainRequest);

    public IdDTO saveDraftServiceRequest(JudiciaryUser user,
            ServiceRequestDetailDTO serviceRequestDetail) throws Exception;

    public IdDTO saveServiceRequestResult(JudiciaryUser user, ServiceRequestDetailDTO detailDTO)
            throws Exception;

    public IdDTO submitServiceRequest(JudiciaryUser user,
            ServiceRequestDetailDTO serviceRequestDetail) throws Exception;

    public IdDTO withdrawServiceRequest(JudiciaryUser user,
            ServiceRequestDetailDTO serviceRequestDetail);

    public List<PosRequestSearchResultDTO> searchPosRequestList(JudiciaryUser user,
            PosRequestSearchDTO searchDTO);

    public PosRequestDetailDTO maintainPosRequest(JudiciaryUser user,
            MaintainRequestDTO maintainRequestDTO);

    public IdDTO submitPosRequest(JudiciaryUser user, PosRequestDetailDTO posRequestDetailDTO);

    public List<ReserviceBatchSearchResultDTO> searchReserviceBatchList(JudiciaryUser user,
            BatchSearchDTO searchDTO);

    public NextHearingDetailDTO generateNextHearingDate(JudiciaryUser user,
            NextHearingDateGenerationDTO generationDTO);

    public ReserviceBatchSearchResultDTO confirmHearingSchedule(JudiciaryUser user,
            ReserviceBatchSearchResultDTO resultDTO) throws Exception;

    public FileDTO generateCertificateBulkPosting(JudiciaryUser user,
            CertifcateBulkPostingDTO postingDTO) throws Exception;

    public IdDTO saveDraftReserviceRequestAndGenerateDocuments(JudiciaryUser user,
            ReserviceBatchSearchResultDTO resultDTO) throws Exception;

    public IdDTO saveDraftReserviceRequest(JudiciaryUser user,
            ReserviceBatchSearchResultDTO resultDTO) throws Exception;

    public IdDTO submitReserviceRequest(JudiciaryUser user, ReserviceBatchSearchResultDTO resultDTO)
            throws Exception;

    public ReserviceRequestDetailDTO maintainReserviceRequest(JudiciaryUser user,
            MaintainRequestDTO maintainRequestDTO);

    public DrnDTO assignDrn(JudiciaryUser user) throws Exception;

    public List<PosRequestDetailDTO> searchPosRequestBatchList(JudiciaryUser user,
            BatchSearchDTO searchDTO);
}
