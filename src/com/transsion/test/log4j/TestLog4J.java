package com.transsion.test.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.util.Log4jConfigListener;

/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-09-26 ����5:49:53
 * @version 0.0.1
 * 
 */
public class TestLog4J {

	private static Logger logger=LogManager.getLogger(TestLog4J.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("hello C++");
        logger.info("��ǰʱ�䣺"+new java.util.Date().toString());
        logger.warn("����̫���ˣ���ȥ��");
        logger.error("�������");
        logger.error("�������SB");
        logger.trace("������Ϣ");
	}

}
