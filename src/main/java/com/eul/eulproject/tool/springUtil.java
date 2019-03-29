package com.eul.eulproject.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class springUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static Logger logger = LoggerFactory.getLogger(springUtil.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(applicationContext != null){
            springUtil.applicationContext = applicationContext;
        }
        logger.info("获取Spring上下文成功");
    }

    public static <T> T getBean(Class<T> tClass){
        if(null== applicationContext){
            return null;
        }
        logger.info("获取bean"+tClass.getName());
        return applicationContext.getBean(tClass);
    }
}
