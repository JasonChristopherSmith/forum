/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import forumServiceConsume.RegistrationModel;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Keagan
 */
public class PasswordValidation {
    
    public String emptyPasswordField (HttpServletRequest request){
        
        String pswValidate = "";
        
        if(!request.getParameter("password").equals("")){
            pswValidate = validatePassword(request);
            return pswValidate;
        }
        return "required";
        
    }
    
    public String validatePassword (HttpServletRequest request){
        if(request.getParameter("password").equals(request.getParameter("confirm"))){
            return "validated";
            
        }
        return "notValidated";
    }
    
    
    
    
    
}
