package edu.school21.javainfo.dao;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DAO {
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
}
