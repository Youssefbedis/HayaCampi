/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;
import javafx.scene.image.ImageView;


/**
 *
 * @author chahine
 */
public class Livreur {
   private int id;
    private  int cin;   
    private String nomLivreur;
    private String prenomLivreur;
    private int numeroTelephone;
    private ImageView  imageView;
    private String disponible;
    private String image;

    private int livraison;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    public String getPrenomLivreur() {
        return prenomLivreur;
    }

    public void setPrenomLivreur(String prenomLivreur) {
        this.prenomLivreur = prenomLivreur;
    }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(int numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLivraison() {
        return livraison;
    }

    public void setLivraison(int livraison) {
        this.livraison = livraison;
    }

    public Livreur(int id, int cin, String nomLivreur, String prenomLivreur, int numeroTelephone, ImageView imageView, String disponible, String image, int livraison) {
        this.id = id;
        this.cin = cin;
        this.nomLivreur = nomLivreur;
        this.prenomLivreur = prenomLivreur;
        this.numeroTelephone = numeroTelephone;
        this.imageView = imageView;
        this.disponible = disponible;
        this.image = image;
        this.livraison = livraison;
    }

    public Livreur(int cin, String nomLivreur, String prenomLivreur, int numeroTelephone, ImageView imageView, String disponible, String image, int livraison) {
        this.cin = cin;
        this.nomLivreur = nomLivreur;
        this.prenomLivreur = prenomLivreur;
        this.numeroTelephone = numeroTelephone;
        this.imageView = imageView;
        this.disponible = disponible;
        this.image = image;
        this.livraison = livraison;
    }

   
    
    
    
    
    public Livreur() {
    }

    @Override
    public String toString() {
        return "Livreur{" + "id=" + id + ", cin=" + cin + ", nomLivreur=" + nomLivreur + ", prenomLivreur=" + prenomLivreur + ", numeroTelephone=" + numeroTelephone + ", imageView=" + imageView + ", disponible=" + disponible + ", image=" + image + ", livraison=" + livraison + '}';
    }

    
   
  
    
    
    
    
      
}
