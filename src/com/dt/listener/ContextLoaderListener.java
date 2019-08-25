package com.dt.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /*
    监听SevletContext对象创建的，ServletContext对象服务器启动后自动创建。

     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源文件
        //获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
       //加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //获取真实路径
        String realpath = servletContext.getRealPath(contextConfigLocation);
        //加载进内存
        try {
            FileInputStream fi =new FileInputStream(realpath);
            System.out.println(fi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了");
    }

    /*
     * ServletContext对象服务器关闭服务器后自动销毁。
     * */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了");
    }
}
