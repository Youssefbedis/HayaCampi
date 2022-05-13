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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Home1Controller implements Initializable {

    @FXML
    private Label lbNameM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private IServiceUser su=new ServiceUtilisateur();

    @FXML
    private void Editprofil(ActionEvent event) throws IOException {
         Parent root= FXMLLoader.load(getClass().getResource("EditProfile.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }
    

    @FXML
    private void profil(ActionEvent event) {
    }

    @FXML
    private void Reservation(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Reserver.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void Store(ActionEvent event) {
    }

    @FXML
    private void Commande(ActionEvent event) {
    }

    @FXML
    private void LOGOUT(ActionEvent event) throws IOException {
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
