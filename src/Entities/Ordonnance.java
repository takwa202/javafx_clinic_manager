/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



import java.sql.Date;
import java.sql.Timestamp;     
    

/**
 *
 * @author HP
 */
public class Ordonnance {

    private int idOrdonnance;
    private String dateAjout;
    private String modeUtilisation ; 
    private String nomPrenomPatient;
    private Produit produit;
    private int id_prod;
    private int id_med;
   
// getIdOrdonnance()DateAjout()ModeUtilisation()NomPrenomPatient(),ord.getProduit().getNomProduit(),ord.getId_prod()));
    public Ordonnance(int idOrdonnance, String dateAjout, String modeUtilisation, String nomPrenomPatient, Produit produit, int id_prod) {
        this.idOrdonnance = idOrdonnance;
        this.dateAjout = dateAjout;
        this.modeUtilisation = modeUtilisation;
        this.nomPrenomPatient = nomPrenomPatient;
        this.produit = produit;
        this.id_prod = id_prod;
    }

    public Ordonnance() {
    }

    public Ordonnance(String nomPrenomPatient) {
        this.nomPrenomPatient = nomPrenomPatient;
    }
    
    public Ordonnance(String dateAjout, String modeUtilisation, String nomPrenomPatient, Produit produit) {
        this.dateAjout = dateAjout;
        this.modeUtilisation = modeUtilisation;
        this.nomPrenomPatient = nomPrenomPatient;
        this.produit = produit;
    }

    public Ordonnance(String dateAjout, String modeUtilisation, String nomPrenomPatient, int id_prod, int id_med) {
        this.dateAjout = dateAjout;
        this.modeUtilisation = modeUtilisation;
        this.nomPrenomPatient = nomPrenomPatient;
        this.id_prod = id_prod;
        this.id_med = id_med;
    }

    public Ordonnance(String dateAjout, String modeUtilisation, Produit produit) {
        this.dateAjout = dateAjout;
        this.modeUtilisation = modeUtilisation;
        this.produit = produit;
    }

    public Ordonnance(String dateAjout, String modeUtilisation, String nomPrenomPatient, Produit produit, int id_med) {
        this.dateAjout = dateAjout;
        this.modeUtilisation = modeUtilisation;
        this.nomPrenomPatient = nomPrenomPatient;
        this.produit = produit;
        this.id_med = id_med;
    }

    public Ordonnance(String dateAjout, String modeUtilisation, String nomPrenomPatient, Produit produit, int id_prod, int id_med) {
        this.dateAjout = dateAjout;
        this.modeUtilisation = modeUtilisation;
        this.nomPrenomPatient = nomPrenomPatient;
        this.produit = produit;
        this.id_prod = id_prod;
        this.id_med = id_med;
    }

    public Ordonnance(String dateAjout, String modeUtilisation, String nomPrenomPatient) {
        this.dateAjout = dateAjout;
        this.modeUtilisation = modeUtilisation;
        this.nomPrenomPatient = nomPrenomPatient;
    }

    public Ordonnance(String dateAjout, String modeUtilisation, String nomPrenomPatient, int id_prod) {
        this.dateAjout = dateAjout;
        this.modeUtilisation = modeUtilisation;
        this.nomPrenomPatient = nomPrenomPatient;
        this.id_prod = id_prod;
    }
    

    public Ordonnance(String dateAjout, String modeUtilisation, String nomPrénomPatient, String produit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Ordonnance(int idOrdonnance, String dateAjout, String modeUtilisation, String nomPrenomPatient, String nomProduit, int id_prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public int getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(int idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getModeUtilisation() {
        return modeUtilisation;
    }

    public void setModeUtilisation(String modeUtilisation) {
        this.modeUtilisation = modeUtilisation;
    }

    public String getNomPrenomPatient() {
        return nomPrenomPatient;
    }

    public void setNomPrenomPatient(String nomPrenomPatient) {
        this.nomPrenomPatient = nomPrenomPatient;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    @Override
    public String toString() {
        return "Ordonnance{" + "idOrdonnance=" + idOrdonnance + ", dateAjout=" + dateAjout + ", modeUtilisation=" + modeUtilisation + ", nomPrenomPatient=" + nomPrenomPatient + ", produit=" + produit + ", id_prod=" + id_prod + ", id_med=" + id_med + '}';
    }

   
   
    

    
    
    
    
    
}
