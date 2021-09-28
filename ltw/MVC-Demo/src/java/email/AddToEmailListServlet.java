
package email;

import business.User;
import data.UserIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddToEmailListServlet extends HttpServlet {
    
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // get parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        
        // create the User object from the parameters
        User user = new User(firstName, lastName, emailAddress);
        // validate the parameters
        String messageFirst = "";
        String messageLast = "";
        String messageEmail = "";
        String url = "";
        if (firstName.length() == 0 ||
        lastName.length() == 0 ||
        emailAddress.length() == 0)
        {
//            message =
//            "Please fill out all three text boxes.";
//            url = "/join_email_list.jsp";
            if(firstName.length()==0)
                messageFirst= "Please fill out first name text box";
            
            if(lastName.length()==0)
                messageLast= "Please fill out last name text box";
            
            if(emailAddress.length()==0)
                messageEmail= "Please fill out email address text box";
                
            url = "/index.jsp";
        }
        else
        {
            //message = "";
            ServletContext context = getServletContext();
            String path = context.getRealPath(
            "/WEB-INF/EmailList.txt");
            UserIO.add(user, path);
            url = "/display_email_entry.jsp";
        }
        request.setAttribute("user", user);
        request.setAttribute("messageFirst", messageFirst);
        request.setAttribute("messageLast", messageLast);
        request.setAttribute("messageEmail", messageEmail);
        // forward request and response to the view
        RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
        
        
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
}
