/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class FactorialQ5 extends HttpServlet {

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        int fact,num,i;
        fact = 1;
        num = Integer.parseInt(request.getParameter("num"));
        for(i=1; i<= num; i++){
            fact = fact*i;
        }
        pw.println("Factorial of "+num+" is "+fact);
    }
}
