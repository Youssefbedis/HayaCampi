/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.Utilisateur;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author user
 */
public class UserController implements Initializable {

    @FXML
    private Label email;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label num;
    @FXML
    private Label cin;
    @FXML
    private Label adr;
    private Utilisateur user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setData(Utilisateur user)
    {
    this.user= user;
    email.setText(user.getEmail());
    nom.setText(user.getFirstName());
    prenom.setText(user.getLastName());
    cin.setText(user.getCIN());
    num.setText(user.getNumTel());
    adr.setText(user.getAdresse());

    
    
    }
    
}
