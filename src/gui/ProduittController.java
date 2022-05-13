/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Pdf;
import models.produit;
import services.ServiceProduit;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Amirov
 */
public class ProduittController implements Initializable {

    @FXML
    private Button supp;
    @FXML
    private TextField nom;
    @FXML
    private TextField desc;
    @FXML
    private TextField etat;
    @FXML
    private TextField img;
    @FXML
    private TextField id;
    @FXML
    private TextField cat;
    @FXML
    private Label listP;
    @FXML
    private Button afficher;
    @FXML
    private Button ajt;
    @FXML
    private Button mod;
    @FXML
    private TextField rec;
    @FXML
    private ComboBox<?> choisir;
    @FXML
    private Button btnTrier;
    @FXML
    private Button pdfm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimer(ActionEvent event)  throws SQLException {
        
                         ServiceProduit sp = new ServiceProduit() ;   

        
      StringBuilder errors=new StringBuilder();
        
        if(id.getText().trim().isEmpty()){
            errors.append("svp enter un id\n");
        }
     
     if(errors.length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
     
                   sp.supprimer(Integer.parseInt(id.getText()));

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Produit is delete successfully!");
            alert.show();
            Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("arbitre supprimer avec succÃ©").graphic(null).hideAfter(Duration.seconds(6))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show(); 
          
    }
        
    

    @FXML
    private void afficher(ActionEvent event) throws SQLException {
                 ServiceProduit sp = new ServiceProduit() ;   
        
            listP.setText(sp.afficher().toString());
    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        
                 ServiceProduit sa = new ServiceProduit() ;   
      StringBuilder errors=new StringBuilder();
        
         if(nom.getText().trim().isEmpty()&&etat.getText().trim().isEmpty()){
            errors.append("svp enter un nom et etat\n");
        }
     
     if(errors.length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
       produit a = new produit(nom.getText(),desc.getText(),etat.getText(),img.getText(),cat.getText());
        
            
        sa.ajouter(a);
      //   Mailing.sendMail(a.getEmail(), a.getNomArb()) ;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText(" vous etes ajoute avec succes veuillez cousulter fotre email !");
            alert.show();
            nom.setText("");
            desc.setText("");
            etat.setText("");
            img.setText("");
            cat.setText("");


        Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("arbitre ajoutÃ© avec succÃ©").graphic(null).hideAfter(Duration.seconds(6))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show(); 

  
    }

    @FXML
    private void modifier(ActionEvent event) throws ParseException {
        
          produit m = new produit();
           StringBuilder errors=new StringBuilder();
        
        if(id.getText().trim().isEmpty()){
            errors.append("Please enter an id\n");
        }
     
     if(errors.length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
                 ServiceProduit sa = new ServiceProduit() ;   
        m.setId(Integer.parseInt(id.getText()));
        m.setNom(nom.getText());
        m.setDescription(desc.getText());
        m.setEtat(etat.getText());
        m.setImage(img.getText());
        m.setCategorie(cat.getText());

        sa.modifier(m);
    
           Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("Match est modifiée avec succÃ©").graphic(null).hideAfter(Duration.seconds(6))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show(); 
        
    }

    @FXML
      private void rec(KeyEvent event) {
                 ServiceProduit sa = new ServiceProduit() ;   
    
    //listP.setText(sa.FindBy(choisir.getSelectionModel().getSelectedItem(),rec.getText()).toString());
    }

    @FXML
    private void affichrtTri(ActionEvent event) {
        
                 ServiceProduit sa = new ServiceProduit() ;   
 //   listP.setText(sa.TrierPrd(choisir.getSelectionModel().getSelectedItem()).toString());
    }

    @FXML
   private void pdfm(ActionEvent event) throws DocumentException, BadElementException, IOException, FileNotFoundException, InterruptedException, SQLException {
        Pdf pd=new Pdf();
        try{
        pd.GeneratePdfm("list of Produit");
            System.out.println("impression done");
        } catch (Exception ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
    
    
}
