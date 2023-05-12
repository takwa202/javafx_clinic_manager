/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author noura
 */



public class Symptome {
    
    private int id_sym;
    private int fievre;
    private int toux;
    private int fatigue;
    private int douleur_musculaire;
    private int mal_de_gorge;
    private int essouflement;
    private int perte_d_appetit;
    private int ecoulement_nasal;
    private int nausee;
    private int vomissement;
    private int mal_de_tete;
    private String autre;
    
    
    public Symptome(){
        
    }

    public Symptome(int id_sym) {
        this.id_sym = id_sym;
    }
    
    

    public Symptome(int id_sym, int fievre, int toux, int fatigue, int douleur_musculaire, int mal_de_gorge, int essouflement, int perte_d_appetit, int ecoulement_nasal, int nausee, int vomissement, int mal_de_tete, String autre) {
        this.id_sym = id_sym;
        this.fievre = fievre;
        this.toux = toux;
        this.fatigue = fatigue;
        this.douleur_musculaire = douleur_musculaire;
        this.mal_de_gorge = mal_de_gorge;
        this.essouflement = essouflement;
        this.perte_d_appetit = perte_d_appetit;
        this.ecoulement_nasal = ecoulement_nasal;
        this.nausee = nausee;
        this.vomissement = vomissement;
        this.mal_de_tete = mal_de_tete;
        this.autre = autre;
    }

    public int getFievre() {
        return fievre;
    }

    public void setFievre(int fievre) {
        this.fievre = fievre;
    }

    public int getToux() {
        return toux;
    }

    public void setToux(int toux) {
        this.toux = toux;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getDouleur_musculaire() {
        return douleur_musculaire;
    }

    public void setDouleur_musculaire(int douleur_musculaire) {
        this.douleur_musculaire = douleur_musculaire;
    }

    public int getMal_de_gorge() {
        return mal_de_gorge;
    }

    public void setMal_de_gorge(int mal_de_gorge) {
        this.mal_de_gorge = mal_de_gorge;
    }

    public int getEssouflement() {
        return essouflement;
    }

    public void setEssouflement(int essouflement) {
        this.essouflement = essouflement;
    }

    public int getPerte_d_appetit() {
        return perte_d_appetit;
    }

    public void setPerte_d_appetit(int perte_d_appetit) {
        this.perte_d_appetit = perte_d_appetit;
    }

    public int getEcoulement_nasal() {
        return ecoulement_nasal;
    }

    public void setEcoulement_nasal(int ecoulement_nasal) {
        this.ecoulement_nasal = ecoulement_nasal;
    }

    public int getNausee() {
        return nausee;
    }

    public void setNausee(int nausee) {
        this.nausee = nausee;
    }

    public int getVomissement() {
        return vomissement;
    }

    public void setVomissement(int vomissement) {
        this.vomissement = vomissement;
    }

    public int getMal_de_tete() {
        return mal_de_tete;
    }

    public void setMal_de_tete(int mal_de_tete) {
        this.mal_de_tete = mal_de_tete;
    }
   


    public int getId_sym() {
        return id_sym;
    }

    public void setId_sym(int id_sym) {
        this.id_sym = id_sym;
    }

    

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    @Override
    public String toString() {
        return "Symptome{" + "id_sym=" + id_sym + ", fievre=" + fievre + ", toux=" + toux 
                + ", fatigue=" + fatigue + ", douleur_musculaire=" + douleur_musculaire 
                + ", mal_de_gorge=" + mal_de_gorge + ", essouflement=" + essouflement 
                + ", perte_d_appetit=" + perte_d_appetit + ", ecoulement_nasal="
                + ecoulement_nasal + ", nausee=" + nausee + ", vomissement=" + vomissement 
                + ", mal_de_tete=" + mal_de_tete + ", autre=" + autre + '}';
    }
    
    
    
    
    
    
}
