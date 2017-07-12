package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.RequestServiceTypeDTO;

/**
 * 
 * @version $Revision: 6473 $ $Date: 2017-04-24 18:09:35 +0800 (週一, 24 四月 2017) $
 * @author $Author: vicki.huang $
 */
public class RequestServiceTypeDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param reqsDoc
     *            entity
     * @return RequestServiceTypeDTO
     */
    public static RequestServiceTypeDTO toDto(Integer caseSeqNo) {
        RequestServiceTypeDTO dto = new RequestServiceTypeDTO();
        if (caseSeqNo != null) {
            if (caseSeqNo == 1) {
                dto.setRequestServiceType(RequestConstant.REQUEST_SERVICE_TYPE_FRIST);
                dto.setRequestServiceTypeName(RequestConstant.REQUEST_SERVICE_TYPE_NAME_FRIST);
            } else if (caseSeqNo > 1) {
                dto.setRequestServiceType(RequestConstant.REQUEST_SERVICE_TYPE_RESERVICE);
                dto.setRequestServiceTypeName(RequestConstant.REQUEST_SERVICE_TYPE_NAME_RESERVICE);
            }
        }
        return dto;
    }

}
