<%-- 
    Document   : PermisosUsuario
    Created on : 13-dic-2020, 20:51:36
    Author     : claud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    if (session.getAttribute("username") == null) {
       response.sendRedirect("index.jsp");
    } 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
