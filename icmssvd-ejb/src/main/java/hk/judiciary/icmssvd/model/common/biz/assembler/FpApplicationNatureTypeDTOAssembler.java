package hk.judiciary.icmssvd.model.common.biz.assembler;

import java.util.ArrayList;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.FpAppNatType;
import hk.judiciary.icmssvd.model.common.biz.dto.FpApplicationNatureTypeDTO;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;

/**
 * 
 * @version $Revision: 90 $ $Date: 2016-11-11 11:34:12 +0800 (Fri, 11 Nov 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class FpApplicationNatureTypeDTOAssembler {
    /**
     * Copy properties from fpAppNatType to FpApplicationNatureTypeDTO
     * 
     * @param fpAppNatType
     *            The entity of the fpAppNatType.
     * 
     * @return FpApplicationNatureTypeDTO
     */
    public static FpApplicationNatureTypeDTO toDto(FpAppNatType fpAppNatType) {
        FpApplicationNatureTypeDTO dto = new FpApplicationNatureTypeDTO();
        if (fpAppNatType != null && DbCommonUtil.isValidDbId(fpAppNatType.getFpAppNatTypeId())) {
            dto.setFpApplicationNatureTypeId(fpAppNatType.getFpAppNatTypeId());
            dto.setSeqNo(fpAppNatType.getSeqNo());
            dto.setFpApplicationNatureCode(DbCommonUtil.getDbValueOrEmpty(fpAppNatType.getCd()));
            dto.setEnglishFpApplicationNatureTypeName(DbCommonUtil.getDbValueOrEmpty(fpAppNatType
                    .getDescEng()));
            dto.setChineseFpApplicationNatureTypeName(DbCommonUtil.getDbValueOrEmpty(fpAppNatType
                    .getDescChin()));
            dto.setVersionAndNanos(fpAppNatType.getVersion());
        }
        return dto;
    }

    /**
     * Copy properties from fpAppNatType to FpApplicationNatureTypeDTO
     * 
     * @param fpAppNatType
     *            List of fpAppNatType.
     * 
     * @return The list of FpApplicationNatureTypeDTO
     */
    public static List<FpApplicationNatureTypeDTO> toDtoList(List<FpAppNatType> fpAppNatTypes) {
        List<FpApplicationNatureTypeDTO> FpApplicationNatureTypeDTOList = new ArrayList<FpApplicationNatureTypeDTO>();
        if (!CommonUtil.isNullOrEmpty(fpAppNatTypes)) {
            for (FpAppNatType fpAppNatType : fpAppNatTypes) {
                FpApplicationNatureTypeDTOList.add(toDto(fpAppNatType));
            }
        }
        return FpApplicationNatureTypeDTOList;
    }

}
