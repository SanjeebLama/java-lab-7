/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class DBQ7 extends HttpServlet {

    Statement stmt = null;
    public void init(ServeltConfig config) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:localhost://3306/servlet";
            Connection con = DriverManager.getConnection(url, "root", "");
             stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

//        String name,address,designation,department;
//        pw.println("Inside doGet()");
//        name = request.getParameter("name");
//        address = request.getParameter("address");
//        designation = request.getParameter("designation");
//        department = request.getParameter("department");
        try {

            String n, a, d, dept;
            String sql = "SELECT * FROM employee";

           ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                n = rs.getString(0);
                a = rs.getString(1);
                d = rs.getString(2);
                dept = rs.getString(3);
                pw.println("Employe Information");
                pw.println("Name : " + n + "/nAddress : " + a + "/nDesignaton : " + d + "/nDepartment : " + dept);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
