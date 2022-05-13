/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Thinkpad
 */
public class mainfx extends Application {
      @Override
    public void start(Stage primaryStage) {
    
        
        try {
            //  Scene scene = new Scene(root, 300, 250);
       Parent root = FXMLLoader.load(getClass().getResource("FXMLServiceFront.fxml"));
      //  Parent root = FXMLLoader.load(getClass().getResource("FXMLStatService.fxml"));
     // Parent root = FXMLLoader.load(getClass().getResource("categorie.fxml"));
     //   Parent root = FXMLLoader.load(getClass().getResource("MediaPlayer.fxml"));
            
            Scene scene = new Scene(root);
            primaryStage.setTitle("Gestion Service");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(mainfx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

