import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet",urlPatterns = "/Success")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer= response.getWriter();

        String UserName = request.getParameter("UserName");
        String Password = request.getParameter("Password");

        if(UserName.equals ("Nivesh")&& Password.equals("123")){
            HttpSession session = request.getSession();
            Cookie c = new Cookie("cookiename",UserName);
            response.addCookie(c);
            RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
            rd.forward(request,response);
            writer.println("Welcome You Can View Your Details <br>");
        }
        else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
            writer.println("Invalid username or password <br>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
