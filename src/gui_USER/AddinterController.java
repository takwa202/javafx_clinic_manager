/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import entity.Interventions;
import entity.Medcin;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import servise.InterServices;
import servise.MedServices;
import servise.UserServeses;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AddinterController implements Initializable {

    @FXML
    private TextField NOM;
    @FXML
    private Button ADD;
    @FXML
    private Text BIRTHDAY;
    @FXML
    private DatePicker date;
    @FXML
    private TextField desc;
    @FXML
    private Text idmed;

    /**
     * Initializes the controller class.
     */
    //var
    Medcin med = new Medcin();
    ObservableList<Medcin> medlist = FXCollections.observableArrayList();
    UserServeses us = new UserServeses();
    MedServices ms = new MedServices();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }   
     public void initializeid( String id) {
        idmed.setText(id);
     
        // TODO
    }   
    //vzar
     InterServices fs = new InterServices();
    List<Interventions> list = new ArrayList<>();
    Interventions intr = new Interventions();
     int currentdoc =1;
    @FXML
    private void ADD(ActionEvent event) {
            med = ms.FindById(Integer.parseInt(idmed.getText()));
        String datePickerValue = date.getValue().toString();
        System.out.println(datePickerValue);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
        date = LocalDate.parse(datePickerValue, dtf);

        Timestamp timestampdate = Timestamp.valueOf(date.atStartOfDay());

        intr.setId_patien(Integer.parseInt(NOM.getText()));
      
        intr.setDescriptions(desc.getText());
        intr.setDate_inter(timestampdate);
     intr.setId_med(med.getId_med());
       
        

        // System.err.println(path);
       System.out.println(intr.toString());
       fs.insert(intr);
            ADD.getScene().getWindow().hide();
    }
    
}
