/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import services.serviceCommande;

/**
 * FXML Controller class
 *
 * @author MAKREM
 */
public class StatistiqueController implements Initializable {

    @FXML
    private PieChart statistique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            int total=0;
    serviceCommande fs = new serviceCommande();
    //    List<Commande> lf = fs.afficherFacture();
    int surplace=fs.nbSurPlace();
    int enligne=fs.nbSurEnLigne();
    total = surplace+ enligne;
        double prcntFeed = ( surplace *100)/total;
        double prcntRec = (enligne * 100)/total;
        
        ObservableList<PieChart.Data> list=FXCollections.observableArrayList(
//current_user.getidRest
            new PieChart.Data("Sur place " + prcntFeed +"%", fs.nbSurPlace()),
            new PieChart.Data("En Ligne " + prcntRec +"%", fs.nbSurEnLigne())
         );
        
      //  System.out.println("Sur place" + prcntFeed +"%");
       // System.out.println("En Ligne" + prcntRec +"%");
         statistique.setAnimated(true);
         statistique.setData(list);
    }    
    }    
    

