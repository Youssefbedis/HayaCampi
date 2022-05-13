/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import models.Centre;
import java.util.List;
/**
 *
 * @author user
 */
public interface IServiceCentre<C>  {
    //public boolean ajouterProduit(C c);
    public void  ajouter(C c);
    public List<C> afficher();
     //public void  modifier (C c);
     public void modifier(C c);
      public void supprimer(int id);
      public List<Centre> tri();
}
