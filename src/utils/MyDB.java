/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class MyDB {
     String url= "jdbc:mysql://localhost:3306/tt";
    String user = "root";
    String pwd ="";
   public Connection connection;
    static MyDB instance;
    
    public MyDB(){
        try {
            connection = DriverManager.getConnection(url, user, pwd);
                   System.out.println("Connexion établie");

        } catch (SQLException ex) {
           System.out.println("Erreur de connexion a la base de données");
           System.out.println("************************************");
           System.out.println(ex);
        }
    }
    
    public static MyDB getInstance(){
    if(instance == null){
       instance = new MyDB();
    }
    return instance;
    }
    
  public Connection getConnection(){
   return connection;
    }
}
