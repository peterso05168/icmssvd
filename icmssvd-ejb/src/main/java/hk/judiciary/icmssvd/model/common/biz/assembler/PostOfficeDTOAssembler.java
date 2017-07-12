package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.PostOffice;
import hk.judiciary.icmssvd.model.common.biz.dto.PostOfficeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (週三, 15 三月 2017) $
 * @author $Author: vicki.huang $
 */
public class PostOfficeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param postOffice
     *            entity
     * @return PostOfficeDTO
     */
    public static PostOfficeDTO toDto(PostOffice postOffice) {
        PostOfficeDTO dto = new PostOfficeDTO();
        if (postOffice != null && postOffice.getPostOfficeId() != null
                && postOffice.getPostOfficeId() != 0) {
            dto.setPostOfficeId(postOffice.getPostOfficeId());
            dto.setPostOfficeName(DbCommonUtil.getDbValueOrEmpty(postOffice.getPostOfficeDesc()));
            dto.setPostOfficeCode(DbCommonUtil.getDbValueOrEmpty(postOffice.getPostOfficeCd()));
            dto.setVersionAndNanos(postOffice.getVersion());
        }
        return dto;
    }

    /**
     * parse entity list to dto list
     * 
     * @param postOffices
     *            List of Entity
     * @return list of PostOfficeDTO
     */
    public static List<PostOfficeDTO> toDtoList(List<PostOffice> postOffices) {
        List<PostOfficeDTO> dtos = new ArrayList<PostOfficeDTO>();
        if (!CommonUtil.isNullOrEmpty(postOffices)) {
            for (PostOffice postOffice : postOffices) {
                dtos.add(toDto(postOffice));
            }
        }
        return dtos;
    }
}
