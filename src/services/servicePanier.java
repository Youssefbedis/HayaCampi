/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.jdbc;
import models.Panier;
import models.Produits;


/**
 *
 * @author User
 */
public class servicePanier implements services <Panier>{
   
       Connection cnx ;
       String req = "";
       Statement st;
       ResultSet rs;
       Scanner sc = new Scanner(System.in);
       serviceProduits sp = new serviceProduits();
    public servicePanier() {
        cnx = jdbc.getInstance().getCnx();
    }
    
    
    @Override
    public void ajouter(Panier t) 
    {
        try {
            System.out.println(t);
            req = "INSERT INTO Panier ( produit_id, user_id,quantity,total) VALUES ('" + t.getIpprod().getId()+ "','"+ t.getIduser()+"','"+ t.getQuantity()+"','"+ t.getTotal()+"')";
            st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("Panier Ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      
    @Override
    public void supprimer(Panier t) {
        try {
        String query2="DELETE FROM Panier WHERE id = ?";
        PreparedStatement smt = cnx.prepareStatement(query2) ;
        smt.setInt(1, t.getId());
        smt.executeUpdate();
        System.out.println("Panier supprimé !");}
    catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }


    @Override
    public void modifier(Panier t) {
        
        try {

                String query2="UPDATE `Panier` SET `total`=?,`quantity`=? WHERE `id`=? ";

                PreparedStatement smt = cnx.prepareStatement(query2);
                smt.setFloat(1, t.getTotal());
                smt.setInt(2, t.getQuantity());
                smt.setInt(3, t.getId());
                

                smt.executeUpdate();
                System.out.println("Panier modifié !");
            } 
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
 
    @Override
    public List<Panier> afficher() {
           List<Panier> list = new ArrayList<>();
        
        try {
            req = "SELECT * FROM Panier";
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()) {
                                    Panier p = new Panier();
                    p.setId(rs.getInt(1));
                    
                    Produits prod = sp.getById(rs.getInt(2));
                    
                    p.setIpprod(prod);
                    p.setIduser(rs.getInt(3));
                    p.setQuantity(rs.getInt(4));
                    p.setTotal(rs.getFloat(5));

            list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
      public Panier getById(int id) {
          Panier a = null;
         String requete = " select* from Panier where id="+id ;
        try {
           
            st = cnx.createStatement();
            rs=st.executeQuery(requete);
            if (rs.next())
            {
                    a.setId(rs.getInt(1));
                    
                    Produits prod = sp.getById(rs.getInt(2));
                    
                    a.setIpprod(prod);
                    a.setIduser(rs.getInt(3));
                    a.setQuantity(rs.getInt(4));
                    a.setTotal(rs.getFloat(5));

               
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a ;
        
    }
     public Panier getByIduser(int iduser,int idprod) {
         Panier a = null;
                 try {
             req = "select * from Panier where user_id="+iduser+" and produit_id="+idprod;
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()) {
                                    Panier p = new Panier();
                    p.setId(rs.getInt(1));
                    
                    Produits prod = sp.getById(rs.getInt(2));
                    
                    p.setIpprod(prod);
                    p.setIduser(rs.getInt(3));
                    p.setQuantity(rs.getInt(4));
                    p.setTotal(rs.getFloat(5));

                     a=p    ;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a ;
        
    }
}
