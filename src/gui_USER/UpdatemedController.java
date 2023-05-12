/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import com.sun.xml.internal.bind.v2.model.core.ID;
import entity.Interventions;
import entity.Medcin;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import servise.MedServices;
import servise.UserServeses;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class UpdatemedController implements Initializable {

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
    private Button update;
    @FXML
    private ChoiceBox<String> GENDER;
    @FXML
    private TextField PASSWORD;
    @FXML
    private Text BIRTHDAY;
    @FXML
    private Text thefiletitle;
    @FXML
    private Button PIC;
    @FXML
    private Text BIRTHDAY1;
    @FXML
    private ChoiceBox <String> speciality;
    @FXML
    private DatePicker date;
    @FXML
    private Spinner<Integer> AGE;
    @FXML
    private Text id;
    //all var
    private String[] gender = {"femme", "homme"};
    private String[] SPECIALITY = {"SPE1", "SPE2"};
    Medcin med = new Medcin();
    ObservableList<Medcin> medlist = FXCollections.observableArrayList();
    UserServeses us = new UserServeses();
    MedServices ms = new MedServices();
    List<Medcin> list = new ArrayList<>();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(26, 100);
        valueFactory.setValue(26);
        AGE.setValueFactory(valueFactory);
        GENDER.getItems().addAll(gender);
        speciality.getItems().addAll(SPECIALITY);
      
    }

    public void initializedata(Medcin med) {
       // String dateAsString = "28/12/2002";
       int id2 = med.getId_med();
     id.setText(Integer.toString(id2));
     Medcin medcin = ms.FindById(id2);
       System.out.println(medcin);
        //name.setText(medcin.getNom_med());
        NOM.setText(medcin.getNom_med());
        PN.setText(medcin.getPrenom_med());
        PHONE.setText(Integer.toString(medcin.getNum_tel_med()));
        ADRESS.setText(medcin.getAdresse_med());
        MAIL.setText(medcin.getEmail_med());
        GENDER.setValue(medcin.getGenre_med());
        speciality.setValue(medcin.getSpeciatilte());
        AGE.getValueFactory().setValue(medcin.getAge_med());
        PASSWORD.setText(medcin.getMdp_med());
      //  DatePicker dateP = new DatePicker(LocalDate. of(2014, 10, 8));
         Date date2 = new Date(medcin.getDate_naissance_med().getTime());/// tilestamp to date !
         int jr = date2.getDay();
         int y = date2.getYear();
         int m = date2.getMonth();
   date.setValue(LocalDate. of(y, m, jr));
     

    }

    @FXML
    private void update(ActionEvent event) {
        int idd =  Integer.parseInt(id.getText());

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
        if (speciality.getValue() == null) {
            a10.setContentText("add speciality !");
            a10.show();
            System.out.println("speciality error");
            result = false;
            speciality.setStyle("-fx-border-color:#ff0000");
        }
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
        if (AGE.getValue() == 26) {
            a4.setContentText("add your age !");
            a4.show();
            System.out.println("no age");
            result = false;
            AGE.setStyle("-fx-border-color:#ff0000");

        }
        if (us.controleSaisiepassword(PASSWORD.getText()) == false) {
            a5.setContentText("password not nalid ! add new password with ... ");
            a5.show();
            System.out.println("pass error");

            result = false;
            PASSWORD.setStyle("-fx-border-color:#ff0000");

        }

        if (GENDER.getValue() == null) {
            a7.setContentText("add gender !");
            a7.show();
            System.out.println("gender error");
            result = false;
            GENDER.setStyle("-fx-border-color:#ff0000");
        }
        if (date.getValue() == null) {
            a6.setContentText("add date !");
            a6.show();
            System.out.println("date error");
            result = false;
            date.setStyle("-fx-border-color:#ff0000");
        }
        if (PHONE.getText().isEmpty()) {
            a8.setContentText("add phone number !");
            a8.show();
            System.out.println("phone error");
            result = false;
            PHONE.setStyle("-fx-border-color:#ff0000");
        }
        if (thefiletitle.getText().isEmpty()) {
            a9.setContentText("add pic !");
            a9.show();
            System.out.println("pic error");
            result = false;
            PIC.setStyle("-fx-border-color:#ff0000");
        }
        if (result == true) {
             String datePickerValue = date.getValue().toString();
        System.out.println(datePickerValue);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
       
        date = LocalDate.parse(datePickerValue, dtf).plusYears(1900);

        Timestamp timestampdate = Timestamp.valueOf(date.atStartOfDay());

            med.setNom_med(NOM.getText());
            med.setPrenom_med(PN.getText());
            med.setAdresse_med(ADRESS.getText());
            med.setEmail_med(MAIL.getText());
            med.setAge_med(AGE.getValue());
            med.setGenre_med(GENDER.getValue());
            med.setMdp_med(PASSWORD.getText());
            med.setNum_tel_med(Integer.parseInt(PHONE.getText()));
            med.setPhoto_med(thefiletitle.getText());
            med.setDate_naissance_med(timestampdate);
            med.setIs_Blocked(0);
            med.setNb_patient(0);
            med.setSpeciatilte(speciality.getValue());

            // System.err.println(path);
            // System.out.println(thefiletitle.getText());
            ms.update(med,idd);
            update.getScene().getWindow().hide();
            //PIC();
        } else {
            System.out.println("CANT ADD DOC ");
        }
    }

    @FXML
    private void PIC(ActionEvent event) throws IOException {
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
