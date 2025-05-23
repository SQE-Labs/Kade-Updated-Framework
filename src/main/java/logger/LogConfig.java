package logger;

import org.apache.log4j.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.io.File.separator;
import static org.apache.log4j.Level.DEBUG;



public class LogConfig {
    private static Logger log;

    private LogConfig() {
    }

    /**
     * Initialize the logger object.
     *
     * @param path path of the log file
     * @return the logger object
     */
    private static synchronized Logger initializeLogger(String path) {
        Logger logger = Logger.getLogger("Logging");
        logger.removeAllAppenders();
        Logger.getRootLogger().removeAllAppenders();
        FileAppender logAppender = null;
        Layout layout = new PatternLayout("%d [%M]: %m%n");
        try {
            logAppender = new FileAppender(layout, path);
        } catch (IOException e) {
            System.err.println("Problems creating log file...");
            e.printStackTrace();
        }
        logger.addAppender(logAppender);
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        logger.addAppender(consoleAppender);
        logger.setLevel(DEBUG);
        return (Logger) logger;
    }

    /**
     * Initialize the logs.
     */
    private static void initLogs() {
        String runtime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM.dd.yyyy.hh.mm.ss"));
        String path = System.getProperty("user.dir") + separator + "target" + separator + "selenium-logs" + separator
                + runtime + ".log";
        log = (Logger) initializeLogger(path);
    }

    /**
     * Get the log instance.
     *
     * @return log instance
     */
    public static Logger getLogger() {
        if (log == null) {
            initLogs();
        }
        return log;
    }
}
