
package servlet;

import business.User;
import data.UserIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayMusicChoicesServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // get parameters from the request
        String types[] = request.getParameterValues("types");
        // send response to browser
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(
                "<!doctype html public \"-//W3C//DTD HTML 4.0 "
                + " Transitional//EN\">\n"
                + "<html>\n"
                + "<head>\n"
                + " <title>Murach's Java Servlets and JSP</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>“Thanks for joining our email list, John Smith</h1>\n"
                + "<p>We ‘ll use this email to notify you whenever we have new releases for these types of music:</p>\n"
                + "</body>\n"
                + "</html>\n"
        );
        for(String type: types) {
            out.println(
               type + "<br>"
            );
        }
        out.println("</body>\n"
                + "</html>\n");
        
        out.close();
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
