/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class Promotion {
    
     private int id;
     private Float ancien_prix;
     private Float nouveau_prix;
     private int duree;
     private Date date_debut;
     private Centre centre ;
     
     

    public Promotion() {
    }

    public Promotion(String CBnomcentre, float parseFloat, float parseFloat0, int parseInt, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public int getId() {
        return id;
    }

    public Float getAncien_prix() {
        return ancien_prix;
    }

    public Float getNouveau_prix() {
        return nouveau_prix;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }
    

    public int getDuree() {
        return duree;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAncien_prix(Float ancien_prix) {
        this.ancien_prix = ancien_prix;
    }

    public void setNouveau_prix(Float nouveau_prix) {
        this.nouveau_prix = nouveau_prix;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Promotion(Float ancien_prix, Float nouveau_prix, int duree, Date date_debut, Centre centre) {
        this.ancien_prix = ancien_prix;
        this.nouveau_prix = nouveau_prix;
        this.duree = duree;
        this.date_debut = date_debut;
        this.centre = centre;
    }

    public Promotion(int id, Float ancien_prix, Float nouveau_prix, int duree, Date date_debut, Centre centre) {
        this.id = id;
        this.ancien_prix = ancien_prix;
        this.nouveau_prix = nouveau_prix;
        this.duree = duree;
        this.date_debut = date_debut;
        this.centre = centre;
    }

    @Override
    public String toString() {
       // return "Promotion{" + "id=" + id + ", ancien_prix=" + ancien_prix + ", nouveau_prix=" + nouveau_prix + ", duree=" + duree + ", date_debut=" + date_debut + ", centre=" + centre + '}';
       return ancien_prix+"";
    }

   
      
     
    
}
