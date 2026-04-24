/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class File_Manager {
    Gson gson=new Gson();
    
    //json yazma
    public void saveUser(String fileName,User user){
        try{
            FileWriter writer=new FileWriter(fileName,true);
            String json=gson.toJson(user);
            writer.write(json+ "\n");
            writer.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    //json okuma
    public void readUsers(String fileName){
        try{
            FileReader reader=new FileReader(fileName);
            Scanner scan=new Scanner(reader);
            
            while(scan.hasNextLine()){
                String json=scan.nextLine();
                User user=gson.fromJson(json, User.class);
                System.out.println(user.getName()+"-"+user.getRole());
            }
            scan.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
