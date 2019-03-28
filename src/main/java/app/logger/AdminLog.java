package app.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;

public class AdminLog {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
      Logger logger = LogManager.getLogger();

        logger.debug("This is a debug message");
                logger.info("This is an info message");
                logger.warn("This is a warn message");
                logger.error("This is an error message");
                logger.fatal("This is a fatal message");
    }

    public static void error(String message) {
        logger.error(new Date() + " ------------- " + message);
    }


}