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
public class categorie {
    private int id;
    private String type;
    

    public categorie(String type) {
        this.type = type;
       
    }

    public categorie(int id) {
        this.id = id;
      
    }
    
    public categorie() {
    }

    @Override
    public String toString() {
        return "categorie{" + " id=" + id + ", type=" + type + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    }


