/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author lenovo
 */
public class Medcin {

    private int id_med;
    private String mdp_med;
    private String email_med;
    private Timestamp date_naissance_med;
    private int age_med;
    private String adresse_med;
    private String genre_med;
    private String nom_med;
    private String prenom_med;
    private int num_tel_med;
    private String photo_med;
    private String photo_dip;
    private int nb_rec_med;
    private int nb_patient;
    private int is_Blocked;
     private String speciatilte;
    


    public Medcin(int id_med, String email_med, int age_med, String adresse_med, String genre_med, String nom_med, String prenom_med, int num_tel_med, int nb_rec_med, int is_Blocked) {
        this.id_med = id_med;
        //this.mdp_med = mdp_med;
        this.email_med = email_med;
        this.age_med = age_med;
        this.adresse_med = adresse_med;
        this.genre_med = genre_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.num_tel_med = num_tel_med;
        this.nb_rec_med = nb_rec_med;
        this.is_Blocked = is_Blocked;
    }

    public Medcin(int id_med, String mdp_med, String email_med, Timestamp date_naissance_med, int age_med, String adresse_med, String genre_med, String nom_med, String prenom_med, int num_tel_med, String photo_med, String speciatilte) {
        this.id_med = id_med;
        this.mdp_med = mdp_med;
        this.email_med = email_med;
        this.date_naissance_med = date_naissance_med;
        this.age_med = age_med;
        this.adresse_med = adresse_med;
        this.genre_med = genre_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.num_tel_med = num_tel_med;
        this.photo_med = photo_med;
        this.speciatilte = speciatilte;
    }
     

    public Medcin(int id_med, int age_med, String adresse_med, String nom_med, String prenom_med) {
        this.id_med = id_med;
        this.age_med = age_med;
        this.adresse_med = adresse_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
    }
     

    public String getSpeciatilte() {
        return speciatilte;
    }

    public void setSpeciatilte(String speciatilte) {
        this.speciatilte = speciatilte;
    }

    public String getPhoto_dip() {
        return photo_dip;
    }

    public void setPhoto_dip(String photo_dip) {
        this.photo_dip = photo_dip;
    }

 //hetha all data constructor
         //(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getTimestamp(4),rs.getInt(5),rs.getString(6),rs.getString(7),  rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11), rs.getString(12), rs.getInt(13),rs.getInt(14)),rs.getBoolean(15),rs.getString(16));

    public Medcin() {
    }

    public Medcin(int id_med, String mdp_med, String email_med, Timestamp date_naissance_med, int age_med, String adresse_med, String genre_med, String nom_med, String prenom_med, int num_tel_med, String photo_med, String photo_dip, int nb_rec_med, int nb_patient, int is_Blocked, String spéciatilte) {
        this.id_med = id_med;
        this.mdp_med = mdp_med;
        this.email_med = email_med;
        this.date_naissance_med = date_naissance_med;
        this.age_med = age_med;
        this.adresse_med = adresse_med;
        this.genre_med = genre_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.num_tel_med = num_tel_med;
        this.photo_med = photo_med;
        this.photo_dip = photo_dip;
        this.nb_rec_med = nb_rec_med;
        this.nb_patient = nb_patient;
        this.is_Blocked = is_Blocked;
        this.speciatilte=speciatilte;
    }

   //  Medcin("mot de pass","email",date,"adree","male","ali","prenommed",555555,"photomed","specialier")
  // Medcin("mot de pass","email",11,"adree","male","ali","prenommed",555555,"photomed","specialier");
      /// hethi pour without the date
      public Medcin( String mdp_med, String email_med, Timestamp date_naissance_med, int age_med, String adresse_med, String genre_med, String nom_med, String prenom_med, int num_tel_med, String photo_med,String spéciatilte) {
       
        this.mdp_med = mdp_med;
        this.email_med = email_med;
      this.date_naissance_med = date_naissance_med;
        this.age_med = age_med;
        this.adresse_med = adresse_med;
        this.genre_med = genre_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.num_tel_med = num_tel_med;
        this.photo_med = photo_med;
           this.speciatilte=speciatilte;
        // this.nb_rec_med = nb_rec_med;
        // this.nb_patient = nb_patient;
        // this.is_Blocked = is_Blocked;

    }
//hetha pour blocker
    public Medcin(int is_Blocked) {
        /*  this.is_Blocked = is_Blocked;
         this.mdp_med = mdp_med;
         this.email_med = email_med;
         this.date_naissance_med = date_naissance_med;
         this.age_med = age_med;
         this.adresse_med = adresse_med;
         this.genre_med = genre_med;
         this.nom_med = nom_med;
         this.prenom_med = prenom_med;
         this.num_tel_med = num_tel_med;
         this.photo_med = photo_med;*/
        // this.nb_rec_med = nb_rec_med;
        // this.nb_patient = nb_patient;
        this.is_Blocked = is_Blocked;

    }

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    public String getMdp_med() {
        return mdp_med;
    }

    public void setMdp_med(String mdp_med) {
        this.mdp_med = mdp_med;
    }

    public String getEmail_med() {
        return email_med;
    }

    public void setEmail_med(String email_med) {
        this.email_med = email_med;
    }

    public Timestamp getDate_naissance_med() {
        return date_naissance_med;
    }

    public void setDate_naissance_med(Timestamp date_naissance_med) {
        this.date_naissance_med = date_naissance_med;
    }

    public int getAge_med() {
        return age_med;
    }

    public void setAge_med(int age_med) {
        this.age_med = age_med;
    }

    public String getAdresse_med() {
        return adresse_med;
    }

    public void setAdresse_med(String adresse_med) {
        this.adresse_med = adresse_med;
    }

    public String getGenre_med() {
        return genre_med;
    }

    public void setGenre_med(String genre_med) {
        this.genre_med = genre_med;
    }

    public String getNom_med() {
        return nom_med;
    }

    public void setNom_med(String nom_med) {
        this.nom_med = nom_med;
    }

    public String getPrenom_med() {
        return prenom_med;
    }

    public void setPrenom_med(String prenom_med) {
        this.prenom_med = prenom_med;
    }

    public int getNum_tel_med() {
        return num_tel_med;
    }

    public void setNum_tel_med(int num_tel_med) {
        this.num_tel_med = num_tel_med;
    }

    public String getPhoto_med() {
        return photo_med;
    }

    @Override
    public String toString() {
        return "Medcin{" + "id_med=" + id_med + ", mdp_med=" + mdp_med + ", email_med=" + email_med + ", date_naissance_med=" + date_naissance_med + ", age_med=" + age_med + ", adresse_med=" + adresse_med + ", genre_med=" + genre_med + ", nom_med=" + nom_med + ", prenom_med=" + prenom_med + ", num_tel_med=" + num_tel_med + ", photo_med=" + photo_med + ", photo_dip=" + photo_dip + ", nb_rec_med=" + nb_rec_med + ", nb_patient=" + nb_patient + ", is_Blocked=" + is_Blocked + ", speciatilte=" + speciatilte + '}';
    }

    public void setPhoto_med(String photo_med) {
        this.photo_med = photo_med;
    }

    public int getNb_rec_med() {
        return nb_rec_med;
    }

    public void setNb_rec_med(int nb_rec_med) {
        this.nb_rec_med = nb_rec_med;
    }

    public int getNb_patient() {
        return nb_patient;
    }

    public void setNb_patient(int nb_patient) {
        this.nb_patient = nb_patient;
    }

    public int getIs_Blocked() {
        return is_Blocked;
    }

    public void setIs_Blocked(int is_Blocked) {
        this.is_Blocked = is_Blocked;
    }

    
}
