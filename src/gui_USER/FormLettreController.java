/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_USER;

import Entities.LettreConfidentielle;
import java.net.URL;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.CRUDLettre;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FormLettreController implements Initializable {

    @FXML
    private DatePicker DateLettretf;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfSignature;
    @FXML
    private TextField idOrdtf;
    @FXML
    private Button btnEnreL;
    Connection cnx ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
      LettreConfidentielle lc = new LettreConfidentielle();
      CRUDLettre pcd = new CRUDLettre();
   //   pcd.ajouterLettreConfidentielle(lc);

    @FXML
    private void saveLettre(ActionEvent event) {
         //sauvegrader dans la base de donnée 
        String datePickerValue = DateLettretf.getValue().toString();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
        date = LocalDate.parse(datePickerValue, dtf);
        Timestamp timestampdate = Timestamp.valueOf(date.atStartOfDay());
        lc.setDate(timestampdate);
        lc.setId_ordonnance(Integer.parseInt(idOrdtf.getText()));
        lc.setDescription(tfDescription.getText());
        lc.setSignature(tfSignature.getText());
        lc.setIdMed(1);
        //ord.setId_prod(0);
        //ord.setId_prod(ftMédicaments.getText());
         //Integer.parseInt(AGE.getText());
        pcd.ajouterLettreConfidentielle(lc); //lien ll base 
        JOptionPane.showMessageDialog(null, "Lettre enregistrée");
        //Redirection ( 2 éme fenetre eli bech tet7al )
        //FXMLLoader.load(getClass().getResource("nom du la deuxiéme fenetre "));
         btnEnreL.getScene().getWindow().hide();
    }
    
}
