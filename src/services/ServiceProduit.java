/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import models.produit;
/*import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;*/
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdbc.jdbc;

/**
 *
 * @author aicha
 */
public class ServiceProduit {
     private Connection cnx = jdbc.getInstance().getCnx() ;
     
    public void ajouter(produit c) {
    try {
      String querry= "INSERT INTO `produit` (nom,description,etat,image,categorie) VALUES ('"
                + c.getDescription()+"', '"
                + c.getEtat()+"','"
                  + c.getImage()+"','"
                  + c.getNom()+"','"
                + c.getCategorie()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

     public ObservableList<produit> afficher() throws SQLException {
     ObservableList<produit> result =  FXCollections.observableArrayList();
     String req = "SELECT * FROM `produit`";
     Statement stm = cnx.createStatement();
     
     ResultSet rst = stm.executeQuery(req);
     
     while(rst.next()){
         produit C = new produit();

         C.setId(rst.getInt("id"));
         C.setNom(rst.getString("nom"));
          C.setDescription(rst.getString("description"));
           C.setEtat(rst.getString("etat"));
            C.setImage(rst.getString("image"));
         C.setCategorie(rst.getString("categorie"));
         result.add(C);
     }

     return result;
    } 
     
      
    public void modifier(produit c) {
          try {
        String querry="UPDATE produit SET nom = '"+c.getNom()+"', description = '"+c.getDescription()+"', etat = '"+c.getEtat()+"', image = '"+c.getImage()+"',categorie = '"+c.getCategorie()+",' WHERE produit.`id` = "+c.getId()+";";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       }
    }
     public void supprimer(int id) {
 try {
        String querry="DELETE FROM produit WHERE produit.`id` = '"+id+"'";

        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
    }  
    public List<produit> recherche(String nom) throws SQLException{
     List<produit> produits = afficher();
    

     List<produit> resultat=produits.stream().filter(produit->nom.equals(produit.getNom())).collect(Collectors.toList());
        return resultat;   
    }
    
     public List<produit> tri() throws SQLException {
    List<produit> produits = afficher();
   
    List<produit> resultat=produits.stream().sorted( Comparator.comparing(produit::getNom)).collect(Collectors.toList());
      return resultat;
      
}
     
   /*  public String QR (String A) throws WriterException, IOException{
        
       
              
             try {
            String qrCodeData = "produit "+A+"";
            String filePath = "C:\\Users\\aicha\\Desktop\\QR"+A+".png";
            
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new EnumMap <  > (EncodeHintType.class);
            
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
            return filePath;
        } catch (UnsupportedEncodingException e) {
            System.err.println(e);
           return "";
        }
               
       }*/
     
     
     
     
     
        public List<produit> RechercherProduit(String critere,String rec) {
      
        List<produit> produits = new ArrayList();
    
        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT * FROM produit where "+critere+" like '"+rec+"%'";
     
        ResultSet rs= stm.executeQuery(querry);
        
        while(rs.next()){
            produit A = new produit();
            A.setId(rs.getInt(1));
            A.setNom(rs.getString(2));
            A.setDescription(rs.getString(3));
            A.setEtat(rs.getString(4));
            A.setImage(rs.getString(5));
            A.setCategorie(rs.getString(6));

            
            
            produits.add(A);
        }
        
    } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
    
    }
   
        return produits;
   
    }
     
     
        
        
     public List<produit> TrierPrd(String critere) {
      
        List<produit> produits = new ArrayList();
    
        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT * FROM produit order by "+critere;
     
        ResultSet rs= stm.executeQuery(querry);
        
         while(rs.next()){
            produit A = new produit();
           A.setId(rs.getInt(1));
            A.setNom(rs.getString(2));
            A.setDescription(rs.getString(3));
            A.setEtat(rs.getString(4));
            A.setImage(rs.getString(5));
            A.setCategorie(rs.getString(6));
            
            
            produits.add(A);
        }
        
    } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
    
    }
   
        return produits;
   
    }
     
     
     
     
     
     
     
     public produit FindBy(int id){
      produit m = new produit();
      try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * FROM `produit` where id ="+id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                 
    
              //  int id = rs.getInt("id");
                m.setId(rs.getInt("id"));
                m.setEtat(rs.getString("etat"));
                m.setCategorie(rs.getString("cat"));
           
               
                
                
                
            }
            rs.close();
            } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
      return m;
  }
     
     
     
     
     
     
     
     
}
