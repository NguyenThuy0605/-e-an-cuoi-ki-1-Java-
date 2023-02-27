/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public abstract class ConnectDB {
    
        private String jdbcURL = "jdbc:mysql://localhost:3306/qlch";
        private String jdbcUsername = "root";
        private String jdbcPassword = "dongchi0905";
        protected Connection conn;
    
    public ConnectDB() {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection to database success");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Connection to database failed");
        }
    }
    
}
