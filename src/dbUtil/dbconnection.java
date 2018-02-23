package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    private static final String SQCONN = "jdbc:sqlite:school.sqlite";


    public static Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                return DriverManager.getConnection(SQCONN);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }










}//class
