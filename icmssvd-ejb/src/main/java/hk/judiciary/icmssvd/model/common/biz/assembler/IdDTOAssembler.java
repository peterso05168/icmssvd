package hk.judiciary.icmssvd.model.common.biz.assembler;

import hk.judiciary.icmssvd.model.common.biz.dto.IdDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class IdDTOAssembler {
    public static IdDTO toDto(Integer id) {
        IdDTO dto = new IdDTO();
        dto.setId(id);
        return dto;
    }
}
