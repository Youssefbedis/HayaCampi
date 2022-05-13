/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Service;
import models.Type;
import services.ServiceService;
import services.ServiceType;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
//import org.controlsfx.control.Notifications;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import tray.notification.TrayNotification;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
//import com.github.plushaze.traynotification.*;
//import org.controlsfx.control.Notifications;
import animatefx.animation.Shake;
import javafx.scene.Node;
import static gui.FXMLServiceController.shake;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import utils.Statics;


/**
 * FXML Controller class
 *
 * @author Nour
 */
public class FXMLServiceController implements Initializable {

    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfNbPers;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfImage;
    @FXML
    private ChoiceBox<Type> tfType;
    @FXML
    private TextField tfRecherche;
    private Label lbAfficher;
    @FXML
    private TextField tfName;
    @FXML
    private ListView<Type> listViewT;
    @FXML
    private ListView<Service> listViewS;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnReset;
    @FXML
    private StackPane stackServiceBack;
    
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    File selectedFile; 
    private String path;
    @FXML
    private ImageView ImageIV;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
        /*tfType.getItems().add("Maladie");
        tfType.getItems().add("Sans solde");*/
        ServiceType sc =  new ServiceType();
       List<Type> list= sc.afficher();
        for(Type c:list){
           
            listViewT.getItems().add(c);
        }
        
      ServiceService ss =  new ServiceService();
       List<Service> liste = ss.afficher();
        for(Service s:liste){
           
            listViewS.getItems().add(s);
        }
        
        for(Type t: list)
            tfType.getItems().add(t);
        
