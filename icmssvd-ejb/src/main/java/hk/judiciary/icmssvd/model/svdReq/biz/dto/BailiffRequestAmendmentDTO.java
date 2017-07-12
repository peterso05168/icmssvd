package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import java.sql.Timestamp;

import hk.judiciary.icmssvd.model.BaseDTO;
             
public class BailiffRequestAmendmentDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Integer bailiffRequestAmendmentId;
	private Integer requestId;
	private Timestamp amendmentDatetime;
	private IntlUserAcDTO intlUserAcDTO;
	private String amendmentDetail;

	public Integer getBailiffRequestAmendmentId() {
		return bailiffRequestAmendmentId;
	}

	public void setBailiffRequestAmendmentId(Integer bailiffRequestAmendmentId) {
		this.bailiffRequestAmendmentId = bailiffRequestAmendmentId;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Timestamp getAmendmentDatetime() {
		return amendmentDatetime;
	}

	public void setAmendmentDatetime(Timestamp amendmentDatetime) {
		this.amendmentDatetime = amendmentDatetime;
	}

	public IntlUserAcDTO getIntlUserAcDTO() {
		return intlUserAcDTO;
	}

	public void setIntlUserAcDTO(IntlUserAcDTO intlUserAcDTO) {
		this.intlUserAcDTO = intlUserAcDTO;
	}

	public String getAmendmentDetail() {
		return amendmentDetail;
	}

	public void setAmendmentDetail(String amendmentDetail) {
		this.amendmentDetail = amendmentDetail;
	}

	@Override
	public String toString() {
		return "BailiffRequestAmendmentDTO [bailiffRequestAmendmentId=" + bailiffRequestAmendmentId + ", requestId="
				+ requestId + ", amendmentDatetime=" + amendmentDatetime + ", intlUserAcDTO=" + intlUserAcDTO
				+ ", amendmentDetail=" + amendmentDetail + "]";
	}

}
