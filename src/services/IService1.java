/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Service;
import java.util.List;
/**
 *
 * @author Nour
 */
public interface IService1 <T> {
    
    public void  ajouter(T t);
    public List<T> afficher();
    public void  modifier (T t);
    public void supprimer (int id);
    public List<T> recherche(String description);
    public List<T> tri();
    public int nb1();
    public int nb2();
  //  public int nb3();
    public int nb4();
    public int nb5();
    public int nb6();
    /*
    ....
TO DO  
tri 
recherche 
.... 
    */

}
