/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ASUS
 */
    public class Staff extends User {
    private double salary;
    private String entryhour;
    private String exithour;
    private String hour;
    
    //constructor
    public Staff(String ID,String name,String surname,String password,String role,double salary,String entryhour,String exithour,String hour){
        super(ID,name,surname,password,role);
        this.salary=salary;
        this.entryhour=entryhour;
        this.exithour=exithour;
        this.hour=hour;
    }
    
    //get functions
    public double getSalary(){
        return this.salary;
    }
    public String getEntryHour(){
        return this.entryhour;
    }
    public String getExitHour(){
        return this.exithour;
    }
    
    //set functions
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setEntryHour(String entryhour){
        this.entryhour=entryhour;
    }
    public void setExitHour(String exithour){
        this.exithour=exithour;
    }
    
    //taking entry hour method
    public String recordTime(){
        LocalTime currentTime=LocalTime.now(); //o anki saati alır
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm"); //saati okunaklı bir formata çevirir
        return currentTime.format(formatter);
    }
    
    public void recordEntry(){
        this.entryhour = recordTime();
        System.out.println("Entry recorded at: " + this.entryhour);
    }
    public void recordExit(){
        this.exithour=recordTime();
        System.out.println("Exit recorded at:"+this.exithour);
    }
  
    public void timeTracking(){
      if(entryhour!=null && exithour!=null){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        //saat formatına dönüştürdüğümüz giriş çıkış saatlerini işlem yapabilmek için geri zaman formatına dönüştürüyoruz
        LocalTime entry = LocalTime.parse(entryhour, formatter);
        LocalTime exit = LocalTime.parse(exithour, formatter);
        
        // İki zaman arasındaki farkı hesaplar
        java.time.Duration duration = java.time.Duration.between(entry, exit);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        this.hour = hours + " saat " + minutes + "dakika";
        System.out.println("Bugünlük toplam çalışma saati:"+ this.hour);
      }else{
        System.out.println("Giriş veye çıkış saati sisteme girilmemiş.");
      }
    }
   
}//end
