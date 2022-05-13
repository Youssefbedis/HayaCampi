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
import models.Commande;
import models.Produits;


/**
 *
 * @author User
 */
public class serviceCommande implements IServiceCommande <Commande>{
   
       Connection cnx ;
       String req = "";
       Statement st;
       ResultSet rs;
       Scanner sc = new Scanner(System.in);
       serviceProduits sp = new serviceProduits();
    public serviceCommande() {
        cnx = jdbc.getInstance().getCnx();
    }
    
    
    @Override
    public void ajouter(Commande t) 
    {
        try {
            req = "INSERT INTO Commande ( user_id, num,rue,ville , num_tel , num_carte,mode) VALUES ('" + t.getUser_id()+ "','"+ t.getNum()+"','"+ t.getRue()+"','"+ t.getVille()+"','"+ t.getNum_tel()+"','"+ t.getNum_carte()+"','"+ t.getMode()+"')";
            st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("Commande Ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      
    @Override
    public void supprimer(Commande t) {
        try {
        String query2="DELETE FROM Commande WHERE id = ?";
        PreparedStatement smt = cnx.prepareStatement(query2) ;
        smt.setInt(1, t.getId());
        smt.executeUpdate();
        System.out.println("Commande supprimé !");}
    catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }


    @Override
    public void modifier(Commande t) {
        
        try {

                String query2="UPDATE `Commande` SET `num`=?,`rue`=?,`ville`=?,`num_tel`=?,`num_carte`=?,`mode`=? WHERE `id`=? ";

                PreparedStatement smt = cnx.prepareStatement(query2);
                smt.setString(1, t.getNum());
                smt.setString(2, t.getRue());
                smt.setString(3, t.getVille());
                smt.setString(4, t.getNum_tel());
                smt.setString(5, t.getNum_carte());
                smt.setString(6, t.getMode());
                smt.setInt(7, t.getId());
                

                smt.executeUpdate();
                System.out.println("Commande modifié !");
            } 
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
 
    @Override
    public List<Commande> afficher() {
           List<Commande> list = new ArrayList<>();
        
        try {
            req = "SELECT * FROM Commande";
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            while(rs.next()) {
                    
                Commande f = new Commande();
                f.setId(rs.getInt("id"));
                f.setNum(rs.getString("num"));
                f.setRue(rs.getString("rue"));
                f.setVille(rs.getString("ville"));
                f.setNum_tel(rs.getString("num_tel"));
                f.setNum_carte(rs.getString("num_carte"));
                f.setMode(rs.getString("mode"));

            list.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    @Override
     public int nbSurPlace(){
     String req="SELECT COUNT(*) FROM commande WHERE mode='Sur Place' ";
      
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
     public int nbSurEnLigne(){
     String req="SELECT COUNT(*) FROM commande WHERE mode='En Ligne' ";
      
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
