package com.github.platform.back.configure;

import com.githup.platform.common.constant.GlobalConstant;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 *
 **/
public class SessionInterceptor implements HandlerInterceptor {

    private static final String LOGIN_PAGE = "http://localhost:9100/platform/login.html";

    private static String[] filterUri = {"login.html", "asyncLogin", "error"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        if (!StringUtils.isEmpty(uri)) {
            String s = uri.substring(uri.lastIndexOf("/")+1);
            if (!Arrays.asList(filterUri).contains(s)) {
                HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
                HttpSession session = httpServletRequest.getSession();
                Object sessionUser = session.getAttribute(GlobalConstant.SESSION_AUTH_LOGIN_USERNAME);

                if (sessionUser == null) {
                    resp.sendRedirect(LOGIN_PAGE);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
