/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;

/**
 *
 * @author ASUS
 */

import java.util.List;

public class Login_System implements IAuthenticable {
    File_Manager fm=new File_Manager();
    
    //override
    public User login(String id,String password){
        List<User> users=fm.readUsers("users.json");
        
        for(User user:users){
            if(user.getID().equals(id) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
