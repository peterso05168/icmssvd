package hk.judiciary.icmssvd.model.svdReq.biz.dto;

import hk.judiciary.icmssvd.model.BaseDTO;

/**
 * 
 * @version $Revision: 3917 $ $Date: 2017-02-04 18:03:30 +0800 (週六, 04 二月 2017) $
 * @author $Author: vicki.huang $
 */
public class MaintainRequestDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private FunctionDTO func;
    private Integer requestId;
    private String caseNo;
    private boolean makeNewRequestInd;

    public FunctionDTO getFunc() {
        return func;
    }

    public void setFunc(FunctionDTO func) {
        this.func = func;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public boolean isMakeNewRequestInd() {
        return makeNewRequestInd;
    }

    public void setMakeNewRequestInd(boolean makeNewRequestInd) {
        this.makeNewRequestInd = makeNewRequestInd;
    }

    @Override
    public String toString() {
        return "MaintainRequestDTO [func=" + func + ", requestId=" + requestId + ", caseNo="
                + caseNo + ", makeNewRequestInd=" + makeNewRequestInd + "]";
    }

}
