/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Livreur;
import Services.ServiceLivreur;
import animatefx.animation.Shake;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import org.apache.commons.io.FileUtils;
import utils.Connection;

/**
 * FXML Controller class
 *
 * @author chahi
 */
public class LivreurController implements Initializable {

    @FXML
    private TableView<Livreur> TableView;
    @FXML
    private TableColumn<Livreur, String> col_Nom;
    @FXML
    private TableColumn<Livreur, String> col_prenom;
    @FXML
    private TableColumn<Livreur, Integer> col_cin;
    @FXML
    private TableColumn<Livreur, Integer> col_num;
    @FXML
    private TableColumn<Livreur, String> col_dispo;
    @FXML
    private TableColumn<Livreur, ImageView> col_image;
    @FXML
    private Pane PaneBlur;
    @FXML
    private Pane PaneFormulaire;
    @FXML
    private JFXTextField txtNom;
    @FXML
    private JFXButton btnModifier;
   
    @FXML
    private Text TitreFormulaire;
    @FXML
    private JFXButton btnAjouter;
    private JFXTextField txtPrix;
    private JFXTextField txtQuantite;
    @FXML
    private ImageView PreviewImage;
    @FXML
    private TableColumn<Livreur, Integer> col_Livraison;
    @FXML
    private TableColumn<Livreur, String> col_Action;
    
    
     File selectedFile;
    private FileChooser Fc = new FileChooser();
    private File file;
    private static String pathImage = "";
    ServiceLivreur work = new ServiceLivreur();
    Livreur rec = new Livreur();
 private ObservableList<Livreur> ListLivreurs;
    @FXML
    private StackPane StckProduits;
    @FXML
    private JFXComboBox<Integer> comboLivreur;
    @FXML
    private JFXTextField txtCin;
    @FXML
    private JFXTextField txtNum;
    @FXML
    private JFXTextField txtDispo;
    @FXML
    private JFXTextField txtPrenom;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      LoadTableLivreur();
      RemplirComboLivreur();
    
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
    private void OpenFormulaireAdd(MouseEvent event) {
        txtNom.clear();
        txtCin.clear();
        txtNum.clear();
        txtPrenom.clear();
        txtDispo.clear();

        // ComboLivraison.setValue(null);
        comboLivreur.getSelectionModel().clearSelection();
        btnAjouter.toFront();
        TitreFormulaire.setText("Ajouter un Livreur");
        PaneFormulaire.setVisible(true);
        PaneBlur.setVisible(true);
    }

