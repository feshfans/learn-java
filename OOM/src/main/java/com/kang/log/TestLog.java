package com.kang.log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * Created by feshfans on 2016/8/9.
 *
 * @email feshfans@163.com
 */
public class TestLog {
    private static Logger logger=Logger.getLogger(TestLog.class);
    public static void main(String[] args) {
        logger.debug("test.....");
    }
}
