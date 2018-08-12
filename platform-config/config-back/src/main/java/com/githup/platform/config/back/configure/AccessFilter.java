package com.githup.platform.config.back.configure;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 */
public class AccessFilter implements Filter {

    private static final String LOGIN_PAGE = "http://localhost:9100/platform/login.html";

    private static String[] filterUri = {"login.html", "asyncLogin"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        System.out.println(uri);
        HttpSession session = req.getSession();
        System.out.println(session.getId());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
