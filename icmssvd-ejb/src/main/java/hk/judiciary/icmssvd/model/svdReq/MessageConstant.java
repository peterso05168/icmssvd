package hk.judiciary.icmssvd.model.svdReq;

/**
 * 
 * @version $Revision: 7772 $ $Date: 2017-06-29 10:27:55 +0800 (週四, 29 六月 2017) $
 * @author $Author: vicki.huang $
 */
public class MessageConstant {
    // svdReq enquiry
    public static final String CASE_NO_NOT_EXISTED = "SUM0001";
    public static final String COMPLETE_DISABLE = "SUM0002";
    public static final String WITHDRAW_DISABLE = "SUM0003";
    public static final String SAVE_REQUEST_RESULT_DISABLE = "SUM0004";
    public static final String SAVE_DRAFT_DISABLE = "SUM0005";
    public static final String SAVE_SERVICE_REQUEST_DISABLE = "SUM0006";

    // proof of service
    public static final String NO_SUCC_SERVREQ = "SUM0007";
    public static final String PROOF_EXISTED = "SUM0008";

    // execution request
    public static final String IS_NOT_BAILIFF = "SUM00009";

    public static final String FOUND_OUTSTANDING_TASK = "SUM0010";
    public static final String NOT_SERVEDBY_BAI_OR_POLI = "SUM0011";
}
