/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprojecttabibi;
import Entities.LettreConfidentielle;
import Entities.Ordonnance;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import services.CRUDLettre;
import services.CRUDOrdonnance;
import utils.Mail;
import utils.MyConnection;

/**
 *
 * @author HP
 */
public class MyProjectTabibi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        
        // TODO code application logic here
   MyConnection mc= new MyConnection(); //pour tester la connexion 
    Timestamp date = createdate();
   
  
  Ordonnance ord ; 
  ord = new Ordonnance("29 octobre","validation","souhaila kharbech",1); 
  CRUDOrdonnance od= new CRUDOrdonnance();
  //od.ajouterOrdonnance(ord);
    // od.supprimerOrdonnance(29);
     //od.modifierOrdonnance(ord, 16);
     // List list =  od.FindById(16);    //recherche 
     // System.out.println(list);
     
       //test affichage
    //   List <Ordonnance>  res = od.afficherOrdonnance();
      //affichlist(res); 
       //test modfication 
      // ord = new Ordonnance ( "27 juillet","trois fois par jour","kkkkk");
       //od.modifierOrdonnance(ord,29);

      
  LettreConfidentielle lc ;
  lc = new LettreConfidentielle (date,1,"suivie4SE3","mohamedmohamed",15);
  CRUDLettre l = new CRUDLettre() ;
   //  l.ajouterLettreConfidentielle(lc);
      
      // l.modifierLettreConfidentielle(lc,6);
       List<LettreConfidentielle> re = l.afficherLettreConfidentielle();
    // affichlist1(re);
     System.out.println(l.afficherLettreConfidentielle().toString());
      //l.supprimerLettre(6);
    //afficher une lettre
  
    
    //recherche :
  // List list =  l.FindById(2);//recherche
  //List list =  l.FindByName("doliprane");
   // System.out.println(list);
 
   
        //test Mailling
      //  Mail send = new Mail(); 
        //send.mail("intégration","test","souhaila.kharbech@esprit.tn");
      
      
      
   
     
       
       
  
    


  

  }
private static void affichlist(List<Ordonnance> ord) {
        for(int j=0; j<ord.size() ; j++){
            System.out.println(ord.get(j).getIdOrdonnance());
            System.out.println(ord.get(j).getDateAjout());
            System.out.println(ord.get(j).getModeUtilisation());
            System.out.println(ord.get(j).getNomPrenomPatient());
            System.out.println(ord.get(j).getProduit().getNomProduit()); }}



 private static Timestamp createdate() {
         Date date = new Date(1996-1900, 11, 12);  
      Timestamp date2 =  new Timestamp(2022-1900,1-1,29,4,0,0,0) ;
      System.out.println(date);
      System.out.println(date2);
        return date2;
        
    }
private static void affichlist1(List<LettreConfidentielle> l) {
        for(int j=0; j<l.size() ; j++){
            System.out.println(l.get(j).getIdConf());
            System.out.println(l.get(j).getDate());
           // System.out.println(l.get(j).getMedcin().getId_med());
            System.out.println(l.get(j).getMedcin().getNom_med());
            System.out.println(l.get(j).getMedcin().getPrenom_med());
            System.out.println(l.get(j).getDescription());
            System.out.println(l.get(j).getSignature());
            System.out.println(l.get(j).getOrdonnance().getNomPrenomPatient());
             }} 
            
             
} 


        
       
     
   
   
   
   
    
