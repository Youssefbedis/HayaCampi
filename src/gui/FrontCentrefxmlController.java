/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import models.Centre;
import services.ServiceCentre;
import com.sun.activation.viewers.TextViewer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.Statics1;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FrontCentrefxmlController implements Initializable {

    @FXML
    private StackPane StckFrontProduit;
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
    @FXML
    private ImageView home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 ServiceCentre sc=new ServiceCentre();
        List<Centre> lsarticle = sc.afficher();
  

             for(Centre elem: lsarticle)
       {
           
            
            System.out.println (elem.toString());
            Label lab1=new  Label();
            Label lab2=new  Label();
            Label lab3=new  Label();
            ImageView iv=new ImageView();
            Button btdetail=new Button();
            Button btmodif=new Button();
            Button btdelete=new Button();
            btdetail.setText("details");
            btdetail.setOnAction(event ->{
                try {
                    URL fxURL = getClass().getResource("../GUI/Centrefxml.fxml");
                    Statics1.CEN=elem;
                    //URL fxURL = getClass().getResource("../gui1/Payment.fxml");
                    Parent root = FXMLLoader.load(fxURL);
                    Stage win = (Stage) btdetail.getScene().getWindow();
                    win.setScene(new Scene(root));
                    
                } catch (IOException ex) {            System.out.println(ex);
                
                }
            });
            
            Label lab4 = new Label();
            HBox herbox = new HBox();
            VBox verbox = new VBox();
            
            ImageView imagev=new ImageView();
            lab1.setText(elem.getNom_centre());
            lab1.setFont(Font.font(26));
            lab1.setPrefWidth(300);
            
            lab2.setText(elem.getDescription());
            lab2.setGraphic(imagev);
            lab2.setFont(Font.font(20));
            lab2.setPrefWidth(300);
            
            // lab3.setText(elem.get());
            
            //      lab3.setPrefWidth(300);
            //  labdate.setText(elem.getCreatedAt());
            //      labdate.setPrefWidth(100);
            File im=new File(Statics1.RelativeURL+elem.getImageName());
            System.out.println(Statics1.RelativeURL+elem.getImageName());
            try {
                System.out.println(im.toURI().toURL().toString());
            } catch (MalformedURLException ex) {
                System.out.println(ex);
            }
            try{
            Image mm=   new Image(new FileInputStream(Statics1.BASE_URL+elem.getImageName()));
            iv.setImage(mm);
            }catch(Exception ex){
                System.err.println(ex);
            }   
                    // iv.setImage(new Image(im.toURI().toURL().toString()));
                    iv.setFitHeight(100);
                    iv.setFitWidth(100);
                    verbox.getChildren().addAll(lab1,lab2,btdetail);
                    herbox.getChildren().addAll(iv,verbox);
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

    @FXML
    private void home(MouseEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("gui/Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }
                   
    }    
