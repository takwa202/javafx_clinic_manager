/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author marie
 */
public class Fiche_suivi {
    private int id_fiche;
    private int id_client;
    private int bilan_id;
    private String diagnostic;
    private String consigne_medicale;
    private Patient pat ;
    private int id_med;
    private String nompa;
    private String prepa;
    private String mail;
    private int tel;
    private int age ;
    private Bilan bi;
    private String type;
    private Timestamp date ;
    private String conclu ;
    
    
    public Fiche_suivi(){
    
    }

    public Fiche_suivi(String diagnostic, String consigne_medicale, Patient pat, String nompa, String prepa, String mail, int tel, int age, Bilan bi, String type, Timestamp date, String conclu) {
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.pat = pat;
        this.nompa = nompa;
        this.prepa = prepa;
        this.mail = mail;
        this.tel = tel;
        this.age = age;
        this.bi = bi;
        this.type = type;
        this.date = date;
        this.conclu = conclu;
    }
    

    public Fiche_suivi(String diagnostic, String consigne_medicale, String nompa, String prepa, String mail, int tel, int age, String type, Timestamp date, String conclu) {
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.nompa = nompa;
        this.prepa = prepa;
        this.mail = mail;
        this.tel = tel;
        this.age = age;
        this.type = type;
        this.date = date;
        this.conclu = conclu;
    }
    

    public Fiche_suivi(String diagnostic, String consigne_medicale, Patient pat, Bilan bi, String nompa, String prepa, String mail, int tel, int age, String type, Timestamp date, String conclu) {
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.pat = pat;
        this.bi = bi;
        this.nompa = nompa;
        this.prepa = prepa;
        this.mail = mail;
        this.tel = tel;
        this.age = age;
        this.type = type;
        this.date = date;
        this.conclu = conclu;
    }
    

    
    

    public Fiche_suivi(int id_client, int bilan_id, String diagnostic, String consigne_medicale, Patient pat, Bilan bi) {
        this.id_client = id_client;
        this.bilan_id = bilan_id;
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.pat = pat;
        this.bi = bi;
    }  

    public Fiche_suivi(int id_fiche, int id_client, int bilan_id, String diagnostic, String consigne_medicale, Patient pat, Bilan bi) {
        this.id_fiche = id_fiche;
        this.id_client = id_client;
        this.bilan_id = bilan_id;
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.pat = pat;
        this.bi = bi;
    }
    

    public Fiche_suivi(int id_fiche, int id_client, int bilan_id, String diagnostic, String consigne_medicale, Patient pat) {
        this.id_fiche = id_fiche;
        this.id_client = id_client;
        this.bilan_id = bilan_id;
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.pat = pat;
    }

    public Fiche_suivi(int id_client, int bilan_id, String diagnostic, String consigne_medicale, Patient pat) {
        this.id_client = id_client;
        this.bilan_id = bilan_id;
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.pat = pat;
    }

    public Fiche_suivi(int id_client, int bilan_id, String diagnostic, String consigne_medicale) {
        this.id_client = id_client;
        this.bilan_id = bilan_id;
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
    }

    public Fiche_suivi(String diagnostic, String consigne_medicale) {
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
    }

    public Fiche_suivi(int id_fiche, int id_client, int bilan_id, String diagnostic, String consigne_medicale) {
        this.id_fiche = id_fiche;
        this.id_client = id_client;
        this.bilan_id = bilan_id;
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
    }

    public Fiche_suivi(int id_fiche, int id_client, int bilan_id, String diagnostic, String consigne_medicale, Patient pat, Bilan bi, int id_med) {
        this.id_fiche = id_fiche;
        this.id_client = id_client;
        this.bilan_id = bilan_id;
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.pat = pat;
        this.bi = bi;
        this.id_med = id_med;
    }

    public Fiche_suivi(int id_client, int bilan_id, String diagnostic, String consigne_medicale, Patient pat, Bilan bi, int id_med) {
        this.id_client = id_client;
        this.bilan_id = bilan_id;
        this.diagnostic = diagnostic;
        this.consigne_medicale = consigne_medicale;
        this.pat = pat;
        this.bi = bi;
        this.id_med = id_med;
    }
    
    
    

    public int getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getBilan_id() {
        return bilan_id;
    }

    public void setBilan_id(int bilan_id) {
        this.bilan_id = bilan_id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getConsigne_medicale() {
        return consigne_medicale;
    }

    public void setConsigne_medicale(String consigne_medicale) {
        this.consigne_medicale = consigne_medicale;
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }

    public Bilan getBi() {
        return bi;
    }

    public void setBi(Bilan bi) {
        this.bi = bi;
    }
    
    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    @Override
    public String toString() {
        return "Fiche_suivi{" + "diagnostic=" + diagnostic + ", consigne_medicale=" + consigne_medicale + ", nompa=" + nompa + ", prepa=" + prepa + ", mail=" + mail + ", tel=" + tel + ", age=" + age + ", type=" + type + ", date=" + date + ", conclu=" + conclu + '}';
    }

    

    
    
    
    

  

    
}
