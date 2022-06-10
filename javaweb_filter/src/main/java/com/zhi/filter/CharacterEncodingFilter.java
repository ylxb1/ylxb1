package com.zhi.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    //初始化 服务器启动时初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }


    //销毁  web服务器关闭的时候，过滤会销毁
    public void destroy() {
        Filter.super.destroy();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        System.out.println("CharacterEncodingFilter执行前...");
        //链Chain  让我们的请求继续走，不写的话程序就会被拦截停止
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("CharacterEncodingFilter执行后...");
    }
}
