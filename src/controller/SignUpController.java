/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Utils.JavaMailUtil;
import models.Utilisateur;
import services.ServiceUtilisateur;
import Utils.JavaMailUtil;
import animatefx.animation.Shake;
import static controller.LoginController.shake;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField TFemail;
    @FXML
    private TextField TFmotdepasse;
    @FXML
    private TextField TFlFirstName;
    @FXML
    private TextField TFLastName;
    @FXML
    private TextField TFCIN;
    @FXML
    private TextField TFNumTelephone;
    @FXML
    private TextField TFAdresse;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCompte(ActionEvent event) throws SQLException, Exception {
        ServiceUtilisateur u = new ServiceUtilisateur();
         if (TFemail.getText().isEmpty()) {
            TFemail.requestFocus();
            shake(TFemail);
            return;
        }
         else if (TFmotdepasse.getText().isEmpty()) {
            TFmotdepasse.requestFocus();
            shake(TFmotdepasse);
            return;
        }
         else if (TFlFirstName.getText().isEmpty()) {
            TFlFirstName.requestFocus();
            shake(TFlFirstName);
            return;
        }
         else if (TFLastName.getText().isEmpty()) {
            TFLastName.requestFocus();
            shake(TFLastName);
            return;
        }

         else if (TFNumTelephone.getText().isEmpty()) {
            TFNumTelephone.requestFocus();
            shake(TFNumTelephone);
            return;
        }
         else if (TFAdresse.getText().isEmpty()) {
            TFAdresse.requestFocus();
            shake(TFAdresse);
            return;
        }
         else {
             
        Utilisateur c = new Utilisateur(TFemail.getText(),"["+'"'+"ROLE_USER"+'"'+']',TFmotdepasse.getText() ,TFlFirstName.getText() ,TFLastName.getText() ,TFCIN.getText(),TFNumTelephone.getText(),TFAdresse.getText());
   
        u.ajouteruser(c);
        
                JavaMailUtil.sendMail(c.getEmail(), c.getIs_verified());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        
        alert.setContentText("compte créer!");
        alert.show();
       Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("gui/Login.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show(); }
        
    }

    @FXML
    private void precedent(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("gui/Login.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }
    public static void shake(Node node) {
        new Shake(node).play();
    }
    
}
