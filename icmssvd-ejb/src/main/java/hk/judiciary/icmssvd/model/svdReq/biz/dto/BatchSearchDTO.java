package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.sql.Timestamp;
import java.util.Date;

import hk.judiciary.icmssvd.model.BaseDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CaseTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ComprisingCourtDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.CourtRoomChambersDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.FpApplicationNatureTypeDTO;
import hk.judiciary.icmssvd.model.common.biz.dto.ProsecutionDepartmentDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class BatchSearchDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private ComprisingCourtDTO comprisingCourt;
    private CourtRoomChambersDTO courtRoomChambers;
    private Date hearingScheduleDate;
    private Timestamp hearingStartTime;
    private CaseTypeDTO caseType;
    private FpApplicationNatureTypeDTO fpApplicationNatureType;
    private ProsecutionDepartmentDTO prosecutionDepartment;
    private FunctionDTO func;

    public ComprisingCourtDTO getComprisingCourt() {
        return comprisingCourt;
    }

    public void setComprisingCourt(ComprisingCourtDTO comprisingCourt) {
        this.comprisingCourt = comprisingCourt;
    }

    public CourtRoomChambersDTO getCourtRoomChambers() {
        return courtRoomChambers;
    }

    public void setCourtRoomChambers(CourtRoomChambersDTO courtRoomChambers) {
        this.courtRoomChambers = courtRoomChambers;
    }

    public Date getHearingScheduleDate() {
        return hearingScheduleDate;
    }

    public void setHearingScheduleDate(Date hearingScheduleDate) {
        this.hearingScheduleDate = hearingScheduleDate;
    }

    public Timestamp getHearingStartTime() {
        return hearingStartTime;
    }

    public void setHearingStartTime(Timestamp hearingStartTime) {
        this.hearingStartTime = hearingStartTime;
    }

    public CaseTypeDTO getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseTypeDTO caseType) {
        this.caseType = caseType;
    }

    public FpApplicationNatureTypeDTO getFpApplicationNatureType() {
        return fpApplicationNatureType;
    }

    public void setFpApplicationNatureType(FpApplicationNatureTypeDTO fpApplicationNatureType) {
        this.fpApplicationNatureType = fpApplicationNatureType;
    }

    public ProsecutionDepartmentDTO getProsecutionDepartment() {
        return prosecutionDepartment;
    }

    public void setProsecutionDepartment(ProsecutionDepartmentDTO prosecutionDepartment) {
        this.prosecutionDepartment = prosecutionDepartment;
    }

    public FunctionDTO getFunc() {
        return func;
    }

    public void setFunc(FunctionDTO func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return "ReserviceBatchSearchDTO [comprisingCourt=" + comprisingCourt
                + ", courtRoomChambers=" + courtRoomChambers + ", hearingScheduleDate="
                + hearingScheduleDate + ", hearingStartTime=" + hearingStartTime + ", caseType="
                + caseType + ", fpApplicationNatureType=" + fpApplicationNatureType
                + ", prosecutionDepartment=" + prosecutionDepartment + ", func=" + func + "]";
    }

}
