package hk.judiciary.icmssvd.model.common.util;

import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.FileTypeMap;
import javax.mail.util.ByteArrayDataSource;

import hk.judiciary.fmk.common.resource.CfsConstant;
import hk.judiciary.fmk.common.security.user.JudiciaryUser;
import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.ejb.cfs.CentralizedFileService;
import hk.judiciary.fmk.ejb.icmsdocservice.ICMSEcfDocService;
import hk.judiciary.fmk.ejb.webservice.WSClientHandler;
import hk.judiciary.fmk.logging.FmkLogger;
import hk.judiciary.fmk.model.cfs.biz.dto.CfsFileInfoDTO;
import hk.judiciary.fmk.model.cfs.biz.dto.FileDTO;
import hk.judiciary.fmk.model.icmsdocservice.biz.dto.ws.CreateDocRequestDTO;
import hk.judiciary.fmk.model.report.biz.dto.ReportResultDTO;
import hk.judiciary.icmscase.webservice.cmc.CaseService;


public class DocumentFileUtil {
	
	public static final FmkLogger logger = new FmkLogger(DocumentFileUtil.class);
	
	public static final String INCOMING_DOCUMENT = "IN";
	public static final String OUTGOING_DOCUMENT = "OUT";
	public static final String UNCLASSIFIED_DOCUMENT = "UNCL";
	
	private static final String DEFAULT_DOCUMENT_STATUS = "ACT";		
    private static final String REPOSITORY_CODE = CfsConstant.REPO_CD_ICMSSVD;
    
    private static ICMSEcfDocService getICMSEcfDocService(JudiciaryUser judiciaryUser) throws Exception {
    	String endpoint = WSClientHandler.getEndpointByWSConfigCode(ICMSEcfDocService.WEBSERVICE_CONFIG_CODE);
    	return WSClientHandler.handleMessage(judiciaryUser, ICMSEcfDocService.class, endpoint);
    }
	
    private static CentralizedFileService getCentralizedFileService(JudiciaryUser judiciaryUser) throws Exception {
    	String endpoint = WSClientHandler.getEndpointByWSConfigCode(CentralizedFileService.WEBSERVICE_CONFIG_CODE);
    	return WSClientHandler.handleMessage(judiciaryUser, CentralizedFileService.class, endpoint);
    } 
	
    private static CaseService getCaseService(JudiciaryUser judiciaryUser) throws Exception {
        String endpoint = WSClientHandler.getEndpointByWSConfigCode(CaseService.WEBSERV_CD);
        return WSClientHandler.handleMessage(judiciaryUser, CaseService.class, endpoint);
    }
    
    
    private static CreateDocRequestDTO generateCreateDocRequestDTO(JudiciaryUser judiciaryUser, String documentTypeCode, String documentClassCode, String documentStatusCode, String drn) throws Exception {
        
        if (CommonUtil.isNullOrEmpty(drn)) {
        	drn = generateDrn(judiciaryUser);
        }
        
        if (CommonUtil.isNullOrEmpty(documentClassCode)) {        	
        	documentClassCode = INCOMING_DOCUMENT;
        }
        
        if (CommonUtil.isNullOrEmpty(documentStatusCode)) {        	
        	documentStatusCode = DEFAULT_DOCUMENT_STATUS;
        }
        
        CreateDocRequestDTO createDocRequest = new CreateDocRequestDTO();
        createDocRequest.setDocTypeCd(documentTypeCode);
        createDocRequest.setDocRefNo(drn);
        createDocRequest.setDocClassCd(documentClassCode);
        createDocRequest.setDocStatusCd(documentStatusCode);
        
        return createDocRequest;
    }
    
    
    /**
     * Get file from ECF repository
     */
    public static FileDTO getDocumentFile(JudiciaryUser judiciaryUser, int icmsDocId) {
    	logger.info("getDocumentFile() start : icmsDocId = " + icmsDocId + ", judiciaryUser = " + judiciaryUser);
   		
    	FileDTO file = null;
    	
    	if (CommonUtil.isNullOrEmpty(file)) {
    		try {
    			file = getEcfFile(judiciaryUser, icmsDocId);
    		} catch (Exception e) {
    			logger.info("Failure in call getEcfFile() by icmsDocId = " + icmsDocId);
    		}
    	}
		
       	logger.info("getDocumentFile() end : file = " + file);
        return file;
    }
 
    
    /**
     * Get DRN by Document Id
     */
    public static String getDrn(JudiciaryUser judiciaryUser, int icmsDocId) throws Exception {
    	logger.info("getDrn() start : icmsDocId = " + icmsDocId + ", judiciaryUser = " + judiciaryUser);
		
    	String drn = null;
    	
    	if (CommonUtil.isNullOrEmpty(drn)) {
    		drn = getICMSEcfDocService(judiciaryUser).findDrnById(icmsDocId);
    	}
    	
       	logger.info("getDrn() end : drn = " + drn);
       	return drn;
    }
   
    /**
     * Generate DRN
     */
    public static String generateDrn(JudiciaryUser judiciaryUser) throws Exception {
    	logger.info("generateDrn() start : judiciaryUser = " + judiciaryUser);

        String drn = getCaseService(judiciaryUser).genDrn();
        
        logger.info("generateDrn() end : drn = " + drn);
        return drn;
    }
    
