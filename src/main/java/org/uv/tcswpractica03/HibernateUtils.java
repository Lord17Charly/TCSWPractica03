package org.uv.tcswpractica03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

    private static final SessionFactory sessionFactory;

    static {
        try {
         
            Configuration cfg = new Configuration().configure();

            
            cfg.addAnnotatedClass(Empleados.class);
            cfg.addAnnotatedClass(Departamento.class);

           
            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println(" Session error: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
