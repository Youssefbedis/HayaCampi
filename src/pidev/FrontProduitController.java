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
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author MAKREM
 */
public class FrontProduitController implements Initializable {

    @FXML
    private StackPane StckFrontProduit;
    @FXML
    private Pane PaneBlur;
    @FXML
    private ScrollPane scrollPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToFournisseur(MouseEvent event) {
    }

    @FXML
    private void GoToProduit(MouseEvent event) {
    }

    @FXML
    private void GoToHomeProduit(MouseEvent event) {
    }

    @FXML
    private void CloseWindowClicked(MouseEvent event) {
    }
    
}
