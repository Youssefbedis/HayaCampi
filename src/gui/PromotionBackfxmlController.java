/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import models.Centre;
import models.Promotion;
import services.ServiceCentre;
import services.ServicePromotion;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PromotionBackfxmlController implements Initializable {

    @FXML
    private ComboBox<Centre> CBnomcentre;
    @FXML
    private TextField TFancienprix;
    @FXML
    private TextField TFnouveauprix;
    @FXML
    private TextField TFdate;
    @FXML
    private TextField TFduree;
    @FXML
    private ListView<Promotion> listView;
    private Label LBaffichage;
    @FXML
    private Button homie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  ServiceCentre sc = new ServiceCentre();
        ServicePromotion sc =  new ServicePromotion();
       List<Promotion> list= sc.afficher();
        for(Promotion c:list){
           
            listView.getItems().add(c);
        }
        
           // sc.exel();
        
        
    }    

    @FXML
    private void ajouterpromotion(ActionEvent event) {
        ServicePromotion sc = new ServicePromotion();
    // sc.ajouter(new Commande(0, TfNum.getText(),TfRue.getText(),CbVille.getValue(),TfNumTel.getText(),TfNumCarte.getText(),CbMode.getValue()));
         Centre centre = CBnomcentre.getSelectionModel().getSelectedItem();
          //String cbMode = (String)CbMode.getSelectionModel().getSelectedItem();
         
     Promotion p = new Promotion(Float.parseFloat(TFancienprix.getText()),Float.parseFloat(TFnouveauprix.getText()),Integer.parseInt(TFduree.getText()),Date.valueOf(TFdate.getText()),centre);
   sc.ajouterPromotion(p);
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("commande is added successfully!");
        alert.show();
    }
     @FXML
    private void afficherpromotion(ActionEvent event) {
        ServicePromotion sp = new ServicePromotion();
        LBaffichage.setText(sp.afficher().toString());
        //listView.setText(sp.afficher().toString());
    }

    @FXML
    private void homehome(ActionEvent event) throws IOException {
          Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("gui/Dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();

    }
    
}
