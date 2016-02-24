/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Course;
import com.base.models.RelTable;
import com.base.models.Teachers;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Opiframe
 */
public class CourseDAO {
    
    public static List<Course> getCourses() throws Exception{
        
        List<Course> lst = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Course.class);
        lst = c.list();
        session.close();
        return lst;
    }
    
    public static void addCourse(Course c) throws Exception{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
        session.close();
    }
    
     public static void addCourseRelations(int t_id,int c_id) throws Exception{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteriaTeach = session.createCriteria(Teachers.class);
        criteriaTeach.add(Restrictions.eq("id",t_id));
        List<Teachers> lst = criteriaTeach.list();
        
        Criteria criteriaCourse = session.createCriteria(Course.class);
        criteriaCourse.add(Restrictions.eq("id",c_id));
        List<Course> lstC = criteriaCourse.list();
        
        RelTable table = new RelTable();
        table.setCourse(lstC.get(0));
        table.setTeachers(lst.get(0));
        session.save(table);
        transaction.commit();
        session.close();
    }
}
