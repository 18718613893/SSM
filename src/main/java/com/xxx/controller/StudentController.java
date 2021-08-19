package com.xxx.controller;

import com.xxx.domain.Student;
import com.xxx.exception.SexException;
import com.xxx.exception.StudentException;
import com.xxx.exception.UsernameException;
import com.xxx.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    @Resource
    private StudentService service;

    @RequestMapping(value = "/selectStudent.do")
    @ResponseBody
    public List<Student> selectStudent(){
    List<Student> students=service.selectAllInService();
    return students;
    }

    @RequestMapping(value = "/insertStudent.do")
    @ResponseBody
    public ModelAndView insertStudent(Student student) throws StudentException {
        String tips="注册失败";
        if(!"xxx".equals(student.getUsername())){
        throw new UsernameException("用户名不是xxx");
        }
        if (!"女".equals(student.getSex())){
            throw new SexException("性别不是女");
        }
        int i = service.insertStudentInService(student);
        if (i>0){
            tips="用户 "+student.getUsername()+ "注册成功";
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("tips",tips);
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping(value = "/login.do")
    @ResponseBody
    public ModelAndView login(Integer id, String password, HttpSession session){
        ModelAndView modelAndView =new ModelAndView();
        Student student = service.selectByIdInService(id);
        System.out.println(student);
        if(student!=null){
            if(student.getPassword().equals(password)){
                session.setAttribute("user",student);
                modelAndView.addObject("tips","登录成功");
            }else{
                modelAndView.addObject("tips","密码错误");
            }
        }else{
            modelAndView.addObject("tips","查无此用户");
        }
        modelAndView.setViewName("tips");
        return modelAndView;
    }


    @RequestMapping(value = "/logout.do")
    @ResponseBody
    public ModelAndView logout(HttpSession session){
        session.removeAttribute("user");
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("tips","退出登录成功");
        modelAndView.setViewName("tips");
        return modelAndView;
    }

    @RequestMapping(value = "student.do")
    @ResponseBody
    public Student student(){
        Student student = service.selectByIdInService(1);
        return student;
    }
}
