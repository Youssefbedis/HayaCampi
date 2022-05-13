/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Livreur;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public interface IService11 <T> {
    
    public boolean  ajouter(Livreur p );
    public List<Livreur> afficher();
    public boolean  modifier (T t);
    public boolean supprimer (T t);
    public List<Livreur> tri();
    public List<Livreur> recherche(String prenomLivreur);
    /*
    ....
TO DO  
tri 
recherche 
.... 
    */

}
