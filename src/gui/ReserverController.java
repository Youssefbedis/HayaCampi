/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import models.Reservation;
import services.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import static javax.swing.UIManager.get;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReserverController implements Initializable {

   
    @FXML
    private DatePicker TFdatedebut;
     @FXML
    private DatePicker TFdatefin;
    @FXML
    private TextField TFNumpersonne;
    @FXML
    private TextField TFNomcentre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void Reserver(ActionEvent event) {
        ServiceReservation u = new ServiceReservation();
        LocalDate Datedebut = TFdatedebut.getValue();
       // Datedebut.toString();
        
       //Date d = new Date(0);
       
        LocalDate Datefin = TFdatefin.getValue();
        //Datefin.toString();
      Reservation c = new Reservation(Datedebut,Datefin,TFNumpersonne.getText() ,TFNomcentre.getText());
    u.ajouter(c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("réservation ajouté!");
        alert.show();
    }

    @FXML
    private void precedent(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }

   
    
}
