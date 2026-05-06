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
    private List<Member> assignedMembers;
    
    //constructor
    public Trainer(String ID,String name,String surname,String password, String role, String branch){
        super(ID,name,surname,password,role);
        this.branch=branch;
        this.assignedMembers=new ArrayList<>();
    }
    
    //get ve set functions
    public String getBranch(){
        return this.branch;
    }
    public void setBranch(String branch){
        this.branch=branch;
    }
    
    
    //5 trainer 
    public boolean assignedMember(Member member){
        if(assignedMembers.size()<5){
            assignedMembers.add(member);
            return true;
        }else{
            return false;
        }
    }
    
    //eğitmenler sadece kendi alanlarında ders verebilir
    public void leadClass(Member member, String branch){
        if(!this.assignedMembers.contains(member)){
            throw new IllegalArgumentException("Hata: Eğitmen girilen üyeye ders vermemektedir.");
        }else if(this.branch!=branch){
            throw new IllegalArgumentException("Hata: Eğitmen istenilen branşta ders vermemektedir.");}
        else{
            this.branch=branch;       
        }
      }
    }
            
    
    
    

