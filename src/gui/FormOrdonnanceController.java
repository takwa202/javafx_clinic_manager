/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Ordonnance;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.CRUDOrdonnance;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FormOrdonnanceController implements Initializable {

    @FXML
    private TextField ftNomPrePatient;
    @FXML
    private TextField ftMédicaments;
    @FXML
    private TextField ftTexteOrdonnance;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private TextField ftDate;
    Connection cnx ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    Ordonnance ord = new Ordonnance();
    CRUDOrdonnance pcd = new CRUDOrdonnance() ;
    //pcd.ajouterOrdonnance(ord);
    @FXML
    private void saveOrdonnance(ActionEvent event) {
        ord.setDateAjout(ftDate.getText());
        ord.setNomPrenomPatient(ftNomPrePatient.getText());
        ord.setModeUtilisation(ftTexteOrdonnance.getText());
        ord.setId_prod(Integer.parseInt(ftMédicaments.getText()));
       pcd.ajouterOrdonnance(ord); //lien ll base 
        JOptionPane.showMessageDialog(null, "Ordonnance enregistrée");
        btnEnregistrer.getScene().getWindow().hide();
    }
    
}
