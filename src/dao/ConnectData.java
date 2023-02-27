//package dao;
//import cuahangmevabe.Account;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author ADMIN
// */
//public class ConnectData {
//     private static String URL ="jdbc:mysql://localhost:3306/qlch";
//    private static String USER = "root";
//    private static String PASSWORD ="123456";
// 
//    public static Connection getConnection() {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            return DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (Exception ex) {
//            System.out.println("error");
//            ex.printStackTrace();
//
//        }
//        return null;
//    }
//
//    public static ArrayList<Account> getAccount() {
//        Statement st = null;
//        ArrayList<Account> list = new ArrayList<>();
//        try {
//            st = getConnection().createStatement();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        String sql = ("SELECT * FROM account");
//        ResultSet rs = null;
//        try {
//            rs = st.executeQuery(sql);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        try {
//            while (rs.next()) {
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//                String type = rs.getString("type");
//                System.out.println("\t" + username + "\t" + password);
//                list.add(new Account(username, password, type));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        try {
//            getConnection().close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return list;
//    }
//
//}
//
