/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import entity.Medcin;
import entity.Pharmacien;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import servise.MedServices;
import servise.PharmacienServeces;
import servise.UserServeses;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AddFARMController implements Initializable {

    @FXML
    private TextField PHONE;
    @FXML
    private TextField PN;
    @FXML
    private TextField NOM;
    @FXML
    private TextField ADRESS;
    @FXML
    private TextField MAIL;
    @FXML
    private Button ADD;
    @FXML
    private TextField PASSWORD;
    @FXML
    private Text thefiletitle;
    @FXML
    private Button PIC;
    @FXML
    private Text BIRTHDAY1;
    
    //******INIT VAR
    Pharmacien far = new Pharmacien();
    ObservableList<Pharmacien> medlist = FXCollections.observableArrayList();
    UserServeses us = new UserServeses();
    PharmacienServeces Fs = new PharmacienServeces();
    List<Pharmacien> list = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ADD(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        Alert a1 = new Alert(Alert.AlertType.WARNING);
        Alert a2 = new Alert(Alert.AlertType.WARNING);
        Alert a3 = new Alert(Alert.AlertType.WARNING);
        Alert a5 = new Alert(Alert.AlertType.WARNING);
        Alert a8 = new Alert(Alert.AlertType.WARNING);
        Alert a9 = new Alert(Alert.AlertType.WARNING);
                     
        Boolean result = true;
         
        if (NOM.getText().isEmpty()) {
            a.setContentText("add name !");
            a.show();
            System.out.println("no name");
            result = false;
            NOM.setStyle("-fx-border-color:#ff0000");

        }
        if (PN.getText().isEmpty()) {
            a1.setContentText("add first name !");
            a1.show();
            System.out.println("no pname");
            result = false;
            PN.setStyle("-fx-border-color:#ff0000");

        }
        if (ADRESS.getText().isEmpty()) {
            a2.setContentText("add adress !");
            a2.show();
            System.out.println("no adress");
            result = false;
            ADRESS.setStyle("-fx-border-color:#ff0000");

        }
        if (us.controleSaisieRegistermail(MAIL.getText()) == false) {
            a3.setContentText("add a rreal mail ! ");
            a3.show();
            System.out.println("no mail");
            result = false;
            MAIL.setStyle("-fx-border-color:#ff0000");

        }
       
        if (us.controleSaisiepassword(PASSWORD.getText()) == false) {
            a5.setContentText("password not nalid ! add new password with ... ");
            a5.show();
            System.out.println("pass error");

            result = false;
            PASSWORD.setStyle("-fx-border-color:#ff0000");

        }
        
                
       
           if (PHONE.getText().isEmpty() ) {
            a8.setContentText("add phone number !");
            a8.show();
            System.out.println("phone error");
            result = false;
            PHONE.setStyle("-fx-border-color:#ff0000");
        }
           if(thefiletitle.getText().isEmpty()){
            a9.setContentText("add pic !");
            a9.show();
             System.out.println("pic error");
            result = false;
            PIC.setStyle("-fx-border-color:#ff0000");
           }
if(result == true){
        

        far.setNom_Pharmacien(NOM.getText());
        far.setPrenom_Pharmacien(PN.getText());
        far.setAdress_Pharmacien(ADRESS.getText());
        far.setEmail_Pharmacien(MAIL.getText());
        far.setMotDePasse_Pharmacien(PASSWORD.getText());
        far.setNumTel_Pharmacien(Integer.parseInt(PHONE.getText()));
        far.setPicturePharm(thefiletitle.getText());
        far.setBlockfarm(0);
       

        // System.err.println(path);
        // System.out.println(thefiletitle.getText());
        Fs.insert(far);
            ADD.getScene().getWindow().hide();
        //PIC();
}else {
    System.out.println("CANT ADD DOC ");
}
 
      
    }

    @FXML
    private void PIC(ActionEvent event)throws IOException {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter exxensionFilterPNG = new FileChooser.ExtensionFilter("JPG files(*.png", "*.PNG");
        FileChooser.ExtensionFilter exxensionFilterJPG = new FileChooser.ExtensionFilter("JPG files(*.jpg", "*.JPG");
        chooser.getExtensionFilters().addAll(exxensionFilterJPG, exxensionFilterPNG);
        File file = chooser.showOpenDialog(null);
        Path temp = Files.copy(Paths.get(file.getPath()), Paths.get("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\ProjetJavaUser\\src\\resources\\" + file.getName() + ""));
        thefiletitle.setText(file.getName());
    }
    
}
