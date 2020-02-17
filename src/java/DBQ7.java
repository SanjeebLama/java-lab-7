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
 * @author dipesh
 */
public class DBQ7 extends HttpServlet {

  Connection con=null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public void init(ServletConfig config){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/test_db";
            con = DriverManager.getConnection(url, "root", "");
            stmt = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
       String n, a, d, des;
        n = request.getParameter("name");
        a = request.getParameter("address");
       d = request.getParameter("department");
        des = request.getParameter("designation");
        pw.println("Outside try catch");
        try {
            String sqlInsert = "INSERT INTO employee VALUES ('"+n+"','"+a+"','"+d+"','"+des+"')";
            int result = stmt.executeUpdate(sqlInsert);
            if(result != -1){
                System.out.println("Inserted Succesfully");
            }else{
                System.out.println("Error in insertion");
            }
            String sql = "SELECT * FROM employee";
            rs = stmt.executeQuery(sql);
            String name, address, dept, designation;
            while(rs.next()){
                name = rs.getString("name");
                address = rs.getString("address");
                dept = rs.getString("department");
                designation = rs.getString("designation");
                pw.println("Name : "+name);
                pw.println("Address : "+address);
                pw.println("Department : "+dept);
                pw.println("Designation : "+designation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}