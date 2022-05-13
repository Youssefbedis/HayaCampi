/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import services.ServiceCentre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import utils.Statics1;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SingleCentreFXMLController implements Initializable {

    @FXML
    private StackPane StckFrontProduit;
    @FXML
    private Pane PaneBlur;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Text nomcen;
    @FXML
    private ImageView imgv;
    @FXML
    private Text txtrue;
    @FXML
    private Text ville;
    @FXML
    private Text txtdescrition;
    @FXML
    private Text mailtxt;
    @FXML
    private Text prixtxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int cenid=Statics1.CEN.getId();
        ListView<VBox> li=new ListView<>();
        ServiceCentre sc=new ServiceCentre();
    }    
    
}
