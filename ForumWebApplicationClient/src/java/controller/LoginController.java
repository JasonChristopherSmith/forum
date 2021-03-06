/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import forumServiceConsume.ForumService;
import forumServiceConsume.ForumService_Service;
import forumServiceConsume.LoginModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import validation.LoginValidation;

public class LoginController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);

        LoginModel loginModel = new LoginModel();
        loginModel.setEmail(request.getParameter("email"));

        loginModel.setPassword(request.getParameter("password"));

        LoginValidation loginValidation = new LoginValidation();
        String message = loginValidation.validateUserName(loginModel);

        if (!message.equals("validated")) {

            session.setAttribute("username", loginModel.getEmail());
            session.setAttribute("loginErrorMessage", message);
            try {
                response.sendRedirect("view/jsp/login.jsp");
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            ForumService_Service service = new ForumService_Service();
            ForumService port = service.getForumServicePort();
            loginModel = port.loginUser(loginModel);

            message = loginModel.getMessage();
            if (message.equals("loginExists")) {

                try {
                    session.invalidate();
                    response.sendRedirect("view/jsp/topics.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                session.setAttribute("username", loginModel.getEmail());
                session.setAttribute("loginErrorMessage", message);
                try {
                    response.sendRedirect("view/jsp/login.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
