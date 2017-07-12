package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.BlfTaskRsltStatus;
import hk.judiciary.icmssvd.model.common.biz.dto.BailiffTaskResultStatusDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class BailiffTaskResultStatusDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param RsltStatus
     *            entity
     * @return ResultStatusDTO
     */
    public static BailiffTaskResultStatusDTO toDto(BlfTaskRsltStatus blfTaskRsltStatus) {
        BailiffTaskResultStatusDTO dto = new BailiffTaskResultStatusDTO();
        if (blfTaskRsltStatus != null && blfTaskRsltStatus.getBlfTaskRsltStatusId() != null
                && blfTaskRsltStatus.getBlfTaskRsltStatusId() != 0) {

            dto.setBailiffTaskResultStatusId(blfTaskRsltStatus.getBlfTaskRsltStatusId());
            dto.setBailiffTaskResultStatusName(DbCommonUtil.getDbValueOrEmpty(blfTaskRsltStatus
                    .getBlfTaskRsltStatusDesc()));
            dto.setVersionAndNanos(blfTaskRsltStatus.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param RsltStatus
     *            List of Entity
     * @return list of ResultStatusDTO
     */
    public static List<BailiffTaskResultStatusDTO> toDtoList(
            List<BlfTaskRsltStatus> blfTaskRsltStatus) {
        List<BailiffTaskResultStatusDTO> dtos = new ArrayList<BailiffTaskResultStatusDTO>();
        if (!CommonUtil.isNullOrEmpty(blfTaskRsltStatus)) {
            for (BlfTaskRsltStatus blfTaskRsltSta : blfTaskRsltStatus) {
                dtos.add(toDto(blfTaskRsltSta));
            }
        }
        return dtos;
    }
}
