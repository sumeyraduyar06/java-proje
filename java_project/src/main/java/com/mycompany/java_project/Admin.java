/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Admin extends User {
    
    //contructor
    public Admin(String ID, String name, String surname, String password, String role){
    super(ID, name, surname, password, role);
}
    public void addStaff(User newStaff){
        File_Manager fm=new File_Manager();
        fm.saveUser("users.json", newStaff);
    }
 
    public void removeStaff(String staffID){
        File_Manager fm=new File_Manager(); //kullanıcıları çekme
        List<User> updatedList=fm.readUsers("users.json");
        
        updatedList.removeIf(user->user.getID().equals(staffID)); //çıkarılacak çalışanın ID aracılığı ile bulma
        
        fm.writeAllUsers("users.json",updatedList);
        System.out.println("Staff with ID:"+staffID+" has been removed!");
        
    }
}
