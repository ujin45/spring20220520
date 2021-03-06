package com.team1.travel.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */

public class AppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext application = sce.getServletContext();
         
         application.setAttribute("appRoot", application.getContextPath());
         
         /* 복붙 주의 , 경로각자 다름, aws3 파일 경로 
         String imageUrl = "https://bucket0207-0330.s3.ap-northeast-2.amazonaws.com";
         application.setAttribute("imageUrl", imageUrl); 
         */
         
         
    }
}




