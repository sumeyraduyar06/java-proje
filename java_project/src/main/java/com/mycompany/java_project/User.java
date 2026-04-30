/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;

/**
 *
 * @author ASUS
 */
public abstract class User {
    private String ID;
    private String name;
    private String surname;
    private String password;
    private String role;
    
    //boş constructor
    public User(){};
    
    //constructor
    public User(String ID,String name,String surname,String password,String role){
        this.ID=ID;
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.role=role;
    }
    
    //get and set methods
    //ID
    public void setID(String ID){
        this.ID=ID;
    }
    public String getID(){
        return this.ID;
    }
    
    //name
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    
    //surname
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getSurname(){
        return this.surname;
    }
    
    //password
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    
    //role
    public void setRole(String role){
        this.role=role;
    }
    public String getRole(){
        return this.role;
    }

}
