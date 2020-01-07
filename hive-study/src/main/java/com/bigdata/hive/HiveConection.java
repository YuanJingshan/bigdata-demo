package com.bigdata.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description
 * @date 2019/11/1
 */
public class HiveConection {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) {
        try {
            // Register driver and create driver instance
            Class.forName(driverName);
            // get connection
            Connection con = DriverManager.getConnection("jdbc:hive2://192.168.132.131:10000/test_db", "", "");
            Statement stmt = con.createStatement();

//            stmt.executeQuery("CREATE DATABASE userdb");
//            System.out.println("Database userdb created successfully.");
            // create statement
//            Statement stmt = con.createStatement();

            // execute statement
            ResultSet res = stmt.executeQuery("select * from emp");

            System.out.println("Result:");
            System.out.println(" ID \t Name \t Salary \t Designation \t Dept ");

            while (res.next()) {
                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4) + " " + res.getString(5));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}