/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Promotion;
import java.util.List;

/**
 *
 * @author user
 */
public interface IServicePromotion<P> {
    
    public void ajouterPromotion(P p);
    public List<Promotion> afficher();
    public void supprimer(P p);
    
}
