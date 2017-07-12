package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.PartcpRoleCat;
import hk.judiciary.icmssvd.model.common.biz.dto.ParticipantRoleCategoryDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class ParticipantRoleCategoryDTOAssembler {
    public static ParticipantRoleCategoryDTO toDto(PartcpRoleCat partcpRoleCat) {
        ParticipantRoleCategoryDTO dto = new ParticipantRoleCategoryDTO();
        if (partcpRoleCat != null && partcpRoleCat.getPartcpRoleCatId() != null
                && partcpRoleCat.getPartcpRoleCatId() != 0) {
            dto.setParticipantRoleCategoryId(partcpRoleCat.getPartcpRoleCatId());
            dto.setParticipantRoleCategoryName(DbCommonUtil.getDbValueOrEmpty(partcpRoleCat
                    .getPartcpRoleCatDesc()));
            dto.setParticipantRoleCategoryCode(DbCommonUtil.getDbValueOrEmpty(partcpRoleCat
                    .getPartcpRoleCatCd()));
            dto.setVersionAndNanos(partcpRoleCat.getVersion());
        }
        return dto;
    }

    public static List<ParticipantRoleCategoryDTO> toDtoList(List<PartcpRoleCat> partcpRoleCats) {
        List<ParticipantRoleCategoryDTO> list = new ArrayList<ParticipantRoleCategoryDTO>();
        if (!CommonUtil.isNullOrEmpty(partcpRoleCats)) {
            for (PartcpRoleCat partcpRoleCat : partcpRoleCats) {
                list.add(toDto(partcpRoleCat));
            }
        }
        return list;
    }
}
