package com.inno.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

public class ContextUtil {

    /**
     * context 추출
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        if (context != null) {
            return context;
        } else {
            return null;
        }
    }

    /**
     * context내의 bean 추출
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }


}
