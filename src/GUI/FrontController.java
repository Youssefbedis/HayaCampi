/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Livreur;
import Services.ServiceLivreur;
import com.jfoenix.controls.JFXMasonryPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author chahi
 */
public class FrontController implements Initializable {

    @FXML
    private StackPane StckFrontProduit;
    @FXML
    private Pane PaneBlur;
    @FXML
    private ScrollPane scrollPane;
    private final JFXMasonryPane mansoryPane = new JFXMasonryPane();
    Livreur l = new Livreur();
    ServiceLivreur work = new ServiceLivreur();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         scrollPane.setStyle("-fx-background: rgb(255,255,255);\n -fx-background-color: rgb(255,255,255)");
        initMansoryCard();
        LoadCardProduits();
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
        List<Livreur> listeLivreurs = new ArrayList<>();
        listeLivreurs = work.afficher();

        if (!listeLivreurs.isEmpty()) {
            for (int i = 0; i < listeLivreurs.size(); i++) {
                VBox root = new VBox();
                ImageView PreviewImageProduit = new ImageView();
                PreviewImageProduit.setFitWidth(120);
                PreviewImageProduit.setFitHeight(120);
                PreviewImageProduit.setPreserveRatio(false);
                PreviewImageProduit.setSmooth(true);
                PreviewImageProduit.setCache(true);

                String nom = listeLivreurs.get(i).getNomLivreur();
                int numeroTelephone = listeLivreurs.get(i).getNumeroTelephone();
                String prenomLivreur = listeLivreurs.get(i).getPrenomLivreur();
                String Disponible = listeLivreurs.get(i).getDisponible();
                //
                File dest = new File("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\");
                File f = new File(dest, listeLivreurs.get(i).getImage());
                //
                if (listeLivreurs.get(i).getImage() != null) {
                    if (!f.exists()) {
                        try {
                            Image img = new Image(new FileInputStream("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\" + "nophoto.jpg"));
                            PreviewImageProduit.setImage(img);
                        } catch (FileNotFoundException ex) {
                            //Logger.getLogger(FrontProduitController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            // Image img = new Image(new FileInputStream(listeUser.get(i).getCarteidentity()));
                            Image img = new Image(new FileInputStream("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\" + listeLivreurs.get(i).getImage()));
                            PreviewImageProduit.setImage(img);
                        } catch (FileNotFoundException ex) {
                            //   Logger.getLogger(FrontProduitController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else if (listeLivreurs.get(i).getImage() == null) {

                    //identityView.setImage(new Image(getClass().getResource("/resources/image/empty-image.jpg").toString()));
                    File file = new File("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\" + "nophoto.jpg");
                    Image imagee = new Image(file.toURI().toString());
                    PreviewImageProduit.setImage(imagee);
                }
                root.setPadding(new Insets(12, 17, 17, 17));
                root.setSpacing(13);

                ///
                root.setStyle("-fx-background-color: #fff; -fx-background-radius: 15px;-fx-effect:dropshadow(three-pass-box, gray, 10, 0, 0, 0);");
                //labels[i].setTextFill(Color.color(1, 0, 0));

                Label LabelNom = new Label("" + nom);
                Label LabelQte = new Label("Disponible : " + Disponible );
                Label LabelPrix = new Label("" + prenomLivreur );
               

                LabelPrix.setTextFill(Color.web("#202B36", 0.8));
               // LabelNom.setTextFill(Color.web("#202B36", 0.8));
                //LabelNom.setStyle("-fx-font-weight: bold");

                ////
                ImageView BuyProducticon;
                BuyProducticon = new ImageView(new Image("file:///C:/Users/chahi/OneDrive/Desktop/Workshop3A36/src/Image/email.PNG"));
                BuyProducticon.setFitHeight(30);
                BuyProducticon.setFitWidth(30);
                HBox managebtn = new HBox(BuyProducticon);

            if(numeroTelephone>0)  // Yo93ed yaffichi mdem Quantite lproduit mawsoltech lel 0 ken woslt m3edech tetafficha
                {
                root.getChildren().addAll(LabelNom, PreviewImageProduit, LabelPrix, LabelQte , managebtn);
                root.setAlignment(Pos.CENTER);
                mansoryPane.getChildren().add(root);
                }

                BuyProducticon.setOnMouseClicked((MouseEvent event) -> {
                    System.out.println("icon NotVerified is pressed !");
                    // System.out.println("" + id);

                  //  work.DecrementProduit(id); //  - 1 quantite
                    
                    
                    LoadCardProduits();
                    
                    
                });

            }

        }

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
         System.exit(0);
    }
    
}
