/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author chah
 */
public class Livraison {
    private int id ;
    private int id_commande ;
    private int prix_total ;
    private int reference ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return id_commande;
    }

    public void setIdCommande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getPrixTotal() {
        return prix_total;
    }

    public void setPrixTotal(int prix_total) {
        this.prix_total = prix_total;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", id_commande=" + id_commande + ", prix_total=" + prix_total + ", reference=" + reference + '}';
    }

    public Livraison(int id, int id_commande, int prix_total, int reference) {
        this.id = id;
        this.id_commande = id_commande;
        this.prix_total = prix_total;
        this.reference = reference;
    }

    public Livraison(int id_commande, int prix_total, int reference) {
        this.id_commande = id_commande;
        this.prix_total = prix_total;
        this.reference = reference;
    }

    public Livraison() {
    }

   
   
    
    
    
    
}
