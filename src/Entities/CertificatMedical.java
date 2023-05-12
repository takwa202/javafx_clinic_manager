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
public class CertificatMedical {
    private int idCertif;
    private Patient2 patient ; 
    private String type_certif;
    private String designation ; 

    public CertificatMedical() {
    }

    public CertificatMedical(int idCertif, Patient2 patient, String type_certif, String designation) {
        this.idCertif = idCertif;
        this.patient = patient;
        this.type_certif = type_certif;
        this.designation = designation;
    }

    public CertificatMedical(Patient2 patient, String type_certif, String designation) {
        this.patient = patient;
        this.type_certif = type_certif;
        this.designation = designation;
    }

    public int getIdCertif() {
        return idCertif;
    }

    public void setIdCertif(int idCertif) {
        this.idCertif = idCertif;
    }

    public Patient2 getPatient() {
        return patient;
    }

    public void setPatient(Patient2 patient) {
        this.patient = patient;
    }

    public String getType_certif() {
        return type_certif;
    }

    public void setType_certif(String type_certif) {
        this.type_certif = type_certif;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "CertificatMedical{" + "idCertif=" + idCertif + ", patient=" + patient + ", type_certif=" + type_certif + ", designation=" + designation + '}';
    }
    
    
    
    
    
    
}
