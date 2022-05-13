/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Livraison;
import java.util.List;

/**
 *
 * @author chahi
 */
public interface IIService <T>{
     public boolean Ajouter(Livraison p);

    public List<Livraison> Afficher();

    public boolean Supprimer(T t);
}
