/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import models.Reservation;
import models.Utilisateur;
import services.IService;
import services.IServiceUser;
import services.ServiceReservation;
import services.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ListeReservationController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    
      private IService su = new ServiceReservation();
    private List<Reservation> res ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Accée");
        res=su.afficher(); // TODO
        System.out.println("Accée méthode");
        int column=0;
        int row=1;
        try {
            for(int i=0;i<res.size();i++){
                
                
                FXMLLoader loader = new FXMLLoader();
                //  loader=FXMLLoader.(getClass().getResource("ProductForm.fxml"));
                loader.setLocation(getClass().getResource("Reservation.fxml"));
                AnchorPane anchorPane = loader.load();
                ReservationController reservationController=loader.getController();
                reservationController.setData(res.get(i));
                if (column==2)
                {
                    column=0;
                    row++;
                }
                grid.add(anchorPane, column, row);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_PREF_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_PREF_SIZE);
                column++;
                GridPane.setMargin(anchorPane, new Insets(10));
                
            } }
        catch (IOException ex) {
            Logger.getLogger(ListeclientController.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        
        // TODO
    }

     

    @FXML
    private void BACK(ActionEvent event) throws IOException {
              Parent root= FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }
    
}
