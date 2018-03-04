import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
@WebServlet("/sayhello")
public class HelloServlet extends HttpServlet {
   @Override
       public void doGet(HttpServletRequest request, HttpServletResponse response)
       throws IOException, ServletException {
 
       // Set the response MIME type of the response message
       response.setContentType("text/html");
       // Allocate a output writer to write the response message into the network socket
       PrintWriter out = response.getWriter();
 
       // Write the response message, in an HTML page
       try {
       	  out.println("<html>");
          out.println("<head><title>Stateful</title></head>");

          out.println("<body>");

          HttpSession session=request.getSession();
          session.setAttribute("savedUsername", request.getParameter("userName"));
	     	 String n=(String)session.getAttribute("savedUsername");  
	   	   out.print("Hello "+ n);  

    
    
         out.println("</body>");
         out.println("</html>");
         
       } finally {
	       out.close();  // Always close the output writer
       }
   }
}