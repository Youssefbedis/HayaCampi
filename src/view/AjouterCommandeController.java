/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import models.Commande;
import services.serviceCommande;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author MAKREM
 */
public class AjouterCommandeController implements Initializable {

    @FXML
    private TextField num;
    @FXML
    private TextField rue;
    @FXML
    private TextField ville;
    @FXML
    private TextField numTel;
    @FXML
    private TextField numCarte;
    @FXML
    private ComboBox<String> combobox;
  ObservableList<String> listmode = FXCollections.observableArrayList( "Sur Place","En ligne");
    private Statement ste;
    private Connection con;
    serviceCommande sc = new serviceCommande();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox.setItems(listmode);
    }    

    @FXML
    private void Submit(ActionEvent event) {
               if(Validchamp(num) && Validchamp(rue) && Validchamp(ville) && Validchamp(numCarte))
        {
                Commande of= new Commande();
               of.setUser_id(6);
                of.setNum(num.getText());
                of.setRue(rue.getText());
                of.setVille(ville.getText());
                of.setNum_tel(numTel.getText());
                of.setNum_carte(numCarte.getText());
                of.setMode(combobox.getSelectionModel().getSelectedItem());
                sc.ajouter(of);
     
       
        
        }
        else
        {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Verifiez les champs!");

        alert.showAndWait();
        }
     

    }
                private boolean Validchamp(TextField T){
        return !T.getText().isEmpty() && T.getLength() >= 2;
    }
    }
    
