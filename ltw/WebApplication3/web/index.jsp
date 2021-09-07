<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Join our email list</h1>
<p>To join our email list, enter your name and
    email address below. <br>
    Then, click on the Submit button.</p>
<form action="displayMusicChoices" method="get">
    <table cellspacing="5" border="0">
        <tr>
            <td align="right">First name:</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td align="right">Last name:</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td align="right">Email address:</td>
            <td><input type="text" name="emailAddress"></td>
        </tr>
        <tr>
            <td align="right">“I’m interested in these types of music”</td>
            <td><select name="musics" multiple>
                <option value="Rock">
                    Rock
                </option>
                <option value="Country">
                    Country
                </option>
                <option value="Bluegrass">
                    Bluegrass
                </option>
                <option value="Folk">
                    Folk
                </option>
            </select></td>
        </tr>
        <tr>
            <td></td>
            <td><br>
                <input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>