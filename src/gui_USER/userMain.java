/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author lenovo
 */
public class userMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       Parent root,root2;
       
        try {
               //  root= FXMLLoader.load(getClass().getResource("addPat.fxml"));

         //  root = FXMLLoader.load(getClass().getResource("admingui.fxml"));
        // root= FXMLLoader.load(getClass().getResource("interventientcrud.fxml"));
        root= FXMLLoader.load(getClass().getResource("login.fxml"));
          
            Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
          
        
        
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
