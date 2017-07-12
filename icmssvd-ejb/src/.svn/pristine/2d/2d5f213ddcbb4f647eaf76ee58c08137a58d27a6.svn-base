package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.BlfTask;
import hk.judiciary.icms.model.dao.entity.IntlUserAc;
import hk.judiciary.icms.model.dao.entity.ProofOfServReqs;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ServReqs;
import hk.judiciary.icmssvd.model.common.biz.assembler.ComprisingCourtDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.CourtRoomChambersDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.PosDocumentTypeDTOAssembler;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosRequestDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class PosRequestDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param proofOfServReqs
     *            entity
     * @return PosRequestDTO
     */
    public static PosRequestDTO toDto(ProofOfServReqs proofOfServReqs) {
        PosRequestDTO dto = new PosRequestDTO();
        if (proofOfServReqs != null && proofOfServReqs.getProofOfServReqsId() != null
                && proofOfServReqs.getProofOfServReqsId() != 0) {
            dto.setPosRequestId(proofOfServReqs.getProofOfServReqsId());
            Reqs reqs = proofOfServReqs.getReqs();
            if (reqs != null) {
                dto.setRequestId(reqs.getReqsId());
                ServReqs servReqs = reqs.getServReqs();
                if (servReqs != null) {
                    dto.setServiceRequestId(servReqs.getServReqsId());
                }
            }
            BlfTask successTask = proofOfServReqs.getSuccessTask();
            if (successTask != null) {
                dto.setSuccessfulTaskId(successTask.getBlfTaskId());
            }
            dto.setPosDocumentInd(CommonUtil.toBoolean(proofOfServReqs.getProofOfDocFlag()));
            dto.setPosDocumentDueDate(proofOfServReqs.getProofByDocDueDate());
            dto.setPosDocumentType(PosDocumentTypeDTOAssembler.toDto(proofOfServReqs
                    .getProofByDocType()));
            dto.setAttendCourtPersonInd(CommonUtil.toBoolean(proofOfServReqs
                    .getAttdCourtInPersonFlag()));
            dto.setPosHearingDatetime(proofOfServReqs.getProofOfServHrnDt());
            IntlUserAc reqsBy = proofOfServReqs.getReqsBy();
            if (reqsBy != null) {
                dto.setRequestedBy(reqsBy.getIntlUserAcId());
            }
            dto.setComprisingCourt(ComprisingCourtDTOAssembler.toDto(proofOfServReqs
                    .getCompsCourt()));
            dto.setCourtRoomChambers(CourtRoomChambersDTOAssembler.toDto(proofOfServReqs
                    .getCourtRmChmbr()));
            dto.setVersionAndNanos(proofOfServReqs.getVersion());
        }
        return dto;
    }
}
