  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Interventions;
import entity.Medcin;
import entity.Patient;
import entity.Pharmacien;
import java.sql.Timestamp;
import servise.InterServices;
import servise.MedServices;
import servise.PharmacienServeces;
import servise.PtientServices;
import servise.UserServeses;
import utils.ShaUtils;

/**
 *
 * @author lenovo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * ************************* test pharmacien  *******************************************
         */
        //sha256
      //  Pharmacien ph = new Pharmacien("bonjour2", "p1", "adress", 155551, "passs", "mail", 0);
       // PharmacienServeces fs = new PharmacienServeces();
       //fs.insert(ph);
       // fs.delete(12);
        //fs.update(ph, 12);
        //System.out.println(fs.FindAll().toString());
       //System.out.println(fs.FindById(12).toString());
       // fs.bloqueFARM(1);
      // System.out.println(fs.hashingFunction("unmotdepasse"));
        //System.out.println(fs.exist(5));
         /**
         * ************************* test med  *******************************************
         */
      //  Timestamp date =createdate(2000,1,1);
      //   Medcin med1 = new Medcin("updated mot de pass","email",date,11,"adree","male","ali","prenommed",555555,"photomed","specialier");
        MedServices ms = new MedServices();
        
       // System.out.println(ms.FindBymail2("llll").toString());
        //ms.insert(med1);
        //ms.delete(3);
        //ms.update(med1,1);
       //System.out.println( ms.FindAll().toString());
       // System.out.println( ms.FindById(100).toString());
        //ms.bloqueMed(1);
        //System.out.println(ms.exist(1));
        //System.out.println(ms.isblocked(1));
       // System.out.println(ms.searchByName("ali"));
       // System.out.println(ms.searchBySpeciality(""));
        /**
         * ************************* test inter  *******************************************
         */
        // InterServices inter = new InterServices();
        // Interventions  intrO = new Interventions(3,1,createdate(2000,11,12),"chirurgie");
        //  inter.insert(intrO);
        // inter.update(intrO,12);
        //  inter.delete(12); 
        //System.out.println(ms.searchBySpeciality(""));
        //  System.out.println(inter.FindAll(3));
        // System.out.println(inter.FindById(1,1));
        // System.out.println(inter.searchByPatientName("dxx", 1));
        // System.out.println();
        /**
         * ************************* test metier  *******************************************
         */
        //(onclik ...)
        //UserServeses us = new UserServeses();
        // us.analyse_Users_Reclamtions_And_Block();
        //System.out.println(us.controleSaisieRegistermail(""));
        // System.out.println(us.controleSaisiepassword(""));
        /*************************** still working on********************************/
        //System.out.println(us.bestdocBySpec("specialier"));
        /****************************************test patient
         *
         */
        //Patient Patient = new Patient("bonjour2", "p1", "adress", "gfg", 41651165,"passs", 33,"f", 0);
        PtientServices ps = new PtientServices();
      // ps.insert(Patient);
       //ps.insert(Patient);
        //ps.delete(1);
        //ps.update(Patient,4);
       // System.out.println(ps.FindAll().toString());
       System.out.println(ps.FindBymail("pat@gmail.com").toString());
      // ps.bloquePAS(3);
      // ps.unbloqueFARM(3);
     // // System.out.println(fs.hashingFunction("unmotdepasse"));
        //System.out.println(fs.exist(5));
         /**/
       //  ShaUtils sh = new ShaUtils();
      //  System.out.println(sh.sha_256encryption("yguy"));
      //  System.out.println(sh.sha_256encryption("yguy"));
              //  System.out.println(sh.sha_256encryption("yjioguy"));

    }

    
    
    
    
    
    
    
    
    
    
    
      public static Timestamp createdate(int y,int m,int j) {
         
        Timestamp date2 = new Timestamp(y - 1900, m - 1, j, 4, 0, 0, 0);
      
        return date2;
    }

}
