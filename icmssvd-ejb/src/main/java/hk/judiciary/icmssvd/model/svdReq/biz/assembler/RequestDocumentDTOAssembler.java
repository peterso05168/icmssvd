package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ReqsDoc;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestDocumentDTO;

/**
 * 
 * @version $Revision: 7569 $ $Date: 2017-06-15 18:07:40 +0800 (週四, 15 六月 2017) $
 * @author $Author: mtse $
 */
public class RequestDocumentDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqsDoc
     *            entity
     * @return RequestDocumentDTO
     */
    public static RequestDocumentDTO toDto(ReqsDoc reqsDoc) {
        RequestDocumentDTO dto = new RequestDocumentDTO();
        if (reqsDoc != null && reqsDoc.getReqsDocId() != null && reqsDoc.getReqsDocId() != 0) {
            dto.setRequestDocumentId(reqsDoc.getReqsDocId());
            if (reqsDoc.getBlfReqs() != null) {
                dto.setRequestId(reqsDoc.getBlfReqs().getReqsId());
            }
            dto.setDocumentSeqNo(reqsDoc.getDocSeqNo());
            if (reqsDoc.getDoc() != null) {
                dto.setDocumentId(reqsDoc.getDoc().getDocId());
            }
            if (reqsDoc.getBlfDocStatusType() != null) {
                dto.setBailiffDocumentStatusId(reqsDoc.getBlfDocStatusType().getBlfDocStatusTypeId());
            }
            dto.setAdminSupportFileId(reqsDoc.getAdmAndSuppFileId());
            dto.setDocumentReferenceNo(reqsDoc.getDocRefNo());            
            dto.setActionRequestInd(CommonUtil.toBoolean(reqsDoc.getActReqFlag()));
            dto.setPrintedInd(CommonUtil.toBoolean(reqsDoc.getPrtFlag()));
//            dto.setHardcopyInd(CommonUtil.toBoolean(reqsDoc.getHardcopyFlag()));
            dto.setReceiveDate(reqsDoc.getRecvDate());
            dto.setIssueDate(reqsDoc.getIssueDate());
            dto.setVersionAndNanos(reqsDoc.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param reqsDocs
     *            List of Entity
     * @return list of RequestDocumentDTO
     */
    public static List<RequestDocumentDTO> toDtoList(List<ReqsDoc> reqsDoces) {
        List<RequestDocumentDTO> dtos = new ArrayList<RequestDocumentDTO>();
        if (!CommonUtil.isNullOrEmpty(reqsDoces)) {
            for (ReqsDoc reqsDoc : reqsDoces) {
                dtos.add(toDto(reqsDoc));
            }
        }
        return dtos;
    }
}
