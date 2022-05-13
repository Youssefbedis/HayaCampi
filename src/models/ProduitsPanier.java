/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class ProduitsPanier {
   private int id;
   private int idpanier;
   private int idproduct;
   private int quantity;

    public ProduitsPanier() {
    }

    public ProduitsPanier(int id, int idpanier, int idproduct, int quantity) {
        this.id = id;
        this.idpanier = idpanier;
        this.idproduct = idproduct;
        this.quantity = quantity;
    }

    public ProduitsPanier(int idpanier, int idproduct, int quantity) {
        this.idpanier = idpanier;
        this.idproduct = idproduct;
        this.quantity = quantity;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProduitsPanier{" + "id=" + id + ", idpanier=" + idpanier + ", idproduct=" + idproduct + ", quantity=" + quantity + '}';
    }

    
   

}
