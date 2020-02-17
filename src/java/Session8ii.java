///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author USER
// */
//public class Session8ii extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//
//            HttpSession session = request.getSession(false);
//            String n = (String) session.getAttribute("uname");
//            out.print("Hello " + n);
//
//            out.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//}
//
//}
