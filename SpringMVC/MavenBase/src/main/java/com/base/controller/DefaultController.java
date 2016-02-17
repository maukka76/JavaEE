
package com.base.controller;

import com.base.DAO.TeacherDAO;
import com.base.models.Teachers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    
    private boolean isLogged = false;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(ModelMap map){
        
        return "index";
    }
    
    @RequestMapping(value="/admin/second", method=RequestMethod.GET)
    public String second(ModelMap map){
        isLogged = true;
        map.addAttribute("teacher", new Teachers());
        try{
            map.addAttribute("teachers",TeacherDAO.getTeachers());
        }catch(Exception e){
            e.printStackTrace();
        }
        return "second";
    }
    
    @RequestMapping(value="/admin/teacher", method=RequestMethod.POST)
    public String addNewTeacher(@ModelAttribute("teacher") Teachers teach,ModelMap map){
        try{
            TeacherDAO.addTeacher(teach);
            map.addAttribute("save_info", "Teacher added succesfully!");
            map.addAttribute("teachers",TeacherDAO.getTeachers());
        }catch(Exception e){
            map.addAttribute("save_info", "Database error!");
            e.printStackTrace();
        }
        return "second";
    }
    
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(HttpServletRequest request,HttpServletResponse resp){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            isLogged = false;
            new SecurityContextLogoutHandler().logout(request, resp, auth);
        }
        return "redirect:/";
    }
    
    @RequestMapping(value="/login/error",method=RequestMethod.GET)
    public String loginError(ModelMap map){
        map.addAttribute("login_error", "Wrong username or password");
        return "index";
    }
    
    @RequestMapping(value="/403",method=RequestMethod.GET)
    public String accessDenied(ModelMap map){
        return "<h1><i>You dont have permission to this page</i></h1>";
    }
    
    @ModelAttribute("isLogged")
    public boolean messages() {
        return isLogged;
    }
}
