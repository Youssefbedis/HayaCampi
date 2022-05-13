/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshope3a35;


import Model.Reservation;
import Model.Utilisateur;
import Services.IService;
import Services.IServiceUser;

import Services.ServiceReservation;
import Services.ServiceUtilisateur;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import utils.MyDb;

/**
 *
 * @author Mohamed
 */
public class pidev1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
   MyDb a= MyDb.getInstance();
       
       System.out.println(a.hashCode());
         ServiceUtilisateur u=  new ServiceUtilisateur();
         ServiceReservation v= new ServiceReservation();
         
 Reservation c = new Reservation(LocalDate.parse("2017-05-01"),LocalDate.parse("2017-05-02"),"25", "sokra");
 Utilisateur b = new Utilisateur( "youssef.bedis@esprit.tn","NULL", "12345678", "ffffff", "bedis", "78912", "25369258", "maamoura");
 b.setId(76);
 IServiceUser us =new ServiceUtilisateur();
 us.Login("youssef.bedis@esprit.tn" ,"12345678","message") ;
us.modifieruser(b, b.getId());
//u.ajouteruser(b);
//u.modifieruser(b, 63);
//u.supprimeruser(63);
//System.out.println(u.afficheruser());

        

//System.out.println(u.afficheruserid(34));
 
//System.out.println(v.afficher());  
//v.ajouter(c);
//v.modifier(c);
//v.supprimer(34);
//System.out.println(s.afficher());
//System.out.println(s.tri());
//System.out.println(s.recherche("ma"));
 
    
    }
   
}
