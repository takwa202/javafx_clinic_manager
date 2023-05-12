/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servise;

import entity.Medcin;
import entity.Pharmacien;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.Mail;

/**
 *
 * @author lenovo
 */
public class UserServeses {

    List<Pharmacien> listPh = new ArrayList<>();
    MedServices ms = new MedServices();
    PharmacienServeces FS = new PharmacienServeces();
    Mail send = new Mail();
// si reclamtion > 5 send worning mail , after  rec block user

    // A regular expression
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PASS_WORD_REGEX
            = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", Pattern.CASE_INSENSITIVE);
    /*
     ^ represents starting character of the string.
     (?=.*[0-9]) represents a digit must occur at least once.
     (?=.*[a-z]) represents a lower case alphabet must occur at least once.
     (?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
     (?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
     (?=\\S+$) white spaces don’t allowed in the entire string.
     .{8, 20} represents at least 8 characters and at most 20 characters.
     $ represents the end of the string.
     */

    public boolean controleSaisieRegistermail(String mail) {
        boolean result = false;
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
        return matcher.find();
    }

    public boolean controleSaisiepassword(String pass) {
        boolean result = false;
        Matcher matcher = VALID_PASS_WORD_REGEX.matcher(pass);
        return matcher.find();
    }

    public void analyse_Users_Reclamtions_And_Block() {
        // pour medcin 
        List<Medcin> res = ms.FindAll();
        List<Pharmacien> res2 = FS.FindAll();
        if (res != null) {
            for (Medcin a : res) {
                if (a.getNb_rec_med() > 5 && a.getNb_rec_med() < 10) {
                    send.mail("you recived more then 5 reclamation recently please contact us...", "ALARM", a.getEmail_med());
                   // System.out.println( a.getEmail_med());
                  //  System.out.println("this is the Object of the mail med");
                } else if (a.getNb_rec_med() > 10) {
                    ms.bloqueMed(a.getId_med());
                  //  System.out.println("this is id of medcin blocked = "+ a.getId_med()+"");
                }
                // System.out.println(a.getNb_rec_med());
            }
        }
        if (res2 != null) {
            for (Pharmacien a : res2) {
                if (a.getNbrReclamation() > 5
                        && a.getNbrReclamation() < 10) {
                   send.mail("you recived more then 5 reclamation recently please contact us... Farm", "ALARM2", a.getEmail_Pharmacien());
                      System.out.println( a.getEmail_Pharmacien());
                    //System.out.println( "this is the Object of the mail med");
                } else if (a.getNbrReclamation() > 10) {
                    FS.bloqueFARM(a.getId_Pharmacien());
                  //  System.out.println("pharmatien with id = "+a.getId_Pharmacien()+" is  blocked");
                }
               // System.out.println(a.getNb_rec_med());
            }
        }
  }
    
    
    
    
    
   /* public Medcin bestdocBySpec(String spes) {
        List<Medcin> res = ms.FindAll();
        Medcin med = new Medcin();
           String s3=new String("dsdq");  
        try {
            
            if (res != null) {
                  for (Medcin a : res) {
                      med=a;
                if ( a.getNb_patient()> med.getNb_patient()) {
                    if ( a.getSpeciatilte().equals(s3)) {
                         med=a;
                    }else{
                        System.out.println("no");
                            }
                   
                } 
                // System.out.println(a.getNb_rec_med());
            }}
            
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
        
        

        return med;
    }

    */
}
