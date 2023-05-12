/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavauser;

import entity.Interventions;
import entity.Medcin;
import entity.Pharmacien;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import servise.InterServices;
import servise.MedServices;
import servise.PharmacienServeces;
import servise.UserServeses;
import utils.Mail;
import utils.MyDB;
import java.awt.*;
import java.awt.event.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import javafx.scene.control.Alert;

/**
 *
 * @author lenovo
 */
public class ProjetJavaUser {
    /* Medcin(int id_med, String mdp_med, String email_med, Timestamp date_naissance_med,
     int age_med, String adresse_med, String genre_med, String nom_med, String prenom_med,
     int num_tel_med, String photo_med, int nb_rec_med, int nb_patient, Boolean is_Blocked,String spéciatilte*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
      
        
        
       
        
        
        
        
        
        /* try{
    //Obtain only one instance of the SystemTray object
    SystemTray tray = SystemTray.getSystemTray();

    // If you want to create an icon in the system tray to preview
    Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");
    //Alternative (if the icon is on the classpath):
    //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

    TrayIcon trayIcon = new TrayIcon(image, "Java AWT Tray Demo");
    //Let the system resize the image if needed
    trayIcon.setImageAutoSize(true);
    //Set tooltip text for the tray icon
    trayIcon.setToolTip("System tray icon demo");
    tray.add(trayIcon);

    // Display info notification:
    trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.INFO);
    // Error:
    // trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.ERROR);
    // Warning:
    // trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.WARNING);
}catch(Exception ex){
    System.err.print(ex);
}
        
       */ 
        
      //**********************************************************test med *************************************
//InterServices inter = new InterServices();
    // Interventions  intrr = new Interventions(1,3,createdate(2000,11,12),"reformed ");
    // inter.insert(intrr);
     //inter.update(intrr, 1);
   //  inter.delete(9);
   //  inter.searchByPatientName("dxx",1);
//System.out.println( inter.searchByPatientName("dxx",1).toString());
//System.out.print(inter.FindById(1,1).toString());
     //System.out.print(inter.FindById(1,1).toString());
     //int size = inter.FindById(1,1).size();
     //System.out.println(size);
     // Timestamp date = createdate();
     
     
     
        //  MyDB db = new MyDB();
        // Medcin med1 = new Medcin("updated mot de pass","email",date,11,"adree","male","ali","prenommed",555555,"photomed","specialier");
       //  MedServices ms = new MedServices();
         
        // ms.bloqueMed(1);
        // ms.isblocked(1);
         
        // ms.insert(med1);
        //  ms.update(med1,1);
        //ms.delete(10);
         /*List <Medcin> res = ms.FindAll();
         Mail send = new Mail();
        
         if (res != null){
         for( Medcin a: res){
             if( a.getNb_rec_med()>5 &&  a.getNb_rec_med() <10 ){
              send.mail("you recived more then 5 reclamation recently please contact us...", "ALARM", a.getEmail_med());
             }else if(a.getNb_rec_med()>10){
             ms.bloqueMed(a.getId_med());
             } 
            // System.out.println(a.getNb_rec_med());
         }
         
         }*/
         UserServeses us = new UserServeses();
      //  us.analyse_Users_Reclamtions_And_Block();
         
   //System.out.println(us.controleSaisiepassword("99AAa@151"));
         
        // System.out.println("");
        // String res = ms.hashingFunction("hhhh");
        //String res2 = ms.hashingFunction("hhhh");
        // System.out.println("my hashed code is");
        // System.out.println(res);
        //System.out.println(res2);
     // List <Medcin> res = ms.FindById(1);
      //  searchlist(res);
        //System.out.println(res.get(0).getId_med());
        // affichlist(res);
        //**********************************************************test pharm ************************************* 
       // Pharmacien farm = new Pharmacien("NF33", "p1", "adress", 155551, "passs", "mail", 0);
        // System.out.println(farm);
     //  PharmacienServeces fs = new PharmacienServeces();
      // fs.bloqueFARM(2);
       // fs.insert(farm);
       // fs.update(farm, 4);
        //fs.delete(1);
       // List <Pharmacien>  res = fs.FindAll();
      //  List <Pharmacien>  res = fs.FindById(5);
        //ArrayList al1 = new ArrayList();
      //  al1 = (ArrayList) res;
       // System.out.println(res.get(0).getId_Pharmacien());
       //  System.out.println(res.get(0).getId_Pharmacien());
        Mail send = new Mail();
      send.mail("hello", "test","takwalassoued066@gmail.com");
        
    



    }

    // about time

    public static void searchlist(List<Medcin> med) {
        // int i = 0;
        for (int j = 0; j < med.size(); j++) {
            if (med.get(j).getId_med() == 1) {
                System.out.println("foundit");
            } else {
                System.out.println("notfoundit");
            }

        }

    }
   /* public static void addimage (String url){
     InputStream input = ClassLoader.getResourceAsStream(url);
    }
*/
    public static void affichlist(List<Medcin> med) {
        // int i = 0;
        for (int j = 0; j < med.size(); j++) {

            System.out.println(med.get(j).getId_med());

        }

    }
 //  Date date = new Date(1996-1900, 11, 12);
    public static Timestamp createdate(int y,int m,int j) {
         
        Timestamp date2 = new Timestamp(y - 1900, m - 1, j, 4, 0, 0, 0);
      
        return date2;
    }

}
