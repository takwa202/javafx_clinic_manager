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
public class Fiche_suivi {
    private int id_fiche;
    private int id_client;
    private int bilan_id;
    private String diagnostic;
    private String consigne_medicale;
    private Patient pat ;
    
    public Fiche_suivi(){
    
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

    @Override
    public String toString() {
        return "Fiche_suivi{" + "id_fiche=" + id_fiche + ", id_client=" + id_client + ", bilan_id=" + bilan_id + ", diagnostic=" + diagnostic + ", consigne_medicale=" + consigne_medicale + ", pat=" + pat + '}';
    }

    
}
