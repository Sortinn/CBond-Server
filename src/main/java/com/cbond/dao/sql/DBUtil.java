package com.cbond.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/CBOND";
    private static String username = "root";
    private static String password = "123456";

    public static Connection open()  {
        try {

            Class.forName(driverName);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        //如果发生异常，返回null
        return null;
    }

    public static void close(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {



    }

}
