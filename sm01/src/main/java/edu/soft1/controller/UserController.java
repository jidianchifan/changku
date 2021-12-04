package edu.soft1.controller;

import edu.soft1.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/login")
    public String login(User user, HttpSession session, HttpServletRequest request) {
        System.out.println("------login()------");
        int flag = 1; //调用业务层
        if (flag == 1){
            System.out.println("username="+user.getUsername());
            session.setAttribute("user",user);
            return "welcome";//登录成功
        }
        System.out.println("登录失败，返回首页index");
        request.setAttribute("error","登录失败，请重新尝试");
        return "forward:/index.jsp";//登录失败
    }


    @RequestMapping("/reg")
    public String reg(User user){
        System.out.println("username="+user.getUsername());
        System.out.println("pwd="+user.getPwd());
        System.out.println("birthday="+user.getBirthday());
        System.out.println("city="+user.getAddress().getCity());
        System.out.println("street="+user.getAddress().getStreet());
        System.out.println("phone="+user.getAddress().getPhone());
        return "redirect:text";
    }
    @RequestMapping("delete")
    public String delete(HttpServletRequest request){
        System.out.println("----delete----");
        request.setAttribute("CRUDmsg","删除完成");
        return "hello";
    }

    @RequestMapping("welcome")
    public String welcome(){
        System.out.println("----welcome----");
        return "welcome";
    }

    @RequestMapping("logout")//登出功能
    public String logout(HttpSession session){
        //清空session
        session.invalidate();
        System.out.println("已登出");
        return "redirect:/index.jsp";//重定向跳转至首页
    }

}
