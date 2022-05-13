/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.Animation;
import com.dlsc.gmapsfx.javascript.object.GoogleMap;
import com.dlsc.gmapsfx.javascript.object.InfoWindow;
import com.dlsc.gmapsfx.javascript.object.InfoWindowOptions;
import com.dlsc.gmapsfx.javascript.object.LatLong;
import com.dlsc.gmapsfx.javascript.object.MapOptions;
import com.dlsc.gmapsfx.javascript.object.MapTypeIdEnum;
import com.dlsc.gmapsfx.javascript.object.Marker;
import com.dlsc.gmapsfx.javascript.object.MarkerOptions;
import com.dlsc.gmapsfx.service.geocoding.GeocodingService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import Model.Livreur;
import Services.ServiceLivreur;
import utils.Connection;

/**
 * FXML Controller class
 *
 * @author chah
 */
public class MaptestController implements Initializable , MapComponentInitializedListener{

    @FXML
    private AnchorPane panier_name;
    @FXML
   
    private GoogleMapView mapComponent;
        Livreur rec = new Livreur();

        private GoogleMap map;
    
    private GeocodingService geocodingService;
    
    private StringProperty address = new SimpleStringProperty();
        ServiceLivreur work = new ServiceLivreur();
        private MarkerOptions markerOptions2;
	private Marker myMarker2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  mapComponent.addMapInitializedListener(this);
  
    }    


    private void closewinw(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void mapInitialized() {
      
    geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        
        mapOptions.center(new LatLong(36.860199, 10.190500))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);

        map = mapComponent.createMap(mapOptions);
        List<Livreur> listee = new ArrayList<>();
        List<String> namee = new ArrayList<>();
        listee = work.afficher();
        ObservableList<Livreur> Liste = FXCollections.observableArrayList(listee);
        System.out.println(Liste);
        for (int i = 0; i < Liste.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions();
        LatLong markerLatLong = new LatLong(36.860199, 10.190500);
        markerOptions.position(markerLatLong)
                .title("My new Marker")
                .icon("mymarker.png")
                .animation(Animation.DROP)
                .visible(true);

        final Marker myMarker = new Marker(markerOptions);

        markerOptions2 = new MarkerOptions();
        LatLong markerLatLong2 = new LatLong(36.800708, 10.111292);
        markerOptions2.position(markerLatLong2)
                .title(Liste.get(i).getNomLivreur())
                .visible(true);
        

        myMarker2 = new Marker(markerOptions2);

        map.addMarker(myMarker2);
InfoWindowOptions infoOptions = new InfoWindowOptions();
        infoOptions.content("<h2 style=color:red;>Name:"+Liste.get(i).getNomLivreur()+"</h2>"+
        "<h3 style=color:black>Disponible: "+Liste.get(i).getDisponible()+"</h3>"+
       "<h4 style=color:black>Number phone: "+Liste.get(i).getNumeroTelephone()+"</h4>")
                .position(markerLatLong);

        InfoWindow window = new InfoWindow(infoOptions);

        window.open(map, myMarker2);
       
        }
        
         }
            
}

