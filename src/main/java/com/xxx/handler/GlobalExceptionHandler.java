package com.xxx.handler;

import com.xxx.exception.UsernameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UsernameException.class)
    public ModelAndView UsernameException(Exception exception){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("massage","用户名错误");
        modelAndView.addObject("tips",exception);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
