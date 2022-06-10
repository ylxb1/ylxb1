package com.zhi.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站--统计session
//在线人数监听

public class OnlineCountListener implements HttpSessionListener {

    //创建session监听
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer)ctx.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count +1);
        }
        ctx.setAttribute("OnlineCount", onlineCount);
    }

    //销毁session监听
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer)ctx.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount = new Integer(0);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }
        ctx.setAttribute("OnlineCount", onlineCount);
    }
}
