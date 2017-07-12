package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.ProofOfServDocType;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PosDocumentTypeDTO;

/**
 * 
 * @version $Revision: 3291 $ $Date: 2017-01-13 16:51:17 +0800 (Fri, 13 Jan 2017) $
 * @author $Author: vicki.huang $
 */
public class PosDocumentTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param ProofOfServDocType
     *            entity
     * @return PosDocumentTypeDTO
     */
    public static PosDocumentTypeDTO toDto(ProofOfServDocType proofOfServDocType) {
        PosDocumentTypeDTO dto = new PosDocumentTypeDTO();
        if (proofOfServDocType != null && proofOfServDocType.getProofOfServDocTypeId() != null
                && proofOfServDocType.getProofOfServDocTypeId() != 0) {
            dto.setPosDocumentTypeId(proofOfServDocType.getProofOfServDocTypeId());
            dto.setPosDocumentTypeCode(DbCommonUtil.getDbValueOrEmpty(proofOfServDocType
                    .getProofOfServDocTypeCd()));
            dto.setPosDocumentTypeName(DbCommonUtil.getDbValueOrEmpty(proofOfServDocType
                    .getProofOfServDocTypeDesc()));
            dto.setVersionAndNanos(proofOfServDocType.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param ProofOfServDocTypes
     *            List of Entity
     * @return list of PosDocumentTypeDTO
     */
    public static List<PosDocumentTypeDTO> toDtoList(List<ProofOfServDocType> ProofOfServDocTypes) {
        List<PosDocumentTypeDTO> dtos = new ArrayList<PosDocumentTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(ProofOfServDocTypes)) {
            for (ProofOfServDocType ProofOfServDocType : ProofOfServDocTypes) {
                dtos.add(toDto(ProofOfServDocType));
            }
        }
        return dtos;
    }
}
