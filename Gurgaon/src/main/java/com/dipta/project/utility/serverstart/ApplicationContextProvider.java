package com.dipta.project.utility.serverstart;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public class ApplicationContextProvider implements ApplicationContextAware{

    private static  ApplicationContext context=null;

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }
}
