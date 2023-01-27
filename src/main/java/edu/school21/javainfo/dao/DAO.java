package edu.school21.javainfo.dao;

import edu.school21.javainfo.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DAO {
    private final SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Check.class)
            .addAnnotatedClass(Friend.class)
            .addAnnotatedClass(P2p.class)
            .addAnnotatedClass(Peer.class)
            .addAnnotatedClass(Recommendation.class)
            .addAnnotatedClass(Task.class)
            .addAnnotatedClass(Timetracking.class)
            .addAnnotatedClass(Transferredpoint.class)
            .addAnnotatedClass(Verter.class)
            .addAnnotatedClass(Xp.class)
            .buildSessionFactory();

    private static final String URL
            = "jdbc:postgresql://localhost:5432/postgres";

    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> index() {
        List<String> tables = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select tablename from pg_tables " +
                            "where schemaname = 'public';");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tables.add(resultSet.getString("tablename"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tables;
    }

    public List<List<String>> getAll(String tableName) {
        List<List<String>> fields = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Class<?> myClass = getTableClass(tableName);

            EntityManager em = session.getEntityManagerFactory()
                    .createEntityManager();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery cq = builder.createQuery(myClass);
            Root root = cq.from(myClass);
            cq.select(root);
            List entities = em.createQuery(cq).getResultList();
            for (Object object : entities) {
                List<String> fieldsOfCurrentObject = new ArrayList<>();
                fields.add(fieldsOfCurrentObject);
                for (Field field : myClass.getFields()) {
                    if (field.getType() == int.class) {
                        fieldsOfCurrentObject.add(
                                String.valueOf(field.get(object)));
                    } else if (field.getType() == Date.class
                            || field.getType() == Timestamp.class
                            || field.getType() == Time.class) {
                        fieldsOfCurrentObject.add(field.get(object).toString());
                    } else {
                        fieldsOfCurrentObject.add((String) field.get(object));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return fields;
    }

    public List<Field> getFields(String tableName) {
        List<Field> fields = new ArrayList<>();

        Class<?> myClass = getTableClass(tableName);
        for (Field field : myClass.getFields()) {
            fields.add(field);
        }
        return fields;
    }

    public <T> T getObject(String tableName) {
        Class<T> myClass = getTableClass(tableName);
        try {
            return myClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> Class<T> getTableClass(String tableName) {
        String className = Character.toUpperCase(tableName.charAt(0))
                + tableName.substring(1);
        if (className.endsWith("s")) {
            className = className.substring(0, className.length() - 1);
        }
        try {
            return (Class<T>) Class.forName(
                    "edu.school21.javainfo.model." + className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> void insert(T object) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @PreDestroy
    public void closeConnections() throws SQLException {
        connection.close();
    }
}
