package edu.school21.javainfo.dao;

import edu.school21.javainfo.model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DAO {
    private SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Task.class).buildSessionFactory();

    private static final String URL
            = "jdbc:postgresql://localhost:5432/postgres";

    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            Criteria criteria = session.createCriteria(myClass);
            List entities = criteria.list();
            for (Object object : entities) {
                List<String> fieldsOfCurrentObject = new ArrayList<>();
                fields.add(fieldsOfCurrentObject);
                for (Field field : myClass.getFields()) {
                    if (field.getType() == int.class) {
                        fieldsOfCurrentObject.add(String.valueOf(field.get(object)));
                    } else {
                        fieldsOfCurrentObject.add((String) field.get(object));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return fields;
    }

    public List<String> getNamesOfFields(String tableName) {
        List<String> names = new ArrayList<>();

        Class<?> myClass = getTableClass(tableName);
        for (Field field : myClass.getFields()) {
            names.add(field.getName());
        }
        return names;
    }

    private Class<?> getTableClass(String tableName) {
        String className = Character.toUpperCase(tableName.charAt(0)) + tableName.substring(1);
        if (className.endsWith("s")) {
            className = className.substring(0, className.length() - 1);
        }
        try {
            return Class.forName("edu.school21.javainfo.model." + className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PreDestroy
    public void closeConnections() throws SQLException {
        connection.close();
    }
}
