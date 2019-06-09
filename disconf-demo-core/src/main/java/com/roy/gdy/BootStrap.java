package com.roy.gdy;

import com.roy.gdy.service.AutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 2019/6/9.
 */
public class BootStrap {
    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);
    private static boolean isTerminal = false;

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath*:applicationContext.xml");

        AutoService autoService = (AutoService) applicationContext.getBean("autoService");

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
