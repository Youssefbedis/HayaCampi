/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.Type;
import javafx.scene.image.ImageView;

/**
 *
 * @author Nour
 */
public class Service {
     private int id, Prix, nb_pers ,name_id;
     private String description ,image ;
     private Type type;
     ImageView imgView;
     

    public Service() {
    }

    public Service(int Prix, int nb_pers, int name_id, String description, String image, Type type, ImageView imgView) {
        
        this.Prix = Prix;
        this.nb_pers = nb_pers;
        this.name_id = name_id;
        this.description = description;
        this.image = image;
        this.type = type;
        this.imgView = imgView;
    }
    

    public Service(int Prix, int nb_pers, String description, String image, Type type) {
        this.Prix = Prix;
        this.nb_pers = nb_pers;
        this.description = description;
        this.image = image;
        this.type = type;
    }

    public Service(int id, int Prix, int nb_pers, String description, String image, Type type) {
        this.id = id;
        this.Prix = Prix;
        this.nb_pers = nb_pers;
        this.description = description;
        this.image = image;
        this.type = type;

        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    
    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getPrix() {
        return Prix;
    }

    public void setNb_pers(int nb_pers) {
        this.nb_pers = nb_pers;
    }

    public int getNb_pers() {
        return nb_pers;
    }

    public String getDescription() {
        return description;
    }

    public int getName_id() {
        return name_id;
    }

    public void setName_id(int name_id) {
        this.name_id = name_id;
    }


    public String getImage() {
        return image;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ImageView getImgView() {
        return imgView;
    }

    public void setImgView(ImageView imgView) {
        this.imgView = imgView;
    }
    
    @Override
    public String toString() {
        //return "Service{" + "id=" + id + ", Prix=" + Prix + ", nb_pers=" + nb_pers + ", name_id=" + name_id + ", description=" + description + ", image=" + image + ", type=" + type + '}';
        return description;
        
    }
    
}
