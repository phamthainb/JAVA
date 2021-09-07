<%@ page import="business.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            // get parameters from the request
            User user = (User) request.getAttribute("user");
        %>
        <h1>Thanks for joining our email list</h1>
        <p>Here is the information that you entered:</p>
        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <td align="right">First name:</td>
                <td><%= user.getFirstName()%></td>
            </tr>
            <tr>
                <td align="right">Last name:</td>
                <td><%= user.getLastName()%></td>
            </tr>
            <tr>
                <td align="right">Email address:</td>
                <td><%= user.getEmailAddress()%></td>
            </tr>
        </table>

        <p>To enter another email address, click on the Back <br>
            button in your browser or the Return button shown <br>
            below. </p>
        <form action="index.jsp" method="post">
            <input type="submit" value="Return">
        </form>
    </body>
</html>
