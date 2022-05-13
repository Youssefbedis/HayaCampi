/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import models.Centre;
import models.Promotion;
import services.ServiceCentre;
import services.ServicePromotion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PromotionFrontController implements Initializable {

    @FXML
    private Pane PaneBlur;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox voboxid;
    @FXML
    private Button campingid;
    @FXML
    private Button promoid;
    @FXML
    private Button homebn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           // TODO
                 ServicePromotion sc=new ServicePromotion();
        List<Promotion> lsarticle = sc.afficher();
  

             for(Promotion elem: lsarticle)
       {
           
            
            System.out.println (elem.toString());
            Label lab1=new  Label();
            Label lab2=new  Label();
            Label lab3=new  Label();
                        Label lab5=new  Label();
            Label lab6=new  Label();
            Label lab7=new  Label();

           // ImageView iv=new ImageView();
            
           
            
            Label lab4 = new Label();
            HBox herbox = new HBox();
            VBox verbox = new VBox();
            
            ImageView imagev=new ImageView();
            lab1.setText(elem.getCentre().getNom_centre());
            lab1.setFont(Font.font(26));
            lab1.setPrefWidth(300);
            
            lab2.setText(elem.getAncien_prix().toString());
            lab2.setGraphic(imagev);
            lab2.setFont(Font.font(20));
            lab2.setPrefWidth(300);
            lab3.setText(elem.getNouveau_prix().toString());
            lab5.setText(elem.getDate_debut().toString());
            lab6.setText(String.valueOf(elem.getDuree()));
            // lab3.setText(elem.get());
            
            //      lab3.setPrefWidth(300);
            //  labdate.setText(elem.getCreatedAt());
            //      labdate.setPrefWidth(100);
          //  File im=new File(Statics.RelativeURL+elem.());
            //System.out.println(Statics.RelativeURL+"\\"+elem.getImageName());
                                // iv.setImage(new Image(im.toURI().toURL().toString()));
                  //  iv.setFitHeight(100);
                    //iv.setFitWidth(100);
                    verbox.getChildren().addAll(lab1,lab2,lab3,lab5,lab6);
                    herbox.getChildren().addAll(verbox);
                    herbox.setPrefWidth(voboxid.getMaxWidth());
                    herbox.getStyleClass().add("color-palette");
                    herbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    voboxid.getChildren().addAll(herbox,lab4);
       
        }
    }    
    @FXML
    private void tocamping(ActionEvent event) {
        
        try {
            URL fxUR = getClass().getResource("../GUI/FrontCentrefxml.fxml");
            Parent root = FXMLLoader.load(fxUR);
            Stage win = (Stage) campingid.getScene().getWindow();
            win.setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(FrontCentrefxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void topromo(ActionEvent event) {
         try {
            URL fxUR = getClass().getResource("../GUI/PromotionFront.fxml");
            Parent root = FXMLLoader.load(fxUR);
            Stage win = (Stage) promoid.getScene().getWindow();
            win.setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(FrontCentrefxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
