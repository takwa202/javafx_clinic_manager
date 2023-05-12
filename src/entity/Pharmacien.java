/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author lenovo
 */
public class Pharmacien {

    private int Id_Pharmacien;
    private String nom_Pharmacien;
    private String Prenom_Pharmacien;
    private String Adress_Pharmacien;
    private int NumTel_Pharmacien;
    private String MotDePasse_Pharmacien;
    private String Email_Pharmacien;
    private int Blockfarm;
    private String picturePharm;
    private int nbrReclamation;

    public Pharmacien(String nom_Pharmacien, String Prenom_Pharmacien, String Adress_Pharmacien, int NumTel_Pharmacien, String MotDePasse_Pharmacien, String Email_Pharmacien, int Blockfarm, String picturePharm, int nbrReclamation) {
        this.nom_Pharmacien = nom_Pharmacien;
        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;
        this.picturePharm = picturePharm;
        this.nbrReclamation = nbrReclamation;
    }

    public Pharmacien() {
    }

    public Pharmacien(int Id_Pharmacien, String nom_Pharmacien, String Prenom_Pharmacien, String Adress_Pharmacien, int NumTel_Pharmacien, String Email_Pharmacien, int Blockfarm) {
        this.Id_Pharmacien = Id_Pharmacien;
        this.nom_Pharmacien = nom_Pharmacien;
        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;
    }

    public Pharmacien(String nom_Pharmacien, String Prenom_Pharmacien, String Adress_Pharmacien, int NumTel_Pharmacien, String MotDePasse_Pharmacien, String Email_Pharmacien, int Blockfarm, String picturePharm) {
        this.nom_Pharmacien = nom_Pharmacien;
        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;
        this.picturePharm = picturePharm;
    }

    public Pharmacien(int Id_Pharmacien, String nom_Pharmacien, String Prenom_Pharmacien, String Adress_Pharmacien, int NumTel_Pharmacien, String MotDePasse_Pharmacien, String Email_Pharmacien, int Blockfarm, String picturePharm, int nbrReclamation) {
        this.Id_Pharmacien = Id_Pharmacien;
        this.nom_Pharmacien = nom_Pharmacien;
        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;
        this.picturePharm = picturePharm;
        this.nbrReclamation = nbrReclamation;
    }

    public Pharmacien(int Id_Pharmacien, String nom_Pharmacien, String Prenom_Pharmacien, String Adress_Pharmacien, int NumTel_Pharmacien, String MotDePasse_Pharmacien, String Email_Pharmacien, int Blockfarm, String picturePharm) {
        this.Id_Pharmacien = Id_Pharmacien;
        this.nom_Pharmacien = nom_Pharmacien;
        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;
        this.picturePharm = picturePharm;
    }

    public String getPicturePharm() {
        return picturePharm;
    }

    public void setPicturePharm(String picturePharm) {
        this.picturePharm = picturePharm;
    }

    public Pharmacien(
            int Id_Pharmacien,
            String nom_Pharmacien,
            String Prenom_Pharmacien,
            String Adress_Pharmacien,
            int NumTel_Pharmacien,
            String MotDePasse_Pharmacien,
            String Email_Pharmacien,
            int Blockfarm) {
        this.Id_Pharmacien = Id_Pharmacien;
        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.nom_Pharmacien = nom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;

    }

    // constructor without id
    public Pharmacien(
            String nom_Pharmacien,
            String Prenom_Pharmacien,
            String Adress_Pharmacien,
            int NumTel_Pharmacien,
            String MotDePasse_Pharmacien,
            String Email_Pharmacien,
            int Blockfarm) {

        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.nom_Pharmacien = nom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;

    }

    public Pharmacien(String nom_Pharmacien, String Prenom_Pharmacien, String Adress_Pharmacien, int NumTel_Pharmacien, String MotDePasse_Pharmacien, String Email_Pharmacien, int Blockfarm, int nbrReclamation, String picturePharm) {
        this.nom_Pharmacien = nom_Pharmacien;
        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;
        this.nbrReclamation = nbrReclamation;
        this.picturePharm = picturePharm;
    }

    public Pharmacien(int Id_Pharmacien, String nom_Pharmacien, String Prenom_Pharmacien, String Adress_Pharmacien, int NumTel_Pharmacien, String MotDePasse_Pharmacien, String Email_Pharmacien, int Blockfarm, int nbrReclamation, String picturePharm) {
        this.Id_Pharmacien = Id_Pharmacien;
        this.nom_Pharmacien = nom_Pharmacien;
        this.Prenom_Pharmacien = Prenom_Pharmacien;
        this.Adress_Pharmacien = Adress_Pharmacien;
        this.NumTel_Pharmacien = NumTel_Pharmacien;
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
        this.Email_Pharmacien = Email_Pharmacien;
        this.Blockfarm = Blockfarm;
        this.nbrReclamation = nbrReclamation;
        this.picturePharm = picturePharm;
    }

    public int getId_Pharmacien() {
        return Id_Pharmacien;
    }

    public void setId_Pharmacien(int Id_Pharmacien) {
        this.Id_Pharmacien = Id_Pharmacien;
    }

    public String getNom_Pharmacien() {
        return nom_Pharmacien;
    }

    public void setNom_Pharmacien(String nom_Pharmacien) {
        this.nom_Pharmacien = nom_Pharmacien;
    }

    public String getPrenom_Pharmacien() {
        return Prenom_Pharmacien;
    }

    public void setPrenom_Pharmacien(String Prenom_Pharmacien) {
        this.Prenom_Pharmacien = Prenom_Pharmacien;
    }

    public String getAdress_Pharmacien() {
        return Adress_Pharmacien;
    }

    public void setAdress_Pharmacien(String Adress_Pharmacien) {
        this.Adress_Pharmacien = Adress_Pharmacien;
    }

    public int getNumTel_Pharmacien() {
        return NumTel_Pharmacien;
    }

    public void setNumTel_Pharmacien(int NumTel_Pharmacien) {
        this.NumTel_Pharmacien = NumTel_Pharmacien;
    }

    public String getMotDePasse_Pharmacien() {
        return MotDePasse_Pharmacien;
    }

    public void setMotDePasse_Pharmacien(String MotDePasse_Pharmacien) {
        this.MotDePasse_Pharmacien = MotDePasse_Pharmacien;
    }

    public String getEmail_Pharmacien() {
        return Email_Pharmacien;
    }

    public void setEmail_Pharmacien(String Email_Pharmacien) {
        this.Email_Pharmacien = Email_Pharmacien;
    }

    public int getBlockfarm() {
        return Blockfarm;
    }

    public void setBlockfarm(int Blockfarm) {
        this.Blockfarm = Blockfarm;
    }

    public int getNbrReclamation() {
        return nbrReclamation;
    }

    public void setNbrReclamation(int nbrReclamation) {
        this.nbrReclamation = nbrReclamation;
    }

    @Override
    public String toString() {
        return "Pharmacien{" + "Id_Pharmacien=" + Id_Pharmacien + ", nom_Pharmacien=" + nom_Pharmacien + ", Prenom_Pharmacien=" + Prenom_Pharmacien + ", Adress_Pharmacien=" + Adress_Pharmacien + ", NumTel_Pharmacien=" + NumTel_Pharmacien + ", MotDePasse_Pharmacien=" + MotDePasse_Pharmacien + ", Email_Pharmacien=" + Email_Pharmacien + ", Blockfarm=" + Blockfarm + '}';
    }

}
