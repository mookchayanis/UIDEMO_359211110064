package sample;

import dbUtil.dbconnection;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class loginModel {
    Connection connection;

    public loginModel() {
        try {
            this.connection = dbconnection.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
        if (this.connection ==null) {
            System.exit(1);
        }
        }//loginModel
    public boolean isDatabaseConnection(){

    }
}//class
