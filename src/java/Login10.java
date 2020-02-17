/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class Login10 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        RequestDispatcher rd = request.getRequestDispatcher("Welcome10.html");
        RequestDispatcher rdBack = request.getRequestDispatcher("Login10.html");
        
        
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(uname.equals("nccs") && password.equals("nccs1234")){
            rd.forward(request, response);
        }else{
            rdBack.forward(request, response);
        }
    }

    
}
