/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.sql.SQLException;
import models.Utilisateur;
import java.util.List;

/**
 *
 * @author Mohamed
 */


public interface IService <T> {
    
    
    public List<T> afficher();
    public void ajouter(T t);
    public void  modifier (T t);
    public void supprimer (int id);
    public List<T> tri();
 
}

     
