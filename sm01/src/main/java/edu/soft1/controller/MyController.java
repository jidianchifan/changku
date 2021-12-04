package edu.soft1.controller;

import edu.soft1.pojo.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping(value = "/param")
public class MyController {

    @RequestMapping("hello")
    public String welcome(){
        System.out.println("----welcome----");
        return "hello";
    }



    /*@RequestMapping(value = "upload",method = {RequestMethod.POST})*/
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public String fileUpload(MultipartFile image,HttpServletRequest request) throws IOException {
        InputStream is = image.getInputStream();//输出流
        String filename = image.getOriginalFilename();//文件名称
        String realPath = request.getServletContext().getRealPath("/images");
        System.out.println("上传路径="+realPath);
        FileOutputStream os = new FileOutputStream(new File(realPath,doFileName(filename)));
        int size = IOUtils.copy(is,os);
        System.out.println("完成上传size="+size+"Byte");
        os.close();is.close();//关闭流
        return "welcome";
    }

    private String doFileName(String filename){
        String extension = FilenameUtils.getExtension(filename);
        String uuid = UUID.randomUUID().toString();
        System.out.println("上传文件名"+uuid);
        return uuid+"."+extension;
    }
}

/*    @RequestMapping("/hello.do")
    public String hello() {
        System.out.println("---hello()---");
        return "hello";
    }*/
 /*   @RequestMapping("/hello")
    public ModelAndView hello(){
        System.out.println("---hello()---");//进入方法的标志
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("msg","I’m peter!");
        return mav;
    }*/
 /*   @RequestMapping("/hello")
    public String hello(String username,Model model){
        System.out.println("---hello()---");//进入方法的标志
        model.addAttribute("username",username);
        return "hello";
    }*/
/*@RequestMapping("/hello")
public String hello(String username,Map<String,String> map){
    System.out.println("---hello()---");//进入方法的标志
    map.put("username",username);
    return "hello";
}*/

    /*@RequestMapping(value = "/param1", method = {RequestMethod.GET})
    public String param1(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("name=" + name);
        request.setAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/param2", method = {RequestMethod.GET, RequestMethod.POST})
    public String param2(HttpServletRequest request, HttpSession session,HttpServletResponse response) {

        String name = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("name=" + name + ",age=" + age);
        session.setAttribute("age", age);
        request.setAttribute("name", name);
        return "hello";
    }
    @RequestMapping(value = "param3",method = {RequestMethod.POST})
    public String param3(String username,int age){//数据名与方法参数相同
        System.out.println("--param3()--");
        System.out.println("username="+username);
        System.out.println("age="+age);
        return "hello";
}
    @RequestMapping(value = "param4",method = {RequestMethod.POST})//数据名与方法参数不同
    public String param4(
            @RequestParam(value = "username",required = false) String u,
            @RequestParam(value = "age",defaultValue = "18") int a,HttpSession session){
        System.out.println("--param4()--");
        System.out.println("u="+u);
        System.out.println("a="+a);
        session.setAttribute("name",u);
        return "redirect:text";//redirect:
    }
    @RequestMapping(value = "param5",method = {RequestMethod.POST})//数据名与方法参数不同
    public String param5(User user,HttpSession session){
        System.out.println("--param5()--");
        System.out.println("username="+user.getUsername());
        System.out.println("age="+user.getAge());
        session.setAttribute("name",user.getUsername());
        return "redirect:text";//redirect:
    }

    @RequestMapping(value = "text")
    public String text(){
        System.out.println("--test()--");
        return "hello";
    }
    @RequestMapping(value = "/reg")
    public String reg(User user){
        System.out.println("username="+user.getUsername());
        System.out.println("pwd="+user.getAge());
//        System.out.println("birthday="+user.getBirthday());
        System.out.println("city="+user.getAddress().getCity());
        System.out.println("street="+user.getAddress().getStreet());
        System.out.println("phone="+user.getAddress().getPhone());
        return "redirect:/param1/text";
    }

     */

