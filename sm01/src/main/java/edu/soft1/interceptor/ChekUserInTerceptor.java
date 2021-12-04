package edu.soft1.interceptor;

import edu.soft1.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChekUserInTerceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session对象
        HttpSession session =request.getSession();
        //判定session中的有无登录对象
        Object obj = session.getAttribute("user");

        if (obj !=null && obj instanceof User){
            System.out.println("拦截器放行");
            return true;//通过
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        response.sendRedirect("index.jsp");
        System.out.println("返回登录页");
        return false;//拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
