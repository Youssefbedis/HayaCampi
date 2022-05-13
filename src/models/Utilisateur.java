/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author MAKREM
 */
public class Utilisateur {
     private int id ;
    private String email;
    private String roles;
    private String password ;
    private String LastName;
    private String FirstName;
    private String CIN;
    private String NumTel;
    private String adresse;
    private String is_verified;
    public static Utilisateur Current_Utilisateur;
 

    public Utilisateur() {
    }

   

  
    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", email=" + email + ", roles=" + roles + ", password=" + password + ", LastName=" + LastName + ", FirstName=" + FirstName + ", CIN=" + CIN+ ", NumTel=" + NumTel +", adresse=" + adresse +  '}';
    }

   
    public Utilisateur( String email,String roles, String password, String LastName, String FirstName, String CIN, String NumTel, String adresse) {
       
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.CIN = CIN;
        this.NumTel = NumTel;
        this.adresse = adresse;
       
     
       
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    public String getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getCIN() {
        return CIN;
    }
    public String getNumTel() {
        return NumTel;
    }


    public String getAdresse() {
        return adresse;
    }

    public String getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(String is_verified) {
        this.is_verified = is_verified;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setroles(String roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
     public void setNumTel(String NumTel) {
        this.NumTel = NumTel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public static Utilisateur getCurrent_Utilisateur() {
        return Current_Utilisateur;
    }

    public static void setCurrent_Utilisateur(Utilisateur Current_Utilisateur) {
        Utilisateur.Current_Utilisateur = Current_Utilisateur;
    }

    public Utilisateur(int id, String email, String roles, String password, String LastName, String FirstName, String CIN, String NumTel, String adresse, String is_verified) {
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
    

    public Utilisateur(int id, String email,String roles, String password, String LastName, String FirstName, String CIN, String NumTel, String adresse) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.CIN = CIN;
        this.NumTel = NumTel;
        this.adresse = adresse;
    } 
     public String crypter(String password){
        String Newstr="";  

        for (int i=0;i<password.length();i++)  
        {  
            char ch=Character.toLowerCase(password.charAt(i));  
            switch (ch)  
            {  
                case 'a':  
                    Newstr=Newstr+"{";  
                    break;  
                case 'b':  
                    Newstr=Newstr+"}";  
                    break;  
                case 'c':  
                    Newstr=Newstr+"#";  
                    break;  
                case 'd':  
                    Newstr=Newstr+"~";  
                    break;  
                case 'e':  
                    Newstr=Newstr+"+";  
                    break;  
                case 'f':  
                    Newstr=Newstr+"-";  
                    break;  
                case 'g':  
                    Newstr=Newstr+"*";  
                    break;  
                case 'h':  
                    Newstr=Newstr+"@";  
                    break;  
                case 'i':  
                    Newstr=Newstr+"/";  
                    break;  
                case 'j':  
                    Newstr=Newstr+"\\";  
                    break;  
                case 'k':  
                    Newstr=Newstr+"?";  
                    break;  
                case 'l':  
                    Newstr=Newstr+"$";  
                    break;  
                case 'm':  
                    Newstr=Newstr+"!";  
                    break;  
                case 'n':  
                    Newstr=Newstr+"^";  
                    break;  
                case 'o':  
                    Newstr=Newstr+"(";  
                    break;  
                case 'p':  
                    Newstr=Newstr+")";  
                    break;  
                case 'q':  
                    Newstr=Newstr+"<";  
                    break;  
                case 'r':  
                    Newstr=Newstr+">";  
                    break;  
                case 's' :  
                    Newstr=Newstr+"=";  
                    break;  
                case 't':  
                    Newstr=Newstr+";";  
                    break;  
                case 'u':  
                    Newstr=Newstr+",";  
                    break;  
                case 'v' :  
                    Newstr=Newstr+"_";  
                    break;  
                case 'w':  
                    Newstr=Newstr+"[";  
                    break;  
                case 'x' :  
                    Newstr=Newstr+"]";  
                    break;  
                case 'y':  
                    Newstr=Newstr+":";  
                    break;  
                case 'z' :  
                    Newstr=Newstr+"\"";  
                    break;  
                case ' ' :  
                    Newstr=Newstr+" ";  
                    break;  
                case '.':  
                    Newstr=Newstr+'3';  
                    break;  
                case ',':  
                    Newstr=Newstr+"1";  
                    break;  
                case '(':  
                    Newstr=Newstr+'4';  
                    break;  
                case '\"':  
                    Newstr=Newstr+'5';  
                    break;  
                case ')' :  
                    Newstr=Newstr+"7";  
                    break;  
                case '?' :  
                    Newstr= Newstr+"2";  
                    break;  
                case '!':  
                    Newstr= Newstr+"8";  
                    break;  
                case '-' :  
                    Newstr= Newstr+"6";  
                    break;  
                case '%' :  
                    Newstr = Newstr+"9";  
                    break;  
                case '1':  
                    Newstr=Newstr+"r";  
                    break;  
                case '2':  
                    Newstr=Newstr+"k";  
                    break;  
                case '3':  
                    Newstr=Newstr+"b";  
                    break;  
                case '4':  
                    Newstr = Newstr+"e";  
                    break;  
                case '5':  
                    Newstr = Newstr+"q";  
                    break;  
                case '6':  
                    Newstr = Newstr+"h";  
                    break;  
                case '7':  
                    Newstr = Newstr+"u";  
                    break;  
                case '8' :  
                    Newstr= Newstr+"y";  
                    break;  
                case '9':  
                    Newstr = Newstr+"w";  
                    break;  
                case '0':  
                    Newstr = Newstr+"z";  
                    break;  
                 default:  
                    Newstr=Newstr+"0";  
                    break;  
            }  
        }  
        
        
        return Newstr;
    }
}