    /**
     * Create ECF Document with case Id and document type code
     */
    public static int createDocument(JudiciaryUser judiciaryUser, Integer caseId, String documentTypeCode) throws Exception {
    	return createDocument(judiciaryUser, caseId, documentTypeCode, null);
    }
    
    /**
     * Create ECF Document with case Id, document type code and DRN
     */
    public static int createDocument(JudiciaryUser judiciaryUser, Integer caseId, String documentTypeCode, String drn) throws Exception {
    	return createDocument(judiciaryUser, caseId, documentTypeCode, drn, null);
    }
    
    /**
     * Create ECF Document with case Id, document type code, DRN and file
     */
    public static int createDocument(JudiciaryUser judiciaryUser, Integer caseId, String documentTypeCode, String drn, FileDTO file) throws Exception {
    	return createDocument(judiciaryUser, caseId, documentTypeCode, INCOMING_DOCUMENT, null, drn, file);
    }
       
    /**
     * Create Return ECF Document with case Id and document type code
     */
    public static int createReturnDocument(JudiciaryUser judiciaryUser, Integer caseId, String documentTypeCode) throws Exception {
    	return createReturnDocument(judiciaryUser, caseId, documentTypeCode, null);
    }
    
    /**
     * Create Return ECF Document with case Id, document type code and DRN
     */
    public static int createReturnDocument(JudiciaryUser judiciaryUser, Integer caseId, String documentTypeCode, String drn) throws Exception {
    	return createReturnDocument(judiciaryUser, caseId, documentTypeCode, drn, null);
    }
    
    /**
     * Create Return ECF Document with case Id, document type code, DRN and file
     */
    public static int createReturnDocument(JudiciaryUser judiciaryUser, Integer caseId, String documentTypeCode, String drn, FileDTO file) throws Exception {
    	return createDocument(judiciaryUser, caseId, documentTypeCode, OUTGOING_DOCUMENT, null, drn, file);
    }
        
    /**
     * Create ECF Document with case Id, document type code, document class code, document status code, DRN and file
     */
    public static int createDocument(JudiciaryUser judiciaryUser, Integer caseId, String documentTypeCode, String documentClassCode, String documentStatusCode, String drn, FileDTO file) throws Exception {
    	logger.info("createDocument() start : caseId = " + caseId + ", documentTypeCode = " + documentTypeCode + ", documentClassCode = " + documentClassCode
        		 	+ ", documentStatusCode = " + documentStatusCode + ", drn = " + drn + ", file = " + (file != null ? file.getFilename() : "null") + ", judiciaryUser = " + judiciaryUser);
    	
    	int icmsDocId;
    	
        String caseIdOrNo = caseId.toString();
        int subFlrId = -1;
        CreateDocRequestDTO createDocRequest = generateCreateDocRequestDTO(judiciaryUser, documentTypeCode, documentClassCode, documentStatusCode, drn);
       	
        if (CommonUtil.isNullOrEmpty(file)) {
        	icmsDocId = getICMSEcfDocService(judiciaryUser).createEcfDoc(caseIdOrNo, createDocRequest, subFlrId);
        } else {        
        	icmsDocId = getICMSEcfDocService(judiciaryUser).createEcfDocWithFile(caseIdOrNo, createDocRequest, subFlrId, file);
        }
        
       	logger.info("createDocument() end : icmsDocId = " + icmsDocId);
        return icmsDocId;
    }
    
    /**
     * Add file to ECF repository
     */
    public static void addEcfFile(JudiciaryUser judiciaryUser, int icmsDocId, FileDTO file) throws Exception {
    	logger.info("addEcfFile() start : icmsDocId = " + icmsDocId + ", file = " + file.getFilename() + ", judiciaryUser = " + judiciaryUser);
		
		getICMSEcfDocService(judiciaryUser).saveEcfFileById(icmsDocId, file);
    	 
       	logger.info("addEcfFile() end");
    }

    /**
     * Get file from ECF repository
     */
    public static FileDTO getEcfFile(JudiciaryUser judiciaryUser, int icmsDocId) throws Exception {
    	logger.info("getEcfFile() start : icmsDocId = " + icmsDocId + ", judiciaryUser = " + judiciaryUser);
   		
		FileDTO file = getICMSEcfDocService(judiciaryUser).getEcfFileById(icmsDocId);
		
       	logger.info("getEcfFile() end : file = " + file.getFilename());
        return file;
    }

    
    /**
     * Create miscellaneous file
     */
    public static String createCfsFile(JudiciaryUser judiciaryUser, FileDTO file) throws Exception {
    	logger.info("createCfsFile() start : file = " + file.getFilename() + ", judiciaryUser = " + judiciaryUser);

    	String sourceFileId = generateDrn(judiciaryUser);
    	
    	addCfsFile(judiciaryUser, sourceFileId, file);
    	 
       	logger.info("createCfsFile() end : sourceFileId = " + sourceFileId);
       	
       	return sourceFileId;
    }
    
