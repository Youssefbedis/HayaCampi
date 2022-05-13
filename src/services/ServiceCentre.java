/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Centre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import static java.time.Clock.system;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




/**
 *
 * @author user
 */
public class ServiceCentre implements IServiceCentre<Centre>{
    private Connection cnx = jdbc.getInstance().getCnx() ;
    
     Connection connexion;
   
     @Override
    public void ajouter(Centre c) {
    try {
        String querry= "INSERT INTO centre( `nom_centre`, `num`, `rue`, `ville`, `mail`, `description`, `image_name`, `prix`)  "
                + "VALUES ('"+c.getNom_centre()+"',"+c.getNum()+",'"+c.getRue()+"','"+c.getVille()+"','"+c.getMail()+"','"+c.getDescription()+"','"+c.getImageName()+"',"+c.getPrix()+")";
       // String querry= "INSERT INTO centre(`nom`, `prenom`) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }
    
    
     @Override
    public List<Centre> afficher() {
     List<Centre> centres = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `centre`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Centre c = new Centre();
            c.setId(rs.getInt(1));
            c.setNom_centre(rs.getString("nom_centre"));
            c.setNum(rs.getInt("num"));
            c.setRue(rs.getString("rue"));
            c.setVille(rs.getString("ville"));
            c.setMail(rs.getString("mail"));
            c.setDescription(rs.getString("description"));
            c.setPrix(rs.getFloat("prix"));
            c.setImageName(rs.getString("image_name"));
            centres.add(c);
            
        }
        
        
        
        return centres;
    } catch (SQLException ex) {
        }
    return centres;
    }
    
    @Override
   /* public void modifier(Centre c) {
        try {
        PreparedStatement query = cnx.prepareStatement(
                "UPDATE `centre` SET nom_centre=?,num=?,rue=?,ville=?,mail=?,description=?,image_name=?,prix=? where id=?");        
                
        query.setString(2, c.getNom_centre());
        query.setInt(3, c.getNum());
        query.setString(4, c.getRue());
        query.setString(5, c.getVille());
        query.setString(6, c.getMail());
        query.setString(7, c.getDescription());        
        query.setString(8, c.getImageName());
//        query.setFloat(9, c.getPrix());
        query.executeUpdate();
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
        }
        
    }*/
    
    public void modifier(Centre c) {
          try {
              Double boule=(double)c.getPrix();
        String querry="UPDATE `centre` SET `nom_centre` = '"+c.getNom_centre()+"', `num` = '"+c.getNum()+"', `rue` = '"+c.getRue()+"', `ville` = '"+c.getVille()+"', `mail` = '"+c.getMail()+"',`description` = '"+c.getDescription()+"',`image_name` = '"+c.getImageName()+"' WHERE `centre`.`id` = "+c.getId()+";";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
    } catch (SQLException ex) {
            System.err.println(ex);
       }
//          try {
//        String querry="UPDATE `article` SET `titre` = '"+t.getTitre()+"', `text` = '"+t.getText()+"', `media` = '"+t.getMedia()+"', `tag` = '"+t.getTag()+",' WHERE `article`.`id` = "+t.getId()+";";
//        Statement stm = cnx.createStatement();
//        stm.executeUpdate(querry);
//    } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//    }
    }
    @Override
    public void supprimer(int id) {
 try {
        String querry="DELETE FROM centre WHERE centre.`id` = '"+id+"' ";
        

        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
    }  
@Override
    public List<Centre> tri() {
    return afficher().stream().sorted( Comparator.comparing(Centre::getNom_centre)).collect(Collectors.toList());
      
      
}
    
    
    /*@Override
    public List<Centre> recherche(String nomCentre) {
     List<Centre> centres = afficher();
    

     List<Centre> resultat=centres.stream().filter(livreur->nomLivreur.equals(livreur.getNomLivreur())).collect(Collectors.toList());
        return resultat;   


    }*/
    
    
    
      public void exel() {
         
   try{ 
        XSSFWorkbook workbook = new XSSFWorkbook();
     // spreadsheet object
        XSSFSheet spreadsheet
            = workbook.createSheet(" Centre Data ");
  
        // creating a row object
        XSSFRow row;
  
        // This data needs to be written (Object[])
        Map<String,Object[]> CentreData= new TreeMap<String, Object[]>();
        CentreData.put("0",new Object[]{"NOM CENTRE","NUM"} );
                List<Centre> fares =afficher();
                        for(Centre c:fares){
                            CentreData.put(""+c.getId(),new Object[]{c.getNom_centre(),c.getNum()+""});
           
            }
                        
       
  
        Set<String> keyid = CentreData.keySet();
  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = CentreData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
  
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
            new File("C:/Centres.xlsx"));
  
        workbook.write(out);
        out.close();
   }
   catch(Exception e )
   {
       
           }
    }
      
      
      
     
}



