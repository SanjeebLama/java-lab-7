import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletConfig;
/**
 *
 * @author dipesh
 */
public class AuthServlet extends HttpServlet {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    public void init(ServletConfig config){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/login";
            con = DriverManager.getConnection(url,"root","");
            stmt = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        String n,p;
        n = request.getParameter("uname");
        p = request.getParameter("password");
        
        try{
            String un , pwd;
            String sql = "SELECT * FROM login where name = 'admin'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                un = rs.getString("name");
                pwd = rs.getString("password");
               if(un.equals(n) && pwd.equals(p)){
                    pw.println("Name/password match");
            }else{
                    pw.println("Name/password does not match");
                }
           }
             
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

   

}