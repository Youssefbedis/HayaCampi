/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import models.Utilisateur;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.DatatypeConverter;
import jdbc.jdbc;
import utils.UtilisateurSession;
/**
 *
 * @author user
 */
public class ServiceUtilisateur implements IServiceUser<Utilisateur>{
    private Connection cnx = jdbc.getInstance().getCnx() ;
    
    /**
     *
     * @param u
     * @throws SQLException
     */
    @Override
    public void ajouteruser(Utilisateur u) throws SQLException {
        //request 
        String req="INSERT INTO `user`(`email`, `roles`, `password`, `last_name`, `first_name`, `cin`, `num_tel`, `adresse`) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,u.getEmail());
            pst.setString(2,u.getRoles());
            pst.setString(3,u.getPassword());
            pst.setString(4,u.getLastName());
            pst.setString(5,u.getFirstName());
            pst.setString(6,u.getCIN());
            pst.setString(7,u.getNumTel());
            pst.setString(8,u.getAdresse());
                        
            pst.executeUpdate();
            System.out.println("Utilisateur ajouter avec Succes");
            
        
        
    }
    @Override
    public void modifieruser(Utilisateur u, int ID) throws SQLException {
            //request 
            System.out.println("pre modifier");
        String req="UPDATE `user` SET `email`=?,`password`=?, `last_name`=? , `first_name` = ?, "
                + "`cin` =?, `num_tel`=?, `Adresse`=? WHERE `ID`="+ID;

        
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,u.getEmail());
            pst.setString(2,u.getPassword());
            pst.setString(3,u.getLastName());
            pst.setString(4,u.getFirstName());
            pst.setString(5,u.getCIN());
            pst.setString(6,u.getNumTel());
            pst.setString(7,u.getAdresse());
            pst.executeUpdate();
            System.out.println("Modification terminer avec Succes");
    }

    @Override
    public void supprimeruser(int ID) throws SQLException {
        //request 
        String req="DELETE FROM `user` WHERE ID=?";

        
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,ID);            
            pst.executeUpdate();
            
        
            System.out.println("Utilisateur Supprimer avec Succes");
        
    }

    @Override
    public List<Utilisateur> afficheruser() throws SQLException {
        //LIST
        List<Utilisateur> utilisateurs = new ArrayList<>();
        //request 
        String req ="SELECT * FROM user ";

            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                utilisateurs.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                
            }
          
        return utilisateurs;

    }
    
    
    public String crypter_password(String password) {
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();

        } catch (NoSuchAlgorithmException e) {
        }

   
     return hashValue;
    
    }

    @Override
    public List<Utilisateur> afficheruserid(int ID) throws SQLException {
        
        //LIST
        List<Utilisateur> utilisateurs = new ArrayList<>();
        //request 
        String req ="SELECT * FROM user WHERE user.`id` = '"+ID+"'";

            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                utilisateurs.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                
            }
          
        return utilisateurs;
        

    }
    @Override
    public String crypter(String password) {
        String url = "http://127.0.0.1:8000/encryptepass?password="+password;
      
        return password;
        
    }
    
        @Override
    public String Login(String email,String password,String message) {
      String req = "SELECT * FROM user WHERE `email` = '"+ email +"'";
       try {
            Statement st = cnx.createStatement();

            ResultSet rs = st.executeQuery(req);
              if(!rs.next()){
                  message="verifier vos cordonner";
                    
                }
              else if(rs.getString("is_verified")!=null)
              {
              message ="compte pas encore activer";
              
              }
              
              else if(rs.getString("password").equals(password))
              {
                  UtilisateurSession.getInstance(rs.getInt("id"), rs.getString("email"), rs.getString("roles"), rs.getString("password"),
                        rs.getString("last_name"), rs.getString ("first_name"), rs.getString("cin"), 
                        rs.getString("num_tel"), rs.getString("adresse"));
                  System.out.println(UtilisateurSession.getLastName());
                  message="Bienvenue";
                  
              }
              else message="mot de passe incorrect";
              
    }catch (SQLException ex) {
            ex.printStackTrace();
        }
       
       return  message;
    }
    @Override
    public void Logout() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       UtilisateurSession.endSession();
    }
    
 }
    
   


