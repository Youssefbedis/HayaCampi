/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.produit;
import com.itextpdf.text.Document;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import services.ServiceProduit;


/**
 *
 * @author Amirov
 */
public class Pdf {
    
    
   
       
    public void GeneratePdfm(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
      
        ServiceProduit m=new ServiceProduit();
        List<produit> list=m.afficher();    
        document.add(new Paragraph("La liste des Produits :"));
        document.add(new Paragraph("     "));
         for(produit u:list)
        {
                            document.add(new Paragraph("Id :"+u.getId()));
        document.add(new Paragraph("Nom produit :"+u.getNom()));
        document.add(new Paragraph("desc:"+u.getDescription()));
        document.add(new Paragraph("etat:"+u.getEtat()));
        document.add(new Paragraph("img:"+u.getImage()));
        document.add(new Paragraph("cat:"+u.getCategorie()));


        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
    
    
}