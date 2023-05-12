/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.CertificatMedical;
import Entities.Patient2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.DropMode.ON;
import utils.MyConnection;
import utils.CurrentData; 


/**
 *
 * @author HP
 */
public class CRUDCertificatMedical {
    Connection cnx; 
    
       public void ajouterCertficatMedical(){
           try {
               String requete6 = "INSERT INTO `certificat_medical`(`Id_patient`,`id_med`,`type_certif`,`designation`)"
                       + "VALUES ('1','1','Accident du travail','congés maladie pendant 15 jours')";
               Statement st = new MyConnection().getcnx().createStatement();
               st.executeUpdate(requete6); 
               System.out.println("Certficat médical ajouté avec succées");
           } catch (SQLException ex) {
               System.err.println(ex.getMessage());
               Logger.getLogger(CRUDCertificatMedical.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
       public void ajouterCertificatMedical( CertificatMedical certif) {
        try {
            String requete7 = "INSERT INTO `certificat_medical`(`Id_patient`,`id_med`,`type_certif`,`designation`)"
                    + "VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete7);
          
            //Id-patient,id_med
            pst.setString(3,certif.getType_certif());
            pst.setString(4,certif.getDesignation() );
            System.out.println("Ordonnance ajoutée avec succées");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(CRUDCertificatMedical.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           
       }
       public List<CertificatMedical> afficherCertificatMedical(){
           List<CertificatMedical> myList = new ArrayList<>();
        try {
       
            String requete8 = "SELECT `Id_certif`,`Nom_patient`,`Prénom_patient`,`type_certif`,`designation` FROM `certificat_medical` JOIN patient ON certificat_medical.Id_patient = patient.Id_patient  WHERE id_med=" +CurrentData.current_user_id;
            Statement st = new MyConnection().getcnx().createStatement();
            ResultSet rs =st.executeQuery(requete8);
            while(rs.next()){
                CertificatMedical certif = new CertificatMedical();
                Patient2 pat = new Patient2();
                certif.setIdCertif(rs.getInt(1));
                pat.setNomPatient(rs.getString("Nom_patient"));
                pat.setNomPatient(rs.getString("Prenom_patient"));
                certif.setPatient(pat);
                //med.setId_med(CurrentData.current_user_id); 
                certif.setType_certif(rs.getString("type_certif"));
                certif.setDesignation(rs.getString("designation"));
                myList.add(certif);
                //myList.add(pat);
                
     
       
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myList; 
       
           }
       
       public void ModifierCertificatMedical(CertificatMedical certif){
           
        try {
            String requete9 = "UPDATE `certificat_medical` SET `Id_certif`= ? ,`Id_patient`=? ,`id_med`=?,`type_certif`=?,`designation`= ?,WHERE Id_certif= ?";
            PreparedStatement pst = cnx.prepareStatement(requete9);
            pst.setInt(1,certif.getIdCertif());
            //pst.setInt(2, certif.getPatient());
            pst.setString(4,certif.getType_certif());
            pst.setString(5,certif.getDesignation());
            pst.executeUpdate();
            System.out.println("Votre certificat  est modifiée!!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
           
           
       }
       public void supprimerCertificatMedical(int idCertif){
        try {
            String requete10 = "DELETE FROM 'certificat_medical' WHERE Id_certif= '" + idCertif + "'";
            Statement st= new MyConnection().getcnx().createStatement();
            st.executeUpdate(requete10);
            System.out.println("Votre Ordonnance est supprimée!!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCertificatMedical.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
       }
                          
  
}
