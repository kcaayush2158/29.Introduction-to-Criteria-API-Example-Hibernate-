package com.application.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

public class HibernateUtil
{
    public static StandardServiceRegistry standardServiceRegistry;
    public static SessionFactory sessionFactory;

    static {
        try{
            standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
            Metadata metadata = metadataSources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (HibernateException ex){
                ex.printStackTrace();
                if(standardServiceRegistry !=null){
                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
                }
        }

    }
    public static SessionFactory sessionFactory(){
        return sessionFactory;
    }

}
