package controller;

import animatefx.animation.Shake;
import Model.InputValidation;
import Model.Utilisateur;
import Services.IServiceUser;
import Services.ServiceUtilisateur;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import utils.MyDb;
import utils.UtilisateurSession;

public class LoginController {
         private Stage stage;
    private Scene scene;
    private Parent root;
    IServiceUser su = new ServiceUtilisateur();


    @FXML
    private TextField TFemail;

    @FXML
    private TextField TFmotdepasse;
    @FXML
    private Button Login;
     @FXML
    private void Login1(ActionEvent event) throws IOException {
    
    System.out.println("here");
     /*   String query2="select * from user where email=?  and password=?";
       Connection cnx =  MyDb.getInstance().getCnx();
      try{
          PreparedStatement smt = cnx.prepareStatement(query2);
       
               smt.setString(1,TFemail.getText());
               smt.setString(2,TFmotdepasse.getText());
               ResultSet rs= smt.executeQuery();
               Utilisateur p;
              
                 if (TFemail.getText().isEmpty()) {
            TFemail.requestFocus();
            shake(TFemail);
            return;
        }
                     else if (TFmotdepasse.getText().isEmpty()) {
            TFmotdepasse.requestFocus();
            shake(TFmotdepasse);
            return;
        }
                     else if (rs.next()){
                     
                     p=new Utilisateur(rs.getInt("id"),rs.getString("email"),rs.getString("roles"),
                             rs.getString("password"),rs.getString("last_name"),rs.getString("first_name"),
                             rs.getString("cin"),rs.getString("num_tel"),rs.getString("adresse"));
                     Utilisateur.setCurrent_Utilisateur(p);
                     System.out.println(Utilisateur.Current_Utilisateur.getEmail());
                     
                     //permiision
                     /*if( permiision(User.Current_User)){
                         System.out.println("bonjours"+User.Current_User.toString());*/
          if (TFemail.getText().isEmpty()) {
            TFemail.requestFocus();
            shake(TFemail);
            return;
        }
                     else if (TFmotdepasse.getText().isEmpty()) {
            TFmotdepasse.requestFocus();
            shake(TFmotdepasse);
            return;
        }
                         String email =TFemail.getText();
                         String password =TFmotdepasse.getText();
                IServiceUser us =new ServiceUtilisateur();
               String test= us.Login(email, password, "");
               if(test.equals("Bienvenue"))
               {
                             Login.getScene().getWindow().hide();
                             String role =UtilisateurSession.getRoles();
                             if (role.equals("["+'"'+"ROLE_USER"+'"'+']')){
                    Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("gui/Home.fxml"));
                     Scene scene;
                     
                    scene = new Scene(root1,1220, 700);
                    Stage stage = new Stage();
                    //stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
      
                    stage.show();  
                             }
                             else 
                             {
                                 System.out.println("rani hne");
                                    Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("gui/Dashboard.fxml"));
                     Scene scene;
                     
                    scene = new Scene(root1,1220, 700);
                    Stage stage = new Stage();
                    //stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
      
                    stage.show();  
                             }
                     }
               else{
                   System.out.println("erreur");
                   
               }}
          
     
            /* boolean testEmail =  InputValidation.textFilledIsNull(TFemail,  "email required");
         boolean testEmailFormat = InputValidation.emailFormat(TFemail, "Exemple: eslord@gmail.com");
            boolean testpassword =  InputValidation.textFilledIsNull(TFmotdepasse, "pass required");
            if(!testEmail&& testEmailFormat && !testpassword)
            {
            String msg="";
            String pass="";
            Utilisateur u=new Utilisateur();
           pass=u.crypter(TFmotdepasse.getText().toString());
         String message=su.Login(TFemail.getText().toString(), pass, msg);
         if(message.equals("Bienvenue"))
         {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
              
                root = loader.load();
                //The following both lines are the only addition we need to pass the arguments
              //Parent root= FXMLLoader.load(getClass().getResource("HomeForm.fxml"));
                HomeController hfb = loader.getController();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Home Page");
               // scene = new Scene(root,1220, 750);
                stage.setScene(scene);
                stage.show();*/
        /*Parent root= FXMLLoader.load(getClass().getResource("ModifierForm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("profile setting");
        //Scene SM=new Scene(root,1220, 750);
       
        stage.setScene(new Scene(root,1220, 750));
        stage.show();*//*
         }
         else
              JOptionPane.showMessageDialog(null, message);
            
            }
    */
    


    @FXML
    void Register(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

   public static void shake(Node node) {
        new Shake(node).play();
    }

    

}
