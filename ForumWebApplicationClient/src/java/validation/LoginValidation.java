/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import forumServiceConsume.LoginModel;

/**
 *
 * @author Keagan
 */
public class LoginValidation {
    
    public String validateUserName(LoginModel loginModel){
        
        if(loginModel.getEmail().equals("")){
            return "Username Required";
            
        } else if (loginModel.getPassword().equals("")){
            return "Password Required";
        }
        return "validated";
    }
    
}
