/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author HP
 */
public class Medecin {
     private int id_med;
    private String nom_med; 
    private String prenom_med;

    public Medecin() {
    }
    
    
    public Medecin(int id_med, String nom_med, String prenom_med) {
        this.id_med = id_med;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
    }

    public Medecin(String nom_med, String prenom_med) {
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
    }

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
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

    @Override
    public String toString() {
        return "Medecin{" + "id_med=" + id_med + ", nom_med=" + nom_med + ", prenom_med=" + prenom_med + '}';
    }
    
    
    
    
}
