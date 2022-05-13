/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jdbc.jdbc;
import models.Panier;
import models.Produits;
import services.servicePanier;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AjouterPanierController implements Initializable {

    @FXML
    private TableView<Produits> TableProduits;
    @FXML
    private TableColumn<Produits, String> nom;
    @FXML
    private TableColumn<Produits, Float> prix;

           private Statement ste;
    private Connection con;
    private final ObservableList<Produits> data = FXCollections.observableArrayList(); 
    @FXML
    private TableColumn<Produits, Integer> idprod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Aff();    
    }  
  
           public void Aff(){
                        try {
            con = jdbc.getInstance().getCnx();
            ste = con.createStatement();
            data.clear();

            ResultSet res = ste.executeQuery("select * from product");
            while(res.next()){
                Produits a = new Produits();
              a.setId(res.getInt(1));
              a.setTitre(res.getString(2));
              a.setImage(res.getString(3));
              a.setPrice(res.getFloat(4));
                
                data.add(a);

            }

        } catch (Exception e) {
                //Logger.getLogger(tab)
        }
            idprod.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom.setCellValueFactory(new PropertyValueFactory<>("titre"));
            prix.setCellValueFactory(new PropertyValueFactory<>("price"));
          
            TableProduits.setItems(data);
           }
           
           
           
    @FXML
    private void AjouterPanier(ActionEvent event) {
        
             ObservableList<Produits> all,Single ;
             all=TableProduits.getItems();
             Single=TableProduits.getSelectionModel().getSelectedItems();
             Produits A = Single.get(0);

             servicePanier sp = new servicePanier();
             System.out.println(A.getId());
             Panier pan =  sp.getByIduser(1,A.getId());
            if(pan==null)
            {
                
             pan = new Panier();
             pan.setIduser(1);
             pan.setIpprod(A);
             pan.setTotal(A.getPrice());
             pan.setQuantity(1);
             sp.ajouter(pan);
            }else
            {
                int quantity = pan.getQuantity()+1;
                pan.setQuantity(quantity);
                pan.setIpprod(A);
                pan.setTotal(A.getPrice()*quantity );
                          sp.modifier(pan);
            }
            
    }
    
}
