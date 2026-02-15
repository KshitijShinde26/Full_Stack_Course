<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Login Page</h2>

<p style="color:red;">
${error}
</p>

<form action="<%= request.getContextPath() %>/site" method="post">

    <input type="hidden" name="action" value="loginUser" />

    Username: <input type="text" name="username" />
    <br><br>

    Password: <input type="password" name="password" />
    <br><br>

    <input type="submit" value="Login" />

</form>

</body>
</html>
