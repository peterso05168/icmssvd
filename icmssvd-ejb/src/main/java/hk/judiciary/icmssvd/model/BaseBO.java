package hk.judiciary.icmssvd.model;

import hk.judiciary.fmk.ejb.biz.AbstractBO;
import hk.judiciary.fmk.logging.FmkLogger;

/**
 * 
 * @version $Revision: 5468 $ $Date: 2017-03-17 17:32:10 +0800 (週五, 17 三月 2017) $
 * @author $Author: mtse $
 */
public class BaseBO extends AbstractBO {

    private final FmkLogger logger = new FmkLogger(this.getClass());

    protected void debug(String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    protected void info(String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    protected void error(String msg) {
        if (logger.isErrorEnabled()) {
            logger.error(msg);
        }
    }

    protected void error(String msg, Throwable e) {
        if (logger.isErrorEnabled()) {
            logger.error(msg, e);
        }
    }
    
	protected void error(Exception e) {
		if (logger.isErrorEnabled()) {
			logger.error(">>> Class: "+e.getClass().getName());
			logger.error(">>> Cause: "+e.getCause());
			logger.error(">>> Message: "+e.getMessage());
			if (e.getStackTrace().length > 0) {
				logger.error(">>> Stacktrace:");
				for (int i=0; i<e.getStackTrace().length && i<100; i++) {
					logger.error("       at "+e.getStackTrace()[i]);
				}
			}
		}
	}

}
