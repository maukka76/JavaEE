/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.controller;

import com.base.DAO.CourseDAO;
import com.base.DAO.StudentDAO;
import com.base.DAO.TeacherDAO;
import com.base.models.Course;
import com.base.models.RelTable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {
    
     @RequestMapping(value="/admin/course", method=RequestMethod.GET)
     public String renderCourse(ModelMap map){
         map.addAttribute("isLogged", true);
         map.addAttribute("course",new Course());
         try{
             map.addAttribute("courses", CourseDAO.getCourses());
         }catch(Exception e){
             e.printStackTrace();
         }
         return "course";
     }
     
    @RequestMapping(value="/admin/course", method=RequestMethod.POST)
    public String addNewCourse(@ModelAttribute("course") Course course,ModelMap map){
        try{
             CourseDAO.addCourse(course);
             map.addAttribute("courses", CourseDAO.getCourses());
         }catch(Exception e){
             e.printStackTrace();
         }
        return "redirect:/admin/course";
    }
    
     @RequestMapping(value="/admin/create", method=RequestMethod.GET)
     public String renderCreateCourse(ModelMap map){
         map.addAttribute("isLogged", true);
         map.addAttribute("relTable", new RelTable());
         try{
             map.addAttribute("teachers", TeacherDAO.getTeachers());
             map.addAttribute("students", StudentDAO.getAllStudents());
             map.addAttribute("courses", CourseDAO.getCourses());
         }catch(Exception e){
             e.printStackTrace();
         }
         return "create_course";
     }
     
     @RequestMapping(value="/admin/add", method=RequestMethod.POST)
     public String createCourse(HttpServletRequest request){
         System.out.println(request.getParameter("course_id"));
         System.out.println(request.getParameter("teach_id"));
         try{
         CourseDAO.addCourseRelations(Integer.parseInt(request.getParameter("teach_id")), 
                                      Integer.parseInt(request.getParameter("course_id")));
         }catch(Exception e){
             e.printStackTrace();
         }
         return "add_students";
     }
}
