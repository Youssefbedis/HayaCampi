/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import models.Centre;
import services.ServiceCentre;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import jdbc.jdbc;


/**
 *
 * @author HP
 */


public class PDF {
    
    /**
     * @param args the command line arguments
     */
    
     private Statement ste;
     private Connection con;
    
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
        //Image img = Image.getInstance("C:/Users/Wael Hcine/Desktop/sportun.png");
        //Image img2 = Image.getInstance("logo.png");
        ServiceCentre us=new ServiceCentre();
        con = jdbc.getInstance().getCnx();
                ste = con.createStatement();
       List<Centre> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT * FROM centre");
     while (rs.next()) {                
          /*     int idCommande=rs.getInt(1);
               int idUser=rs.getInt(2);
               float total=rs.getFloat(3);
               String etat=rs.getString(4);*/
          int id = rs.getInt(1);
          String nom_centre = rs.getString(2);
          int num = rs.getInt(3);
          String rue = rs.getString(4);
          String ville = rs.getString(5);
          String mail = rs.getString(6);
          String description = rs.getString(7);
          String image = rs.getString(8);
          Float prix = rs.getFloat(9);
          
          
          Centre e=new Centre(id, nom_centre,num,rue,ville,mail,description,image,prix);   
               
        arr.add(e);}
     // document.add(img);
        for(Centre h:arr)
        {
        document.add(new Paragraph("id :"+h.getId()));
        document.add(new Paragraph("Name :"+ h.getNom_centre()));
        document.add(new Paragraph("Num:"+h.getNum()));
        document.add(new Paragraph("Rue :"+h.getRue()));
        document.add(new Paragraph("Ville :"+h.getVille()));
        document.add(new Paragraph("Mail :"+h.getMail()));
        document.add(new Paragraph("Description :"+h.getDescription()));
        document.add(new Paragraph("Image :"+h.getImageName()));
        document.add(new Paragraph("prix :"+String.valueOf(h.getPrix())));
        
           //document.add(img);
         //document.add(img2);
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        } 
        
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
    
}
