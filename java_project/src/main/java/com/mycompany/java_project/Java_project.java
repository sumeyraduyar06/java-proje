/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.java_project;
//import com.google.gson.Gson;

/**
 *
 * @author ASUS
 */

import java.util.Scanner;

public class Java_project {

    public static void main(String[] args) {
        IAuthenticable aut=new Login_System();
        Scanner scan=new Scanner(System.in);
        
        //kullanıcıdan giriş bilgilerini alma
        System.out.println("ID:");
        String id=scan.nextLine();
        System.out.println("Password:");
        String password=scan.nextLine();
        
        User user=aut.login(id, password);
        
        if(user!=null){
            System.out.println("Login successful!");
            
            //giren kişiye göre ekrana yönlendirme
            switch(user.getRole()){
                case "admin":
                    System.out.println("Redirecting to admin panel.");
                    break;
               case "member":
                    try {
                      // Casting yaparak Genel User nesnesini Member'a çeviriyoruz ki kendi metotlarımızı görebilelim
                      Member loginMember = (Member) user;
                      loginMember.checkMembershipStatus();
                        
                      // İleride arayüze geçtiğinde burası şöyle olacak:
                      // UserMainPanel uyeEkrani = new UserMainPanel(girisYapanUye);
                      // uyeEkrani.setVisible(true);  
                    } catch (Exception e) {
                        System.out.println("Üye bilgileri alınırken bir hata oluştu: " + e.getMessage());
                    }
                    break;
                case "trainer":
                    System.out.println("Redirecting to trainer panel.");
                    break;
                case "staff":
                    System.out.println("Redirecting to staff panel.");
                    break;      
            }
        }else{
            System.out.println("Invalid Login!");
        } 
    }
}
