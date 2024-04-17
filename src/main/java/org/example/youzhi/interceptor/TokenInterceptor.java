package org.example.youzhi.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.example.youzhi.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(StringUtils.isNotBlank(token)) {
            if(TokenUtil.verity(token)) {
                return true;
            } else {
                response.setContentType("application/json; charset=utf-8");
                response.setCharacterEncoding("utf-8");
                HashMap<String, Object> map = new HashMap<>();
                map.put("code", 401);
                map.put("msg", "该用户没授权，请重新登录");
                response.getWriter().append(map.toString());
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
