package com.zhi.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转  拿到session
        HttpServletRequest request1 = (HttpServletRequest) servletRequest;
        HttpServletResponse response1 = (HttpServletResponse) servletResponse;

        //Object user_session = request1.getSession().getAttribute("USER_SESSION");
        //判断
        if (request1.getSession().getAttribute("USER_SESSION")==null) {
            response1.sendRedirect("/error.jsp");
            //session注销过后是空的 就进入错误页面  避免注销后还能直接进入主页
        }
        //链
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
