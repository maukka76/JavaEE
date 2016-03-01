/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.RelTable;
import com.base.models.SearchModel;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Opiframe
 */
public class SearchDAO {
    
    public static SearchModel serachInfo(int t_id,int c_id) throws Exception{
        SearchModel returnValue = new SearchModel();
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(t_id != 0){
            Criteria criteria = session.createCriteria(RelTable.class, "rt");
            criteria.createCriteria("rt.course", "course");
            criteria.createCriteria("rt.teachers", "teach");
            criteria.createCriteria("rt.students", "students");
            criteria.add(Restrictions.eq("teach.id",t_id));
            
            if(criteria.list().size() > 0){
              
               List<RelTable> temp = criteria.list();
               for(int i = 0; i < temp.size(); i++){
                     if(temp.get(i) != null){
                         if(temp.get(i).getCourse() != null)
                            returnValue.addCourse(temp.get(i).getCourse().getCName());
                         if(temp.get(i).getStudents() != null)
                            returnValue.addStudent(temp.get(i).getStudents().getSName());
                         if(temp.get(i).getTeachers() != null)
                            returnValue.addTeach(temp.get(i).getTeachers().getTName());
                     }
                 }
            }
        }
        
        session.close();
        return returnValue;
    }
}
