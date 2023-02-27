/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author ADMIN
 */
public class UserDAO extends ConnectDB{
    
    public UserDAO() {
        super();
    }
    
    public User verifyUser(User user) {
        try {
            
       
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT *\n"
                    + "FROM user\n"
                    + "WHERE username = ? AND password = ?\n");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            
            System.out.println(preparedStatement);
            
             ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                return new User(
                        rs.getString(1),
                        rs.getString(2)
                );
            }
    }
         catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    
    }
    
    public void createUser(User user) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO user(username, password)\n"
                    + "VALUES(?,?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean checkDuplicate(String username) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE username = ?");
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        System.out.println( userDAO.verifyUser(new User("admin", "admi1n")));
    }
    
}
