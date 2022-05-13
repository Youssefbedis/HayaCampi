/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Panier {
   private int id;
   private Produits ipprod;
   private String prodname;
   private int iduser;
   private int quantity;
   private float total;

    public Panier() {
    }

    public Panier(Produits ipprod, int iduser, int quantity, float total) {
        this.ipprod = ipprod;
        this.iduser = iduser;
        this.quantity = quantity;
        this.total = total;
    }

    public Panier(int id, Produits ipprod, int iduser, int quantity, float total) {
        this.id = id;
        this.ipprod = ipprod;
        this.iduser = iduser;
        this.quantity = quantity;
        this.total = total;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produits getIpprod() {
        return ipprod;
    }

    public void setIpprod(Produits ipprod) {
        this.ipprod = ipprod;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", ipprod=" + ipprod + ", iduser=" + iduser + ", quantity=" + quantity + ", total=" + total + '}';
    }


}
