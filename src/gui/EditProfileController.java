/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.Utilisateur;
import Services.IServiceUser;
import Services.ServiceUtilisateur;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.UtilisateurSession;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EditProfileController implements Initializable {

    @FXML
    private StackPane StckFrontProduit;
    @FXML
    private TextField TFNom;
    @FXML
    private Label Nom;
    @FXML
    private TextField TFPrenom;
    @FXML
    private Label prenom;
    @FXML
    private TextField TFCIN;
    @FXML
    private Label CIN;
    @FXML
    private TextField TFNumtel;
    @FXML
    private Label NumTel;
    @FXML
    private TextField TFAdresse;
    @FXML
    private Label Adresse;
    @FXML
    private TextField TFEmail;
    @FXML
    private Label email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      Utilisateur x;
    IServiceUser su=new ServiceUtilisateur();

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
        
    }

    @FXML
    private void ModifierprofM(ActionEvent event) throws SQLException {
        UtilisateurSession.setEmail(TFEmail.getText().toString());
              UtilisateurSession.setLastName(TFNom.getText().toString());
              UtilisateurSession.setFirstName(TFPrenom.getText().toString());
              UtilisateurSession.setNumTel(TFNumtel.getText().toString());
              UtilisateurSession.setNumTel(TFAdresse.getText().toString());
              Utilisateur u=new Utilisateur(UtilisateurSession.getId(), UtilisateurSession.getEmail(), UtilisateurSession.getRoles(), UtilisateurSession.getPassword(), UtilisateurSession.getLastName(), UtilisateurSession.getFirstName(), UtilisateurSession.getCIN(), UtilisateurSession.getNumTel(), UtilisateurSession.getAdresse());
              System.out.println(u);
             su.modifieruser(u,u.getId());
               JOptionPane.showMessageDialog(null, "modifier avec succee");
    }

    @FXML
    private void CloseWindowClicked(MouseEvent event) throws SQLException {
        
    }
    
}
