/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Opiframe
 */
public class SearchModel {
    
    private List<String> teach = new ArrayList();
    private List<String> stud = new ArrayList();
    private List<String> course = new ArrayList();
    
    public void addTeach(String t){
        if(t != null)
            teach.add(t);
    }
    
    public void addStudent(String s){
        if(s != null)
            stud.add(s);
    }
    
    public void addCourse(String c){
        if(c != null)
            course.add(c);
    }

    public List<String> getTeach() {
        return teach;
    }

    public List<String> getStud() {
        return stud;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setTeach(List<String> teach) {
        this.teach = teach;
    }

    public void setStud(List<String> stud) {
        this.stud = stud;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }
    
    
}
