/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import models.Centre;
import services.ServiceCentre;
import animatefx.animation.Shake;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import jdbc.jdbc;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.JavaMailUtil1;
import animatefx.animation.Shake;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import javafx.scene.Node;
import static gui.CentrefxmlController.shake;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import utils.PDF;
import utils.SMSApi;
import utils.Statics1;


/**
 * FXML Controller class
 *
 * @author user
 */
public class CentrefxmlController implements Initializable {

    @FXML
    private TextField TFnom;
    @FXML
    private TextField TFnum;
    @FXML
    private TextField TFrue;
    @FXML
    private TextField TFville;
    @FXML
    private TextField TFmail;
    @FXML
    private TextField TFdescription;
    @FXML
    private TextField TFprix;
    private Label affichage;
    @FXML
    private TextField TFchercher;
    @FXML
    private ListView<Centre> listView;
    @FXML
    private Button modifierbtn;
    @FXML
    private Button btimg;
        File selectedFile; 
    private String path;
    @FXML
    private ImageView ImageIV;
    @FXML
    private Text imagepath;
    @FXML
    private Button homho;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       /* MyDb connectNow = new MyDb();
    Connection cnx =connectNow.getCnx();
String querry = "SELECT * from centre";
try{
 Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            String nom = rs.getString("nom_centre");
            int num = rs.getInt("num");
            String rue = rs.getString("rue");
            String ville = rs.getString("ville");
            String mail = rs.getString("mail");
            String description = rs.getString("description");
            String image = rs.getString("image_name");
            Float prix = rs.getFloat("prix");
            String listOut= "Nom Centre :"+"  "+nom+ "|" + "Num:"+"  "+num +"|"+ "Rue:"+"  " +rue+"|"+ "ville:"+"  "+ville+ "|" + "mail:"+"  "+mail+"|"+ "description:"+"  "+description+"|" + "image_name:"+"  "+image+ "|" + "prix:"+" "+prix;
            listView.getItems().add(listOut);
           // listView.getItems().add(listOut);
           

        }}
catch(Exception e ){
}*/
       ServiceCentre sc =  new ServiceCentre();
       List<Centre> list= sc.afficher();
        for(Centre c:list){
           
            listView.getItems().add(c);
        }
        
