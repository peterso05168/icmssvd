package hk.judiciary.icmssvd.model.common.biz.assembler;

import hk.judiciary.icms.model.dao.entity.IntlUserAc;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.IntlUserAcDTO;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (Wed, 15 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class IntlUserAcDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param IntlUserAc
     *            entity
     * @return IntlUserAcDTO
     */
    public static IntlUserAcDTO toDto(IntlUserAc intlUserAc) {
        IntlUserAcDTO dto = new IntlUserAcDTO();
        if (intlUserAc != null && intlUserAc.getIntlUserAcId() != null
                && intlUserAc.getIntlUserAcId() != 0) {
            dto.setIntlUserAcId(intlUserAc.getIntlUserAcId());
            dto.setLoginName(DbCommonUtil.getDbValueOrEmpty(intlUserAc.getLoginName()));
            dto.setEnglishSurname(DbCommonUtil.getDbValueOrEmpty(intlUserAc.getSurname()));
            dto.setEnglishGivenName(DbCommonUtil.getDbValueOrEmpty(intlUserAc.getGivenName()));
            dto.setChineseSurname(DbCommonUtil.getDbValueOrEmpty(intlUserAc.getSurnameChin()));
            dto.setChineseGivenName(DbCommonUtil.getDbValueOrEmpty(intlUserAc.getGivenNameChin()));
            dto.setVersionAndNanos(intlUserAc.getVersion());
        }
        return dto;
    }

}
