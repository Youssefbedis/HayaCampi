/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.produit;
import services.ServiceProduit;
import java.sql.SQLException;
/**
 *
 * @author Amirov
 */
public class GestPrd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
                  ServiceProduit sp = new ServiceProduit() ;
//produit p = new produit("Aicha","Produit1","hors stock","image.jpg","cat");
       //     sp.supprimer(9);
    System.out.println( sp.afficher().toString());
    
}
        
        
    }
    

