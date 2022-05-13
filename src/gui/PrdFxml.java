/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Amirov
 */
public class PrdFxml extends Application {
    
    @Override
       public void start(Stage stage)throws Exception {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Produitt.fxml"));
                    Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Gestion Produit");
        stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
