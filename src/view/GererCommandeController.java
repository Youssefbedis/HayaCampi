/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdbc.jdbc;
import models.Commande;
import services.serviceCommande;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class GererCommandeController implements Initializable {

    @FXML
    private TableView<Commande> tablecommande;
    @FXML
    private TableColumn<Commande, Integer> id;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TableColumn<Commande, String> num;
    @FXML
    private TableColumn<Commande, String> rue;
    @FXML
    private TableColumn<Commande, String> ville;
    @FXML
    private TableColumn<Commande, String> numtel;
    @FXML
    private TableColumn<Commande, String> num_carte;
    @FXML
    private TableColumn<Commande, String> mode;
    @FXML
    private TextField recherche;
    @FXML
    private TextField inputrue;
    @FXML
    private TextField inputville;
    @FXML
    private TextField inputtel;
    @FXML
    private TextField inputcarte;

        ObservableList<String> listmode = FXCollections.observableArrayList( "Sur Place","En ligne");
    private Statement ste;
    private Connection con;
    private final ObservableList<Commande> data = FXCollections.observableArrayList();
    @FXML
    private TextField inputnum;

    serviceCommande sc = new serviceCommande();
    @FXML
    private Label idlbl;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                combo.setItems(listmode);
                
                Aff();   
    }

           public void Aff(){
                        try {
            con = jdbc.getInstance().getCnx();
            ste = con.createStatement();
            data.clear();

          //  ResultSet rs = ste.executeQuery("select * from commande where idUser="+2);
            ResultSet rs = ste.executeQuery("select * from commande ");
            while(rs.next()){
                Commande f = new Commande();
                f.setId(rs.getInt("id"));
                f.setNum(rs.getString("num"));
                f.setRue(rs.getString("rue"));
                f.setVille(rs.getString("ville"));
                f.setNum_tel(rs.getString("num_tel"));
                f.setNum_carte(rs.getString("num_carte"));
                f.setMode(rs.getString("mode"));
                data.add(f);
            }
        } catch (Exception e) {
                //Logger.getLogger(tab)
        }
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            num.setCellValueFactory(new PropertyValueFactory<>("num"));
            rue.setCellValueFactory(new PropertyValueFactory<>("rue"));
            ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
            numtel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
            num_carte.setCellValueFactory(new PropertyValueFactory<>("num_carte"));
            mode.setCellValueFactory(new PropertyValueFactory<>("mode"));
         
            tablecommande.setItems(data);
            RechercheAV();
           }
           
                 public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Commande> filteredData = new FilteredList<>(data, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		recherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(tmp -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (tmp.getVille().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (tmp.getRue().indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Commande> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tablecommande.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tablecommande.setItems(sortedData);
    }

    @FXML
    private void Supprimer(ActionEvent event) {
                
                        tablecommande.setItems(data);

             ObservableList<Commande> alldomains,Singledomain ;
             alldomains=tablecommande.getItems();
             Singledomain=tablecommande.getSelectionModel().getSelectedItems();
             Commande A = Singledomain.get(0);
             sc.supprimer(A);
             Singledomain.forEach(alldomains::remove);
             Aff();

    }

    @FXML
    private void Ajouter(ActionEvent event) {
                if(Validchamp(inputnum) && Validchamp(inputrue) && Validchamp(inputville) && Validchamp(inputcarte))
        {
                Commande of= new Commande();
                of.setUser_id(6);
                of.setNum(inputnum.getText());
                of.setRue(inputrue.getText());
                of.setVille(inputville.getText());
                of.setNum_tel(inputtel.getText());
                of.setNum_carte(inputcarte.getText());
                of.setMode(combo.getSelectionModel().getSelectedItem());
                sc.ajouter(of);
     
        Aff();
        RechercheAV();  
        }
        else
        {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Verifiez les champs!");

        alert.showAndWait();
        }
                             TrayNotification tray= new TrayNotification();
        AnimationType anim = AnimationType.POPUP;
        tray.setAnimationType(anim);
        tray.setTitle("Notifications");
        tray.setMessage("commande ajouté avec succès");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(5)); 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("commande is added successfully!");
        alert.show();
        

    }
                private boolean Validchamp(TextField T){
        return !T.getText().isEmpty() && T.getLength() >= 2;
    }

    @FXML
    private void modifer(ActionEvent event) {
                        if(Validchamp(inputnum) && Validchamp(inputrue) && Validchamp(inputville) && Validchamp(inputcarte))
        {
                Commande of= new Commande();
                of.setId(Integer.valueOf(idlbl.getText()));
                of.setUser_id(6);
                of.setNum(inputnum.getText());
                of.setRue(inputrue.getText());
                of.setVille(inputville.getText());
                of.setNum_tel(inputtel.getText());
                of.setNum_carte(inputcarte.getText());
                of.setMode(combo.getSelectionModel().getSelectedItem());
                sc.modifier(of);
        
        Aff();
        RechercheAV();  
        }
        else
        {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Verifiez les champs!");

        alert.showAndWait();
        }
    }

    @FXML
    private void SelectedModif(MouseEvent event) {
        
        
        tablecommande.setItems(data);

             ObservableList<Commande> alldomains,Singledomain ;
             alldomains=tablecommande.getItems();
             Singledomain=tablecommande.getSelectionModel().getSelectedItems();
             Commande A = Singledomain.get(0);
             idlbl.setText(String.valueOf(A.getId()));
             inputnum.setText(A.getNum());
             inputrue.setText(A.getRue());
             inputville.setText(A.getVille());
             inputcarte.setText(A.getNum_carte());
             inputtel.setText(A.getNum_tel());
             combo.setValue(A.getMode());
    }

    @FXML
    private void stat(ActionEvent event) throws IOException {
          Parent root= FXMLLoader.load(getClass().getResource("Statistique.fxml"));
        Stage stage = new Stage();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void rating(ActionEvent event) throws IOException {
         Parent root= FXMLLoader.load(getClass().getResource("Rating.fxml"));
        Stage stage = new Stage();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void qrCode(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("QrCode.fxml"));
        Stage stage = new Stage();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void gohome(ActionEvent event) throws IOException {
         Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("gui/Dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage.setTitle("login");
        //Scene SM=new Scene(root);
       
      stage.setScene(new Scene(root));
        stage.show();
    }

}
