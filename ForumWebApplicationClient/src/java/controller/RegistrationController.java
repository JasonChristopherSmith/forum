/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.net.httpserver.HttpServer;
import forumServiceConsume.ForumService;
import forumServiceConsume.ForumService_Service;
import forumServiceConsume.RegistrationModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import validation.EmailValidation;
import validation.MobileValidation;
import validation.NameSurnameValidation;
import validation.PasswordValidation;

public class RegistrationController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        String validatePasswordResult;
        String validateEmailResult;
        boolean validateMobileResult;
        boolean validateNameSurnameResult;

        PasswordValidation passwordValidation = new PasswordValidation();
        EmailValidation emailValidation = new EmailValidation();
        MobileValidation mobileValidation = new MobileValidation();
        NameSurnameValidation nameSurnameValidation = new NameSurnameValidation();

        validatePasswordResult = passwordValidation.emptyPasswordField(request);

        if (validatePasswordResult.equals("notValidated")) {

            session.setAttribute("errorMessage", "Password does not match");
            session.setAttribute("nameValue", request.getParameter("fname"));
            session.setAttribute("surnameValue", request.getParameter("sname"));
            session.setAttribute("emailValue", request.getParameter("email"));
            session.setAttribute("mobileValue", request.getParameter("mobile"));

            try {
                response.sendRedirect("view/jsp/registration.jsp");
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (validatePasswordResult.equals("required")) {

            session.setAttribute("errorMessage", "Password required");
            session.setAttribute("nameValue", request.getParameter("fname"));
            session.setAttribute("surnameValue", request.getParameter("sname"));
            session.setAttribute("emailValue", request.getParameter("email"));
            session.setAttribute("mobileValue", request.getParameter("mobile"));

            try {
                response.sendRedirect("view/jsp/registration.jsp");
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (validatePasswordResult.equals("validated")) {

            validateEmailResult = emailValidation.validateEmail(request);

            if (validateEmailResult.equals("empty")) {

                session.setAttribute("errorMessage", "Email required!!");
                session.setAttribute("nameValue", request.getParameter("fname"));
                session.setAttribute("surnameValue", request.getParameter("sname"));
                session.setAttribute("emailValue", request.getParameter("email"));
                session.setAttribute("mobileValue", request.getParameter("mobile"));

                try {
                    response.sendRedirect("view/jsp/registration.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (validateEmailResult.equals("emailNotMatched")) {
                session.setAttribute("errorMessage", "Email does not comply");
                session.setAttribute("nameValue", request.getParameter("fname"));
                session.setAttribute("surnameValue", request.getParameter("sname"));
                session.setAttribute("emailValue", request.getParameter("email"));
                session.setAttribute("mobileValue", request.getParameter("mobile"));

                try {
                    response.sendRedirect("view/jsp/registration.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                validateMobileResult = mobileValidation.validateMobile(request);

                if (!validateMobileResult) {
                    session.setAttribute("errorMessage", "No Mobile number entered");
                    session.setAttribute("nameValue", request.getParameter("fname"));
                    session.setAttribute("surnameValue", request.getParameter("sname"));
                    session.setAttribute("emailValue", request.getParameter("email"));
                    session.setAttribute("mobileValue", request.getParameter("mobile"));

                    try {
                        response.sendRedirect("view/jsp/registration.jsp");
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (validateMobileResult) {
                    validateNameSurnameResult = nameSurnameValidation.validateNameSurname(request);

                    if (!validateNameSurnameResult) {
                        session.setAttribute("errorMessage", "Insert name and surname!!");
                        session.setAttribute("nameValue", request.getParameter("fname"));
                        session.setAttribute("surnameValue", request.getParameter("sname"));
                        session.setAttribute("emailValue", request.getParameter("email"));
                        session.setAttribute("mobileValue", request.getParameter("mobile"));

                        try {
                            response.sendRedirect("view/jsp/registration.jsp");
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (validateNameSurnameResult) {

                        RegistrationModel registrationModel = new RegistrationModel();
                        registrationModel.setName(request.getParameter("fname"));
                        registrationModel.setSurname(request.getParameter("sname"));
                        registrationModel.setMobile(request.getParameter("mobile"));
                        registrationModel.setEmail(request.getParameter("email"));
                        registrationModel.setPassword(request.getParameter("password"));

                        ForumService_Service service = new ForumService_Service();
                        ForumService port = service.getForumServicePort();
                        registrationModel = port.registerUser(registrationModel);

                        String message = registrationModel.getMessage();

                        if (message.equals("emailExists")) {

                            session.setAttribute("errorMessage", "Email address is already registered!!");
                            session.setAttribute("nameValue", request.getParameter("fname"));
                            session.setAttribute("surnameValue", request.getParameter("sname"));
                            session.setAttribute("emailValue", request.getParameter("email"));
                            session.setAttribute("mobileValue", request.getParameter("mobile"));

                            try {
                                response.sendRedirect("view/jsp/registration.jsp");
                            } catch (IOException ex) {
                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {

                            try {
                                session.invalidate();
                                response.sendRedirect("view/jsp/login.jsp");
                            } catch (IOException ex) {
                                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                }

            }

        }

    }
}
