/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import entity.Patient;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import servise.PtientServices;
import servise.UserServeses;
import utils.ShaUtils;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AddPatController implements Initializable {

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
    private  ChoiceBox<String> GENDER;
    @FXML
    private TextField PASSWORD;
    @FXML
    private Text thefiletitle;
    @FXML
    private Button PIC;
    @FXML
    private Text BIRTHDAY1;
    private DatePicker date;
   
    
    
    //var
    ShaUtils sh = new ShaUtils();

    UserServeses us =new UserServeses();
     private String[] gender = {"femme", "homme"};
    Patient med = new Patient();
    ObservableList<Patient> medlist = FXCollections.observableArrayList();
    PtientServices ps = new PtientServices();
    
    List<Patient> list = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        GENDER.getItems().addAll(gender);
    }    

    @FXML
    private void ADD(ActionEvent event) {
          Alert a = new Alert(Alert.AlertType.WARNING);
        Alert a1 = new Alert(Alert.AlertType.WARNING);
        Alert a2 = new Alert(Alert.AlertType.WARNING);
        Alert a3 = new Alert(Alert.AlertType.WARNING);
        Alert a4 = new Alert(Alert.AlertType.WARNING);
        Alert a5 = new Alert(Alert.AlertType.WARNING);
        Alert a6 = new Alert(Alert.AlertType.WARNING);
                  Alert a7 = new Alert(Alert.AlertType.WARNING);
                    Alert a8 = new Alert(Alert.AlertType.WARNING);
                      Alert a9 = new Alert(Alert.AlertType.WARNING);
                      Alert a10 = new Alert(Alert.AlertType.WARNING);
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
        
                if (GENDER.getValue()== null) {
            a7.setContentText("add gender !");
            a7.show();
            System.out.println("gender error");
            result = false;
            GENDER.setStyle("-fx-border-color:#ff0000");
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
       

        med.setNom_patient(NOM.getText());
        med.setPrenom_patient(PN.getText());
        med.setAdress_patient(ADRESS.getText());
        med.setEmail_patient(MAIL.getText());
    
        med.setGendre_patient(GENDER.getValue());
        med.setMotDePassel_patient(PASSWORD.getText());
        med.setNumTel_patient(Integer.parseInt(PHONE.getText()));
        med.setImage(thefiletitle.getText());
        
        med.setIsblokedpatient(0);
   

        // System.err.println(path);
        // System.out.println(thefiletitle.getText());
        ps.insert(med);
        try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            ADD.getScene().getWindow().hide();
          
        //PIC();
}else {
    System.out.println("CANT ADD DOC ");
}

 

    }

    @FXML
    private void PIC(ActionEvent event)  throws IOException {
        // Image img2 = new Image ("");
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter exxensionFilterPNG = new FileChooser.ExtensionFilter("JPG files(*.png", "*.PNG");
        FileChooser.ExtensionFilter exxensionFilterJPG = new FileChooser.ExtensionFilter("JPG files(*.jpg", "*.JPG");
        chooser.getExtensionFilters().addAll(exxensionFilterJPG, exxensionFilterPNG);
        File file = chooser.showOpenDialog(null);
        //  BufferedImage ufferedImag = ImageIO.read(file);
        //Afichage
        //Image image = SwingFXUtils.toFXImage(ufferedImag, null);
        //  img.setImage(image);
        //file. getName()  >> get file name "Sring"
        //file.getPath()>> get file path "String"
        //to make copy of file ain another file

        Path temp = Files.copy(Paths.get(file.getPath()), Paths.get("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\ProjetJavaUser\\src\\resources\\" + file.getName() + ""));
        thefiletitle.setText(file.getName());

    }
    
    }
    

