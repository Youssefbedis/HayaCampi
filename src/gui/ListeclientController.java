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
public class ListeclientController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private IServiceUser su = new ServiceUtilisateur();
    private List<Utilisateur> users ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("rani dkhalt");
        try {
            
            users=su.afficheruser();
            
             System.out.println("7ata ena nemchi");
            int column=0;
            int row=1;
            try {
                for(int i=0;i<users.size();i++){
                    
                    
                    FXMLLoader loader = new FXMLLoader();
                    //  loader=FXMLLoader.(getClass().getResource("ProductForm.fxml"));
                    loader.setLocation(getClass().getResource("User.fxml"));
                    AnchorPane anchorPane = loader.load();
                    UserController userController=loader.getController();
                    userController.setData(users.get(i));
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
        catch (SQLException ex) {
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
