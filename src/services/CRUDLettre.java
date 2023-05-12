/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.LettreConfidentielle;
import Entities.Medecin;
import Entities.Ordonnance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.CurrentData;
import utils.MyConnection;

/**
 *
 * @author HP
 */
public class CRUDLettre {
    Connection cnx;
     
    // Ajout d'une ordonnance  
  public void ajouterLettreConfidentielle(LettreConfidentielle lc){
       
        String requete="INSERT INTO `lettre_confidentielle`(`date`,`id_med`,`description`,`signature`,`id_ordonnance`)"
                +"values ('" + lc.getDate() + "','"+ lc.getIdMed()+"','"+ lc.getDescription()+"','"+ lc.getSignature()+"','"+ lc.getId_ordonnance()+"')";
        try {
           
            Statement st= new MyConnection().getcnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Lettre confidentielle ajoutée avec succées!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
  //modification
    public void modifierLettreConfidentielle(LettreConfidentielle lc, int idC){
       String requete4 = "UPDATE `lettre_confidentielle` SET `date`='" + lc.getDate() + "'," + "`description`='" + lc.getDescription() + "',`signature`='" + lc.getSignature() +  "' WHERE   IdConf = '" + idC + "'  ";
        try {
             
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(requete4);
            pst.executeUpdate(requete4);
            System.out.println("Lettre  modifiée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
 
  

    
   
  
    
    
    }
    
  

    //afficher une lettre confidentielle
     public List<LettreConfidentielle> afficherLettreConfidentielle(){
        List<LettreConfidentielle> myList=new ArrayList<>();
        
        try {
            String requete2 =  "SELECT `IdConf`,`date`,"
                    + "`nom_med`,`prenom_med`,`description`,`signature`,`nomPrenomPatient`"
                    + " FROM `lettre_confidentielle` JOIN `medecin` ON lettre_confidentielle.id_med = medecin.id_med "
                    + "JOIN `ordonnance` ON lettre_confidentielle.Id_ordonnance = ordonnance.Id_ordonnance WHERE lettre_confidentielle.id_med= 1" ;
            Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while (rs.next()){
                LettreConfidentielle lc = new LettreConfidentielle();
                Medecin med = new Medecin ();
                Ordonnance ord = new Ordonnance();
            
                lc.setIdConf(rs.getInt(1));
                lc.setDate(rs.getTimestamp(2));
              //  lc.setMedcin(med);
                //med.setId_med(rs.getInt("id_med"));
                med.setNom_med(rs.getString("nom_med"));
                med.setPrenom_med(rs.getString("prenom_med"));
                lc.setDescription(rs.getString("description"));
                lc.setSignature(rs.getString("signature"));
                ord.setNomPrenomPatient(rs.getString("nomPrenomPatient"));
                
                //ord.setIdOrdonnance(rs.getInt("Id_ordonnance"));
               lc.setOrdonnance(ord);
                
                //ord.setNomPrenomPatient(rs.getString("nomPrenomPatient"));
               //ord.setIdOrdonnance(rs.getInt("id_ordonnance"));
               myList.add(lc);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    } 
    
     
    //supprimer une lettre 
     public void supprimerLettre(int idl){
        try {
            String requete3 = "DELETE FROM `lettre_confidentielle` WHERE IdConf='" + idl + "'";
            
            Statement st= new MyConnection().getcnx().createStatement();
            st.executeUpdate(requete3); 
            System.out.println("lettre confidentielle supprimée avec succées");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDOrdonnance.class.getName()).log(Level.SEVERE, null, ex);
        }  
    } 
     
     //rechercher une lettre
     public List FindById(int idl) {
        List<LettreConfidentielle> list = new ArrayList<>();
      String requette5 = "SELECT `date`, `id_med`, `description`, `signature`,`id_ordonnance`  From `lettre_confidentielle` WHERE IdConf= '" + idl + "' ";
       /*  String requete2 =  "SELECT `IdConf`,`date`,"
                    + "`nom_med`,`prenom_med`,`description`,`signature`,`nomPrenomPatient`"
                    + " FROM `lettre_confidentielle` JOIN `medecin`  ON lettre_confidentielle.id_med = medecin.id_med "
                    + "JOIN `ordonnance` ON lettre_confidentielle.id_ordonnance = ordonnance.Id_ordonnance WHERE lettre_confidentielle.id_med=" +CurrentData.current_user_id ;*/
        try {
              Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requette5);
           // ResultSet rs = st.executeQuery(requete2);
            
            while (rs.next()) {
               LettreConfidentielle lc = new  LettreConfidentielle (rs.getTimestamp("date"),rs.getInt("id_med"),rs.getString("description"),rs.getString("signature"),rs.getInt("id_ordonnance"));
                /*LettreConfidentielle lc = new LettreConfidentielle();
                Medecin med = new Medecin ();
                Ordonnance ord = new Ordonnance();
                lc.setIdConf(rs.getInt(1));
                lc.setDate(rs.getTimestamp(2));
                lc.setMedcin(med);
               // med.setId_med(rs.getInt("id_med"));
                med.setNom_med(rs.getString("nom_med"));
                med.setPrenom_med(rs.getString("prenom_med"));
                lc.setDescription(rs.getString("description"));
                lc.setSignature(rs.getString("signature"));
                lc.setOrdonnance(ord);
                ord.setNomPrenomPatient(rs.getString("nomPrenomPatient"));
               // ord.setIdOrdonnance(rs.getInt(1)); */
                list.add(lc);
            }
            System.out.println("Lettre confidentielle existante !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    
     
    } 
      
           
            
    
     
    
     
     
}