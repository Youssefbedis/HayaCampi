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
import models.Produits;


/**
 *
 * @author User
 */
public class serviceProduits implements services <Produits>{
   
       Connection cnx ;
       String req = "";
       Statement st;
       ResultSet rs;
       Scanner sc = new Scanner(System.in);

    public serviceProduits() {
        cnx = jdbc.getInstance().getCnx();
    }
    
    
    @Override
    public void ajouter(Produits t) 
    {
    }
      
    @Override
    public void supprimer(Produits t) {

    }


    @Override
    public void modifier(Produits t) {
        
    }
 
    @Override
    public List<Produits> afficher() {
           List<Produits> list = new ArrayList<>();
        
        try {
            req = "SELECT * FROM produit";
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()) {
              Produits a =  new Produits();
              a.setId(rs.getInt(1));
              a.setTitre(rs.getString(2));
              a.setImage(rs.getString(3));
              a.setPrice(rs.getFloat(4));
            list.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
          public Produits getById(int id) {
          Produits a = null;
         String requete = " select* from Produit where id="+id ;
        try {
           
            st = cnx.createStatement();
            rs=st.executeQuery(requete);
            if (rs.next())
            {
              a.setId(rs.getInt(1));
              a.setTitre(rs.getString(2));
              a.setImage(rs.getString(3));
              a.setPrice(rs.getFloat(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a ;
        
    }

    
      


}
