package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Pd;
import hk.judiciary.icmssvd.model.common.biz.dto.ProsecutionDepartmentDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.biz.assembler.AddressDTOAssembler;

/**
 * 
 * @version $Revision: 90 $ $Date: 2016-11-11 11:34:12 +0800 (Fri, 11 Nov 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class ProsecutionDepartmentDTOAssembler {
    /**
     * Copy properties from pd to ProsecutionDepartmentDTO
     * 
     * @param pd
     *            The entity of the pd.
     * 
     * @return ProsecutionDepartmentDTO
     */
    public static ProsecutionDepartmentDTO toDto(Pd pd) {
        ProsecutionDepartmentDTO dto = new ProsecutionDepartmentDTO();
        if (pd != null && DbCommonUtil.isValidDbId(pd.getPdId())) {
            dto.setProsecutionDepartmentCodeId(pd.getPdId());
            dto.setSeqNo(pd.getSeqNo());
            dto.setProsecutionDepartmentCode(DbCommonUtil.getDbValueOrEmpty(pd.getPdCd()));
            dto.setProsecutionDepartmentName(DbCommonUtil.getDbValueOrEmpty(pd.getPdName()));
            dto.setProsecutionDepartmentChineseName(DbCommonUtil.getDbValueOrEmpty(pd
                    .getPdNameChin()));
            dto.setTelephoneNo(DbCommonUtil.getDbValueOrEmpty(pd.getTelNo()));
            dto.setFaxNo(DbCommonUtil.getDbValueOrEmpty(pd.getFaxNo()));
            dto.setMobileNo(DbCommonUtil.getDbValueOrEmpty(pd.getMobiNo()));
            dto.setAddress(AddressDTOAssembler.toDto(pd.getAddr()));
            dto.setEnglishDepartmentHeadTitle(DbCommonUtil.getDbValueOrEmpty(pd
                    .getDeptHeadTitleEng()));
            dto.setChineseDepartmentHeadTitle(DbCommonUtil.getDbValueOrEmpty(pd
                    .getDeptHeadTitleChi()));
            dto.setVersionAndNanos(pd.getVersion());
        }
        return dto;
    }

    /**
     * Copy properties from pd to ProsecutionDepartmentDTO
     * 
     * @param pd
     *            List of pd.
     * 
     * @return The list of ProsecutionDepartmentDTO
     */
    public static List<ProsecutionDepartmentDTO> toDtoList(List<Pd> pds) {
        List<ProsecutionDepartmentDTO> prosecutionDepartmentDTOList = new ArrayList<ProsecutionDepartmentDTO>();
        if (!CommonUtil.isNullOrEmpty(pds)) {
            for (Pd pd : pds) {
                prosecutionDepartmentDTOList.add(toDto(pd));
            }
        }
        return prosecutionDepartmentDTOList;
    }

}
