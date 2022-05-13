/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author user
 */
public class UtilisateurSession {
    
    private  static UtilisateurSession instance=null;
    private static int id ;
    private static String email;
    private static String roles;
    private static String password ;
    private static String LastName;
    private static String FirstName;
    private static String CIN;
    private static String NumTel;
    private static String adresse;
    private static String is_verified;

    private UtilisateurSession(int id, String email, String roles, String password, String LastName, String FirstName, String CIN, String NumTel, String adresse,String is_verified) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.CIN = CIN;
        this.NumTel = NumTel;
        this.adresse = adresse;
        this.is_verified = is_verified;

    }

    public static UtilisateurSession getInstance() {
        return instance;
    }

    public static void setInstance(UtilisateurSession instance) {
        UtilisateurSession.instance = instance;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UtilisateurSession.id = id;
    }

    public static String getIs_verified() {
        return is_verified;
    }

    public static void setIs_verified(String is_verified) {
        UtilisateurSession.is_verified = is_verified;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UtilisateurSession.email = email;
    }

    public static String getRoles() {
        return roles;
    }

    public static void setRoles(String roles) {
        UtilisateurSession.roles = roles;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UtilisateurSession.password = password;
    }

    public static String getLastName() {
        return LastName;
    }

    public static void setLastName(String LastName) {
        UtilisateurSession.LastName = LastName;
    }

    public static String getFirstName() {
        return FirstName;
    }

    public static void setFirstName(String FirstName) {
        UtilisateurSession.FirstName = FirstName;
    }

    public static String getCIN() {
        return CIN;
    }

    public static void setCIN(String CIN) {
        UtilisateurSession.CIN = CIN;
    }

    public static String getNumTel() {
        return NumTel;
    }

    public static void setNumTel(String NumTel) {
        UtilisateurSession.NumTel = NumTel;
    }

    public static String getAdresse() {
        return adresse;
    }

    public static void setAdresse(String adresse) {
        UtilisateurSession.adresse = adresse;
    }
    public static UtilisateurSession getInstance(int id, String email, String roles, String password, String LastName, String FirstName, String CIN, String NumTel, String adresse) {
       
      if(instance == null) {
            instance = new UtilisateurSession( id,  email,  roles,  password,  LastName,  FirstName,  CIN,  NumTel,  adresse,is_verified);
        }
        return instance;
    }
    public static UtilisateurSession endSession()
    {
    instance=null;
    return instance;
    }
}
