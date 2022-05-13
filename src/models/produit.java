/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author aicha
 */
public class produit {
    private int id;
    private String nom;
    private String description;
    private String etat;
    private String image;
    private String categorie;

    public produit(String nom, String description, String etat, String image, String categorie) {
        this.nom = nom;
        this.description = description;
        this.etat = etat;
        this.image = image;
        this.categorie = categorie;
    }

    public produit(int id, String nom, String description, String etat, String image, String categorie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.etat = etat;
        this.image = image;
        this.categorie = categorie;
    }
    
    public produit() {
    }

    @Override
    public String toString() {
        return "produit{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", etat=" + etat + ", image=" + image + ", categorie=" + categorie + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
}
