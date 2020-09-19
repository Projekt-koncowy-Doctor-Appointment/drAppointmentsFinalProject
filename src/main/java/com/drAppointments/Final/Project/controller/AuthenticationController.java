package com.drAppointments.Final.Project.controller;

import com.drAppointments.Final.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public ModelAndView patientHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("patient");
        return modelAndView;
    }
    // można spróbować spróbować dodać value = "/index", i tam spróbować wszystko umieścić w indexie,
    // chociaż jest to chyba mało optymalne

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

}
