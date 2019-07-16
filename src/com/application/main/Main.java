package com.application.main;
import com.application.entity.UserDetails;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //Create a CriteriaBuilder instance by calling the Session.getCriteriaBuilder() method.
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create a query object by creating an instance of the CriteriaQuery interface.
        CriteriaQuery<UserDetails> criteria = builder.createQuery(UserDetails.class);

        // Set the query Root by calling the from() method on the CriteriaQuery object to define a range variable in FROM clause.
        Root<UserDetails> root = criteria.from(UserDetails.class);

        //Specify what the type of the query result will be by calling the select() method of the CriteriaQuery object.
        criteria.select(root);

        //Prepare the query for execution by creating a org.hibernate.query.Query instance by calling the Session.createQuery() method, specifying the type of the query result.
        Query<UserDetails> q = session.createQuery(criteria);

        //Execute the query by calling the getResultList() or getSingleResult() method on the org.hibernate.query.Query object.
        List<UserDetails> list = q.getResultList();

        for (UserDetails l : list) {
            System.out.println(l.getUsername());
        }


        session.getTransaction().commit();
        session.close();


    }
}