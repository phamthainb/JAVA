package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import data.UserIO;

public class DisplayMusicChoicesServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // get parameters from the request
//        String[] musics = request.getParameterValues("musics");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String[] musics = request.getParameterValues("music");

        String musicToArray = "";
        for(int i = 0; i<musics.length; i++) {
            musicToArray += "<p>" + musics[i] + "</p>";
        }
        
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
                + "<h1>Thanks for joining our email list, " + firstName + " " + lastName +  "</h1>\n"
                + "<p>We'll use this email to notify you whenever we have new realeases for these types of musics:</p>\n"
                + musicToArray
                + "</body>\n"
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