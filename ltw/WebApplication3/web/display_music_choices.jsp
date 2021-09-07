
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <%
            // get parameters from the request
            String firstName
                    = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress
                    = request.getParameter("emailAddress");
            String[] musics = request.getParameterValues("musics");
        %>
        <h1>Thanks for joining our email list, " + <%=firstName%> + " " + <%=lastName%> +"</h1>

    </body>
</html>
