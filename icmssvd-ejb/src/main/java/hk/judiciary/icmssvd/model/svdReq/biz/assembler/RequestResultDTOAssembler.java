package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ReqsRslt;
import hk.judiciary.icmssvd.model.common.biz.assembler.BailiffTaskResultReasonDTOAssembler;
import hk.judiciary.icmssvd.model.common.biz.assembler.BailiffTaskResultStatusDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestResultDTO;

/**
 * 
 * @version $Revision: 7268 $ $Date: 2017-06-01 14:25:01 +0800 (週四, 01 六月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestResultDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqsRslt
     *            entity
     * @return RequestResultDTO
     */
    public static RequestResultDTO toDto(ReqsRslt reqsRslt) {
        RequestResultDTO dto = new RequestResultDTO();
        if (reqsRslt != null && reqsRslt.getBlfReqsRsltId() != null
                && reqsRslt.getBlfReqsRsltId() != 0) {
            dto.setRequestResultId(reqsRslt.getBlfReqsRsltId());
            if (reqsRslt.getBlfReqs() != null) {
                dto.setRequestId(reqsRslt.getBlfReqs().getReqsId());
            }
            dto.setBailiffTaskResultStatus(BailiffTaskResultStatusDTOAssembler.toDto(reqsRslt
                    .getRsltStatus()));
            dto.setEndorsementDate(reqsRslt.getEndorDate());
            dto.setBailiffTaskResultReason(BailiffTaskResultReasonDTOAssembler.toDto(reqsRslt
                    .getRsltRsn()));
            dto.setServiceDate(reqsRslt.getServDate());
            dto.setServiceReturnDate(reqsRslt.getServRtnDate());
            dto.setRequestResultNotes(DbCommonUtil.getDbValueOrEmpty(reqsRslt.getBlfReqsRsltNote()));
            dto.setProcessedBy(DbCommonUtil.getDbValueOrEmpty(reqsRslt.getProcBy()));
            dto.setAttemptNo(reqsRslt.getAtmptNo());
            dto.setVersionAndNanos(reqsRslt.getVersion());
        }
        return dto;
    }

    public static RequestResultDTO toDto(List<ReqsRslt> reqsRslts) {
        RequestResultDTO dto = new RequestResultDTO();
        if (!CommonUtil.isNullOrEmpty(reqsRslts)) {
            dto = toDto(reqsRslts.get(0));
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param reqsRslts
     *            List of Entity
     * @return list of RequestResultDTO
     */
    public static List<RequestResultDTO> toDtoList(List<ReqsRslt> reqsRslts) {
        List<RequestResultDTO> dtos = new ArrayList<RequestResultDTO>();
        if (!CommonUtil.isNullOrEmpty(reqsRslts)) {
            for (ReqsRslt reqsRslt : reqsRslts) {
                dtos.add(toDto(reqsRslt));
            }
        }
        return dtos;
    }
}
