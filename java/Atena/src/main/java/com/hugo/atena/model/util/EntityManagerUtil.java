/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hugo
 */
public class EntityManagerUtil {

    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static EntityManager getEntityManager() {

        if (factory == null) {
//            factory = Persistence.createEntityManagerFactory("AtenaPU");
            factory = Persistence.createEntityManagerFactory("AtenaHSQLDB");
        }
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    private static EntityManagerFactory getHSQLDB() {

//        @see https://www.objectdb.com/java/jpa/persistence/overview
//        @see http://www.hsqldb.org/doc/2.0/guide/running-chapt.html#rgc_new_db
        Map<String, String> properties = new HashMap();
        properties.put("javax.persistence.jdbc.user", "admin");
        properties.put("javax.persistence.jdbc.password", "admin");
        properties.put("javax.persistence.jdbc.driver", "org.hsqldb.jdbc.JDBCDriver");
        properties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.put("hibernate.connection.autocommit", "false");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("i can't", properties);

        return emf;
    }

    private static void createDB() {

        try {

            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection c = DriverManager.getConnection("jdbc:hsqldb:file:/home/hugo/Projects/GitProjects/remote_git/java/DB/db_atena;ifexists=false", "admin", "admin");

            System.out.println("IS Close:" + c.isClosed());

        } catch (SQLException ex) {
            Logger.getLogger(EntityManagerUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntityManagerUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
