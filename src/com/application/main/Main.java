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

            Query query = session.createQuery(" from UserDetails");
            query.setMaxResults(2); //Set the maximum result
            query.setFirstResult(2); //  prints  from the result 3

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
