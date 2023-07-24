package uz.pdp.trackstore.conectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static ConnectionPool intance = new ConnectionPool();
    private BlockingQueue<Connection> free = new LinkedBlockingQueue<>(8);
    private BlockingQueue<Connection> used = new LinkedBlockingQueue<>(8);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/trackstore";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "root123";

    private ConnectionPool() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 8; i++) {
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                free.add(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static ConnectionPool getIntance() {
        return intance;
    }

    public Connection getConnection() {
        Connection connection;
        try {
            connection = free.take();
            used.put(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    public void releaseConnection(Connection connection) {
        try {
            used.remove(connection);
            free.put(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
