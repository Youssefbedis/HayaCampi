/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import models.Reservation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReservationController implements Initializable {

    public void setData(Reservation get) {
           this.res= get;
        
    debut.setText(String.valueOf(res.getDateDebut()));
    fin.setText(String.valueOf(res.getDateFin()));
    Nbr.setText(res.getNbrPersonne());
    Nomcentre.setText(res.getNomCentre());
    
       
    }

    @FXML
    private Label debut;
    @FXML
    private Label fin;
    @FXML
    private Label Nbr;
    @FXML
    private Label Nomcentre;
    private Reservation res;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    
    
}
