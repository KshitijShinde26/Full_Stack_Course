<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.basic.Hello" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<h2><%= new Hello().message() %></h2>

<a href="<%= request.getContextPath() %>/site?action=login">
    Go to Login Page
</a>

</body>
</html>
