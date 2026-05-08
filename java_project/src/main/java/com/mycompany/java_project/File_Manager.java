/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;
import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class File_Manager {
    Gson gson = new GsonBuilder()
    .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
        @Override
        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.toString()); // JSON'a "2026-05-09" olarak yazar
        }
    })
    .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
        @Override
        public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsString()); // JSON'dan okurken tekrar objeye çevirir
        }
    })
    .create();
    
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
     public List<User> readUsers(String fileName) {
        List<User> userList = new ArrayList<>();
        java.io.File file = new java.io.File(fileName);
        if (!file.exists()) return userList; 

        try (FileReader reader = new FileReader(file);
             Scanner scan = new Scanner(reader)) {
            
            while (scan.hasNextLine()) {
                String json = scan.nextLine();
                if (json.trim().isEmpty()) continue;

                JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
                // BURASI DÜZELTİLDİ: user.getRole() yerine obj'den gelen role bakıyoruz
                String role = obj.get("role").getAsString(); 
                User user = null;

                switch (role.toLowerCase()) {
                    case "member":
                        user = gson.fromJson(json, Member.class);
                        break;
                    case "trainer":
                        user = gson.fromJson(json, Trainer.class);
                        break;
                    case "admin":
                        user = gson.fromJson(json, Admin.class);
                        break;
                    case "staff":
                        user = gson.fromJson(json, Staff.class);
                        break;
                }
                if (user != null) userList.add(user);
            }
        } catch (Exception e) {
            System.out.println("Okuma Hatası: " + e.getMessage());
        }
        return userList;
    }
     
    //json güncelleme
    public void writeAllUsers(String fileName, List<User> userList){
        try {
            //false parametresi dosyayı boşsaltır ve baştan yazar
            FileWriter writer=new FileWriter(fileName,false);
           
            for(User u:userList){
                String json=gson.toJson(u);//tekrardan silinen hariç her şeyi json formatına dönüştür
                writer.write(json+"\n"); //dosayaya yaz ve aalt satıra geç
            }
            writer.close();
            System.out.println("File updated successfully!");
        }catch(Exception e){
            System.out.println("Update Error:"+e.getMessage());
        }
    }
}
