/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Teachers;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class is fro making CRUD operations to teacher table
 * in our database
 * @author Opiframe
 */
public class TeacherDAO {
    
    /**
     * This method adds new tecaher into database
     * @param teach
     * @throws java.lang.Exception
     */
    public static void addTeacher(Teachers teach) throws Exception{
        
        //Create session to our database
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Because we are writing to database we need tarnsaction besides session
        Transaction transaction = session.beginTransaction();
        //Add teacher to database
        System.out.println("Save Teacher info to db");
        session.save(teach);
        //End transaction
        transaction.commit();
        //Release session
        session.close();
    }
    
    public static List<Teachers> getTeachers() throws Exception{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Use hql query language here, NOT SQL!!!
        Query query = session.createQuery("from Teachers");
        //Make the query to database
        List<Teachers> lst = query.list();
        session.close();
        //Return list of teachers
        return lst;
    }
}
