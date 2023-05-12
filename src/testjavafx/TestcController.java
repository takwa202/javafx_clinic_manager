/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class TestcController implements Initializable {
    @FXML
    private Button butReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void returne(ActionEvent event) {
         try {
           Parent  root = FXMLLoader.load(getClass().getResource("/testjavafx/treeviewtest.fxml"));
            Scene scene = new Scene(root, 400, 400);
           Stage stage = new Stage();
             stage.setScene(scene);
              stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
    }
    }
    