    @FXML
    private void CloseFormulaireClicked(MouseEvent event) {
         PaneFormulaire.setVisible(false);
        PaneBlur.setVisible(false);

        //
        File file = new File("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\" + "uploadimageicon.png");
        Image imagee = new Image(file.toURI().toString());
        PreviewImage.setImage(imagee);
        //
        pathImage = "";
    }

    @FXML
    private void ModifierProduitClicked(MouseEvent event) {
        
         int id = 0;
        if (TableView.getSelectionModel().getSelectedItem() != null) {
            id = Integer.valueOf((TableView.getSelectionModel().getSelectedItem().getId()));
        }
         if (txtNom.getText().isEmpty()) {
            txtNom.requestFocus();
            shake(txtNom);
            return;
        }
        
         if (txtPrenom.getText().isEmpty()) {
            txtPrenom.requestFocus();
            shake(txtPrenom);
            return;
        }
         
         
        if (txtCin.getText().isEmpty()) {
            txtCin.requestFocus();
            shake(txtCin);
            return;
        }
        if (txtNum.getText().isEmpty()) {
            txtNum.requestFocus();
            shake(txtNum);
            return;
        }
        if (txtDispo.getText().isEmpty()) {
            txtDispo.requestFocus();
            shake(txtDispo);
            return;
        }

      
        

        if (comboLivreur.getSelectionModel().getSelectedItem() == null) {
            comboLivreur.requestFocus();
            shake(comboLivreur);
            return;
        }

        if (pathImage.isEmpty()) {
            PreviewImage.requestFocus();
            shake(PreviewImage);
            return;
        }

        rec.setNomLivreur(txtNom.getText());
        rec.setPrenomLivreur(txtPrenom.getText());
        rec.setDisponible(txtDispo.getText());

        rec.setCin(Integer.valueOf(txtCin.getText()));
        rec.setNumeroTelephone(Integer.valueOf(txtNum.getText()));
        rec.setImage(pathImage);
        rec.setLivraison(comboLivreur.getSelectionModel().getSelectedItem());
        Boolean result = work.modifier(rec);

        if (result) {

            txtNom.clear();
            txtPrenom.clear();
            txtCin.clear();
            txtNum.clear();
            txtDispo.clear();

            comboLivreur.getSelectionModel().clearSelection();
            pathImage = "";
            // ComboFournisseur.setValue(null);
            //
            PaneFormulaire.setVisible(false);
            PaneBlur.setVisible(false);
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Livraison à été Modifié ✔");
        alert.show();
            LoadTableLivreur();
        

            // Reset imagePreview ater Modif
            File file = new File("C:\\xampp\\htdocs\\Projet\\Uploads\\" + "uploadimageicon.png");
            Image imagee = new Image(file.toURI().toString());
           PreviewImage.setImage(imagee);
        }
        LoadTableLivreur();

    }

    @FXML
    private void AjouterProduitClicked(MouseEvent event) {
        
        if (txtNom.getText().isEmpty()) {
            txtNom.requestFocus();
            shake(txtNom);
            return;
        }
        
         if (txtPrenom.getText().isEmpty()) {
            txtPrenom.requestFocus();
            shake(txtPrenom);
            return;
        }
         
         
        if (txtCin.getText().isEmpty()) {
            txtCin.requestFocus();
            shake(txtCin);
            return;
        }
        if (txtNum.getText().isEmpty()) {
            txtNum.requestFocus();
            shake(txtNum);
            return;
        }
        if (txtDispo.getText().isEmpty()) {
            txtDispo.requestFocus();
            shake(txtDispo);
            return;
        }

      
        

        if (comboLivreur.getSelectionModel().getSelectedItem() == null) {
            comboLivreur.requestFocus();
            shake(comboLivreur);
            return;
        }

        if (pathImage.isEmpty()) {
            PreviewImage.requestFocus();
            shake(PreviewImage);
            return;
        }

        rec.setNomLivreur(txtNom.getText());
        rec.setPrenomLivreur(txtPrenom.getText());
        rec.setDisponible(txtDispo.getText());

        rec.setCin(Integer.valueOf(txtCin.getText()));
        rec.setNumeroTelephone(Integer.valueOf(txtNum.getText()));
        rec.setImage(pathImage);
        rec.setLivraison(comboLivreur.getSelectionModel().getSelectedItem());
        //  ComboFournisseur.getSelectionModel().getSelectedItem();
        // rec.setVote();

        boolean result = work.ajouter(rec); // Fonction AjoutUser
        if (result) {

            txtNom.clear();
            txtPrenom.clear();
            txtCin.clear();
            txtNum.clear();
            txtDispo.clear();

            comboLivreur.getSelectionModel().clearSelection();
            pathImage = "";
            // ComboFournisseur.setValue(null);
            //
            PaneFormulaire.setVisible(false);
            PaneBlur.setVisible(false);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Livreur à été ajouté ✔");
        alert.show();
            LoadTableLivreur();
        }
    }

  @FXML
    private void UploadImageClicked(MouseEvent event) {
        File dest = new File("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\");
        Fc.setTitle("Open Resource File");
        Fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("images", "*.bmp", "*.png", "*.jpg", "*.gif"));
        selectedFile = Fc.showOpenDialog(null);

        if (selectedFile != null) {
            try {

                String Destination = "D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\";
                File f = new File(dest, selectedFile.getName());

                FileUtils.copyFileToDirectory(selectedFile, dest);
                pathImage = selectedFile.getName();

                Image image = new Image(new FileInputStream(selectedFile), 200, 200, true, true);
                PreviewImage.setImage(image);
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
    }

    
    
 




    @FXML
    private void CloseWindowClicked(MouseEvent event) {
          System.exit(0);
    }
    
    
    
    private void LoadTableLivreur() {

        List<Livreur> listee = new ArrayList<>();
        listee = work.afficher();
        ObservableList<Livreur> Liste = FXCollections.observableArrayList(listee);

        col_Nom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("nom_livreur"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("prenom_livreur"));
        col_dispo.setCellValueFactory(new PropertyValueFactory<Livreur,String>("disponible"));

        col_cin.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("cin"));
        col_num.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("numero_telephone"));
        //
        col_Livraison.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("livraison_id"));

        col_image.setCellValueFactory(new ImageProduitsCellValueFactory());

       // col_idFournisseur.setCellValueFactory(new NomFournisseurCellValueFactory());
        //
        ListLivreurs = FXCollections.observableArrayList(listee);
        TableView.setItems(ListLivreurs);
        
       
        AddIcontoTable();
    }

