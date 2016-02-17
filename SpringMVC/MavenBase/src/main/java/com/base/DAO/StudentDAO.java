/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Students;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Opiframe
 */
public class StudentDAO {
    
    public static void addStudent(Students stud) throws Exception{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(stud);
        transaction.commit();
        session.close();
    }
    
    public static List<Students> getAllStudents() throws Exception{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Students.class);
        
        List<Students> std = criteria.list();
        session.close();
        
        return std;
    }
}
