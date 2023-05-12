/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.LettreConfidentielle;
import Entities.Ordonnance;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.CRUDLettre;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TableViewLettreController implements Initializable {
    @FXML
    private TableView<LettreConfidentielle> TableLettreView;
    @FXML
    private TableColumn<LettreConfidentielle, String> IdconfColonne;
    @FXML
    private TableColumn<LettreConfidentielle, String> dateLettreColonne;
    @FXML
    private TableColumn<LettreConfidentielle, String> descriptionColonne;
    @FXML
    private TableColumn<LettreConfidentielle, String> signcolonne;
    @FXML
    private TableColumn<LettreConfidentielle, String> Id_ordoColonne;
    @FXML
    private TableColumn<LettreConfidentielle, String> nomPrenomPatColonne;
    @FXML
    private Button btnAjoutLettre;
    @FXML
    private Button BtnRefreshLettre;
    @FXML
    private Button UpdateLettre;
    @FXML
    private Button DeleteLettre;
    
    
    ObservableList<LettreConfidentielle>  LettreList = FXCollections.observableArrayList();
    CRUDLettre lc= new CRUDLettre();
    List<LettreConfidentielle> list = new ArrayList<>();
    ObservableList<Ordonnance>  OrdonnanceList = FXCollections.observableArrayList();
    List<Ordonnance> list1 = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       LettreList.clear();
       list = lc.afficherLettreConfidentielle();
      // System.out.println(list.size());
     
      
      for (LettreConfidentielle l : list) {
         // System.out.println(ord.getNomPrenomPatient());
         
     LettreList.add(new LettreConfidentielle(l.getIdConf(),l.getDate(),l.getDescription(),l.getSignature(),l.getId_ordonnance(),l.getOrdonnance(),l.getOrdonnance().getNomPrenomPatient()));   
     //ProduitList.add(new Produit(ord.getProduit().getIdProduit(),ord.getProduit().getNomProduit()));
        }
       TableLettreView.setItems(LettreList);
       IdconfColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("idConf"));
        dateLettreColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("date"));
       descriptionColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("description"));
       signcolonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("signature"));
       Id_ordoColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("idOrdonnance"));
       nomPrenomPatColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("nomPrenomPatient")); 
    }    
    @FXML
    private void ADDLettre(MouseEvent event) {
        try {
            Parent patient = FXMLLoader.load(getClass().getResource("FormLettre.fxml"));
            Scene scene = new Scene(patient);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableViewLettreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RefreshLettre(MouseEvent event) {
         LettreList.clear();
       list = lc.afficherLettreConfidentielle();
      // System.out.println(list.size());
     
      
      for (LettreConfidentielle l : list) {
         // System.out.println(ord.getNomPrenomPatient());
         
     LettreList.add(new LettreConfidentielle(l.getIdConf(),l.getDate(),l.getDescription(),l.getSignature(),l.getId_ordonnance(),l.getOrdonnance()));   
     //ProduitList.add(new Produit(ord.getProduit().getIdProduit(),ord.getProduit().getNomProduit()));
        }
       TableLettreView.setItems(LettreList);
       IdconfColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("idConf"));
        dateLettreColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("date"));
       descriptionColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("description"));
       signcolonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("signature"));
       Id_ordoColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("id_ordonnance"));
       nomPrenomPatColonne.setCellValueFactory(new PropertyValueFactory<LettreConfidentielle,String>("nomPrenomPatient")); 
        
    }
     @FXML
     private void DeleteLettre(MouseEvent event) {
          LettreConfidentielle l   = TableLettreView.getSelectionModel().getSelectedItem();
          lc. supprimerLettre(l.getIdConf());
          RefreshLettre(event);
     }
      @FXML
     private void UpdateLettre(MouseEvent event) {
          LettreConfidentielle lm   = TableLettreView.getSelectionModel().getSelectedItem();
         // lc.modifierLettreConfidentielle(lm.getIdConf()); //deux paramétres 
          RefreshLettre(event);
     }
     
    
    
}
