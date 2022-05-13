/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Livreur;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
 * @author Mohamed
 */
public class ServiceLivreur implements IService11<Livreur>{
   
    @Override
    public boolean ajouter(Livreur p) {
   try {
            String requete = "INSERT INTO livreur (nom_livreur,prenom_livreur,cin,numero_telephone,livraison_id,image,disponible)"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = jdbc.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, p.getNomLivreur());
            pst.setString(2, p.getPrenomLivreur());
            pst.setInt(3, p.getNumeroTelephone());
            pst.setInt(4, p.getCin());
            pst.setInt(5, p.getLivraison());
            pst.setString(6, p.getImage());
            pst.setString(7, p.getDisponible());


            pst.executeUpdate();

            System.out.println("Livreur à été ajouté ✔");
            return true;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return false;
        
    }

    
    
    
    
    @Override
    public List<Livreur> afficher() {
    List<Livreur> LivreurList = new ArrayList<>();
        try {
            String querry = "SELECT * FROM `livreur`  ORDER BY id DESC";
           Statement pst = jdbc.getInstance().getCnx().createStatement();
            ResultSet rs = pst.executeQuery(querry);
            while (rs.next()) {
                Livreur r = new Livreur();
                ///
                ImageView img = new ImageView();
                Image image;
                try {
                    if (rs.getString("image") == null) {
                    } else if (rs.getString("image") != null) {
                         image = new Image(new FileInputStream(("C:\\xampp\\htdocs\\Projet\\Uploads\\"+rs.getString("image"))));
                        img.setImage(image);
                        img.setPreserveRatio(false);
                        img.setFitWidth(50);
                        img.setFitHeight(50);

                    }
                } catch (FileNotFoundException ex) {
                    try {
                        System.out.println(ex.getMessage());
                        image = new Image(new FileInputStream(("C:\\xampp\\htdocs\\Projet\\Uploads\\"+"nophoto.jpg")));
                        img.setImage(image);
                        img.setPreserveRatio(true);
                        img.setFitWidth(50);
                        img.setFitHeight(50);
                    } catch (FileNotFoundException ex1) {
                        Logger.getLogger(ServiceLivreur.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                 r.setId(rs.getInt("id"));
                r.setImageView(img);
                r.setLivraison(rs.getInt("livraison_id"));
                r.setNomLivreur(rs.getString("nom_livreur"));
                r.setNumeroTelephone(rs.getInt("numero_telephone"));
                r.setCin(rs.getInt("cin"));
                r.setPrenomLivreur(rs.getString("prenom_livreur"));
                r.setImage(rs.getString("image"));
                r.setDisponible(rs.getString("disponible"));

               
                LivreurList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return LivreurList;
        }
        
    
    
    
    

    @Override
    public boolean modifier(Livreur t) {
        
        
         try {
        String sql ="UPDATE livreur SET cin =?, nom_livreur =?, prenom_livreur =?, numero_telephone =?,image =?,disponible =?,livraison_id = ?, WHERE livreur.`id` = ?";
            PreparedStatement preparedStatement = jdbc.getInstance().getCnx().prepareStatement(sql);
            // Statement stm = cnx.createStatement();
            //ResultSet rs= stm.executeQuery(sql);
            preparedStatement.setString(1, t.getNomLivreur());
            preparedStatement.setString(2, t.getPrenomLivreur());
            preparedStatement.setInt(3, t.getCin());
            preparedStatement.setInt(4, t.getNumeroTelephone());
            preparedStatement.setInt(5, t.getLivraison());
            preparedStatement.setString(6, t.getImage());
            preparedStatement.setString(7, t.getDisponible());
            preparedStatement.setInt(8, t.getId());
            preparedStatement.executeUpdate();
          System.out.println("lIVREUR modifié ✔");
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return false;
       }

    @Override
    public boolean supprimer(Livreur l) {
        
         try {
            String requete = "DELETE FROM livreur where id = ?";
            PreparedStatement pst = jdbc.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, l.getId());
            pst.executeUpdate();

            System.out.println("lIVREUR supprimée ✔");

            return true;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return false;
         }

    @Override
    public List<Livreur> tri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livreur> recherche(String prenomLivreur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
