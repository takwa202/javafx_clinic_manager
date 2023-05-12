/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servise;

import entity.Patient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;
import utils.ShaUtils;

/**
 *
 * @author lenovo
 */
public class PtientServices {
    
    ShaUtils sh = new ShaUtils();

    Connection conx;

    //c'est un constructeur !!
    public PtientServices() {
        conx = MyDB.getInstance().getConnection();
    }

    /*   String req = "INSERT INTO `pharmacien`(`Id_Pharmacien `, `nom_Pharmacien`, `Prenom_Pharmacien`, `Adress_Pharmacien`, `NumTel_Pharmacien`, `MotDePasse_Pharmacien`,`Email_Pharmacien`, `Blockfarm` ) "
     + "values ('" + farm.getId_Pharmacien() + "','" + farm.getNom_Pharmacien()+ "','" + farm.getPrenom_Pharmacien() + "','" + farm.getAdress_Pharmacien() + "','"
     + farm.getNumTel_Pharmacien() + "','" + hashingFunction(farm.getMotDePasse_Pharmacien()) + "','" +farm.getEmail_Pharmacien() + "','" + farm.getBlockfarm() + "')";*/
 
    public void insert(Patient farm) {

        String req = "INSERT INTO  `patient`( `Nom_patient`, `Prenom_patient`, `Email_patient`, `Adress_patient`,"
                + "`NumTel_patient`, `MotDePassel_patient`,`Age_patient`,`Gendre_patient`,`isblokedpatient`,`image` ) "
                + "values ('" + farm.getNom_patient() + "','" + farm.getPrenom_patient() + "','" + farm.getEmail_patient() + "','"
                + farm.getAdress_patient() + "','" + farm.getNumTel_patient() + "','" + sh.sha_256encryption(farm.getMotDePassel_patient()) + "','" + farm.getAge_patient() + "'"
                + ",'" + farm.getGendre_patient() + "', '" + farm.getIsblokedpatient()+ "','" + farm.getImage()+ "')";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            // System.out.println(med); 
            //   System.out.println(req); 
            System.out.println("PATIENT ADDED SUCCSEFULY !");
            //System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }


    public void update(Patient farm, int id) {
        String req = "UPDATE `patient` SET `Nom_patient`='" + farm.getNom_patient() + "',"
                + "`Prenom_patient`='" + farm.getPrenom_patient() + "',`Email_patient`='" + farm.getEmail_patient() + "',`Adress_patient`='"
                + farm.getAdress_patient() + "',`NumTel_patient`='" + farm.getNumTel_patient()+ "',"
                + "`MotDePassel_patient`='" + sh.sha_256encryption(farm.getMotDePassel_patient()) + "',"
                + "`Age_patient`='" + farm.getAge_patient()+ "',"
                + "`Gendre_patient` ='" + farm.getGendre_patient()+ "',`isblokedpatient` = '" + farm.getIsblokedpatient()+ "',`image` = '" + farm.getImage()+ "' WHERE Id_patient  = '" + id + "'  ";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);

            System.out.println("PATIENT UPDATED SUCCSEFULY !");
            //  System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }


    public void delete(int id) {
        InterServices is =new InterServices();
        is.delete2(id);
        String req = "DELETE FROM `patient`  WHERE Id_patient  = '" + id + "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("PATIENT DELETED SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    private ResultSet rs;

   
    public List<Patient> FindAll() {
        List<Patient> list = new ArrayList<>();
        String req = "SELECT * From `patient` ";
        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                
                Patient e = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  
                   rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(14));
                list.add(e);
            }
            System.out.println("PHARM GETED SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    private ResultSet rs2;

  
    public List<Patient> FindById(int id) {
        List <Patient> list = new ArrayList<>();
        String req = "SELECT `Id_patient `,`Nom_patient `, `Prenom_patient `, `Email_patient`, `Adress_patient`, `NumTel_patient`,"
                + "`MotDePassel_patient`, `Age_patient`,`Gendre_patient`,`isblokedpatient`,`image` From `patient` WHERE Id_patient  = '" + id + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
               Patient e = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  
                   rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(14));
                list.add(e);
            }
            System.out.println("Ptient FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    } 
      public Patient FindById2(int id) {
      //  List <Pharmacien> list = new ArrayList<>();
      Patient ps = new Patient();
      String req = "SELECT `Id_patient `,`Nom_patient `, `Prenom_patient `, `Email_patient`, `Adress_patient`, `NumTel_patient`,"
                + "`MotDePassel_patient`, `Age_patient`,`Gendre_patient`,`isblokedpatient`,`image`  From `patient` WHERE Id_patient  = '" + id + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
                               Patient e = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  
                   rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(14));
               ps=e;
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ps;
    }
     public Patient FindBymail(String mail) {
      
      Patient ps = new Patient();
      String req = "SELECT `Id_patient`,`Nom_patient`, `Prenom_patient`, `Email_patient`, `Adress_patient`, `NumTel_patient`,"
                + "`MotDePassel_patient`, `Age_patient`,`Gendre_patient`,`isblokedpatient`,`image`  From  `patient` WHERE  Email_patient  = '" + mail + "' ";
//System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                               Patient e = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  
                   rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11));
               ps =e;
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");
             System.out.println(ps.toString());

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ps;
    }
    

    public List searchByName(String name) {
 List <Patient> list = new ArrayList<Patient>();
        String req = "SELECT `Id_patient `,`Nom_patient `, `Prenom_patient `, `Email_patient`, `Adress_patient`, `NumTel_patient`,"
                + "`MotDePassel_patient`, `Age_patient`,`Gendre_patient`,`isblokedpatient` ,`image` From `patient` WHERE Nom_patient  = '" + name + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
                Patient e = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  
                   rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(14));
                list.add(e);
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;    }

   
  
    public void bloquePAS(int id) {
   String req = "UPDATE `patient` SET  `isblokedpatient` = 1  WHERE Id_patient = '" + id + "'  ";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("patient BLOCKED SUCCSEFULY !");
            //  System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }
     public void unbloqueFARM(int id) {
   String req = "UPDATE `patient` SET  `isblokedpatient` = 0  WHERE Id_patient = '" + id + "'  ";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("patient BLOCKED SUCCSEFULY !");
            //  System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }


    public String hashingFunction(String pass) {
        String plaintext = "your text here";
        String hashtext = "";
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
            Logger.getLogger(MedServices.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }

        return hashtext;
    }

  
    public boolean exist(int id) {
        PtientServices PS =new PtientServices();
         List <Patient> list = new ArrayList<>();
        Patient p = new Patient();
        
        list = PS.FindById(id);
        boolean result = true;
        if(list.isEmpty()){
        result =false;
        }
        return result;   }

    public boolean isblocked(int id) {
 int blc=0;
  boolean resut;
        String req = "SELECT `isblokedpatient` From `patient` WHERE Id_patient   = '" + id + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
               blc =rs2.getInt(1);
            }
            System.out.println("patient FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }if (blc == 0) {
            System.out.println("patient NOT BLOCKED!");
            resut= false;
        } else {
              System.out.println("patient  IS BLOCKED!");
               resut= true;
        }
        return resut;      }
    
}
