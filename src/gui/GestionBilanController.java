/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entity.Bilan;
import entity.Fiche_suivi;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import servise.BilanCRUD;
import servise.Fiche_suiviCRUD;
import utils.Mail;

/**
 * FXML Controller class
 *
 * @author marie
 */
public class GestionBilanController implements Initializable {

    @FXML
    private Button btnajouterbilan;
    @FXML
    private DatePicker tfdate_bilan;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tfconclusion;
    @FXML
    private TableView<Bilan> tableviewbil;
    @FXML
    private TableColumn<Bilan,String > coltype;
    @FXML
    private TableColumn<Bilan,Timestamp> coldate;
    @FXML
    private TableColumn<Bilan,String> colconclusion;
    @FXML
    private Button btnsupprimerbilan;
    @FXML
    private Button btnenvoyer;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      coltype.setCellValueFactory(new PropertyValueFactory<Bilan,String >("type"));
     coldate.setCellValueFactory(new PropertyValueFactory<Bilan,Timestamp >("date_bilan"));
     colconclusion.setCellValueFactory(new PropertyValueFactory<Bilan,String >("conclusion")); 
      refresh_table();
    }
    
    public void  refresh_table () {
   
             try {
              BilanCRUD b =new  BilanCRUD();
             
          ObservableList<Bilan> list = FXCollections.observableArrayList(b.afficherBilan());  
          this.tableviewbil.getItems().clear();
          this.tableviewbil.getItems().addAll(list);
         
         
        } catch (Exception e) {
        }
        // TODO
    }  

    Bilan b = new Bilan();
    BilanCRUD bcd = new BilanCRUD();

    @FXML
    private void enregistrerbilan(ActionEvent event)
    {
        String datePickerValue = tfdate_bilan.getValue().toString();
        DateTimeFormatter tfdabil = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date2;
        date2 = LocalDate.parse(datePickerValue,tfdabil);
        Timestamp timestampdate = Timestamp.valueOf(date2.atStartOfDay());
        b.setDate_bilan(timestampdate);
        Timestamp date_bilan = b.getDate_bilan();
       String type  = tftype.getText();
     //   LocalDate date;
      //  Date  tfdabil = tfdate_bilan.getValue()ù;
        String conclusion  = tfconclusion.getText();
        
        Bilan b  = new Bilan(type,date_bilan,conclusion);
        Fiche_suiviCRUD fcd = new Fiche_suiviCRUD();
        bcd.ajouterBilan(b);
        System.out.println("Bilan insérée");
        JOptionPane.showMessageDialog(null, "Bilan enregistrée");
    }

    @FXML
    private void supprimerbilan(ActionEvent event) {
        int selectedID=tableviewbil.getSelectionModel().getFocusedIndex();
      tableviewbil.getItems().remove(selectedID);
    }

    @FXML
    private void envoyermail(ActionEvent event) {
        Mail mail = new Mail();
        mail.mail("protrusion discale lombaire", "conclusion bilan", "mariem.tlili@esprit.tn");
    }
    
    
    
    
    
}
