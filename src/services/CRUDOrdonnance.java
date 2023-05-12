/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import Entities.Ordonnance;
import Entities.Patient2;
import Entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;
import java.sql.Timestamp;
import org.omg.CORBA.Current;
import utils.CurrentData;

/**
 *
 * @author HP
 */
public class CRUDOrdonnance {
    Connection cnx;
   
     
    // Ajout d'une ordonnance  
  public void ajouterOrdonnance(Ordonnance ord){
       
        String requete="INSERT INTO `ordonnance`(`dateAjout`,`Mode_utilisation`,`nomPrenomPatient`,`id_produit`)"
                +"values ('" + ord.getDateAjout() + "','"+ ord.getModeUtilisation()+"','"+ ord.getNomPrenomPatient()+"','"+ ord.getId_prod()+"')";
      
        try {
           
            Statement st= new MyConnection().getcnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Ordonnance ajoutée avec succées!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 
    
  
  
  
  
  
   // supprimer Ordonnance
    public void supprimerOrdonnance(int idOrd){
        try {
            String requete3 = "DELETE FROM `ordonnance` WHERE id_ordonnance='" + idOrd + "'";
            
            Statement st= new MyConnection().getcnx().createStatement();
            st.executeUpdate(requete3); 
            System.out.println("Ordonnance supprimée");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDOrdonnance.class.getName()).log(Level.SEVERE, null, ex);
        }  
    } 
    
   
    //afficher ordonnance
    public List<Ordonnance> afficherOrdonnance(){
        List<Ordonnance> myList=new ArrayList<>();
        
        try {
            String requete2 =  "SELECT `Id_ordonnance`,`DateAjout`,`nom_prod`,`Mode_utilisation`,`nomPrenomPatient`,`id_produit`FROM `ordonnance` JOIN `produit` ON ordonnance.id_produit = produit.id_prod WHERE id_med=" +CurrentData.current_user_id ;
            Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while (rs.next()){
               Ordonnance ord = new Ordonnance();
                Produit pro = new Produit ();
                ord.setIdOrdonnance(rs.getInt(1));
                ord.setDateAjout(rs.getString(2));
                ord.setModeUtilisation(rs.getString(3));
                ord.setNomPrenomPatient(rs.getString("nomPrenomPatient"));
                ord.setId_med(CurrentData.current_user_id);
                pro.setNomProduit(rs.getString("nom_prod"));
                ord.setProduit(pro);
                myList.add(ord); 
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    //modifier ordonnance 
   public void modifierOrdonnance(Ordonnance ord, int id){
       String requete4 = "UPDATE `ordonnance` SET `DateAjout`='" + ord.getDateAjout() + "'," + "`Mode_utilisation`='" + ord.getModeUtilisation() + "',`nomPrenomPatient`='" + ord.getNomPrenomPatient() +  "' WHERE   Id_ordonnance = '" + id + "'  ";
        try {
             
            PreparedStatement pst = new MyConnection().getcnx().prepareStatement(requete4);
            pst.executeUpdate(requete4);
            System.out.println("Ordonnance modifiée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
   }
   /*   String requete="INSERT INTO `ordonnance`(`dateAjout`,`Mode_utilisation`,`nomPrenomPatient`,`id_produit`,`id_med)"
                +"values ('" + ord.getDateAjout() + "','"+ ord.getModeUtilisation()+"','"+ ord.getNomPrenomPatient()+"','"+ ord.getId_prod()+"','"+ ord.getId_med()+"')";*/
   // Rechercher Ordonnance 
   
   public List FindById(int id) {
        List<Ordonnance> list = new ArrayList<>();
        String requette5 = "SELECT `DateAjout`, `Mode_utilisation`, `nomPrenomPatient`, `id_produit`,`id_med`  From `ordonnance` WHERE Id_ordonnance= '" + id + "' ";

        try {
              Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requette5);
            while (rs.next()) {
                Ordonnance ord = new Ordonnance(rs.getString("DateAjout"),rs.getString("Mode_utilisation"),rs.getString("nomPrenomPatient"),rs.getInt("id_produit"),rs.getInt("id_med"));
                list.add(ord);
            }
            System.out.println("Ordonnance existant !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }  
   
   /* public List FindByName(String name) {
        List<Ordonnance> list = new ArrayList<>();
        String requette5 = "SELECT `DateAjout`, `Mode_utilisation`, `nomPrenomPatient`, `id_produit`,`id_med`  From `ordonnance` WHERE nom_prod= '" + name + "' ";

        try {
              Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requette5);
            while (rs.next()) {
                Ordonnance ord = new Ordonnance(rs.getString("DateAjout"),rs.getString("Mode_utilisation"),rs.getString("nomPrenomPatient"),rs.getInt("id_produit"),rs.getInt("id_med"));
                list.add(ord);
            }
            System.out.println("Produit  existante !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }  */
  
    
}


