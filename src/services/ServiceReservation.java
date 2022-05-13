/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import models.Reservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import jdbc.jdbc;

/**
 *
 * @author user
 */
public class ServiceReservation implements IService<Reservation> {
    
     private Connection cnx = jdbc.getInstance().getCnx() ;
   
  
  
  
  
    @Override
    public void ajouter(Reservation c) {
    try {
        String querry= "INSERT INTO reservation(`date_debut`, `date_fin` , `nbr_personne`, `nom_centre` ) VALUES ('"+c.getDateDebut()+"','"+c.getDateFin()+"','"+c.getNbrPersonne()+"','"+c.getNomCentre()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
}
}
    
    

    @Override
    public List<Reservation> afficher() {
     List<Reservation> reservations = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `reservation`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Reservation c = new Reservation();
            
            c.setId(rs.getInt(1));
            c.setDateDebut(LocalDate.parse(rs.getString("date_debut").substring(0, 10)));
            c.setDateFin(LocalDate.parse(rs.getString("date_fin").substring(0, 10)));
            c.setNbrPersonne(rs.getString("nbr_personne"));
            c.setNomCentre(rs.getString("nom_centre"));
            reservations.add(c); 
}
        
    
    } catch (SQLException ex) {
       System.out.println(ex);
        }
    return reservations;
    }
    
    
    

    @Override
    public void modifier(Reservation c) {
          try {
        String querry="UPDATE reservation SET date_debut = '"+c.getDateDebut()+"', date_fin= '"+c.getDateFin()+"', nbr_personne = '"+c.getNbrPersonne()+"', nom_centre = '"+c.getNomCentre()+"' WHERE reservation.`id` = "+c.getId()+";";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       }
}

    
    
    
    
    @Override
    public void supprimer(int id) {
 try {
        String querry="DELETE FROM reservation WHERE reservation.`id` = '"+id+"'";

        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());    
}
}  
    
    
    
    @Override
    public List<Reservation> tri() {
    List<Reservation> reservation = afficher();
    
    List<Reservation> resultat=reservation.stream().sorted( Comparator.comparing(Reservation::getDateDebut)).collect(Collectors.toList());
      return resultat;
      
}
    
    
    
   /*
    @Override
    public List<Reservation> recherche(String Reservation) {
     List<Reservation> reservations = afficher();
    

     List<Reservation> resultat=reservations.stream().filter(reservation->nom_centre.equals(reservation.getNomCentre())).collect(Collectors.toList());
        return resultat;   
    }
    */
}
