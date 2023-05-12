/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Timestamp;

/**
 *
 * @author HP
 */
public class LettreConfidentielle {
    private int idConf;
    private Timestamp date ;
    private int idMed ;
    private Medecin medcin ;
    private String description ;
    private String signature ;
    private int id_ordonnance ;
    private Ordonnance ordonnance ;
    private String nomPrenomPatient;

    public LettreConfidentielle(int idConf, Timestamp date, String description, String signature, int id_ordonnance, Ordonnance ordonnance) {
        this.idConf = idConf;
        this.date = date;
        this.description = description;
        this.signature = signature;
        this.id_ordonnance = id_ordonnance;
        this.ordonnance = ordonnance;
    }
    

    public LettreConfidentielle() {
    }
//
    public LettreConfidentielle(int idConf, Timestamp date, String description, String signature, int id_ordonnance, Ordonnance ordonnance, String nomPrenomPatient) {
        this.idConf = idConf;
        this.date = date;
        this.description = description;
        this.signature = signature;
        this.id_ordonnance = id_ordonnance;
        this.ordonnance = ordonnance;
        this.nomPrenomPatient = nomPrenomPatient;
    }
    
    
    

    public LettreConfidentielle(int idConf, Timestamp date, Medecin medcin, String description, String signature, Ordonnance ordonnance) {
        this.idConf = idConf;
        this.date = date;
        this.medcin = medcin;
        this.description = description;
        this.signature = signature;
        this.ordonnance = ordonnance;
    }
    

    public LettreConfidentielle(Timestamp date, int idMed, String description, String signature, int id_ordonnance) {
        this.date = date;
        this.idMed = idMed;
        this.description = description;
        this.signature = signature;
        this.id_ordonnance = id_ordonnance;
    }

    public LettreConfidentielle(Timestamp date, int idMed, Medecin medcin, String description, int id_ordonnance, Ordonnance ordonnance) {
        this.date = date;
        this.idMed = idMed;
        this.medcin = medcin;
        this.description = description;
        this.id_ordonnance = id_ordonnance;
        this.ordonnance = ordonnance;
    }

    public LettreConfidentielle(Timestamp date, Medecin medcin, String description, String signature, Ordonnance ordonnance) {
        this.date = date;
        this.medcin = medcin;
        this.description = description;
        this.signature = signature;
        this.ordonnance = ordonnance;
    }

    public LettreConfidentielle(Timestamp date, int idMed, Medecin medcin, String description, String signature, int id_ordonnance, Ordonnance ordonnance) {
        this.date = date;
        this.idMed = idMed;
        this.medcin = medcin;
        this.description = description;
        this.signature = signature;
        this.id_ordonnance = id_ordonnance;
        this.ordonnance = ordonnance;
    }

    public LettreConfidentielle(int idConf, Timestamp date, int idMed, Medecin medcin, String description, String signature, int id_ordonnance, Ordonnance ordonnance) {
        this.idConf = idConf;
        this.date = date;
        this.idMed = idMed;
        this.medcin = medcin;
        this.description = description;
        this.signature = signature;
        this.id_ordonnance = id_ordonnance;
        this.ordonnance = ordonnance;
    }

    public LettreConfidentielle(int idConf, Timestamp date, int idMed, String description, String signature, int id_ordonnance) {
        this.idConf = idConf;
        this.date = date;
        this.idMed = idMed;
        this.description = description;
        this.signature = signature;
        this.id_ordonnance = id_ordonnance;
    }

    public LettreConfidentielle(String date, int parseInt, String description, String signature, int parseInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LettreConfidentielle(int idConf, Timestamp date, String description, String signature, Ordonnance ordonnance, int id_ordonnance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public int getIdConf() {
        return idConf;
    }

    public void setIdConf(int idConf) {
        this.idConf = idConf;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }

    public Medecin getMedcin() {
        return medcin;
    }

    public void setMedcin(Medecin medcin) {
        this.medcin = medcin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getId_ordonnance() {
        return id_ordonnance;
    }

    public void setId_ordonnance(int id_ordonnance) {
        this.id_ordonnance = id_ordonnance;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    @Override
    public String toString() {
        return "LettreConfidentielle{" + "idConf=" + idConf + ", date=" + date + ", idMed=" + idMed + ", medcin=" + medcin + ", description=" + description + ", signature=" + signature + ", id_ordonnance=" + id_ordonnance + ", ordonnance=" + ordonnance + '}';
    }
    
    
    
}
