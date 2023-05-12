/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import servise.MedServices;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
 

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ImageController implements Initializable {
    @FXML
    private ImageView img;
    @FXML
    private Button uploadbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 Connection conx;
    @FXML
    private void upload(ActionEvent event) throws IOException {
       // Image img2 = new Image ("");
        FileChooser chooser =new FileChooser();
        FileChooser.ExtensionFilter exxensionFilterPNG = new FileChooser.ExtensionFilter("JPG files(*.png","*.PNG");
                FileChooser.ExtensionFilter exxensionFilterJPG = new FileChooser.ExtensionFilter("JPG files(*.jpg","*.JPG");
                chooser.getExtensionFilters().addAll(exxensionFilterJPG,exxensionFilterPNG);
                File file = chooser.showOpenDialog(null);
                BufferedImage ufferedImag = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(ufferedImag, null);
                img.setImage(image);
                //file. getName() >> get file name "Sring"
                //file.getPath()>> get file path "String"
                //to make copy of file ain another file
                 Path temp= Files.copy(Paths.get(file.getPath()),Paths.get("C:\\Users\\lenovo\\Pictures\\"+file. getName()+""));
                
                
                 
        
    }
    
}
