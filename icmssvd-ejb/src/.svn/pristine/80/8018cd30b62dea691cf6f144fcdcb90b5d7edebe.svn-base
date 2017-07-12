package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ReqsDoc;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.DocumentDraftDTO;

/**
 * 
 * @version $Revision: 6002 $ $Date: 2017-03-30 18:32:23 +0800 (Thu, 30 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class DocumentDraftDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqsDoc
     *            entity
     * @return DocumentDraftDTO
     */
    public static DocumentDraftDTO toDto(ReqsDoc reqsDoc) {
        DocumentDraftDTO dto = new DocumentDraftDTO();
        if (reqsDoc != null && DbCommonUtil.isValidDbId(reqsDoc.getReqsDocId())) {
            dto.setRequestDocument(RequestDocumentDTOAssembler.toDto(reqsDoc));
            dto.setSelectedDocumentInd(true);
            dto.setVersionAndNanos(reqsDoc.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param reqsDocs
     *            List of Entity
     * @return list of DocumentDraftDTO
     */
    public static List<DocumentDraftDTO> toDtoList(List<ReqsDoc> reqsDocs) {
        List<DocumentDraftDTO> dtos = new ArrayList<DocumentDraftDTO>();
        
        if (!CommonUtil.isNullOrEmpty(reqsDocs)) {        	
            for (ReqsDoc reqsDoc : reqsDocs) {            	
            	if (CommonUtil.isNullOrEmpty(reqsDoc.getDoc()) && !CommonUtil.isNullOrEmpty(reqsDoc.getDocRefNo())) { 
            		dtos.add(toDto(reqsDoc));            		
            	}
            }            
        }
        return dtos;
    }
}
