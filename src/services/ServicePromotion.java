/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Centre;
import models.Promotion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jdbc.jdbc;

/**
 *
 * @author user
 */
public class ServicePromotion implements  IServicePromotion<Promotion>  {
     private Connection cnx = jdbc.getInstance().getCnx() ;
    
    
      @Override
    public void ajouterPromotion(Promotion p) {
    try {//new SimpleDateFormat("YYYY/MM/DD").format(  p.getDate_debut())
        String querry= "INSERT INTO `promotion`( centre_id,`ancien_prix`, `nouveau_prix`, `duree`, `date_debut`)  "
                + "VALUES ("+p.getCentre().getId()+","+p.getAncien_prix()+","+p.getNouveau_prix()+","+p.getDuree()+", '"+ p.getDate_debut()  +"')";
        
       // String querry= "INSERT INTO centre(`nom`, `prenom`) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }
    
       @Override
    public List<Promotion> afficher() {
     List<Promotion> promotions = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `promotion` inner join `centre` where promotion.centre_id=centre.id ";
        
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Promotion p = new Promotion();
            Centre c = new Centre();
            c.setId(rs.getInt(2));
             c.setNom_centre(rs.getString("nom_centre"));
            c.setNum(rs.getInt("num"));
            c.setRue(rs.getString("rue"));
            c.setVille(rs.getString("ville"));
            c.setMail(rs.getString("mail"));
            c.setDescription(rs.getString("description"));
            c.setPrix(rs.getFloat("prix"));
            
            
            
            p.setId(rs.getInt(1));
            p.setAncien_prix(rs.getFloat("ancien_prix"));
            p.setNouveau_prix(rs.getFloat("ancien_prix"));
            p.setDuree(rs.getInt("duree"));
            p.setDate_debut(Date.valueOf(rs.getString("date_debut")));
            p.setCentre(c);
            promotions.add(p);
            
           
            
        }
    } catch (SQLException ex) {
        }
    return promotions;
    }
    
   /* @Override
    public void modifier(Centre c) {
        try {
        PreparedStatement query = cnx.prepareStatement(
                "UPDATE `centre` SET nom_centre=?,num=?,rue=?,ville=?,mail=?,description=?,image_name=?,prix=? where id=?");        
                
        query.setString(1, c.getNom_centre());
        query.setInt(2, c.getNum());
        query.setString(3, c.getRue());
        query.setString(4, c.getVille());
        query.setString(5, c.getMail());
        query.setString(6, c.getDescription());        
        query.setString(7, c.getImageName());
        //query.setInt(7, c.getPrix())
        query.executeUpdate();
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
        }
        
        
        
    }*/
     @Override
    public void supprimer(Promotion p) {
 try {
        String querry="DELETE FROM promotion WHERE promotion.`id` = "+p.getId();
        

        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
    }  
    
}
