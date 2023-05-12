/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import entity.Interventions;
import entity.Medcin;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import servise.MedServices;
import servise.UserServeses;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class UpdateinterController implements Initializable {

    @FXML
    private Text idmed;

    /**
     * Initializes the controller class.
     */
    //var
    Interventions inter = new Interventions();
     Medcin med = new Medcin();
    ObservableList<Medcin> medlist = FXCollections.observableArrayList();
    UserServeses us = new UserServeses();
    MedServices ms = new MedServices();
    @FXML
    private TextField desc;
    @FXML
    private Button update;
    @FXML
    private Text BIRTHDAY;
    @FXML
    private DatePicker date;
    @FXML
    private Text idinter;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  
     public void initializeid( String id, Interventions inter) {
         
        idmed.setText(id);
         med = ms.FindById(Integer.parseInt(idmed.getText()));
     
    /*  Date date2 = new Date(inter.getDate_inter().getTime());/// tilestamp to date !
         int jr = date2.getDay();
         int y = date2.getYear();
         int m = date2.getMonth();
      date.setValue(LocalDate.of(y, m, jr));*/
      desc.setText(inter.getDescriptions());
         
        // TODO
    }   

    @FXML
    private void update(ActionEvent event) {
    }
    
}
