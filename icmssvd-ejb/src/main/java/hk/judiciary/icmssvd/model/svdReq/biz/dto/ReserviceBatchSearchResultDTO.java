package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (Fri, 30 Dec 2016) $
 * @author $Author: vicki.huang $
 */
public class ReserviceBatchSearchResultDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer batchSeqNo;
    private String recordMode;
    private NextHearingDetailDTO nextHearingDetail;
    private ReserviceRequestDetailDTO reserviceRequestDetail;
    private FunctionDTO func;

    public Integer getBatchSeqNo() {
        return batchSeqNo;
    }

    public void setBatchSeqNo(Integer batchSeqNo) {
        this.batchSeqNo = batchSeqNo;
    }

    public String getRecordMode() {
        return recordMode;
    }

    public void setRecordMode(String recordMode) {
        this.recordMode = recordMode;
    }

    public NextHearingDetailDTO getNextHearingDetail() {
        return nextHearingDetail;
    }

    public void setNextHearingDetail(NextHearingDetailDTO nextHearingDetail) {
        this.nextHearingDetail = nextHearingDetail;
    }

    public ReserviceRequestDetailDTO getReserviceRequestDetail() {
        return reserviceRequestDetail;
    }

    public void setReserviceRequestDetail(ReserviceRequestDetailDTO reserviceRequestDetail) {
        this.reserviceRequestDetail = reserviceRequestDetail;
    }

    public FunctionDTO getFunc() {
        return func;
    }

    public void setFunc(FunctionDTO func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return "ReserviceBatchSearchResultDTO [batchSeqNo=" + batchSeqNo + ", recordMode="
                + recordMode + ", nextHearingDetail=" + nextHearingDetail
                + ", reserviceRequestDetail=" + reserviceRequestDetail + ", func=" + func + "]";
    }

}
