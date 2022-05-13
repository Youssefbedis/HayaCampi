/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Service;
import services.ServiceService;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class FXMLStatServiceController implements Initializable {

    @FXML
    private PieChart Pie;
    @FXML
    private StackPane stackStat;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 int total=0;
     ServiceService ss = new ServiceService();
        List<Service> lf = ss.afficher();
        
        int one=ss.nb1();
    int two=ss.nb2();
    total = one+ two;
        double prcntFeed = ( one *100)/total;
        double prcntRec = (two * 100)/total;
        
        ObservableList<PieChart.Data> list=FXCollections.observableArrayList(
//current_user.getidRest
            new PieChart.Data(" Cabane Triangulaire " + prcntFeed +" % ", ss.nb1()),
            new PieChart.Data(" TreeHouse " + prcntRec +" % ", ss.nb2())
         );
   
        System.out.println("Cabane Triangulaire" + prcntFeed +" % ");
        System.out.println("TreeHouse" + prcntRec +" % ");
         Pie.setAnimated(true);
         Pie.setData(list);
         
    }    
    
    private void GoToHomeeee(MouseEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("FXMLService.fxml"));
        stackStat.getChildren().removeAll();
        stackStat.getChildren().setAll(menu);
    }
    
   

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("FXMLService.fxml"));
        stackStat.getChildren().removeAll();
        stackStat.getChildren().setAll(menu);
    }
    
}
