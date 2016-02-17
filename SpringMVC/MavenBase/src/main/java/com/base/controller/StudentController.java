/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.controller;

import com.base.DAO.StudentDAO;
import com.base.models.Students;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    private boolean studentPage = false;
    @RequestMapping(value="/admin/student", method=RequestMethod.GET)
    public String renderStudent(ModelMap map){
        map.addAttribute("studentPage", true);
        map.addAttribute("isLogged", true);
        map.addAttribute("student", new Students());
        try{
            map.addAttribute("students", StudentDAO.getAllStudents());
        }catch(Exception e){
            e.printStackTrace();
        }
        return "student";
    }
    
    @RequestMapping(value="/admin/student", method=RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("student") Students stud,ModelMap map){
        try{
            StudentDAO.addStudent(stud);
            map.addAttribute("students", StudentDAO.getAllStudents());
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/student";
    }
    
    @ModelAttribute("studentPage")
    public boolean studenPage() {
        return studentPage;
    }
}
