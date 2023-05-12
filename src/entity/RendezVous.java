/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Symptome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

/**
 *
 * @author noura
 */
public class RendezVous {
    
    private int id_rd;
    private Date date_rd;
    private int heure_rd;
    private long jour_restant;
    private int id_patient;
    private Medcin medecin;
    private Symptome symptome;
    private String nom_med;
    private String prenom_med;
    private String specialite_med;
    Button modifier;
      

    public RendezVous() {
    }

    public RendezVous(Date date_rd, int heure_rd, long jour_restant, String nom_med, String prenom_med, String specialite_med,Button modifier) {
        this.date_rd = date_rd;
        this.heure_rd = heure_rd;       
        this.jour_restant = jour_restant;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.specialite_med = specialite_med;
        this.modifier=modifier;
    }
    
    public RendezVous(Date date_rd, int heure_rd, long jour_restant, String nom_med, String prenom_med, String specialite_med) {
        this.date_rd = date_rd;
        this.heure_rd = heure_rd;       
        this.jour_restant = jour_restant;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.specialite_med = specialite_med;
        
    }
    
    

    public RendezVous(Date date_rd, int heure_rd, int id_patient, Medcin medecin, Symptome symptome, String nom_med, String prenom_med, String specialite_med) {
        this.date_rd = date_rd;
        this.heure_rd = heure_rd;
        this.id_patient = id_patient;
        this.medecin = medecin;
        this.symptome = symptome;
        this.nom_med = nom_med;
        this.prenom_med = prenom_med;
        this.specialite_med = specialite_med;
    }

    public RendezVous(Date date_rd, int heure_rd, int id_patient, Medcin medecin , Symptome symptome) {
        this.date_rd = date_rd;
        this.heure_rd = heure_rd;
        this.id_patient = id_patient;
        this.medecin = medecin;
        this.symptome = symptome;
        
        
        /*try {
           
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.FRANCE);
            
            LocalDateTime now = LocalDateTime.now();
            //changer 
            Date firstDate = (Date) sdf.parse(sdf.format(date_rd));
            Date secondDate = (Date) sdf.parse(sdf.format(now));

            long diff = secondDate.getTime() - firstDate.getTime();
            
            TimeUnit time = TimeUnit.DAYS;
            long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
            
            this.jour_restant = diffrence ;
           
        } catch (ParseException ex) { 
            
            System.err.println(ex.getMessage());        
        }*/
        
        
        
        
    }
    public int calculerJourRestant(Date date_rd){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();
        //int jr = now.getDay();
        int y = now.getYear();
        //int m = now.getMonth();
        
        
        
        return 5;
    }    
    

    public RendezVous(int id_rd, Date date_rd, int heure_rd, int id_patient ,Medcin med,Symptome sym) {
        
        this.id_rd = id_rd;
        this.date_rd = date_rd;
        this.heure_rd = heure_rd;
        
        /*try {
           
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.FRANCE);
            
            LocalDateTime now = LocalDateTime.now();
            Date firstDate = (Date) sdf.parse(sdf.format(date_rd));
            Date secondDate = (Date) sdf.parse(sdf.format(now));
            
            long diff = secondDate.getTime() - firstDate.getTime();
            
            TimeUnit time = TimeUnit.DAYS;
            long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
            
            this.jour_restant = diffrence ;
           
        } catch (ParseException ex) { 
            
            System.err.println(ex.getMessage());        
        }*/
        
        this.medecin = med;
        this.id_patient = id_patient;
        this.symptome = symptome;
        
    }

    public RendezVous(Date date_rd, int heure_rd, int id_patient, Medcin med) {       
        this.date_rd = date_rd;
        this.heure_rd = heure_rd;
        this.id_patient = id_patient;
        this.medecin = med ;
        
        /*try {
           
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.FRANCE);
            
            LocalDateTime now = LocalDateTime.now();
            Date firstDate = (Date) sdf.parse(sdf.format(date_rd));
            Date secondDate = (Date) sdf.parse(sdf.format(now));
            
            long diff = secondDate.getTime() - firstDate.getTime();
            
            TimeUnit time = TimeUnit.DAYS;
            long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
            
            this.jour_restant = diffrence ;
           
        } catch (ParseException ex) { 
            
            System.err.println(ex.getMessage());        
        }*/
        
    }
    
    public RendezVous(Date date_rd, int heure_rd) {
        this.date_rd = date_rd;
        this.heure_rd = heure_rd;
        
        /*try {
           
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.FRANCE);
            
            LocalDateTime now = LocalDateTime.now();
            Date firstDate = (Date) sdf.parse(sdf.format(date_rd));
            Date secondDate = (Date) sdf.parse(sdf.format(now));
            
            long diff = secondDate.getTime() - firstDate.getTime();
            
            TimeUnit time = TimeUnit.DAYS;
            long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
            
            this.jour_restant = diffrence ;
           
        } catch (ParseException ex) { 
            
            System.err.println(ex.getMessage());        
        }*/
    }
    

    public Symptome getSymptome() {
        return symptome;
    }

    public void setSymptome(Symptome symptome) {
        this.symptome = symptome;
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

    public String getSpecialite_med() {
        return specialite_med;
    }

    public void setSpecialite_med(String specialite_med) {
        this.specialite_med = specialite_med;
    }


    

    public int getId_rd() {
        return id_rd;
    }

    public void setId_rd(int id_rd) {
        this.id_rd = id_rd;
    }

    public Date getDate_rd() {
        return date_rd;
    }

    public void setDate_rd(Date date_rd) {
        this.date_rd = date_rd;
    }

    public int getHeure_rd() {
        return heure_rd;
    }

    public void setHeure_rd(int heure_rd) {
        this.heure_rd = heure_rd;
    }

    public long getJour_restant() {
        return jour_restant;
    }

    public void setJour_restant(int jour_restant) {
        this.jour_restant = jour_restant;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public Medcin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medcin medecin) {
        this.medecin = medecin;
    }

    public Button getModifier() {
        return modifier;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }
    

    @Override
    public String toString() {
        return "RendezVous{" + "id_rd=" + id_rd + ", date_rd=" + date_rd + ", heure_rd=" + heure_rd + ", jour_restant=" + jour_restant + ", id_patient=" + id_patient + ", medecin=" + medecin + ", symptome=" + symptome + ", nom_med=" + nom_med + ", prenom_med=" + prenom_med + ", specialite_med=" + specialite_med + '}';
    }

    

    
    
    
}
