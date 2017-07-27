package util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import org.slf4j.LoggerFactory;
import prop.LogProp;

public class Logger {
    private static ch.qos.logback.classic.Logger logger = null;

    public static void info(String msg) {
        makeLogger(Level.INFO);
        logger.info(msg);
    }

    public static void warn(String msg) {
        makeLogger(Level.WARN);
        logger.warn(msg);
    }

    public static void debug(String msg) {
        makeLogger(Level.DEBUG);
        logger.debug(msg);
    }

    public static void error(String msg) {
        makeLogger(Level.ERROR);
        logger.error(msg);
    }

    private static void makeLogger(Level l) {
        if (logger != null) {
            logger.setLevel(l);
        }

        if (logger == null) {
            LogProp prop = LogConfig.getLog();

            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            logger = context.getLogger(Logger.class);

            // Don't inherit root appender
            logger.setAdditive(false);

            // Atach appender to logger
            if(prop.getRollingMode().equals("true")) {
                logger.addAppender(getRollingFileAppender(prop, context));
            } else {
                logger.addAppender(getFileAppender(prop, context));
            }
        }
    }

    private static RollingFileAppender getRollingFileAppender(LogProp prop, LoggerContext context) {
        RollingFileAppender rollingFile = new RollingFileAppender();
        rollingFile.setContext(context);
        rollingFile.setName("EVENT_LOG");

        // Set up rolling policy
        TimeBasedRollingPolicy rollingPolicy = new TimeBasedRollingPolicy();
        rollingPolicy.setFileNamePattern(prop.getFullPath());

        rollingPolicy.setParent(rollingFile);
        rollingPolicy.setContext(context);
        rollingPolicy.start();

        // set up pattern encoder
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern("%msg%n");
        encoder.start();

        rollingFile.setRollingPolicy(rollingPolicy);
        rollingFile.setEncoder(encoder);
        rollingFile.start();

        return rollingFile;
    }

    private static FileAppender getFileAppender(LogProp prop, LoggerContext context) {
        FileAppender rollingFile = new FileAppender();
        rollingFile.setContext(context);
        rollingFile.setName("EVENT_LOG");

        // set up pattern encoder
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern("%msg%n");
        encoder.start();

        rollingFile.setFile(prop.getFullPath());
        rollingFile.setEncoder(encoder);
        rollingFile.start();

        return rollingFile;
    }
}
