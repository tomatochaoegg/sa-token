package com.hankun.satokenlearn.util;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * http处理工具类
 *
 * @author zhouxuanhong
 * @date 2019-04-03 14:11
 * @since JDK1.8
 */
public class ServletUtils {
    /**
     * 获取ServletRequestAttributes
     *
     * @return ServletRequestAttributes ${@link ServletRequestAttributes}
     * @author zhouxuanhong
     * @date 2019-04-03 18:45
     */
    private static ServletRequestAttributes getServletRequestAttributes() {

        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }


    /**
     * 获取HttpServletRequest
     *
     * @return HttpServletRequest ${@link HttpServletRequest}
     * @author zhouxuanhong
     * @date 2019-04-03 14:13
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }
        return servletRequestAttributes.getRequest();
    }


    /**
     * 获取HttpServletResponse
     *
     * @return HttpServletResponse ${@link HttpServletResponse}
     * @author zhouxuanhong
     * @date 2019-04-03 14:14
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }
        return servletRequestAttributes.getResponse();
    }


    /**
     * 获取HttpSession
     *
     * @return HttpSession ${@link HttpSession}
     * @author zhouxuanhong
     * @date 2019-05-15 14:50
     */
    public static HttpSession getSesson() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        return getRequest().getSession();
    }


    /**
     * 获取ServletContext
     *
     * @return ServletContext ${@link ServletContext}
     * @author zhouxuanhong
     * @date 2019-05-15 14:50
     */
    public static ServletContext getServletContext() {
        WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        if (currentWebApplicationContext == null) {
            return null;
        }
        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }

}
