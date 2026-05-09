/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.java_project;
//import com.google.gson.Gson;

/**
 *
 * @author ASUS
 */

public class Java_project {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            // Programı LoginPanel ile başlat
            new LoginPanel().setVisible(true);
        });
        
        System.out.println("VIGOR Health & Wellness System is running...");
    }
}