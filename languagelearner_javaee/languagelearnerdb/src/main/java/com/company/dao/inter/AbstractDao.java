package com.company.dao.inter;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao {
    public Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");//JDBC - Java Database Connectivity
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/language_learner", "root", "");
        return c;
    }

    private static EntityManagerFactory emf = null;

    public static EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("languagePU");
        }
        EntityManager em = emf.createEntityManager();

        return em;
    }
    
    public static void closeEmf(){
        emf.close();
    }
}
