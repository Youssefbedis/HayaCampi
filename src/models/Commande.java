/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Commande {
   private int id;
   private int user_id;
   private String num;
   private String rue;
   private String ville;
   private String num_tel;
   private String num_carte;
   private String mode;

    public Commande() {
    }

    public Commande(int id, int user_id, String num, String rue, String ville, String num_tel, String num_carte, String mode) {
        this.id = id;
        this.user_id = user_id;
        this.num = num;
        this.rue = rue;
        this.ville = ville;
        this.num_tel = num_tel;
        this.num_carte = num_carte;
        this.mode = mode;
    }

    public Commande(int user_id, String num, String rue, String ville, String num_tel, String num_carte, String mode) {
        this.user_id = user_id;
        this.num = num;
        this.rue = rue;
        this.ville = ville;
        this.num_tel = num_tel;
        this.num_carte = num_carte;
        this.mode = mode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getNum_carte() {
        return num_carte;
    }

    public void setNum_carte(String num_carte) {
        this.num_carte = num_carte;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", user_id=" + user_id + ", num=" + num + ", rue=" + rue + ", ville=" + ville + ", num_tel=" + num_tel + ", num_carte=" + num_carte + ", mode=" + mode + '}';
    }
    
    


}
