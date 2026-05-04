/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class Trainer extends User {
    private String branch;
    private List<Member> assigned_members;
    
    //constructor
    Trainer(String ID,String name,String surname,String password, String role,String branch){
        super(ID,name,surname,password,role);
        this.branch=branch;
        this.assigned_members=new ArrayList<>();
    }
    
    //get ve set functions
    public String getBranch(){
        return this.branch;
    }
    public void setBranch(String br){
        this.branch=br;
    }
    
    
    //5 trainer 
    public boolean assignedMember(Member member){
        if(assigned_members.size()<5){
            assigned_members.add(member);
            return true;
        }else{
            return false;
        }
    }
}
