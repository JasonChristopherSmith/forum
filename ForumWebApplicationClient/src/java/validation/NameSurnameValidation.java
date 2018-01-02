/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Keagan
 */
public class NameSurnameValidation {
    public boolean validateNameSurname(HttpServletRequest request){
        if (request.getParameter("fname").equals("") || request.getParameter("sname").equals("")){
            return false;
        }
        return true;
    }
}
