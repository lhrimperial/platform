package com.github.platform.back.configure.shrio;

import com.alibaba.fastjson.JSON;
import com.githup.platform.common.domain.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        /*  使用response返回    */
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            ResponseDTO responseVO = new ResponseDTO(false, "", ex.getMessage());
            response.getWriter().write(JSON.toJSONString(responseVO));
        } catch (Exception e) {
            logger.error("与客户端通讯异常:"+ e.getMessage(), e);
        }
        logger.debug("异常:" + ex.getMessage(), ex);
        return mv;
    }
}
