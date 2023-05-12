/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author marie
 */
public class Patient {
    private int Id_patient ;
    private String Nom_patient;
    private String Prénom_patient;
    private String Email_patient;
    private String Adress_patient;
    private int NumTel_patient;
    private int Age_patient;

    public Patient() {
    }

    public Patient(int Id_patient, String Nom_patient, String Prénom_patient, String Email_patient, String Adress_patient, int NumTel_patient, int Age_patient) {
        this.Id_patient = Id_patient;
        this.Nom_patient = Nom_patient;
        this.Prénom_patient = Prénom_patient;
        this.Email_patient = Email_patient;
        this.Adress_patient = Adress_patient;
        this.NumTel_patient = NumTel_patient;
        this.Age_patient = Age_patient;
    }

    public Patient(String Nom_patient, String Prénom_patient, String Email_patient, String Adress_patient, int NumTel_patient, int Age_patient) {
        this.Nom_patient = Nom_patient;
        this.Prénom_patient = Prénom_patient;
        this.Email_patient = Email_patient;
        this.Adress_patient = Adress_patient;
        this.NumTel_patient = NumTel_patient;
        this.Age_patient = Age_patient;
    }

    public int getId_patient() {
        return Id_patient;
    }

    public void setId_patient(int Id_patient) {
        this.Id_patient = Id_patient;
    }

    public String getNom_patient() {
        return Nom_patient;
    }

    public void setNom_patient(String Nom_patient) {
        this.Nom_patient = Nom_patient;
    }

    public String getPrénom_patient() {
        return Prénom_patient;
    }

    public void setPrénom_patient(String Prénom_patient) {
        this.Prénom_patient = Prénom_patient;
    }

    public String getEmail_patient() {
        return Email_patient;
    }

    public void setEmail_patient(String Email_patient) {
        this.Email_patient = Email_patient;
    }

    public String getAdress_patient() {
        return Adress_patient;
    }

    public void setAdress_patient(String Adress_patient) {
        this.Adress_patient = Adress_patient;
    }

    public int getNumTel_patient() {
        return NumTel_patient;
    }

    public void setNumTel_patient(int NumTel_patient) {
        this.NumTel_patient = NumTel_patient;
    }

    public int getAge_patient() {
        return Age_patient;
    }

    public void setAge_patient(int Age_patient) {
        this.Age_patient = Age_patient;
    }

    @Override
    public String toString() {
        return "Patient{" + "Id_patient=" + Id_patient + ", Nom_patient=" + Nom_patient + ", Prénom_patient=" + Prénom_patient + ", Email_patient=" + Email_patient + ", Adress_patient=" + Adress_patient + ", NumTel_patient=" + NumTel_patient + ", Age_patient=" + Age_patient + '}';
    }

    
    
    
    
}
