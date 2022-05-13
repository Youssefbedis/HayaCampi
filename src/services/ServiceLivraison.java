/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Livraison;
import models.Livreur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.jdbc;

/**
 *
 * @author chahi
 */
public class ServiceLivraison implements IIService1<Livraison> {
    
    
     @Override
    public boolean Ajouter(Livraison p) {
        try {
            String requete = "INSERT INTO livraison (id_commande,prix_total,reference)"
                    + "VALUES (?,?,?)";
            PreparedStatement pst = jdbc.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, p.getIdCommande());
            pst.setInt(2, p.getPrixTotal());
            pst.setInt(3, p.getReference());

            pst.executeUpdate();

            System.out.println("Livraison à été ajouté ✔");
            return true;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return false;
    }

    @Override
    public List<Livraison> Afficher() {
            List<Livraison> ListLivraison = new ArrayList<>();
        try {
            String requete = "SELECT id_commande,prix_total,reference FROM Livraison ORDER BY id DESC";
            Statement pst = jdbc.getInstance().getCnx().createStatement();
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                Livraison r = new Livraison();
                r.setIdCommande(rs.getInt(1));
                r.setPrixTotal(rs.getInt(2));
                r.setReference(rs.getInt(3));
               

                ListLivraison.add(r);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return ListLivraison;
    }
////////////////////////////////Modifier///////////////////////////////
    
    public static boolean ModifierLivraison(Livraison t) {
        try {
            String sql = "UPDATE Livraison SET id_commande= ?,prix_total = ?, referenece = ? WHERE id = ?";
            PreparedStatement preparedStatement = jdbc.getInstance().getCnx().prepareStatement(sql);
            preparedStatement.setInt(1, t.getIdCommande());
            preparedStatement.setInt(2, t.getPrixTotal());
            preparedStatement.setInt(3, t.getReference());

            System.out.println("Livraison été modifié ✔");

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return false;
    }
////////////////////////////////supprimer////////////////
    @Override
    public boolean Supprimer(Livraison l) {
        try {
            String requete = "DELETE FROM livraison where id = ? ";
            PreparedStatement pst = jdbc.getInstance().getCnx().prepareStatement(requete);
           
            pst.setInt(1, l.getId());
            pst.executeUpdate();
            System.out.println("Livraison supprimée ✔");

            return true;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return false;
    }
     
}
