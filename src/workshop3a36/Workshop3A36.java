/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop3A36;

import Model.Livreur;
import Model.Livraison;
import Services.ServiceLivreur;
import Services.ServiceLivraison;
import java.util.List;

import utils.Connection;

/**
 *
 * @author chah
 */
public class Workshop3A36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   Connection a= Connection.getInstance();
       
       System.out.println(a.hashCode());
         ServiceLivreur s =  new ServiceLivreur();
         Livreur l = new Livreur();
         //ServiceLivraison l =  new ServiceLivraison();
       
//c1.setId(29);
//s.ajouter(c1);
//s.ajouter(c2);
System.out.println(s.afficher());
//s.modifier(c1);
//System.out.println(s.tri());
//System.out.println(s.recherche("mahfou"));
//System.out.println(l.rechercheL("400"));

//System.out.println(l.afficherL());
//s.afficher();
 //s.supprimer(c1);
  //s.supprimer(15);
 //s.modifier(c1);
    
    }
   
}
