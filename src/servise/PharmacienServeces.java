/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servise;

import InServise.InterMedServeses;
import InServise.InterPharmServeses;
import entity.Pharmacien;
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
public class PharmacienServeces implements InterPharmServeses<Pharmacien> {
ShaUtils sh = new ShaUtils();

    Connection conx;

    //c'est un constructeur !!
    public PharmacienServeces() {
        conx = MyDB.getInstance().getConnection();
    }

    /*   String req = "INSERT INTO `pharmacien`(`Id_Pharmacien `, `nom_Pharmacien`, `Prenom_Pharmacien`, `Adress_Pharmacien`, `NumTel_Pharmacien`, `MotDePasse_Pharmacien`,`Email_Pharmacien`, `Blockfarm` ) "
     + "values ('" + farm.getId_Pharmacien() + "','" + farm.getNom_Pharmacien()+ "','" + farm.getPrenom_Pharmacien() + "','" + farm.getAdress_Pharmacien() + "','"
     + farm.getNumTel_Pharmacien() + "','" + hashingFunction(farm.getMotDePasse_Pharmacien()) + "','" +farm.getEmail_Pharmacien() + "','" + farm.getBlockfarm() + "')";*/
    @Override
    public void insert(Pharmacien farm) {

        String req = "INSERT INTO `pharmacien`(`nom_Pharmacien`, `Prenom_Pharmacien`, `Adress_Pharmacien`, `NumTel_Pharmacien`, `MotDePasse_Pharmacien`,"
                + "`Email_Pharmacien`, `Blockfarm`,`picturePharm` ) "
                + "values ('" + farm.getNom_Pharmacien() + "','" + farm.getPrenom_Pharmacien() + "','" + farm.getAdress_Pharmacien() + "','"
                + farm.getNumTel_Pharmacien() + "','" + sh.sha_256encryption(farm.getMotDePasse_Pharmacien()) + "','" + farm.getEmail_Pharmacien() + "'"
                + ",'" + farm.getBlockfarm() + "', '" + farm.getPicturePharm()+ "')";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            // System.out.println(med); 
            //   System.out.println(req); 
            System.out.println("PHARMCIEN ADDED SUCCSEFULY !");
            //System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override

    public void update(Pharmacien farm, int id) {
        String req = "UPDATE `pharmacien` SET `nom_Pharmacien`='" + farm.getNom_Pharmacien() + "',"
                + "`Prenom_Pharmacien`='" + farm.getPrenom_Pharmacien() + "',`Adress_Pharmacien`='" + farm.getAdress_Pharmacien() + "',`NumTel_Pharmacien`='"
                + farm.getNumTel_Pharmacien() + "',"
                + "`MotDePasse_Pharmacien`='" + sh.sha_256encryption(farm.getMotDePasse_Pharmacien()) + "',"
                + "`Email_Pharmacien`='" + farm.getEmail_Pharmacien() + "',"
                + "`Blockfarm` ='" + farm.getBlockfarm() + "',`picturePharm` = '" + farm.getPicturePharm()+ "' WHERE Id_Pharmacien = '" + id + "'  ";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);

            System.out.println("PHARMACIN UPDATED SUCCSEFULY !");
            //  System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String req = "DELETE FROM `pharmacien`  WHERE Id_Pharmacien = '" + id + "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("PHARMACIEN DELETED SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    private ResultSet rs;

    @Override
    public List<Pharmacien> FindAll() {
        List<Pharmacien> list = new ArrayList<>();
        String req = "SELECT * From `pharmacien` ";
        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                Pharmacien e = new Pharmacien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  
                   rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8),rs.getString(9),rs.getInt(10));
                list.add(e);
            }
            System.out.println("PHARM GETED SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    private ResultSet rs2;

    @Override
    public List<Pharmacien> FindById(int id) {
        List <Pharmacien> list = new ArrayList<>();
        String req = "SELECT `Id_Pharmacien`,`nom_Pharmacien`, `Prenom_Pharmacien`, `Adress_Pharmacien`, `NumTel_Pharmacien`, `MotDePasse_Pharmacien`,"
                + "`Email_Pharmacien`, `Blockfarm`,`picturePharm`From `pharmacien` WHERE Id_Pharmacien  = '" + id + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
                Pharmacien e = new Pharmacien(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
                        rs2.getInt(5), rs2.getString(6), rs2.getString(7), rs2.getInt(8),rs2.getString(9));
                list.add(e);
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    } 
      public Pharmacien FindById2(int id) {
      //  List <Pharmacien> list = new ArrayList<>();
      Pharmacien fr = new Pharmacien();
        String req = "SELECT `Id_Pharmacien`,`nom_Pharmacien`, `Prenom_Pharmacien`, `Adress_Pharmacien`, `NumTel_Pharmacien`, `MotDePasse_Pharmacien`,"
                + "`Email_Pharmacien`, `Blockfarm`,`picturePharm`From `pharmacien` WHERE Id_Pharmacien  = '" + id + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
                Pharmacien e = new Pharmacien(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
                        rs2.getInt(5), rs2.getString(6), rs2.getString(7), rs2.getInt(8),rs2.getString(9));
               fr=e;
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return fr;
    }
    

    @Override
    public List searchByName(String name) {
 List <Pharmacien> list = new ArrayList<>();
        String req = "SELECT `Id_Pharmacien`,`nom_Pharmacien`, `Prenom_Pharmacien`, `Adress_Pharmacien`, `NumTel_Pharmacien`, `MotDePasse_Pharmacien`,"
                + "`Email_Pharmacien`, `Blockfarm`,`picturePharm` From `pharmacien` WHERE nom_Pharmacien  = '" + name + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
                Pharmacien e = new Pharmacien(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
                        rs2.getInt(5), rs2.getString(6), rs2.getString(7), rs2.getInt(8), rs2.getString(9));
                list.add(e);
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;    }
     public Pharmacien searchBymail(String name) {
// List <Pharmacien> list = new ArrayList<>();
    Pharmacien fr = new Pharmacien();
        String req = "SELECT `Id_Pharmacien`,`nom_Pharmacien`, `Prenom_Pharmacien`, `Adress_Pharmacien`, `NumTel_Pharmacien`, `MotDePasse_Pharmacien`,"
                + "`Email_Pharmacien`, `Blockfarm`,`picturePharm` From `pharmacien` WHERE Email_Pharmacien  = '" + name + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
               Pharmacien e = new Pharmacien(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
                        rs2.getInt(5), rs2.getString(6), rs2.getString(7), rs2.getInt(8),rs2.getString(9));
               fr=e;
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return fr;    }

   
    @Override
    public void bloqueFARM(int id) {
   String req = "UPDATE `pharmacien` SET  `Blockfarm` = 1  WHERE Id_Pharmacien = '" + id + "'  ";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("PHARMACIN BLOCKED SUCCSEFULY !");
            //  System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }
     public void unbloqueFARM(int id) {
   String req = "UPDATE `pharmacien` SET  `Blockfarm` = 0  WHERE Id_Pharmacien = '" + id + "'  ";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("PHARMACIN BLOCKED SUCCSEFULY !");
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
            Logger.getLogger(MedServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hashtext;
    }

    @Override
    public boolean exist(int id) {
List <Pharmacien> list = new ArrayList<>();
  boolean resut;
        String req = "SELECT `Id_Pharmacien`,`nom_Pharmacien`, `Prenom_Pharmacien`, `Adress_Pharmacien`, `NumTel_Pharmacien`, `MotDePasse_Pharmacien`,"
                + "`Email_Pharmacien`, `Blockfarm` From `pharmacien` WHERE Id_Pharmacien  = '" + id + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
                Pharmacien e = new Pharmacien(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
                        rs2.getInt(5), rs2.getString(6), rs2.getString(7), rs2.getInt(8));
                list.add(e);
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }if (list.size() == 0) {
            System.out.println("PHARM NOT FOUND !");
            resut= false;
        } else {
              System.out.println("PHARM FOUND SUCCSEFULY !");
               resut= true;
        }
        return resut;   }

    @Override
    public boolean isblocked(int id) {
 int blc=0;
  boolean resut;
        String req = "SELECT `Blockfarm` From `pharmacien` WHERE Id_Pharmacien  = '" + id + "' ";
System.out.println(req);
        try {
            Statement st = conx.createStatement();
            rs2 = st.executeQuery(req);
            while (rs2.next()) {
               blc =rs2.getInt(1);
            }
            System.out.println("PARMACIEN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }if (blc == 0) {
            System.out.println("PHARM NOT BLOCKED!");
            resut= false;
        } else {
              System.out.println("PHARM  IS BLOCKED!");
               resut= true;
        }
        return resut;      }

}
