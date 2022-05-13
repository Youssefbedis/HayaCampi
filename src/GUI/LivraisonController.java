/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.LivreurController.shake;
import Model.Livraison;
import Model.Livreur;
import Services.ServiceLivraison;
import animatefx.animation.Shake;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author chahi
 */
public class LivraisonController implements Initializable {

    @FXML
    private TableView<Livraison> TableViewLivraisons;
    @FXML
    private TableColumn<Livraison, String> col_com;
    @FXML
    private TableColumn<Livraison, String> col_prix;
    @FXML
    private TableColumn<Livraison, String> col_ref;
    @FXML
    private TableColumn<Livraison, String> col_Action;
    @FXML
    private Pane PaneBlur;
    @FXML
    private Pane PaneFormulaire;
    @FXML
    private JFXTextField txtprix;
    @FXML
    private JFXTextArea txtcom;
    @FXML
    private JFXButton btnModifier;
    @FXML
    private JFXTextField txtref;
    @FXML
    private Text TitreFormulaire;
    @FXML
    private JFXButton btnAjouter;
    
    Livraison rec = new Livraison();
    ServiceLivraison work = new ServiceLivraison();
     private ObservableList<Livraison> ListLivraisons;
    @FXML
    private StackPane StckFournisseur;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       LoadTableLivraison();

    }    


    @FXML
    private void GoToProduit(MouseEvent event) {
    }

    @FXML
    private void GoToHomeProduit(MouseEvent event) {
    }

    @FXML
    private void OpenFormulaireAdd(MouseEvent event) {
        txtcom.clear();
        txtprix.clear();
        txtref.clear();
        btnAjouter.toFront();
        TitreFormulaire.setText("Ajouter une Livraison");
        PaneFormulaire.setVisible(true);
        PaneBlur.setVisible(true);
    }

    @FXML
    private void CloseFormulaireClicked(MouseEvent event) {
         PaneFormulaire.setVisible(false);
        PaneBlur.setVisible(false);
    }


    @FXML
    private void CloseWindowClicked(MouseEvent event) {
         System.exit(0);
    }
    
    
       private void LoadTableLivraison() {

        List<Livraison> listee = new ArrayList<>();
        listee = work.Afficher();
        ObservableList<Livraison> Liste = FXCollections.observableArrayList(listee);

        col_com.setCellValueFactory(new PropertyValueFactory<>("id_commande"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
        col_ref.setCellValueFactory(new PropertyValueFactory<>("reference"));
        ListLivraisons = FXCollections.observableArrayList(listee);
        TableViewLivraisons.setItems(ListLivraisons);
        
        

        

       
        //////////////////////////////////////////////////////
      // AddIcontoTable();
    }
       
       
       /* private void AddIcontoTable()
    {
     //add cell of button edit 
        Callback<TableColumn<Livraison, String>, TableCell<Livraison, String>> cellFoctory = (TableColumn<Livraison, String> param) -> {
            //make cell containing buttons

            final TableCell<Livraison, String> cell = new TableCell<Livraison, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    // that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                    } else {

                        ImageView Deleteicon, Editicon;
                        Deleteicon = new ImageView(new Image("C:\\Users\\chahi\\OneDrive\\Desktop\\Workshop3A36\\src\\Image\\deleteicon.png"));
                        Deleteicon.setFitHeight(30);
                        Deleteicon.setFitWidth(30);
                        setGraphic(Deleteicon);

                        Editicon = new ImageView(new Image("C:\\Users\\chahi\\OneDrive\\Desktop\\Workshop3A36\\src\\Image\\editicon.png"));
                        Editicon.setFitHeight(30);
                        Editicon.setFitWidth(30);
                        setGraphic(Editicon);

                        Editicon.setOnMouseClicked((MouseEvent event) -> {
                            //   System.out.println("icon Edit is pressed !");
                            txtcom.setText(String.valueOf(TableViewLivraisons.getSelectionModel().getSelectedItem().getIdCommande()));
                            txtprix.setText(String.valueOf(TableViewLivraisons.getSelectionModel().getSelectedItem().getPrixTotal()));
                            txtref.setText(String.valueOf(TableViewLivraisons.getSelectionModel().getSelectedItem().getReference()));

                            OpenPopupModifier();
                        });
                        Deleteicon.setOnMouseClicked((MouseEvent event) -> {
                            //   System.out.println("icon delete is pressed !");
                            if (TableViewLivraisons.getSelectionModel().getSelectedItem() != null) {
                                rec = TableViewLivraisons.getSelectionModel().getSelectedItem();
                                Boolean result = work.Supprimer(rec.getId());
                                if (result) {
                                    System.out.println("Livraison Has Been Deleted ✔");
                                    LoadTableLivraison();
                                }
                            }
                        });

                        //managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(Deleteicon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(Editicon, new Insets(2, 3, 0, 2));
                        HBox managebtn = new HBox(Editicon, Deleteicon);
                        setGraphic(managebtn);
                    }
                }
            };
            return cell;
        };
        col_Action.setCellFactory(cellFoctory);
    }*/

    private void OpenPopupModifier() {
        btnModifier.toFront();
        TitreFormulaire.setText("Modifier La Livraison");
        PaneFormulaire.setVisible(true);
        PaneBlur.setVisible(true);
    }

    @FXML
    private void GoToFournisseur(MouseEvent event) {
    }

    @FXML
    private void ModifierFournisseurClicked(MouseEvent event) {
         int id = 0;
        if (TableViewLivraisons.getSelectionModel().getSelectedItem() != null) {
            id = Integer.valueOf((TableViewLivraisons.getSelectionModel().getSelectedItem().getId()));
        }
        if (txtcom.getText().isEmpty()) {
            txtcom.requestFocus();
            shake(txtcom);
            return;
        }
        if (txtprix.getText().isEmpty()) {
            txtprix.requestFocus();
            shake(txtprix);
            return;
        }

        
        if (txtref.getText().isEmpty()) {
            txtref.requestFocus();
            shake(txtref);
            return;
        }
        rec.setIdCommande(Integer.valueOf(txtcom.getText()));
        rec.setPrixTotal(Integer.valueOf(txtprix.getText()));
        rec.setReference(Integer.valueOf(txtref.getText()));
        rec.setId(id);
        Boolean result = work.ModifierLivraison(rec);

        if (result) {
            txtcom.clear();
            txtprix.clear();
            txtref.clear();
            //
            PaneFormulaire.setVisible(false);
            PaneBlur.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Livraison à été Modifier ✔");
        alert.show();
            
            LoadTableLivraison();
        }
        LoadTableLivraison();

    }

    @FXML
    private void AjouterFournisseurClicked(MouseEvent event) {
        
         if (txtcom.getText().isEmpty()) {
            txtcom.requestFocus();
            shake(txtcom);
            return;
        }
        if (txtprix.getText().isEmpty()) {
            txtprix.requestFocus();
            shake(txtprix);
            return;
        }

        
        if (txtref.getText().isEmpty()) {
            txtref.requestFocus();
            shake(txtref);
            return;
        }

        rec.setIdCommande(Integer.valueOf(txtcom.getText()));
        rec.setPrixTotal(Integer.valueOf(txtprix.getText()));
        rec.setReference(Integer.valueOf(txtref.getText()));
      

        boolean result = work.Ajouter(rec); // Fonction AjoutUser
        if (result) {

            txtcom.clear();
            txtprix.clear();
            txtref.clear();
            //
            PaneFormulaire.setVisible(false);
            PaneBlur.setVisible(false);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Livraison à été ajouté ✔");
        alert.show();
            LoadTableLivraison();
        }
    }
    
     public static void shake(Node node) {
        new Shake(node).play();
    }

    @FXML
    private void BtnUpdate(ActionEvent event) {
        OpenPopupModifier();
    }

    @FXML
    private void BtnDelete(ActionEvent event) {
         TableViewLivraisons.setItems(ListLivraisons);

             ObservableList<Livraison> alldomains,Singledomain ;
             alldomains=TableViewLivraisons.getItems();
             Singledomain=TableViewLivraisons.getSelectionModel().getSelectedItems();
             Livraison rec = Singledomain.get(0);
             work.Supprimer(rec);
             
             Singledomain.forEach(alldomains::remove);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Livraison à été Supprimer ✔");
        alert.show();
             work.Afficher();
    }
    
}
