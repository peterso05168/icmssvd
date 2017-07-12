package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.DocClass;
import hk.judiciary.icmssvd.model.common.biz.dto.DocumentClassDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class DocumentClassDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param docClass
     *            entity
     * @return DocumentClassDTO
     */
    public static DocumentClassDTO toDto(DocClass docClass) {
        DocumentClassDTO dto = new DocumentClassDTO();
        if (docClass != null && docClass.getDocClassId() != null && docClass.getDocClassId() != 0) {
            dto.setDocumentClassId(docClass.getDocClassId());
            dto.setDocumentClassCode(DbCommonUtil.getDbValueOrEmpty(docClass.getDocClassCd()));
            dto.setDocumentClassName(DbCommonUtil.getDbValueOrEmpty(docClass.getDocClassDesc()));
            dto.setVersionAndNanos(docClass.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param docClasss
     *            List of Entity
     * @return list of DocumentClassDTO
     */
    public static List<DocumentClassDTO> toDtoList(List<DocClass> docClasss) {
        List<DocumentClassDTO> dtos = new ArrayList<DocumentClassDTO>();
        if (!CommonUtil.isNullOrEmpty(docClasss)) {
            for (DocClass docClass : docClasss) {
                dtos.add(toDto(docClass));
            }

        }
        return dtos;
    }
}
