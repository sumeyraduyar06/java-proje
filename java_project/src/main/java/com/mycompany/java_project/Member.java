/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;

/**
 *
 * @author sude
 */
public class Member extends User {
/**
 *
 * @author sude
 */
      public enum Membership{
        BASIC(1,"Standart Plan",0.0),
        PREMIUM(2,"Premium Plan",1.1),
        VIP(3,"VIP üye",2.2);
    
    //üyelik özelliklerimizi tanımlıyoruz
    private final int num; //üyelik tipleri 1,2,3 şeklinde
    private final String planName;
    private final double planPrice; //üyelik fiyatı
    private String start_date;
    private String end_date;
    private String assigned_trainer;
    
    private Membership(int num, String planName, double planPrice){
        this.num=num;
        this.planName=planName;
        this.planPrice=planPrice;
    }
    
    //üyelik özellikleri get metotları
    public int getNum(){
        return num;
    }
    
    public String getPlanName(){
    return planName;
    }
    
    public double getPlanPrice(){
        return planPrice;
    }
    
    public String getStartDate(){
        return this.start_date;
    }
    
    public String getEndDate(){
        return this.end_date;
    }
    
    public String getAassignedTrainer(){
        return this.assigned_trainer;
    }
    
   }//enum bitişi
}
