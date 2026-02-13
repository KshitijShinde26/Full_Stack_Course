<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
It's home<br/>
<a href="<%=request.getContextPath() %>/ExerciseDemo?page=ExerciseLogin">Login</a><br/>
<a href="<%=request.getContextPath() %>/ExerciseDemo?page=ExerciseSignup">Sign Up</a><br/>
<a href="<%=request.getContextPath() %>/ExerciseDemo?page=ExerciseAbout">About</a><br/>
</body>
</html>