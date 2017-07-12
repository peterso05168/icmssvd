package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.CourtLvlType;
import hk.judiciary.icms.model.dao.entity.DocType;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.FunctionDTO;

/**
 * 
 * @version $Revision: 6787 $ $Date: 2017-05-09 18:09:55 +0800 (週二, 09 五月 2017) $
 * @author $Author: mtse $
 */
public class DocumentTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param docType
     *            entity
     * @return DocumentTypeDTO
     */
    public static DocumentTypeDTO toDto(DocType docType) {
        DocumentTypeDTO dto = new DocumentTypeDTO();
        if (docType != null && docType.getDocTypeId() != null && docType.getDocTypeId() != 0) {
            dto.setDocumentTypeId(docType.getDocTypeId());
            dto.setDocumentTypeCode(DbCommonUtil.getDbValueOrEmpty(docType.getDocTypeCd()));
            dto.setDocumentTypeName(DbCommonUtil.getDbValueOrEmpty(docType.getDocTypeDesc()));
            dto.setVersionAndNanos(docType.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param docTypes
     *            List of Entity
     * @return list of DocumentTypeDTO
     */
    public static List<DocumentTypeDTO> toDtoList(List<DocType> docTypes, FunctionDTO function) {
        List<DocumentTypeDTO> dtos = new ArrayList<DocumentTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(docTypes)) {
            for (DocType docType : docTypes) {
                CourtLvlType courtLvlType = docType.getCourtLvlType();
                if (courtLvlType != null
                        && courtLvlType.getCourtLvlTypeCd()
                                .equals(function.getCourtLevelTypeCode())) {            	
                	dtos.add(toDto(docType));
                }
            }

        }
        return dtos;
    }
}
