package hk.judiciary.icmssvd.util;

import hk.judiciary.fmk.common.util.CommonUtil;
import hk.judiciary.fmk.logging.FmkLogger;
import hk.judiciary.fmk.model.cfs.biz.dto.FileDTO;
import hk.judiciary.fmk.view.AbstractController;

public class DocumentFileUtil {

    public static final FmkLogger logger = new FmkLogger(DocumentFileUtil.class);
    
    public static final Integer PDF_VIEWER_WIDTH = 800;
    public static final Integer PDF_VIEWER_HEIGHT = 600;
    private static final String PRINT_ALIAS = "";

    /**
     * Launch PDF Viewer
     * 
     * @param fileDTO
     * @throws Exception 
     */
    public static void launchPDFViewer(AbstractController inController, FileDTO fileDTO) throws Exception {
        logger.debug("executing launchPDFViewer()");
        if (!CommonUtil.isNullOrEmpty(fileDTO) 
            && !CommonUtil.isNullOrEmpty(fileDTO.getContent())
            && !CommonUtil.isNullOrEmpty(fileDTO.getContent().getInputStream())) {
            inController.fileViewer(fileDTO.getContent().getInputStream(), fileDTO.getFilename(), PRINT_ALIAS, PDF_VIEWER_WIDTH, PDF_VIEWER_HEIGHT);
        }
    }
    
    /**
     * Launch Download
     * 
     * @param fileDTO
     * @throws Exception 
     */
    public static void launchDownload(AbstractController inController, FileDTO fileDTO) throws Exception {
        logger.debug("executing launchDownload()");
        if (!CommonUtil.isNullOrEmpty(fileDTO) 
            && !CommonUtil.isNullOrEmpty(fileDTO.getContent())
            && !CommonUtil.isNullOrEmpty(fileDTO.getContent().getInputStream())) {
            inController.fileDownload(fileDTO.getContent().getInputStream(), fileDTO.getContent().getContentType(), fileDTO.getFilename());
        }
    }

}
