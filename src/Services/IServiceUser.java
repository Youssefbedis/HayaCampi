/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Utilisateur;
import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author user
 */
public interface IServiceUser<T>{
    void ajouteruser(T t) throws SQLException;
    void modifieruser(T t,int id)throws SQLException;
    void  supprimeruser (int t)throws SQLException;
    public List afficheruser() throws SQLException;
    public List afficheruserid(int ID) throws SQLException;
    public String Login(String email,String password,String message);
    public void Logout();
    public String crypter(String password);
    
}
