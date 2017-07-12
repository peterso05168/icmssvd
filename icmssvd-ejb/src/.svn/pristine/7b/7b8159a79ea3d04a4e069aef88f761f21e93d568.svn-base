package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import java.util.Calendar;
import java.util.List;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.common.util.DateUtil;
import hk.judiciary.icms.model.dao.entity.Case;
import hk.judiciary.icms.model.dao.entity.HrnDtl;
import hk.judiciary.icms.model.dao.entity.HrnNat;
import hk.judiciary.icms.model.dao.entity.HrnSchd;
import hk.judiciary.icms.model.dao.entity.ListSchd;
import hk.judiciary.icms.model.dao.entity.LstList;
import hk.judiciary.icms.model.dao.entity.PdListCharcs;
import hk.judiciary.icmssvd.model.common.biz.assembler.ProsecutionDepartmentDTOAssembler;
import hk.judiciary.icmssvd.model.common.util.DbCommonUtil;
import hk.judiciary.icmssvd.model.common.util.SvdCommonUtil;
import hk.judiciary.icmssvd.model.svdReq.RequestConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.NextHearingDetailDTO;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.PartyDTO;

/**
 * 
 * @version $Revision: 5333 $ $Date: 2017-03-15 14:03:56 +0800 (Wed, 15 Mar 2017) $
 * @author $Author: vicki.huang $
 */
public class NextHearingDetailDTOAssembler {
    /**
     * parse entity to dto
     * 
     * @param hrnDtl
     *            entity
     * @return NextHearingDetailDTO
     */
    public static NextHearingDetailDTO toDto(HrnDtl hrnDtl, HrnSchd hrnSchd) {
        NextHearingDetailDTO dto = new NextHearingDetailDTO();
        if (hrnDtl != null && DbCommonUtil.isValidDbId(hrnDtl.getHrnDtlId())) {
            Case vcase = hrnDtl.getVcase();
            if (vcase != null) {
                dto.setCaseId(vcase.getCaseId());
                dto.setCaseNo(SvdCommonUtil.getCaseNo(vcase));
                if (vcase.getChrgNat() != null) {
                    dto.setProsecutionDepartment(ProsecutionDepartmentDTOAssembler.toDto(vcase
                            .getChrgNat().getPd()));
                }
                List<PartyDTO> partyDTOs = PartyDTOAssembler.toDtoList(vcase.getPartcpRole(),
                        RequestConstant.PARTICIPANT_ROLE_TYPE_DEFENDANT);
                if (!CommonUtil.isNullOrEmpty(partyDTOs)) {
                    dto.setDefendant(partyDTOs.get(0));
                }
                if (vcase.getCompsCourt() != null) {
                    dto.setComprisingCourtId(vcase.getCompsCourt().getCompsCourtId());
                }
                if (vcase.getCaseType() != null) {
                    dto.setCaseTypeId(vcase.getCaseType().getCaseTypeId());
                    List<HrnNat> hrnNats = vcase.getCaseType().getHrnNat();
                    if (!CommonUtil.isNullOrEmpty(hrnNats)) {
                        for (HrnNat hrnNat : hrnNats) {
                            if (RequestConstant.HRN_NAT_CD_RESERVICE.equals(hrnNat.getHrnNatCd())) {
                                dto.setHearingNatureId(hrnNat.getHrnNatId());
                                break;
                            }
                        }
                    }
                }
                if (vcase.getChrgNat() != null && vcase.getChrgNat().getFirstHrnTimeWgt() != null) {
                    dto.setHearingTimeWeightId(vcase.getChrgNat().getFirstHrnTimeWgt()
                            .getHrnTimeWgtId());
                }
                if (vcase.getSummonNoti() != null) {
                    dto.setFpApplicationNatureTypeId(vcase.getSummonNoti().getSummonNotiId());
                }
            }

            if (hrnDtl.getHrnSchd() != null) {
                dto.setOriginalHearingDate(hrnDtl.getHrnSchd().getHrnSchdDate());
                if (hrnDtl.getHrnSchd().getListSchd() != null) {
                    ListSchd listSchd = hrnDtl.getHrnSchd().getListSchd();
                    LstList list = listSchd.getList();
                    if (list != null && !CommonUtil.isNullOrEmpty(list.getListCharcs())) {
                        List<PdListCharcs> pdListCharcs = list.getListCharcs().get(0)
                                .getPdListCharcs();
                        if (!CommonUtil.isNullOrEmpty(pdListCharcs)) {
                            dto.setDayFromAllocation(pdListCharcs.get(0).getDayFrAlloc());
                        }
                    }
                    if (listSchd.getListType() != null) {
                        dto.setListTypeId(listSchd.getListType().getListTypeId());
                    }
                }
            }
            if (hrnSchd != null && DbCommonUtil.isValidDbId(hrnSchd.getHrnSchdId())) {
            	// Next hearing is scheduled
                dto.setHearingScheduleId(hrnSchd.getHrnSchdId());
                ListSchd listSchd = hrnSchd.getListSchd();
                if (listSchd != null) {
                    dto.setHearingScheduleDate(listSchd.getListSchdDate());
                    dto.setHearingStartTime(DateUtil.dateToString(listSchd.getListSchdDate(), "HH:mm"));
                    if (listSchd.getList() != null) {
                        dto.setListId(listSchd.getList().getListId());
                    }
                }
                if (hrnSchd.getHrnDtl() != null && hrnSchd.getHrnDtl().getCourtRmChmbr() != null) {
                    dto.setCourtRoomChambersName(hrnSchd.getHrnDtl().getCourtRmChmbr().getName());
                }
            } else {
            	// Default a new hearing date to schedule next hearing 
                Calendar calendar = Calendar.getInstance();
                if (dto.getOriginalHearingDate() != null) {
                    calendar.setTime(dto.getOriginalHearingDate());            	
                }
                if (dto.getDayFromAllocation() != null) {
                    calendar.add(Calendar.DATE, dto.getDayFromAllocation());
                }
                
                dto.setHearingScheduleDate(calendar.getTime());                
            }

            dto.setVersionAndNanos(hrnDtl.getVersion());
        }
        return dto;
    }
}
