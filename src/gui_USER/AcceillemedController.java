/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import entity.Medcin;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import servise.MedServices;
import servise.UserServeses;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AcceillemedController implements Initializable {

    @FXML
    private ImageView medprofilepic;
    @FXML
    private Button intervention;
    @FXML
    private Text idmed;

    /**
     * Initializes the controller class.
     */
    //var 
    Medcin med = new Medcin();
    ObservableList<Medcin> medlist = FXCollections.observableArrayList();
    UserServeses us = new UserServeses();
    MedServices ms = new MedServices();
    List<Medcin> list = new ArrayList<>();
    @FXML
    private Text MEDNAME;
    @FXML
    private Button LettreConfidentielle;
    @FXML
    private Button fichsuivie;
    @FXML
    private Button fichsuivie1;
    
     public void initializeid( String id) {
        idmed.setText(id);
        // System.out.println("this happened first");
         // int test = Integer.parseInt(idmed.getText());
       med = ms.FindById(Integer.parseInt(idmed.getText()));
        // System.out.println("this happened 2nd");
       // System.out.println(med.toString());
  
  //String picpath ="C:\\Users\\lenovo\\Documents\\NetBeansProjects\\ProjetJavaUser\\src\\resources"+med.getPhoto_med()+"";
  Image image = new Image(getClass().getResourceAsStream("/resources/"+med.getPhoto_med()+""));
        medprofilepic.setImage(image);
        MEDNAME.setText(med.getNom_med());
        // TODO
        // TODO*/
    }   
    
    
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
       
    }   
    

    @FXML
    private void interventions(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interventientcrud.fxml"));
        try {
            Parent root = loader.load();
            InterventientcrudController controller = loader.getController();
            controller.initializeid(idmed.getText());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MedcinviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
           // login.getScene().getWindow().hide();
        
        
        
        
    }

    @FXML
    private void fichsuivie(ActionEvent event) {
         try {
               Parent root = FXMLLoader.load(getClass().getResource("/gui/GestionFiche.fxml"));
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
    private void LettreConfidentielle(ActionEvent event) throws IOException {
         //FXMLLoader loader = new FXMLLoader(getClass().getResource("TableViewLettre.fxml"));
      
                //////////
                try {
               Parent root = FXMLLoader.load(getClass().getResource("/gui/TableViewLettre.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           // login.getScene().getWindow().hide();
    }

    @FXML
    private void bilon(ActionEvent event) {
        //GestionBilanController
         try {
               Parent root = FXMLLoader.load(getClass().getResource("/gui/GestionBilan.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
}
