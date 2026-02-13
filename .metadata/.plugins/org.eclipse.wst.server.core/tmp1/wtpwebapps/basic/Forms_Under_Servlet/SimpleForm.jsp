<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Form</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/Controller" method="post">

Full Name :
<input type="text" name="fullname" /><br/><br/>

Gender :
<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female" checked>Female
<br/><br/>

<!--  Language learned :
<input type="checkbox" name="language" value="Java" checked>Java
<input type="checkbox" name="language" value="Python">Python
<input type="checkbox" name="language" value="C++">C++
<br/><br/>
-->
Language learned:
<input type="text" name="language" /><br/><br/>
Skill :
<input type="text" name="skill" /><br/><br/>

<input type="submit" value="Submit">
</form>
</body>
</html>