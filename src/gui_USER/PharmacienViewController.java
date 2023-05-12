/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import entity.Medcin;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import servise.PharmacienServeces;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class PharmacienViewController implements Initializable {
    @FXML
    private TableView <Pharmacien> tabel;
    @FXML
    private TableColumn<String, Pharmacien> ID;
    @FXML
    private TableColumn<String, Pharmacien> NOM;
    @FXML
    private TableColumn<String, Pharmacien>  PN;
    @FXML
    private TableColumn<String, Pharmacien>  ADRESS;
    @FXML
    private TableColumn<String, Pharmacien> MAIL;
    @FXML
    private TableColumn<String, Pharmacien>  PHONE;
    @FXML
    private TableColumn<String, Pharmacien>  IS_BLOCKED;
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
    @FXML
    private Button block;
    @FXML
    private Button unblock;
    
    /*** var declaration 
     * 
     */
      ObservableList<Pharmacien> medlist = FXCollections.observableArrayList();
    PharmacienServeces fs = new PharmacienServeces();
    List<Pharmacien> list = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           medlist.clear();
        list = fs.FindAll();
        for (Pharmacien a : list) {
           medlist.add(new Pharmacien(a.getId_Pharmacien(), a.getNom_Pharmacien(),a.getPrenom_Pharmacien(),a.getAdress_Pharmacien(),a.getNumTel_Pharmacien(),a.getEmail_Pharmacien(),a.getBlockfarm() ));
        }

        //   medlist=  FXCollections.observableList(ms.FindAll());
        tabel.setItems(medlist);
        ID.setCellValueFactory(new PropertyValueFactory<>("Id_Pharmacien"));
        NOM.setCellValueFactory(new PropertyValueFactory<>("nom_Pharmacien"));
        PN.setCellValueFactory(new PropertyValueFactory<>("Prenom_Pharmacien"));
        ADRESS.setCellValueFactory(new PropertyValueFactory<>("Adress_Pharmacien"));
        //AGE.setCellValueFactory(new PropertyValueFactory<>("age_med"));
        MAIL.setCellValueFactory(new PropertyValueFactory<>("Email_Pharmacien"));
        // PASSWORD.setCellValueFactory(new PropertyValueFactory<>(""));
      //  GENDER.setCellValueFactory(new PropertyValueFactory<>("genre_med"));
        PHONE.setCellValueFactory(new PropertyValueFactory<>("NumTel_Pharmacien"));
       // NBR_R.setCellValueFactory(new PropertyValueFactory<>("nb_rec_med"));
        IS_BLOCKED.setCellValueFactory(new PropertyValueFactory<>("Blockfarm"));
        // TODO
    }    

    

    @FXML
    private void search(ActionEvent event) {
         medlist.clear();
        int id = Integer.parseInt(searchinput.getText());
        list = fs.FindById(id);
        for (Pharmacien a : list) {
           medlist.add(new Pharmacien(a.getId_Pharmacien(), a.getNom_Pharmacien(),a.getPrenom_Pharmacien(),a.getAdress_Pharmacien(),a.getNumTel_Pharmacien(),a.getEmail_Pharmacien(),a.getBlockfarm() ));
               
        }
        tabel.setItems(medlist);
        ID.setCellValueFactory(new PropertyValueFactory<>("Id_Pharmacien"));
        NOM.setCellValueFactory(new PropertyValueFactory<>("nom_Pharmacien"));
        PN.setCellValueFactory(new PropertyValueFactory<>("Prenom_Pharmacien"));
        ADRESS.setCellValueFactory(new PropertyValueFactory<>("Adress_Pharmacien"));
        //AGE.setCellValueFactory(new PropertyValueFactory<>("age_med"));
        MAIL.setCellValueFactory(new PropertyValueFactory<>("Email_Pharmacien"));
        // PASSWORD.setCellValueFactory(new PropertyValueFactory<>(""));
      //  GENDER.setCellValueFactory(new PropertyValueFactory<>("genre_med"));
        PHONE.setCellValueFactory(new PropertyValueFactory<>("NumTel_Pharmacien"));
       // NBR_R.setCellValueFactory(new PropertyValueFactory<>("nb_rec_med"));
        IS_BLOCKED.setCellValueFactory(new PropertyValueFactory<>("Blockfarm"));
        // TODO

        
    }

    @FXML
    private void add(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("addFARM.fxml"));
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
    private void delete(ActionEvent event) {
         Pharmacien person = tabel.getSelectionModel().getSelectedItem();
        fs.delete(person.getId_Pharmacien());
        refresh(event);
    }

    @FXML
    private void refresh(ActionEvent event) {
         medlist.clear();
        list = fs.FindAll();
        for (Pharmacien a : list) {
           medlist.add(new Pharmacien(a.getId_Pharmacien(), a.getNom_Pharmacien(),a.getPrenom_Pharmacien(),a.getAdress_Pharmacien(),a.getNumTel_Pharmacien(),a.getEmail_Pharmacien(),a.getBlockfarm() ));
        }

        //   medlist=  FXCollections.observableList(ms.FindAll());
        tabel.setItems(medlist);
        ID.setCellValueFactory(new PropertyValueFactory<>("Id_Pharmacien"));
        NOM.setCellValueFactory(new PropertyValueFactory<>("nom_Pharmacien"));
        PN.setCellValueFactory(new PropertyValueFactory<>("Prenom_Pharmacien"));
        ADRESS.setCellValueFactory(new PropertyValueFactory<>("Adress_Pharmacien"));
        //AGE.setCellValueFactory(new PropertyValueFactory<>("age_med"));
        MAIL.setCellValueFactory(new PropertyValueFactory<>("Email_Pharmacien"));
        // PASSWORD.setCellValueFactory(new PropertyValueFactory<>(""));
      //  GENDER.setCellValueFactory(new PropertyValueFactory<>("genre_med"));
        PHONE.setCellValueFactory(new PropertyValueFactory<>("NumTel_Pharmacien"));
       // NBR_R.setCellValueFactory(new PropertyValueFactory<>("nb_rec_med"));
        IS_BLOCKED.setCellValueFactory(new PropertyValueFactory<>("Blockfarm"));
        // TODO
        
    }

    @FXML
    private void update(ActionEvent event) {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("updatpharm.fxml"));
        try {
            Parent root = loader.load();
            UpdatpharmController controller = loader.getController();
           controller.initializedata2(tabel.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MedcinviewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
@FXML
    private void block(ActionEvent event) {
        Pharmacien person = tabel.getSelectionModel().getSelectedItem();
        fs.bloqueFARM(person.getId_Pharmacien());
        refresh(event);
    }

    @FXML
    private void unblock(ActionEvent event) {
           Pharmacien person = tabel.getSelectionModel().getSelectedItem();
        fs.unbloqueFARM(person.getId_Pharmacien());
        refresh(event);
    }
    
}
