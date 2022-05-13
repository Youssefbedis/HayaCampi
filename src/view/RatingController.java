/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author MAKREM
 */
public class RatingController implements Initializable {

    @FXML
    private Rating rating;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    



    @FXML
    private void BtnSubmit(ActionEvent event) {
             System.out.println("Rating given by user :" + rating.getRating());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rating");
         alert.setContentText("Rating=" +rating.getRating()+"/5"+"  "
                 + "    "+ "Thank you ! Have a nice day ");
        
        alert.show();
    }
    }
    
       

