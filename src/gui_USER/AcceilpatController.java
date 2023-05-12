/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import servise.UserServeses;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AcceilpatController implements Initializable {

    @FXML
    private Button reclamer;

    /**
     * Initializes the controller class.
     */
    //var
    UserServeses us = new UserServeses();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reclamer(ActionEvent event) {
        us.analyse_Users_Reclamtions_And_Block();
        
    }
    
}
