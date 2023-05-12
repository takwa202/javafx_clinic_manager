/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AdminguiController implements Initializable {
    @FXML
    private Button MEDCIN;
    @FXML
    private Button PHARMACIEN;
    @FXML
    private BorderPane PANE;
    @FXML
    private Button PHARMACIEN1;
    @FXML
    private Button PHARMACIEN2;
    @FXML
    private Button CLOSE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void MEDCIN(ActionEvent event) {
                loadui("Medcinview");

    }

    @FXML
    private void PHARMACIEN(ActionEvent event) {
       loadui("pharmacienView");
    }
    private void loadui (String ui){
        Parent root = null;
        try {
           root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminguiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        PANE.setCenter(root);
    }
    

    @FXML
    private void CLOSE(ActionEvent event) {
    }
    
}
