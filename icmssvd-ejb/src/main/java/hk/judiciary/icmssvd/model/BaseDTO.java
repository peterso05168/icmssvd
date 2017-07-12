package hk.judiciary.icmssvd.model;

import java.sql.Timestamp;

import hk.judiciary.fmk.ejb.biz.dto.AbstractDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class BaseDTO extends AbstractDTO {

    private static final long serialVersionUID = 1L;

    private Integer nanos;

    private boolean needValidate = true;

    private String errorBoxComponentId;

    private String warningBoxComponentId;

    public void setVersionAndNanos(Timestamp verison) {
        this.setNanos(verison.getNanos());
        this.setVersion(verison);
    }

    public Timestamp getVersionWithNanos() {
        Timestamp version = null;
        if (this.getNanos() != null && this.getVersion() != null) {
            version = this.getVersion();
            version.setNanos(this.getNanos());
        }
        return version;
    }

    public Integer getNanos() {
        return nanos;
    }

    public void setNanos(Integer nanos) {
        this.nanos = nanos;
    }

    public boolean isNeedValidate() {
        return needValidate;
    }

    public void setNeedValidate(boolean needValidate) {
        this.needValidate = needValidate;
    }

    public String getErrorBoxComponentId() {
        return errorBoxComponentId;
    }

    public void setErrorBoxComponentId(String errorBoxComponentId) {
        this.errorBoxComponentId = errorBoxComponentId;
    }

    public String getWarningBoxComponentId() {
        return warningBoxComponentId;
    }

    public void setWarningBoxComponentId(String warningBoxComponentId) {
        this.warningBoxComponentId = warningBoxComponentId;
    }

}
