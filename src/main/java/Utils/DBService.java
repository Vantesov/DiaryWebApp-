package Utils;

import java.sql.*;

public class DBService {
    private static final String URL = "jdbc:postgresql://localhost:5432/diary";
    private static final String username = "postgres";
    private static final String password = "root";


    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver class is not found!");
        }
        return DriverManager.getConnection(URL,username,password);
    }

    public static int insert(String SQL){
        Connection connection = null;
        Statement statement = null;
        int rows = 0;

        try {
            connection = DBService.getConnection();
            statement = connection.createStatement();
            rows = statement.executeUpdate(SQL);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rows;
    }

    public static ResultSet select(String SQL){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return resultSet;
    }

    public static int update(String SQL){
        Connection connection = null;
        Statement statement = null;
        int rows = 0;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            rows = statement.executeUpdate(SQL);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rows;
    }

    public static int delete(String SQL){
        Connection connection = null;
        Statement statement = null;
        int rows = 0;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            rows = statement.executeUpdate(SQL);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rows;
    }
}
