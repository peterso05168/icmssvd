package hk.judiciary.icmssvd.model.report.constant;

import hk.judiciary.fmk.common.util.ReportUtil;

public enum SvdReportConstant {
	RPT_SVD_COVER ("RPT-SVD-COVER", "RPT-SVD-COVER", ReportUtil.ReportFormat.PDF),
	RPT_SVD_CERT_SER ("RPT-SVD-CERT-SER", "RPT-SVD-CERT-SER", ReportUtil.ReportFormat.PDF),
	RPT_SVD_CL ("RPT-SVD-CL", "RPT-SVD-CL", ReportUtil.ReportFormat.PDF),
	RPT_SVD_N ("RPT-SVD-N", "RPT-SVD-N", ReportUtil.ReportFormat.PDF),
	RPT_SVD_Z ("RPT-SVD-Z", "RPT-SVD-Z", ReportUtil.ReportFormat.PDF),
	RPT_SVD_L ("RPT-SVD-L", "RPT-SVD-L", ReportUtil.ReportFormat.PDF),
	RPT_SVD_M ("RPT-SVD-M", "RPT-SVD-M", ReportUtil.ReportFormat.PDF),
	RPT_SVD_P ("RPT-SVD-P", "RPT-SVD-P", ReportUtil.ReportFormat.PDF),
	RPT_SVD_D ("RPT-SVD-D", "RPT-SVD-D", ReportUtil.ReportFormat.PDF),
	RPT_SVD_S ("RPT-SVD-S", "RPT-SVD-S", ReportUtil.ReportFormat.PDF),
	RPT_SVD_R ("RPT-SVD-R", "RPT-SVD-R", ReportUtil.ReportFormat.PDF),
	RPT_SVD_V ("RPT-SVD-V", "RPT-SVD-V", ReportUtil.ReportFormat.PDF),
	RPT_SVD_K ("RPT-SVD-K", "RPT-SVD-K", ReportUtil.ReportFormat.PDF),
	RPT_SVD_FS ("RPT-SVD-FS", "RPT-SVD-FS", ReportUtil.ReportFormat.PDF),
	RPT_SVD_FN ("RPT-SVD-FN", "RPT-SVD-FN", ReportUtil.ReportFormat.PDF),
	RPT_SVD_LO ("RPT-SVD-LO", "RPT-SVD-LO", ReportUtil.ReportFormat.PDF),
	RPT_SVD_PGBL ("RPT-SVD-PGBL", "RPT-SVD-PGBL", ReportUtil.ReportFormat.PDF),
    RPT_SVD_POS_BK ("RPT-SVD-CERT-POS-BK", "RPT-SVD-CERT-POS-BK", ReportUtil.ReportFormat.PDF),
    RPT_SVD_POS_DS ("RPT-SVD-CERT-POS-DS", "RPT-SVD-CERT-POS-DS", ReportUtil.ReportFormat.PDF),
    RPT_SVD_D_RES ("RPT-SVD-D-RES", "RPT-SVD-D-RES", ReportUtil.ReportFormat.PDF),
	RPT_SVD_S_RES ("RPT-SVD-S-RES", "RPT-SVD-S-RES", ReportUtil.ReportFormat.PDF),
	RPT_SVD_R_RES ("RPT-SVD-R-RES", "RPT-SVD-R-RES", ReportUtil.ReportFormat.PDF),
	RPT_SVD_V_RES ("RPT-SVD-V-RES", "RPT-SVD-V-RES", ReportUtil.ReportFormat.PDF),
	RPT_SVD_K_RES ("RPT-SVD-K-RES", "RPT-SVD-K-RES", ReportUtil.ReportFormat.PDF),
	RPT_SVD_FS_RES ("RPT-SVD-FS-RES", "RPT-SVD-FS-RES", ReportUtil.ReportFormat.PDF); 
	
	private String reportName;
	private String reportTypeCode;
	private String reportFormat;
	
	private SvdReportConstant(String reportName, String reportTypeCode, String reportFormat) {
		this.reportName = reportName;
		this.reportTypeCode = reportTypeCode;
		this.reportFormat = reportFormat;
	}
	
	public String getReportName() {
		return reportName;
	}
	public String getReportTypeCode() {
		return reportTypeCode;
	}
	public String getReportFormat() {
		return reportFormat;
	}

}

