package com.transsion.test.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.util.Log4jConfigListener;

/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-09-26 下午5:49:53
 * @version 0.0.1
 * 
 */
public class TestLog4J {

	private static Logger logger=LogManager.getLogger(TestLog4J.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("hello C++");
        logger.info("当前时间："+new java.util.Date().toString());
        logger.warn("脖子太累了，出去活动活动");
        logger.error("程序错误。");
        logger.error("程序错误SB");
        logger.trace("跟踪信息");
	}

}
