<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member</title>
</head>
<body>

<h2>Welcome ${sessionScope.username} 🎉</h2>

<a href="<%= request.getContextPath() %>/site?action=logout">
    Logout
</a>

</body>
</html>
