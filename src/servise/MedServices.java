/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servise;

import InServise.InterMedServeses;
import entity.Medcin;
import java.math.BigInteger;
import java.nio.Buffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getBoolean;
import utils.MyDB;
import utils.ShaUtils;

/**
 *
 * @author lenovo
 */
public class MedServices implements InterMedServeses<Medcin> {

    Connection conx;
ShaUtils sh = new ShaUtils();
    //c'est un constructeur !!
    public MedServices() {
        conx = MyDB.getInstance().getConnection();
        //Blob blob = conx.createBlob();
    }
    /* mdp_med, email_med,date_naissance_med,
     age_med,adresse_med,  genre_med,  nom_med,  prenom_med,
     num_tel_med,  photo_med, spéciatilte*/

  
    @Override
    
    public void insert(Medcin med) {
        String req = "INSERT INTO `medecin`(`mdp_med`, `email_med`, `date_naissance_med`, `age_med`, `adresse_med`, `genre_med`,`nom_med`, `prenom_med`, `num_tel_med`, `photo_med`, `speciatilte`) "
                + "values ('" + sh.sha_256encryption(med.getMdp_med()) + "','" + med.getEmail_med() + "','" + med.getDate_naissance_med() + "','" + med.getAge_med() + "','"
                + med.getAdresse_med() + "','" + med.getGenre_med() + "','" + med.getNom_med() + "','" + med.getPrenom_med() + "','" + med.getNum_tel_med()
                + "','" + med.getPhoto_med() + "','" + med.getSpeciatilte() + "')";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            // System.out.println(med); 
            //   System.out.println(req); 
            System.out.println("MEDCIN ADDED SUCCSEFULY !");
            //System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void update(Medcin med, int id) {
      
        /* mdp_med, email_med,date_naissance_med,
         age_med,adresse_med,  genre_med,  nom_med,  prenom_med,
         num_tel_med,  photo_med, spéciatilte*/
        String req = "UPDATE `medecin` SET`mdp_med`='" +  sh.sha_256encryption(med.getMdp_med()) + "',`email_med`='" + med.getEmail_med() + "',"
                + "`date_naissance_med`='" + med.getDate_naissance_med() + "',`age_med`='" + med.getAge_med() + "',`adresse_med`='"
                + med.getAdresse_med() + "',`genre_med`='" + med.getGenre_med() + "',`nom_med`='" + med.getNom_med() + "',`prenom_med`='"
                + med.getPrenom_med() + "',`num_tel_med`='" + med.getNum_tel_med() + "',`photo_med`='" + med.getPhoto_med() + "',`speciatilte`='"
                + med.getSpeciatilte() + "' WHERE id_med= '" + id + "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            // System.out.println(med); 
            //  System.out.println(req); 
            System.out.println("MEDCIN UPDATED SUCCSEFULY !");
            //  System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String req = "DELETE FROM `medecin`  WHERE id_med= '" + id + "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("MEDCIN DELETED SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
 
    private ResultSet rs;

    @Override
    public List<Medcin> FindAll() {
        List<Medcin> list = new ArrayList<>();
        String req = "SELECT * From `medecin` ";
        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Medcin e = new Medcin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
                list.add(e);
            }
            System.out.println(" ALL MEDCIN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;

    }
       public void imgupload(Buffer img ,int id){
          String req = "SELECT  `img`From `img` WHERE id_img = '" + id + "' ";
    }
            


    @Override
    public Medcin FindById(int id) {
       // List<Medcin> list = new ArrayList<>();
             Medcin med = new Medcin();

        String req = "SELECT  `id_med`, `mdp_med`, `email_med`, `date_naissance_med`, `age_med`, `adresse_med`, `genre_med`,`nom_med`, `prenom_med`, `num_tel_med`, `photo_med`,`photo_dip`,`nb_rec_med`,`nb_patient`,`is_Blocked`,`speciatilte` From `medecin` WHERE id_med= '" + id + "' ";

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Medcin e = new Medcin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
               med =e;
            }
            System.out.println("MEDCIN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return med;
    }

     public List<Medcin> FindById2(int id) {
        List<Medcin> list = new ArrayList<>();
             //Medcin med = new Medcin();

        String req = "SELECT  `id_med`, `mdp_med`, `email_med`, `date_naissance_med`, `age_med`, `adresse_med`, `genre_med`,`nom_med`, `prenom_med`, `num_tel_med`, `photo_med`,`photo_dip`,`nb_rec_med`,`nb_patient`,`is_Blocked`,`spéciatilte` From `medecin` WHERE id_med= '" + id + "' ";

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Medcin e = new Medcin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
              list.add(e);
            }
            System.out.println("MEDCIN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Medcin searchByName(String nom_med) {
      // List<Medcin> list = new ArrayList<>();
      Medcin med = new Medcin();
        String req = "SELECT  `id_med`, `mdp_med`, `email_med`, `date_naissance_med`, `age_med`,"
                + " `adresse_med`, `genre_med`,`nom_med`, `prenom_med`, `num_tel_med`, "
                + "`photo_med`,`photo_dip`,`nb_rec_med`,`nb_patient`,`is_Blocked`,"
                + "`speciatilte` From `medecin` WHERE nom_med= '" + nom_med + "' ";

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Medcin e = new Medcin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
               med=e;
            }
            System.out.println("MEDCIN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return med;    }

   public List<Medcin> FindBymail(String mail ) {
        List<Medcin> list = new ArrayList<>();
             //Medcin med = new Medcin();

        String req = "SELECT  `id_med`, `mdp_med`, `email_med`, `date_naissance_med`, `age_med`, `adresse_med`, `genre_med`,`nom_med`, `prenom_med`, `num_tel_med`, `photo_med`,`photo_dip`,`nb_rec_med`,`nb_patient`,`is_Blocked`,`speciatilte` From `medecin` WHERE email_med= '" + mail + "' ";

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Medcin e = new Medcin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
              list.add(e);
            }
            System.out.println("MEDCIN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
   public Medcin FindBymail2(String mail ) {
        //List<Medcin> list = new ArrayList<>();
            Medcin med = new Medcin();

        String req = "SELECT  `id_med`, `mdp_med`, `email_med`, `date_naissance_med`, `age_med`, `adresse_med`, `genre_med`,`nom_med`, `prenom_med`, `num_tel_med`, `photo_med`,`photo_dip`,`nb_rec_med`,`nb_patient`,`is_Blocked`,`speciatilte` From `medecin` WHERE email_med= '" + mail + "' ";

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Medcin e = new Medcin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
                 med=e;
            }
            System.out.println("MEDCIN FOUND SUCCSEFULY !");
            System.out.println(med.toString());

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return med;
    }
    
    @Override
    public List searchBySpeciality(String name) {
List<Medcin> list = new ArrayList<>();
        String req = "SELECT  `id_med`, `mdp_med`, `email_med`, `date_naissance_med`, `age_med`,"
                + " `adresse_med`, `genre_med`,`nom_med`, `prenom_med`, `num_tel_med`, "
                + "`photo_med`,`photo_dip`,`nb_rec_med`,`nb_patient`,`is_Blocked`,"
                + "`speciatilte` From `medecin` WHERE speciatilte= '" + name + "' ";

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Medcin e = new Medcin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
                list.add(e);
            }
            System.out.println("MEDCIN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;        }

    @Override
    public void bloqueMed( int id) {
        
         String req = "UPDATE `medecin` SET`is_Blocked`= 1 WHERE id_med= '" + id + "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            // System.out.println(med); 
            //  System.out.println(req); 
            System.out.println("MEDCIN BLOCKED SUCCSEFULY !");
            //  System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void unbloqueMed( int id) {
        
         String req = "UPDATE `medecin` SET`is_Blocked`= 0 WHERE id_med= '" + id + "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            // System.out.println(med); 
            //  System.out.println(req); 
            System.out.println("MEDCIN unBLOCKED SUCCSEFULY !");
            //  System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public String hashingFunction(String pass) {
        String plaintext = "your text here";
         String hashtext="";
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(plaintext.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
             hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            };
           
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MedServices.class.getName()).log(Level.SEVERE, null, ex);
        }

         return hashtext;
    }

    @Override
    public boolean exist(int id) {
  List<Medcin> list = new ArrayList<>();
  boolean resut;
        String req = "SELECT  `id_med`, `mdp_med`, `email_med`, `date_naissance_med`, `age_med`, `adresse_med`, `genre_med`,`nom_med`, `prenom_med`, `num_tel_med`, `photo_med`,`photo_dip`,`nb_rec_med`,`nb_patient`,`is_Blocked`,`speciatilte` From `medecin` WHERE id_med= '" + id + "' ";

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Medcin e = new Medcin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
                list.add(e);
            }
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        if (list.size() == 0) {
            System.out.println("MEDCIN NOT FOUND !");
            resut= false;
        } else {
              System.out.println("MEDCIN FOUND SUCCSEFULY !");
               resut= true;
        }
        return resut;    }

    @Override
    public boolean isblocked(int id) {
   int isB = 0;
   boolean resut;
        String req = "SELECT `is_Blocked` From `medecin` WHERE id_med= '" + id + "' ";

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
               isB = rs.getInt(1);
            }
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        if (isB == 0) {
            System.out.println("MEDCIN NOT Blocked !");
            resut= false;
        } else {
              System.out.println("MEDCIN is Blocked !");
               resut= true;
               System.out.println(resut);
        }
        return resut;       }
    
    
   

}
