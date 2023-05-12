/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servise;
import entity.Bilan;
import entity.Fiche_suivi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;
import java.sql.ResultSet;

/**
 *
 * @author marie
 */
public class BilanCRUD {
    public void ajouterBilan(Bilan b ){
        try {
            String requete1 = "INSERT INTO bilan(type,date_bilan,conclusion) VALUES(?,?,?)";
            PreparedStatement fst = new MyConnection().getcnx().prepareStatement(requete1);
            
            fst.setString(1,b.getType());
            fst.setTimestamp(2,b.getDate_bilan());
            fst.setString(3,b.getConclusion());
            fst.executeUpdate();
            System.out.println("Le Bilan est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
             
        }
           
    }
    
    
    public void supprimerbilan(int id) {
        String requete = "DELETE FROM `bilan`  WHERE id_bilan= '" + id + "'";

        try {
            Statement st = new MyConnection().getcnx().createStatement();
            st.executeUpdate(requete);
                 System.out.println("bilan est supprimée avec succés");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 
        
    }
    
    
    public void modifierBilan(Bilan bcd ,int id)
 {
       String requete4 = "UPDATE `bilan` SET `type`='" + bcd.getType() + "'," + "`date_bilan`='" + bcd.getDate_bilan() + "'," + "`conclusion`='" + bcd.getConclusion() +  "' WHERE   id_bilan = '" + id + "'  ";
        try {
             
            PreparedStatement fst = new MyConnection().getcnx().prepareStatement(requete4);
            fst.executeUpdate(requete4);
            System.out.println("Bilan modifiée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
       
   }
    
    private ResultSet rs;
    public List FindBilanById(int id) {
        List<Bilan> list = new ArrayList<>();
        String requette5 = "SELECT `type`, `date_bilan`, `conclusion`From `bilan` WHERE id_bilan= '" + id + "' ";

        try {
            Statement st = new MyConnection().getcnx().createStatement();
            rs = st.executeQuery(requette5);
            while (rs.next()) {
                Bilan b = new Bilan(rs.getString(1), rs.getTimestamp(2), rs.getString(3));
                list.add(b);
            }
            System.out.println("Bilan trouvée avec succées !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public List<Bilan> afficherBilan(){
         List<Bilan> mylist = new ArrayList<>();
        try {
            String requete3 = "SELECT * FROM bilan";
            Statement st = new MyConnection().getcnx().createStatement(); 
            ResultSet rs = st.executeQuery(requete3);
            while(rs.next()){
                
                Bilan b =  new Bilan();
                b.setId_bilan(rs.getInt(1));
                b.setType(rs.getString("type"));
                b.setDate_bilan(rs.getTimestamp("date_bilan"));
                b.setConclusion(rs.getString("conclusion"));               
                mylist.add(b);
            }     
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        
        return mylist;
     
     
    }       
    
    public List FindBilanByType(String type) {
        List<Bilan> list = new ArrayList<>();
        String requette5 = "SELECT `id_bilan`,`type`, `date_bilan`, `conclusion`From `bilan` WHERE type= '" + type + "' ";

        try {
            Statement st = new MyConnection().getcnx().createStatement();
            rs = st.executeQuery(requette5);
            while (rs.next()) {
                Bilan b = new Bilan(rs.getInt(1),rs.getString(2),rs.getTimestamp(3), rs.getString(4));
                list.add(b);
            }
            System.out.println("Bilan trouvée avec succées !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
}
           
    
    

