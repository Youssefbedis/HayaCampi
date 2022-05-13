/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author user
 */
public class Centre {
     private int id;
    private String nom_centre;
    private int num;
    private String rue;
    private String ville;
    private String mail;
    private String description;
    private String imageName ;
    private Float prix;

    public Centre() {
    }

    public Centre(String nom_centre, int num, String rue, String ville, String mail, String description, String imageName, Float prix) {
        this.nom_centre = nom_centre;
        this.num = num;
        this.rue = rue;
        this.ville = ville;
        this.mail = mail;
        this.description = description;
        this.imageName = imageName;
        this.prix = prix;
    }

    public Centre(String nom_centre, int num, String rue, String ville, String mail, String description, String imageName) {
        this.nom_centre = nom_centre;
        this.num = num;
        this.rue = rue;
        this.ville = ville;
        this.mail = mail;
        this.description = description;
        this.imageName = imageName;
    }
    

    public Centre(int id, String nom_centre, int num, String rue, String ville, String mail, String description, String imageName, Float prix) {
        this.id = id;
        this.nom_centre = nom_centre;
        this.num = num;
        this.rue = rue;
        this.ville = ville;
        this.mail = mail;
        this.description = description;
        this.imageName = imageName;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getNom_centre() {
        return nom_centre;
    }

    public int getNum() {
        return num;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getMail() {
        return mail;
    }

    public String getDescription() {
        return description;
    }

    public String getImageName() {
        return imageName;
    }

    public Float getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_centre(String nom_centre) {
        this.nom_centre = nom_centre;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
      //  return "Centre{" + "id=" + id + ", nom_centre=" + nom_centre + ", num=" + num + ", rue=" + rue + ", ville=" + ville + ", mail=" + mail + ", description=" + description + ", imageName=" + imageName + ", prix=" + prix + '}';
      return nom_centre;
    }
    
    
    
}
