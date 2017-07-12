package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.DocStatus;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentStatusDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class DocumentStatusDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param docStatus
     *            entity
     * @return DocumentStatusDTO
     */
    public static DocumentStatusDTO toDto(DocStatus docStatus) {
        DocumentStatusDTO dto = new DocumentStatusDTO();
        if (docStatus != null && docStatus.getDocStatusId() != null
                && docStatus.getDocStatusId() != 0) {
            dto.setDocumentStatusId(docStatus.getDocStatusId());
            dto.setDocumentStatusCode(DbCommonUtil.getDbValueOrEmpty(docStatus.getDocStatusCd()));
            dto.setDocumentStatusName(DbCommonUtil.getDbValueOrEmpty(docStatus.getDocStatusDesc()));
            dto.setVersionAndNanos(docStatus.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param docStatuss
     *            List of Entity
     * @return list of DocumentStatusDTO
     */
    public static List<DocumentStatusDTO> toDtoList(List<DocStatus> docStatuss) {
        List<DocumentStatusDTO> dtos = new ArrayList<DocumentStatusDTO>();
        if (!CommonUtil.isNullOrEmpty(docStatuss)) {
            for (DocStatus docStatus : docStatuss) {
                dtos.add(toDto(docStatus));
            }

        }
        return dtos;
    }
}
