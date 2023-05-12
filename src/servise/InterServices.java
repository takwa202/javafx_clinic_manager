/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servise;

import InServise.InterInterServeses;
import InServise.InterPharmServeses;
import entity.Interventions;
import entity.Medcin;
import entity.Patient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author lenovo
 */
public class InterServices implements InterInterServeses<Interventions> {

    Connection conx;

    //c'est un constructeur !!
    public InterServices() {
        conx = MyDB.getInstance().getConnection();
        //Blob blob = conx.createBlob();
    }

    @Override
    public void insert(Interventions inter) {

        String req = "INSERT INTO `intervention`(`id_med`,`id_patien`,`date_inter`,`descriptions`)"
                + "values('" + inter.getId_med() + "','" + inter.getId_patien() + "','" + inter.getDate_inter() + "','" + inter.getDescriptions() + "')";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            // System.out.println(med); 
            //   System.out.println(req); 
            System.out.println("INTERVENTION  ADDED SUCCSEFULY !");
            //System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private ResultSet rs;

    @Override
    public List<Interventions> FindById(int idmed ,int idpat) {
      
        List<Interventions> list = new ArrayList<>();
        String req = "SELECT`nom_med`,`prenom_med`,"
                + "`speciatilte`,`Nom_patient`,`Prenom_patient`,`date_inter`,`descriptions`"
                + " FROM`intervention` JOIN `medecin` ON intervention.id_med=medecin.id_med JOIN `patient`"
                + "ON intervention.id_patien=patient.Id_patient WHERE intervention.id_med = " + idm + " AND intervention.id_patien = " + idpat + " ";
        // 

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {

               // System.out.println("there is data");
                Patient pat = new Patient();
                Medcin med = new Medcin();
                Interventions inter = new Interventions();
                med.setNom_med(rs.getString("nom_med"));
                med.setPrenom_med(rs.getString("prenom_med"));
                med.setSpeciatilte(rs.getString("speciatilte"));
                pat.setNom_patient(rs.getString("Nom_patient"));
                pat.setPrenom_patient(rs.getString("Prenom_patient"));
                inter.setDate_inter(rs.getTimestamp("date_inter"));
                inter.setDescriptions(rs.getString("descriptions"));
                inter.setMedcin(med);
                inter.setPastient(pat);
                list.add(inter);
            }
            System.out.println("INTERV BY ID FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    private static int idm = 1;

    @Override
    //BYIDMED THE CUURNT USER
    public List<Interventions> FindAll(int idm) {

        List<Interventions> list = new ArrayList<>();
        String req = "SELECT `id_interv`,`nom_med`,`prenom_med`,"
                + "`speciatilte`,`Nom_patient`,`Prenom_patient`,`date_inter`,`descriptions`"
                + " FROM`intervention` JOIN `medecin` ON intervention.id_med=medecin.id_med JOIN `patient`"
                + "ON intervention.id_patien=patient.Id_patient WHERE intervention.id_med = " + idm + "   ";
        // AND intervention.id_patien = 1

        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {

                System.out.println("there is data");
                Patient pat = new Patient();
                Medcin med = new Medcin();
                Interventions inter = new Interventions();
                med.setNom_med(rs.getString("nom_med"));
                med.setPrenom_med(rs.getString("prenom_med"));
                med.setSpeciatilte(rs.getString("speciatilte"));
                pat.setNom_patient(rs.getString("Nom_patient"));
                pat.setPrenom_patient(rs.getString("Prenom_patient"));
                inter.setDate_inter(rs.getTimestamp("date_inter"));
                inter.setDescriptions(rs.getString("descriptions"));
                inter.setId_interv(rs.getInt("id_interv"));
                inter.setMedcin(med);
                inter.setPastient(pat);
                list.add(inter);
            }
            System.out.println("MEDCIN FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void update(Interventions inter, int id) {
 String req = "UPDATE `intervention` SET `id_med`='" + inter.getId_patien() + "',`id_patien`='" + inter.getId_patien() + "'"
         + ",`date_inter`='" + inter.getDate_inter() + "',`descriptions`='" + inter.getDescriptions() + "'"
                + "WHERE id_interv = '" + id+ "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            // System.out.println(med); 
            //   System.out.println(req); 
            System.out.println("INTERVENTION  Updated SUCCSEFULY !");
            //System.out.println(med); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void delete(int id) {
String req = "DELETE FROM `intervention`  WHERE id_interv = '" + id+ "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("INTER DELETED SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }
     public void delete2(int id) {
String req = "DELETE FROM `intervention`  WHERE id_patien  = '" + id+ "'";

        try {
            Statement st = conx.createStatement();
            st.executeUpdate(req);
            System.out.println("INTER DELETED SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }

    @Override
    public List searchByPatientName(String name,int idM) {

        List<Interventions> list = new ArrayList<>();
        String req = "SELECT`nom_med`,`prenom_med`,"
                + "`speciatilte`,`Nom_patient`,`Prenom_patient`,`date_inter`,`descriptions`"
                + " FROM`intervention` JOIN `medecin` ON intervention.id_med=medecin.id_med JOIN `patient`"
                + "ON intervention.id_patien=patient.Id_patient WHERE intervention.id_med = " + idm +" AND patient.Nom_patient = '" + name + "' ";
        // 

        
        
       

        
        
        try {
            Statement st = conx.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {

               // System.out.println("there is data");
                Patient pat = new Patient();
                Medcin med = new Medcin();
                Interventions inter = new Interventions();
                med.setNom_med(rs.getString("nom_med"));
                med.setPrenom_med(rs.getString("prenom_med"));
                med.setSpeciatilte(rs.getString("spéciatilte"));
                pat.setNom_patient(rs.getString("Nom_patient"));
                pat.setPrenom_patient(rs.getString("Prenom_patient"));
                inter.setDate_inter(rs.getTimestamp("date_inter"));
                inter.setDescriptions(rs.getString("descriptions"));
                inter.setMedcin(med);
                inter.setPastient(pat);
                list.add(inter);
            }
            System.out.println("INTERV BY ID FOUND SUCCSEFULY !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;    }

   
   /* public List searchBySpeciality(String input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
