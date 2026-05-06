/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author sude
 */

public class Member extends User {
    private String tc;
    private String phoneNo;
    private int height;
    private int weight;
    private int age;
    private LocalDate startDate;
    private LocalDate endDate;
    private String assignedTrainer;
    private Membership currentPlan;
    //üyelik başlangıç tarihleri için güncel tarihi çekiyoruz
    LocalDate today = LocalDate.now();
    
    
    //tc boy kilo gibi bilgilerin get set metotları
    public String getTc(){
        return tc;}
    public void setTc(String tc){
        if(tc.length()<11){
        throw new IllegalArgumentException("Hata: Tc kimlik numarası 11 haneden az olamaz.");}
        else if(tc.length()>11){
        throw new IllegalArgumentException("Hata: Tc kimlik numarası 11 haneden fazla olamaz.");}
        else{
            this.tc=tc;
        }
    }
    
     public String getphoneNo(){
        return phoneNo;}
     public void setphoneNo(String phoneNo){
        if(phoneNo.length()<10){
        throw new IllegalArgumentException("Hata: Telefon numarası 10 haneden az olamaz.");}
        else if(phoneNo.length()>10){
             throw new IllegalArgumentException("Hata: Telefon numarası 10 haneden fazla olamaz.");}
        else{
            this.phoneNo=phoneNo;
        }
    }
     
     public int getHeight(){
         return height;}
     public void setHeight(int height){
         if(height<0){
             throw new IllegalArgumentException("Hata: Boy değeri negatif girilemez.");}
         else if(height>300){
             throw new IllegalArgumentException("Hata: Geçersiz boy değeri.");}
         else{
         this.height=height;}
     }
     
      public int getWeight(){
         return weight;}
     public void setWeight(int weight){
         if(weight<0){
             throw new IllegalArgumentException("Hata: Kilo değeri negatif girilemez.");}
         else if(weight>2000){
             throw new IllegalArgumentException("Hata: Geçersiz kilo değeri.");}
         else{
         this.weight=weight;}
     }
     
     public int getAge(){
         return age;}
     public void setAge(int age){
         if (age<0) {
            throw new IllegalArgumentException("Hata: Yaş negatif olamaz.");
        } else if (age > 200) {
            throw new IllegalArgumentException("Hata: Geçersiz bir yaş girdiniz.");
        } else {
            this.age = age;
        }
     }
    
 
    //get set metotları ile oluşabilecek tarih hataları önlenerek kullanıcıya bildirim verilecek
    public LocalDate getStartDate(){
        return this.startDate;
    }
    public void setStartDate(LocalDate startDate){
        if(endDate!=null && startDate.isAfter(endDate)){
          throw new IllegalArgumentException("Hata:Üyelik paketi bitiş tarihi, başlangıç tarihinden ileri bir tarihte olmalıdır.");}
        else{
            this.startDate=startDate;
        }
    }
    
    public LocalDate getEndDate(){
        return this.endDate;
    }
    public void setEndDate() {
       if(startDate==null){
           throw new IllegalArgumentException("Hata: Başlanıgıç tarihi girilmeden bitiş tarihi girilemez.");
       }else{
           this.endDate=startDate.plusDays(7);
       }
    }
   
    public String getAssignedTrainer(){
        return this.assignedTrainer;
    }
    public void setAssignedTrainer(){
        this.assignedTrainer=assignedTrainer;
    }
    
   
    //ÜYELİK BİLGİLERİ ENUM SINIFI
    public enum Membership{
        BASIC(1,"Standart Plan",100.0),
        PREMIUM(2,"Premium Plan",200.0),
        VIP(3,"VIP Plan",300.0);
    
    //üyelik özelliklerimizi tanımlıyoruz
    private final int num; //üyelik tipleri 1,2,3 şeklinde
    private final String planName;
    private final double planPrice; //üyelik fiyatı
    
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
   }//enum bitişi
      
      //tarihler girilerek üyeliğe kaç gün kaldı öğrenilecilecek
      public long checkMembershipStatus() {
          long dayCount=ChronoUnit.DAYS.between(today,endDate);
          return dayCount;
    }
      
      //üye yeni plana geçer ve üyeliğin start end tarihleri bugüne göre güncellenir
      public void changeMembershipPlan(Membership newPlan) {
        this.currentPlan=newPlan;
        this.setStartDate(LocalDate.now());
        this.setEndDate();
      }
      
      //eğer yeni plana şimd değil ileri bir tarihte geçiliyorsa
      public void changeMembershipPlan(Membership newPlan, LocalDate startDate){
          this.currentPlan=newPlan;
          this.setStartDate(startDate);
          this.setEndDate();
      }
      
}//end
