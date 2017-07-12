package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 43 $ $Date: 2016-09-23 12:15:30 +0800 (Fri, 23 Sep 2016) $
 * @author $Author: timhtyuen@judiciary.gov.hk $
 */
public class FpApplicationNatureTypeDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer fpApplicationNatureTypeId;
    private Integer seqNo;
    private String fpApplicationNatureCode;
    private String englishFpApplicationNatureTypeName;
    private String chineseFpApplicationNatureTypeName;

    public Integer getFpApplicationNatureTypeId() {
        return fpApplicationNatureTypeId;
    }

    public void setFpApplicationNatureTypeId(Integer fpApplicationNatureTypeId) {
        this.fpApplicationNatureTypeId = fpApplicationNatureTypeId;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getFpApplicationNatureCode() {
        return fpApplicationNatureCode;
    }

    public void setFpApplicationNatureCode(String fpApplicationNatureCode) {
        this.fpApplicationNatureCode = fpApplicationNatureCode;
    }

    public String getEnglishFpApplicationNatureTypeName() {
        return englishFpApplicationNatureTypeName;
    }

    public void setEnglishFpApplicationNatureTypeName(String englishFpApplicationNatureTypeName) {
        this.englishFpApplicationNatureTypeName = englishFpApplicationNatureTypeName;
    }

    public String getChineseFpApplicationNatureTypeName() {
        return chineseFpApplicationNatureTypeName;
    }

    public void setChineseFpApplicationNatureTypeName(String chineseFpApplicationNatureTypeName) {
        this.chineseFpApplicationNatureTypeName = chineseFpApplicationNatureTypeName;
    }

    @Override
    public String toString() {
        return "FpApplicationNatureTypeDTO [fpApplicationNatureTypeId=" + fpApplicationNatureTypeId
                + ", seqNo=" + seqNo + ", fpApplicationNatureCode=" + fpApplicationNatureCode
                + ", englishFpApplicationNatureTypeName=" + englishFpApplicationNatureTypeName
                + ", chineseFpApplicationNatureTypeName=" + chineseFpApplicationNatureTypeName
                + "]";
    }

}
