/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import jdbc.jdbc;
import models.Panier;
import models.Produits;
import services.servicePanier;
import services.serviceProduits;

/**
 * FXML Controller class
 *
 * @author sbs
 */
public class GererPanierController implements Initializable {


           serviceProduits sp = new serviceProduits();
           servicePanier spanier = new servicePanier();

       private Statement ste;
    private Connection con;
    private final ObservableList<Panier> data = FXCollections.observableArrayList(); 
    @FXML
    private TableView<Panier> tablepanier;
    @FXML
    private TableColumn<Panier, Integer> id;
    @FXML
    private TableColumn<Panier,String> produitn;
    @FXML
    private TableColumn<Panier, Integer> Quantity;
    @FXML
    private TableColumn<Panier, Float> total;
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

            ResultSet res = ste.executeQuery("select * from panier where user_id=1");
            while(res.next()){
                Panier a = new Panier();
                                    a.setId(res.getInt(1));
                    
                    Produits prod = sp.getById(res.getInt(2));
                    a.setIpprod(prod);
                    a.setIduser(res.getInt(3));
                    a.setQuantity(res.getInt(4));
                    a.setTotal(res.getFloat(5));
                
                data.add(a);
              }
            }
            catch (Exception e) {
                //Logger.getLogger(tab)
        }
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            produitn.setCellValueFactory(new PropertyValueFactory<>("prodname"));
            Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            total.setCellValueFactory(new PropertyValueFactory<>("total"));
          
            tablepanier.setItems(data);
           }

    @FXML
    private void Supprimer(ActionEvent event) {
        
                        tablepanier.setItems(data);

             ObservableList<Panier> alldomains,Singledomain ;
             alldomains=tablepanier.getItems();
             Singledomain=tablepanier.getSelectionModel().getSelectedItems();
             Panier A = Singledomain.get(0);
             spanier.supprimer(A);
             Singledomain.forEach(alldomains::remove);
             Aff();

    }

    @FXML
    private void Commander(ActionEvent event) {
    }

            

    }
    

