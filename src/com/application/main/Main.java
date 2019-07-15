package com.application.main;

import com.application.entity.UserDetails;
import com.application.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args){
        try (Session session = HibernateUtil.sessionFactory().openSession()){
            session.beginTransaction();

            //By using named query (HQL)
            Query query = session.getNamedQuery("UserDetails.byId");
            query.setParameter("userId",1);//setting the value of userId in the named Parameters

            //By using named native query (SQL)
            Query query1 = session.getNamedNativeQuery("UserDetails.byName");
            query.setString(0,"User23")
            List<UserDetails>users = (List<UserDetails>) query.list();

            session.getTransaction().commit();
            session.close();
            for (UserDetails s : users){
                System.out.println(s.getId()+"\t"+s.getUsername());
            }

         }catch (HibernateException ex){
            ex.printStackTrace();
        }


    }


}
