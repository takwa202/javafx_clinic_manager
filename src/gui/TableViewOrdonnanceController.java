/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Ordonnance;
import Entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.CRUDOrdonnance;
import utils.CurrentData;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TableViewOrdonnanceController implements Initializable {

    @FXML
    private TableView<Ordonnance> TableOrdonnance;
    @FXML
    private TableColumn<Ordonnance, String> IdOrdColonne;
    @FXML
    private TableColumn<Ordonnance, String> DateColonne;
    @FXML
    private TableColumn<Ordonnance, String> MedicamentColonne;
    @FXML
    private TableColumn<Ordonnance, String> TexteOrdColonne;
    @FXML
    private TableColumn<Ordonnance, String> NomPrePatientColonne;
    @FXML
    private TableColumn<Ordonnance, String> idProdColonne;
     @FXML
    private Button btnrefresh;
    
    @FXML
    private Button getADDview;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    // String query = null;
     //Connection cnx = null;
     //PreparedStatement ps = null;
     //ResultSet rs = null;
   //  Ordonnance ordonnance = null;
     ObservableList<Ordonnance>  OrdonnanceList = FXCollections.observableArrayList();
     CRUDOrdonnance od= new CRUDOrdonnance();
     List<Ordonnance> list = new ArrayList<>();
    ObservableList<Produit>  ProduitList = FXCollections.observableArrayList();
     List<Produit> list1 = new ArrayList<>();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
       OrdonnanceList.clear();
       list = od.afficherOrdonnance();
            for (Ordonnance ord : list) {
         // System.out.println(ord.getNomPrenomPatient());
         OrdonnanceList.add(new Ordonnance(ord.getIdOrdonnance(),ord.getDateAjout(),ord.getModeUtilisation(),ord.getNomPrenomPatient(),ord.getProduit(),ord.getId_prod()));   
     //ProduitList.add(new Produit(ord.getProduit().getIdProduit(),ord.getProduit().getNomProduit()));
        }
       TableOrdonnance.setItems(OrdonnanceList);
        IdOrdColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("idOrdonnance"));
        DateColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("dateAjout"));
        TexteOrdColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("nomProduit"));
        MedicamentColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("modeUtilisation"));
        NomPrePatientColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("nomPrenomPatient"));
        idProdColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("id_prod")); 
      
        }
    
    
    
    
      

    @FXML
    private void getADDview(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("FormOrdonnance.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableViewOrdonnanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

    @FXML
    private void refreshTable(MouseEvent event) {
        OrdonnanceList.clear();
        list = od.afficherOrdonnance();
        for (Ordonnance ord : list) {
          //  OrdonnanceList.add(new Ordonnance (ord.getIdOrdonnance(),ord.getDateAjout(),ord.getId_prod(),ord.getModeUtilisation(),ord.getNomPrenomPatient(),ord.getId_prod());
        }
        OrdonnanceList = FXCollections.observableList(od.afficherOrdonnance());
        TableOrdonnance.setItems(OrdonnanceList);
        IdOrdColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("idOrdonnance"));
        DateColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("dateAjout"));
        MedicamentColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("nomProduit"));
        TexteOrdColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("modeUtilisation"));
        NomPrePatientColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("nomPrenomPatient"));
        idProdColonne.setCellValueFactory(new PropertyValueFactory<Ordonnance,String>("id_Prod"));
          
    }
    @FXML 
    private void DELETE(MouseEvent event) {
        Ordonnance person = TableOrdonnance.getSelectionModel().getSelectedItem();
        od.supprimerOrdonnance(person.getIdOrdonnance());
        refreshTable(event);
    }
     @FXML 
    private void Update(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("updatpharm.fxml"));
            
            Parent root = loader.load();
           // UpdatpharmController controller = loader.getController();
           // controller.initializedata2(TableOrdonnance.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableViewOrdonnanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
       
        
      
      

   
    
}