    /**
     * Add miscellaneous file
     */
    public static void addCfsFile(JudiciaryUser judiciaryUser, String sourceFileId, FileDTO file) throws Exception {
    	logger.info("addCfsFile() start : sourceFileId = " + sourceFileId + ", file = " + file.getFilename() + ", judiciaryUser = " + judiciaryUser);

    	CfsFileInfoDTO cfsFileInfo = new CfsFileInfoDTO();
    	cfsFileInfo.setRepositoryCode(REPOSITORY_CODE);
    	cfsFileInfo.setSourceFileId(sourceFileId); 
    	
    	getCentralizedFileService(judiciaryUser).saveFile(cfsFileInfo, file);
    	 
       	logger.info("addCfsFile() end");
    }
    
    
    /**
     * Delete miscellaneous file
     */
    public static void deleteCfsFile(JudiciaryUser judiciaryUser, String sourceFileId) throws Exception {
    	logger.info("deleteCfsFile() start : sourceFileId = " + sourceFileId + ", judiciaryUser = " + judiciaryUser);
    	
    	CfsFileInfoDTO cfsFileInfo = new CfsFileInfoDTO();
    	cfsFileInfo.setRepositoryCode(REPOSITORY_CODE);
    	cfsFileInfo.setSourceFileId(sourceFileId);    	

    	getCentralizedFileService(judiciaryUser).deleteFile(cfsFileInfo); 
    	
       	logger.info("deleteCfsFile() end");

    }
    
    
    /**
     * Get miscellaneous file
     */
    public static FileDTO getCfsFile(JudiciaryUser judiciaryUser, String sourceFileId) throws Exception {
    	logger.info("getCfsFile() start : sourceFileId = " + sourceFileId + ", judiciaryUser = " + judiciaryUser);
    	
    	CfsFileInfoDTO cfsFileInfo = new CfsFileInfoDTO();
    	cfsFileInfo.setRepositoryCode(REPOSITORY_CODE);
    	cfsFileInfo.setSourceFileId(sourceFileId);    	

    	FileDTO file = getCentralizedFileService(judiciaryUser).getFile(cfsFileInfo); 
    	
       	logger.info("getCfsFile() end : file = " + file.getFilename());
          
        return file;
    }
     
    /**
     * Generate FileDTO by file path 
     */
    public static FileDTO generateFileDTO(String filePath) {
    	DataSource dataSource = new FileDataSource(filePath);     
    	FileDTO file = new FileDTO();
    	file.setFilename(dataSource.getName());            	
    	file.setContent(new DataHandler(dataSource)); 
    	return file;
    }
    
    /**
     * Generate FileDTO by reportResult 
     */
    public static FileDTO generateFileDTO(ReportResultDTO reportResult) {
    	return generateFileDTO(reportResult, reportResult.getReportId());
    }
    
    /**
     * Generate FileDTO by reportResult with filename
     */
    public static FileDTO generateFileDTO(ReportResultDTO reportResult, String filename) {
    	FileDTO file = new FileDTO();
    	file.setFilename(filename);
    	 DataSource dataSource = new ByteArrayDataSource(reportResult.getDocument(), FileTypeMap
                 .getDefaultFileTypeMap().getContentType(reportResult.getDocument().toString()));
         file.setContent(new DataHandler(dataSource));
    	return file;
    }


    /**
     * Generate Source File Id
     * 
     * @param Document
     *            Type Code
     * @return Source File Id
     */
    public static String genSourceFileId(JudiciaryUser judiciaryUser, String documentTypeCode)
            throws Exception {
        logger.info("genSourceFileId() starts : documentTypeCode = " + documentTypeCode);
        String drn = generateDrn(judiciaryUser);
        String sourceFileId = drn + "_" + documentTypeCode;
        logger.info("genSourceFileId() ends : sourceFileId = " + sourceFileId);
        return sourceFileId;
    }

    /**
     * Get DRN from Source File Id
     * 
     * @param sourceFileId
     * @return DRN
     */
    public static String getDrn(String sourceFileId) {
        return getSourceFileIdData(sourceFileId, true);
    }

    /**
     * Get Document Type Code from Source File Id
     * 
     * @param sourceFileId
     * @return Document Type Code
     */
    public static String getDocumentTypeCode(String sourceFileId) {
        return getSourceFileIdData(sourceFileId, false);
    }

    /**
     * Get data from Source File Id
     * 
     * @param sourceFileId
     * @return returnVal
     */
    private static String getSourceFileIdData(String sourceFileId, boolean isGetDrn) {
        logger.info("getSourceFileIdData() starts : sourceFileId = " + sourceFileId);
        String returnVal = null;
        List<String> docRefNoDetail = CommonUtil.split(sourceFileId, "_");
        if (!CommonUtil.isNullOrEmpty(docRefNoDetail) && docRefNoDetail.size() == 2) {
            if (isGetDrn) {
                returnVal = docRefNoDetail.get(0);
            } else {
                returnVal = docRefNoDetail.get(1);
            }
        }
        logger.info("getSourceFileIdData() ends : returnVal = " + returnVal);
        return returnVal;
    }

}
