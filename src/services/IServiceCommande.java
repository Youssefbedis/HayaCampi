/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author MAKREM
 */
public interface IServiceCommande<T> {
      public void  ajouter(T t);
    public List<T> afficher();
    public void  modifier (T t);
    public void supprimer (T t);
    public int nbSurPlace();
    public int nbSurEnLigne();
}
