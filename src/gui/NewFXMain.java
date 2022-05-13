/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.Captcha;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
      /* StackPane root = new StackPane();

		Captcha captcha = new Captcha();

		captcha.setSummand1(5);
		captcha.setSummand2(10);

		// Format
		captcha.setScaleX(3.0);
		captcha.setScaleY(3.0);

		// HINT: Group catches the scaled bounds of the captcha -> otherwise it
		// would have layout issues
		Group group = new Group(captcha);

		root.getChildren().add(group);

		Scene rootScene = new Scene(root);
		primaryStage.setScene(rootScene);
		primaryStage.show();
        
        */
       try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            
            Scene scene = new Scene(root);
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Haya Campi");
            primaryStage.show();
              } catch (IOException ex) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
