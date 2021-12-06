package com.loukj.finalhomework;

import javax.xml.transform.Result;
import java.sql.*;

public class JdbcUtils {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/userinfo";
        String sqlUserName = "root";
        String sqlPassword = "root";
        Connection newConn = DriverManager.getConnection(url, sqlUserName, sqlPassword);
        return newConn;
    }

    public static void release(Statement newSta, Connection newConn) {
        if (newSta != null) {
            try {
                newSta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            newSta = null;
        }
        if (newConn != null) {
            try {
                newConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            newConn = null;
        }
    }

    public static void release(ResultSet newRst, Statement newSta, Connection newConn) {
        if (newRst != null) {
            try {
                newRst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            newRst = null;
        }
        release(newSta, newConn);
    }
}
