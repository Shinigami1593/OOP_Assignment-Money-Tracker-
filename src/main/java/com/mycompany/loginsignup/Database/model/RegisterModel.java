/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsignup.Database.model;

/**
 *
 * @author Asus
 */
public class RegisterModel {
    private String username;
    private String address;
    private String password;
    private String cPassword;
    
    public RegisterModel(String username, String password, String address, String cPassword){
        this.username = username;
        this.password = password;
        this.address = address;
        this.cPassword = cPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }
    
    public String getCPassword(){
        return cPassword;
    }
}
