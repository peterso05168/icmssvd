package hk.judiciary.icmssvd.model.courtCase.biz.dto;

import java.io.Serializable;
import java.util.List;

public class CustomAccessInfoDTO extends CommonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<ComprisingCourtDTO> compsCourts;

	public List<ComprisingCourtDTO> getCompsCourts() {
		return compsCourts;
	}
	public void setCompsCourts(List<ComprisingCourtDTO> compsCourts) {
		this.compsCourts = compsCourts;
	}

	
}
