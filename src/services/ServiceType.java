/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Service;
import models.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.jdbc;

/**
 *
 * @author Nour
 */
public class ServiceType implements IIService<Type>{
private Connection cnx = jdbc.getInstance().getCnx() ;
   
    @Override
    public void ajouter(Type t) {
    try {
        String querry= "INSERT INTO type(`name`) VALUES ('"+t.getName()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

    @Override
    public List<Type> afficher() {
     List<Type> types = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `type`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Type p = new Type();
            
            p.setId(rs.getInt(1));
            p.setName(rs.getString("name"));
            types.add(p);
        }
        
        
        
        return types;
    } catch (SQLException ex) {
        }
    return types;
    }

    @Override
    public void modifier(Type t) {
        try {
        PreparedStatement query = cnx.prepareStatement(
                "UPDATE type set name=? where id=?");        
        
        
        query.setString(1, t.getName());
        query.setInt(2, t.getId());        
        query.executeUpdate();
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
        }
       }

    @Override
    public void supprimer(int id) {
          try {
        String querry="DELETE FROM type WHERE type.`id` = '"+id+"'";

        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());    
}
         }
    
    
}
