package hk.judiciary.icmssvd.model.svdReq.biz.assembler;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.icms.model.dao.entity.Reqs;
import hk.judiciary.icms.model.dao.entity.ReqsAddr;
import hk.judiciary.icms.model.dao.entity.ReqsDoc;
import hk.judiciary.icmssvd.model.common.CommonConstant;
import hk.judiciary.icmssvd.model.svdReq.biz.dto.BailiffRequestAmendmentDTO;

public class BailiffRequestAmendmentDTOAssembler {

	/**
	 * Copy properties from Reqs to BailiffRequestAmendmentDTO
	 * 
	 * @param eventKey the event key.
	 * @param reqs the entity of the Reqs.
	 * 
	 * @return BailiffRequestAmendmentDTO
	 */
	public static BailiffRequestAmendmentDTO toDto(String eventKey, Reqs reqs) {
		
		BailiffRequestAmendmentDTO dto = null;
		
		if (!CommonUtil.isNullOrEmpty(eventKey) && !CommonUtil.isNullOrEmpty(reqs)) {
			dto = new BailiffRequestAmendmentDTO();
			
	    	String amendmentDetail = "Request"; 
	    	
	    	if (CommonConstant.EVENT_UPDATE_STATUS.equals(eventKey)) {
	    		amendmentDetail = amendmentDetail + " Status updated to \"";
	    		
	    		if (!CommonUtil.isNullOrEmpty(reqs.getReqsStatus())) {
	    			amendmentDetail = amendmentDetail + reqs.getReqsStatus().getReqsStatusTypeDesc();
	    		}
	    		amendmentDetail = amendmentDetail + "\"";
	    	}	    	
	    	
	    	dto.setRequestId(reqs.getReqsId());
	    	dto.setAmendmentDetail(amendmentDetail);
		}
		
		return dto;
	}
	
    
	/**
	 * Copy properties from ReqsAddr to BailiffRequestAmendmentDTO
	 * 
	 * @param eventKey the event key.
	 * @param reqsAddr the entity of the ReqsAddr.
	 * 
	 * @return BailiffRequestAmendmentDTO
	 */
    public static BailiffRequestAmendmentDTO toDto(String eventKey, ReqsAddr reqsAddr) {
    	
		BailiffRequestAmendmentDTO dto = null;
		if (!CommonUtil.isNullOrEmpty(eventKey) && !CommonUtil.isNullOrEmpty(reqsAddr)) {
			dto = new BailiffRequestAmendmentDTO();
			
	    	String amendmentDetail = "Address";
    		
    		if (CommonConstant.EVENT_ADD.equals(eventKey)) {
    			amendmentDetail = amendmentDetail + " added";
    		} else if (CommonConstant.EVENT_UPDATE.equals(eventKey)) {
    			amendmentDetail = amendmentDetail + " updated to";
    		} else if (CommonConstant.EVENT_DELETE.equals(eventKey)) {
    			amendmentDetail = amendmentDetail + " deleted";
    		}    		
    		amendmentDetail = amendmentDetail + ": \"";
    		
    		if (!CommonUtil.isNullOrEmpty(reqsAddr.getAddrLine1())) {
    			amendmentDetail = amendmentDetail + reqsAddr.getAddrLine1() + " ";
    		}
    		if (!CommonUtil.isNullOrEmpty(reqsAddr.getAddrLine2())) {
    			amendmentDetail = amendmentDetail + reqsAddr.getAddrLine2() + " ";
    		}
    		if (!CommonUtil.isNullOrEmpty(reqsAddr.getAddrLine3())) {
    			amendmentDetail = amendmentDetail + reqsAddr.getAddrLine3() + " ";
    		}
    		if (!CommonUtil.isNullOrEmpty(reqsAddr.getAddrLine1Chin())) {
    			amendmentDetail = amendmentDetail + reqsAddr.getAddrLine1Chin();
    		}
    		if (!CommonUtil.isNullOrEmpty(reqsAddr.getAddrLine2Chin())) {
    			amendmentDetail = amendmentDetail + reqsAddr.getAddrLine2Chin();
    		}
    		if (!CommonUtil.isNullOrEmpty(reqsAddr.getAddrLine3Chin())) {
    			amendmentDetail = amendmentDetail + reqsAddr.getAddrLine3Chin();
    		} 
    		
    		amendmentDetail = amendmentDetail + "\"";
	    	
	    	dto.setRequestId(reqsAddr.getReqs().getReqsId());
	    	dto.setAmendmentDetail(amendmentDetail);			
		}
		
		return dto;
    }

	/**
	 * Copy properties from ReqsDoc to BailiffRequestAmendmentDTO
	 * 
	 * @param eventKey the event key.
	 * @param reqsDoc the entity of the ReqsDoc.
	 * 
	 * @return BailiffRequestAmendmentDTO
	 */
    public static BailiffRequestAmendmentDTO toDto(String eventKey, ReqsDoc reqsDoc) {
    	
		BailiffRequestAmendmentDTO dto = null;
		if (!CommonUtil.isNullOrEmpty(eventKey) && !CommonUtil.isNullOrEmpty(reqsDoc)) {
			dto = new BailiffRequestAmendmentDTO();
			
	    	String amendmentDetail = "Document"; 
	    	
	    	if (CommonConstant.EVENT_ADD.equals(eventKey)) {

	    		amendmentDetail = amendmentDetail + " added: \"";
	    		if (!CommonUtil.isNullOrEmpty(reqsDoc.getDoc()) && !CommonUtil.isNullOrEmpty(reqsDoc.getDoc().getDocType())) {
	    			
	    			if (!CommonUtil.isNullOrEmpty(reqsDoc.getDoc().getDocType())) {
	    				amendmentDetail = amendmentDetail + reqsDoc.getDoc().getDocType().getDocTypeDesc();
	    				
	    				if (!CommonUtil.isNullOrEmpty(reqsDoc.getDoc().getDocFolio()) && reqsDoc.getDoc().getDocFolio().size() > 0) {
	    					amendmentDetail = amendmentDetail + ", " + reqsDoc.getDoc().getDocFolio().get(0).getFolioNo();
	    				}
	    			}
	    		}
	    		amendmentDetail = amendmentDetail + "\"";
	    	}
	    		    	
	    	dto.setRequestId(reqsDoc.getBlfReqs().getReqsId());
	    	dto.setAmendmentDetail(amendmentDetail);			
		}
		
		return dto;
    }
        
	
}
