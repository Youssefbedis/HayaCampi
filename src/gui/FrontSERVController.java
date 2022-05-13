/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Service;
import models.Type;
import services.ServiceService;
import services.ServiceType;
import com.jfoenix.controls.JFXMasonryPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Nour
 */
public class FrontSERVController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private StackPane StckFrontProduit;
    @FXML
    private Pane PaneBlur;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnReset;
    @FXML
    private BorderPane bp;
    
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    private final JFXMasonryPane mansoryPane = new JFXMasonryPane();
    
    Service rec = new Service();
    ServiceService work = new ServiceService();
    ServiceType haya = new ServiceType();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        scrollPane.setStyle("-fx-background: rgb(255,255,255);\n -fx-background-color: rgb(255,255,255)");
        initMansoryCard();
        LoadCardProduits();
        file = new File("C:\\Users\\MAKREM\\Desktop\\CAMPING.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }    
    
    private void initMansoryCard() {
        mansoryPane.setPadding(new Insets(15, 15, 15, 15));
        mansoryPane.setVSpacing(5);
        mansoryPane.setHSpacing(5);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(mansoryPane);

    }
    
    private void LoadCardProduits() {

        mansoryPane.getChildren().clear();
        List<Service> listeServices = new ArrayList<>();
        List<Type> listeTypes = new ArrayList<>();
        listeServices = work.afficher(); //maram hatta afficher(rec)
        listeTypes = haya.afficher();

        if ((!listeServices.isEmpty())&&(!listeTypes.isEmpty())) {
            
            for (int i = 0; i < listeServices.size(); i++) {
                
                VBox root = new VBox();
                ImageView PreviewImageProduit = new ImageView();
                PreviewImageProduit.setFitWidth(120);
                PreviewImageProduit.setFitHeight(120);
                PreviewImageProduit.setPreserveRatio(false);
                PreviewImageProduit.setSmooth(true);
                PreviewImageProduit.setCache(true);


                String nom = listeServices.get(i).getType().getName();
                int id = listeServices.get(i).getId();
                int nom_id = listeServices.get(i).getName_id();
                String description = listeServices.get(i).getDescription();
                int prix = listeServices.get(i).getPrix();
                int nb_pers = listeServices.get(i).getNb_pers();
                // String image = listeServices.get(i).getImage();
               
                //
                File dest = new File("C:\\xampp\\htdocs\\Projet\\Uploads\\");
                File f = new File(dest, listeServices.get(i).getImage());
                //
                if (listeServices.get(i).getImage() != null) {
                    if (!f.exists()) {
                        try {
                            Image img = new Image(new FileInputStream("C:\\xampp\\htdocs\\Projet\\Uploads\\" + "nophoto.jpg"));
                            PreviewImageProduit.setImage(img);
                        } catch (FileNotFoundException ex) {
                            //Logger.getLogger(FrontProduitController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            // Image img = new Image(new FileInputStream(listeUser.get(i).getCarteidentity()));
                            Image img = new Image(new FileInputStream("C:\\xampp\\htdocs\\Projet\\Uploads\\" + listeServices.get(i).getImage()));
                            PreviewImageProduit.setImage(img);
                        } catch (FileNotFoundException ex) {
                            //   Logger.getLogger(FrontProduitController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else if (listeServices.get(i).getImage() == null) {

                    //identityView.setImage(new Image(getClass().getResource("/resources/image/empty-image.jpg").toString()));
                    File file = new File("C:\\xampp\\htdocs\\Projet\\Uploads\\" + "nophoto.jpg");
                    Image imagee = new Image(file.toURI().toString());
                    PreviewImageProduit.setImage(imagee);
                }
                root.setPadding(new Insets(12, 17, 17, 17));
                root.setSpacing(13);

                ///
                root.setStyle("-fx-background-color: #fff; -fx-background-radius: 15px;-fx-effect:dropshadow(three-pass-box, gray, 10, 0, 0, 0);");
                //labels[i].setTextFill(Color.color(1, 0, 0));

                Label LabelNom = new Label("" + nom);
                Label LabelDesc = new Label("" + description +"  ");
                Label LabelNbPers = new Label("Nombre de personnes: " + nb_pers +" PAX ");
                Label LabelPrix = new Label("Prix: " + prix + " DT");
                LabelPrix.setTextFill(Color.web("#202B36", 0.8));
          //      LabelNom.setTextFill(Color.web("#202B36", 0.8));
            //    LabelNom.setStyle("-fx-font-weight: bold");

                ////
                ImageView BuyProducticon;
                BuyProducticon = new ImageView(new Image("file:///C:/Users/Nour/Desktop/Desktop/WorkShope3A35/src/Images/buyicon.png"));
                BuyProducticon.setFitHeight(30);
                BuyProducticon.setFitWidth(30);
                HBox managebtn = new HBox(BuyProducticon);

                //if(Quantite>0)  // Yo93ed yaffichi mdem Quantite lproduit mawsoltech lel 0 ken woslt m3edech tetafficha
                
                root.getChildren().addAll(LabelNom, PreviewImageProduit, LabelPrix, LabelNbPers , managebtn);
//  root.getChildren().addAll( PreviewImageProduit, LabelPrix, LabelNbPers , managebtn);
                                
root.setAlignment(Pos.CENTER);
                mansoryPane.getChildren().add(root);
                

                BuyProducticon.setOnMouseClicked((MouseEvent event) -> {
                    System.out.println("icon NotVerified is pressed !");
                    // System.out.println("" + id);

                    //work.DecrementProduit(id); //  - 1 quantite
                    
                    
                    LoadCardProduits();
                    
                    
                });
                
            //}

            }
            }
        

    }

    @FXML
    private void GoToFournisseur(MouseEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("FXMLServiceBack.fxml"));
        StckFrontProduit.getChildren().removeAll();
        StckFrontProduit.getChildren().setAll(menu);
    }

    @FXML
    private void ghne(MouseEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("MediaPlayer.fxml"));
        StckFrontProduit.getChildren().removeAll();
        StckFrontProduit.getChildren().setAll(menu);
    }



    @FXML
    private void CloseWindowClicked(MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void playAct(ActionEvent event) throws Exception {
        mediaPlayer.play();
    }

    @FXML
    private void pauseAct(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    private void resetAct(ActionEvent event) {
        mediaPlayer.seek(Duration.seconds(0.0));
    }

    @FXML
    private void HOME(MouseEvent event) throws IOException {
          Parent root= FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }
    
}
