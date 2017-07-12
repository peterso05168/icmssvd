package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.BlfTaskRsltRsn;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultReasonDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffTaskResultReasonDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param rsltRsn
     *            entity
     * @return ResultReasonDTO
     */
    public static BailiffTaskResultReasonDTO toDto(BlfTaskRsltRsn blfTaskRsltRsn) {
        BailiffTaskResultReasonDTO dto = new BailiffTaskResultReasonDTO();
        if (blfTaskRsltRsn != null && blfTaskRsltRsn.getBlfTaskRsltRsnId() != null
                && blfTaskRsltRsn.getBlfTaskRsltRsnId() != 0) {
            dto.setBailiffTaskResultReasonId(blfTaskRsltRsn.getBlfTaskRsltRsnId());
            dto.setBailiffTaskResultReasonName(DbCommonUtil.getDbValueOrEmpty(blfTaskRsltRsn
                    .getBlfTaskRsltRsnDesc()));
            dto.setVersionAndNanos(blfTaskRsltRsn.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param rsltRsns
     *            List of Entity
     * @return list of ResultReasonDTO
     */
    public static List<BailiffTaskResultReasonDTO> toDtoList(List<BlfTaskRsltRsn> blfTaskRsltRsns) {
        List<BailiffTaskResultReasonDTO> dtos = new ArrayList<BailiffTaskResultReasonDTO>();
        if (!CommonUtil.isNullOrEmpty(blfTaskRsltRsns)) {
            for (BlfTaskRsltRsn blfTaskRsltRsn : blfTaskRsltRsns) {
                dtos.add(toDto(blfTaskRsltRsn));
            }
        }
        return dtos;
    }
}
