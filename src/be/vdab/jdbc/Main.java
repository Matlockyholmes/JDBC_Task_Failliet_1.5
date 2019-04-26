package be.vdab.jdbc;

import java.sql.*;

public class Main {
    private static final String URL =
            "jdbc:mysql://localhost/bieren?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String UPDATE_BROUWER_2 = "update bieren set brouwerid = 2 where brouwerid = 1 and alcohol >= 8.5";
    private static final String UPDATE_BROUWER_3 = "update bieren set brouwerid = 3 where brouwerid = 1";
    private static final String DELETE_BROUWER_1 = "delete from brouwers where id = 1";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.executeUpdate(UPDATE_BROUWER_2);
            statement.executeUpdate(UPDATE_BROUWER_3);
            statement.executeUpdate(DELETE_BROUWER_1);
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }
}


