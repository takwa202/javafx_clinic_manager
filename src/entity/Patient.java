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
public class Patient {

    private int Id_patient;
    private String Nom_patient;
    private String Prenom_patient;

   
    private String Email_patient;
    private String Adress_patient;
    private int NumTel_patient;
    private String MotDePassel_patient;
    private int Age_patient;
    private String Gendre_patient;
    private int Nb_Rdv;
    private int Nb_Achat;
    private int Nb_Reclamation;
    private int isblokedpatient;
     private String image;

    public Patient(
            int Id_patient,
            String Nom_patient,
            String Prenom_patient,
            String Email_patient,
            String Adress_patient,
            int NumTel_patient,
            String MotDePassel_patient,
            int Age_patient,
            String Gendre_patient,
            int Nb_Rdv,
            int Nb_Achat,
            int Nb_Reclamation,
            int isblokedpatient,
            String image
            
    ) {
        this.Id_patient = Id_patient;
        this.Nom_patient = Nom_patient;
        this.Prenom_patient = Prenom_patient;
        this.Email_patient = Email_patient;
        this.Adress_patient = Adress_patient;
        this.NumTel_patient = NumTel_patient;
        this.MotDePassel_patient = MotDePassel_patient;
        this.Age_patient = Age_patient;
        this.Gendre_patient = Gendre_patient;
        this.Nb_Rdv = Nb_Rdv;
        this.Nb_Achat = Nb_Achat;
        this.Nb_Reclamation = Nb_Reclamation;
        this.isblokedpatient = isblokedpatient;
        this.image = image;
      
    }

    public Patient(String Nom_patient) {
        this.Nom_patient = Nom_patient;
    }
 public Patient() {
    }
     //  rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  
                //   rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8),rs.getString(9),rs.getInt(10)

    public Patient(int Id_patient, String Nom_patient, String Prenom_patient, String Email_patient, String Adress_patient, int NumTel_patient, String MotDePassel_patient, int Age_patient, String Gendre_patient, int isblokedpatient,String image) {
        this.Id_patient = Id_patient;
        this.Nom_patient = Nom_patient;
        this.Prenom_patient = Prenom_patient;
        this.Email_patient = Email_patient;
        this.Adress_patient = Adress_patient;
        this.NumTel_patient = NumTel_patient;
        this.MotDePassel_patient = MotDePassel_patient;
        this.Age_patient = Age_patient;
        this.Gendre_patient = Gendre_patient;
        this.isblokedpatient = isblokedpatient;
        this.image = image;    }

    public Patient(String Nom_patient, String Prenom_patient, String Email_patient,
            String Adress_patient, int NumTel_patient, String MotDePassel_patient,
            int Age_patient, String Gendre_patient, int isblokedpatient,String image) {
        this.Nom_patient = Nom_patient;
        this.Prenom_patient = Prenom_patient;
        this.Email_patient = Email_patient;
        this.Adress_patient = Adress_patient;
        this.NumTel_patient = NumTel_patient;
        this.MotDePassel_patient = MotDePassel_patient;
        this.Age_patient = Age_patient;
        this.Gendre_patient = Gendre_patient;
        this.isblokedpatient = isblokedpatient;
                this.image = image;
    }

    public Patient(String Nom_patient, String Prenom_patient, String Email_patient, String Adress_patient, int NumTel_patient, String MotDePassel_patient, int Age_patient, String Gendre_patient, int Nb_Rdv, int Nb_Achat, int Nb_Reclamation, int isblokedpatient,String image) {
        this.Nom_patient = Nom_patient;
        this.Prenom_patient = Prenom_patient;
        this.Email_patient = Email_patient;
        this.Adress_patient = Adress_patient;
        this.NumTel_patient = NumTel_patient;
        this.MotDePassel_patient = MotDePassel_patient;
        this.Age_patient = Age_patient;
        this.Gendre_patient = Gendre_patient;
        this.Nb_Rdv = Nb_Rdv;
        this.Nb_Achat = Nb_Achat;
        this.Nb_Reclamation = Nb_Reclamation;
        this.isblokedpatient = isblokedpatient;
                this.image = image;
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

    public String getPrenom_patient() {
        return Prenom_patient;
    }

    public void setPrenom_patient(String Prenom_patient) {
        this.Prenom_patient = Prenom_patient;
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

    public String getMotDePassel_patient() {
        return MotDePassel_patient;
    }

    public void setMotDePassel_patient(String MotDePassel_patient) {
        this.MotDePassel_patient = MotDePassel_patient;
    }

    public int getAge_patient() {
        return Age_patient;
    }

    public void setAge_patient(int Age_patient) {
        this.Age_patient = Age_patient;
    }

    public String getGendre_patient() {
        return Gendre_patient;
    }

    public void setGendre_patient(String Gendre_patient) {
        this.Gendre_patient = Gendre_patient;
    }

    public int getNb_Rdv() {
        return Nb_Rdv;
    }

    public void setNb_Rdv(int Nb_Rdv) {
        this.Nb_Rdv = Nb_Rdv;
    }

    public int getNb_Achat() {
        return Nb_Achat;
    }

    public void setNb_Achat(int Nb_Achat) {
        this.Nb_Achat = Nb_Achat;
    }

    public int getNb_Reclamation() {
        return Nb_Reclamation;
    }

    public void setNb_Reclamation(int Nb_Reclamation) {
        this.Nb_Reclamation = Nb_Reclamation;
    }

    @Override
    public String toString() {
        return "Patient{" + "Id_patient=" + Id_patient + ", Nom_patient=" + Nom_patient + ", Pr\u00e9nom_patient=" + Prenom_patient + ", Email_patient=" + Email_patient + ", Adress_patient=" + Adress_patient + ", NumTel_patient=" + NumTel_patient + ", MotDePassel_patient=" + MotDePassel_patient + ", Age_patient=" + Age_patient + ", Gendre_patient=" + Gendre_patient + ", Nb_Rdv=" + Nb_Rdv + ", Nb_Achat=" + Nb_Achat + ", Nb_Reclamation=" + Nb_Reclamation + ", isblokedpatient=" + isblokedpatient +", image="+image+ '}';
    }

    public int getIsblokedpatient() {
        return isblokedpatient;
    }

    public void setIsblokedpatient(int isblokedpatient) {
        this.isblokedpatient = isblokedpatient;
        
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

}
