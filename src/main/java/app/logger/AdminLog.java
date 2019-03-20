package app.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;

public class AdminLog {

    private static Logger logger = LogManager.getLogger();

    public static void error(String message) {
        logger.error(new Date() + " ------------- " + message);
    }


}