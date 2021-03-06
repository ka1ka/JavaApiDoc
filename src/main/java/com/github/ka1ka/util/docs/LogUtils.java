package com.github.ka1ka.util.docs;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * a simple logger
 *
 * @author yeguozhong util.github.com
 */
public class LogUtils {

    private static final Logger LOGGER = Logger.getGlobal();

    static{
        try{
            FileHandler fileHandler = new FileHandler(DocContext.getLogFile().getAbsolutePath());
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);
            LOGGER.addHandler(fileHandler);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void info(String message, Object... args){
        LOGGER.info(String.format("info: " +message, args));
    }

    public static void warn(String message, Object... args){
        LOGGER.warning(String.format("warning!! " +message, args));
    }

    public static void error(String message, Object... args){
        LOGGER.severe(String.format("error!!! " + message, args));
    }

    public static void error(String message, Throwable e){
        LOGGER.log(Level.SEVERE, message, e);
    }
}