    private void AddIcontoTable() {

        /////////////////////////////////////////////////
        //add cell of button edit 
      /*  Callback<TableColumn<Livreur, String>, TableCell<Livreur, String>> cellFoctory = (TableColumn<Livreur, String> param) -> {
            //make cell containing buttons

            final TableCell<Livreur, String> cell = new TableCell<Livreur, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    // that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                    } else {

                        ImageView Deleteicon, Editicon;
                        Deleteicon = new ImageView(new Image("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\deleteicon.png"));
                        Deleteicon.setFitHeight(30);
                        Deleteicon.setFitWidth(30);
                        setGraphic(Deleteicon);

                        Editicon = new ImageView(new Image("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\editicon.png"));
                        Editicon.setFitHeight(30);
                        Editicon.setFitWidth(30);
                        setGraphic(Editicon);

                       Editicon.setOnMouseClicked((MouseEvent event) -> {
                            System.out.println("icon Edit is pressed !");
                            txtNom.setText(TableView.getSelectionModel().getSelectedItem().getNomLivreur());
                            txtPrenom.setText(TableView.getSelectionModel().getSelectedItem().getPrenomLivreur());
                           txtDispo.setText(TableView.getSelectionModel().getSelectedItem().getDisponible());

                            txtCin.setText(String.valueOf(TableView.getSelectionModel().getSelectedItem().getCin()));
                            txtNum.setText(String.valueOf(TableView.getSelectionModel().getSelectedItem().getNumeroTelephone()));
                            comboLivreur.setValue(TableView.getSelectionModel().getSelectedItem().getLivraison());
                            //PreviewImage.setImage(value);
                            OpenPopupModifier();
                        });
                        Deleteicon.setOnMouseClicked((MouseEvent event) -> {
                            //   System.out.println("icon delete is pressed !");
                            if (TableView.getSelectionModel().getSelectedItem() != null) {
                                rec = TableView.getSelectionModel().getSelectedItem();
                                Boolean result = work.supprimer(rec.getId());
                                if (result) {
                                    System.out.println("Livreur Has Been Deleted ✔");
                                    LoadTableLivreur();
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
        col_Action.setCellFactory(cellFoctory);*/

       
//////////////////////////////////////////////////////////////////////////////////////////////// Color Red
        col_cin.setCellFactory(column -> {
            return new TableCell<Livreur, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty ? "" : getItem().toString());
                    setGraphic(null);

                    TableRow<Livreur> currentRow = getTableRow();
                    
                    if (!isEmpty()) {
                        if (item == 0) {
                            currentRow.setStyle("-fx-background-color: linear-gradient(to right top, #EB3349 , #F45C43);-fx-opacity:0.5"); ///  Set color red
                        } else {
                            currentRow.setStyle("");
                        }
                    }
                }
            };
        });
    }
    
    
    
    
        private void OpenPopupModifier() {
        int id = 0;
        if (TableView.getSelectionModel().getSelectedItem() != null) {
            id = Integer.valueOf((TableView.getSelectionModel().getSelectedItem().getId()));
        }
        ////////////
        try {
            String Destination = "D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\";
            File dest = new File("D:\\Programme\\xampp\\htdocs\\Projet\\Uploads\\");

            String requeteee = "SELECT image,cin FROM livreur WHERE id = '" + id + "'";
            Statement psttt = Connection.getInstance().getCnx().createStatement();
            ResultSet rsss = psttt.executeQuery(requeteee);
            while (rsss.next()) {
                String exist = "";
                exist = rsss.getString(1);
                if (exist != null && !exist.isEmpty()) {
                    String ImageProduct = Destination + rsss.getString(1);
                    String NomImage = rsss.getString(1);
                    pathImage = rsss.getString(1);
                    File f = new File(dest, NomImage);
                    if (f.exists()) {
                        System.out.println("File  Exist  in Uploads");
                        Image imagee = new Image(new FileInputStream(ImageProduct), 200, 200, true, true);
                        PreviewImage.setImage(imagee);
                    } else {
                        System.out.println("File Not Exist  in Uploads");
                        File file = new File(Destination + "uploadimageicon.png");
                        Image imagee = new Image(file.toURI().toString());
                        PreviewImage.setImage(imagee);
                    }

                } else if (exist == null || exist.isEmpty()) {
                    System.out.println("Base de donnée champ image null or empty !");
                    File file = new File(Destination + "uploadimageicon.png");
                    Image imagee = new Image(file.toURI().toString());
                    PreviewImage.setImage(imagee);
                }

            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LivreurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ///////////
        btnModifier.toFront();
        TitreFormulaire.setText("Modifier Le Livreur");
        PaneFormulaire.setVisible(true);
        PaneBlur.setVisible(true);
    }

    @FXML
    private void BtnUpdate(ActionEvent event) {
        OpenPopupModifier();
    }

    @FXML
    private void BtnDelete(ActionEvent event) {
        TableView.setItems(ListLivreurs);

             ObservableList<Livreur> alldomains,Singledomain ;
             alldomains=TableView.getItems();
             Singledomain=TableView.getSelectionModel().getSelectedItems();
             Livreur l = Singledomain.get(0);
             work.supprimer(l);
             Singledomain.forEach(alldomains::remove);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Livreur à été Supprimer ✔");
        alert.show();
             
             work.afficher();
}
    
     
     
        private class ImageProduitsCellValueFactory implements Callback<TableColumn.CellDataFeatures<Livreur, ImageView>, ObservableValue<ImageView>> {

        @Override
        public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<Livreur, ImageView> param) {
            Livreur item = param.getValue();
            ImageView img = null;

            img = item.getImageView();

            return new SimpleObjectProperty<>(img);
        }
    }
    
        
        private void RemplirComboLivreur() {
        try {

            String requetee = "SELECT id FROM `livraison`";
            Statement pstt = Connection.getInstance().getCnx().createStatement();
            ResultSet rs = pstt.executeQuery(requetee);
            while (rs.next()) {
                comboLivreur.getItems().addAll(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
        
    public static void shake(Node node) {
        new Shake(node).play();
    }
        
}