        file = new File("C:\\Users\\MAKREM\\Desktop\\CAMPING.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    
            
    
    }    
    public void alert_Box(String title, String message) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle(title);
         alert.setContentText(message);
         alert.show();
    }
    @FXML
    private void btnAjouter(ActionEvent event) throws SQLException, FileNotFoundException {
        // controle de saisie
       
        if (tfType.getItems().isEmpty()) {
            alert_Box("Vérifiez le type", "Veuillez remplir le champ Type");
            tfType.requestFocus();
            shake(tfType);

        } else if (tfDescription.getText().isEmpty()) {
            alert_Box("Vérifiez la description", "Veuillez remplir le champ Description");
            tfDescription.requestFocus();
            shake(tfDescription);

        } else if (tfPrix.getText().isEmpty()) {
            alert_Box("Verifier le prix", "Veuillez remplir le champ Prix");
            tfPrix.requestFocus();
            shake(tfPrix);
            
        } else if (tfNbPers.getText().isEmpty()) {
            alert_Box("Verifier le Nombre de personnes", "Veuillez remplir le champ Nombre de personnes");
            tfNbPers.requestFocus();
            shake(tfNbPers);
    }
    else 
         {    
        System.out.println("Yes");
    
    //ajout du conge
        ServiceService cong = new ServiceService();
        Type type = tfType.getSelectionModel().getSelectedItem();
        Service c= new Service(Integer.parseInt(tfPrix.getText()), Integer.parseInt(tfNbPers.getText()), tfDescription.getText(), tfImage.getText(), type);
        
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Service is added successfully!");
        alert.show();
        cong.ajouter(c);
        listViewS.getItems().add(c);

        
        TrayNotification tray= new TrayNotification();
        AnimationType anim = AnimationType.POPUP;
        tray.setAnimationType(anim);
        tray.setTitle("Notifications");
        tray.setMessage("Congé ajouté avec succès");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(5)); 
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        cong.ajouter(c);

         }
    }
    @FXML
    private void btnAfficher(ActionEvent event) {
        ServiceService sc = new ServiceService();
        lbAfficher.setText(sc.afficher().toString());
    }

    @FXML
    private void btnToutEffacer(ActionEvent event) {
    }

    @FXML
    private void btnAnnuler(ActionEvent event) {
    }

    @FXML
    private void btnRecherche(ActionEvent event) {
    }


    @FXML
    private void btnModifierType(ActionEvent event) {
    
        ServiceType sc = new ServiceType();
      Type c =  new Type(tfName.getText());
        System.out.println(c);
      sc.modifier(c);
        
   listViewT.getItems();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("type is modified successfully!");
        alert.show();
        
    }

    @FXML
    private void btnSupprimerType(ActionEvent event) {
        ServiceType sc = new ServiceType();
      if (listViewT.getSelectionModel().getSelectedItem() != null) {
          ObservableList <Type> list2 = FXCollections.observableArrayList();
          Type type =listViewT.getSelectionModel().getSelectedItem(); 
               sc.supprimer(type.getId());
               
          listViewT.getItems().remove(type);
                list2.remove(list2);
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Success");
                  alert.setContentText("type is deleted successfully!");
                  alert.show();

                 
      }
    }

    @FXML
    private void btnAjouterType(ActionEvent event) {
        ServiceType sc = new ServiceType();
         Type t = new Type(tfName.getText());
    sc.ajouter(t);
        
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("centre is added successfully!");
        alert.show();
    }

    @FXML
    private void btnSupprimer(ActionEvent event) {
      /*  ServiceService sc = new ServiceService();
      if (listViewS.getSelectionModel().getSelectedItem() != null) {
          ObservableList <Service> list2 = FXCollections.observableArrayList();
          Service service =listViewS.getSelectionModel().getSelectedItem(); 
               sc.supprimer(service.getId());
               
          listViewT.getItems().remove(service);
                list2.remove(list2);
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Success");
                  alert.setContentText("type is deleted successfully!");
                  alert.show();*/
                  
                  ServiceService sc = new ServiceService();
      if (listViewS.getSelectionModel().getSelectedItem() != null) {
          ObservableList <Service> list2 = FXCollections.observableArrayList();
          Service listOut=listViewS.getSelectionModel().getSelectedItem();
              
               
          listViewS.getItems().remove(listOut);
                
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Success");
                  alert.setContentText("Livreur is deleted successfully!");
                  alert.show();

                 
      
    }}

    private int cid ;
    @FXML
    private void sendtoedit(javafx.scene.input.MouseEvent event) {
                Type t = listViewT.getSelectionModel().getSelectedItem();
        cid=t.getId();
        tfName.setText(t.getName());
    }

    @FXML
    private void sendtoedit1(javafx.scene.input.MouseEvent event) {
        /*Service t = listViewT.getSelectionModel().getSelectedItem();
        cid=t.getId();
        tfName.setText(t.getName());*/
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

  
    public static void shake(Node node) {
        new Shake(node).play();
    }
    
    @FXML
    private void ImportImage(ActionEvent event) throws MalformedURLException, FileNotFoundException {
                FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

                    try {
                        path = selectedFile.getName();
                        ImageIV.setImage(new Image(selectedFile.toURI().toURL().toString()));
                        ImageIV.setFitHeight(150);
                        ImageIV.setFitWidth(250);
                        tfImage.setText(path);
                        File tagetFile=new File(Statics.BASE_URL);
                        System.out.println(tagetFile.toURI().toURL().toString());
                        copyFiles(selectedFile, tagetFile);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLServiceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }  
    }
    public static void copyFiles(File sourceLocation , File targetLocation) throws FileNotFoundException, IOException {

       
                InputStream in = null;
                in = new FileInputStream(sourceLocation);
                OutputStream out = new FileOutputStream(targetLocation+"\\"+sourceLocation.getName());
                System.out.println(targetLocation+"\\"+sourceLocation.getName());
                // Copy the bits from input stream to output stream
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                System.out.println("image ");
                in.close();
            }            
    
    
    
    /*@FXML
    private void GoToFournisseur(javafx.scene.input.MouseEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("FXMLService.fxml"));
        stackServiceBack.getChildren().removeAll();
        stackServiceBack.getChildren().setAll(menu);
    }*/

    @FXML
    private void GoToStat(javafx.scene.input.MouseEvent evenet) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("FXMLStatService.fxml"));
        stackServiceBack.getChildren().removeAll();
        stackServiceBack.getChildren().setAll(menu);
    }

    
    @FXML
    private void CloseWindowClicked(javafx.scene.input.MouseEvent event) {
        System.exit(0);
    }

    private void GoToHomeee(javafx.scene.input.MouseEvent event) throws IOException {
                Parent menu = FXMLLoader.load(getClass().getResource("FXMLServiceFront.fxml"));
        stackServiceBack.getChildren().removeAll();
        stackServiceBack.getChildren().setAll(menu);
    }

    @FXML
    private void music(javafx.scene.input.MouseEvent event) throws IOException {
                Parent menu = FXMLLoader.load(getClass().getResource("MediaPlayer.fxml"));
        stackServiceBack.getChildren().removeAll();
        stackServiceBack.getChildren().setAll(menu);
    }

    @FXML
    private void back(javafx.scene.input.MouseEvent event) throws IOException {
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("gui/Dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }

    
}
