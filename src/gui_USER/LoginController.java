/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import entity.Medcin;
import entity.Patient;
import entity.Pharmacien;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import servise.MedServices;
import servise.PharmacienServeces;
import servise.PtientServices;
import servise.UserServeses;
import utils.ShaUtils;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class LoginController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private Text signeup;
    @FXML
    private Button login;
    @FXML
    private PasswordField pass;
    @FXML
    private ChoiceBox<String> type;

    /**
     * Initializes the controller class.
     */
    //var
    ShaUtils sh = new ShaUtils();

    private String[] typeslist = {"medcin", "pharmacien", "pacient"};
    UserServeses us = new UserServeses();
    PtientServices ps = new PtientServices();
    MedServices ms = new MedServices();
    Medcin med = new Medcin();
        Pharmacien far = new Pharmacien();
        PharmacienServeces fs = new PharmacienServeces();
        Patient pas = new Patient();
        PtientServices pcc = new  PtientServices();

    List<Medcin> liste = new ArrayList<Medcin>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.getItems().addAll(typeslist);
    }

    @FXML
    private void signeup(MouseEvent event) {
         try {
                Parent root = FXMLLoader.load(getClass().getResource("AddPat.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            signeup.getScene().getWindow().hide();
        
        

    }

    @FXML
    private void login(ActionEvent event) {
        Alert al = new Alert(Alert.AlertType.WARNING);
        Alert al2 = new Alert(Alert.AlertType.WARNING);

        boolean testpass = false;

        String mailinput = mail.getText();
        String paassword = sh.sha_256encryption(pass.getText());
        //String paassword =pass.getText();
        /**
         * ******************* admin?  *********************************
         */
        if (mailinput.equals("root") && pass.getText().equals("root")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("admingui.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            login.getScene().getWindow().hide();
        } /**
         * ******************* med?   *********************************
         */
           else if (type.getValue().equals("medcin")) {
 //System.out.println(mailinput);
           med = ms.FindBymail2(mailinput);
           //System.out.println(med.toString());
           if( med.getEmail_med() == null ||  med.getEmail_med() == ""  ) {   
               al.setContentText(" verfy your adress  !");
                al.show();
                }else

            if (med.getMdp_med().equals(paassword)) {
               // System.out.println(med.getMdp_med().equals(paassword));
               // System.out.println(med.getMdp_med());
              //  System.out.println(paassword);
                
                
                 /*****/
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("acceillemed.fxml"));
        try {
           
            //System.out.println(String.valueOf(med.getId_med()));
            // System.out.println("hiii");
            Parent root = loader.load();
           AcceillemedController controller = loader.getController();
           controller.initializeid(String.valueOf(med.getId_med()));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MedcinviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
            login.getScene().getWindow().hide();

            } else{
                al.setContentText(" verfy your password !");
                 al.show();
            
            
            }

                   }
        
        
        
        
        //*******************************pharm**********
     
        
        /***
         * 
         */
        else if (type.getValue().equals("pharmacien")) {
 //System.out.println(mailinput); far = fs.searchBymail(mailinput);
           // System.out.println(med.toString());
         
               // System.out.println(med.getMdp_med().equals(paassword));
               // System.out.println(med.getMdp_med());
               // System.out.println(paassword);
                
                try {
                Parent root = FXMLLoader.load(getClass().getResource("acceilfarm.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            login.getScene().getWindow().hide();

            } 
            
            

                   
        
        
         
        /*********************************    patient**************************************/
         else if (type.getValue().equals("pacient")) {
 //System.out.println(mailinput);
             pas = pcc.FindBymail(mailinput);
           System.out.println(pas.toString());
           if( pas.getEmail_patient() == null ||  pas.getEmail_patient() == ""  ) {   
               al.setContentText(" verfy your adress  !");
                al.show();
                }else

            if (pas.getMotDePassel_patient().equals(paassword)) {
               // System.out.println(med.getMdp_med().equals(paassword));
               // System.out.println(med.getMdp_med());
               // System.out.println(paassword);
                
                try {
                Parent root = FXMLLoader.load(getClass().getResource("acceilpat.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            login.getScene().getWindow().hide();

            } else{
                al.setContentText(" verfy your password !");
                 al.show();
            
            
            }

                   }
        
    }
    









}
