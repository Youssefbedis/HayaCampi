/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.IServiceUser;
import Services.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DashboardController implements Initializable {
    private IServiceUser su=new ServiceUtilisateur();

    @FXML
    private ImageView Logo;
    @FXML
    private Label MenuLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BtnLivreur(ActionEvent event) {
    }

    @FXML
    private void BtnLivraison(ActionEvent event) {
    }

    @FXML
    private void BtnMap(ActionEvent event) {
    }

    @FXML
    private void BtnListUser(ActionEvent event) throws IOException {
            Parent root= FXMLLoader.load(getClass().getResource("Listeclient.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
        
    }

    @FXML
    private void BtnReservation(ActionEvent event) throws IOException {
          Parent root= FXMLLoader.load(getClass().getResource("ListeReservation.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void BtnHome(ActionEvent event) throws IOException {
           Parent root= FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
        
    }

    @FXML
    private void Btndeconnection(ActionEvent event) throws IOException {
           su.Logout();
          Parent root= FXMLLoader.load(getClass().getResource("Login.fxml"));
       //  AnchorPane pan= FXMLLoader.load(getClass().getResource("/gui/SignupForm.fxml"));
       // Scene scen =new Scene(root,920, 650);
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       primaryStage.setTitle("Login_Form");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}
