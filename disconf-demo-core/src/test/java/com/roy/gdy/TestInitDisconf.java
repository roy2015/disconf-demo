package com.roy.gdy;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 2019/6/9.
 */
public class TestInitDisconf {
    private static final Logger logger = LoggerFactory.getLogger(TestInitDisconf.class);

    @Test
    public void testInitDisconf() {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath*:applicationContext.xml");



        boolean isTerminal = false;

        try {
            while (!isTerminal) {
                TimeUnit.MINUTES.sleep(10);
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
            isTerminal = true;
        } finally {
            applicationContext.destroy();
        }


    }

}
