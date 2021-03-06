package edu.upc.dsa.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactorySession {
    public static Session openSession() {

        Connection conn = getConnection();

        Session session = new SessionImpl(conn);

        return session;
    }


    private static Connection getConnection() {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/dbjuego", "dbjuegodsa", "explorer19" );
                    //DriverManager.getConnection("jdbc:mysql://localhost/dbjuego?user=dbjuegodsa&password=explorer19");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
