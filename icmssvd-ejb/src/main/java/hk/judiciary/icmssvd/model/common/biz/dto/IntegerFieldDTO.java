package hk.judiciary.icmssvd.model.common.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 2551 $ $Date: 2016-12-30 21:14:55 +0800 (週五, 30 十二月 2016) $
 * @author $Author: vicki.huang $
 */
public class IntegerFieldDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer integerField1;
    private Integer integerField2;

    public Integer getIntegerField1() {
        return integerField1;
    }

    public void setIntegerField1(Integer integerField1) {
        this.integerField1 = integerField1;
    }

    public Integer getIntegerField2() {
        return integerField2;
    }

    public void setIntegerField2(Integer integerField2) {
        this.integerField2 = integerField2;
    }

    @Override
    public String toString() {
        return "IntegerFieldDTO [integerField1=" + integerField1 + ", integerField2="
                + integerField2 + "]";
    }

}
