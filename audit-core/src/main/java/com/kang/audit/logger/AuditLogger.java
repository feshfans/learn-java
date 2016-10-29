package com.kang.audit.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by feshfans on 2016/10/29.
 */
public class AuditLogger {

    private static final Logger logger= LoggerFactory.getLogger(AuditLogger.class);

    static void info(String message){
        logger.info(message);
    }

}
