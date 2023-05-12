/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import entity.Interventions;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import servise.InterServices;
import servise.MedServices;
import servise.PtientServices;
import servise.UserServeses;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class InterventientcrudController implements Initializable {

    @FXML
    private TableView<Interventions> tabel;
    @FXML
    private TableColumn< String, Interventions> ID;
    @FXML
    private TableColumn< String, Interventions> NOM;
    @FXML
    private TableColumn< String, Interventions> DATEINTERVENTIEN;
    @FXML
    private TableColumn< String, Interventions> DESCRIPTION;
    @FXML
    private Button search;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button refresh;
    @FXML
    private Button update;
    @FXML
    private TextField searchinput;

    /**
     * Initializes the controller class.
     */
    //var
    ObservableList<Interventions> medlist = FXCollections.observableArrayList();
    InterServices fs = new InterServices();
    List<Interventions> list = new ArrayList<>();
    Interventions intr = new Interventions();
     Medcin med = new Medcin();
   
    UserServeses us = new UserServeses();
    MedServices ms = new MedServices();
    
     Patient pat = new Patient();
    ObservableList<Patient> patlist = FXCollections.observableArrayList();
    PtientServices ps = new PtientServices();
    
    List<Patient> listp = new ArrayList<>();
    @FXML
    private Text idmed;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        
        
        
        
        
        
        
        
        
        
        
        // TODO
    }    
     public void initializeid( String id) {
        idmed.setText(id);
         med = ms.FindById(Integer.parseInt(idmed.getText()));
          medlist.clear();
        list = fs.FindAll(med.getId_med());
        for (Interventions a : list) {
           medlist.add(new Interventions(a.getId_interv(),a.getDate_inter(),a.getDescriptions(), 
                   a.getPastient(),a.getPastient().getNom_patient()));
            //patlist.add(a.getPastient());
        
        }

          //medlist=  FXCollections.observableList(ms.FindAll());
        tabel.setItems(medlist);
      ID.setCellValueFactory(new PropertyValueFactory<>("id_interv"));
        NOM.setCellValueFactory(new PropertyValueFactory<>("patname"));//??>> hetha mn jointure
       DATEINTERVENTIEN.setCellValueFactory(new PropertyValueFactory<>("date_inter"));
       DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
      
        // TODO
        
        // TODO
    }   

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addinter.fxml"));
        try {
            Parent root = loader.load();
            AddinterController controller = loader.getController();
            controller.initializeid(idmed.getText());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MedcinviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @FXML
    private void delete(ActionEvent event) {
         Interventions inter = tabel.getSelectionModel().getSelectedItem();
        fs.delete(inter.getId_interv());
        refresh(event);
    }

    @FXML
    private void refresh(ActionEvent event) {
            medlist.clear();
        list = fs.FindAll(med.getId_med());
        for (Interventions a : list) {
           medlist.add(new Interventions(a.getId_interv(),a.getDate_inter(),a.getDescriptions(), a.getPastient(),a.getPastient().getNom_patient()));
            //patlist.add(a.getPastient());
        
        }

          //medlist=  FXCollections.observableList(ms.FindAll());
        tabel.setItems(medlist);
      ID.setCellValueFactory(new PropertyValueFactory<>("id_interv"));
        NOM.setCellValueFactory(new PropertyValueFactory<>("patname"));//??>> hetha mn jointure
       DATEINTERVENTIEN.setCellValueFactory(new PropertyValueFactory<>("date_inter"));
       DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
      
    }

    @FXML
    private void update(ActionEvent event) {
        //updateinter
          FXMLLoader loader = new FXMLLoader(getClass().getResource("updateinter.fxml"));
        try {
            Parent root = loader.load();
            UpdateinterController controller = loader.getController();
            controller.initializeid(idmed.getText(),tabel.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MedcinviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
