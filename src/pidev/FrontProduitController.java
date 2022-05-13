/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FrontProduitController implements Initializable {

    @FXML
    private StackPane StckFrontProduit;
    @FXML
    private Pane PaneBlur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CloseWindowClicked(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void Editprofil(MouseEvent event) {
        
    }

    @FXML
    private void Reservation(MouseEvent event) {
    }
    
}
