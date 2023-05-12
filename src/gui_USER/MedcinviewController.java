/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import entity.Medcin;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import servise.MedServices;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class MedcinviewController implements Initializable {

    @FXML
    private TableView<Medcin> tabel;
    @FXML
    private TableColumn<String, Medcin> ID;
    @FXML
    private TableColumn<String, Medcin> NOM;
    @FXML
    private TableColumn<String, Medcin> PN;
    @FXML
    private TableColumn<String, Medcin> ADRESS;
    @FXML
    private TableColumn<String, Medcin> MAIL;
    // private TableColumn<String, Medcin> PASSWORD;
    @FXML
    private TableColumn<String, Medcin> AGE;
    @FXML
    private TableColumn<String, Medcin> GENDER;
    @FXML
    private TableColumn<String, Medcin> PHONE;
    @FXML
    private TableColumn<String, Medcin> NBR_R;
    @FXML
    private TableColumn<String, Medcin> IS_BLOCKED;
    @FXML
    private Button search;
    @FXML
    private TextField searchinput;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button refresh;
    @FXML
    private Button update;

    ObservableList<Medcin> medlist = FXCollections.observableArrayList();
    MedServices ms = new MedServices();
    List<Medcin> list = new ArrayList<>();
    @FXML
    private Button block;
    @FXML
    private Button unblock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        medlist.clear();
        list = ms.FindAll();
        for (Medcin a : list) {
            medlist.add(new Medcin(a.getId_med(), a.getEmail_med(), a.getAge_med(), a.getAdresse_med(), a.getGenre_med(), a.getNom_med(), a.getPrenom_med(),
                    a.getNum_tel_med(), a.getNb_rec_med(), a.getIs_Blocked()));
        }

        //   medlist=  FXCollections.observableList(ms.FindAll());
        tabel.setItems(medlist);
        ID.setCellValueFactory(new PropertyValueFactory<>("id_med"));
        NOM.setCellValueFactory(new PropertyValueFactory<>("nom_med"));
        PN.setCellValueFactory(new PropertyValueFactory<>("prenom_med"));
        ADRESS.setCellValueFactory(new PropertyValueFactory<>("adresse_med"));
        AGE.setCellValueFactory(new PropertyValueFactory<>("age_med"));
        MAIL.setCellValueFactory(new PropertyValueFactory<>("email_med"));
        // PASSWORD.setCellValueFactory(new PropertyValueFactory<>(""));
        GENDER.setCellValueFactory(new PropertyValueFactory<>("genre_med"));
        PHONE.setCellValueFactory(new PropertyValueFactory<>("num_tel_med"));
        NBR_R.setCellValueFactory(new PropertyValueFactory<>("nb_rec_med"));
        IS_BLOCKED.setCellValueFactory(new PropertyValueFactory<>("is_Blocked"));

    }

    @FXML
    private void search(ActionEvent event) {

        medlist.clear();
        int id = Integer.parseInt(searchinput.getText());
        list = ms.FindById2(id);
        for (Medcin a : list) {
            medlist.add(new Medcin(a.getId_med(), a.getEmail_med(), a.getAge_med(), a.getAdresse_med(), a.getGenre_med(), a.getNom_med(), a.getPrenom_med(),
                    a.getNum_tel_med(), a.getNb_rec_med(), a.getIs_Blocked()));
        }

        //   medlist=  FXCollections.observableList(ms.FindAll());
        tabel.setItems(medlist);
        ID.setCellValueFactory(new PropertyValueFactory<>("id_med"));
        NOM.setCellValueFactory(new PropertyValueFactory<>("nom_med"));
        PN.setCellValueFactory(new PropertyValueFactory<>("prenom_med"));
        ADRESS.setCellValueFactory(new PropertyValueFactory<>("adresse_med"));
        AGE.setCellValueFactory(new PropertyValueFactory<>("age_med"));
        MAIL.setCellValueFactory(new PropertyValueFactory<>("email_med"));
        // PASSWORD.setCellValueFactory(new PropertyValueFactory<>(""));
        GENDER.setCellValueFactory(new PropertyValueFactory<>("genre_med"));
        PHONE.setCellValueFactory(new PropertyValueFactory<>("num_tel_med"));
        NBR_R.setCellValueFactory(new PropertyValueFactory<>("nb_rec_med"));
        IS_BLOCKED.setCellValueFactory(new PropertyValueFactory<>("is_Blocked"));

    }

    @FXML
    private void add(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addMED.fxml"));
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
        Medcin person = tabel.getSelectionModel().getSelectedItem();
        ms.delete(person.getId_med());
        refresh(event);
    }

    @FXML
    private void refresh(ActionEvent event) {
        medlist.clear();
        list = ms.FindAll();
        for (Medcin a : list) {
            medlist.add(new Medcin(a.getId_med(), a.getEmail_med(), a.getAge_med(), a.getAdresse_med(), a.getGenre_med(), a.getNom_med(), a.getPrenom_med(),
                    a.getNum_tel_med(), a.getNb_rec_med(), a.getIs_Blocked()));

        }

        //   medlist=  FXCollections.observableList(ms.FindAll());
        tabel.setItems(medlist);
        ID.setCellValueFactory(new PropertyValueFactory<>("id_med"));
        NOM.setCellValueFactory(new PropertyValueFactory<>("nom_med"));
        PN.setCellValueFactory(new PropertyValueFactory<>("prenom_med"));
        ADRESS.setCellValueFactory(new PropertyValueFactory<>("adresse_med"));
        AGE.setCellValueFactory(new PropertyValueFactory<>("age_med"));
        MAIL.setCellValueFactory(new PropertyValueFactory<>("email_med"));
        // PASSWORD.setCellValueFactory(new PropertyValueFactory<>(""));
        GENDER.setCellValueFactory(new PropertyValueFactory<>("genre_med"));
        PHONE.setCellValueFactory(new PropertyValueFactory<>("num_tel_med"));
        NBR_R.setCellValueFactory(new PropertyValueFactory<>("nb_rec_med"));
        IS_BLOCKED.setCellValueFactory(new PropertyValueFactory<>("is_Blocked"));

    }

    @FXML
    private void update(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("updatemed.fxml"));
        try {
            Parent root = loader.load();
            UpdatemedController controller = loader.getController();
            controller.initializedata( tabel.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MedcinviewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* FXMLLoader load = new FXMLLoader();
            try {
            Medcin person = tabel.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(getClass().getResource("updatemed.fxml"));
            UpdatemedController controller = load.getController();
            controller.initializedata();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);

            //stage.setUserData(person);
            stage.show();
            } catch (IOException ex) {
            System.out.println(ex.getMessage());
            }*/
    }

    @FXML
    private void block(ActionEvent event) {
        Medcin person = tabel.getSelectionModel().getSelectedItem();
        ms.bloqueMed(person.getId_med());
        refresh(event);
    }

    @FXML
    private void unblock(ActionEvent event) {
          Medcin person = tabel.getSelectionModel().getSelectedItem();
        ms.unbloqueMed(person.getId_med());
        refresh(event);
    }

}
