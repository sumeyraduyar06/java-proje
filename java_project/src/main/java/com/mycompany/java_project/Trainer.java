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


public class Trainer extends Staff {
    private String branch;
    private List<Member> assignedMembers;

    // Constructor
    public Trainer(String ID, String name, String surname, String password, String role, 
                   double salary, String entryhour, String exithour, String hour, String branch) {
        super(ID, name, surname, password, role, salary, entryhour, exithour, hour);
        
        this.branch = branch;
        this.assignedMembers = new ArrayList<>();
        

    }

    // Get ve Set metotları
    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Member> getAssignedMembers() {
        return assignedMembers;
    }

    // Kapasite Kontrolü (Max 5 Üye)
    public boolean assignedMember(Member member) {
        if (assignedMembers.size() < 5) {
            assignedMembers.add(member);
            return true;
        } else {
            return false;
        }
    }

    // Branş Kontrolü
    public void leadClass(Member member, String requestedBranch) {
        // Üye kontrolü
        if (!this.assignedMembers.contains(member)) {
            throw new IllegalArgumentException("Hata: Eğitmen bu üyeye atanmamış.");
        } 
        // Branş kontrolü
        if (!this.branch.equalsIgnoreCase(requestedBranch)) {
            throw new IllegalArgumentException("Hata: Eğitmenin branşı (" + this.branch + ") istenen branşla (" + requestedBranch + ") uyuşmuyor.");
        }
        
        System.out.println(member.getName() + " için " + requestedBranch + " dersi başlatıldı.");
    }
}