package org.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*用户登录拦截器登录*/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    //返回true就放行，返回false就拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            //如果没有登录过，就跳回登录页
            request.setAttribute("msg","你还没有登陆过");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            return false;   //返回false请求拦截
        }
        return true;      //返回true请求放行
    }


}
