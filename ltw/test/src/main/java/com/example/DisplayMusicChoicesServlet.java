package com.example;

import com.example.model.User;
import com.example.model.UserIO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class DisplayMusicChoicesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String[] musics = request.getParameterValues("musics");
        ServletContext sc = getServletContext();
        User user = new User(firstName, lastName, emailAddress);
        String message = "Please fill out";
        String url = "";
        if (firstName.length() == 0   ){
            message+= " First name, ";
        }
        if (lastName.length() == 0) {
            message+= " Last name,";
        }
        if (emailAddress.length() == 0) {
            message+= " Email,";
        }
        if (!message.equals("Please fill out")) {
            url = "/join_email_list.jsp";
        }
        else
        {
            message = "";
            String path = sc.getRealPath("/WEB-INF/EmailList.txt");
            UserIO.add(user, path); // value write to file in target/...
            url = "/display_email_entry.jsp";
        }
        request.setAttribute("user", user);
        request.setAttribute("message", message);
        request.setAttribute("musics", Arrays.asList(musics));
        // forward request and response to the view
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
