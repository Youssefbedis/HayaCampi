/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 21650
 */
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
public class InputValidation {
        public static boolean textFilledIsNull(TextField inputTextField,String validationText)
    {
        boolean isNull = false;
        String validationString = null;
        
        if(inputTextField.getText().isEmpty())
        {
            isNull = true;
            validationString = validationText;
        }
        
        return isNull;
    }
            public static boolean emailFormat(TextField inputTextField, String validationText) {
        boolean isEmail = true;
        String validationString = null;

        if (!inputTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com")) {
            isEmail = false;
            validationString = validationText;

        }
        
        return isEmail;

    }
            public static boolean rbselected(RadioButton rb1,RadioButton rb2, Label output){
            boolean result=true;
                String validationString = null;
            if(!(rb1.isSelected()||rb2.isSelected())){
                    validationString="role required";
                result=false;}
            output.setText(validationString);
            return result;
            }
    
}
