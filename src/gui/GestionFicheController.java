/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.Bilan;
import entity.Fiche_suivi;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import servise.BilanCRUD;
import servise.Fiche_suiviCRUD;

/**
 * FXML Controller class
 *
 * @author marie
 */
public class GestionFicheController implements Initializable {

    @FXML
    private Button btnvalider_fiche;
    @FXML
    private Button btnsupprimer_fiche;
    @FXML
    private Button btnactualiser_fiche;
    @FXML
    private TextField tfid_pat_fiche;
    @FXML
    private TextField tfid_bil_fiche;
    @FXML
    private TextField tfdiag;
    @FXML
    private TextField tfconsigne;
    @FXML
    private TableView<Fiche_suivi> tableviewfiche;
    @FXML
    private TableColumn<Fiche_suivi,String> diagcol;
    @FXML
    private TableColumn<Fiche_suivi,String> conscol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        diagcol.setCellValueFactory(new PropertyValueFactory<Fiche_suivi,String >("diagnostic"));
     conscol.setCellValueFactory(new PropertyValueFactory<Fiche_suivi,String >("consigne_medicale"));
      refresh_table();
        // TODO
    }  
    
    public void  refresh_table () {
   
             try {
              Fiche_suiviCRUD f =new  Fiche_suiviCRUD();
             
          ObservableList<Fiche_suivi> list = FXCollections.observableArrayList(f.afficherFiches_suivi2());  
          this.tableviewfiche.getItems().clear();
          this.tableviewfiche.getItems().addAll(list);
         
         
        } catch (Exception e) {
        }
        // TODO
    }  

    @FXML
    private void saveFiche(ActionEvent event) {
      String idpf = tfid_pat_fiche.getText();
        String idbf = tfid_bil_fiche.getText();
        String diagnostic = tfdiag.getText();
        String consigne = tfconsigne.getText();
        
        Fiche_suivi f = new Fiche_suivi(Integer.parseInt(idpf),Integer.parseInt(idbf),diagnostic,consigne);
        Fiche_suiviCRUD fcd = new Fiche_suiviCRUD();
        fcd.ajouterFiche_suivi2(f);
        System.out.println("Fiche insérée");
        JOptionPane.showMessageDialog(null, "Fiche_suivi enregistrée");  
        
    }

    @FXML
    private void deleteFiche(MouseEvent event) {
    }

    @FXML
    private void refresh(MouseEvent event) {
    }
    
}
