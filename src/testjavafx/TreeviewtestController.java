/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavafx;

import entity.Medcin;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import servise.MedServices;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class TreeviewtestController implements Initializable {

    List<Medcin> list = new ArrayList<>();
    @FXML
    private TableView<Medcin> TABLE;
    @FXML
    private TableColumn<String, Medcin> ID;
    @FXML
    private TableColumn<String, Medcin> NAME;
    @FXML
    private TableColumn<String, Medcin> PRENOM;
    @FXML
    private TableColumn<String, Medcin> AGE;
    @FXML
    private TableColumn<String, Medcin> EDIT;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button refrech;
    ObservableList<Medcin> medlist = FXCollections.observableArrayList();
    MedServices ms = new MedServices();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         medlist.clear();
        list = ms.FindAll();
        for (Medcin a : list) {
            medlist.add(new Medcin(a.getId_med(), a.getAge_med(), a.getAdresse_med(), a.getNom_med(), a.getPrenom_med()));
        }

        //   medlist=  FXCollections.observableList(ms.FindAll());
        TABLE.setItems(medlist);
        ID.setCellValueFactory(new PropertyValueFactory<>("id_med"));
        NAME.setCellValueFactory(new PropertyValueFactory<>("nom_med"));
        PRENOM.setCellValueFactory(new PropertyValueFactory<>("prenom_med"));
        AGE.setCellValueFactory(new PropertyValueFactory<>("adresse_med"));
        EDIT.setCellValueFactory(new PropertyValueFactory<>("age_med"));

    }

    @FXML
    private void add() {
      
        try {
           Parent  root = FXMLLoader.load(getClass().getResource("/testjavafx/testc.fxml"));
            Scene scene = new Scene(root);
           Stage stage = new Stage();
             stage.setScene(scene);
              stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void update(ActionEvent event) {
       //  medlist.clear();
       // list = ms.FindAll();
        Medcin person = TABLE.getSelectionModel().getSelectedItem();
         System.out.println(person.getId_med());
         ms.delete(person.getId_med());
        
    }

    @FXML
    private void refrech(ActionEvent event) {
        medlist.clear();
        list = ms.FindAll();
        for (Medcin a : list) {
            medlist.add(new Medcin(a.getId_med(), a.getAge_med(), a.getAdresse_med(), a.getNom_med(), a.getPrenom_med()));
        }

        //   medlist=  FXCollections.observableList(ms.FindAll());
        TABLE.setItems(medlist);

    }

    @FXML
    private void CLOSE(MouseEvent event) {
    }
}//List<T> list = ObservableList<T>.stream().collect(Collectors.toList());
