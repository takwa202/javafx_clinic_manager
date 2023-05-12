/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entities.Ordonnance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author HP
 */
public class MyConnection {

    public static Object getInstance;

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String url="jdbc:mysql://localhost:3306/tt";
    public String login="root";
    public String pwd="";
    Connection cnx ;
    
    
    public MyConnection(){
        try {
          cnx = DriverManager.getConnection(url, login, pwd);
          System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage()); 
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   // public static ObservableList<Ordonnance>getAllOrdonnance() throws SQLException{
    //  ObservableList<Ordonnance> list = FXCollections.observableArrayList();
        
     //  PreparedStatement ps = cnx.prepareStatement("SELECT * FROM `ordonnance`");
      //  ResultSet rs = executeQuery();
        
        
   // }
    
    public Connection getcnx(){
        return cnx ; 
        
    }

    public Object getCnx() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
