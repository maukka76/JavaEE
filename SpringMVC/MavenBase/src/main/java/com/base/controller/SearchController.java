/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.controller;

import com.base.DAO.CourseDAO;
import com.base.DAO.SearchDAO;
import com.base.DAO.TeacherDAO;
import com.base.models.NewCourseModel;
import com.base.models.RelTable;
import com.base.models.SearchModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    
     @RequestMapping(value="/admin/search", method=RequestMethod.GET)
     public String search(ModelMap map){
         try{
             map.addAttribute("teachers", TeacherDAO.getTeachers());
             map.addAttribute("courses", CourseDAO.getCourses());
         }catch(Exception e){
             e.printStackTrace();
         }
         return "search";
     }
     
     @RequestMapping(value="/admin/search", method=RequestMethod.POST)
     public @ResponseBody SearchModel search(@RequestBody NewCourseModel model) throws Exception{
         
         SearchModel returnValue = null;
         try{
             returnValue = SearchDAO.serachInfo(Integer.parseInt(model.getTeach_id()),Integer.parseInt(model.getCourse_id()));
         }catch(Exception e){
             e.printStackTrace();
         }
         return returnValue;
     }
}       
