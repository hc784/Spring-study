package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class log4jTest {
	

    private Logger logger = LogManager.getLogger(log4jTest.class);
    
    public void printLog() {
        logger.debug("[debug] log! 로그가 어디 찍히는로그가 어디 찍히");
        logger.info("[info] log!로그가 어디 찍히로그가 어디 찍히로그가 어디 찍히");
        logger.warn("[warn] log!");
        logger.error("[error] log!");
    }

}
