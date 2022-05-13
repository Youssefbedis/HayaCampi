/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author chahi
 */
public class MenuController implements Initializable {

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
    private void BtnLivreur(ActionEvent event) throws IOException {
         Parent root= FXMLLoader.load(getClass().getResource("Livreur.fxml"));
        Stage stage = new Stage();
       
      stage.setScene(new Scene(root));
            stage.setTitle("----------   Gestion des Livreurs   ------ ");

        stage.show();
    }

    @FXML
    private void BtnLivraison(ActionEvent event) throws IOException {
         Parent root= FXMLLoader.load(getClass().getResource("Livraison.fxml"));
        Stage stage = new Stage();
       
      stage.setScene(new Scene(root));
            stage.setTitle("----------    Gestion des Livraisons    ------ ");

        stage.show();
       
      
    }

    @FXML
    private void BtnMap(ActionEvent event) throws IOException {
         Parent root= FXMLLoader.load(getClass().getResource("maptest.fxml"));
        Stage stage = new Stage();
       
      stage.setScene(new Scene(root));
      stage.setTitle("----------    MAP    ------ ");

        stage.show();
    }
    
}
