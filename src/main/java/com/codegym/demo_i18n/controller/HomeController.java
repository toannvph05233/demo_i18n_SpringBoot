package com.codegym.demo_i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class HomeController {
    @Autowired
    MessageSource messageSource;

    @GetMapping("/home")
    public ModelAndView home(@RequestParam(defaultValue = "en") String lg){
        ModelAndView modelAndView = new ModelAndView("demo");

        String home = messageSource.getMessage("home",null,new Locale(lg));
        String user = messageSource.getMessage("user",null,new Locale(lg));
        String product = messageSource.getMessage("product",null,new Locale(lg));

        modelAndView.addObject("home",home);
        modelAndView.addObject("user",user);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
}
