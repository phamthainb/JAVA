package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import data.UserIO;

public class AddToEmailListServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        ServletContext sc = getServletContext();
       
        User user = new User(firstName, lastName, emailAddress);
        String message = "Please fill out";
        String url = "";
        if (firstName.length() == 0) {
            message += " First name, ";
        }
        if (lastName.length() == 0) {
            message += " Last name,";
        }
        if (emailAddress.length() == 0) {
            message += " Email,";
        }
        
        if (!message.equals("Please fill out")) {
            url = "/join_email_list.jsp";
        } else {
            message = "";
            String path = sc.getRealPath("/WEB-INF/EmailList.txt");
            UserIO.add(user, path); // value write to file in target/...
            url = "/display_email_entry.jsp";
        }
        
        request.setAttribute("user", user);
        request.setAttribute("message", message);
        
        // forward request and response to the view
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
