/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsignup.Database.dao;

import com.mycompany.loginsignup.Database.model.LoginModel;
import com.mycompany.loginsignup.Database.model.RegisterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class AuthDao {
    public boolean login(LoginModel user) {
        PreparedStatement ps = null;
        Connection conn = openConnection();

        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public boolean register(RegisterModel user) {
        PreparedStatement ps = null;
        Connection conn = openConnection();

        String sql = "INSERT INTO users(username, password, email) VALUES(?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getCPassword());

            int result = ps.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    private Connection openConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
