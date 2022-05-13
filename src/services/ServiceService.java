/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import services.IService1;
import models.Service;
import models.Type;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jdbc.jdbc;

/**
 *
 * @author Nour
 */
public class ServiceService implements IService1<Service>{
    
private Connection cnx = jdbc.getInstance().getCnx() ;
   
    @Override
    public void ajouter(Service t) {
    try {
        String querry= "INSERT INTO `service`( name_id , `description` , `prix`, `nb_pers` , `image`)"+ ""
                + "VALUES ('"+t.getType().getId()+"','"+t.getDescription()+"','"+t.getPrix()+"','"+t.getNb_pers()+"','"+t.getImage()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    System.out.println("Produit été ajouté ✔");
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

    @Override
    public List<Service> afficher() {

     List<Service> services = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `service` join `type` WHERE service.name_id=type.id ";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Service p = new Service();
            Type t = new Type();
            
            ImageView img = new ImageView();
                Image image;
                try {
                    if (rs.getString("image") == null) {
                    } else if (rs.getString("image") != null) {
                        image = new Image(new FileInputStream(("C:\\xamppp\\htdocs\\Projet\\Uploads\\"+rs.getString("image"))));
                        img.setImage(image);
                        img.setPreserveRatio(false);
                        img.setFitWidth(50);
                        img.setFitHeight(50);

                    }
                } catch (FileNotFoundException ex) {
                    try {
                        System.out.println(ex.getMessage());
                        image = new Image(new FileInputStream(("C:\\xamppp\\htdocs\\Projet\\Uploads\\"+"nophoto.jpg")));
                        img.setImage(image);
                        img.setPreserveRatio(true);
                        img.setFitWidth(50);
                        img.setFitHeight(50);
                    } catch (FileNotFoundException ex1) {
                        Logger.getLogger(ServiceService.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                //
                p.setImgView(img);
            
            t.setName(rs.getString("name"));
            
            p.setId(rs.getInt(1));
            p.setName_id(rs.getInt("name_id"));
            p.setDescription(rs.getString("description"));
            p.setPrix(rs.getInt("prix"));
            p.setNb_pers(rs.getInt("nb_pers"));
            p.setImage(rs.getString("image"));
            p.setType(t);
            services.add(p);
        }
        
    } catch (SQLException ex) {
        System.out.println(ex);
        }
    return services;
    }

    @Override
    public void modifier(Service t) {
        try {
        PreparedStatement query = cnx.prepareStatement(
                "UPDATE service set image=?, nb_pers=?, prix=?, description=? where id=?");        
        
        query.setString(1, t.getImage());
        query.setInt(2, t.getNb_pers());
        query.setInt(3, t.getPrix());
        query.setString(4, t.getDescription());
        query.setInt(5, t.getName_id());
        query.setInt(6, t.getId());        
        query.executeUpdate();
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
        String querry="DELETE FROM service WHERE service.`id` = '"+id+"'";

        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());    
}
         }
    
/*@Override
    public List<Service> recherche(int id) {
     
        List<Service> services = new ArrayList();
        String req = "select * from agence where id =?";
        try {Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(req);
        while (rs.next()){
            Service p = new Service();
            
            p.setId(rs.getInt(1));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrix(rs.getInt(20));
            p.setNbPers(rs.getInt("nbPers"));
            p.setImage(rs.getString("image"));
            services.add(p);
        }
        return services;
            }
         catch (Exception e) {
            System.out.println(" probleme dans la recherche");
            e.printStackTrace();
        }
        //System.out.println(u);
        return services;
       
}*/
    
@Override
    public List<Service> tri() {
    List<Service> services = afficher();
    /*livreurs.stream()
        
        .map(x -> x.getNomLivreur().substring(0, 1).toUpperCase() + x.getNomLivreur().substring(1))
        // tri par ordre alphabétique
        .sorted()
        .forEach(System.out::println );*/
    List<Service> resultat=services.stream().sorted( Comparator.comparing(Service::getPrix)).collect(Collectors.toList());
      return resultat;
      
}
    
@Override
    public List<Service> recherche(String description) {
    return afficher().stream().filter(service->description.equals(service.getDescription())).collect(Collectors.toList());
           
    }
    
 @Override
     public int nb1(){
     String req="SELECT COUNT(*) FROM service join `type` WHERE service.name_id=type.id AND name='cabane triangulaire' ";
      
      int nb =0;
        
        try {
          Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while(rs.next()){
             nb= rs.getInt(1);
              System.out.println(nb);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nb;
    }
     
     @Override
     public int nb2(){
     String req="SELECT COUNT(*) FROM service join `type` WHERE service.name_id=type.id AND name='TreeHouse' ";
      
      int nb =0;
        
        try {
          Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while(rs.next()){
             nb= rs.getInt(1);
              System.out.println(nb);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nb;
    }
     @Override
     public int nb4(){
     String req="SELECT COUNT(*) FROM service join `type` WHERE service.name_id=type.id AND name='cosy cabane' ";
      
      int nb =0;
        
        try {
          Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while(rs.next()){
             nb= rs.getInt(1);
              System.out.println(nb);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nb;
    }
     @Override
     public int nb5(){
     String req="SELECT COUNT(*) FROM service join `type` WHERE service.name_id=type.id AND name='luxurious big nest' ";
      
      int nb =0;
        
        try {
          Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while(rs.next()){
             nb= rs.getInt(1);
              System.out.println(nb);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nb;
    }
     @Override
     public int nb6(){
     String req="SELECT COUNT(*) FROM service join `type` WHERE service.name_id=type.id AND name='big treehouse' ";
      
      int nb =0;
        
        try {
          Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while(rs.next()){
             nb= rs.getInt(1);
              System.out.println(nb);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nb;
    }
     
     
    
}