            sc.exel();
        
        
    }    
    @FXML
    void sendtoedit(MouseEvent m){
        Centre c = listView.getSelectionModel().getSelectedItem();
        cid=c.getId();
        TFnom.setText(c.getNom_centre());
        TFnum.setText(c.getNum()+"");
        TFrue.setText(c.getRue());
        TFville.setText(c.getVille());
        TFmail.setText(c.getMail());
        TFdescription.setText(c.getDescription());
        imagepath.setText(c.getImageName());
        TFprix.setText(c.getPrix()+"");
     
    }
    private int cid;
    @FXML
    private void ajoutercentre(ActionEvent event) throws Exception {
        
        if (TFnom.getText().isEmpty()) {
            alert_Box("Vérifiez le type", "Veuillez remplir le champ Type");
            TFnom.requestFocus();
            shake(TFnom);

        } /*else if (tfDescription.getText().isEmpty()) {
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
    }*/
    else 
         {    
        System.out.println("Yes");
         }
        
         ServiceCentre sc = new ServiceCentre();
         Centre c;
        c = new Centre(TFnom.getText(),Integer.parseInt(TFnum.getText()),TFrue.getText()
                ,TFville.getText() ,TFmail.getText() ,TFdescription.getText(),imagepath.getText()
                ,Float.parseFloat(TFprix.getText()));
    sc.ajouter(c);
    JavaMailUtil1.sendMail(c.getMail());
        
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("centre is added successfully!");
        alert.show();
        
        TrayNotification tray= new TrayNotification();
        AnimationType anim = AnimationType.POPUP;
        tray.setAnimationType(anim);
        tray.setTitle("Notifications");
        tray.setMessage("Centre ajouté avec succès");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(5)); 
        //((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        
        //SEND SMS
        SMSApi sms = new SMSApi();
        sms.sendSMS("+21626718545", "Admin.");

          Alert a = new Alert(Alert.AlertType.INFORMATION, "Pub added !", ButtonType.OK);
          a.showAndWait();
   // sc.ajouter(new Centre(0, TFnom.getText(), TFnum.getText() , TFrue.getText() ,TFville.getText() , TFmail.getText() ,TFdescription.getText(),TFimage.getText(),TFprix.getText() ));
    }
    /*@FXML
    private void BtnAjouter(ActionEvent event) {
         ServiceCommande sc = new ServiceCommande();
    // sc.ajouter(new Commande(0, TfNum.getText(),TfRue.getText(),CbVille.getValue(),TfNumTel.getText(),TfNumCarte.getText(),CbMode.getValue()));
         String cbVille = (String)CbVille.getSelectionModel().getSelectedItem();
          String cbMode = (String)CbMode.getSelectionModel().getSelectedItem();
         
     Commande c = new Commande(Integer.parseInt(TfNum.getText()),TfRue.getText(),cbVille,Integer.parseInt(TfNumTel.getText()),Long.parseLong(TfNumCarte.getText()),cbMode);
   sc.ajouter(c);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("commande is added successfully!");
        alert.show();
   
       
   }*/
    
    

   /* @FXML
    private void BtnAfficher(ActionEvent event) {
         
     ServiceCommande sc = new ServiceCommande();
   LbAfficher.setText(sc.afficher().toString());
    }*/

    @FXML
    private void affichercentres(ActionEvent event) {
        ServiceCentre sc = new ServiceCentre();
        affichage.setText(sc.afficher().toString());
    }

    @FXML
    private void cherchercentre(ActionEvent event) {
    }
    @FXML
    private void modifier(ActionEvent event) {
        Centre c;
        ServiceCentre sc = new ServiceCentre();
                c = new Centre(TFnom.getText(),Integer.parseInt(TFnum.getText()),TFrue.getText()
                ,TFville.getText() ,TFmail.getText() ,TFdescription.getText(),imagepath.getText()
                ,Float.parseFloat(TFprix.getText()));
                        c.setId(cid);
        System.err.println(c.toString()+"  techh  "+c.getId());
        sc.modifier(c);
        
        
   
   
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("commande is modified successfully!");
        alert.show();
        
    
        
    }
    

    @FXML
    private void tricentres(ActionEvent event) {
        ServiceCentre sc = new ServiceCentre();
       List<Centre> list =sc.tri();
       listView.getItems().clear();
       for(Centre c:list)
           
            listView.getItems().add(c);
    }
    
    public static void shake(Node node) {
        new Shake(node).play();
    }
    public void alert_Box(String title, String message) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle(title);
         alert.setContentText(message);
         alert.show();
    }

    @FXML
    private void pdff(ActionEvent event) throws DocumentException, BadElementException, IOException, FileNotFoundException, InterruptedException, SQLException {
        PDF PF = new PDF();
        PF.GeneratePdf("fff");
    }

    @FXML
    private void suprimercentre(ActionEvent event) {
         ServiceCentre sc = new ServiceCentre();
      if (listView.getSelectionModel().getSelectedItem() != null) {
          ObservableList <Centre> list2 = FXCollections.observableArrayList();
          Centre listOut=listView.getSelectionModel().getSelectedItem();
              
               
          listView.getItems().remove(listOut);
                
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Success");
                  alert.setContentText("Livreur is deleted successfully!");
                  alert.show();

                 
      }
    }
     @FXML
    private void ImportImage(ActionEvent event) throws MalformedURLException {
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

            path = selectedFile.getName();
            ImageIV.setImage(new Image(selectedFile.toURI().toURL().toString()));
            ImageIV.setFitHeight(150);
            ImageIV.setFitWidth(250);
            imagepath.setText(path);
            File tagetFile=new File(Statics1.BASE_URL);
            System.out.println(tagetFile.toURI().toURL().toString());
            copyFiles(selectedFile, tagetFile);
        }  
    }
    public static void copyFiles(File sourceLocation , File targetLocation) {

       
                InputStream in = null;
        try {
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
        } catch (FileNotFoundException ex) {
 System.out.println(ex);            } catch (IOException ex) {
 System.out.println(ex);            } finally {
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println(ex);            }
        }
            
            }            

    @FXML
    private void homiee(ActionEvent event) throws IOException {
        
        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("gui/Dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }
}
  
    

