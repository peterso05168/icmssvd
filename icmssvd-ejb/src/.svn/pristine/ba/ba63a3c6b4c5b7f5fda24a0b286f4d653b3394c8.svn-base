package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsDoc;
import hk.judiciary.icms.model.dao.entity.ReqsPartcpRole;
import hk.judiciary.icmssvd.model.common.biz.dto.RequestStatusTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.common.util.DocumentFileUtil;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestAddressDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ReserviceRequestDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.ServiceRequestDTO;
import hk.judiciary.icmssvd.model.svdReq.util.AppServiceDocValidationUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (Wed, 15 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class ReserviceRequestDetailDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param Reqs
     *            entity
     * @return ReserviceRequestDetailDTO
     */
    public static ReserviceRequestDetailDTO toDto(Reqs reqs) {
        ReserviceRequestDetailDTO dto = new ReserviceRequestDetailDTO();
        if (reqs != null && reqs.getReqsId() != null && reqs.getReqsId() != 0) {
            dto.setRequest(RequestDTOAssembler.toDto(reqs));
            dto.setServiceRequest(ServiceRequestDTOAssembler.toDto(reqs.getServReqs()));
            dto.setRequestAddress(RequestAddressDTOAssembler.toDto(reqs.getReqsAddr()));
            List<ReqsPartcpRole> reqsPartcpRoles = reqs.getReqsPartcpRole();
            if (!CommonUtil.isNullOrEmpty(reqsPartcpRoles)) {
                for (ReqsPartcpRole reqsPartcpRole : reqsPartcpRoles) {
                    if (RequestConstant.REQUEST_RECIPIENT
                            .equals(reqsPartcpRole.getRecipReqserInd())) {
                        dto.setRecipient(PartyDTOAssembler.toDto(reqsPartcpRole));
                        break;
                    }
                }
            }
            List<ReqsDoc> reqsDocs = reqs.getReqsDoc();
            if (!CommonUtil.isNullOrEmpty(reqsDocs)) {
                for (ReqsDoc reqsDoc : reqsDocs) {
                	String documentTypeCode = "";
                	if (!CommonUtil.isNullOrEmpty(reqsDoc.getDoc()) && DbCommonUtil.isValidDbId(reqsDoc.getDoc().getDocId()) 
                		&& CommonUtil.isNullOrEmpty(reqsDoc.getAdmAndSuppFileId())) {
                		
                		documentTypeCode = reqsDoc.getDoc().getDocType().getDocTypeCd();

                	} else if (CommonUtil.isNullOrEmpty(reqsDoc.getDoc()) && !CommonUtil.isNullOrEmpty(reqsDoc.getDocRefNo())) {
               			documentTypeCode = DocumentFileUtil.getDocumentTypeCode(reqsDoc.getDocRefNo());
                	}
                	
                	if (AppServiceDocValidationUtil.isSummonsDocumentType(documentTypeCode)) {
                		dto.setSummonsGeneratedInd(true);
                		break;
                	}
                	
                }
            }
            dto.setVersionAndNanos(reqs.getVersion());
        }
        return dto;
    }

    public static ReserviceRequestDetailDTO toDto(Case vCase) {
        ReserviceRequestDetailDTO dto = new ReserviceRequestDetailDTO();
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setCaseId(vCase.getCaseId());
        if (vCase.getCompsCourt() != null) {
            requestDTO.setCaseCourtSystem(DbCommonUtil.getDbValueOrEmpty(vCase.getCompsCourt()
                    .getCompsCourtCd()));
        }
        if (vCase.getCaseType() != null) {
            requestDTO.setCaseType(DbCommonUtil.getDbValueOrEmpty(vCase.getCaseType()
                    .getCaseTypeCd()));
        }

        requestDTO.setCaseSerialNo(vCase.getCaseSerNo());
        requestDTO.setCaseYear(vCase.getCaseYr());
        requestDTO.setCaseNo(SvdCommonUtil.getCaseNo(vCase));
        requestDTO.setRequestStatusType(new RequestStatusTypeDTO());
        dto.setRequest(requestDTO);
        dto.setServiceRequest(new ServiceRequestDTO());
        dto.setRequestAddress(new RequestAddressDTO());
        return dto;
    }

}
